package util;

import org.mindrot.jbcrypt.BCrypt;

public class HashUtil {

    // ハッシュ生成
    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // パスワード照合
    public static boolean check(String plain, String hashed) {
        return BCrypt.checkpw(plain, hashed);
    }
}