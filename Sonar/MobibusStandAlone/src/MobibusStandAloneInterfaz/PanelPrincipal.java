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
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import MobibusStandAloneMundo.Emergencia;
import MobibusStandAloneMundo.Mundo;
import MobibusStandAloneMundo.Ubicacion;
import MobibusStandAloneMundo.Mobibus;

public class PanelPrincipal extends JPanel {

	private Mundo mundo;

	private PanelMenu botones;


	private PanelMobibus estaciones;

	private PanelEmergencias emergencias;

	private MobibusStandAloneInterfaz.PanelInfo info;


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

		List<Mobibus> x = mundo.darDisponibles();
		Mobibus[] Mobibuses = new Mobibus[x.size()];
		for(int i=0; i<x.size();i++)
		{
			Mobibuses[i]=x.get(i);
		}
		return Mobibuses;
	}

	public Emergencia[] darEmergencias()
	{
		mundo.emergencias();

		List<Emergencia> x = mundo.derEmergencias();
		Emergencia[] lista = new Emergencia[x.size()];
		for(int i=0; i<x.size();i++)
		{
			lista[i]=x.get(i);
		}
		return lista;
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

	public void mostrarBotones3() 
	{	
		emergencias.setVisible(false);
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

	public void mostrarEmergencias() 
	{	
		botones.setVisible(false);
		emergencias = new PanelEmergencias(this);
		add(emergencias, BorderLayout.CENTER);
		emergencias.setVisible( true );
		emergencias.actualizar();
		emergencias.actualizarLista(darEmergencias());
	}
	
	public void mostrarInfo(Emergencia x) 
	{	
		emergencias.setVisible(false);
		info = new PanelInfo(this);
		add(info, BorderLayout.CENTER);
		info.setVisible( true );
		info.actualizar(mundo.cercano(x));
	}

	public void cambiarEstadoMobi(Mobibus mobi)
	{
		mundo.cambiarEstado(mobi);
	}
}
