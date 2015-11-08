package VcubStandAloneInterfaz;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public class PanelMenu extends JPanel implements ActionListener
{
	private transient PanelPrincipal principal;
	private JLabel label;
	private transient Logger LOGGER;

	/**
	 * Create the panel.
	 */
	public PanelMenu(PanelPrincipal ventana)
	{
		principal = ventana;

		GridBagLayout gridBagLayoutVM = new GridBagLayout();
		gridBagLayoutVM.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutVM.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutVM.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayoutVM.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayoutVM);

		label = new JLabel("");
		label.setHorizontalAlignment( JLabel.CENTER );
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		label.setPreferredSize(new Dimension(300, 300));
		GridBagConstraints gbc_labelVM = new GridBagConstraints();
		gbc_labelVM.insets = new Insets(0, 0, 5, 5);
		gbc_labelVM.gridx = 2;
		gbc_labelVM.gridy = 1;
		add(label, gbc_labelVM);
		
		JButton btnCambiarUbicacionActualVM = new JButton("Ver estaciones de Vcub");
		btnCambiarUbicacionActualVM.setActionCommand("CAMBIO1");
		btnCambiarUbicacionActualVM.addActionListener(this);
		
		GridBagConstraints gbc_btnCambiarUbicacionActualVM = new GridBagConstraints();
		gbc_btnCambiarUbicacionActualVM.insets = new Insets(0, 0, 5, 5);
		gbc_btnCambiarUbicacionActualVM.gridx = 2;
		gbc_btnCambiarUbicacionActualVM.gridy = 3;
		add(btnCambiarUbicacionActualVM, gbc_btnCambiarUbicacionActualVM);
		
		gbc_btnCambiarUbicacionActualVM.gridx = 2;
		gbc_btnCambiarUbicacionActualVM.gridy = 5;
		JButton btn2VM = new JButton("Ver Vcubs Disponibles");
		btn2VM.setActionCommand("CAMBIO");
		btn2VM.addActionListener(this);
		add(btn2VM, gbc_btnCambiarUbicacionActualVM);

		actualizar();
	}

	public void actualizar()
	{
		URL zzVM = null;

		try
		{
			zzVM = new URL("http://static.blogo.it/ecologiablog/ecologiablog_bicing_barcelona.jpg");
		} 
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			LOGGER.log(null, "context", e);
		}

		if(zzVM!=null)
		{
			ImageIcon iconoVM = new ImageIcon(zzVM);
			label.setIcon(iconoVM);
		}
		this.revalidate();
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		String x = arg0.getActionCommand();
		if("CAMBIO".equals(x))
		{
			principal.mostrarCambiar();
		}
		else if("CAMBIO1".equals(x))
		{
			principal.mostrarEstaciones();
		}
	}
}
