package TranviaStandAloneInterfaz;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelLogIn extends JPanel {
	private JTextField textField;
	private PanelPrincipal principal;

	/**
	 * Create the panel.
	 */
	public PanelLogIn(PanelPrincipal ppal) {
		setLayout(null);
		principal=ppal;
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(139, 125, 41, 50);
		add(lblId);
		
		textField = new JTextField();
		textField.setBounds(182, 136, 140, 35);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblBienvenido = new JLabel("Bienvenido! \r\nPor favor indique el id de su tranvia:\r\n");
		lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBienvenido.setBounds(26, 37, 414, 77);
		add(lblBienvenido);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				principal.mostrarPanel();
			}
		});
		btnIngresar.setBounds(166, 191, 89, 23);
		add(btnIngresar);

	}

}
