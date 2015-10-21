import java.awt.*;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.CENTER;
import static javax.swing.GroupLayout.Alignment.LEADING;

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
						si.setVisible(false);
						no.setVisible(false);
						//ConfiguracionManual();
					}
				}
		);
	}
	private ActionListener Configuracion() {
		// TODO Auto-generated method stub

		JLabel titulo = new JLabel("Creacion Aleatoria");
		JLabel filas = new JLabel("Numero de Filas:");
		JLabel porcen = new JLabel("Porcentaje de Obstaculos");
		JLabel columnas = new JLabel("Numero de columnas:");
		JTextField porcen_tex = new JTextField();
		JTextField filas_tex = new JTextField();
		JTextField columnas_text = new JTextField();
		
		
		JButton aceptaB = new JButton("Aceptar");
		JButton cancelaB = new JButton("Cancelar");
		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(layout.createSequentialGroup()
        		.addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(LEADING)
                            .addComponent(filas)
                            .addComponent(filas_tex)
                            
                            )
                    .addGroup(
                        layout.createParallelGroup(LEADING)
                        .addComponent(columnas)
                            .addComponent(columnas_text)
                            .addComponent(porcen)
                            .addComponent(porcen_tex)
                            .addComponent(aceptaB)
                            .addComponent(cancelaB)
            )));
                
            layout.linkSize(SwingConstants.HORIZONTAL, aceptaB, cancelaB);
            
            layout.setVerticalGroup(layout.createSequentialGroup()
            	 .addGroup(
                            layout.createParallelGroup(LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(
                                        layout.createParallelGroup(BASELINE)
                                        .addComponent(filas)
                                        .addComponent(columnas)
                                        .addComponent(porcen)
                                        .addComponent(aceptaB))
                                .addGroup(
                                        layout.createParallelGroup(BASELINE)
                                        .addComponent(filas_tex)
                                        .addComponent(columnas_text)
                                        .addComponent(porcen_tex)
                                        .addComponent(cancelaB))
                )));
            BoxLayout layoutMain = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
            getContentPane().setSize(400,400);
            getContentPane().setLayout(layoutMain);
                 
            setTitle("Crear Mapa Aleatorio");
            pack();
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
            this.add(aceptaB);
            
            aceptaB.addActionListener(
    				new ActionListener() {
    					
    					@Override
    					public void actionPerformed(ActionEvent e) {
    						// TODO Auto-generated method stub
    						int i = Integer.parseInt(filas_tex.getText());
    						int j = Integer.parseInt(columnas_text.getText());
    						int p = Integer.parseInt(porcen_tex.getText());
    						Crear(i,j,0,p);
    						
    					}
    				}
    				
    		);
            this.add(cancelaB);
            cancelaB.addActionListener(
    				new ActionListener() {
    					
    					@Override
    					public void actionPerformed(ActionEvent e) {
    						// TODO Auto-generated method stub
    						
    						//Crear
    						new Menu();
    						setSize(400,400);
    						setVisible(true);
    						
    					}
    				}
    		);
        

		//JOptionPane.showMessageDialog(this, "Creada Matriz de " + matriz.getFilas() +" filas y " + matriz.getColumnas() + " columnas","Configuración inicial", JOptionPane.PLAIN_MESSAGE);
		return null;

		
	}
	/*private ActionListener ConfiguracionManual() {
		// TODO Auto-generated method stub
		

		//MISMO QUE Configuracion();

		this.add(aceptaB);

		aceptaB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i = Integer.parseInt(filas_tex.getText());
				int j = Integer.parseInt(columnas_text.getText());
				Crear(i, j,1);

			}
		}

		);
		this.add(cancelaB);
		cancelaB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// Crear
				new Menu();
				setSize(400, 400);
				setVisible(true);

			}
		});
		return null;
		
	}	
*/
	private ActionListener Crear(int i, int j, int tipo,int por){
	    if(tipo==0){
	    	boolean b=true;
	    }else{
	    	boolean b=false;
	    }
		boolean b=true;
		Matrix matriz = new Matrix(i,j,b,por);
	    return null;
		
	}
	

}
