<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
    <h1>Panel de Control</h1>
    
    <div class="card">
        <h3>Total de Vehículos Registrados: ${total}</h3>
    </div>

    <h3>Top 5 Vehículos más antiguos</h3>
    <ul>
        <c:forEach var="v" items="${antiguos}">
            <li>${v.marca} ${v.modelo} - Año: <b>${v.anio}</b></li>
        </c:forEach>
    </ul>
    
    <a href="VehiculoController?accion=listar">Volver al listado</a>
</body>
</html>