package algoritmos;


import java.util.ArrayList;
import java.util.HashMap;

import util.Grafo;

public class CaminhoMinimo {
	
	private static final int infinityInt = 999999;
	
	Grafo G;
	private Integer u;
	private Integer min;
	
	private ArrayList <Integer> Q;
	private int[] caminho;
	
	public void Dijkstra(Grafo G, Integer s) {
		Integer [] dist;
		Integer [] pred;
		//para cada vértice v em V faça:
		dist = new Integer[G.V.size()];
		pred = new Integer[G.V.size()];
		for (Integer i = 0; i < G.V.size(); ++i) {
			dist[i] = infinityInt;
			pred[i] = null;
		}
		//dist[s] <- 0
		dist[s] = 0;
		
		//Q <- V
		Q = new ArrayList<>();
		for(int i = 0; i < G.V.size(); ++i)
			Q.add(G.V.get(i));
		
		while(!Q.isEmpty()) {
			u = 0;
			min = infinityInt;
			//u ← i : min{dist[i], ∀ i ∈ Q}
			for(int i = 0; i < Q.size(); ++i) {
				
				if(dist[Q.get(i)] < min) {
					
					u = Q.get(i);
					min = dist[i];

					
				}
			}
			//Q ← Q – {u}
			Q.remove(u);
			//para cada vértice v adjacente a u faça
			for(int i = 0; i < G.listaAdj.get(u).size(); ++i) {
				//se dist[v] > dist[u] + w(u, v) então
				if(dist[G.listaAdj.get(u).get(i).destino] > dist[u] + G.listaAdj.get(u).get(i).peso) {
					//dist[v] ← dist[u] + w(u, v)
					dist[G.listaAdj.get(u).get(i).destino] = dist[u] + G.listaAdj.get(u).get(i).peso;
					//pred[v] ← u
					pred[G.listaAdj.get(u).get(i).destino] = u;
				}
			}
		}
		for(int i = 0; i < G.V.size(); ++i) {
			System.out.println("vetor = " + i + " dist = " + dist[i] + " pred = " +pred[i]);
		}
	}
	
	public boolean Bellman_Ford(Grafo G, Integer s) {
		Integer [] dist;
		Integer [] pred;
		//para cada vértice v em V faça:
		dist = new Integer[G.V.size()];
		pred = new Integer[G.V.size()];
		for (Integer i = 0; i < G.V.size(); ++i) {
			dist[i] = infinityInt;
			pred[i] = null;
		}
		//dist[s] <- 0
		dist[s] = 0;
		
		//para cada vértice i em V faça
		for(int i = 0; i < G.V.size(); ++i) {
			for(int j = 0; j < G.listaAdj.get(i).size(); ++j) {
				//se dist[v] > dist[u] + w(u, v) então
				if(dist[G.listaAdj.get(i).get(j).destino] > dist[G.listaAdj.get(i).get(j).origem] + G.listaAdj.get(i).get(j).peso) {
					dist[G.listaAdj.get(i).get(j).destino] = dist[G.listaAdj.get(i).get(j).origem] + G.listaAdj.get(i).get(j).peso;
					pred[G.listaAdj.get(i).get(j).destino] = G.listaAdj.get(i).get(j).origem;
				}
			}
		}
		for(int i = 0; i < G.V.size(); ++i) {
			System.out.println("vetor = " + i + " dist = " + dist[i] + " pred = " +pred[i]);
		}
		for(int i = 0; i < G.V.size(); ++i) {
			for(int j = 0; j > G.listaAdj.get(i).size(); ++j) {
				//se dist[v] > dist[u] + w(u, v) então
				if(dist[G.listaAdj.get(i).get(j).destino] > dist[G.listaAdj.get(i).get(j).origem] + G.listaAdj.get(i).get(j).peso) {
					return false;
				}
			}
		}
		return true;
	}
	public void Floyd_Warshall(Grafo G) {
		Integer [][] dist;
		Integer [][] pred;
		
		dist = new Integer[G.V.size()][G.V.size()];
		pred = new Integer[G.V.size()][G.V.size()];
		for(int i = 0; i < G.V.size(); ++i) {
			for(int j = 0; j < G.V.size(); ++j) {
				
				if (i == j)
					dist[i][j] = 0;
				else if(G.matrizAdj[i][j] != 0) {
					dist[i][j] = G.matrizAdj[i][j];
					pred[i][j] = i;
				}
				else {
					dist[i][j] = infinityInt;
					pred[i][j] = null;
				}
			}
		}
		for(int k = 0 ; k < G.V.size(); ++k) {
			for(int i = 0 ; i < G.V.size(); ++i) {
				for(int j = 0 ; j < G.V.size(); ++j) {
					
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
						pred[i][j] = pred[k][j];
						
					}
					
				}
			}
		}
		for(int i = 0; i < G.V.size(); ++i) {
			System.out.println("\nVertice = " + i);
			System.out.print("dist = ");
			for(int j = 0; j < G.V.size(); ++j) {
				System.out.print(dist[i][j] + "|");	
			}
			System.out.print(" pred = ");
			for(int j = 0; j < G.V.size(); ++j) {
				System.out.print(pred[i][j] + "|");
			}
			
			System.out.println();
		}
//		for(int i = 0; i < G.V.size(); ++i) {
//			for(int j = 0; j < G.V.size(); ++j) {
//				System.out.print(pred[i][j]+ "|");
//			}
//			System.out.println("\n");
//		}
		
	}
}