# このリポジトリの Astro を読むためのガイド

このサイトの Astro は、Java の教材データから **静的 HTML を生成する役** です。ブラウザが Java を実行したり、ページを表示するたびにサーバーが Java ファイルを読んだりはしません。`pnpm build` の時点で、各教材ページの HTML・CSS・必要な JavaScript が `dist/` に書き出され、GitHub Pages はその完成物を配信します。

## まず全体像

```text
開発者が pnpm build を実行する
          |
          v
Astro / Node.js（ビルド時）
  |- src/data/lessons.ts が examples/ の Java ファイルを読む
  |- src/pages/ が URL ごとの HTML を決める
  |- src/components/ と src/layouts/ が HTML を組み立てる
  `- Shiki が Java コードを色付けする
          |
          v
dist/（完成した静的ファイル）
          |
          v
GitHub Pages（ファイルを配信するだけ）
          |
          v
ブラウザ
  |- HTML と CSS を表示する
  `- <script> に書かれた小さな機能だけを実行する
     （検索、モバイルメニュー、コードコピー、左右キー移動）
```

ポイントは、`src/` の TypeScript/Astro コードの大半はブラウザへそのまま送られないことです。ビルド中に HTML へ変換されます。一方、`.astro` 内の `<script>` はブラウザで必要な操作を書く場所なので、ビルド後のページに JavaScript として残ります。

## `Astro` と `client` の使い分け

Astro では「どこで動くか」を三つに分けて考えると分かりやすくなります。

| 層 | このリポジトリの例 | いつ動くか | できること |
|---|---|---|---|
| ビルド時の Node.js | `src/data/lessons.ts` の `readFileSync`、`CodePanel.astro` の Shiki | `pnpm dev` / `pnpm build` | リポジトリ上の Java ファイルを読む、HTML文字列を作る。ブラウザ API は使えない。 |
| Astro のレンダリング | `src/pages/`、`src/layouts/`、`src/components/` | 各ページの HTML を作る時 | `Astro.props`、`Astro.url`、`import.meta.env.BASE_URL` を使い、コンポーネントを HTML に展開する。 |
| ブラウザ（client） | `.astro` の `<script>`、Cloudflare Analytics | 利用者がページを開いた後 | `document`、`window`、`navigator.clipboard` を使い、画面操作に反応する。 |

### このリポジトリに `client:*` はない

Astro の `client:load`、`client:visible` などは、React/Vue/Svelte のような **UI フレームワークのコンポーネントをブラウザで起動（hydrate）するための指定** です。例えば React の検索ボックスを読み込み後に動かすなら、概念的には次のように書きます。

```astro
---
import SearchBox from "../components/SearchBox.tsx";
---

<SearchBox client:load />
```

このプロジェクトには React/Vue/Svelte コンポーネントも `client:*` もありません。そのため、ここで「client」という言葉が出た場合は、主に **HTML に残る通常の `<script>` がブラウザで動く** という意味です。小さな操作だけなら、フレームワークを追加せずに現在の方式で十分です。

| 画面の機能 | 実装ファイル | client 側で動く処理 |
|---|---|---|
| 検索ダイアログ、モバイル目次 | `src/layouts/BaseLayout.astro` | DOM を検索し、`hidden`、`open`、リンク先を書き換える。 |
| コードのコピー | `src/components/CodePanel.astro` | クリックを受けて `navigator.clipboard.writeText()` を呼ぶ。 |
| 前後教材の左右キー移動 | `src/pages/java/[...slug].astro` | `keydown` を受けて次/前ページへ移動する。 |
| アクセス解析 | `src/layouts/BaseLayout.astro` | Cloudflare の外部スクリプトを読み込む。 |

### 判断の目安

- Java ファイルを読んでページに埋め込みたい、URL ごとに HTML を作りたい → Astro の frontmatter（`---` の中）に書く。
- クリック、入力、キーボード操作など、ページを開いた後に反応したい → `.astro` の `<script>` に書く。
- 状態が複雑な UI をフレームワークで作りたい → React/Vue/Svelte を追加し、そのコンポーネントだけに `client:*` を付ける。静的な本文やレイアウトまで client 化しない。

`document`、`window`、`navigator` はブラウザにしか存在しません。これらを frontmatter に書くとビルド中に失敗するため、現在のように `<script>` 内へ置きます。反対に `readFileSync` は Node.js 用なので、ブラウザ用 `<script>` に置いてはいけません。

## フォルダと責務

```text
.
├── src/                         # サイトを組み立てる Astro/TypeScript
│   ├── pages/                   # URL とページ本体（ファイルベースルーティング）
│   │   ├── index.astro          # / のホーム画面
│   │   └── java/[...slug].astro # /java/** の全教材ページを生成
│   ├── layouts/                 # 複数ページで共有する骨組み
│   │   └── BaseLayout.astro     # head、サイドバー、検索ダイアログ、共通script
│   ├── components/              # 再利用する表示部品
│   │   ├── CodePanel.astro      # 片方のコード欄とコピー操作
│   │   ├── CodeComparison.astro # Source/Test の二列表示
│   │   ├── Sidebar.astro        # ナビゲーション
│   │   └── ...                  # バッジ、GitHubリンク、前後移動
│   ├── data/lessons.ts          # 教材メタデータとJavaファイルを読む唯一の入口
│   ├── lib/links.ts             # GitHub Pages のサブパスを考慮した内部リンク
│   └── styles/global.css        # サイト全体の色・フォント・基本スタイル
├── examples/                    # 教材の正本。Maven/JUnit が実行する Java コード
│   ├── pom.xml
│   └── src/{main,test}/java/    # 表示する Source と検証する Test
├── public/                      # 変換せず公開する静的ファイル（favicon など）
├── scripts/                     # ビルド後の補助検証
├── docs/                        # 実装・運用の説明資料
├── .github/workflows/           # CI と GitHub Pages デプロイ
├── astro.config.mjs             # Astro の公開URL、base、静的出力の設定
└── package.json                 # pnpm コマンドと依存関係
```

### `pages` が URL になる仕組み

Astro は `src/pages/` 配下のファイル名から URL を決めます。

| ファイル | 生成される URL | このリポジトリでの役割 |
|---|---|---|
| `src/pages/index.astro` | `/` | トップページ |
| `src/pages/java/[...slug].astro` | `/java/string/equals/` など | 41テーマを同じテンプレートで表示 |

`[...slug].astro` の `...` は、`string/equals` のようにスラッシュを含む可変長の URL 部分を受け取る記法です。ここで `getStaticPaths()` が `lessons` の各 `slug` を返すことで、ビルド時にテーマごとの HTML が作られます。新しい教材を `lessons.ts` に登録すると、このルートからページも増えます。

## データから画面までの流れ

```text
examples/src/main/java/.../X.java    examples/src/test/java/.../XTest.java
                  \                         /
                   \                       /
                    v                     v
             src/data/lessons.ts
               |- ファイルパスと説明を対応付ける
               `- sourceCode() / testCode() で内容を読む
                         |
                         v
                src/pages/*.astro
                  |- 一覧を表示する
                  `- getStaticPaths() で教材ごとのページを作る
                         |
                         v
        BaseLayout + CodeComparison + CodePanel
                         |
                         v
                   dist/**/*.html
```

`examples/` が教材コードの正本で、`lessons.ts` は「どのファイルを、どの URL・タイトル・説明で見せるか」を結び付ける目録です。表示用に Java コードをもう一度コピーしていないため、`pnpm test:java` が検証するコードとサイトに表示するコードが一致します。

## GitHub Pages 用の URL に注意する理由

ローカル開発時はサイトの先頭が `/` ですが、GitHub Pages では `https://tonbiattack.github.io/java-by-tests/` のようにリポジトリ名のサブパスで公開されます。

`astro.config.mjs` は GitHub Actions 上だけ `base: "/java-by-tests"` にしています。`src/lib/links.ts` の `withBase()` と `BaseLayout.astro` の `asset()` は、この違いを吸収して内部リンクや favicon を正しい URL にします。内部リンクを新規に追加する時は、`href="/java/..."` と直書きせず、既存コードと同様に `withBase()` または `asset()` を使ってください。

## 変更した時の確認方法

```bash
# 開発サーバーで見た目とブラウザ操作を確認する
pnpm dev

# Astro/TypeScript の整合性を確認する
pnpm typecheck

# Java テスト、静的ビルド、Pages用リンクをまとめて確認する
pnpm verify
```

`pnpm verify` が成功すれば、Astro の型検査、Java/JUnit テスト、GitHub Pages のサブパスでのビルド、出力済みページの内部リンク検査まで通っています。ただし、コピー操作やモバイルメニューのような実際のブラウザ操作は `pnpm dev` で一度確認すると安心です。

### Windows PowerShell で Pages 向けに確認する場合

現在の `verify` スクリプト内の `GITHUB_ACTIONS=true pnpm build` は、GitHub Actions（Linux）の書式です。PowerShell では環境変数の設定方法が異なるため、次を順に実行してください。

```powershell
pnpm typecheck
pnpm test:java
$env:GITHUB_ACTIONS = "true"
pnpm build
Remove-Item Env:GITHUB_ACTIONS
pnpm verify:links
```

これは CI の `pnpm verify` と同じ品質ゲートです。ビルド前に `GITHUB_ACTIONS` を設定することで、GitHub Pages 用の `/java-by-tests/` サブパスを使ったリンクを確認できます。
