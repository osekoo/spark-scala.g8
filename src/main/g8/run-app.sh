#!/bin/bash
echo Stopping Spark cluster...
bash ./spark-stop.sh

echo Starting Spark cluster...
bash ./spark-start.sh

echo "Waiting for Spark master to be ready..."
sleep 4

echo Building Spark job...
sbt package

echo "Submitting Spark job..."
docker exec -it spark-submit dos2unix /app/spark-submit.sh
docker exec -it spark-submit chmod +x /app/spark-submit.sh
docker exec -it spark-submit /app/spark-submit.sh
