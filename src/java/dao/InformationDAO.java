/**
 * copy right by FPT
 * InformationDAO.java
 * author DuyDV
 */
package dao;

import context.DBContext;
import entity.Cake;
import entity.Information;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * InformationDAO class<br>
 * <pre>
 * getInfomation
 * </pre>
 * @author DuyDV
 */
public class InformationDAO {
/**
 * getInfomation method <br>
 * <pre>
 * get informattion in db
 * </pre>
 * @return information
 * @throws Exception 
 */
    public Information getInfomation() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        try {
            String query = "select * from Information";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Information information = new Information(rs.getString("shortDescription"),
                        rs.getString("address"),
                        rs.getString("tel"),
                        rs.getString("email"),
                        rs.getString("openingHours"),
                        rs.getString("signature"));
                return information;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
        return null;
    }
}
