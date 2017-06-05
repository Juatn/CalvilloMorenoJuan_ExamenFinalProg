package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextPane;

import Models.Vehiculo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Entrada extends JFrame {

	public JFrame frame;
	private JButton buttonentrada;
	private JButton buttonsalida;
	private JButton buttoncaja;
	private JButton buttonregistrar;
	private JLabel lblmatricula;
	static JTextPane textMatricula;
	static Vehiculo c1;
	static boolean esta = false;

	

	/**
	 * Create the application.
	 */
	public Entrada() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 660, 565);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		buttonentrada = new JButton("Entrada Vehiculo");
		buttonentrada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				textMatricula.setVisible(true);
				lblmatricula.setVisible(true);
				buttonregistrar.setVisible(true);

			}
		});
		buttonentrada.setBounds(28, 61, 161, 92);
		frame.getContentPane().add(buttonentrada);

		buttonsalida = new JButton("Pago/Salida");
		buttonsalida.setBounds(237, 61, 161, 92);
		frame.getContentPane().add(buttonsalida);

		buttoncaja = new JButton("Caja del dia");
		buttoncaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "La caja del dia asciende a " + PagoSalida.cajatotal, "CAJA",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		buttoncaja.setBounds(448, 61, 161, 92);
		frame.getContentPane().add(buttoncaja);

		textMatricula = new JTextPane();
		textMatricula.setBounds(111, 260, 287, 43);
		textMatricula.setVisible(false);
		frame.getContentPane().add(textMatricula);

		lblmatricula = new JLabel("Matricula:");
		lblmatricula.setBounds(111, 224, 69, 20);
		lblmatricula.setVisible(false);
		frame.getContentPane().add(lblmatricula);

		buttonregistrar = new JButton("Registrar");
		buttonregistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		buttonregistrar.setVisible(false);

		buttonregistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String matri = textMatricula.getText().trim();

				// hacer visible la nueva ventana y agregar fecha entrada
				frame.setVisible(false);
				Date p = new Date();

				c1 = new Vehiculo(p, matri);
				Contenedor.Lista.ListaVehiculo.add(c1);
				PagoSalida c = new PagoSalida();
				c.frame.setVisible(true);

			}

		});
		buttonregistrar.setBounds(189, 371, 209, 68);
		frame.getContentPane().add(buttonregistrar);
	}
}
