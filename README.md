# 概要

よくあるweb3層構成

```txt
.
├── doc -> ドキュメント置き場
├── build_and_start.sh -> ローカル環境構築shell
├── docker-compose.yml
├── web -> Webサーバ資材
|   ├── Dockerfile
|   ├── nginx -> nginx設定ファイル
|   │   ├── conf.d
|   │   │   └── default.conf
|   │   ├── mime.types
|   │   └── nginx.conf
|   └── nuxtjs-src -> Nuxt.js資材
├── app -> applicationサーバ資材
│   ├── Dockerfile
│   └── spring-boot-src -> application資材
│       ├── build.gradle
│       ├── gradle
│       │   └── wrapper
│       │       ├── gradle-wrapper.jar
│       │       └── gradle-wrapper.properties
│       ├── gradlew
│       ├── settings.gradle
│       └── src
└── db -> ローカル用DB資材
    ├── Dockerfile
    ├── mysql -> MySQL設定ファイル
    │   ├── conf.d
    │   │   ├── docker.cnf
    │   │   └── mysql.cnf
    │   └── my.cnf
    └── mysql_init -> ローカルDBのDumpファイル
        └── 1_dump.sql
```

# 単体環境構築手順

同ディレクトリの`build_and_start.sh`を実行することで、以下が実行される

1. フロントエンド資材のビルド
2. バックエンド資材のビルド
3. web、app、dbコンテナを起動

# 構成図案

![構成図](./doc/構成図a.svg)

メリット : 
  - web層、app層毎のスケーリングローリングアップデートができる
  - バックエンドのみ他サービスに部分移行がしやすい

デメリット : 
  - ALB 1台分の料金増


![構成図](./doc/構成図b.svg)

メリット : 
  - ALB 1台分の料金節約
  - セッション回りが管理しやすい？（ログとかも見やすい？）

デメリット : 
  - コンテナ更新時app-web一組でローリングアップデートすることになる
  - メモリ、CPUなどのチューニング時web-app一組でのバランスを見てやる必要がある

![構成図](./doc/構成図c.svg)

メリット : 
  - 最も料金を節約できる

デメリット : 
  - ルーティングやレスポンスなどの設定がALBでできることに限られる

# 絵文字コミット分類

|内容|コード|絵文字|
|:-:|:-:|:-:|
|新機能|`:sparkles:`|✨|
|バグ修正|`:bug:`|🐛|
|リファクタリング|`:recycle:`|♻️|
|ドキュメント|`:books:`|📚|
