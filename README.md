# Spring_Enjoyable_Kotlin
## 概要
### 内容 
下記ブランチで旅行で遊べる施設や食事・宿の記述をするサイトにチャレンジ中。
途中でKotlinでも記載してみたくなったので、途中でフォークした。

InteliJの機能でKotlinに変換して別途開発を継続する

#### 元ブランチ
[https://github.com/railgun-0402/Spring_Enjoyable_Site](https://github.com/railgun-0402/Spring-Enjoyble-SSG)


## 使用技術(作成中なので予定も含む)
### バックエンド
<img src="https://camo.qiitausercontent.com/00f9cc65cdea735164a23edab49f10a1bf9cb56a/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f2d4a6176612d3030373339362e7376673f6c6f676f3d6a617661267374796c653d666f722d7468652d6261646765"> <img src="https://camo.qiitausercontent.com/eb8e0216005c7badaaa4bf7eb2be4d177990d747/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f2d507974686f6e2d4632433633432e7376673f6c6f676f3d707974686f6e267374796c653d666f722d7468652d6261646765">

### フロントエンド
<img src="https://img.shields.io/badge/-JavaScript-276DC3.svg?logo=javascript&style=flat">

### その他インフラ
<img src="https://camo.qiitausercontent.com/01ce7f13e49ffb3193222a9a53f69cb78f60561f/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f2d506f737467726573716c2d3333363739312e7376673f6c6f676f3d706f737467726573716c267374796c653d666f722d7468652d6261646765266c6f676f436f6c6f723d7768697465"> <img src="https://camo.qiitausercontent.com/11e97646e81c116c851923e0f45e6a6a8037f64c/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f2d446f636b65722d3134383843362e7376673f6c6f676f3d646f636b6572267374796c653d666f722d7468652d6261646765"> <img src="https://camo.qiitausercontent.com/38f0d65f0b30d5c48c51df90da9235549605af35/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f2d676974687562616374696f6e732d4646464646462e7376673f6c6f676f3d6769746875622d616374696f6e73267374796c653d666f722d7468652d6261646765">
<img src="https://camo.qiitausercontent.com/ec57734305b17aa755e88894461c2239ca05e3ea/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f2d7465727261666f726d2d3230323332413f7374796c653d666f722d7468652d6261646765266c6f676f3d7465727261666f726d266c6f676f436f6c6f723d383434454241">

## テスト
- spock/Junit5
  - テスト観点を身につける
  - 正直どちらUnitTestの方法はどちらでもいい
  - ただし、確認漏れを防ぐ「ケースを作成」を心掛ける

## フロントエンドブランチ
https://github.com/railgun-0402/React_Enjoyble

## feature
- 管理画面
  - 施設の登録・更新・削除
    - 施設の量は多いのでパンくずリストでも作る
  - ユーザの登録・更新・削除
    - ブラックリストやプランで使用できる機能を制限するのも面白いかも？
  - ゴミみたいなお問い合わせをPythonで読み分けて、優先度を下げるなどしてみたい
    - 優先度低いのはメール or Slackのみ等
- ユーザ
  - Top画面
  - 施設の詳細画面
  - 施設のお気に入り
  - 施設予約履歴
  - 会員ランク
  - アンケート
    - 施設の評価みたいなもの
  - おみくじ
    - サイトによくある娯楽をパクって実装してみる
  - お問い合わせ
    - メール送信
    - 管理者へメールが届くこと
    - formで良さそう
