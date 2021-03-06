package algo3.algocity.controlador;

import java.util.Observable;
import java.util.Observer;

import algo3.algocity.modelo.Juego;
import algo3.algocity.vista.EstadoJuego;

public class ControladorEstadoJuego implements Observer {

	private EstadoJuego estadoJuego;

	public ControladorEstadoJuego(EstadoJuego estadoJuego) {
		this.estadoJuego = estadoJuego;
	}

	@Override
	public void update(Observable observable, Object arg) {
		Juego juego = (Juego) observable;
		estadoJuego.actualizarDia(juego.getTurno());
		estadoJuego.actualizarDinero(juego.getDinero());
		estadoJuego.actualizarJugador(juego.getJugador());
		estadoJuego.actualizarPoblacion(juego.getCiudadanos());
	}

	public EstadoJuego getEstadoJuego() {
		return estadoJuego;
	}

}
