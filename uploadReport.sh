#!/bin/bash
FILE=""
for file in `find ./build/cucumber -type f  -name '*.json'`;
do
    FILE="$FILE -F \"files=@$file\""
done

COMMAND="curl -i -X POST -H \"Content-Type: multipart/form-data\" $FILE http://$MGP/api/test/uat"
echo "uplaod command"
echo $COMMAND
eval ${COMMAND}
