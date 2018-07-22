#!/usr/bin/env bash
projectRoot=/home/lion/IdeaProjects/taotao

 installAt(){
    cd $1
    if [[ ! -f "pom.xml" ]]; then
            echo "pom.xml does not exist at $1"
            exit 1
    fi
    echo "install $1"
    mvn install
 }

 installAll(){
        installAt $projectRoot/taotao-parent
        installAt $projectRoot/taotao-manager/taotao-manager-pojo
        installAt $projectRoot/taotao-common
        installAt $projectRoot/taotao-manager/taotao-manager-interface
        installAt $projectRoot/taotao-manager/taotao-manager-dao
        installAt $projectRoot/taotao-content/taotao-content-interface
 }

 installAll
