#!/usr/bin/env bash
projectRoot=/home/lion/IdeaProjects/taotao

function startService {
    servicePath=$1
    [ -d "$servicePath" ] ||  exit -1
    cd "$servicePath"
    mvn clean org.apache.tomcat.maven:tomcat7-maven-plugin:2.2:run -f pom.xml
}

startService taotao-manager
