@echo off
echo Stopping Spark cluster...
docker rm -f spark-master
docker rm -f spark-worker

echo Starting Spark cluster...
docker-compose up -d

echo Waiting for Spark master to be ready...
timeout 10

echo Submitting Spark job...
docker exec -it spark-master ./spark-submit.sh
echo Spark job submitted.
