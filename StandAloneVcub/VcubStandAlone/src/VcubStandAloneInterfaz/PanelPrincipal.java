package VcubStandAloneInterfaz;

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

import VcubStandAloneMundo.EstacionVcub;
import VcubStandAloneMundo.Mundo;
import VcubStandAloneMundo.Ubicacion;
import VcubStandAloneMundo.Vcub;

public class PanelPrincipal extends JPanel {

	private Mundo mundo;

	private PanelMenu botones;

	private PanelVcubs vcubs;

	private PanelEstaciones estaciones;

	private PanelInfo info;

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

	public void mostrarCambiar() 
	{	
		botones.setVisible(false);
		vcubs = new PanelVcubs(this); 
		add(vcubs, BorderLayout.CENTER);
		vcubs.setVisible( true );
		vcubs.actualizarLista(darDisponibles());
	}

	public Vcub[] darDisponibles()
	{
		mundo.disponibles();

		ArrayList<Vcub> x = mundo.darDisponibles();
		Vcub[] vcubs = new Vcub[x.size()];
		for(int i=0; i<x.size();i++)
		{
			vcubs[i]=x.get(i);
		}
		Vcub y = new Vcub(Long.valueOf("12"),"disponible");
		System.out.println(mundo.darDisponibles().size());
		System.out.println(((Vcub) mundo.darDisponibles().get(0)).getEstado());
		return vcubs;
	}

	public EstacionVcub[] darEstaciones()
	{
		mundo.estaciones();

		ArrayList<EstacionVcub> x = mundo.darEstaciones();
		EstacionVcub[] estacionesVcub = new EstacionVcub[x.size()];
		for(int i=0; i<x.size();i++)
		{
			estacionesVcub[i]=x.get(i);
		}
		System.out.println(mundo.darEstaciones().size());
		return estacionesVcub;
	}

	public String generarMapa(Ubicacion x)
	{
		return mundo.generarMapa(x);
	}

	public void mostrarBotones() 
	{	
		vcubs.setVisible(false);
		botones = new PanelMenu(this);
		add(botones, BorderLayout.CENTER);
		botones.setVisible( true );
		botones.actualizar();
	}

	public void mostrarBotones2() 
	{	
		estaciones.setVisible(false);
		botones = new PanelMenu(this);
		add(botones, BorderLayout.CENTER);
		botones.setVisible( true );
		botones.actualizar();
	}
	
	public void mostrarBotones3() 
	{	
		info.setVisible(false);
		botones = new PanelMenu(this);
		add(botones, BorderLayout.CENTER);
		botones.setVisible( true );
		botones.actualizar();
	}

	public void mostrarEstaciones() 
	{	
		botones.setVisible(false);
		estaciones = new PanelEstaciones(this);
		add(estaciones, BorderLayout.CENTER);
		estaciones.setVisible( true );
		estaciones.actualizar();
		estaciones.actualizarLista(darEstaciones());
	}
	
	public void mostrarInfo(EstacionVcub x) 
	{	
		estaciones.setVisible(false);
		info = new PanelInfo(this);
		add(info, BorderLayout.CENTER);
		info.setVisible( true );
		info.actualizar(x);
	}
	
	public void mostrarEstaciones2() 
	{	
		info.setVisible(false);
		estaciones = new PanelEstaciones(this);
		add(estaciones, BorderLayout.CENTER);
		estaciones.setVisible( true );
		estaciones.actualizar();
		estaciones.actualizarLista(darEstaciones());
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
