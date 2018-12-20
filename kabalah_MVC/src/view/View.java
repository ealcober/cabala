package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javax.swing.border.Border;

import controller.Controller;

import model.Model;

public class View extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Model alefato = new Model();
	Controller ctrl = new Controller(new Model());

	int valor = 0;
	Boolean terminado = false;

	public View() {
		super("Kabbalah v1.0");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// panel principal
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout());

		JPanel visoresPanel = new JPanel();
		visoresPanel.setLayout(new GridLayout(3, 2));

		// text Area Permutaciones
		JTextArea permShow = new JTextArea();
		permShow.setEditable(false);

		Border border = BorderFactory.createLineBorder(Color.BLACK);
		permShow.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));

		// botones alefato
		JPanel panelAlefato = new JPanel();
		panelAlefato.setLayout(new GridLayout(6, 4));
		panelAlefato.setPreferredSize(new Dimension(500, 30));

		// visores
		JTextArea visor = new JTextArea(2, 20);
		visor.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		visor.setEditable(false);
		/*
		 * Font f = visor.getFont(); float size = f.getSize() + 1.0f; visor.setFont(
		 * f.deriveFont(size) );
		 */

		// suma de visor
		JTextArea suma = new JTextArea(2, 20);
		suma.setEditable(false);
		suma.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));

		suma.setText(String.valueOf(0));

		JLabel permute = new JLabel("Permutaciones");
		JLabel introduzca = new JLabel("Introduzca el texto");
		JLabel sumaG = new JLabel("Suma de Guematria");

		for (int i = 0; i < 27; i++) {

			JButton b = new JButton(Model.alefato[i]);
			b.setToolTipText("letter:" + " " + Model.alefato[i] + " " + "Value: " + Model.valor[i]);

			b.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {

					if (terminado) {

						Model.conjunto.clear();
						visor.setText("");
						suma.setText(String.valueOf(0));
						permShow.setText("");
						ctrl.clearSb();
						valor = 0;

						ctrl.addConjuntoString(b.getText());
						visor.append(b.getText());
						valor = Model.getValor(b.getText());
						suma.setText(String.valueOf(Integer.parseInt(suma.getText()) + valor));
						terminado = false;

					} else {

						ctrl.addConjuntoString(b.getText());
						visor.append(b.getText());
						valor = Model.getValor(b.getText());
						suma.setText(String.valueOf(Integer.parseInt(suma.getText()) + valor));
					}

				}
			});
			panelAlefato.add(b);

		}

		JButton c = new JButton("borrar");
		c.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Model.conjunto.clear();
				visor.setText("");
				suma.setText(String.valueOf(0));
				permShow.setText("");
				ctrl.clearSb();
				valor = 0;

			}
		});
		panelAlefato.add(c);

		JButton calc = new JButton("permuta");
		calc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				StringBuilder permutaciones = ctrl.permutaSb("");

				permShow.setText(permutaciones.toString());
				List<String> l = new LinkedList<String>();
				String[] s = permutaciones.toString().split("\n");
				for (int i = 0; i < s.length; i++) {
					l.add(s[i]);
				}

				JFrame ventanaDiccionario = new VentanaDiccionario(l);
				// ventanaDiccionario.setVisible(true);
				terminado = true;

			}
		});
		panelAlefato.add(calc);

		panelPrincipal.add(panelAlefato, BorderLayout.EAST);

		visoresPanel.add(permute);

		JScrollPane scroll = new JScrollPane(permShow, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		visoresPanel.add(scroll);
		permShow.setVisible(true);

		visoresPanel.add(sumaG);
		visoresPanel.add(suma);
		visoresPanel.add(introduzca);
		visoresPanel.add(visor);

		panelPrincipal.add(visoresPanel, BorderLayout.CENTER);

		this.add(panelPrincipal);

		this.pack();

		this.setSize(800, 400);

		// this.setIconImage(this.getIconImage());
		this.setVisible(true);

	}
	/*
	 * @Override public Image getIconImage() { Image retValue =
	 * Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource(
	 * "path_to_window_icon.jpg"));
	 * 
	 * return retValue; }
	 */

}
