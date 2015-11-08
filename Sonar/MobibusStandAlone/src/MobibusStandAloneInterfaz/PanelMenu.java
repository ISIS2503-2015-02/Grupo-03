package MobibusStandAloneInterfaz;

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
	private transient PanelPrincipal principalIP;
	private JLabel labelIP;
	private Logger LOGGER;
	/**
	 * Create the panel.
	 */
	public PanelMenu(PanelPrincipal ventana)
	{
		principalIP = ventana;

		GridBagLayout gridBagLayoutIP = new GridBagLayout();
		gridBagLayoutIP.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutIP.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutIP.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayoutIP.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayoutIP);

		labelIP = new JLabel("");
		labelIP.setHorizontalAlignment( JLabel.CENTER );
		labelIP.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelIP.setPreferredSize(new Dimension(300, 300));
		GridBagConstraints gbc_labelIP = new GridBagConstraints();
		gbc_labelIP.insets = new Insets(0, 0, 5, 5);
		gbc_labelIP.gridx = 2;
		gbc_labelIP.gridy = 1;
		add(labelIP, gbc_labelIP);
		
		JButton btnCambiarUbicacionActualIP = new JButton("Ver Mobibuses");
		btnCambiarUbicacionActualIP.setActionCommand("CAMBIO1");
		btnCambiarUbicacionActualIP.addActionListener(this);
		
		GridBagConstraints gbc_btnCambiarUbicacionActualIP = new GridBagConstraints();
		gbc_btnCambiarUbicacionActualIP.insets = new Insets(0, 0, 5, 5);
		gbc_btnCambiarUbicacionActualIP.gridx = 2;
		gbc_btnCambiarUbicacionActualIP.gridy = 3;
		add(btnCambiarUbicacionActualIP, gbc_btnCambiarUbicacionActualIP);
		
		JButton btnEmergencias = new JButton("Ver Emergencias");
		btnEmergencias.setActionCommand("CAMBIO");
		btnEmergencias.addActionListener(this);

		gbc_btnCambiarUbicacionActualIP.insets = new Insets(0, 0, 5, 5);
		gbc_btnCambiarUbicacionActualIP.gridx = 2;
		gbc_btnCambiarUbicacionActualIP.gridy = 5;
		add(btnEmergencias, gbc_btnCambiarUbicacionActualIP);
		
		actualizar();
	}

	public void actualizar()
	{
		URL zzIP = null;

		try
		{
			zzIP = new URL("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQ7RqeQ93yAGmWy-qow58NQ4BR-YaknJs-TKpOUmx_-KeNdKq4X");
		} 
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.log(null, "context", e);
			
		}

		if(zzIP!=null)
		{
			ImageIcon iconoIP = new ImageIcon(zzIP);
			labelIP.setIcon(iconoIP);
		}
		this.revalidate();
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		String x = arg0.getActionCommand();
		if("CAMBIO1".equals(x))
		{
			principalIP.mostrarEstaciones();
		}
		else if("CAMBIO".equals(x))
		{
			principalIP.mostrarEmergencias();;
		}
	}
}
