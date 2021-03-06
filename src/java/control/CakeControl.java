/**
 * copy right by FPT
 * CakeControl.java
 * author DuyDV
 */
package control;

import context.DBContext;
import dao.CakeDAO;
import dao.ShareDAO;
import entity.Cake;
import entity.Share;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CakeControl", urlPatterns = {"/CakeControl"})
/**
 * CakeControl class<br>
 * <pre>
 * processRequest
 * </pre>
 */
public class CakeControl extends HttpServlet {
/**
 * processRequest class<br>
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
        try {
            //begin of set imagePath
            DBContext bContext = new DBContext();
            String imagePath = bContext.getImagePath();
            request.setAttribute("imagePath", imagePath);
            //end of set imagePath

            ShareDAO shareDAO = new ShareDAO();
            List<Share> share = shareDAO.getShare();
            request.setAttribute("share", share);

            String id = request.getParameter("id");
            int idCake = 0;
            try {
                idCake = Integer.parseInt(id);
            } catch (Exception e) {
                idCake = 1;
            }
            CakeDAO cakeDAO = new CakeDAO();
            Cake cake = cakeDAO.getCakeDetail(idCake);
            if (cake == null) {
                request.setAttribute("cake", cakeDAO.getCakeDetail(1));
            } else {
                request.setAttribute("cake", cake);
            }
            request.getRequestDispatcher("CakeDetail.jsp").forward(request, response);
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
