package principal;

import javax.swing.SwingUtilities;

import vistas.VentanaLogIn;

public class App {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				VentanaLogIn v = new VentanaLogIn();
				v.pack();
				v.setVisible(true);
			}
		});
	}

}
