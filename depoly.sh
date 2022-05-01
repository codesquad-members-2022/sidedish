#!/bin/bash

echo "====== [Depoly] start ======"
echo "[Depoly] init system env"
source /etc/profile > /dev/null 2>&1

git fetch
remote=` git rev-parse origin/team-03`
present=` git rev-parse team-03`

if [[ $remote == $present ]]; then
	echo "[Depoly] 현재 최신 버전입니다. 스크립트를 종료합니다."
	exit 0
fi

echo "[Depoly] 리포지토리 최신화"
git merge origin/team-03

echo "====== [FE] 새로운 View react 빌드 ======"
cd ./FE
npm install
npm run build
cd ../
echo "====== [FE] 새로운 View react 빌드완료 ======"


echo "====== [BE] 이전 서버 종료 ======"
cd ./BE
sidedish=` jps | grep com | cut -d' ' -f1`
kill -9 $sidedish

echo "====== [BE] 새로운 서버 실행 ======"
bash ./gradlew clean bootjar
nohup java -jar build/libs/com-0.0.1-SNAPSHOT.jar &

cd ../
echo "[BE] 완료"

echo "====== [Depoly] Done ======"