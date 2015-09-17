package MobibusStandAloneInterfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import MobibusStandAloneMundo.Mundo;
import MobibusStandAloneMundo.Ubicacion;
import MobibusStandAloneMundo.Mobibus;

public class PanelPrincipal extends JPanel {

	private Mundo mundo;

	private PanelMenu botones;


	private PanelMobibus estaciones;


	public static void main(String[] args) 
	{

		JFrame n = new JFrame();
		n.setMinimumSize(new Dimension(450, 650));
		n.setVisible(true);
		PanelPrincipal nuevo = new PanelPrincipal(new Mundo());
		nuevo.setVisible(true);
		n.getContentPane().add(nuevo); 
	}

	/**
	 * Create the panel.
	 */
	public PanelPrincipal(Mundo x)
	{    	
		mundo = x;
		//Creación de los paneles aquí

		botones = new PanelMenu( this );
		add( botones, BorderLayout.CENTER);		
		botones.setVisible(true);

		botones.actualizar();
		this.revalidate();
	}


	public Mobibus[] darDisponibles()
	{
		mundo.disponibles();

		ArrayList<Mobibus> x = mundo.darDisponibles();
		Mobibus[] Mobibuses = new Mobibus[x.size()];
		for(int i=0; i<x.size();i++)
		{
			Mobibuses[i]=x.get(i);
		}
		Mobibus y = new Mobibus(Long.valueOf("12"));
		System.out.println(mundo.darDisponibles().size());
		System.out.println(((Mobibus) mundo.darDisponibles().get(0)).getEstado());
		return Mobibuses;
	}

	
	public String generarMapa(Ubicacion x)
	{
		return mundo.generarMapa(x);
	}



	public void mostrarBotones2() 
	{	
		estaciones.setVisible(false);
		botones = new PanelMenu(this);
		add(botones, BorderLayout.CENTER);
		botones.setVisible( true );
		botones.actualizar();
	}
	


	public void mostrarEstaciones() 
	{	
		botones.setVisible(false);
		estaciones = new PanelMobibus(this);
		add(estaciones, BorderLayout.CENTER);
		estaciones.setVisible( true );
		estaciones.actualizar();
		estaciones.actualizarLista(darDisponibles());
	}
	
	
	
	public void mostrarEstaciones2() 
	{	
		estaciones = new PanelMobibus(this);
		add(estaciones, BorderLayout.CENTER);
		estaciones.setVisible( true );
		estaciones.actualizar();
		estaciones.actualizarLista(darDisponibles());
	}
	
	public void cambiarEstadoMobi(Mobibus mobi)
	{
		mundo.cambiarEstado(mobi);
	}
	//
	//	public void mostrarBotones2() 
	//	{	
	//		opciones.setVisible(false);
	//		botones = new PanelBotones(this);
	//		add(botones, BorderLayout.CENTER);
	//		botones.setVisible( true );
	//		botones.actualizar();
	//	}
	//
	//	public void mostrarBotones3() 
	//	{	
	//		postal.setVisible(false);
	//		botones = new PanelBotones(this);
	//		add(botones, BorderLayout.CENTER);
	//		botones.setVisible( true );
	//		botones.actualizar();
	//	}
	//
	//	public void mostrarBotones4() 
	//	{	
	//		ciudad.setVisible(false);
	//		botones = new PanelBotones(this);
	//		add(botones, BorderLayout.CENTER);
	//		botones.setVisible( true );
	//		botones.actualizar();
	//	}
	//
	//	public void mostrarOpciones()
	//	{
	//		botones.setVisible(false);
	//		opciones = new PanelOpciones(this); 
	//		add(opciones, BorderLayout.CENTER);
	//		opciones.setVisible( true );
	//	}
	//
	//	public void mostrarCodigoPostal()
	//	{
	//		opciones.setVisible(false);
	//		postal = new PanelCambiarCodigoPostal(this); 
	//		add(postal, BorderLayout.CENTER);
	//		postal.setVisible( true );
	//	}
	//
	//	public void mostrarCiudad()
	//	{
	//		opciones.setVisible(false);
	//		ciudad = new PanelCambiarCiudad(this); 
	//		add(ciudad, BorderLayout.CENTER);
	//		ciudad.setVisible( true );
	//	}
	//
	//	public void cambiar(String cod, String lat, String lon, String ciu)
	//	{
	//		if(darUsuario()!=null)
	//		{
	//			if((lat != "" && lon != "")|| cod != "" || ciu != "")
	//			{
	//				darUsuario().cambiarUbicacionActual(cod, lat, lon, ciu);
	//			}
	//		}
	//	}
	//
	//	public Usuario darUsuario()
	//	{
	//		return cupihotel.darUsuario();
	//	}
	//
	//	public String URL()
	//	{
	//		return cupihotel.generarMapa();
	//	}
}
