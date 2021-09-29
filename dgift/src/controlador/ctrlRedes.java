/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
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
    
    

    public ctrlRedes(fMaestrosMarco f) throws SQLException {
        this.frm = f;
        this.frm.btnCancelarRedes.addActionListener(this);
        this.frm.btnEditarRedes.addActionListener(this);
        this.frm.btnGuardarRedes.addActionListener(this);
        this.frm.btnSalirRedes.addActionListener(this);
        this.frm.btnBusquedaRedes.addActionListener(this);
        this.frm.grRedes.setRowSelectionAllowed(true);
        this.frm.grRedes.setColumnSelectionAllowed(false); 
        this.frm.txtIdRrss.setVisible(false);
        red.setNombre_red(frm.txtBusquedaRedes.getText());
        listarBusq(frm.grRedes,red);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()== frm.btnGuardarRedes){
      red.setNombre_red(frm.txtRed.getText());
      red.setEs_activo((frm.chkActivoRedes.isSelected())?1:0);
      
          try {
              if(redC.registar(red)){
                  limpiarPantalla();
                  Toolkit.getDefaultToolkit().beep();
                  JOptionPane.showMessageDialog(null, "Registro Guardado Exitosamente");
                  frm.txtBusquedaRedes.setText(null);
                  red.setNombre_red(frm.txtBusquedaRedes.getText());
                  listarBusq(frm.grRedes,red);
              }else{
                  Toolkit.getDefaultToolkit().beep();
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
                  Toolkit.getDefaultToolkit().beep();
                  JOptionPane.showMessageDialog(null, "Registro Editado Exitosamente");
                  red.setId_rrss(Integer.parseInt(frm.txtIdRrss.getText()));
                  listarBusq(frm.grRedes,red);
                  limpiarPantalla();
              }else{
                  Toolkit.getDefaultToolkit().beep();
                  JOptionPane.showMessageDialog(null, "Error al Editar");           
              } } catch (SQLException ex) {
              Logger.getLogger(ctrlRedes.class.getName()).log(Level.SEVERE, null, ex);
          }
       } 
       
       if(e.getSource()== frm.btnBusquedaRedes){
       
       red.setNombre_red(frm.txtBusquedaRedes.getText());
          try {
              
              listarBusq(frm.grRedes,red);
               } catch (SQLException ex) {
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
    
   /* public void listarP (JTable listRedes){
        
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
        
    }*/
    
    
     public void listarBusq (JTable listRedes,redes red) throws SQLException{
        
        modeloRed=(DefaultTableModel)listRedes.getModel();
        modeloRed.getDataVector().removeAllElements();
        modeloRed.fireTableDataChanged();
        
        List<redes>lista= redC.buscar(red);
        Object[]object = new Object[3];
        int i;
        if (lista.size()==0){
        Toolkit.getDefaultToolkit().beep(); 
        JOptionPane.showMessageDialog(null, "No se encontraron Registros Asociados a su busqueda","Aviso", JOptionPane.WARNING_MESSAGE);
         
        }
        for(i=0;i<lista.size();i++){
         object[0]= lista.get(i).getId_rrss();
         object[1]= lista.get(i).getNombre_red();
         object[2]= (lista.get(i).getEs_activo()==1)?Boolean.TRUE:Boolean.FALSE;
         modeloRed.addRow(object);
        }
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        frm.grRedes.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        frm.grRedes.setModel(modeloRed);
        
    }
    
    
}
