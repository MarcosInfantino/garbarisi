package dominio;

public class Eo implements ImpuestoAplicable{
    private Double factorGananciaImpositiva;
    private Double factorPrecioBase;
    private Double gananciasImpositivas;
    public Double calculate(Double precioBase){
        return (factorPrecioBase*precioBase)/(factorGananciaImpositiva*gananciasImpositivas);
    }

    public Eo(Double factorGananciaImpositiva, Double factorPrecioBase, Double gananciasImpositivas) {
        this.factorGananciaImpositiva = factorGananciaImpositiva;
        this.factorPrecioBase = factorPrecioBase;
        this.gananciasImpositivas = gananciasImpositivas;
    }
}
