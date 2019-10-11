

FROM openjdk:8-jdk-alpine

RUN apk update && \
    apk add wget ca-certificates bash curl && \
    wget --no-verbose "https://piccolo.link/sbt-1.3.2.tgz" && \
    tar xzf "sbt-1.3.2.tgz"

ENV PATH="/sbt/bin:${PATH}"

RUN sbt sbtVersion

