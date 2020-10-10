
ARG JAVA_VERSION=11
ARG SBT_VERSION=1.4.0
ARG SCALA_VERSION=2.13.3

FROM openjdk:${JAVA_VERSION}

COPY ./spark_cluster/start_master.sh        /start_master.sh
COPY ./spark_cluster/start_worker.sh        /start_worker.sh

WORKDIR /root/
RUN apt-get -y update && \
    apt-get -y install zip unzip make && \
    curl -s "https://get.sdkman.io" | bash && \
    /bin/bash -c "source .sdkman/bin/sdkman-init.sh && sdk install sbt ${SBT_VERSION} && sdk install scala ${SCALA_VERSION}"

# Install Spark
RUN curl https://downloads.apache.org/spark/spark-3.0.1/spark-3.0.1-bin-hadoop2.7.tgz | tar -xzf - && \
    mv /root/spark-3.0.1-bin-hadoop2.7 /spark

ENTRYPOINT ["tail", "-f", "/dev/null"]