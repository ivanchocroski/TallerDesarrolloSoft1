<%-- 
    Document   : Vista
    Created on : 6/03/2018, 01:57:28 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <script src="..//js/jquery-1.7.2.min.js"></script>
        <script src="..//js/spin.min.js"></script>
        
        <script>
           $(document).ready(function(){
               $("#btn").click(function(e){
                   $.ajax({
                       url: './demo',
                       type: 'post',
                       data: $("#formE").serialize(),
                       success:function(rea,iv,ol){
                           alert("perfecto")
                       },
                       error:function(err,status){
                           alert(status)
                       }
                   })
               })
           })
        </script>
         <script>
            function validaForm(){
                //aqui validaremos los campos de texto que tenga el formulario
                if($("#nombre").val()== ""){
                    alert("tiene que llenar el campo nombre")
                    $("#nombre").focus();
                    return false;
                }
                if($("#salario").val()== ""){
                    alert("tiene que llenar el campo salario")
                    $("#salario").focus();
                    return false;
                }
                if($("#fechadeIngreso").val()== ""){
                    alert("tiene que llenar el campo fecha de ingreso")
                    $("#fechadeIngreso").focus();
                    return false;
                }
                if($("#idDepto").val()== ""){
                    alert ("tiene que llenar el campo del id del departamento")
                    $("#idDepto").focus();
                    return false;
                }
                
            }
        </script>
    </head>
    <body>
        <form action="/EmpleadoServlet" method="post" name="formE">
            <table>
                <tr>
                    <td>id:</td>
                    <input type="number" name="id">
                </tr>
                <tr>
                    <td>Nombre:</td>
                <input type="text" name="nombre" placeholder="Nombre" requiered>
                </tr>
                <tr>
                    <td>Salario:</td>
                <input type="number" name="salario" placeholder="Salario" required>
                </tr>
                <tr>
                    <td>Fecha de ingreso:</td>
                <input type="date" name="fechadeIngreso" placeholder="Fecha de ingreso" required>
                </tr>
                <tr>
                    <td>Id del departamento:</td>
                <input type="number" name="idDepto" placeholder="Id del departamento" required>
                </tr>
                <input type="submit" value="enviar" name="btn">
            </table>
        </form>
    </body>
</html>
