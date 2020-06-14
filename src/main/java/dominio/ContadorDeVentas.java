package dominio;

public class ContadorDeVentas implements Observer{
    private int cantidadDeVentas=0;


    @Override
    public void notificarVentaDe(Producto p) {
        cantidadDeVentas++;
    }


    public Integer getCantidadDeVentas() {
        return cantidadDeVentas;
    }

    public void setCantidadDeVentas(int cantidadDeVentas) {
        this.cantidadDeVentas = cantidadDeVentas;
    }
}
