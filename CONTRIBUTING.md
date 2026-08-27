# Contributing to Java by Tests

Java by Tests は、Java の挙動を短い Source/Test の対で記録する教材です。変更の目的は、テーマ数を増やすことではなく、**一つの見落としやすい契約を再現可能な証拠として残すこと**です。

## 変更の最小単位

新しい教材または既存教材の修正では、次の四点を同じ変更に含めてください。

| 対象 | 役割 | 配置 |
|---|---|---|
| Source | 確認したい挙動を最小限に表す Java 実装 | `examples/src/main/java/` |
| Test | 正常系、境界値、例外または状態変化を固定する JUnit 5 テスト | `examples/src/test/java/` |
| Metadata | タイトル、カテゴリ、タグ、Source/Testの対応、観測結果 | `src/data/lessons.ts` |
| 説明 | 何を確認するか、なぜ見落としやすいか | `src/data/lessons.ts` の `oneLine`、`checks`、`note` |

Sourceだけ、Testだけ、表示データだけを追加する変更は受け入れません。ブラウザに表示するコードとMavenで検証するコードを同一に保つことが、このリポジトリの中心的な制約です。

## テーマの選び方

良いテーマは、短く、観測可能で、再現可能です。`String`、コレクション、数値、`Optional`、`Stream`、例外、ジェネリクス、日時、並行性などで「似た API だが契約が異なる」一点を選びます。外部サービス、実時間、ネットワーク、ランダム値には依存させず、テスト単体で同じ結果を再現できるようにします。

| 確認すること | 例 |
|---|---|
| 正常系 | 入力に対して期待する値・順序・状態を返すか。 |
| 境界値 | 空文字、空コレクション、ゼロ、null、閾値前後でどう振る舞うか。 |
| 失敗 | 期待する例外型、原因、失敗後の状態をどう扱うか。 |
| 不変条件 | 可変・不変、参照共有、hash契約、リソース解放を守るか。 |

## 実装手順

1. IssueまたはPRの説明に、確認したい契約を一文で書きます。
2. JUnit テストを先に追加し、失敗することを確認します。
3. テストを通す最小の Source を追加します。
4. `lessons.ts` にメタデータと expected / actual、または期待する例外型を記録します。
5. ローカルで全ての品質ゲートを通します。

```bash
pnpm install
pnpm verify
```

## プルリクエストの確認項目

| 確認項目 | 合格条件 |
|---|---|
| 焦点 | 一つの仕様・API契約に焦点を絞っている。 |
| テスト | 正常系に加え、境界値または失敗時の挙動を確認している。 |
| 表示との一致 | Source/Testのパス、ファイル名、観測結果が実在するコードと一致する。 |
| 実行性 | `pnpm verify` が成功する。 |
| 文書 | タイトル、説明、タグが言語仕様・APIの挙動を正確に表す。 |
| 独立性 | 実ネットワーク、実時刻、外部資格情報へ依存しない。 |

## Issueの使い分け

新しい題材の提案には [教材テーマ提案](https://github.com/tonbiattack/java-by-tests/issues/new?template=lesson-request.yml) を、コード・表示・リンク・CIの不具合には [バグ報告](https://github.com/tonbiattack/java-by-tests/issues/new?template=bug-report.yml) を使ってください。

## References

[1] [JUnit 5 User Guide](https://docs.junit.org/current/user-guide/)

[2] [Java by Tests — Live Demo](https://tonbiattack.github.io/java-by-tests/)
