# Java by Tests

**Java by Tests** は、Javaの仕様や標準APIの挙動を、読み物ではなく実行可能な **JUnit 5 テスト**から学ぶための静的ドキュメントサイトです。各テーマでSourceとTestを並べ、コードと期待する振る舞いを短時間で確かめられます。

## Demo

👉 [Live Demo](https://tonbiattack.github.io/java-by-tests/)

## Features

- Java 21とJUnit 5で検証した**10件の短い学習テーマ**を掲載します。
- SourceとTestを対で表示し、テスト名・assertionからコードの契約を読み取れます。
- `equals`、`isBlank`、`List`、`Map`、`Optional`、`Stream`、例外、genericsを横断できます。
- テーマ、テスト名、カテゴリ、Javaバージョンを対象に静的検索できます。
- コードはGoogle Java Formatで整形され、デスクトップとモバイルで読みやすく折り返します。
- 掲載コードをMavenで実行し、GitHub Actionsでテスト・静的ビルド・リンクを検査します。

## Tech Stack

| 領域 | 主な技術 | 用途 |
| --- | --- | --- |
| Static site | Astro / TypeScript / Shiki | 静的生成、型検査、Java構文ハイライト |
| Executable examples | Java 21 / JUnit 5 / Maven | 掲載コードのコンパイルと仕様の検証 |
| Code style | Google Java Format | Java教材とテストの統一書式 |
| Automation | GitHub Actions / GitHub Pages | 継続的検証と静的サイト公開 |

## Architecture

```text
Browser
  ↓
GitHub Pages
  ↑
Astro static build ──→ src/pages + src/components
  ↑                         ↑
src/data/lessons.ts ─────── examples/src/{main,test}/java
                                  ↑
                         Java 21 + JUnit 5 tests
```

バックエンドやデータベースは持ちません。Astroのビルド時に`examples/`の実Javaファイルを読み込み、画面に表示するSource/TestとMavenが検証するコードを同じファイルに保ちます。

## Getting Started

Node.js 20以降、pnpm、Java 21、Mavenを用意してください。

### Install

```bash
pnpm install
```

### Development

```bash
pnpm dev
```

### Test the Java examples

```bash
mvn -B -f examples/pom.xml test
```

### Build and verify links

```bash
GITHUB_ACTIONS=true pnpm build
pnpm verify:links
```

`GITHUB_ACTIONS=true`を付けると、GitHub Pages用の`/java-by-tests/`ベースパスでビルドできます。通常のローカル閲覧だけなら`pnpm dev`で十分です。

## Project Structure

```text
.
├── src/
│   ├── components/          # Source/Testパネル、ナビゲーション、検索UI
│   ├── data/lessons.ts      # テーマのメタデータとJavaファイルの対応
│   ├── layouts/             # 共通レイアウトと静的検索
│   └── pages/               # ホームと教材ページの動的ルート
├── examples/
│   ├── pom.xml              # Java 21 / JUnit 5のMaven設定
│   └── src/
│       ├── main/java/       # Sourceとして表示する実装
│       └── test/java/       # Testとして表示するJUnitテスト
├── scripts/verify-pages-links.mjs
└── .github/workflows/       # 検証とGitHub Pagesデプロイ
```

## Technical Notes

**表示用コードを複製しません。** `lessons.ts`はテーマと実ファイルの対応だけを管理し、Astroがビルド時に`examples/`のソースとテストを取得します。このため、画面のコード、ローカルのJUnit実行、GitHub Actionsでの検証を同じ変更として扱えます。

**静的サイトに限定しています。** API、認証、データベースを使わずGitHub Pagesで配信できるため、教材の閲覧にアカウントや外部サービスは必要ありません。内部リンクはGitHub Pagesのサブパスを前提に生成し、CIでリンク先の静的ページを検査します。

## Motivation

Java APIの細かな挙動は、長い説明よりも「どの入力に何を期待するか」を示すテストの方が速く確かめられる場面があります。Java by Testsは、その確認手順を短いSource/Testのペアとして残すために作成しました。

## Roadmap

- [ ] Javaの例外メッセージと独自例外に関する教材を追加する。
- [ ] 検索結果でキーボード移動と一致箇所の強調表示を提供する。
- [ ] コードパネルに任意の行番号表示を追加する。

## References

[1] [Astro Documentation](https://docs.astro.build/)

[2] [Google Java Format](https://github.com/google/google-java-format)

[3] [GitHub Pages: Custom GitHub Actions Workflows](https://docs.github.com/pages/getting-started-with-github-pages/using-custom-workflows-with-github-pages)
