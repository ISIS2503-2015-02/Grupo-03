package VcubStandAloneInterfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import VcubStandAloneMundo.EstacionVcub;
import VcubStandAloneMundo.Mundo;
import VcubStandAloneMundo.Ubicacion;
import VcubStandAloneMundo.Vcub;

public class PanelPrincipal extends JPanel {

	private Mundo mundo;

	private PanelIniciarSesion iniciar;

	private PanelMenu botones;

	private PanelVcubs vcubs;

	private PanelEstaciones estaciones;

	private PanelInfo info;

	private PanelRegistro registro;

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
		
		iniciar = new PanelIniciarSesion( this );
		add( iniciar, BorderLayout.CENTER);		
		iniciar.setVisible(true);

		iniciar.reiniciar();
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

		List<Vcub> x = mundo.darDisponibles();
		Vcub[] vcubsxx = new Vcub[x.size()];
		for(int i=0; i<x.size();i++)
		{
			vcubsxx[i]=x.get(i);
		}
		return vcubsxx;
	}

	public EstacionVcub[] darEstaciones()
	{
		mundo.estaciones();

		List<EstacionVcub> x = mundo.darEstaciones();
		EstacionVcub[] estacionesVcub = new EstacionVcub[x.size()];
		for(int i=0; i<x.size();i++)
		{
			estacionesVcub[i]=x.get(i);
		}
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

	public void iniciarSesion(String pCorreo, String pPassword) 
	{	
		if(mundo.iniciar(pCorreo, pPassword)==true)
		{
			iniciar.setVisible(false);
			botones = new PanelMenu(this);
			add(botones, BorderLayout.CENTER);
			botones.setVisible( true );
			botones.actualizar();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "No se ha encontrado el usuario");
		}
	}

	public void registrarse(String pNombre, long pDocumento, String pTipoDocumento, long pTelefono, String pDireccion, String pCorreo, long pTarjeta) throws ParseException
	{
		if(mundo.registrarse(pNombre, pDocumento, pTipoDocumento, pTelefono, pDireccion, pCorreo, pTarjeta)==true)
		{
			registro.setVisible(false);
			botones = new PanelMenu(this);
			add(botones, BorderLayout.CENTER);
			botones.setVisible( true );
			botones.actualizar();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "No se pudo llevar a cabo el registro");
		}	
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

	public void mostrarRegistro() 
	{	
		iniciar.setVisible(false);
		registro = new PanelRegistro(this);
		add(registro, BorderLayout.CENTER);
		registro.setVisible( true );
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

	public void mostrarIniciar( ) 
	{	
		registro.setVisible(false);
		iniciar = new PanelIniciarSesion(this);
		add(iniciar, BorderLayout.CENTER);
		iniciar.setVisible( true );
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
}
