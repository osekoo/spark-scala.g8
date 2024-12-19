@echo off
docker-compose up -d
docker exec -it spark-master /app/spark-submit.sh
