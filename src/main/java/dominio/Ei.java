package dominio;

public class Ei implements ImpuestoAplicable{
    private Double factorGananciasImpositivas;
    private Double factorPrecioBase;
    private Double gananciasImpositivas;
    public Double calculate(Double precioBase){
        return precioBase/factorPrecioBase+factorGananciasImpositivas*gananciasImpositivas;
    }

    public Ei(Double factorGananciasImpositivas, Double factorPrecioBase, Double gananciasImpositivas) {
        this.factorGananciasImpositivas = factorGananciasImpositivas;
        this.factorPrecioBase = factorPrecioBase;
        this.gananciasImpositivas = gananciasImpositivas;
    }
}
