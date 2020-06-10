package Controller;

import Model.CrimeInform;
import Model.Prisoner;
import Model.PrisonerDAO;
import Model.PrivateInform;

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

@WebServlet(name = "Controller.PrisonerServlet",urlPatterns = "/prisoners")
public class PrisonerServlet extends HttpServlet {
    private final PrisonerDAO prisonerDAO = new PrisonerDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            if(action == null )
                action = "";
            switch (action){
                case "create":
                    try {
                        createNewPrisoner(request,response);
                    } catch (SQLException | ClassNotFoundException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                case "edit":
                    editPrisoner(request,response);
                    break;


            }
    }

    private void editPrisoner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit.jsp");
        requestDispatcher.forward(request,response);
    }

    public void  createNewPrisoner(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        String cellRoom = request.getParameter("cellRoom");
        Prisoner prisoner = new Prisoner(id,cellRoom);
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        double height = Double.parseDouble(request.getParameter("height"));
        double weight = Double.parseDouble(request.getParameter("weight"));
        String address = request.getParameter("address");
        String identification = request.getParameter("identification");
        prisoner.setPrivateInform(new PrivateInform(name,age,height,weight,address,identification));
        String crime = request.getParameter("crime");
        String date_arrived = request.getParameter("date_arrived");
        String date_departure = request.getParameter("date_departure");
        String judgment = request.getParameter("judgment");
        String other = request.getParameter("other");
        prisoner.setCrimeInform(new CrimeInform(crime,date_arrived,date_departure,judgment,other));
        prisonerDAO.createPrisoner(prisoner);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
        requestDispatcher.forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                try {
                    deletePrisoner(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    showAllPrisoner(request, response);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }



    }

    private void deletePrisoner(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        prisonerDAO.deletePrisonerById(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(request,response);

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showAllPrisoner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        request.setAttribute("list", prisonerDAO.getAllPrisoners());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(request, response);
    }

}