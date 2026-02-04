package com.MavenEjercicios.controller;
import java.io.IOException;
import java.util.List;

import com.MavenEjercicios.dao.PropietarioDAO;
import com.MavenEjercicios.dao.VehiculoDAO;
import com.MavenEjercicios.model.Vehiculo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/VehiculoController")
public class VehiculoController extends HttpServlet {
    
    VehiculoDAO dao = new VehiculoDAO();
    PropietarioDAO daoProp = new PropietarioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion == null || accion.isEmpty()) {
            listar(request, response);
            return;
        }

        switch (accion) {
            case "listar":
                listar(request, response);
                break;

            case "nuevo":
                request.setAttribute("listaPropietarios", daoProp.listar());
                request.getRequestDispatcher("form-vehiculo.jsp").forward(request, response);
                break;

            case "editar":
                cargarFormularioEdicion(request, response);
                break;

            case "dashboard":
                mostrarDashboard(request, response);
                break;

            case "eliminar":
                eliminar(request, response);
                break;

            default:
                listar(request, response);
        }
    }

    // ---------------------- LISTAR ----------------------
    private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Vehiculo> lista = dao.listarTodoInfoCompleta();
        req.setAttribute("vehiculos", lista);
        req.getRequestDispatcher("lista-vehiculos.jsp").forward(req, resp);
    }

    // ---------------------- DASHBOARD ----------------------
    private void mostrarDashboard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("total", dao.getTotalVehiculos());
        req.setAttribute("antiguos", dao.get5MasAntiguos());
        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
    }

    // ---------------------- ELIMINAR ----------------------
    private void eliminar(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        dao.eliminar(id);
        listar(req, resp);
    }

    // ---------------------- CARGAR FORMULARIO EDICIÓN ----------------------
    private void cargarFormularioEdicion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Vehiculo v = dao.listarPorId(id);

        req.setAttribute("vehiculo", v);
        req.setAttribute("listaPropietarios", daoProp.listar());
        req.getRequestDispatcher("form-vehiculo.jsp").forward(req, resp);
    }

    // ---------------------- CREAR / EDITAR ----------------------
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idStr = request.getParameter("idVehiculo"); // viene vacío si es nuevo
        String matricula = request.getParameter("matricula");
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        int anio = Integer.parseInt(request.getParameter("anio"));
        int idProp = Integer.parseInt(request.getParameter("idPropietario"));

        Vehiculo v = new Vehiculo();
        v.setMatricula(matricula);
        v.setMarca(marca);
        v.setModelo(modelo);
        v.setAnio(anio);
        v.setIdPropietario(idProp);

        if (idStr == null || idStr.isEmpty()) {
            // Crear nuevo
            dao.agregar(v);
        } else {
            // Editar existente
            v.setIdVehiculo(Integer.parseInt(idStr));
            dao.editar(v);
        }

        response.sendRedirect("VehiculoController?accion=listar");
    }
}
