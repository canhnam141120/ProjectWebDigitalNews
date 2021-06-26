/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.NewsDAO;
import dao.impl.NewsDAOimpl;
import entity.News;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class SearchController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String error = "Error, keyword can't null!";
        try {
            NewsDAO articleDAO = new NewsDAOimpl();
            ArrayList<News> last5Articles = articleDAO.getTop5NumberNews(5);
            News latestArticle = last5Articles.get(0);
            request.setAttribute("latestArticle", latestArticle);
            request.setAttribute("last5Articles", last5Articles);
            String keyword = request.getParameter("keyword").trim();
            if (keyword.equals("")) {
                throw new Exception();
            }
            String page = request.getParameter("page");
            page = (page == null || page.trim().isEmpty()) ? "1" : page;
            int pageIndex = Integer.parseInt(page);
            final int pageSize = 3;
            int totalRecords = articleDAO.getTotalRecords(keyword);
            if (totalRecords <= 0) {
                error = "Not Found!";
                throw new Exception();
            } else {
                ArrayList<News> results = articleDAO.search(keyword, pageIndex, pageSize);
                int totalPages = (totalRecords % pageSize == 0) ? (totalRecords / pageSize) : (totalRecords / pageSize + 1);
                request.setAttribute("keyword", keyword);
                request.setAttribute("pageIndex", pageIndex);
                request.setAttribute("results", results);
                request.setAttribute("totalPages", totalPages);
            }
            request.getRequestDispatcher("search.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
