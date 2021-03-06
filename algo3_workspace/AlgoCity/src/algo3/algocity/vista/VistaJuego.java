package algo3.algocity.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import algo3.algocity.controlador.CargarJuego;
import algo3.algocity.controlador.ControladorEstadoJuego;
import algo3.algocity.controlador.GuardarJuego;
import algo3.algocity.controlador.NuevoJuego;
import algo3.algocity.controlador.PasarTurno;
import algo3.algocity.modelo.Coordenada;
import algo3.algocity.modelo.Juego;

public class VistaJuego extends JFrame implements Observer {

	private static final long serialVersionUID = 6156376075508293279L;

	private Juego juego;
	private Container contenedor;
	private NuevoJuego nuevoJuego;
	private PasarTurno pasarTurno;
	private GuardarJuego guardarJuego;
	private CargarJuego cargarJuego;
	private JPanel panelMapa;
	private EstadoJuego estadoJuego;
	private ControladorEstadoJuego controladorEstado;

	public VistaJuego(Juego juego) {
		this.juego = juego;
		this.juego.addObserver(this);
		this.setTitle("Algo City");
		this.contenedor = getContentPane();
		this.inicializarMapa();
		this.inicializarBarraDeEstado();
		this.inicializarBarraLateral();
		this.inicializarMenu();
		this.inicializarVentana();
	}

	private void inicializarBarraLateral() {
		JPanel panelLateral = new JPanel();
		panelLateral
				.setLayout(new BoxLayout(panelLateral, BoxLayout.PAGE_AXIS));
		panelLateral.add(InformacionHectarea.getInstance());
		
		panelLateral.setPreferredSize(new Dimension(250, 480));
		contenedor.add(panelLateral, BorderLayout.LINE_START);
	}

	private void inicializarBarraDeEstado() {
		this.estadoJuego = new EstadoJuego(this.juego);
		this.controladorEstado = new ControladorEstadoJuego(estadoJuego);
		this.contenedor.add(estadoJuego, BorderLayout.PAGE_START);
		this.juego.addObserver(this.controladorEstado);
	}

	public void inicializarMapa() {
		int dimension = this.juego.getMapa().getTamanio();

		GridLayout layoutMapa = new GridLayout(dimension + 1, dimension + 1);
		panelMapa = new JPanel();
		panelMapa.setLayout(layoutMapa);

		int at = 0;
		for (int x = 0; x < dimension; x++) {
			for (int y = 0; y < dimension; y++) {
				Coordenada c = new Coordenada(x, y);
				panelMapa.add(new VistaHectarea(this.juego, c), at);
				at++;
			}
		}
		this.contenedor.add(panelMapa, BorderLayout.CENTER);
	}

	private void inicializarMenu() {
		// create a menu bar
		final MenuBar menuBar = new MenuBar();

		// create menus
		Menu archivoMenu = new Menu("Archivo");
		Menu turnoMenu = new Menu("Turno");
		final Menu acercaDeMenu = new Menu("Acerca de");

		// Nuevo juego
		MenuItem nuevoMenuItem = new MenuItem("Nuevo");
		nuevoMenuItem.setActionCommand("Nuevo");
		this.nuevoJuego = new NuevoJuego(juego, this);
		nuevoMenuItem.addActionListener(this.nuevoJuego);

		// Abrir una partida
		MenuItem abrirMenuItem = new MenuItem("Abrir");
		abrirMenuItem.setActionCommand("Abrir");
		this.cargarJuego = new CargarJuego(this.juego);
		abrirMenuItem.addActionListener(this.cargarJuego);

		// Guardar una partida	
		MenuItem guardarMenuItem = new MenuItem("Guardar");
		guardarMenuItem.setActionCommand("Guardar");
		this.guardarJuego = new GuardarJuego(juego);
		guardarMenuItem.addActionListener(guardarJuego);

		MenuItem salirMenuItem = new MenuItem("Salir");
		salirMenuItem.setActionCommand("Salir");

		MenuItem pasarMenuItem = new MenuItem("Pasar");
		pasarMenuItem.setActionCommand("Pasar");

		MenuItemListener menuItemListener = new MenuItemListener();

		nuevoMenuItem.addActionListener(menuItemListener);
		abrirMenuItem.addActionListener(menuItemListener);
		guardarMenuItem.addActionListener(menuItemListener);
		salirMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(VistaJuego.this,
						" Esta seguro? ") == JOptionPane.YES_OPTION) {

					VistaJuego.this.processWindowEvent(new WindowEvent(
							VistaJuego.this, WindowEvent.WINDOW_CLOSING));
				}
			}

		});
		
		// Guardamos instancia para poder setear el juego actual al cargar uno
		// nuevo
		pasarTurno = new PasarTurno(juego);
		pasarMenuItem.addActionListener(pasarTurno);

		// add menu items to menus
		archivoMenu.add(nuevoMenuItem);
		archivoMenu.addSeparator();
		archivoMenu.add(abrirMenuItem);
		archivoMenu.add(guardarMenuItem);
		archivoMenu.addSeparator();
		archivoMenu.add(salirMenuItem);

		turnoMenu.add(pasarMenuItem);

		// add menu to menubar
		menuBar.add(archivoMenu);
		menuBar.add(turnoMenu);
		menuBar.add(acercaDeMenu);

		// add menubar to the frame
		this.setMenuBar(menuBar);
	}

	class MenuItemListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}
	}

	private void inicializarVentana() {

		// Maximizar la ventana
		//this.setSize(800, 700);
		this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);

		// Si la ventana esta maximizada
		// no tiene sentido un location
		// this.setLocation(8, 0);

		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void update() {
		this.update(null, null);
	}

	@Override
	public void update(Observable o, Object arg) {
		int dimension = this.juego.getMapa().getTamanio();

		int at = 0;
		for (int x = 0; x < dimension; x++) {

			for (int y = 0; y < dimension; y++) {
				((VistaHectarea) panelMapa.getComponent(at)).updateVista();
				at++;
			}
		}
	}

	public void resetVista(){
		this.contenedor.remove(this.panelMapa);
		this.contenedor.repaint();
	}
}
