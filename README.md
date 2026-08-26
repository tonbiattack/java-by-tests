# Java by Tests

**Java by Tests** は、Javaの仕様や標準APIの挙動を、長い説明ではなく **JUnit 5 テスト**で確認するための静的学習サイトです。各教材ページは常に **Source** と **Test** を対にして表示します。サイトに載るコードは `examples/` にある実ファイルをAstroのビルド時に読むため、表示とJUnitの実行コードを二重管理しません。

> 「Javaのこの挙動はどうだったか」を、テストメソッド名と assertion から数秒で確認する Executable Documentation を目指します。

## 使用技術

| 区分 | 技術 | 役割 |
| --- | --- | --- |
| サイト | Astro / TypeScript / Shiki | 静的生成、型検査、Javaコードのハイライト |
| 実行例 | Java 21 / JUnit 5 / Maven | 掲載コードのコンパイルと挙動の検証 |
| 自動化 | GitHub Actions / GitHub Pages | PR・mainでの検証と静的サイトの公開 |

## ローカル起動

Node.js 22系とJava 21、Mavenを用意したうえで、以下を実行します。

```bash
pnpm install
pnpm dev
```

本番形式で確認する場合は、`pnpm build && pnpm preview` を実行してください。

## Javaテストの実行

掲載するコードと同じ `examples/` のテストを実行します。

```bash
mvn -B -f examples/pom.xml test
```

## GitHub Pagesへのデプロイ

`main` へのpush時、`deploy-pages.yml` は Maven のJUnitテスト、Astroビルド、`dist/` のGitHub Pages配置を順に実行します。最初の公開前に、GitHubリポジトリの **Settings → Pages** で公開元を **GitHub Actions** に設定してください。別の所有者またはリポジトリ名を使う場合は、`astro.config.mjs` と `src/data/lessons.ts` の `SOURCE_REPOSITORY` を更新します。

## ディレクトリ構成

```text
.
├── src/                    # Astroのページ、レイアウト、コンポーネント、教材メタデータ
├── examples/
│   ├── pom.xml
│   └── src/
│       ├── main/java/      # Sourceとして表示するJavaコード
│       └── test/java/      # Testとして表示するJUnitコード
└── .github/workflows/      # CIとPagesデプロイ
```

## 新しいJavaテーマを追加する方法

最初に `examples/src/main/java/` に対象コード、`examples/src/test/java/` に対応するJUnitテストを追加します。次に `src/data/lessons.ts` の `lessons` 配列へ、URLスラッグ、カテゴリ、短い説明、Javaバージョン、代表テスト名、ふたつのファイルパス、確認事項を1件追加します。ページ側はビルド時に教材を収集するため、新しいルートを個別に実装する必要はありません。

追加後は必ず `mvn -B -f examples/pom.xml test` と `pnpm build` を実行してください。これにより、掲載するSource/Testと実行したコードが一致した状態を保てます。検索ダイアログは、教材タイトルだけでなく、代表テスト名、カテゴリ、Javaバージョンも `lessons` のメタデータから静的に検索します。

## 参照

[Astro](https://docs.astro.build/) と [GitHub PagesのGitHub Actionsによる公開](https://docs.github.com/pages/getting-started-with-github-pages/using-custom-workflows-with-github-pages) の公式ドキュメントを、構成・公開方法の参照先として利用しています。
