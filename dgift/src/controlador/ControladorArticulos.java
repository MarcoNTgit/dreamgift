/**
 * @author Carlos Thieme
 * fecha   13/09/2021
 * 
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ArticuloDAO;
import modelo.Articulos;
import vista.fMaestros;


public class ControladorArticulos implements WindowListener{

    ArticuloDAO dao = new ArticuloDAO();
    Articulos a = new Articulos();
    fMaestros fmae = new fMaestros();
    DefaultTableModel modelo = new DefaultTableModel();
       
    public ControladorArticulos(fMaestros m){
        this.fmae = m;
        this.fmae.addWindowListener(this);
    }
    
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource()==fmae.btnEditarArticulo) {
//            listar(fmae.grArticulos);
//        }
//    }
    public void listar(JTable grArticulos){
        modelo = (DefaultTableModel)grArticulos.getModel();
        List<Articulos>lista=dao.listar();
        Object[]object=new Object[6];
        for (int i = 0; i < lista.size(); i++){
            object[0]=lista.get(i).getIdArticulo();
            object[1]=lista.get(i).getNombreArticulo();
            object[2]=lista.get(i).getIdCategoria();
            object[3]=lista.get(i).getStockArticulo();
            object[4]=lista.get(i).getPrecioArticulo();
            object[5]=lista.get(i).getFechaVence();
            modelo.addRow(object);
        }
        fmae.grArticulos.setModel(modelo);
    }    

    @Override
    public void windowOpened(WindowEvent we) {
        
    }

    @Override
    public void windowClosing(WindowEvent we) {
        fmae.dispose();
        System.exit(0); 
    }

    @Override
    public void windowClosed(WindowEvent we) {
        
    }

    @Override
    public void windowIconified(WindowEvent we) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        
    }

    @Override
    public void windowActivated(WindowEvent we) {
        listar(fmae.grArticulos);
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
