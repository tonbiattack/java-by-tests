# Java by Tests

[![Java examples](https://github.com/tonbiattack/java-by-tests/actions/workflows/ci.yml/badge.svg)](https://github.com/tonbiattack/java-by-tests/actions/workflows/ci.yml)
[![GitHub Pages](https://img.shields.io/badge/demo-GitHub%20Pages-181717?logo=github)](https://tonbiattack.github.io/java-by-tests/)
[![Java 21](https://img.shields.io/badge/Java-21-ED8B00?logo=openjdk&logoColor=white)](https://openjdk.org/projects/jdk/21/)
[![JUnit 5](https://img.shields.io/badge/test-JUnit%205-25A162)](https://junit.org/junit5/)

**Java by Tests** は、Java 21 で見落としやすい言語仕様と標準 API の挙動を、実行可能な **JUnit 5 テスト**から学ぶ静的ドキュメントサイトです。各テーマでは最小の Source、振る舞いを固定する Test、具体的な期待値または例外を並べ、コードの契約を短時間で確認できます。

> Javaの文法を網羅するのではなく、**見た目は似ていても挙動が異なる API・言語仕様**を、JUnit テストという実行可能な仕様書として読み解く教材です。

| Link | 内容 |
|---|---|
| [Live Demo](https://tonbiattack.github.io/java-by-tests/) | ブラウザで Source と Test を対比して読む。 |
| [TypeScript by Tests](https://github.com/tonbiattack/typescript-by-tests) | 同じ教材方針を TypeScript 5 / Node.js 22 へ移植した姉妹リポジトリ。 |
| [TypeScript Demo](https://tonbiattack.github.io/typescript-by-tests/) | TypeScript版の実行可能な教材サイト。 |
| [学習順のガイド](./LEARNING_PATH.md) | 関心に応じた開始地点と、Red → Green → Refactor の進め方。 |
| [Astro 構成ガイド](./docs/ASTRO_GUIDE.md) | このサイトのビルド時処理、ブラウザ側スクリプト、フォルダの責務を実装に対応させて解説。 |
| [教材拡張ガイド](./docs/EXPANSION_GUIDE.md) | 新しいテーマを選び、Source・Test・表示をそろえて追加するための判断基準。 |

## 誰のための教材か

Java を書いた経験はあるものの、`String`、`List`、`Optional`、`Stream`、`BigDecimal`、日時、ジェネリクス、並行処理の「動くと思ったのに違った」を、短いコードとテストで確かめたい読者を対象にします。JUnit の assertion を読み、実装を一行だけ変えて失敗を観測し、最小の修正で Green に戻す学び方を想定しています。

## 学習マップ

全 **55 テーマ**を 8 カテゴリに分けています。興味のある項目から始められますが、初めての場合は Language → Collections → Functional → Error Handling の順が読みやすい構成です。

| カテゴリ | テーマ数 | まず読むテーマ | 身に付ける問い |
|---|---:|---|---|
| Language | 16 | [`String: == と equals`](https://tonbiattack.github.io/java-by-tests/java/string/equals/) | 値比較と参照比較、初期化順、overloadをどう区別するか。 |
| Collections | 11 | [`ArrayList: add`](https://tonbiattack.github.io/java-by-tests/java/list/add/) | 可変性、共有ビュー、コピー、`Map` のキー契約、`Comparator` の等価性をどう扱うか。 |
| Numbers | 4 | [`BigDecimal: equals と compareTo`](https://tonbiattack.github.io/java-by-tests/java/bigdecimal/equals-vs-compare-to/) | 数値の精度、scale、丸めをどう固定するか。 |
| Functional | 10 | [`Optional: orElse`](https://tonbiattack.github.io/java-by-tests/java/optional/or-else/) | 不在、遅延評価、Stream の状態と重複キーをどう表すか。 |
| Error Handling | 3 | [`assertThrows`](https://tonbiattack.github.io/java-by-tests/java/exception/assert-throws/) | 期待する例外とリソース解放をどう契約化するか。 |
| Generics | 3 | [`? extends Number`](https://tonbiattack.github.io/java-by-tests/java/generics/extends/) | 読み書きの境界と型消去をどう考えるか。 |
| Date / Time | 2 | [`LocalDate と LocalDateTime`](https://tonbiattack.github.io/java-by-tests/java/datetime/localdate-localdatetime/) | 日付、時刻、タイムゾーン、経過時間をどう分けるか。 |
| Concurrency | 6 | [`CompletableFuture: join`](https://tonbiattack.github.io/java-by-tests/java/concurrency/completable-future-join/) | 非同期失敗、割り込み、共有状態の制約をどう扱うか。 |

各テーマの Source と Test は [Live Demo](https://tonbiattack.github.io/java-by-tests/) で確認できます。コードをローカルで実行する場合は、次の手順を使ってください。

## すぐに始める

### 必要条件

Node.js **20 以上**、pnpm、Java **21**、Maven を用意してください。[1] [2]

### インストールと閲覧

```bash
pnpm install
pnpm dev
```

### 実行可能な Java 教材を検証する

```bash
pnpm test:java
```

### すべての品質ゲートを実行する

```bash
pnpm verify
```

`pnpm verify` は、Astro の型検査、Maven による Java/JUnit テスト、GitHub Pages 用サブパスでの静的ビルド、内部リンク検査を順に実行します。

| コマンド | 目的 |
|---|---|
| `pnpm dev` | ローカルで教材サイトを閲覧する。 |
| `pnpm test:java` | `examples/` の Java 21 / JUnit 5 テストを実行する。 |
| `pnpm typecheck` | Astro コンポーネントと TypeScript 設定を静的検査する。 |
| `GITHUB_ACTIONS=true pnpm build` | GitHub Pages用の `/java-by-tests/` サブパスで静的ビルドする。 |
| `pnpm verify:links` | 静的出力の内部リンクを検査する。 |
| `pnpm verify` | 上記の品質ゲートを一括で実行する。 |

## このリポジトリが保証すること

ブラウザに表示する Source/Test と、ローカルで Maven が実行するコードは同じ Java ファイルです。Astro はビルド時に `examples/` を読み込み、テーマ・タグ・観測結果だけを `src/data/lessons.ts` で管理します。そのため、説明用コードと検証対象が乖離しません。

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

| 品質ゲート | 守る契約 | 自動化場所 |
|---|---|---|
| JUnit 5 | 全55テーマの期待値・例外・状態遷移 | Maven / GitHub Actions |
| Astro check | 表示コンポーネントとデータ定義の型整合性 | pnpm / GitHub Actions |
| Static build | GitHub Pagesで公開できるHTML生成 | Astro / GitHub Actions |
| Link verification | サブパス下の内部リンクが実在すること | Node.js script / GitHub Actions |

## リポジトリ構成

Astro が何をビルド時に処理し、どのコードだけがブラウザで動くかは、[Astro 構成ガイド](./docs/ASTRO_GUIDE.md) を参照してください。このプロジェクトには `client:*` ディレクティブはなく、静的 HTML を基本とし、検索・コピーなどの小さな操作だけを通常の `<script>` で実装しています。

```text
.
├── examples/
│   ├── pom.xml              # Java 21 / JUnit 5 の実行設定
│   └── src/
│       ├── main/java/       # Sourceとして表示する完成実装
│       └── test/java/       # 挙動を固定するJUnitテスト
├── src/
│   ├── components/          # Source/Test パネル、目次、検索UI
│   ├── data/lessons.ts      # 55テーマのメタデータと実ファイルの対応
│   ├── layouts/             # 共通レイアウトと静的検索
│   └── pages/               # ホームと教材ページの静的ルート
├── public/                  # 変換せず公開する静的ファイル
├── docs/                    # 実装・運用の説明資料
├── .github/                 # CI、Pagesデプロイ、Issueテンプレート
├── LEARNING_PATH.md         # カテゴリ別の学習導線
├── CONTRIBUTING.md          # 教材を追加・改善するための規約
└── scripts/verify-pages-links.mjs
```

## 新しいテーマを提案・追加する

新しい挙動を見つけたときは、[教材テーマ提案](https://github.com/tonbiattack/java-by-tests/issues/new?template=lesson-request.yml) を利用してください。不具合の報告には [バグ報告](https://github.com/tonbiattack/java-by-tests/issues/new?template=bug-report.yml) を使えます。実装を伴う更新では、**Source、Test、`lessons.ts` のメタデータ、観測結果**を同じ変更に含めます。詳細は [CONTRIBUTING.md](./CONTRIBUTING.md) を参照してください。

## ライセンス

このリポジトリには現時点でライセンスファイルを設定していません。再利用、配布、派生物の作成を予定する場合は、リポジトリ所有者へ確認してください。

## References

[1] [OpenJDK JDK 21](https://openjdk.org/projects/jdk/21/)

[2] [JUnit 5 User Guide](https://docs.junit.org/current/user-guide/)

[3] [Astro Documentation](https://docs.astro.build/)

[4] [GitHub Pages: Custom GitHub Actions Workflows](https://docs.github.com/pages/getting-started-with-github-pages/using-custom-workflows-with-github-pages)
