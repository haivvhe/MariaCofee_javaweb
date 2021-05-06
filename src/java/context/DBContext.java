/**
 * copy right by FPT
 * DBContexts.java
 * author DuyDV
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
/**
 * DBContext class<br>
 * <pre>
 * DBContext
 * getConnection
 * closeConnection
 * getImagePath
 * </pre>
 * @author DuyDV
 */
public class DBContext {
/**
 * store initial
 */
    InitialContext initial;
    /**
     * store context
     */
    Context context;
    /**
     * store dbname, serverName, portNumber, image, username, password
     */
    String dbname, serverName, portNumber, image, username, password;

    public DBContext() {
        try {
            initial = new InitialContext();
            Object obj = initial.lookup("java:comp/env");
            context = (Context) obj;
            serverName = context.lookup("serverName").toString();
            dbname = context.lookup("dbName").toString();
            portNumber = context.lookup("portNumber").toString();
            image = context.lookup("image").toString();
            username = context.lookup("username").toString();
            password = context.lookup("password").toString();
        } catch (Exception e) {
        }

    }
/**getConnection<br>
 * <pre>
 * connect db
 * <pre>
 * @return
 * @throws ClassNotFoundException
 * @throws SQLException 
 */
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbname;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, username, password);

        //bên dưới là kết nối kiểu authen dùng cho máy nhà trường
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        Connection conn = DriverManager.getConnection("jdbc:sqlserver://"
//                + serverName + ":"
//                + portNumber + ";databaseName="
//                + dbname +";integratedSecurity=true;");
//        return conn;
    }
/**
 * closeConnection method<br>
 * <pre>
 * close connect db
 * </pre>
 * @param rs
 * @param ps
 * @param con
 * @throws SQLException 
 */
    public void closeConnection(ResultSet rs, PreparedStatement ps, Connection con) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
/**
 * getImagePath class<br>
 * <pre>
 * get image
 * </pre>
 * @return image
 * @throws Exception 
 */
    public String getImagePath() throws Exception {
        return image;
    }
}
