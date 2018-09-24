import com.auth.LoginForm;
import java.sql.*;
import java.lang.*;


public class MainFile {
    public static void main(String[] args) {
//        new LoginForm();
        Connection connection = null;
        Statement stmt = null;
        String sql;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.sqlite");
            stmt = connection.createStatement();

            sql = String.join(
                    System.getProperty("line.separator"),
                    "CREATE TABLE IF NOT EXISTS USERS(" +
                            "ID INTEGER PRIMARY KEY," +
                            "USERNAME VARCHAR NOT NULL," +
                            "EMAIL VARCHAR NOT NULL," +
                            "PASSWORD VARCHAR NOT NULL);",
                    "CREATE TABLE IF NOT EXISTS FILES(" +
                            "FILENAME VARCHAR PRIMARY KEY," +
                            "SIZE INTEGER NOT NULL," +
                            "DATE_UPLOADED DATE NOT NULL," +
                            "TYPE VARCHAR NOT NULL," +
                            "URL VARCHAR NOT NULL UNIQUE," +
                            "DOWNLOADED_BY INTEGER," +
                            "FOREIGN KEY (DOWNLOADED_BY) REFERENCES USERS(ID));",
                    "CREATE TABLE IF NOT EXISTS DOWNLOAD_LIST(" +
                            "ID INTEGER PRIMARY KEY," +
                            "FILENAME VARCHAR NOT NULL," +
                            "DATE_UPLOADED DATE NOT NULL," +
                            "PROGRESS INTEGER NOT NULL);"
            );

            stmt.execute(sql);

            stmt.close();
            connection.close();
        }
        catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}