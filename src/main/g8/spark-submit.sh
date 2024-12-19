#!/bin/bash
spark-submit \
    --deploy-mode client \
    --master "$SPARK_MASTER_URL" \
    --executor-cores 4 \
    --executor-memory 2G \
    --num-executors 1 \
    --class "$class_name;format="Camel"$" \
    "target/scala-2.12/$name;format="normalize"$_2.12-$app_version$.jar" \
