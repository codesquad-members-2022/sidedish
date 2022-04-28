#!/bin/bash

export MYSQL_DATABASE_URL=""
export MYSQL_DATABASE_USERNAME=""
export MYSQL_DATABASE_PASSWORD=""

cd back_sidedish/backend

git fetch
remote=` git rev-parse origin/backend`
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
git merge origin/backend
./gradlew bootJar

nohup java -jar build/libs/sidedish-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod &
