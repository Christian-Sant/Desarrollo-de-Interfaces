<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Taller</title>
</head>
<body>
    <h1>Taller Mecánico</h1>
    <h3>Sistema de Gestión de Vehículos</h3>
    <ul>
        <li><a href="VehiculoController?accion=listar">Gestión de Vehículos</a></li>
        <li><a href="PropietarioController?accion=listar">Gestión de Propietarios</a></li>
        <li><a href="VehiculoController?accion=dashboard">Dashboard y Estadísticas</a></li>
    </ul>
</body>
</html>