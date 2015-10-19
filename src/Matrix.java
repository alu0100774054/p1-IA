import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

		if (isRandom == true) {
			String porcentajeInput = JOptionPane.showInputDialog("Número de Obstaculos");
			int porcentaje = Integer.parseInt(porcentajeInput);
			getContentPane().setLayout(new GridLayout(FILAS,COLUMNAS));
			ImageIcon aux,aux2;
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
			aux=new ImageIcon("/Users/erikbv99421/Documents/workspace/robot/Icons/foto-cara.png"); //fondo del mapa
			aux2=new ImageIcon("/Users/erikbv99421/Documents/workspace/robot/foto-cara2.png");	//obstaculos
			//creamos el mapa
			int k=0;
			for (int i=0;i<FILAS;i++)
				for (int j=0;j<COLUMNAS;j++)
				{
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
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			
		} else {
			//falta el manual
			getContentPane().setLayout(new GridLayout(FILAS,COLUMNAS));
			ImageIcon aux,aux2;
			for (int i=0;i<FILAS;i++)
				for (int j=0;j<COLUMNAS;j++)
				{
					aux=new ImageIcon("/Users/erikbv99421/Documents/workspace/robot/Icons/foto-cara.png");
					if(i==j){
						aux2=new ImageIcon("/Users/erikbv99421/Documents/workspace/robot/foto-cara2.png");
						JLabel picbomba = new JLabel(aux2);
						getContentPane().add(picbomba);
					}
					JLabel piclabel = new JLabel(aux);
					getContentPane().add(piclabel);
				}
			pack();
			setVisible(true);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			
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
}
