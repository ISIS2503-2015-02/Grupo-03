package TranviaStandAloneInterfaz;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCrearEmergencia extends JPanel {
	private PanelPrincipal principal;
	private JTextField Descripción;
	private JRadioButton rdbtnTranviaFueraDe;
	private JRadioButton rdbtnTranviaSigueFuncionando;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JRadioButton rdbtnLeve;
	private JRadioButton rdbtnModerada;
	private JRadioButton rdbtnGrave;

	/**
	 * Create the panel.
	 */
	public PanelCrearEmergencia(PanelPrincipal ppal) {
		setLayout(null);
		principal=ppal;
		JLabel lblCrearEmergencia = new JLabel("Crear Emergencia");
		lblCrearEmergencia.setBounds(156, 5, 137, 22);
		lblCrearEmergencia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblCrearEmergencia);
		
		JLabel lblNewLabel = new JLabel("Descripci\u00F3n");
		lblNewLabel.setBounds(32, 58, 200, 50);
		add(lblNewLabel);
		
		Descripción = new JTextField();
		Descripción.setBounds(127, 73, 290, 58);
		add(Descripción);
		Descripción.setColumns(10);
		
		JLabel lblMagnitud = new JLabel("Magnitud");
		lblMagnitud.setBounds(32, 162, 91, 50);
		add(lblMagnitud);
		
		rdbtnLeve = new JRadioButton("Leve");
		buttonGroup_1.add(rdbtnLeve);
		rdbtnLeve.setBounds(127, 163, 109, 23);
		add(rdbtnLeve);
		
		
		rdbtnModerada = new JRadioButton("Moderada");
		buttonGroup_1.add(rdbtnModerada);
		rdbtnModerada.setBounds(127, 189, 109, 23);
		add(rdbtnModerada);
		
		rdbtnGrave = new JRadioButton("Grave");
		buttonGroup_1.add(rdbtnGrave);
		rdbtnGrave.setBounds(127, 221, 109, 23);
		add(rdbtnGrave);
		
		JLabel lblNewLabel_1 = new JLabel("Consecuencia\r\n");
		lblNewLabel_1.setBounds(32, 265, 200, 50);
		add(lblNewLabel_1);
		
		rdbtnTranviaSigueFuncionando = new JRadioButton("Tranvia sigue funcionando");
		buttonGroup.add(rdbtnTranviaSigueFuncionando);
		rdbtnTranviaSigueFuncionando.setBounds(127, 274, 264, 23);
		add(rdbtnTranviaSigueFuncionando);
		
		rdbtnTranviaFueraDe = new JRadioButton("Tranvia fuera de servicio");
		buttonGroup.add(rdbtnTranviaFueraDe);
		rdbtnTranviaFueraDe.setBounds(127, 306, 188, 23);
		add(rdbtnTranviaFueraDe);
		
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(127, 362, 89, 23);
		add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(226, 362, 89, 23);
		add(btnCancelar);

	}
}
