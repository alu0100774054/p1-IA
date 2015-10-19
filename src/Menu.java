import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class Menu extends JFrame {
	
	public Menu() {
		// TODO Auto-generated constructor stub
		super("Martian");
		
		JMenu menuMartian = new JMenu("Options");
		menuMartian.setMnemonic('O');
		
		//crea el elemento salir
		JMenuItem elementoSalir = new JMenuItem("Exit");
		elementoSalir.setMnemonic('E');
		menuMartian.add(elementoSalir);
		elementoSalir.addActionListener(
				new ActionListener() {
					
					//termina cuando el usuario hace clic en elementoSalir
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						System.exit(0); //sale de la aplicación
					}
				}
		);
		
		//crea el elemento cerrar mapa
				JMenuItem elementoCerrar = new JMenuItem("Close");
				elementoSalir.setMnemonic('C');
				menuMartian.add(elementoCerrar);
				elementoSalir.addActionListener(
						new ActionListener() {
							
							//termina cuando el usuario hace clic en elementoSalir
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								Actualizar(); //cierra el mapa
							}
						}
				);
		JMenuBar barra = new JMenuBar();	//crea la barra de menús
		setJMenuBar(barra); 	//agrega la barra de menús a la aplicación
		barra.add(menuMartian);	//agrega el menuMartian a la barra de menús
		
		Modo();
	}
	private void Modo() {
		// TODO Auto-generated method stub
		FlowLayout layout = new FlowLayout();
		setLayout(layout);

		JButton si = new JButton("Generar mapa aleatorio");
		JButton no = new JButton("Genererar mapa manualmente");
		
		this.add(si);
		si.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Configuracion();
					}
				}
		);
		this.add(no);
		no.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						ConfiguracionManual();
					}
				}
		);
	}
	private ActionListener Configuracion() {
		// TODO Auto-generated method stub
		
		String inputFilas = JOptionPane.showInputDialog("Introduzca el número de filas");
		String inputColumnas = JOptionPane.showInputDialog("Introduzca el número de columnas");
		
		int i = Integer.parseInt(inputFilas);
		int j = Integer.parseInt(inputColumnas);
		boolean b=true;
		Matrix matriz = new Matrix(i,j,b);
		
		JOptionPane.showMessageDialog(this, "Creada Matriz de " + matriz.getFilas() +" filas y " + matriz.getColumnas() + " columnas","Configuración inicial", JOptionPane.PLAIN_MESSAGE);
		return null;
		
	}
	private ActionListener ConfiguracionManual() {
		// TODO Auto-generated method stub
		
		
		String inputFilas = JOptionPane.showInputDialog("Introduzca el número de filas");
		String inputColumnas = JOptionPane.showInputDialog("Introduzca el número de columnas");
		
		int i = Integer.parseInt(inputFilas);
		int j = Integer.parseInt(inputColumnas);
		boolean b=false;
		Matrix matriz = new Matrix(i,j,b);
		
		JOptionPane.showMessageDialog(this, "Creada Matriz de " + matriz.getFilas() +" filas y " + matriz.getColumnas() + " columnas","Configuración inicial", JOptionPane.PLAIN_MESSAGE);
		return null;
		
	}
	public void Actualizar() {
		Configuracion();
	}
}
