package dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Sucursal {
    private String nombre;
    private List<Observer> observers= new ArrayList<Observer>();
    private Deposito deposito;

    public void agregarObserver(Observer observer){
        observers.add(observer);
    }

    public void realizarVenta(Producto p) throws SinStockException {
        if(!deposito.hayStock(p.getDescripcion())){
            throw new SinStockException("El producto no esta en stock");
        }else{
            this.notificarVentaDe(p);
        }
    }

    private void notificarVentaDe(Producto producto){
        this.observers.forEach(ob->ob.notificarVentaDe(producto));
    }


    public Sucursal(String nombre, Deposito deposito) {
        this.nombre = nombre;
        this.deposito = deposito;
    }
}
