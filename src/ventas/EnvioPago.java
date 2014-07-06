package ventas;

import productos.Articulo;

public class EnvioPago extends EstadoEnvio {

	public EnvioPago(EntregaADomicilio unEnvio) {
		super(unEnvio);
	}

	@Override
	public void enviar() throws EnvioCanceladoException, Exception {
		throw new EntregaPagaException("El envio ya fue pagado por el cliente");
	}

	@Override
	public void cancelar() throws EnvioCanceladoException, EntregaPagaException {
		throw new EntregaPagaException("El envio ya fue pagado por el cliente");
	}

	@Override
	public void reprogramar() throws EnvioCanceladoException, Exception {
		throw new EntregaPagaException("El envio ya fue pagado por el cliente");
	}
	
	@Override
	public float getGananciaDeVenta() {
		float ganancia = 0f;
		for(Articulo articulo : this.getEntregaADomicilio().getDetalle())
			ganancia += articulo.getGanancia();
		return ganancia;
	}

}