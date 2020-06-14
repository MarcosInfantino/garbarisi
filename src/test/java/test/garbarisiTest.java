package test;


import dominio.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class garbarisiTest {
    private Iva iva=new Iva(0.21);
    private final Ei ei=new Ei(3.5,4.0,0.3);
    private final Eo eo= new Eo(4.0,0.5,4.0);
    private TipoDeProducto productoElectronico=new TipoDeProducto("Electronico");
    private TipoDeProducto productoHogar=new TipoDeProducto("Hogar");

    private Deposito deposito=new Deposito();
    private Producto lavarropas=new Producto("Lavarropas",5000.0, productoHogar);
    private Producto play4=new Producto("PS4",20000.0, productoElectronico);
    private Producto pc=new Producto("PC",15000.0, productoElectronico);
    private Sucursal sucursal=new Sucursal("Sucursal 1",deposito);
    private OficinaContable oficinaContable=new OficinaContable();
    private ContadorDeVentas contadorDeVentas= new ContadorDeVentas();
    @Before
    public void inicio() throws SinStockException {
        productoElectronico.agregarImpuesto(iva);
        productoElectronico.agregarImpuesto(eo);
        productoHogar.agregarImpuesto(iva);
        productoHogar.agregarImpuesto(ei);
        deposito.agregarProducto(lavarropas,5);
        deposito.agregarProducto(play4,5);
        deposito.agregarProducto(pc,5);
        sucursal.agregarObserver(oficinaContable);
        sucursal.agregarObserver(contadorDeVentas);
        sucursal.agregarObserver(deposito);
        sucursal.realizarVenta(play4);
        sucursal.realizarVenta(lavarropas);


    }
    @Test
    public void seIncrementanVentas(){
        Assert.assertTrue(contadorDeVentas.getCantidadDeVentas()==2);
    }
    @Test
    public void seIncrementaLibroDiario(){
        Assert.assertTrue(oficinaContable.getTotalLibroDiario()== play4.precioFinal()+lavarropas.precioFinal());
    }
    @Test
    public void precioFinalPs4(){
        Assert.assertTrue(play4.precioFinal()==24825.0);
    }
    @Test
    public void precioFinalLavarropas(){
        Assert.assertTrue(lavarropas.precioFinal()==7301.05);
    }
    @Test
    public void seDisminuyoElStockPs4(){
        Assert.assertTrue(deposito.obtenerStockDe(play4)==4);

    }
    @Test
    public void seDisminuyoElStockLavarropas(){
        Assert.assertTrue(deposito.obtenerStockDe(lavarropas)==4);

    }
}
