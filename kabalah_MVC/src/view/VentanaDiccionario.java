package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.sun.corba.se.internal.iiop.ORB;

public class VentanaDiccionario extends JFrame {

	private final String url ="http://www.morfix.co.il/en/";
	private String end;
	private String init;
	
	
	
	

	public VentanaDiccionario(List<String> l) {
		super("Diccionarios online");

		
		int n = (int) Math.floor(Math.sqrt(l.size())) +1;

		// panel principal
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout());

		JPanel visoresPanel = new JPanel();
		visoresPanel.setLayout(new GridLayout());
		
		this.setSize(new Dimension(800, 600));
		
		
	
			for (int i = 0; i < n; i++){
				
				
					init = url;
					end = l.get(i);
					l.remove(i);
					init += end;
					String command = "firefox "+init;
					
					SwingUtilities.invokeLater(new Runnable() {

						@Override
						public void run() {
							try {
								Runtime.getRuntime().exec(command);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
							
							
						}
					});
					
					
					
					
					
			
					
					
			
				end="";init="";
			
		
		
	
	}
	

	}}
