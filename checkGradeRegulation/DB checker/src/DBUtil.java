import java.sql.*;

public class DBUtil {
    private Connection conn = null;
    private Statement stmt;
    public DBUtil(){
        try {
            //JDBC连接
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/student";
            conn = DriverManager.getConnection(url,"root","password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public  ResultSet  query(String sql){
        ResultSet resultSet = null;
        try {
            //执行sql语句，返回查询结果
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            return resultSet;
        }

    }
    public void close(){
        try {
            stmt.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
