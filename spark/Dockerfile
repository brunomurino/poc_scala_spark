

FROM openjdk:8-alpine

ENV JAVA_HOME="/usr/lib/jvm/java-1.8-openjdk"

# Install Python3
RUN apk --update add curl bash python3 \
    python3-dev \
    py-pip \
    build-base

# Install Python Dependencies
WORKDIR /root/
COPY ./python_requirements.txt /root/python_requirements.txt
RUN pip3 install --upgrade pip && \
    pip3 install -r python_requirements.txt

# Install Apache Spark
WORKDIR /
RUN curl https://www-eu.apache.org/dist/spark/spark-2.4.4/spark-2.4.4-bin-hadoop2.7.tgz | tar -xzf - \
    && mv /spark-2.4.4-bin-hadoop2.7 /spark

COPY start_master.sh /start_master.sh
COPY start_worker.sh /start_worker.sh
COPY spark-defaults.conf  /spark/conf/spark-defaults.conf
COPY mariadb-java-client-2.5.4.jar /usr/share/java/mariadb-java-client-2.5.4.jar

WORKDIR /root/

ENTRYPOINT ["tail", "-f", "/dev/null"]
