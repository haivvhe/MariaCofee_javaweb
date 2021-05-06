/**
 * copy right by FPT
 * ListCakeControl.java
 * author DuyDV
 */
package control;

import context.DBContext;
import dao.CakeDAO;
import dao.InformationDAO;
import dao.IntroductionDAO;
import dao.ShareDAO;
import entity.Cake;
import entity.Information;
import entity.Introduction;
import entity.Share;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ListCakeControl", urlPatterns = {"/ListCakeControl"})
/**
 * ListCakeControl class <br>
 * <pre>
 * processRequest
 * </pre>
 */
public class ListCakeControl extends HttpServlet {

    /**
     * processRequest method<br>
     * <pre>
     * load image
     * load share
     * </pre>
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            DBContext bContext = new DBContext();
            String imagePath = bContext.getImagePath();
            request.setAttribute("imagePath", imagePath);
            

            ShareDAO shareDAO = new ShareDAO();
            List<Share> share = shareDAO.getShare();
            request.setAttribute("share", share);

            CakeDAO cakeDAO = new CakeDAO();
            String page_index = request.getParameter("txtPage");
            if(page_index == null){
                page_index = "1";
            }
            int pageIndex = Integer.parseInt(page_index);
            
            int pageSize = 3;
            int rowCount = cakeDAO.getTotalProducts();  
            int maxPage = rowCount / pageSize;
            if(rowCount % pageSize !=0){
                maxPage = maxPage + 1;
            }
            List<Cake> cakes = cakeDAO.getAllCakes(pageIndex, pageSize);
            request.setAttribute("cakes", cakes);
            request.setAttribute("maxPage", maxPage);
            request.setAttribute("pageIndex", pageIndex);

            request.setAttribute("activeList", "activeList");
            request.getRequestDispatcher("List.jsp").forward(request, response);

        } catch (Exception ex) {
            response.sendRedirect("Error.jsp");
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
        processRequest(request, response);
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
