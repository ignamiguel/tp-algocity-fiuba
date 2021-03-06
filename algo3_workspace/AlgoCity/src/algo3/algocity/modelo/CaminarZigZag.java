package algo3.algocity.modelo;

import java.util.Random;

public class CaminarZigZag implements ICaminable {

	@Override
	public void caminarMapa(Godzilla godzilla, Mapa mapa) {
		Hectarea hectarea;
		while ((godzilla.obtenerCoordenada()).obtenerY() < mapa.getTamanio()) {
			
			hectarea = mapa.getHectarea(godzilla.obtenerCoordenada());
			hectarea.afectarCon(godzilla);
			godzilla.avanzarEnY();
			godzilla.retrocederEnX();
			
			
			if((godzilla.obtenerCoordenada()).obtenerY() < mapa.getTamanio()){
				hectarea = mapa.getHectarea(godzilla.obtenerCoordenada());
				hectarea.afectarCon(godzilla);
				godzilla.avanzarEnY();
				godzilla.avanzarEnX();
			}
			
			if((godzilla.obtenerCoordenada()).obtenerY() < mapa.getTamanio()){
				hectarea = mapa.getHectarea(godzilla.obtenerCoordenada());
				hectarea.afectarCon(godzilla);
				godzilla.avanzarEnY();
				godzilla.avanzarEnX();
			}
		}

	}

	public Coordenada generarCoordenadaAleatoria(Mapa mapa) {
		Random aleatorio = new Random();
		int coordX = 2 + aleatorio.nextInt(mapa.getTamanio() - 2);
		return new Coordenada(coordX,0);
	}
	
}