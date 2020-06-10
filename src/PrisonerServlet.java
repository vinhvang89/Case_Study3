import Model.Prisoner;
import Model.PrisonerDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PrisonerServlet",urlPatterns = "/abc")
public class PrisonerServlet extends HttpServlet {
    private final PrisonerDAO prisonerDAO = new PrisonerDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null){
            action = "";
        }
        switch (action){
            case "showAll":
                try {
                    showAllPrisoner(request,response);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "updateJailRoom":
                updateJailRoom(request,response);
            default:
                break;
        }
    }

    private void updateJailRoom(HttpServletRequest request, HttpServletResponse response) {
            }

    private void showAllPrisoner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        request.setAttribute("list",prisonerDAO.getAllPrisoners());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(request,response);
    }
}
