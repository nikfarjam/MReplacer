#!/bin/sh
cmd_compile='c'
if [ ! -z $1 ]
then
    if [ $1 == $cmd_compile ]
    then
        mvn -DskipTests -q clean install
    fi
fi
java -jar target/dist/MReplacer.jar &
