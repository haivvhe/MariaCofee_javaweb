/**
 * copy right by FPT
 * IntroductionDAO.java
 * author DuyDV
 */
package dao;


import context.DBContext;
import entity.Information;
import entity.Introduction;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * IntroductionDAO <br>
 * <pre>
 * getIntroduction
 * </pre>
 * @author DuyDV
 */
public class IntroductionDAO {
 /**
  * getIntroduction <br>
  * <pre>
  * get intro
  * </pre>
  * @return introduction
  * @throws Exception 
  */   
     public Introduction getIntroduction() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        try {
            String query = "select * from Intro";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Introduction introduction = new Introduction(rs.getString("title"), 
                        rs.getString("picture"), 
                        rs.getString("shortDescription"), 
                        rs.getString("detailDescription"));
                return introduction;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
        return null;
     }
    
}
