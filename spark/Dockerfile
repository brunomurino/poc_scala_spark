

FROM openjdk:8-alpine

RUN apk --update add curl bash

RUN curl https://www-eu.apache.org/dist/spark/spark-2.4.4/spark-2.4.4-bin-hadoop2.7.tgz | tar -xzf - \
    && mv /spark-2.4.4-bin-hadoop2.7 /spark

COPY start_master.sh /start_master.sh
COPY start_worker.sh /start_worker.sh

ENTRYPOINT ["tail", "-f", "/dev/null"]
# ENTRYPOINT ["/bin/bash"]