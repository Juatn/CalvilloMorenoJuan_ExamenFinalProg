package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import Models.Vehiculo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.awt.Color;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PagoSalida extends JFrame {

	protected JFrame frame;
	private JButton btnNewButton;
	private JButton buttonpagosalida;
	private JButton buttoncaja;
	private JLabel lblMatricula;
	private JLabel lblHoraEntrada;
	private JLabel lblHolaSalida;
	private JTextPane textmatricula;
	private JTextPane texthoraentrada;
	private JTextPane texthorasalida;
	private JButton buttonsalir;
	private JLabel lblPrecio;
	private JButton buttonanterior;
	private JButton buttonsiguiente;
	private JLabel labelveh;
	protected int indice = 0;
	private JButton buttonverveh;
	private JLabel labelapagar;
	private JLabel lblEuros;
	private JLabel lblCambio;
	private JLabel lblcambio;
	private JLabel label;
	private JLabel lblInsertCoin;
	private JTextPane textcoin;
	protected double precio=0;
	static double cajatotal=0;
	private JButton buttoncambio;
	protected boolean controldinero=true;


	/**
	 * Create the application.
	 */
	public PagoSalida() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 671, 532);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnNewButton = new JButton("Entrada Vehiculo");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setVisible(false);
				Entrada c=new Entrada();
				c.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(38, 16, 159, 91);
		frame.getContentPane().add(btnNewButton);

		buttonpagosalida = new JButton("Pago y Salida");
		buttonpagosalida.setBounds(255, 16, 159, 91);
		frame.getContentPane().add(buttonpagosalida);

		buttoncaja = new JButton("Caja dia");
		buttoncaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "La caja del dia asciende a "+PagoSalida.cajatotal, "CAJA",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		buttoncaja.setBounds(458, 16, 159, 91);
		frame.getContentPane().add(buttoncaja);

		lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(38, 215, 69, 20);
		frame.getContentPane().add(lblMatricula);

		lblHoraEntrada = new JLabel("Hora Entrada:");
		lblHoraEntrada.setBounds(38, 276, 106, 20);
		frame.getContentPane().add(lblHoraEntrada);

		lblHolaSalida = new JLabel("Hora Salida:");
		lblHolaSalida.setBounds(38, 334, 106, 20);
		frame.getContentPane().add(lblHolaSalida);

		textmatricula = new JTextPane();
		textmatricula.setBounds(160, 209, 184, 34);
		frame.getContentPane().add(textmatricula);

		texthoraentrada = new JTextPane();
		texthoraentrada.setBounds(159, 276, 184, 34);
		frame.getContentPane().add(texthoraentrada);

		texthorasalida = new JTextPane();
		texthorasalida.setBounds(160, 326, 184, 34);
		frame.getContentPane().add(texthorasalida);

		JButton btnPagarYSalir = new JButton("Pagar ");
		btnPagarYSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// visible
				lblInsertCoin.setVisible(true);
				textcoin.setVisible(true);
				// creo fecha ahora
				Date a = new Date();
				Vehiculo p = Contenedor.Lista.ListaVehiculo.get(indice);
				p.setFechaSalida(a);
				texthorasalida.setText(p.getFechaSalida().toString());

				// calculo precio

				// de entrada
				int horaentrada = p.getFechaEntrada().getHours();
				int minutoentrada = p.getFechaEntrada().getMinutes();

				// salida

				int horasalida = p.getFechaSalida().getHours();
				int minutosalida = p.getFechaSalida().getMinutes();

				// prec
				int hora = horaentrada - horasalida;
				int c = hora * 60;
				int b = minutoentrada - minutosalida;

				int minutos = c + b;
				
				precio=(minutos*0.15);
				
				p.setDinero(precio);
				
				labelapagar.setText(""+p.getDinero());
				
				cajatotal=cajatotal+precio;

			}
		});
		btnPagarYSalir.setBounds(188, 396, 156, 45);
		frame.getContentPane().add(btnPagarYSalir);

		buttonsalir = new JButton("Salir");
		buttonsalir.setBackground(new Color(255, 102, 102));
		buttonsalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setVisible(false);
				Entrada c = new Entrada();
				c.frame.setVisible(true);
			}
		});
		buttonsalir.setBounds(15, 384, 123, 69);
		frame.getContentPane().add(buttonsalir);

		lblPrecio = new JLabel("Total a pagar");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setBounds(428, 196, 157, 20);
		frame.getContentPane().add(lblPrecio);

		buttonanterior = new JButton("<");
		buttonanterior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				vehanterior();
				imprimirveh();
				updateContador();
			}

		});
		buttonanterior.setBounds(53, 151, 62, 29);
		frame.getContentPane().add(buttonanterior);

		buttonsiguiente = new JButton(">");
		buttonsiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				vehsiguiente();
				imprimirveh();
				updateContador();
			}
		});
		buttonsiguiente.setBounds(282, 151, 62, 29);
		frame.getContentPane().add(buttonsiguiente);

		labelveh = new JLabel("");
		labelveh.setBounds(130, 155, 137, 25);
		frame.getContentPane().add(labelveh);

		buttonverveh = new JButton("Ver vehiculos");
		buttonverveh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				updateContador();
				imprimirveh();
			}
		});
		buttonverveh.setBounds(140, 111, 137, 29);
		frame.getContentPane().add(buttonverveh);

		labelapagar = new JLabel("0");
		labelapagar.setBounds(458, 247, 127, 34);
		frame.getContentPane().add(labelapagar);

		lblEuros = new JLabel("Euros.");
		lblEuros.setForeground(new Color(0, 0, 255));
		lblEuros.setBounds(516, 297, 69, 20);
		frame.getContentPane().add(lblEuros);

		lblCambio = new JLabel("Cambio:");
		lblCambio.setBounds(458, 363, 69, 20);
		frame.getContentPane().add(lblCambio);

		lblcambio = new JLabel("");
		lblcambio.setBounds(480, 408, 69, 20);
		frame.getContentPane().add(lblcambio);

		label = new JLabel("Euros.");
		label.setForeground(Color.BLUE);
		label.setBounds(516, 433, 69, 20);
		frame.getContentPane().add(label);

		lblInsertCoin = new JLabel("Insert coin:");

		lblInsertCoin.setBounds(385, 123, 91, 34);
		lblInsertCoin.setVisible(false);
		frame.getContentPane().add(lblInsertCoin);

		textcoin = new JTextPane();
		textcoin.setBounds(480, 123, 137, 34);
		textcoin.setVisible(false);
		frame.getContentPane().add(textcoin);
		
		buttoncambio = new JButton("Dar cambio");
		buttoncambio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				double dinero=Double.parseDouble(textcoin.getText());
				double cambioadar=dinero-precio;
				
				if (dinero == precio) {
					JOptionPane.showMessageDialog(null, "Me has dado el dinero justo", "Sin cambio",
							JOptionPane.INFORMATION_MESSAGE);
				}
				if (dinero < precio) {
					JOptionPane.showMessageDialog(null, "FALTAN " + cambioadar + " Euros", "EEH!",
							JOptionPane.ERROR_MESSAGE);
				}
				if(controldinero){
					cajatotal = cajatotal + (dinero - cambioadar);
					controldinero=false;
					
				}
				Entrada.esta=false;
			}
			
		});
		buttoncambio.setBounds(458, 171, 142, 20);
		frame.getContentPane().add(buttoncambio);
	}

	private void updateContador() {
		labelveh.setText((indice + 1) + " de " + Contenedor.Lista.ListaVehiculo.size());
	}

	private int vehsiguiente() {
		++indice;
		if (indice == Contenedor.Lista.ListaVehiculo.size()) {
			indice = 0;
		}
		return indice;

	}

	private int vehanterior() {
		--indice;
		if (indice < 0) {
			indice = Contenedor.Lista.ListaVehiculo.size() - 1;
		}
		return indice;

	}

	public void imprimirveh() {

		Vehiculo p = Contenedor.Lista.ListaVehiculo.get(indice);

		textmatricula.setText(p.getMatricula());

		texthoraentrada.setText(p.getFechaEntrada().toString());

	}

}
