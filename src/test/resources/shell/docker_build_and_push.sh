#!/bin/bash
set -x #echo on

mvn clean package -Pnative -Dquarkus.native.container-build=true

docker build -f src/main/docker/Dockerfile.native -t triphon/otaibe-nginx-with-eureka-demo-microservice .

docker push triphon/otaibe-nginx-with-eureka-demo-microservice
