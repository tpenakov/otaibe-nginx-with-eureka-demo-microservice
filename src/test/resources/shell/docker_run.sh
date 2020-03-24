#!/bin/bash
echo "=================================================="
echo "Usage (from project dir):"
echo "bash src/test/resources/shell/docker_run.sh <QUARKUS_HTTP_PORTS> <EUREKA_HOST_PORT> <HOST_NAME_OR_IP>"
echo
echo "Example:"
echo 'bash src/test/resources/shell/docker_run.sh "24460 24461 24462" 172.94.14.97:24455 172.94.14.97'
echo "=================================================="

set -x #echo on


for QUARKUS_HTTP_PORT in $1
do
docker run -i -d --rm -p ${QUARKUS_HTTP_PORT}:${QUARKUS_HTTP_PORT} \
   --name "otaibe-nginx-with-eureka-demo-microservice-${QUARKUS_HTTP_PORT}"\
   --env "QUARKUS_HTTP_PORT=${QUARKUS_HTTP_PORT}" \
   --env "EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://$2/eureka/" \
   --env "EUREKA_INSTANCE_HOSTNAME=$3" \
   triphon/otaibe-nginx-with-eureka-demo-microservice
done
