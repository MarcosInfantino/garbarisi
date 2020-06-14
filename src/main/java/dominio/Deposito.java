package dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Deposito implements Observer{
    private List<ProductoEnStock> stock=new ArrayList<ProductoEnStock>();
    @Override
    public void notificarVentaDe(Producto p) {
        this.reducirStock(p.getDescripcion());
    }
    public void agregarProducto(Producto producto, int cantidad){
        stock.add(new ProductoEnStock(producto,cantidad));
    }
    
    private Optional<ProductoEnStock> encontrarProducto(String nombre){
        return stock.stream().filter(pro->(pro.getProducto().getDescripcion())==nombre).findFirst();

    }

    private void reducirStock(String descripcion){
        ProductoEnStock p=this.encontrarProducto(descripcion).get();
        p.setStock(p.getStock()-1);
    }

    public boolean hayStock(String descripcion){
        return this.encontrarProducto(descripcion).get().getStock()>0;
    }

    public int obtenerStockDe(Producto p){
        return this.encontrarProducto(p.getDescripcion()).get().getStock();
    }
     class ProductoEnStock{
        public Producto producto;
        public int stock;

        public Producto getProducto() {
            return producto;
        }

        public void setProducto(Producto producto) {
            this.producto = producto;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public ProductoEnStock(Producto producto, int stock) {
            this.producto = producto;
            this.stock = stock;
        }
    }
}
