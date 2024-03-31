import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;
import java.lang.String;


import com.AutoWeb.dao.VehicleDAO;
import com.AutoWeb.entities.Vehicle;

@WebServlet("/VehicleServlet")
public class VehicleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private VehicleDAO vehicleDAO;

    public VehicleServlet() {
        super();
        vehicleDAO = new VehicleDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "getAllVehicles":
                getAllVehicles(request, response);
                break;
            // Adicione outras ações aqui, se necessário
            default:
                break;
        }
    }

    private void getAllVehicles(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            List<Vehicle> vehicles = vehicleDAO.getAllVehicles(); // Implemente este método no VehicleDAO para buscar todos os veículos
            request.setAttribute("vehicles", vehicles);
            request.getRequestDispatcher("listVehicles.jsp").forward(request, response);
        } catch (ServletException e) {
            // Tratar a exceção aqui, se necessário
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "addVehicle":
                addVehicle(request, response);
                break;
            
            default:
                break;
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
       
        String action = request.getParameter("action");
        switch (action) {
            case "updateVehicle":
                updateVehicle(request, response);
                break;
            
            default:
                break;
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        
        String action = request.getParameter("action");
        switch (action) {
            case "deleteVehicle":
                deleteVehicle(request, response);
                break;
           
            default:
                break;
        }
    }

    private void addVehicle(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // Seu código para adicionar um veículo
    }

    private void updateVehicle(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // Seu código para atualizar um veículo
    }

    private void deleteVehicle(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // Seu código para deletar um veículo
    }
}
