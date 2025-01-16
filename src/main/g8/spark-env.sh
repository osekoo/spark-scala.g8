#!/bin/bash
docker rm -f spark-env

docker run -it --rm --name spark-env -v "\$(pwd)":/workspace -h localhost -p 4040:4040 -p 8080:8080 -p 8081:8081 -e SPARK_MODE=env ghcr.io/osekoo/spark:3.5
