#!/usr/bin/env bash
REPO=harbor.emotibot.com/client/youqian
CONTAINER=emotibot_adapter
GIT_HEAD="$(git rev-parse --short=8 HEAD)"
GIT_DATE=$(git log HEAD -n1 --pretty='format:%cd' --date=format:'%Y%m%d-%H%M')
TAG="$GIT_HEAD-$GIT_DATE"

DOCKER_IMAGE=$REPO/$CONTAINER:$TAG


DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

BUILDROOT=$DIR/../

mvn="cd ../ && mvn package -DskipTests"
echo $mvn
eval $mvn

cmd="docker build \
  -t $DOCKER_IMAGE \
  -f $DIR/Dockerfile \
  $BUILDROOT"
echo $cmd
eval $cmd
