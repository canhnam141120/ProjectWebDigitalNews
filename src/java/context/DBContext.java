/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author DELL
 */
public class DBContext {
/**
 * This method connect to database.
 * @return Connection.. It is a <code> java.sql.Connection <code> object.
 * @throws Exception 
 */
    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }
    private final String serverName = "localhost";
    private final String dbName = "DigitalNews";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "sa";

    /**
     * Close result set
     *
     * @param rs It is a <code> java.sql.ResultSet <code> object.
     * @throws SQLException
     */
    public void closeResultSet(ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
    }

    /**
     * Close prepared statement
     *
     * @param st It is a <code> java.sql.PreparedStatement <code> object.
     * @throws SQLException
     */
    public void closePreparedStatement(PreparedStatement st) throws SQLException {
        if (st != null && !st.isClosed()) {
            st.close();
        }
    }

    /**
     * Close Connection
     *
     * @param con It is a <code> java.sql.Connection <code> object.
     * @throws SQLException
     */
    public void closeConnection(Connection con) throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    /**
     * Get url of image
     *
     * @return url.. It is a <code> java.ulti.String <code> object.
     */
    public String getImgPath() {
        return "resources/img/";
    }
}
