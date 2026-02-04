package com.MavenEjercicios.controller;

import java.io.IOException;
import java.util.List;

import com.MavenEjercicios.dao.PropietarioDAO;
import com.MavenEjercicios.model.Propietario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/PropietarioController")
public class PropietarioController extends HttpServlet {

    PropietarioDAO dao = new PropietarioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
                request.getRequestDispatcher("form-propietario.jsp").forward(request, response);
                break;

            case "editar":
                cargarFormularioEdicion(request, response);
                break;

            case "eliminar":
                eliminar(request, response);
                break;

            default:
                listar(request, response);
        }
    }

    // ---------------------- LISTAR ----------------------
    private void listar(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Propietario> lista = dao.listar();
        req.setAttribute("propietarios", lista);
        req.getRequestDispatcher("lista-propietarios.jsp").forward(req, resp);
    }

    // ---------------------- ELIMINAR ----------------------
    private void eliminar(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        int id = Integer.parseInt(req.getParameter("id"));
        dao.eliminar(id);
        listar(req, resp);
    }

    // ---------------------- CARGAR FORMULARIO EDICIÓN ----------------------
    private void cargarFormularioEdicion(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        Propietario p = dao.listarPorId(id);

        req.setAttribute("propietario", p);
        req.getRequestDispatcher("form-propietario.jsp").forward(req, resp);
    }

    // ---------------------- CREAR / EDITAR ----------------------
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("idPropietario");
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");

        Propietario p = new Propietario();
        p.setNombre(nombre);
        p.setTelefono(telefono);
        p.setDireccion(direccion);

        if (idStr == null || idStr.isEmpty()) {
            // Crear nuevo
            dao.agregar(p);
        } else {
            // Editar existente
            p.setIdPropietario(Integer.parseInt(idStr));
            dao.editar(p);
        }

        response.sendRedirect("PropietarioController?accion=listar");
    }
}
