package vista;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;

public class ClientesView extends JPanel {

	/**
	 * Create the panel.
	 */
	public ClientesView() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("ver listado clientes");
		add(lblNewLabel);

	}

}
