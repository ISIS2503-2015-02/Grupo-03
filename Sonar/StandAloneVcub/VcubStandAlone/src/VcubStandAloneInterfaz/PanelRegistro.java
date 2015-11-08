package VcubStandAloneInterfaz;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Dimension;

public class PanelRegistro extends JPanel implements ActionListener
{
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------
	/**
	 * Comando INICIARSESION
	 */
	public final static String REGISTRAR = "Registrar";

	// -----------------------------------------------------------------
	// Atributos de la Interfaz
	// -----------------------------------------------------------------

	/**
	 * textfield nombre
	 */
	private JTextField textNombre;

	/**
	 * textfield identificador
	 */
	private JTextField textIdentificador;

	/**
	 * textfield tipo identificador
	 */
	private JTextField textTipoIdentificador;

	/**
	 * textfield telefono
	 */
	private JTextField textTelefono;

	/**
	 * textfield direccion
	 */
	private JTextField textDireccion;

	/**
	 * textfield correo
	 */
	private JTextField textCorreo;

	/**
	 * textfield tarjeta
	 */
	private JTextField textTarjeta;

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
	public PanelRegistro(PanelPrincipal ventana)
	{
		principal = ventana;

		GridBagLayout gridBagLayoutRV = new GridBagLayout();
		gridBagLayoutRV.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutRV.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutRV.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayoutRV.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayoutRV);

		JLabel labelxRV = new JLabel("Registro");
		labelxRV.setBounds(168, 11, 78, 17);
		labelxRV.setFont(new Font("Tahoma", Font.PLAIN, 14));

		GridBagConstraints gbc_btnCambiarUbicacionActualRV = new GridBagConstraints();
		gbc_btnCambiarUbicacionActualRV.insets = new Insets(0, 0, 5, 5);
		gbc_btnCambiarUbicacionActualRV.gridx = 2;
		gbc_btnCambiarUbicacionActualRV.gridy = 1;
		add(labelxRV, gbc_btnCambiarUbicacionActualRV);

		gbc_btnCambiarUbicacionActualRV.gridx = 0;
		gbc_btnCambiarUbicacionActualRV.gridy = 3;
		JLabel lblUsuarioRV = new JLabel("Nombre:");
		lblUsuarioRV.setMaximumSize(new Dimension(37, 14));
		lblUsuarioRV.setBounds(110, 58, 84, 14);
		add(lblUsuarioRV, gbc_btnCambiarUbicacionActualRV);

		gbc_btnCambiarUbicacionActualRV.gridx = 2;
		gbc_btnCambiarUbicacionActualRV.gridy = 3;
		textNombre = new JTextField();
		textNombre.setMinimumSize(new Dimension(37, 14));
		textNombre.setMaximumSize(new Dimension(37, 14));
		textNombre.setBounds(225, 55, 86, 20);
		add(textNombre, gbc_btnCambiarUbicacionActualRV);
		textNombre.setColumns(10);

		gbc_btnCambiarUbicacionActualRV.gridx = 0;
		gbc_btnCambiarUbicacionActualRV.gridy = 5;
		JLabel lblIdRV = new JLabel("Documento:");
		lblIdRV.setMaximumSize(new Dimension(37, 14));
		lblIdRV.setBounds(110, 108, 103, 14);
		add(lblIdRV, gbc_btnCambiarUbicacionActualRV);

		gbc_btnCambiarUbicacionActualRV.gridx = 2;
		gbc_btnCambiarUbicacionActualRV.gridy = 5;
		textIdentificador = new JTextField();
		textIdentificador.setMaximumSize(new Dimension(37, 14));
		textIdentificador.setBounds(225, 105, 86, 20);
		textIdentificador.setColumns(10);
		add(textIdentificador, gbc_btnCambiarUbicacionActualRV);

		gbc_btnCambiarUbicacionActualRV.gridx = 0;
		gbc_btnCambiarUbicacionActualRV.gridy = 7;
		JLabel lblTipoRV = new JLabel("Tipo documento:");
		lblTipoRV.setMaximumSize(new Dimension(37, 14));
		lblTipoRV.setBounds(110, 108, 103, 14);
		add(lblTipoRV, gbc_btnCambiarUbicacionActualRV);

		gbc_btnCambiarUbicacionActualRV.gridx = 2;
		gbc_btnCambiarUbicacionActualRV.gridy = 7;
		textTipoIdentificador = new JTextField();
		textTipoIdentificador.setMaximumSize(new Dimension(37, 14));
		textTipoIdentificador.setBounds(225, 105, 86, 20);
		textTipoIdentificador.setColumns(10);
		add(textTipoIdentificador, gbc_btnCambiarUbicacionActualRV);

		gbc_btnCambiarUbicacionActualRV.gridx = 0;
		gbc_btnCambiarUbicacionActualRV.gridy = 9;
		JLabel lblTel = new JLabel("Telefono:");
		lblTel.setMaximumSize(new Dimension(37, 14));
		lblTel.setBounds(110, 108, 103, 14);
		add(lblTel, gbc_btnCambiarUbicacionActualRV);

		gbc_btnCambiarUbicacionActualRV.gridx = 2;
		gbc_btnCambiarUbicacionActualRV.gridy = 9;
		textTelefono = new JTextField();
		textTelefono.setMaximumSize(new Dimension(37, 14));
		textTelefono.setBounds(225, 105, 86, 20);
		textTelefono.setColumns(10);
		add(textTelefono, gbc_btnCambiarUbicacionActualRV);

		gbc_btnCambiarUbicacionActualRV.gridx = 0;
		gbc_btnCambiarUbicacionActualRV.gridy = 11;
		JLabel lblDir = new JLabel("Direccion:");
		lblDir.setMaximumSize(new Dimension(37, 14));
		lblDir.setBounds(110, 108, 103, 14);
		add(lblDir, gbc_btnCambiarUbicacionActualRV);

		gbc_btnCambiarUbicacionActualRV.gridx = 2;
		gbc_btnCambiarUbicacionActualRV.gridy = 11;
		textDireccion = new JTextField();
		textDireccion.setMaximumSize(new Dimension(37, 14));
		textDireccion.setBounds(225, 105, 86, 20);
		textDireccion.setColumns(10);
		add(textDireccion, gbc_btnCambiarUbicacionActualRV);

		gbc_btnCambiarUbicacionActualRV.gridx = 0;
		gbc_btnCambiarUbicacionActualRV.gridy = 13;
		JLabel lblCor = new JLabel("Correo:");
		lblCor.setMaximumSize(new Dimension(37, 14));
		lblCor.setBounds(110, 108, 103, 14);
		add(lblCor, gbc_btnCambiarUbicacionActualRV);

		gbc_btnCambiarUbicacionActualRV.gridx = 2;
		gbc_btnCambiarUbicacionActualRV.gridy = 13;
		textCorreo = new JTextField();
		textCorreo.setMaximumSize(new Dimension(37, 14));
		textCorreo.setBounds(225, 105, 86, 20);
		textCorreo.setColumns(10);
		add(textCorreo, gbc_btnCambiarUbicacionActualRV);

		gbc_btnCambiarUbicacionActualRV.gridx = 0;
		gbc_btnCambiarUbicacionActualRV.gridy = 15;
		JLabel lblTar = new JLabel("Tarjeta:");
		lblTar.setMaximumSize(new Dimension(37, 14));
		lblTar.setBounds(110, 108, 103, 14);
		add(lblTar, gbc_btnCambiarUbicacionActualRV);

		gbc_btnCambiarUbicacionActualRV.gridx = 2;
		gbc_btnCambiarUbicacionActualRV.gridy = 15;
		textTarjeta = new JTextField();
		textTarjeta.setMaximumSize(new Dimension(37, 14));
		textTarjeta.setBounds(225, 105, 86, 20);
		textTarjeta.setColumns(10);
		add(textTarjeta, gbc_btnCambiarUbicacionActualRV);

		gbc_btnCambiarUbicacionActualRV.gridx = 2;
		gbc_btnCambiarUbicacionActualRV.gridy = 17;
		JButton btnInicarSesion = new JButton("Registrarse");
		btnInicarSesion.setBounds(77, 160, 136, 23);
		btnInicarSesion.setActionCommand(REGISTRAR);
		btnInicarSesion.addActionListener(this);
		add(btnInicarSesion, gbc_btnCambiarUbicacionActualRV);

		gbc_btnCambiarUbicacionActualRV.gridx = 2;
		gbc_btnCambiarUbicacionActualRV.gridy = 19;
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(223, 160, 106, 23);
		btnCancelar.setActionCommand("CANCELAR");
		btnCancelar.addActionListener(this);
		add(btnCancelar, gbc_btnCambiarUbicacionActualRV);

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
		if(x.equals(REGISTRAR))
		{
			Long doc = Long.valueOf(textIdentificador.getText());
			Long tel = Long.valueOf(textTelefono.getText());
			Long tar = Long.valueOf(textTarjeta.getText());
			try {
				principal.registrarse(textNombre.getText(), doc, textTipoIdentificador.getText(), tel, textDireccion.getText(), textCorreo.getText(), tar);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}	
		else if("CANCELAR".equals(x))
		{
			principal.mostrarIniciar();			
		}	
	}

	/**
	 * Reinicia el panel
	 */
	public void reiniciar()
	{
		textIdentificador.setText(""); 
		textNombre.setText(""); 
		textCorreo.setText("");
		textDireccion.setText("");
		textTarjeta.setText("");
		textTelefono.setText("");
		textTipoIdentificador.setText("");
	}
}
