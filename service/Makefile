.PHONY: build run

build:
	sbt package

run:
	@/spark/bin/spark-submit target/scala-2.12/simple-project_2.12-1.0.jar 2> t.log

build-run: build run