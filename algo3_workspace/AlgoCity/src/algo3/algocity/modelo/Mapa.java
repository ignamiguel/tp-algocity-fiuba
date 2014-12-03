package algo3.algocity.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//import java.util.ArrayList;
//import java.util.Iterator;

public class Mapa {

	private Hectarea area[][];
	private int tamanio;

	ArrayList<Coordenada> pozos;

	// para hacer el refresh de cada turno recorre la lista y le dice a cada
	// linea actualizate,Pablo
	// La linea de tension ahora esta en las hectareas en la lista de
	// conecciones
	// private ArrayList<LineaDeTension> lineasDelMapa;

	public Mapa(IGeneradorDeMapa generadorDeMapa) {

		this.tamanio = generadorDeMapa.obtenerTamanio();
		this.area = new Hectarea[tamanio][tamanio];
		this.pozos = new ArrayList<Coordenada>();

		generadorDeMapa.generarArea(this.area);

	}

	public Hectarea obtenerHectarea(Coordenada coordenada) {
		if (!this.esValida(coordenada)) {
			throw new CoordenadaInvalidaExcepcion();
		}
		return area[coordenada.obtenerX()][coordenada.obtenerY()];
	}

	public boolean construir(Construccion construccion, Coordenada coordenada) {
		Hectarea hectarea = this.obtenerHectarea(coordenada);
		return hectarea.construir(construccion);
	}

	public boolean estaEnElMapaCoordenada(Coordenada coord) {
		int coorX = coord.obtenerX();
		int coorY = coord.obtenerY();
		if ((coorX >= 0) & (coorX < tamanio) & (coorY >= 0) & (coorY < tamanio))
			return true;
		else
			return false;
	}

	public int obtenerTamanio() {
		return this.tamanio;
	}

	public boolean conectar(Conexion conexion, Coordenada ubicacion) {
		Hectarea hectarea = this.obtenerHectarea(ubicacion);
		return hectarea.conectar(conexion);

	}

	public boolean construir(PozoDeAgua pozo, Coordenada coordenada) {
		if (!this.construir(pozo, coordenada)) {
			return false;
		}
		this.pozos.add(coordenada);
		return true;
	}

	public void propagarAgua() {
		
		ArrayList<Hectarea> superficie = this.obtenerSuperficiePropagable(pozos.get(0), new PozoDeAgua());

		for (Hectarea hectarea : superficie) {
			//hectarea.propagar();
		}
		
	}

	private ArrayList<Hectarea> obtenerSuperficiePropagable(Coordenada origen,
			IPropagable servicio) {

		Set<Hectarea> visitadas = new HashSet<Hectarea>();
		visitadas.add(this.obtenerHectarea(origen));
		Coordenada posicion = origen.copiar();
		return this.buscarHectareas(posicion, servicio, visitadas);

	}

	private ArrayList<Hectarea> buscarHectareas(Coordenada posicion,
			IPropagable servicio, Set<Hectarea> visitadas) {
		
		ArrayList<Hectarea> superficie = new ArrayList<Hectarea>();		

		if (this.esValida(posicion.moverArriba())) {
			Hectarea h = this.obtenerHectarea(posicion);
			if (!visitadas.contains(h)) {
				visitadas.add(h);

				if (h.tieneConexion(servicio.obtenerConexionNecesaria())) {
					superficie.add(h);
					superficie.addAll(this.buscarHectareas(posicion, servicio, visitadas));
				}
			}
		}
		posicion.moverAbajo();

		if (this.esValida(posicion.moverAbajo())) {
			Hectarea h = this.obtenerHectarea(posicion);
			if (!visitadas.contains(h)) {
				visitadas.add(h);

				if (h.tieneConexion(servicio.obtenerConexionNecesaria())) {
					superficie.add(h);
					superficie.addAll(this.buscarHectareas(posicion, servicio, visitadas));
				}
			}
		}
		posicion.moverArriba();

		if (this.esValida(posicion.moverDerecha())) {
			Hectarea h = this.obtenerHectarea(posicion);
			if (!visitadas.contains(h)) {
				visitadas.add(h);

				if (h.tieneConexion(servicio.obtenerConexionNecesaria())) {
					superficie.add(h);
					superficie.addAll(this.buscarHectareas(posicion, servicio, visitadas));
				}
			}
		}
		posicion.moverIzquierda();

		if (this.esValida(posicion.moverIzquierda())) {
			Hectarea h = this.obtenerHectarea(posicion);
			if (!visitadas.contains(h)) {
				visitadas.add(h);

				if (h.tieneConexion(servicio.obtenerConexionNecesaria())) {
					superficie.add(h);
					superficie.addAll(this.buscarHectareas(posicion, servicio, visitadas));
				}
			}
		}
		posicion.moverDerecha();

		return superficie;
	}

	public boolean esValida(Coordenada coordenada) {
		if (coordenada.x < 0 || coordenada.y < 0)
			return false;
		if (coordenada.x >= this.tamanio || coordenada.y >= this.tamanio)
			return false;
		return true;
	}

}
