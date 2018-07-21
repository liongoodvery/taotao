#!/usr/bin/env bash
java=/home/share/software/jdk1.8.0_131/bin/java
projectRoot=/home/lion/IdeaProjects/taotao
run_manager_service(){
    echo "run_manager_service"
}
run_manager_web(){
    echo "run_manager_web"
 }

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
 }

 main(){
    if [[ "$1" == "" ||  "$1" == "help" ]]; then
         help
    elif [[ "$1" == "installAll" ]]; then
         installAll
    fi

}


help(){
    echo "start.sh help"
    echo "start.sh installAll"
    exit 1
}

main  "$@"