#FROM maven:3.3.9-jdk-8
#FROM harbor.emotibot.com/buildbase/emotibot-maven-aliyun:3-jdk-8
FROM anapsix/alpine-java
MAINTAINER yangbai
# Set TimeZone
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone && mkdir -p /usr/src/app

WORKDIR /usr/src/app

COPY run ./run
COPY ./target/adapter-0.0.1-SNAPSHOT.jar /usr/src/app/adapter.jar
# set bundle version
ENV BUNDLE_VER=1.29-SNAPSHOT

#HEALTHCHECK
HEALTHCHECK  CMD curl -XGET -f http://localhost:9066/healthCheck || exit 1

# defaults
ENTRYPOINT ["run/entrypoint.sh"]
