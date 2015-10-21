import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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
						si.setVisible(false);
						no.setVisible(false);
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
		
		JLabel filas = new JLabel("Numero de filas:");
		JLabel columnas = new JLabel("Numero de columnas:");
		JTextField filas_tex = new JTextField();
		JTextField columnas_text = new JTextField();
		
		
		JButton aceptaB = new JButton("Aceptar");
		JButton cancelaB = new JButton("Cancelar");
		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(filas)
                .addComponent(columnas)
                .addGroup(layout.createParallelGroup()
                    .addComponent(filas_tex)
                    .addComponent(columnas_text)
                    .addGroup(layout.createSequentialGroup()
                        
                        
                .addGroup(layout.createParallelGroup()
                    .addComponent(aceptaB)
                    .addComponent(cancelaB))
            )));
                
            layout.linkSize(SwingConstants.HORIZONTAL, aceptaB, cancelaB);
            
            layout.setVerticalGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                		.addComponent(filas)
                        .addComponent(columnas)
                        .addComponent(filas_tex)
                        .addComponent(columnas_text)
                        .addComponent(aceptaB))
                    .addGroup(layout.createParallelGroup()
                        
                        .addComponent(cancelaB))
                );
     
            setTitle("Crear");
            pack();
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		/*tring inputFilas = JOptionPane.showInputDialog("Introduzca el número de filas");
		String inputColumnas = JOptionPane.showInputDialog("Introduzca el número de columnas");
		
		int i = Integer.parseInt(inputFilas);
		int j = Integer.parseInt(inputColumnas);
		boolean b=true;
		Matrix matriz = new Matrix(i,j,b);
		
		JOptionPane.showMessageDialog(this, "Creada Matriz de " + matriz.getFilas() +" filas y " + matriz.getColumnas() + " columnas","Configuración inicial", JOptionPane.PLAIN_MESSAGE);*/
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
}
