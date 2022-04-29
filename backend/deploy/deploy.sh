#!/bin/bash

export MYSQL_DATABASE_URL=""
export MYSQL_DATABASE_USERNAME=""
export MYSQL_DATABASE_PASSWORD=""

cd sidedish/backend

git fetch
remote=` git rev-parse origin/deploy_backend`
present=` git rev-parse HEAD`

if [[ $remote == $present ]]; then
		echo "[BE] No need to deploy"
		exit 0
else
		echo "[BE] Start deploy..."
fi

#kill old app
sidedish= jps | grep sidedish | cut -d' ' -f1
echo "[BE] Try to kill sidedish"
kill -9 $sidedish

rm -rf build
git merge origin/deploy_backend
./gradlew bootJar

nohup java -jar -Dspring.profiles.active=prod build/libs/sidedish-0.0.1-SNAPSHOT.jar &
