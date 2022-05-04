package hellomysql.repositories;

public class DBUtil {
    static void close(AutoCloseable autoCloseable) {
        try {
            if(autoCloseable != null)
            autoCloseable.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
