#!/bin/bash

is_live_the_process () {
NUM_PROC=`ps -ef|grep "$1"|grep -v "grep" |wc -l`

if [ $NUM_PROC == "1" ]; then
   echo "OK     | $2 |"
else
   echo "ERROR  | $2 | $3"
fi
}

echo "------------------------------------"
echo "ESTADO | PROCESO          | MENSAJE"
echo "------------------------------------"
is_live_the_process "\-Des.uv.aLiteral.${env}" "${project.artifactId}          " "Revisa es.uv.aLiteral.log.file"
echo "------------------------------------"
