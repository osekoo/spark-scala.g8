@echo off

echo Stopping Spark cluster...
call spark-stop >nul 2>&1

echo Starting Spark cluster...
call spark-start >nul 2>&1

timeout /T 4 /NOBREAK

echo Building Spark job...
call sbt package >nul 2>&1

echo Submitting Spark job...
docker exec -it spark-submit dos2unix /app/spark-submit.sh
docker exec -it spark-submit chmod +x /app/spark-submit.sh
docker exec -it spark-submit /app/spark-submit.sh
