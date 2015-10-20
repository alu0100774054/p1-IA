import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class Matrix extends JFrame {
	private int COLUMNAS;
	private int FILAS;
	private boolean isRandom;

	public Matrix(int f,int c, boolean b) {
		// TODO Auto-generated constructor stub
		FILAS = f;
		COLUMNAS = c;
		isRandom=b;

		//creamos la matrix
		if (isRandom == true) {
			String porcentajeInput = JOptionPane.showInputDialog("Número de Obstaculos");
			int porcentaje = Integer.parseInt(porcentajeInput);
			getContentPane().setLayout(new GridLayout(FILAS,COLUMNAS));
			ImageIcon aux,aux2,aux3;
			Random aleatorio = new Random();
			int vectorObstaculosI[] = new int[porcentaje];
			int vectorObstaculosJ[] = new int[porcentaje];
			int posicion;
			for (int i = 0; i < porcentaje; i++) {
				posicion=aleatorio.nextInt(FILAS);
				vectorObstaculosI[i]=posicion;
			}
			for (int i = 0; i < porcentaje; i++) {
				posicion=aleatorio.nextInt(COLUMNAS);
				vectorObstaculosJ[i]=posicion;
			}
			aux=new ImageIcon("/Users/erikbv99421/Documents/workspace/Martian/Media/arena.png"); //fondo del mapa
			aux2=new ImageIcon("/Users/erikbv99421/Documents/workspace/Martian/Media/obstaculo.png");	//obstaculo
			aux3=new ImageIcon("/Users/erikbv99421/Documents/workspace/Martian/Media/robot.png");	//robot
			//creamos el mapa
			int k=0;
			for (int i=0;i<FILAS;i++)
				for (int j=0;j<COLUMNAS;j++)
				{
					if ((i==1)&&(j==3)) {
						JLabel picRobot = new JLabel(aux3);
						getContentPane().add(picRobot);
					}
					if ((vectorObstaculosI[k]==i)&&(vectorObstaculosJ[k]==j)) {
						JLabel picbomba = new JLabel(aux2);
						getContentPane().add(picbomba);
						k++;
					}
					JLabel piclabel = new JLabel(aux);
					getContentPane().add(piclabel);
				}

			pack();
			setVisible(true);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		} else {
			//falta el manual
			getContentPane().setLayout(new GridLayout(FILAS,COLUMNAS));
			ImageIcon aux,aux2,aux3;
			aux=new ImageIcon("/Users/erikbv99421/Documents/workspace/Martian/Media/arena.png"); //fondo del mapa
			aux2=new ImageIcon("/Users/erikbv99421/Documents/workspace/Martian/Media/obstaculo.png");	//obstaculo
			aux3=new ImageIcon("/Users/erikbv99421/Documents/workspace/Martian/Media/robot.png");	//robot
			for (int i=0;i<FILAS;i++)
				for (int j=0;j<COLUMNAS;j++)
				{
					if ((i==1)&&(j==3)) {
						JLabel picRobot = new JLabel(aux3);
						getContentPane().add(picRobot);
					}
					JLabel piclabel = new JLabel(aux);
					getContentPane().add(piclabel);
				}
			ManejadorRaton manejador = new ManejadorRaton();
			addMouseListener(manejador);
			addMouseMotionListener(manejador);

			pack();
			setVisible(true);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		}
	}
	private class ManejadorRaton implements MouseListener,MouseMotionListener
	{

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			setElemento(e.getX(), e.getY());
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			setElemento(e.getX(), e.getY());
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public int getFilas() {
		return FILAS;
	}
	public void setFilas(int f) {
		FILAS = f;
	}
	public int getColumnas() {
		return COLUMNAS;
	}
	public void setColumnas(int c) {
		COLUMNAS = c;
	}
	public boolean getRandom() {
		return isRandom;
	}
	public void setRandom(boolean b) {
		isRandom = b;
	}
	public void setElemento(int X, int Y){
		for (int i=0;i<FILAS;i++)
			for (int j=0;j<COLUMNAS;j++)
			{
				if ((i==X)&&(j==Y)) {
					ImageIcon aux2=new ImageIcon("/Users/erikbv99421/Documents/workspace/Martian/Media/obstaculo.png");	//obstaculo
					JLabel picbomba = new JLabel(aux2);
					getContentPane().add(picbomba);
				}
			}
	}
}
