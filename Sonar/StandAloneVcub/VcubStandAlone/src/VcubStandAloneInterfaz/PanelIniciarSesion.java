package VcubStandAloneInterfaz;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Dimension;

public class PanelIniciarSesion extends JPanel implements ActionListener
{
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------
	/**
	 * Comando INICIARSESION
	 */
	public final static String INICIARSESION = "Iniciar Sesion";

	// -----------------------------------------------------------------
	// Atributos de la Interfaz
	// -----------------------------------------------------------------
	/**
	 * textfield identificador
	 */
	private JTextField textIdentificador;

	/**
	 * textfield nombre
	 */
	private JTextField textNombre;

	/**
	 * Panel principal de la interfaz
	 */
	private PanelPrincipal principal;

	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------	
	/**
	 * Create the panel.
	 */
	public PanelIniciarSesion(PanelPrincipal ventana)
	{
		principal = ventana;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel labelx = new JLabel("Iniciar Sesion");
		labelx.setBounds(168, 11, 78, 17);
		labelx.setFont(new Font("Tahoma", Font.PLAIN, 14));

		GridBagConstraints gbc_btnCambiarUbicacionActual = new GridBagConstraints();
		gbc_btnCambiarUbicacionActual.insets = new Insets(0, 0, 5, 5);
		gbc_btnCambiarUbicacionActual.gridx = 2;
		gbc_btnCambiarUbicacionActual.gridy = 1;
		add(labelx, gbc_btnCambiarUbicacionActual);

		gbc_btnCambiarUbicacionActual.gridx = 0;
		gbc_btnCambiarUbicacionActual.gridy = 3;
		JLabel lblUsuario = new JLabel("Correo:");
		lblUsuario.setMaximumSize(new Dimension(37, 14));
		lblUsuario.setBounds(110, 58, 84, 14);
		add(lblUsuario, gbc_btnCambiarUbicacionActual);

		gbc_btnCambiarUbicacionActual.gridx = 2;
		gbc_btnCambiarUbicacionActual.gridy = 3;
		textNombre = new JTextField();
		textNombre.setMinimumSize(new Dimension(37, 14));
		textNombre.setMaximumSize(new Dimension(37, 14));
		textNombre.setBounds(225, 55, 86, 20);
		add(textNombre, gbc_btnCambiarUbicacionActual);
		textNombre.setColumns(10);

		gbc_btnCambiarUbicacionActual.gridx = 0;
		gbc_btnCambiarUbicacionActual.gridy = 5;
		JLabel lblId = new JLabel("Documento:");
		lblId.setMaximumSize(new Dimension(37, 14));
		lblId.setBounds(110, 108, 103, 14);
		add(lblId, gbc_btnCambiarUbicacionActual);

		gbc_btnCambiarUbicacionActual.gridx = 2;
		gbc_btnCambiarUbicacionActual.gridy = 5;
		textIdentificador = new JTextField();
		textIdentificador.setMaximumSize(new Dimension(37, 14));
		textIdentificador.setBounds(225, 105, 86, 20);
		textIdentificador.setColumns(10);
		add(textIdentificador, gbc_btnCambiarUbicacionActual);

		gbc_btnCambiarUbicacionActual.gridx = 2;
		gbc_btnCambiarUbicacionActual.gridy = 7;
		JButton btnInicarSesion = new JButton("IniciarSesion");
		btnInicarSesion.setBounds(77, 160, 136, 23);
		btnInicarSesion.setActionCommand(INICIARSESION);
		btnInicarSesion.addActionListener(this);
		add(btnInicarSesion, gbc_btnCambiarUbicacionActual);

		gbc_btnCambiarUbicacionActual.gridx = 2;
		gbc_btnCambiarUbicacionActual.gridy = 9;
		JButton btnCancelar = new JButton("Registrarse");
		btnCancelar.setBounds(223, 160, 106, 23);
		btnCancelar.setActionCommand("REGISTRAR");
		btnCancelar.addActionListener(this);
		add(btnCancelar, gbc_btnCambiarUbicacionActual);

		reiniciar();
		this.revalidate();
	}

	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		String x = e.getActionCommand();
		if(x.equals("REGISTRAR"))
		{
			principal.mostrarRegistro();
		}	
		else if(x.equals(INICIARSESION))
		{
			principal.iniciarSesion(textNombre.getText(),textIdentificador.getText());			
		}	
	}

	/**
	 * Reinicia el panel
	 */
	public void reiniciar()
	{
		textIdentificador.setText(""); 
		textNombre.setText(""); 
	}
}
