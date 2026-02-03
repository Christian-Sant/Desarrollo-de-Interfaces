package com.MavenEjercicios.controller;
import java.io.IOException;
import java.util.List;

import com.MavenEjercicios.dao.VehiculoDAO;
import com.MavenEjercicios.model.Vehiculo;
import com.MavenEjercicios.dao.PropietarioDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/VehiculoController")
public class VehiculoController extends HttpServlet {

    VehiculoDAO dao = new VehiculoDAO();
    PropietarioDAO daoProp = new PropietarioDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion == null || accion.isEmpty()) {
            listar(request, response);
        } else {
            switch (accion) {
                case "listar":
                    listar(request, response);
                    break;
                case "nuevo":
                    request.setAttribute("listaPropietarios", daoProp.listar());
                    request.getRequestDispatcher("views/form-vehiculo.jsp").forward(request, response);
                    break;
                case "editar":
                    int id = Integer.parseInt(request.getParameter("id"));
                    Vehiculo v = dao.listarPorId(id); // Obtenemos datos actuales
                    request.setAttribute("vehiculo", v);
                    request.setAttribute("listaPropietarios", daoProp.listar());
                    request.getRequestDispatcher("views/form-vehiculo.jsp").forward(request, response);
                    break;
                case "dashboard":
                    mostrarDashboard(request, response);
                    break;
                case "eliminar":
                    int idEliminar = Integer.parseInt(request.getParameter("id"));
                    dao.eliminar(idEliminar);
                    listar(request, response);
                    break;
            }
        }
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Vehiculo> lista = dao.listarTodoInfoCompleta();
        req.setAttribute("vehiculos", lista);
        req.getRequestDispatcher("views/lista-vehiculos.jsp").forward(req, resp);
    }

    private void mostrarDashboard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("total", dao.getTotalVehiculos());
        req.setAttribute("antiguos", dao.get5MasAntiguos());
        req.getRequestDispatcher("views/dashboard.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Leer parámetros del formulario
        int idVehiculo = request.getParameter("idVehiculo") != null
                         ? Integer.parseInt(request.getParameter("idVehiculo")) : 0;

        String matricula = request.getParameter("matricula");
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        int anio = Integer.parseInt(request.getParameter("anio"));
        int idProp = Integer.parseInt(request.getParameter("idPropietario"));

        Vehiculo v = new Vehiculo(matricula, marca, modelo, anio);
        v.setIdPropietario(idProp);

        if(idVehiculo == 0) {
            // Nuevo vehículo
            dao.agregar(v);
        } else {
            // Editar vehículo existente
            v.setIdVehiculo(idVehiculo);
            dao.editar(v);
        }

        response.sendRedirect("VehiculoController?accion=listar");
    }
}
