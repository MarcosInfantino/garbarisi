package dominio;

public class Producto {
    private String descripcion;
    private Double precio;
    private TipoDeProducto tipo;

    public Double precioFinal(){
        return this.precio+this.tipo.totalImpuestosPara(this);
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public TipoDeProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeProducto tipo) {
        this.tipo = tipo;
    }

    public Producto(String descripcion, Double precio, TipoDeProducto tipo) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
    }
}
