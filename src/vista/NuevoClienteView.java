package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class NuevoClienteView extends JPanel {

	/**
	 * Create the panel.
	 */
	public NuevoClienteView() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Nuevo cliente");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		add(lblNewLabel);

	}

}
