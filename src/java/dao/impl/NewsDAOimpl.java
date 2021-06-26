
package dao.impl;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import entity.News;

public class NewsDAOimpl extends DBContext implements dao.NewsDAO {

    /**
     * Find the top of news and sort by time.
     *
     * @param number amount of news.. It is a <code> java.util.Integer <code> object
     * @return a list of news.. It is a <code> java.util.ArrayList <code> object
     * @throws java.lang.Exception
     */
    @Override
    public ArrayList<News> getTop5NumberNews(int number) throws Exception {
        String sql = "SELECT TOP(5) * FROM dbo.Article WHERE id ! = ?\n"
                + "ORDER BY [time] DESC";
        ArrayList<News> articles = new ArrayList<>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            st = con.prepareStatement(sql);
            st.setInt(1, number);
            rs = st.executeQuery();
            while (rs.next()) {
                News a = new News();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setContent(rs.getString("content"));
                a.setDescription(rs.getString("description"));
                a.setImage(getImgPath() + rs.getString("image"));
                a.setTime(rs.getTimestamp("time"));
                a.setAuthor(rs.getString("author"));
                articles.add(a);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(st);
            closeConnection(con);
        }
        return articles;
    }
    @Override
    public News getTopNumberNews(int number) throws Exception {
        String sql = "SELECT TOP(?) * FROM dbo.Article\n"
                + "ORDER BY [time] DESC";
                Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        News a = new News();
        try {
            con = getConnection();
            st = con.prepareStatement(sql);
            st.setInt(1, number);
            rs = st.executeQuery();
            while (rs.next()) {
                
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setContent(rs.getString("content"));
                a.setDescription(rs.getString("description"));
                a.setImage(getImgPath() + rs.getString("image"));
                a.setTime(rs.getTimestamp("time"));
                a.setAuthor(rs.getString("author"));
                return a;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
        
    }
        return a;
    }
    /**
     * Find the news depends on id.
     *
     * @param id Identity of news.. It is a <code> java.util.Integer <code> object
     * @return A new which is news.. It is a <code> java.util.ArrayList <code> object
     * @throws java.lang.Exception
     */
    @Override
    public News getNewsByID(int id) throws Exception {
        String sql = "SELECT * FROM dbo.Article WHERE id = ?";
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            st = con.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                News a = new News();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setContent(rs.getString("content"));
                a.setDescription(rs.getString("description"));
                a.setImage(getImgPath() + rs.getString("image"));
                a.setTime(rs.getTimestamp("time"));
                a.setAuthor(rs.getString("author"));
                return a;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(st);
            closeConnection(con);
        }
        return null;
    }

    /**
     * Search the News depends on keyword and index.
     *
     * @param keyword keyword in tittle of news.. It is a <code> java.util.String <code> object
     * @param pageIndex index display news of page .. It is a <code> java.util.Integer <code> object
     * @param pageSize amount news can dislay in a page.. It is a <code> java.util.Integer <code> object
     * @return a List of News.. It is a <code> java.util.ArrayList <code> object
     * @throws java.lang.Exception
     */
    @Override
    public ArrayList<News> search(String keyword, int pageIndex, int pageSize)
            throws Exception {
        String sql = "WITH t AS (\n"
                + "SELECT ROW_NUMBER() OVER (ORDER BY [time] DESC) rownum,* "
                + "FROM dbo.Article \n"
                + "WHERE title LIKE '%' + ? + '%' OR content LIKE '%' + ? + '%'\n"
                + ")\n"
                + "SELECT * FROM t "
                + "WHERE t.rownum >= (? - 1) * ? + 1 AND t.rownum <= ? * ?";
        ArrayList<News> articles = new ArrayList<>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            st = con.prepareStatement(sql);
            st.setString(1, keyword);
            st.setString(2, keyword);
            st.setInt(3, pageIndex);
            st.setInt(4, pageSize);
            st.setInt(5, pageIndex);
            st.setInt(6, pageSize);
            rs = st.executeQuery();
            while (rs.next()) {
                News a = new News();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setContent(rs.getString("content"));
                a.setDescription(rs.getString("description"));
                a.setImage(getImgPath() + rs.getString("image"));
                a.setTime(rs.getTimestamp("time"));
                a.setAuthor(rs.getString("author"));
                articles.add(a);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(st);
            closeConnection(con);
        }
        return articles;
    }

    /**
     * Find total news depends on keyword.
     *
     * @param keyword keyword in tittle of news.. It is a <code> java.util.String <code> object
     * @return total of news.. It is a <code> java.util.Integer <code> object
     * @throws java.lang.Exception
     */
    @Override
    public int getTotalRecords(String keyword) throws Exception {
        String sql = "SELECT COUNT(*) AS Total FROM dbo.Article \n"
                + "WHERE title LIKE '%' + ? + '%' OR content LIKE '%' + ? + '%'";
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            st = con.prepareStatement(sql);
            st.setString(1, keyword);
            st.setString(2, keyword);
            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total");
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(st);
            closeConnection(con);
        }
        return -1;
    }
}
