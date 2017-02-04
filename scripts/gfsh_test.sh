#!/bin/bash
set -x
set -e
./bin/gfsh -e 'start locator --name="locator1"'
./bin/gfsh -e 'start server --name="server1" --J=-Dgemfire.locators=localhost[10334]'
./bin/gfsh -e "connect" -e "create region --name=test --type=PARTITION"
./bin/gfsh -e "connect" -e "put --key=A --value=MyValue --region=test"
VALUE=`./bin/gfsh -e "connect" -e "get --key=A --region=test"`
./bin/gfsh -e "connect" -e "stop server --name=server1" -e "stop locator --name=locator1"
if [[ $VALUE != *MyValue* ]]; then
  echo "------------------"
  echo "Unexpected result from gfsh get $VALUE\n"
  echo "------------------"
  exit 1
fi
