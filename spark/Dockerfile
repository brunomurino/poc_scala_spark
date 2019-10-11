

FROM openjdk:8-alpine

ENV spark=https://www-eu.apache.org/dist/spark/spark-2.4.4/spark-2.4.4-bin-hadoop2.7.tgz

RUN apk --update add curl tar bash file

RUN curl ${spark} | tar -xzf - && \
    mv /$(echo ${spark} | sed -r "s/.+\/(.+)\..+/\1/") /spark

ENTRYPOINT ["tail", "-f", "/dev/null"]