#!/usr/bin/env bash


#EA_JVM_OPTS=-Xms4g -Xmx4g -XX:+UseConcMarkSweepGC
#            -XX:+CMSParallelRemarkEnabled -XX:MaxMetaspaceSize=128m
#            -XX:+UseCMSInitiatingOccupancyOnly
#            -XX:CMSInitiatingOccupancyFraction=70
#            -XX:+ScavengeBeforeFullGC
#            -XX:+CMSScavengeBeforeRemar

# Start the service
java -Djava.security.egd=file:/dev/./urandom \
                     -Dfile.encoding=UTF8 \
                     $EA_JVM_OPTS \
                     -jar *.jar
