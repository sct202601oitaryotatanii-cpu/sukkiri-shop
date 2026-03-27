# 🛒 スッキリ商店（ECサイト）

## 📌 概要
Java（Servlet/JSP）で作成したシンプルなECサイトです。  
ユーザー認証・カート・購入・管理者機能まで実装しています。

---

## 🎯 主な機能

### 👤 ユーザー機能
- ユーザー登録
- ログイン / ログアウト（bcryptによるパスワード暗号化）
- 商品一覧表示
- カート機能（数量管理）
- 商品購入
- 注文履歴表示

### 🔐 認証・セキュリティ
- セッション管理
- Filterによるログイン制御
- 管理者権限チェック（role）

### 🛠 管理者機能
- 管理画面表示（adminのみアクセス可）
- 商品一覧管理

---

## 🧱 使用技術

- Java（Servlet / JSP）
- JDBC
- H2 Database
- Apache Tomcat
- jBCrypt（パスワード暗号化）

---

## 🗂 ディレクトリ構成

src
├─ model // ビジネスロジック
├─ dao // DBアクセス
├─ servlet // サーブレット
├─ filter // 認証フィルター
└─ util // ハッシュ処理など

WEB-INF
├─ jsp // 画面（JSP）
└─ lib // ライブラリ


---

## 🗄 データベース

### ACCOUNTSテーブル
| カラム | 型 |
|--------|----|
| USER_ID | VARCHAR |
| PASS | VARCHAR(100) |
| MAIL | VARCHAR |
| NAME | VARCHAR |
| AGE | INT |
| ROLE | VARCHAR |

※ PASSはbcryptで暗号化（約60文字）

---

## 🔑 管理者ログイン

管理者機能を使うには、以下のSQLで権限を付与してください。

```sql
UPDATE ACCOUNTS SET ROLE='admin' WHERE USER_ID='対象ユーザー';



