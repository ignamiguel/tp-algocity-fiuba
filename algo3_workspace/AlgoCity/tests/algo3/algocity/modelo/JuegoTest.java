package algo3.algocity.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class JuegoTest {

	@Test
	public void crearUnJuego() {
		Juego juego = new Juego();

		assertNotNull("Instancia de un juego", juego);
	}

	@Test
	public void crearUnJuegoConMapaPlayaParaVerTerreno(){
		Juego juego = new Juego();
		
		String resultado = juego.getMapa().getHectarea(new Coordenada(0,0)).getEtiqueta();		
		
		assertEquals("Terreno", resultado);
	}
	
	@Test
	public void crearUnJuegoConMapaPlayaParaVerAgua(){
		Juego juego = new Juego();
		
		String resultado = juego.getMapa().getHectarea(new Coordenada(0,20)).getEtiqueta();		
		
		assertEquals("Agua", resultado);
	}
	
	@Test
	public void insertarUnaResidenciaEnJuego(){
		Juego juego = new Juego();
		
		Residencia casa = new Residencia();
		
		boolean resultado = juego.insertar(casa, new Coordenada(0, 0));
		
		assertEquals(true, resultado);
		
	}
	
	@Test
	public void insertarUnaCentralEolicaEnJuego(){
		Juego juego = new Juego();
		
		CentralEolica central = new CentralEolica();
		
		boolean resultado = juego.insertar(central, new Coordenada(0, 0));
		
		assertEquals(true, resultado);
		
	}

	@Test
	public void insertarUnPozoDeAguaEnJuego(){
		Juego juego = new Juego();
		
		PozoDeAgua pda = new PozoDeAgua();
		
		boolean resultado = juego.insertar(pda, new Coordenada(0, 20));
		
		assertEquals(true, resultado);
		
	}

	@Test
	public void insertarUnaEstacionDeBomberosEnJuego(){
		Juego juego = new Juego();
		
		EstacionDeBomberos edb = new EstacionDeBomberos();
		
		boolean resultado = juego.insertar(edb, new Coordenada(0, 0));
		
		assertEquals(true, resultado);
	}
	
	@Test
	public void crearUnJuegoConValoresIniciales(){
		Juego juego = new Juego();
		
		int dinero = juego.getDinero();
		
		assertEquals(100000, dinero);
		
	}

	@Test
	public void insertarUnaResidenciaEnJuegoCuesta5(){
		Juego juego = new Juego();
		
		Residencia casa = new Residencia();
		
		juego.insertar(casa, new Coordenada(0, 0));
		
		int dinero = juego.getDinero();
		
		assertEquals(99995, dinero);		
		
	}
	
	@Test
	public void insertarUnComercioEnJuegoCuesta5(){
		Juego juego = new Juego();
		
		Comercio comercio = new Comercio();
		
		juego.insertar(comercio, new Coordenada(0, 0));
		
		int dinero = juego.getDinero();
		
		assertEquals(99995, dinero);		
		
	}
	
	@Test
	public void insertarUnaIndustriaEnJuegoCuesta10(){
		Juego juego = new Juego();
		
		Industria industria = new Industria();
		
		juego.insertar(industria, new Coordenada(0, 0));
		
		int dinero = juego.getDinero();
		
		assertEquals(99990, dinero);		
		
	}
	
	@Test
	public void insertarUnaCentralEolicaEnJuegoCuesta1000(){
		Juego juego = new Juego();
		
		CentralEolica ce = new CentralEolica();
		
		juego.insertar(ce, new Coordenada(0, 0));
		
		int dinero = juego.getDinero();
		
		assertEquals(99000, dinero);		
		
	}
	
	@Test
	public void insertarUnaCentralMineralEnJuegoCuesta3000(){
		Juego juego = new Juego();
		
		CentralMineral cm = new CentralMineral();
		
		juego.insertar(cm, new Coordenada(0, 0));
		
		int dinero = juego.getDinero();
		
		assertEquals(97000, dinero);		
		
	}
	
	@Test
	public void insertarUnaCentralNuclearEnJuegoCuesta10000(){
		Juego juego = new Juego();
		
		CentralNuclear cn = new CentralNuclear();
		
		juego.insertar(cn, new Coordenada(0, 0));
		
		int dinero = juego.getDinero();
		
		assertEquals(90000, dinero);		
		
	}
	
	@Test
	public void insertarUnaEstacionDeBomberosEnJuegoCuesta1500(){
		Juego juego = new Juego();
		
		EstacionDeBomberos edb = new EstacionDeBomberos();
		
		juego.insertar(edb, new Coordenada(0, 0));
		
		int dinero = juego.getDinero();
		
		assertEquals(98500, dinero);
	}
	
	@Test
	public void insertarUnaRutaEnJuegoCuesta10(){
		Juego juego = new Juego();
		
		Ruta ruta = new Ruta();
		
		juego.insertar(ruta, new Coordenada(0, 0));
		
		int dinero = juego.getDinero();
		
		assertEquals(99990, dinero);
	}
	
	@Test
	public void insertarUnaTuberiaEnJuegoCuesta5(){
		Juego juego = new Juego();
		
		Tuberia tuberia = new Tuberia();
		
		assertEquals(true,juego.insertar(tuberia, new Coordenada(0, 0)));
		
		int dinero = juego.getDinero();
		
		assertEquals(99995, dinero);
	}
	
	@Test
	public void insertarUnaLineaDeTensionEnJuegoCuesta10(){
		Juego juego = new Juego();
		
		LineaDeTension ldt = new LineaDeTension();
		
		assertEquals(true,juego.insertar(ldt, new Coordenada(0, 0)));
		
		int dinero = juego.getDinero();
		
		assertEquals(99995, dinero);
	}
	
	@Test
	public void NoSePuedeinsertarUnaEstacionDeBomberosSiYaHabiaUnaEstacionEnLaHectarea(){
		Juego juego = new Juego();
		
		EstacionDeBomberos edb = new EstacionDeBomberos();
		
		juego.insertar(edb, new Coordenada(0, 0));
		
		int dinero = juego.getDinero();
		
		assertEquals(98500, dinero);
		
		assertEquals(false,juego.insertar(edb, new Coordenada(0, 0)));
	}
	
	@Test
	public void insertarUnaResidenciaAgregaALaHectareaALaListaDeResidencias(){
		Juego juego = new Juego();
		
		Residencia res = new Residencia();
		
		juego.insertar(res,new Coordenada(5,5));
		
		
		assertEquals(true,juego.getCoordenadasResidenciales().contains(new Coordenada(5,5)));
	}
	
	@Test
	public void insertarUnaIndustriaAgregaALaHectareaALaListaDeIndustrias(){
		Juego juego = new Juego();
		
		Industria ind = new Industria();
		
		Coordenada c = new Coordenada(5,5);
		
		juego.insertar(ind,c);
		
		assertEquals(true,juego.getCoordenadasIndustriales().contains(c));
	}
	
	@Test
	public void insertarUnComercioAgregaALaHectareaALaListaDeComercio(){
		Juego juego = new Juego();
		
		Comercio comercio = new Comercio();
		
		juego.insertar(comercio,new Coordenada(5,5));
		
		assertEquals(true,juego.getCoordenadasComerciales().contains(new Coordenada(5,5)));
	}
	
	@Test
	public void insertarTresResidenciaAgregaLasHectareaALaListaDeResidencias(){
		Juego juego = new Juego();
		
		Residencia res1 = new Residencia();
		Residencia res2 = new Residencia();
		Residencia res3 = new Residencia();
		
		juego.insertar(res1,new Coordenada(5,5));
		juego.insertar(res2,new Coordenada(8,5));
		juego.insertar(res3,new Coordenada(10,5));
		
		
		assertEquals(true,juego.getCoordenadasResidenciales().contains(new Coordenada(5,5)));
		assertEquals(true,juego.getCoordenadasResidenciales().contains(new Coordenada(8,5)));
		assertEquals(true,juego.getCoordenadasResidenciales().contains(new Coordenada(10,5)));
	}
	
	@Test
	public void insertarTresIndustriasAgregaLasHectareaALaListaDeIndustrias(){
		Juego juego = new Juego();
		
		Industria ind1 = new Industria();
		Industria ind2 = new Industria();
		Industria ind3 = new Industria();
		
		juego.insertar(ind1,new Coordenada(5,5));
		juego.insertar(ind2,new Coordenada(8,5));
		juego.insertar(ind3,new Coordenada(10,5));
		
		
		assertEquals(true,juego.getCoordenadasIndustriales().contains(new Coordenada(5,5)));
		assertEquals(true,juego.getCoordenadasIndustriales().contains(new Coordenada(8,5)));
		assertEquals(true,juego.getCoordenadasIndustriales().contains(new Coordenada(10,5)));
	}
	
	@Test
	public void insertarTresComerciosAgregaLasHectareaALaListaDeComercios(){
		Juego juego = new Juego();
		
		Comercio com1 = new Comercio();
		Comercio com2 = new Comercio();
		Comercio com3 = new Comercio();
		
		juego.insertar(com1,new Coordenada(5,5));
		juego.insertar(com2,new Coordenada(8,5));
		juego.insertar(com3,new Coordenada(10,5));
		
		assertEquals(true,juego.getCoordenadasComerciales().contains(new Coordenada(5,5)));
		assertEquals(true,juego.getCoordenadasComerciales().contains(new Coordenada(5,5)));
		assertEquals(true,juego.getCoordenadasComerciales().contains(new Coordenada(5,5)));
	}
	
	@Test
	public void insertarTresEDificiosAgregaLasHectareaALaListasListasCorrespondientes(){
		Juego juego = new Juego();
		
		Comercio com = new Comercio();
		Residencia res = new Residencia();
		Industria ind = new Industria();
		
		Coordenada c1 = new Coordenada(5,5);
		Coordenada c2 = new Coordenada(8,5);
		Coordenada c3 = new Coordenada(10,5);
		
		juego.insertar(com,new Coordenada(5,5));
		juego.insertar(res,new Coordenada(8,5));
		juego.insertar(ind,new Coordenada(10,5));
		
		
		assertEquals(true,juego.getCoordenadasComerciales().contains(c1));
		assertEquals(true,juego.getCoordenadasResidenciales().contains(c2));
		assertEquals(true,juego.getCoordenadasIndustriales().contains(c3));
	}
	
	@Test
	public void insertarUnaCentralEolicaAgregaALaHectareaALaListaDeCentrales(){
		Juego juego = new Juego();
		
		CentralEolica central = new CentralEolica();
		Coordenada coord = new Coordenada(5,5);
		
		juego.insertar(central,coord);
		
		assertEquals(true,juego.getCoordenadasConCentral().contains(coord));
	}
	
	@Test
	public void insertarUnaCentralMineralAgregaALaHectareaALaListaDeCentrales(){
		Juego juego = new Juego();
		
		CentralMineral central = new CentralMineral();
		
		Coordenada c = new Coordenada(5,5);
		
		juego.insertar(central,c);
		
		assertEquals(true,juego.getCoordenadasConCentral().contains(c));
	}
	
	@Test
	public void insertarUnaCentralNueclearAgregaALaHectareaALaListaDeCentrales(){
		Juego juego = new Juego();
		
		CentralNuclear central = new CentralNuclear();
		
		Coordenada c = new Coordenada(5,5);
		
		juego.insertar(central,c);
		
		assertEquals(true,juego.getCoordenadasConCentral().contains(c));
	}
	
	@Test
	public void insertarTresCentralesAgregaLasHectareaALaListaDeCentrales(){
		Juego juego = new Juego();
		
		CentralEolica eolica = new CentralEolica();
		CentralMineral mineral = new CentralMineral();
		CentralNuclear nuclear = new CentralNuclear();
		
		Coordenada cEolica = new Coordenada(5,5);
		Coordenada cMineral = new Coordenada(8,5);
		Coordenada cNuclear = new Coordenada(10,5);
		
		
		juego.insertar(eolica,cEolica);
		juego.insertar(mineral,cMineral);
		juego.insertar(nuclear,cNuclear);
		
		
		assertEquals(true,juego.getCoordenadasConCentral().contains(cEolica));
		assertEquals(true,juego.getCoordenadasConCentral().contains(cMineral));
		assertEquals(true,juego.getCoordenadasConCentral().contains(cNuclear));
	}
	
	@Test
	public void insertarUnaEstacionDeBomberosAgregaALaHectareaALaListaDeEstacionDeBomberos(){
		Juego juego = new Juego();
		
		EstacionDeBomberos edb = new EstacionDeBomberos();
		
		juego.insertar(edb, new Coordenada(3,3));
		
		assertEquals(true,juego.getEstacionesDeBomberos().contains(edb));
	}
	
	@Test
	public void insertarDosEstacionesDeBomberosAgregaLasHectareaALaListaDeEstacionDeBomberos(){
		Juego juego = new Juego();
		
		EstacionDeBomberos edb = new EstacionDeBomberos();
		EstacionDeBomberos edb2 = new EstacionDeBomberos();
		
		juego.insertar(edb,new Coordenada(5,5));
		juego.insertar(edb2,new Coordenada(10,5));
		
	
		assertEquals(true,juego.getEstacionesDeBomberos().contains(edb));
		assertEquals(true,juego.getEstacionesDeBomberos().contains(edb2));
	}
	
	@Test
	public void insertarUnPozoDeAguaAgregaALaHectareaALaListaDePozoDeAgua(){
		Juego juego = new Juego();
		
		PozoDeAgua pozo = new PozoDeAgua();
		
		Coordenada c = new Coordenada(23,23);
		
		juego.insertar(pozo,c);
		
		
		assertEquals(true,juego.getCoordenadasConPozo().contains(c));
	}
	
	@Test
	public void insertarDosPozosDeAguaAgregaLasHectareaLaListaDePozosDeAgua(){
		Juego juego = new Juego();
		
		PozoDeAgua pozo = new PozoDeAgua();
		PozoDeAgua pozo2 = new PozoDeAgua();
		
		Coordenada c1 = new Coordenada(23,23);
		Coordenada c2 = new Coordenada(0,23);
		
		juego.insertar(pozo,c1);
		juego.insertar(pozo2,c2);
		
		assertEquals(true,juego.getCoordenadasConPozo().contains(c1));
		assertEquals(true,juego.getCoordenadasConPozo().contains(c2));
	}
	
	@Test
	public void insertarUnaLineaDeTensionAgregaALaHectareaALaListaDeConexiones(){
		Juego juego = new Juego();
		
		LineaDeTension ldt = new LineaDeTension();
		
		Coordenada c = new Coordenada(5,5);
		
		juego.insertar(ldt,new Coordenada(5,5));
		
		assertEquals(true,juego.getCoordenadasConConexiones().contains(c));
	}
	
	@Test
	public void insertarUnaTuberiaAgregaALaHectareaALaListaDeConexiones(){
		Juego juego = new Juego();
		
		Tuberia tuberia = new Tuberia();
		
		juego.insertar(tuberia,new Coordenada(5,5));
		
		assertEquals(true,juego.getCoordenadasConConexiones().contains(new Coordenada(5,5)));
	}
	
	@Test
	public void insertarUnaRutaAgregaALaHectareaALaListaDeConexiones(){
		Juego juego = new Juego();
		
		Ruta ruta = new Ruta();
		
		juego.insertar(ruta,new Coordenada(5,5));
		
		assertEquals(true,juego.getCoordenadasConConexiones().contains(new Coordenada(5,5)));
	}
	
	@Test
	public void insertarLasTresConexionesAgregaSoloUnaVezLaHectareaALaListaDeConexiones(){
		Juego juego = new Juego();
		
		Ruta ruta = new Ruta();
		Tuberia tuberia = new Tuberia();
		LineaDeTension ldt = new LineaDeTension();
		
		Coordenada c = new Coordenada(5,5);
		
		juego.insertar(ruta,c);
		juego.insertar(tuberia,c);
		juego.insertar(ldt,c);
		
		assertEquals(true,juego.getCoordenadasConConexiones().contains(c));
		assertEquals(1,juego.getCoordenadasConConexiones().size());
	}
	
	@Test
	public void insertarLasTresConexionesEnDiferentesHectareaAgregaLasHectareaALaListaDeConexiones(){
		Juego juego = new Juego();
		
		Ruta ruta = new Ruta();
		Tuberia tuberia = new Tuberia();
		LineaDeTension ldt = new LineaDeTension();
		
		juego.insertar(ruta,new Coordenada(5,5));
		juego.insertar(tuberia,new Coordenada(2,5));
		juego.insertar(ldt,new Coordenada(0,5));
		
		assertEquals(true,juego.getCoordenadasConConexiones().contains(new Coordenada(5,5)));
		assertEquals(true,juego.getCoordenadasConConexiones().contains(new Coordenada(2,5)));
		assertEquals(true,juego.getCoordenadasConConexiones().contains(new Coordenada(0,5)));
		assertEquals(3,juego.getCoordenadasConConexiones().size());
	}
	
	
	@Test
	public void testJuegoComienzaEnElTurno1(){
		Juego juego = new Juego();
		assertEquals(1,juego.getTurno());
	}
	
	@Test
	public void testJuegoPasaDeTurnoATurno2(){
		Juego juego = new Juego();
		assertEquals(1,juego.getTurno());
		juego.turnoAvanzar();
		assertEquals(2,juego.getTurno());
	}
	
	@Test
	public void testPasarDeTurnoPropagaLosServiciosDeLasLosPozosDeAgua(){
		Juego juego = new Juego();
		
		PozoDeAgua pozo = new PozoDeAgua();
		
		juego.insertar(pozo, new Coordenada(23,23));
		juego.insertar(new Tuberia(), new Coordenada(23,24));
		
		Hectarea hectarea = juego.getMapa().getHectarea(new Coordenada(23,24));
		
		assertEquals(true, hectarea.tieneConexion(TipoDeConexion.Tuberia));
		assertEquals(false, hectarea.estaActivo(TipoDeServicio.Cloacas));
		
		juego.turnoAvanzar();
		
		assertEquals(true, hectarea.tieneConexion(TipoDeConexion.Tuberia));
		assertEquals(true, hectarea.estaActivo(TipoDeServicio.Cloacas));
	}
	
	@Test
	public void testPasarDeTurnoPropagaLosServiciosDeLosPozosDeAguaATresHectareaVecinas(){
		Juego juego = new Juego();
		
		PozoDeAgua pozo = new PozoDeAgua();
		
		juego.insertar(pozo, new Coordenada(23,23));
		juego.insertar(new Tuberia(), new Coordenada(23,22));
		juego.insertar(new Tuberia(), new Coordenada(23,21));
		juego.insertar(new Tuberia(), new Coordenada(23,20));
		
		Hectarea hectarea1 = juego.getMapa().getHectarea(new Coordenada(23,22));
		Hectarea hectarea2 = juego.getMapa().getHectarea(new Coordenada(23,21));
		Hectarea hectarea3 = juego.getMapa().getHectarea(new Coordenada(23,20));
		
		assertEquals(true, hectarea1.tieneConexion(TipoDeConexion.Tuberia));
		assertEquals(false, hectarea1.estaActivo(TipoDeServicio.Cloacas));
		assertEquals(true, hectarea2.tieneConexion(TipoDeConexion.Tuberia));
		assertEquals(false, hectarea2.estaActivo(TipoDeServicio.Cloacas));
		assertEquals(true, hectarea3.tieneConexion(TipoDeConexion.Tuberia));
		assertEquals(false, hectarea3.estaActivo(TipoDeServicio.Cloacas));
		
		juego.turnoAvanzar();
		
		assertEquals(true, hectarea1.tieneConexion(TipoDeConexion.Tuberia));
		assertEquals(true, hectarea1.estaActivo(TipoDeServicio.Cloacas));
		assertEquals(true, hectarea2.tieneConexion(TipoDeConexion.Tuberia));
		assertEquals(true, hectarea2.estaActivo(TipoDeServicio.Cloacas));
		assertEquals(true, hectarea3.tieneConexion(TipoDeConexion.Tuberia));
		assertEquals(true, hectarea3.estaActivo(TipoDeServicio.Cloacas));
	}
	
	@Test
	public void testPasarDeTurnoPropagaElServioDeTransioTresHectareaVecinas(){
		Juego juego = new Juego();
		
		
		juego.insertar(new Ruta(), new Coordenada(1,12));
		juego.insertar(new Ruta(), new Coordenada(2,12));
		juego.insertar(new Ruta(), new Coordenada(3,12));
		
		Hectarea hectarea1 = juego.getMapa().getHectarea(new Coordenada(1,12));
		Hectarea hectarea2 = juego.getMapa().getHectarea(new Coordenada(2,12));
		Hectarea hectarea3 = juego.getMapa().getHectarea(new Coordenada(3,12));
		
		assertEquals(true, hectarea1.tieneConexion(TipoDeConexion.Ruta));
		assertEquals(false, hectarea1.estaActivo(TipoDeServicio.AccesoAlTransito));
		assertEquals(true, hectarea2.tieneConexion(TipoDeConexion.Ruta));
		assertEquals(false, hectarea2.estaActivo(TipoDeServicio.AccesoAlTransito));
		assertEquals(true, hectarea3.tieneConexion(TipoDeConexion.Ruta));
		assertEquals(false, hectarea3.estaActivo(TipoDeServicio.AccesoAlTransito));
		
		juego.turnoAvanzar();
		
		assertEquals(true, hectarea1.tieneConexion(TipoDeConexion.Ruta));
		assertEquals(true, hectarea1.estaActivo(TipoDeServicio.AccesoAlTransito));
		assertEquals(true, hectarea2.tieneConexion(TipoDeConexion.Ruta));
		assertEquals(true, hectarea2.estaActivo(TipoDeServicio.AccesoAlTransito));
		assertEquals(true, hectarea3.tieneConexion(TipoDeConexion.Ruta));
		assertEquals(true, hectarea3.estaActivo(TipoDeServicio.AccesoAlTransito));
	}
	
	@Test
	public void metodoParaTestConecetarTodosLosServiciosATodoElMapa(){
		Juego juego = new Juego();
		juego.conectarServicios();
		
			for(int i=0; i < juego.getMapa().getTamanio(); i++){
				for(int j=0; j < juego.getMapa().getTamanio(); j++){
					Coordenada c = new Coordenada(i,j);
					Hectarea hectarea = juego.getMapa().getHectarea(c);
					assertEquals(true,hectarea.estaActivo(TipoDeServicio.AccesoAlTransito));
					assertEquals(true,hectarea.estaActivo(TipoDeServicio.Electrico));
					assertEquals(true,hectarea.estaActivo(TipoDeServicio.Cloacas));
				}
			}	
		}
	
	@Test
	public void testSePuedenDescontarTodosLosServiciosDelMapa(){
		Juego juego = new Juego();
		juego.conectarServicios();
		
			for(int i=0; i < juego.getMapa().getTamanio(); i++){
				for(int j=0; j < juego.getMapa().getTamanio(); j++){
					Coordenada c = new Coordenada(i,j);
					Hectarea hectarea = juego.getMapa().getHectarea(c);
					assertEquals(true,hectarea.estaActivo(TipoDeServicio.AccesoAlTransito));
					assertEquals(true,hectarea.estaActivo(TipoDeServicio.Electrico));
					assertEquals(true,hectarea.estaActivo(TipoDeServicio.Cloacas));
				}
			}	
			
		juego.desconectarServicios();
		}
	
	@Test
	public void testGodillaAtacaUnaResidenciaEnElMapaPasndoDeTurnoConGodzilla(){
		Juego juego = new Juego();
		
		Residencia res = new Residencia();
	
		Coordenada c = new Coordenada(10,10);
		
		juego.insertar(res,c);
		
		assertEquals(100, res.getSalud());
		
		juego.despertarAGodzillaSinRandom();
		
		assertEquals(0, res.getSalud());
	}
	
	@Test
	public void testGodillaAtacaUnaResidenciaConLosTresServiciosEnLaCoordenada(){
		Juego juego = new Juego();
		
		Residencia res = new Residencia();
		LineaDeTension ldt = new LineaDeTension();
		Ruta ruta = new Ruta();
		Tuberia tuberia = new Tuberia();
		
		Coordenada c = new Coordenada(10,10);
		
		juego.insertar(res,c);
		juego.insertar(ldt,c);
		juego.insertar(ruta,c);
		juego.insertar(tuberia,c);
		
		assertEquals(100, res.getSalud());
		assertEquals(100, ldt.getSalud());
		assertEquals(100, ruta.getSalud());
		assertEquals(100, tuberia.getSalud());
		
		juego.despertarAGodzillaSinRandom();
		
		assertEquals(0, res.getSalud());
		assertEquals(0, ldt.getSalud());
		assertEquals(20, ruta.getSalud());
		assertEquals(100, tuberia.getSalud());
	}
	
	@Test
	public void testGodillaAtacaUnaResidenciaUnaIndustriaYUnComercioAlineados(){
		Juego juego = new Juego();
		
		Residencia res = new Residencia();
		Industria ind = new Industria();
		Comercio com = new Comercio();
		
		juego.insertar(res,new Coordenada(10,10));
		juego.insertar(ind,new Coordenada(10,17));
		juego.insertar(com,new Coordenada(10,0));
		
		assertEquals(100, res.getSalud());
		assertEquals(100, ind.getSalud());
		assertEquals(100, com.getSalud());
		
		juego.despertarAGodzillaSinRandom();
		
		assertEquals(0, res.getSalud());
		assertEquals(60, ind.getSalud());
		assertEquals(25, com.getSalud());
	}
	
	@Test
	public void testGodillaAtacaUnaResidenciaUnaIndustriaYUnComercioAlineadosYSonReparadosPorUnaEstacionDeBomberos(){
		Juego juego = new Juego();
		
		Residencia res = new Residencia();
		Industria ind = new Industria();
		Comercio com = new Comercio();
		
		juego.insertar(res,new Coordenada(10,10));
		juego.insertar(ind,new Coordenada(10,17));
		juego.insertar(com,new Coordenada(10,0));
		juego.insertar(new EstacionDeBomberos(),new Coordenada(10,4));
		
		assertEquals(100, res.getSalud());
		assertEquals(100, ind.getSalud());
		assertEquals(100, com.getSalud());
		
		juego.despertarAGodzillaSinRandom();
		
		assertEquals(0, res.getSalud());
		assertEquals(60, ind.getSalud());
		assertEquals(25, com.getSalud());
		
		juego.repararAverias();
		
		assertEquals(10, res.getSalud());
		assertEquals(63, ind.getSalud());
		assertEquals(32, com.getSalud());
		
	}
	
	@Test
	public void testGodillaAtacaUnaResidenciaUnaIndustriaYUnComercioAlineadosYNoSonReparadosPorqueNoHayBomberos(){
		Juego juego = new Juego();
		
		Residencia res = new Residencia();
		Industria ind = new Industria();
		Comercio com = new Comercio();
		
		juego.insertar(res,new Coordenada(10,10));
		juego.insertar(ind,new Coordenada(10,17));
		juego.insertar(com,new Coordenada(10,0));
		
		assertEquals(100, res.getSalud());
		assertEquals(100, ind.getSalud());
		assertEquals(100, com.getSalud());
		
		juego.despertarAGodzillaSinRandom();
		
		assertEquals(0, res.getSalud());
		assertEquals(60, ind.getSalud());
		assertEquals(25, com.getSalud());
		
		juego.repararAverias();
		
		assertEquals(0, res.getSalud());
		assertEquals(60, ind.getSalud());
		assertEquals(25, com.getSalud());
		
	}
	
	@Test
	public void testGodillaAtacaUnaResidenciaUnaIndustriaYUnComercioAlineadosYSonReparadosPorDosEstacionDeBomberos(){
		Juego juego = new Juego();
		
		Residencia res = new Residencia();
		Industria ind = new Industria();
		Comercio com = new Comercio();
		
		juego.insertar(res,new Coordenada(10,10));
		juego.insertar(ind,new Coordenada(10,17));
		juego.insertar(com,new Coordenada(10,0));
		juego.insertar(new EstacionDeBomberos(),new Coordenada(10,4));
		juego.insertar(new EstacionDeBomberos(),new Coordenada(10,7));
		
		assertEquals(100, res.getSalud());
		assertEquals(100, ind.getSalud());
		assertEquals(100, com.getSalud());
		
		juego.despertarAGodzillaSinRandom();
		
		assertEquals(0, res.getSalud());
		assertEquals(60, ind.getSalud());
		assertEquals(25, com.getSalud());
		
		juego.repararAverias();
		
		assertEquals(20, res.getSalud());
		assertEquals(66, ind.getSalud());
		assertEquals(39, com.getSalud());
		
	}
	
	@Test
	public void testGodillaAtacaUnaResidenciaUnaIndustriaYUnComercioAlineadosYLasTresConexionesYSonReparadosPorUnaEstacionDeBomberos(){
		Juego juego = new Juego();
		
		Residencia res = new Residencia();
		Industria ind = new Industria();
		Comercio com = new Comercio();
		
		juego.insertar(res,new Coordenada(10,10));
		juego.insertar(ind,new Coordenada(10,17));
		juego.insertar(com,new Coordenada(10,0));
		
		juego.insertar(new EstacionDeBomberos(),new Coordenada(10,4));
		
		LineaDeTension ldt = new LineaDeTension();
		Ruta ruta = new Ruta();
		Tuberia tuberia = new Tuberia();
		
		Coordenada c = new Coordenada(10,10);
		
		juego.insertar(ldt,c);
		juego.insertar(ruta,c);
		juego.insertar(tuberia,c);
		
		assertEquals(100, res.getSalud());
		assertEquals(100, ind.getSalud());
		assertEquals(100, com.getSalud());
		
		assertEquals(100, ldt.getSalud());
		assertEquals(100, ruta.getSalud());
		assertEquals(100, tuberia.getSalud());
		
		juego.despertarAGodzillaSinRandom();
		
		assertEquals(0, res.getSalud());
		assertEquals(60, ind.getSalud());
		assertEquals(25, com.getSalud());
		
		assertEquals(0, ldt.getSalud());
		assertEquals(20, ruta.getSalud());
		assertEquals(100, tuberia.getSalud());
		
		juego.repararAverias();
		
		assertEquals(10, res.getSalud());
		assertEquals(63, ind.getSalud());
		assertEquals(32, com.getSalud());
		
		assertEquals(100, ldt.getSalud());
		assertEquals(100, ruta.getSalud());
		assertEquals(100, tuberia.getSalud());
		
	}
}
