# Java by Tests 教材拡張指示書

## 目的

Java by Tests を「見落としやすい挙動だけを集めた教材」から、次の方向へ拡張する。

> **Java の言語仕様・標準 API・代表的な機能の挙動を、実行可能な JUnit 5 テストから理解する教材**

ただし、Java 入門サイト、構文リファレンス、API カタログにはしない。

追加判断の最重要基準は、**そのテストを見ることで Java の理解が一段深くなるか**である。

## 教材に追加してよいテーマ

各テーマは原則として次のいずれかに分類できるものにする。

### Pitfall

直感と実際の挙動がずれやすいもの。

例:

- `==` と `equals`
- `BigDecimal.equals` と `compareTo`
- `Arrays.asList` と `List.of`
- `Optional.orElse` と `orElseGet`
- `HashMap` の key と `equals` / `hashCode`
- mutable object を key にした場合の挙動

### Behavior

意外ではなくても、Java を書くうえで理解しておく価値が高く、テストで挙動を確認すると理解しやすいもの。

例:

- `try-with-resources` の close 順序
- `record` の自動生成メソッド
- `enum` の identity
- `switch expression`
- immutable / mutable collection
- defensive copy
- `Comparator` の比較規則

### Concept

Java の重要概念を、説明ではなく実行結果から理解できるもの。

例:

- 継承とオーバーライド
- overload と override
- covariance / invariance
- type erasure
- `? extends` / `? super`
- checked / unchecked exception
- thread safety
- happens-before
- virtual thread

## 追加しないテーマ

以下は原則として教材化しない。

- `1 + 2 == 3` のような単純な構文確認
- 変数宣言、if、for の基本操作だけを説明する内容
- JUnit を使う意味がほぼないテーマ
- JavaDoc の内容をそのまま写しただけのもの
- Spring、Jakarta EE などフレームワーク依存が強い内容
- 外部 DB、ネットワーク、実時刻、資格情報が必要な内容
- テーマ数を増やすことだけが目的の細分化

## Java 版で優先する領域

### 優先度 A

既存教材との重複を確認したうえで、未整備なら優先して追加する。

- `equals` / `hashCode` 契約
- `HashMap` / `HashSet` の key 契約
- `TreeMap` / `TreeSet` と `Comparator`
- `record`
- `sealed class`
- `switch expression`
- `try-with-resources`
- defensive copy
- immutable / mutable
- `Optional` の eager / lazy evaluation
- Stream の lazy evaluation / single-use
- `CompletableFuture` の例外伝播
- Virtual Threads

### 優先度 B

- `enum`
- annotation
- reflection
- class initialization
- static initialization order
- overload resolution
- varargs
- autoboxing / unboxing
- integer cache
- `String` pool
- `StringBuilder`
- `Collectors.toMap` の duplicate key
- unmodifiable view と immutable copy の違い
- `ExecutorService`
- interruption
- `synchronized`
- `volatile`

### 優先度 C

より高度だが、最小コードで明確に観測できる場合に追加する。

- class loader
- memory visibility
- happens-before
- weak references
- `Cleaner`
- serialization の仕様差
- pattern matching

## Java らしさを優先する

TypeScript 版・Go 版とテーマ数を揃える必要はない。

Java では特に以下を重視する。

- nominal typing
- class / interface
- JVM 上の実行モデル
- object identity
- generics と type erasure
- exceptions
- collection contracts
- concurrency / memory model
- Java 21 の主要言語機能

他言語に似たテーマがあっても、Java 固有の契約が弱い場合は無理に追加しない。

## 各教材の作り方

既存の Source + Test 形式を維持する。

各テーマでは最低限、次を満たす。

1. 一つの問いに絞る
2. Source は挙動確認に必要な最小コードにする
3. Test で値、例外、順序、状態変化のいずれかを固定する
4. `src/data/lessons.ts` に観測結果を記録する
5. 「なぜそうなるか」を短く説明する
6. 実務上の注意点がある場合は明記する
7. テストは決定的で何度実行しても同じ結果になるようにする

## 分類

新規テーマは可能なら次のいずれかの観点を明示する。

- `Pitfall`: 誤解しやすさが主題
- `Behavior`: 実行時契約が主題
- `Concept`: 概念理解が主題

分類を UI に追加するかどうかは別途判断してよい。分類のためだけに既存構造を複雑化しない。

## テーマ追加時の判断質問

追加前に次を確認する。

- Java 経験者でも結果を説明できない可能性があるか
- 実務のバグやレビューで役立つか
- テストで示すことに意味があるか
- 既存テーマと重複していないか
- 一つのテーマに複数の論点を詰め込みすぎていないか
- Java 固有の学びがあるか

3 個以上が弱い場合は追加しない。

## 実施手順

今後教材を拡張するときは以下の順で進める。

1. README、LEARNING_PATH、`src/data/lessons.ts`、既存 Source/Test を確認する
2. 既存テーマを重複なく把握する
3. 不足している重要テーマを優先度順に洗い出す
4. 一度に大量追加せず、意味のまとまりごとに追加する
5. Source / Test / Metadata / 説明を同じ変更で更新する
6. `pnpm verify` を通す
7. 必要なら README と LEARNING_PATH のカテゴリ数・説明も更新する

## 完了条件

新規教材の変更は以下をすべて満たして完了とする。

- JUnit 5 で挙動が再現可能
- Source と Test が最小構成
- 表示内容と実行コードが一致
- 既存教材と重複しない
- Java 固有の学習価値がある
- 単なる文法チュートリアルではない
- `pnpm verify` が成功する

テーマ数ではなく、**Java の挙動をテストという実行可能な仕様書として残せているか**を品質基準にする。
