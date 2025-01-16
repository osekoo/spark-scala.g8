#!/bin/bash
spark-submit \
    --deploy-mode client \
    --master "spark://localhost:7077" \
    --executor-cores 1 \
    --executor-memory 2G \
    --num-executors 8 \
    --class "$class_name;format="Camel"$" \
    "target/scala-2.12/$name;format="normalize"$_2.12-$app_version$.jar" \
    1000000 \
