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
                case "editPrivateInform":
                    try {
                        editPrivateInform(request,response);
                    } catch (SQLException | ClassNotFoundException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                case "editCrimeInform":
                    try {
                        editCrimeInform(request,response);
                    } catch (SQLException | ClassNotFoundException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                case "editCellRoom":
                    try {
                        editCellRoom(request,response);
                    } catch (SQLException | ClassNotFoundException throwables) {
                        throwables.printStackTrace();
                    }
                    break;

            }
    }

    private void editCellRoom(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String cellRoom = request.getParameter("cellRoom");
        prisonerDAO.updateJailRoom(new Prisoner(id,cellRoom));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("editCellRoom.jsp");
        requestDispatcher.forward(request,response);
    }

    private void editCrimeInform(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Prisoner prisoner = new Prisoner();
        prisoner.setId(id);
        String crime = request.getParameter("crime");
        String date_arrived = request.getParameter("date_arrived");
        String date_departure = request.getParameter("date_departure");
        String judgment = request.getParameter("judgment");
        String other = request.getParameter("other");

        prisoner.setCrimeInform(new CrimeInform(crime, date_arrived,date_departure, judgment, other));
        prisonerDAO.updateCrimeInform(prisoner);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("editCrimeInfo.jsp");
        requestDispatcher.forward(request,response);
    }

    private void editPrivateInform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        Prisoner prisoner = new Prisoner();
        prisoner.setId(id);
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        double height = Double.parseDouble(request.getParameter("height"));
        double weight = Double.parseDouble(request.getParameter("weight"));
        String address = request.getParameter("address");
        String identification = request.getParameter("identification");
        prisoner.setPrivateInform(new PrivateInform(name,age,height,weight,address,identification));
        prisonerDAO.updatePrivateInform(prisoner);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("editPrivateInform.jsp");
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
            case "editPrivateInform":
                showEditPrivateInform(request,response);
                break;
            case "editCrimeInform":
                showEditCrimeInform(request,response);
            case "editCellRoom":
                showEditCellRoom(request,response);
                break;
            case "delete":
                try {
                    deletePrisoner(request,response);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "showAll":
                try {
                    showAllPrisoner(request, response);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request,response);
                break;

        }



    }

    private void showEditCellRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("editCellRoom.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showEditCrimeInform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("editCrimeInfo.jsp");
        requestDispatcher.forward(request,response);
    }

    private void deletePrisoner(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        prisonerDAO.deletePrisonerById(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(request,response);

    }

    private void showEditPrivateInform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("editPrivateInform.jsp");
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