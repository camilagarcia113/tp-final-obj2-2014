package ventas;

import java.util.List;

import productos.Articulo;
import sistema.Cliente;

public abstract class Venta {
	
	private List<Articulo> articulos;
	private Cliente cliente;
	
	/**
	 * Crea una instancia de venta.
	 * @param unaListaDeArticulos: una lista de objetos que implementen la interfaz
	 *        Articulo.
	 * @param unCliente: una instancia de Cliente.
	 */
	protected Venta(List<Articulo> unaListaDeArticulos, Cliente unCliente){
		articulos = unaListaDeArticulos;
		cliente = unCliente;
	}
	
	/**
	 * Retorna la suma de los precios de los art�culos de la venta.
	 * @return Double.
	 */
	public Double getMonto(){
		Double montoFinal = 0d;
		for(Articulo articulo : articulos){
			montoFinal += articulo.getPrecio();
		}
		return montoFinal;
	}
	
	/**
	 * Retorna la ganancia producto de las ventas concretadas.
	 * El precio total de la venta - el precio de costo.
	 * @return
	 */
	public float getGanancia(){
		Float montoFinal = 0f;
		for(Articulo articulo : articulos)
			montoFinal += (articulo.getPrecio()-articulo.getPrecioCompra());
		return montoFinal;
	}
	/**
	 * Retorna el cliente que hizo la compra.
	 * @return Cliente.
	 */
	public Cliente getCliente(){
		return cliente;
	}
	
	/**
	 * Retorna la lista de art�culos comprados.
	 * @return List<Articulo>.
	 */
	public List<Articulo> getDetalle(){
		return articulos;
	}

	/**
	 * Retorna si esta venta fue realizada por el Cliente unCliente
	 * @param unCliente
	 * @return boolean
	 */
	public boolean fueCompradaPor(Cliente unCliente) {
		return unCliente.equals(this.cliente);
	}

}
