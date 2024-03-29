package productos;

import java.util.List;

/**
 * Esta clase representa un paquete de ofertas, es decir un conjunto de
 * productos u otras ofertas a su vez. Cada paquete de ofertas tiene una lista
 * de ofertas conteniendo todos los productos ofertados.
 */
public class PaqueteDeOferta extends Oferta {

	private List<Articulo> articulos;

	public PaqueteDeOferta(List<Articulo> unaListaDeArticulos, float unDescuento) {
		super(unDescuento);
		this.articulos = unaListaDeArticulos;
	}

	/*
	 * @Override public float calcularPrecio() { float resultado = 0f; for
	 * (Articulo articulo : this.articulos) { resultado +=
	 * articulo.calcularPrecio();
	 * 
	 * } return (resultado*this.getDescuento()); }
	 */

	@Override
	public float getPrecio() {
		float resultado = 0f;
		for (Articulo articulo : this.articulos) {
			resultado += articulo.getPrecio();

		}
		return (resultado / this.getDescuento());
	}

	@Override
	public float getPrecioDeCompra() {
		float precioCompra = 0f;
		for (Articulo articulo : this.articulos)
			precioCompra += articulo.getPrecioDeCompra();
		return precioCompra;
	}

	public void agregarOferta(Oferta unaOferta) {
		this.articulos.add(unaOferta);
	}

	public List<Articulo> getOfertas() {
		return this.articulos;
	}

	@Override
	public void descontarStockDeVenta(int unaCantidadDeArticulos)
			throws ArticuloSinStockException {
		for (Articulo articulo : this.articulos)
			articulo.descontarStockDeVenta(unaCantidadDeArticulos);
	}

	@Override
	public void cancelarCompraDeArticulo() {
		for (Articulo articulo : this.articulos)
			articulo.cancelarCompraDeArticulo();
	}

	@Override
	public float getGanancia() {
		float ganancia = 0f;
		for (Articulo articulo : this.articulos)
			ganancia += articulo.getGanancia();
		return ganancia;
	}
}
