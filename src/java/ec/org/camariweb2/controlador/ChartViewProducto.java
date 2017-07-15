package ec.org.camariweb2.controlador;

import ec.org.camariweb2.funciones.crudProducto;
//import static ec.org.camariWeb.dalc.crudCliente.findbyAll;
import ec.org.camariweb2.entidades.clsProducto;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
//import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.PieChartModel;

@Named("ChartViewProducto")
@ViewScoped
public class ChartViewProducto  implements Serializable{
    
 private PieChartModel pieModel2;
 
 @PostConstruct
    public void init() {
        createPieModels();
    }
    
      public PieChartModel getPieModel2() {
        return pieModel2;
    }

    private void createPieModels() {
        createPieModel2();
    }
    
    
     private void createPieModel2() {
//        pieModel2 = new PieChartModel();
//
//        pieModel2.set("Brand 1", 540);
//        pieModel2.set("Brand 2", 325);
//        pieModel2.set("Brand 3", 702);
//        pieModel2.set("Brand 4", 421);
//
//        pieModel2.setTitle("Custom Pie");
//        pieModel2.setLegendPosition("e");
//        pieModel2.setFill(false);
//        pieModel2.setShowDataLabels(true);
//        pieModel2.setDiameter(150);
    }
    
    
     public void listar() {
        crudProducto pro;
        List<clsProducto>lista;

        try {
            pro = new crudProducto();
            lista = pro.findbyAll();
            graficar(lista);
        } catch (Exception e) {
            //Logica de excepcion y/o mensajes de error
        } finally {
            //Logica de cierre
        }
    }

    
    private void graficar(List<clsProducto> lista) {

        pieModel2 = new PieChartModel();

        for (clsProducto pro : lista) {
            pieModel2.set(pro.getNombre(), pro.getStock());
        }
        pieModel2.setTitle("Producto");
        pieModel2.setLegendPosition("e");
        pieModel2.setFill(false);
        pieModel2.setShowDataLabels(true);
        pieModel2.setDiameter(300);
    } 
    
    

}
