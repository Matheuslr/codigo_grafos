package util;

import java.util.ArrayList;

public class Grafo {
	
	public ArrayList<Integer> V;
    public ArrayList<Aresta> I;
    public int [] [] matrizAdj;
    public ArrayList<ArrayList<Aresta>> listaAdj;
	public Grafo(ArrayList<Integer> v, ArrayList<Aresta> i, int[][] matrizAdj, ArrayList<ArrayList<Aresta>> listaAdj) {
		super();
		V = v;
		I = i;
		this.matrizAdj = matrizAdj;
		this.listaAdj = listaAdj;
	}
	public ArrayList<Integer> getV() {
		return V;
	}
	public void setV(ArrayList<Integer> v) {
		V = v;
	}
	public ArrayList<Aresta> getI() {
		return I;
	}
	public void setI(ArrayList<Aresta> i) {
		I = i;
	}
	public int[][] getMatrizAdj() {
		return matrizAdj;
	}
	public void setMatrizAdj(int[][] matrizAdj) {
		this.matrizAdj = matrizAdj;
	}
	public ArrayList<ArrayList<Aresta>> getListaAdj() {
		return listaAdj;
	}
	public void setListaAdj(ArrayList<ArrayList<Aresta>> listaAdj) {
		this.listaAdj = listaAdj;
	}
    
    
}
