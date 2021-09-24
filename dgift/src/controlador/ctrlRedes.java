/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.consultasRedes;
import modelo.redes;
import vista.fMaestros;
        

/**
 *
 * @author Marco Bonilla
 */
public class ctrlRedes implements ActionListener{
    
    private redes red = new redes();
    private consultasRedes redC = new consultasRedes();
    private fMaestros frm = new fMaestros();
    DefaultTableModel modeloRed;
    
    

    public ctrlRedes(fMaestros f) {
      this.frm = f;
        this.frm.btnCancelarRedes.addActionListener(this);
        this.frm.btnEditarRedes.addActionListener(this);
        this.frm.btnGuardarRedes.addActionListener(this);
        this.frm.btnSalirRedes.addActionListener(this);
        this.frm.comboRedes.addActionListener(this);
        this.frm.txtRed.addActionListener(this);
        listarP(frm.listRedes);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
      
    }
    
    public void listarP (JTable listRedes){
        
        modeloRed=(DefaultTableModel)listRedes.getModel();
        List<redes>lista= redC.listar();
        Object[]object = new Object[3];
        int i;
        for(i=0;i<lista.size();i++){
         object[0]= lista.get(i).getId_rrss();
         object[1]= lista.get(i).getNombre_red();
         object[2]= (lista.get(i).getEs_activo()==1)?Boolean.TRUE:Boolean.FALSE;
         modeloRed.addRow(object);
        }
        frm.listRedes.setModel(modeloRed);
    }
    
    
}
