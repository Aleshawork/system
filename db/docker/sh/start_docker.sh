#!/bin/bash
chmod +x init-db.sh

cd ..
rm -rf changelog
docker-compose rm --stop --force
mkdir changelog
cp -vR ../src/main/resources/changelog/model changelog/model

docker-compose up -d

docker-compose logs --tail=25 -f liquibase