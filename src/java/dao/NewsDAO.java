
package dao;

import java.util.ArrayList;
import entity.News;

public interface NewsDAO {

    /**
     * Find the top of news and sort by time.
     *
     * @param number amount of news.. It is a <code> java.util.Integer <code> object
     * @return a list of news.. It is a <code> java.util.ArrayList <code> object
     * @throws java.lang.Exception
     */
    public News getTopNumberNews(int number) throws Exception;

    
     public ArrayList<News> getTop5NumberNews(int number) throws Exception;
    /**
     * Find the news depends on id.
     *
     * @param id Identity of news.. It is a <code> java.util.Integer <code> object
     * @return A new which is news.. It is a <code> java.util.ArrayList <code> object
     * @throws java.lang.Exception
     */
    public News getNewsByID(int id) throws Exception;

    /**
     * Search the News depends on keyword and index.
     *
     * @param keyword keyword in tittle of news.. It is a <code> java.util.String <code> object
     * @param pageIndex index display news of page .. It is a <code> java.util.Integer <code> object
     * @param pageSize amount news can dislay in a page.. It is a <code> java.util.Integer <code> object
     * @return a List of News.. It is a <code> java.util.ArrayList <code> object
     * @throws java.lang.Exception
     */
    public ArrayList<News> search(String keyword, int pageIndex, int pageSize) throws Exception;

    /**
     * Find total news depends on keyword.
     *
     * @param keyword keyword in tittle of news.. It is a <code> java.util.String <code> object
     * @return total of news.. It is a <code> java.util.Integer <code> object
     * @throws java.lang.Exception
     */
    public int getTotalRecords(String keyword) throws Exception;

}
