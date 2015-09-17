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
import MobibusStandAloneMundo.Mobibus;

public class PanelPrincipal extends JPanel {

	private Mundo mundo;

	private PanelBotones botones;

	private PanelReservas Mobibus;
	//
	//	private PanelCambiarCodigoPostal postal;
	//
	//	private PanelCambiarCiudad ciudad;

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

		botones = new PanelBotones( this );
		add( botones, BorderLayout.CENTER);		
		botones.setVisible(true);

		botones.actualizar();
		this.revalidate();
	}

	public void mostrarCambiar() 
	{	
		botones.setVisible(false);
		Mobibus = new PanelReservas(this); 
		add(Mobibus, BorderLayout.CENTER);
		Mobibus.setVisible( true );
		Mobibus.actualizarLista(darDisponibles());
	}

	public Mobibus[] darDisponibles()
	{
		mundo.disponibles();

		ArrayList<Mobibus> x = mundo.darDisponibles();
		Mobibus[] Mobibus = new Mobibus[x.size()];
		for(int i=0; i<x.size();i++)
		{
			Mobibus[i]=x.get(i);
		}
		Mobibus y = new Mobibus(Long.valueOf("12"),"disponible");
		System.out.println(mundo.darDisponibles().size());
		System.out.println(((Mobibus) mundo.darDisponibles().get(0)).getId());
		System.out.println(((Mobibus) mundo.darDisponibles().get(0)).getEstado());
		return Mobibus;
	}

	public void mostrarBotones() 
	{	
		Mobibus.setVisible(false);
		botones = new PanelBotones(this);
		add(botones, BorderLayout.CENTER);
		botones.setVisible( true );
		botones.actualizar();
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
