package dominio;

public class Iva implements ImpuestoAplicable{
    private Double factorPrecio;
    @Override
    public Double calculate(Double precio) {
        return factorPrecio* precio;
    }

    public Iva(Double factorPrecio) {
        this.factorPrecio = factorPrecio;
    }
}
