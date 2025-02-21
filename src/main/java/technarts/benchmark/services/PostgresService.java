package technarts.benchmark.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresService {
    private static final String HOST = "localhost";
    private static final int PORT = 5432;
    private static final String DATABASE = "mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    private static final String URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE;

    public static void executeRawSql(String sql) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            boolean hasResultSet = statement.execute(sql);

            if (hasResultSet) {
                try (ResultSet rs = statement.getResultSet()) {
                    while (rs.next()) {
//                        System.out.println(rs.getString(1));
                    }
                }
            } else {
                int updateCount = statement.getUpdateCount();
//                System.out.println("Rows affected: " + updateCount);
            }

        } catch (SQLException e) {
//            System.err.println("Error executing SQL: " + e.getMessage());
//            e.printStackTrace();
        }
    }
}
