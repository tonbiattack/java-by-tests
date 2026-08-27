# Java by Tests — 学習順のガイド

## この教材の読み方

各テーマでは、まず Test の名前と assertion を読み、次に Source を確認します。完成実装を先に読むよりも、どの入力に何を期待し、どの例外を契約として扱うかを先に捉えられます。ローカルでテストを一度通した後、実装を一行だけ変えて Red を観測し、最小の修正で Green に戻してください。

```bash
pnpm test:java
```

> **テストは「コードが動く」ことの印ではなく、どの振る舞いを残すかを再実行可能にした記録です。**

## 最初の一周

Javaの言語仕様と標準APIの差分を順に確認したい場合は、次の4カテゴリから始めます。

| 順序 | カテゴリ | 最初のテーマ | 最初のテスト | 次の一歩 |
|---:|---|---|---|---|
| 1 | Language | [`String: == と equals`](https://tonbiattack.github.io/java-by-tests/java/string/equals/) | `StringComparisonTest` | Unicodeの長さと正規化を比較する。 |
| 2 | Collections | [`ArrayList: add`](https://tonbiattack.github.io/java-by-tests/java/list/add/) | `NumbersTest` | `List.of` と `Arrays.asList` の可変性を比較する。 |
| 3 | Functional | [`Optional: orElse`](https://tonbiattack.github.io/java-by-tests/java/optional/or-else/) | `NicknamesTest` | `orElse` と `orElseGet` の評価タイミングを確認する。 |
| 4 | Error Handling | [`assertThrows`](https://tonbiattack.github.io/java-by-tests/java/exception/assert-throws/) | `DivisionTest` | 例外の型と失敗後の状態を追加で検証する。 |

## 関心から選ぶ学習マップ

| 関心 | 読むカテゴリ | 代表的なテーマ | 学ぶ設計判断 |
|---|---|---|---|
| 値オブジェクトと比較 | Language / Collections | `equals` と `hashCode`、可変Mapキー、record配列 | 値比較・参照比較・hash契約をどう揃えるか。 |
| 入力値の扱い | Language / Functional | `isBlank`、`ofNullable`、Optional API設計 | 空白・null・不在をどの境界で正規化するか。 |
| コレクションの変更 | Collections / Functional | `List.of`、`Arrays.asList`、`Stream.toList` | 可変・固定長・変更不可の区別をどうAPIに残すか。 |
| 金額と数値 | Numbers | `BigDecimal`、丸め、doubleからの生成 | 数値比較と丸め規則をどうテストへ固定するか。 |
| 日付とタイムゾーン | Date / Time | `LocalDate`、夏時間の演算 | 暦日・時刻・経過時間をどう型で区別するか。 |
| 非同期と並行性 | Concurrency | `CompletableFuture.join`、ThreadLocal、ConcurrentHashMap | 失敗・文脈・null制約をどう明示するか。 |
| 型システム | Generics / Language | `? extends`、`? super`、型消去、sealed switch | 読む・書く・実行時型の境界をどう設計するか。 |

## 各テーマで試すこと

1. テスト名を自分の言葉で読み替えます。
2. `assertEquals`、`assertThrows`、`assertTrue` が何を固定するかを一つずつ説明します。
3. Sourceの一行を変更し、失敗メッセージの expected / actual、または例外型を観測します。
4. 最小の変更でテストを通します。
5. 境界値、入力不変性、失敗時の状態のいずれかを一つ追加します。

新しいテーマを追加する場合は、[CONTRIBUTING.md](./CONTRIBUTING.md) に従い、Source、Test、メタデータ、観測結果を同期してください。

## References

[1] [JUnit 5 User Guide](https://docs.junit.org/current/user-guide/)

[2] [Java by Tests — Live Demo](https://tonbiattack.github.io/java-by-tests/)
