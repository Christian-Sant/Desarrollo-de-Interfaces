<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head><title>Listado de Vehículos</title></head>
<body>
    <h2>Gestión de Vehículos</h2>
    <a href="VehiculoController?accion=nuevo">Agregar Nuevo</a> | 
    <a href="VehiculoController?accion=dashboard">Ver Estadísticas</a>
    
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Marca</th>
                <th>Modelo</th>
                <th>Año</th>
                <th>Matrícula</th>
                <th>Propietario</th> <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="v" items="${vehiculos}">
                <tr>
                    <td>${v.id}</td>
                    <td>${v.marca}</td>
                    <td>${v.modelo}</td>
                    <td>${v.anio}</td>
                    <td>${v.matricula}</td>
                    <td>${v.nombrePropietarioAux}</td>
                    <td>
                        <a href="VehiculoController?accion=editar&id=${v.id}">Editar</a>
                        <a href="VehiculoController?accion=eliminar&id=${v.id}">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>