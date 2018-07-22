#!/usr/bin/env bash
PROJECT_ROOT=/home/lion/IdeaProjects/taotao
artifactId=taotao-content-service

 java -cp /home/lion/bin/myutils.jar \
    -DbaseDir=$PROJECT_ROOT/taotao-content/$artifactId   \
    -DgroupId=com.taotao       \
    -DartifactId=$artifactId        \
    -Dversion=0.0.1-SNAPSHOT          \
    -DparentGroupId=com.taotao  \
    -DparentArtifactId=taotao-content \
    -DparentVersion=0.0.1-SNAPSHOT       \
    -DbasePackage=com.taotao.content.service            \
    -Dmodel=        \
    -Dpackaging=jar           \
    org.lion.utils.tools.maven.CreateMavenProject