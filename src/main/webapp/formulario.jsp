<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Formulario</title>
</head>
<body>
    <h1>Pet Smile</h1>

    <form action="ServletServlet" method="post">
    <input type="hidden" name="accion" value="agregarDueno">
        <fieldset>
            <legend>Datos del Propietario:</legend>
            <label for="rut">Rut: </label><input type="text" id="rut" name="rut" required>
            <label for="nombre">Nombre: </label><input type="text" id="nombre" name="nombre" required>
            <label for="apellido">Apellido: </label><input type="text" id="apellido" name="apellido" required>
            <label for="direccion">Direccion: </label><input type="text" id="direccion" name="direccion" required>
            <label for="correo">Correo: </label><input type="text" id="correo" name="correo" required>
            <label for="telefono">Telefono: </label><input type="text" id="telefono" name="telefono" required>
            <input type="submit" id="btnregistrarDueno" value="Registrar">
			<%
			String mensaje = (String) session.getAttribute("mensaje");
			if (mensaje != null) {
			%>
			<div class="exito"><%=mensaje%></div>
			<%
			session.removeAttribute("mensaje"); // Eliminar el mensaje después de mostrarlo
			}
			%>
		</fieldset>
    </form>

    <hr>

    <form action="ServletServlet" method="post">
    <input type="hidden" name="accion" value="agregarMascota">
        <fieldset>
            <legend>Datos de la mascota:</legend>
            <label for="nombreM">Nombre: </label><input type="text" id="nombreM" name="nombreM" required>
            <label for="edad">Edad: </label><input type="number" id="edad" name="edad" required>
            <label for="tipo">Tipo: </label><input type="text" id="tipo" name="tipo" required>
            <input type="submit" id="btnIngresarMascota" value="Registrar">
            <%
			String mensaje2 = (String) session.getAttribute("mensaje2");
			if (mensaje2 != null) {
			%>
			<div class="exito"><%=mensaje2%></div>
			<%
			session.removeAttribute("mensaje2"); // Eliminar el mensaje después de mostrarlo
			}
			%>
        </fieldset>
    </form>

    <hr>

    <form action="ServletServlet" method="post">
    <input type="hidden" name="accion" value="agregarAgenda">
        <fieldset>
            <legend>Agenda:</legend>
            <label for="hora">Hora: </label><input type="time" id="hora" name="hora" required>
            <label for="fecha">Fecha: </label><input type="date" id="fecha" name="fecha" required>
            <input type="submit" id="btnIngresarAgenda" value="Registrar">
            <%
			String mensaje3 = (String) session.getAttribute("mensaje3");
			if (mensaje3 != null) {
			%>
			<div class="exito"><%=mensaje3%></div>
			<%
			session.removeAttribute("mensaje3"); // Eliminar el mensaje después de mostrarlo
			}
			%>
        </fieldset>
    </form>
</body>
</html>
