package dominio;
import java.util.*;
public class TipoDeProducto {
    private String descripcion;
    private List<ImpuestoAplicable> impuestos=new ArrayList<ImpuestoAplicable>();
    void agregarImpuestoAplicable(ImpuestoAplicable impuesto){
        impuestos.add(impuesto);
    }

    Double totalImpuestosPara(Producto producto){
        return impuestos.stream().mapToDouble(impuesto->impuesto.calculate(producto.getPrecio())).sum();
    }

    public TipoDeProducto(String descripcion) {
        this.descripcion = descripcion;

    }
    public void agregarImpuesto(ImpuestoAplicable impuesto){
        impuestos.add(impuesto);
    }

}
