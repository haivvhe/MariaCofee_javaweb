/**
 * copy right by FPT
 * CakeDAO.java
 * author DuyDV
 */
package dao;

import context.DBContext;
import entity.Cake;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 * CakeDAO class <br>
 * <pre>
 * getTop2
 * getTotalProducts
 * getAllCakes
 * </pre>
 * @author DuyDV
 */
public class CakeDAO {
/**
 * getTop2 method<br>
 * <pre>
 * select top 2 with DateCreated
 * </pre>
 * @return list
 * @throws Exception 
 */
    public List<Cake> getTop2() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        ArrayList<Cake> list = new ArrayList<>();
        try {
            String query = "select top 2* from Products order by DateCreated desc";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cake cake = new Cake(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("picture"),
                        rs.getString("shortDescription"),
                        rs.getString("detailDescription"),
                        rs.getString("price")
                );
                list.add(cake);
            }
            return list;
        } catch (Exception e) {
           throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
    }
/**
 * getCakeDetail method<br>
 * <pre>
 * get cake with id
 * </pre>
 * @param CakeID
 * @return cake
 * @throws Exception 
 */
    public Cake getCakeDetail(int CakeID) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        try {
            String query = "select * from Products where ID = ?";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, CakeID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cake cake = new Cake(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("picture"),
                        rs.getString("shortDescription"),
                        rs.getString("detailDescription"),
                        rs.getString("price")
                );
                return cake;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
        return null;
    }
/**
 * getTotalProducts<br>
 * <pre>
 * count cake in db
 * </pre>
 * @return count
 * @throws Exception 
 */
    public int getTotalProducts() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBContext db = new DBContext();
        int count = 0;
        try {
            String query = "select count(*) from Products";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            db.closeConnection(rs, ps, conn);
        }
        return count;
    }
/**
 * getAllCakes method<br>
 * <pre>
 * paging
 * </pre>
 * @param pageIndex
 * @param pageSize
 * @return
 * @throws Exception 
 */
    public List<Cake> getAllCakes(int pageIndex, int pageSize) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
         DBContext db = new DBContext();
        ArrayList<Cake> list = new ArrayList<>();
        try {
            String sql = " select *from("
                    + " select ROW_NUMBER() over (order by ID ASC) as rn, *\n"
                    + " from Products"
                    + " )as x\n"
                    + " where rn between (?-1)*?+1"
                    + " and ?*?";
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pageIndex);
            ps.setInt(2, pageSize);
            ps.setInt(3, pageIndex);
            ps.setInt(4, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cake cake = new Cake(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("picture"),
                        rs.getString("shortDescription"),
                        rs.getString("detailDescription"),
                        rs.getString("price")
                );
                list.add(cake);
            }
            return list;
        } catch (Exception e) {
           throw  e;
        } finally {
            db.closeConnection(rs, ps, conn);
        }
    }

}
