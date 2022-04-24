#!/bin/bash

cd front_sidedish
echo "[FE] Start script"

git fetch
remote=` git rev-parse origin/frontend`
present=` git rev-parse HEAD`

if [[ $remote == $present ]]; then
		echo "[FE] No need to deploy"
		exit 0
else
		echo "[FE] Start deploy..."
fi

echo "[FE] git reset & pull"
git reset --hard a002511
git pull origin frontend

echo "[FE] project rebuild"
cd frontend/sidedish

npm install

npm run build
