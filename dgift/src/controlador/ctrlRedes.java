/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.redesDAO;
import modelo.redes;
//import vista.fMaestros;
import vista.fMaestrosMarco;
        

/**
 *
 * @author Marco Bonilla
 */
public class ctrlRedes implements ActionListener{
    
    private redes red = new redes();
    private redesDAO redC = new redesDAO();
    private fMaestrosMarco frm = new fMaestrosMarco();
    DefaultTableModel modeloRed;
    
    

    public ctrlRedes(fMaestrosMarco f) {
      this.frm = f;
        this.frm.btnCancelarRedes.addActionListener(this);
        this.frm.btnEditarRedes.addActionListener(this);
        this.frm.btnGuardarRedes.addActionListener(this);
        this.frm.btnSalirRedes.addActionListener(this);
        this.frm.txtRed.addActionListener(this);
        this.frm.chkActivoRedes.addActionListener(this);
        this.frm.txtBusquedaRedes.addActionListener(this);
        this.frm.txtIdRrss.addActionListener(this);
        listarP(frm.grRedes);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()== frm.btnGuardarRedes){
      red.setNombre_red(frm.txtRed.getText());
      red.setEs_activo((frm.chkActivoRedes.isSelected())?1:0);
      
          try {
              if(redC.registar(red)){
                  limpiarPantalla();
                  JOptionPane.showMessageDialog(null, "Registro Guardado Exitosamente");
                  listarP(frm.grRedes);
              }else{
                  JOptionPane.showMessageDialog(null, "Error al guardar");           
              } } catch (SQLException ex) {
              Logger.getLogger(ctrlRedes.class.getName()).log(Level.SEVERE, null, ex);
          }
       }
      
       if(e.getSource()== frm.btnEditarRedes){
      red.setId_rrss(Integer.parseInt(frm.txtIdRrss.getText()));
      red.setNombre_red(frm.txtRed.getText());
      red.setEs_activo((frm.chkActivoRedes.isSelected())?1:0);
      
          try {
              if(redC.modificar(red)){
                  limpiarPantalla();
                  JOptionPane.showMessageDialog(null, "Registro Editado Exitosamente");
                  listarP(frm.grRedes);
              }else{
                  JOptionPane.showMessageDialog(null, "Error al Editar");           
              } } catch (SQLException ex) {
              Logger.getLogger(ctrlRedes.class.getName()).log(Level.SEVERE, null, ex);
          }
       } 
    }
    
    public void limpiarPantalla(){
        frm.txtIdRrss.setText(null);
        frm.txtRed.setText(null);
        frm.chkActivoRedes.setSelected(false);
        frm.btnCancelarRedes.setEnabled(false);
        frm.btnEditarRedes.setEnabled(false);
        frm.btnGuardarRedes.setEnabled(false);
    }
    
    public void listarP (JTable listRedes){
        
        modeloRed=(DefaultTableModel)listRedes.getModel();
        modeloRed.getDataVector().removeAllElements();
        modeloRed.fireTableDataChanged();
        
        List<redes>lista= redC.listar();
        Object[]object = new Object[3];
        int i;
        for(i=0;i<lista.size();i++){
         object[0]= lista.get(i).getId_rrss();
         object[1]= lista.get(i).getNombre_red();
         object[2]= (lista.get(i).getEs_activo()==1)?Boolean.TRUE:Boolean.FALSE;
         modeloRed.addRow(object);
        }
        frm.grRedes.setModel(modeloRed);
        
    }
    
    
}
