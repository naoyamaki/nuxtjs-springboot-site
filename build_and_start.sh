#!/bin/sh

cd `dirname $0`
shpwd=`pwd`

# フロント資材作成
cd $shpwd/nuxt-src
npm run generate

# バックエンド資材作成
cd $shpwd/spring-boot-src
sh gradlew build

cd $shpwd
docker compose up --build -d