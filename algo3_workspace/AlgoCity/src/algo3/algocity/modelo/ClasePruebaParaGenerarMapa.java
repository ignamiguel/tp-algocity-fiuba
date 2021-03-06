package algo3.algocity.modelo;

//la uso para testear la creacion de lineas de tension en mapa, provisoria ,Pablo
public class ClasePruebaParaGenerarMapa implements IGeneradorDeMapa {

	private int tamanio;
	private Coordenada entradaALaCiudad;

	public ClasePruebaParaGenerarMapa() {
		tamanio = 5;
		entradaALaCiudad = new Coordenada(0,2);
	}

	public void generarArea(Hectarea[][] area) {

		for (int i = 0; i < tamanio; i++) {
			for (int j = 0; j < tamanio; j++) {

				area[i][j] = new Terreno();
			}
		}

	}

	public int obtenerTamanio() {

		return tamanio;
	}

	@Override
	public Coordenada obtenerEntradaALaCiudad() {
		return entradaALaCiudad;
	}

}
