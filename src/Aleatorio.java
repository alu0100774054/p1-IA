import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Aleatorio extends JFrame{
	
	
	public  Aleatorio() {
		
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
		
	}

}
