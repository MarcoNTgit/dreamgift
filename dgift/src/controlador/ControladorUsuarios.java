/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import modelo.Categorias;
import modelo.CategoriasDAO;
import modelo.Usuarios;
import modelo.UsuariosDAO;
import vista.fMaestros;

/**
 *
 * @author caarlos
 */
public class ControladorUsuarios implements ActionListener{
    UsuariosDAO dao = new UsuariosDAO();
    Usuarios a = new Usuarios();
    fMaestros fmae = new fMaestros();
    DefaultTableModel modelo = new DefaultTableModel();
       
    public ControladorUsuarios(fMaestros m){
        this.fmae = m;
        this.fmae.btnEditar.addActionListener(this);
        this.fmae.btnGuardar.addActionListener(this);
        this.fmae.btnAgregar.addActionListener(this);
   }

    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
