set -x
set -x
./bin/gfsh -e 'start locator --name="locator1"'
./bin/gfsh -e 'start server --name="server1" --J=-Dgemfire.locators=localhost[10334]'
./bin/gfsh -e "connect" -e "create region --name=test --type=PARTITION"
./bin/gfsh -e "connect" -e "rput --key=A --value=B --region=test"
./bin/gfsh -e "connect" -e "stop server --name=server1" -e "stop locator --name=locator1"
