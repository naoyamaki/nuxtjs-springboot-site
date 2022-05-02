# 概要

```txt
.
├── doc/ -> ドキュメント置き場
├── build_and_start.sh -> ローカル環境構築shell
├── docker-compose.yml
├── lb/ -> lb資材
|   ├── Dockerfile
|   └── nginx/ -> Nginx設定ファイル
├── contents/ -> contents資材
|   ├── Dockerfile
|   └── nginx/ -> Nginx設定ファイル
├── nuxt-src/ -> フロントエンド資材
├── app/ -> バックエンドサーバ資材
│   ├── Dockerfile
│   └ conf/ -> Tomcat設定ファイル
├── spring-boot-src/ -> バックエンド資材
├── db/ -> ローカル用DB資材
│   ├── Dockerfile
│   ├── mysql/ -> MySQL設定ファイル
│   └── mysql_init/ -> ローカルDBのDumpファイル
└─ terraform/ -> AWS資材定義
```

# 単体環境構築手順

同ディレクトリの`build_and_start.sh`を実行することで、以下が実行される

1. フロントエンド資材のビルド
2. バックエンド資材のビルド
3. 各コンテナを起動

# 構成図案

![構成図](./doc/構成図c.svg)

ローカル環境では  
ALBをlbコンテナが  
S3をcontentsコンテナが  
代替している。

# 絵文字コミット分類

|内容|コード|絵文字|
|:-:|:-:|:-:|
|新機能|`:sparkles:`|✨|
|バグ修正|`:bug:`|🐛|
|リファクタリング|`:recycle:`|♻️|
|ドキュメント|`:books:`|📚|
|修正途中|`:construction:`|🚧|
