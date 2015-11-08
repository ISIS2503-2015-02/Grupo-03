package TranviaStandAloneInterfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import TranviaStandAloneMundo.Mundo;
import TranviaStandAloneMundo.Tranvia;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.UIManager;

import java.awt.Panel;

public class PanelPrincipal extends JPanel {

	private Mundo mundo;
	private JButton btnCrearEmergencia;
	private JButton btnPnico;
	private Panel panel;
	private PanelCrearEmergencia emergencia;
	private PanelLogIn login;

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
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblTranvia = new JLabel("\t\t\t\t\t\t\tTranvia");
		lblTranvia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblTranvia, BorderLayout.NORTH);
		
		login = new PanelLogIn(this);
		add(login);
		login.setLayout(null);
		panel = new Panel();
		
		btnPnico = new JButton("\u00A1Ayuda!");
		btnPnico.setBounds(164, 118, 109, 31);
		panel.add(btnPnico);
		btnPnico.setForeground(Color.RED);
		btnPnico.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnPnico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mundo.Panico();
				
			}
		});
		
		btnCrearEmergencia = new JButton("Crear Emergencia");
		btnCrearEmergencia.setBounds(164, 45, 117, 23);
		panel.add(btnCrearEmergencia);
		btnCrearEmergencia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarEmergencia();
			}
		});
		mundo = x;
		emergencia = new PanelCrearEmergencia(this);
		

		this.revalidate();
	}

	public void mostrarPanel()
	{
		add(panel, BorderLayout.CENTER);
		panel.setVisible( true );
		login.setVisible(false);
		emergencia.setVisible(false);
		this.revalidate();
	}
	public void mostrarEmergencia() 
	{	
		add(emergencia, BorderLayout.CENTER);
		emergencia.setVisible( true );
		panel.setVisible(false);
		this.revalidate();
		
	}

	public void crearEmergencia(String descripcion, String magnitud, String consecuencia ) 
	{
		try {
			mundo.crearEmergencia(descripcion, consecuencia, magnitud);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void mostrarBotones() 
	{	
		emergencia.setVisible(false);

	}

	public void getTranvia(String string) {
		mundo.getTranvia(string);
	}
}
