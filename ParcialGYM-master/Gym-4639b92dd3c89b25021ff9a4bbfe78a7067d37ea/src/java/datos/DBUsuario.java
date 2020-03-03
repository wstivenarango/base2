/*
 * DBContactos.java
 * 
 * Created on 7/04/2008, 10:26:02 PM
 */
package datos;

import java.sql.*;
import Logica.Usuario;

public class DBUsuario {

    DBConexion cn;

    public DBUsuario() {
        cn = new DBConexion();
    }

    public ResultSet getUsuarioById(int id) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT con_id, "
                + " con_nombre, "
                + " con_peso, "
                + " con_edad, "
                + " con_estatura,");
        pstm.setInt(1, id);

        ResultSet res = pstm.executeQuery();
        /*
         res.close();	
         */

        return res;
    }

    /**
     * trae todos los registros de la tabla contactos
     */
    public ResultSet getUsuarios() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT con_id, "
                + " con_nombre, "
                + " con_peso, "
                + " con_edad, "
                + " con_estatura,");

        ResultSet res = pstm.executeQuery();
        return res;
    }

    public void insertarUsuario(Usuario c) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into usuario (us_nombre, "
                    + " us_nombre, "
                    + " us_peso, "
                    + " us_edad, "
                    + " us_estatura,");
            pstm.setString(1, c.getNombre());
            pstm.setFloat(2, c.getPeso());
            pstm.setFloat(3, c.getEdad());
            pstm.setFloat(4, c.getEstatura());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }



    public String getMensaje() {
        return cn.getMensaje();
    }
}
