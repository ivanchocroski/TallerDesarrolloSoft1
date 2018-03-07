/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.connection;

import com.demo.connection.modelo.Empleado;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author E201
 */
public class conexionbd {
    
     private static String url="jdbc:postgresql://localhost:3306/demo";
     private static String user="root";
    private static String password="estudiante";
    
    private static Connection con=null;
    //metodo para la coneccion de la base de datos
    public static void connect() throws ClassNotFoundException, SQLException{
        Class.forName("org.posgresql.Driver");
        con=DriverManager.getConnection(url, user, password);
    }
    //metodo para agregar un empleado a la base de datos
    public static void insertarEmpleados(Empleado en) throws ClassNotFoundException, SQLException{
        connect();
        
        PreparedStatement pst= con.prepareStatement(" insert to into " + "empleado values(?,?,?,?,? )");
        pst.setInt(1,en.getId());
        pst.setString(2,en.getNombre());
        pst.setDouble(3,en.getSalario());
        pst.setDate(4, (Date) en.getFechadeIngreso());
        pst.setInt(5,en.getIdDepto());
        con.close();
        pst.close();
        
    }
    //metodo para actualizar
    public static void actualizarEmpleados(Empleado en) throws ClassNotFoundException, SQLException{
        connect();
        PreparedStatement pst = con.prepareStatement("Update contactos set id dpto=?, "
                + "nombre=?, salario=?, fecha de ingreso=?,where id=?");
        
        pst.setInt(5,en.getId());
        pst.setInt(1,en.getIdDepto());
        pst.setString(2,en.getNombre());
        pst.setDouble(3,en.getSalario());
        pst.setDate(4, (Date) en.getFechadeIngreso());
    }
    //metodo para borrar
    public static void borrarEmpleados(Empleado en) throws ClassNotFoundException, SQLException{
        connect();
        PreparedStatement pst=con.prepareStatement("delete from empleado where nombre ");
        pst.setString(1,en.getNombre() );
    }
    //metodo para ver los contactos de la lista
    public static List<Empleado>lista() throws ClassNotFoundException, SQLException{
        connect();
       List<Empleado> listaEmpleado=new  ArrayList<>();
        PreparedStatement pst = con.prepareStatement("Select * from contactos ");
        ResultSet rst = pst.executeQuery();
        while(rst.next()){
           Empleado e=new Empleado(rst.getInt(1), rst.getString(2),
                    rst.getDouble(3), rst.getDate(4),rst.getInt(5));
            listaEmpleado.add(e);
        }
        con.close();
        pst.close();
         return listaEmpleado;
        
        
    }
    
    
   
    
}
