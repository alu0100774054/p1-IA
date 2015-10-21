import java.awt.*;

import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Random;
import java.util.Vector;

import javax.swing.*;
import java.lang.reflect.Array;
public class Matrix extends JFrame {
	private int COLUMNAS;
	private int FILAS;
	private boolean isRandom;
	ImageIcon fondo,obstaculo,robot_explorador,robot_recogedor,paquete;
	public Matrix(int f,int c, boolean b) {
		// TODO Auto-generated constructor stub
		//Inicializa los atributos
		FILAS = f;
		COLUMNAS = c;
		isRandom=b;
		/*fondo = new ImageIcon("/Users/erikbv99421/Documents/workspace/p1-IA/Media/arena.png");
		obstaculo = new ImageIcon("/Users/erikbv99421/Documents/workspace/p1-IA/Media/obstaculo.png");
		robot_explorador = new ImageIcon("/Users/erikbv99421/Documents/workspace/p1-IA/Media/robot.png");
		robot_recogedor = new ImageIcon("/Users/erikbv99421/Documents/workspace/p1-IA/Media/robot2.png");
		paquete = new ImageIcon("/Users/erikbv99421/Documents/workspace/p1-IA/Media/paquete.png");*/
		
		fondo = new ImageIcon("C:/Users/quino/workspace/p1-IA/Media/arena.jpg");
		obstaculo = new ImageIcon("C:/Users/quino/workspace/p1-IA/Media/obstaculo.png");
		robot_explorador = new ImageIcon("C:/Users/quino/workspace/p1-IA/Media/robot.png");
		robot_recogedor = new ImageIcon("C:/Users/quino/workspace/p1-IA/Media/robot2.png");
		paquete = new ImageIcon("C:/Users/quino/workspace/p1-IA/Media/paquete.png");
		

		//creamos la matrix
		if (isRandom == true) {
			
			getContentPane().setLayout(new GridLayout(FILAS,COLUMNAS));	//crea la matriz
			CargaElementos();
			PedirPorcentaje();	//pide porcentaje y devuelve el numero de obstaculos
			pack();
			setVisible(true);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		} else {
			//falta el manual
			getContentPane().setLayout(new GridLayout(FILAS,COLUMNAS));
			CargaElementos();
			ManejadorRaton manejador = new ManejadorRaton();
			addMouseListener(manejador);
			addMouseMotionListener(manejador);

			pack();
			setVisible(true);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		}
	}
	private void CargaElementos() {
		// TODO Auto-generated method stub
		//creamos el mapa
		for (int i=0;i<FILAS;i++)
			for (int j=0;j<COLUMNAS;j++)
			{
				JLabel picFondo = new JLabel(fondo);
				getContentPane().add(picFondo);
			}
	}
	private void GenerarVector(int tamanyo) {
		// TODO Auto-generated method stub
		Vector<Integer> v = new Vector<Integer>(tamanyo);
		int aux;
		for (int i = 0; i < tamanyo; i++) {
			aux=GeneraAleatorio(tamanyo());
			v.insertElementAt(aux, i);
		}
		v.sort(null);
		RellenarObstaculos(v);
	}

	private void RellenarObstaculos(Vector<Integer> v) {
		// TODO Auto-generated method stub
		
		int	i = 0,k=0;
		for (int filas = 0; filas < FILAS; filas++) {
			k++;
			for (int Columnas = 0; Columnas < COLUMNAS; Columnas++) {
				if (v.get(i) == k) {
					JLabel picbomba = new JLabel(obstaculo);
					getContentPane().add(picbomba);
					i++;
				}
				k++;
			}
		}
	}
	private int GeneraAleatorio(int precision) {
		// TODO Auto-generated method stub
		Random aleatorio = new Random();
		int nAleatorio = aleatorio.nextInt(precision);
		return nAleatorio;
	}
	private void PedirPorcentaje() {
		// TODO Auto-generated method stub
		String porcentajeInput = JOptionPane.showInputDialog("Porcentaje de Obstaculos");
		int porcentaje = Integer.parseInt(porcentajeInput);
		int nObstaculos = ((porcentaje*tamanyo())/100);
		GenerarVector(nObstaculos);
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
	public int tamanyo() {
		return FILAS*COLUMNAS;
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
					JLabel picObstaculo = new JLabel(obstaculo);
					getContentPane().add(picObstaculo);
				}
			}
	}
}
