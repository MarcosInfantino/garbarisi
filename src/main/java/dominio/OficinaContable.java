package dominio;

public class OficinaContable implements Observer{
    private Double totalLibroDiario=0.0;

    @Override
    public void notificarVentaDe(Producto p) {
        this.totalLibroDiario+=p.precioFinal();
    }

    public Double getTotalLibroDiario() {
        return totalLibroDiario;
    }

    public void setTotalLibroDiario(Double totalLibroDiario) {
        this.totalLibroDiario = totalLibroDiario;
    }
}
