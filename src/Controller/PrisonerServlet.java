package Controller;

import Model.Prisoner;
import Model.PrisonerDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "Controller.PrisonerServlet",urlPatterns = "/prisoners")
public class PrisonerServlet extends HttpServlet {
    private final PrisonerDAO prisonerDAO = new PrisonerDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null)
            action="";
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case  "showAll":
                try {
                    showList(request,response);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "editCellRoom":
                showEditCellRoomForm(request,response);
                break;
        }

    }

    private void showEditCellRoomForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("editCellRoom.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
        requestDispatcher.forward(request,response);
    }
    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        List<Prisoner> prisoners = prisonerDAO.getAllPrisoners();
        request.setAttribute("list",prisoners);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null)
            action="";
        switch (action){
            case "create":
                try {
                    createNewPrisoner(request,response);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "editCellRoom":
                try {
                    editCellRoom(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;

        }

    }

    private void editCellRoom(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        Prisoner prisoner = new Prisoner();
        int id = Integer.parseInt(request.getParameter("id"));
        String cellRoom = request.getParameter("cellRoom");
        prisoner.setCellRoom(cellRoom);
        prisoner.setId(id);
        prisonerDAO.editCellRoom(prisoner);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("editCellRoom.jsp");
        requestDispatcher.forward(request,response);

    }

    private void createNewPrisoner(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String cellRoom = request.getParameter("cellRoom");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        double height = Double.parseDouble(request.getParameter("height"));
        double weight = Double.parseDouble(request.getParameter("weight"));
        String address = request.getParameter("address");
        String identification = request.getParameter("identification");
        String crime = request.getParameter("crime");
        String date_arrived = request.getParameter("date_arrived");
        String date_departure = request.getParameter("date_departure");
        String judgment = request.getParameter("judgment");
        String other = request.getParameter("other");
        prisonerDAO.createPrisoner(new Prisoner(id,cellRoom,name,age,height,weight,address,
                identification,crime,date_arrived,date_departure,judgment,other));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(request,response);
    }
}