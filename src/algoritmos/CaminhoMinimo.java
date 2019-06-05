package algoritmos;


import java.util.ArrayList;
import java.util.HashMap;

import util.Grafo;

public class CaminhoMinimo {
	
	private static final int infinityInt = 999999;
	
	Grafo G;
	private Integer u;
	private Integer min;
	private Integer [] dist;
	private Integer [] pred;
	private ArrayList <Integer> Q;
	private int[] caminho;
	
	public void Dijkstra(Grafo G, Integer s) {
		//para cada vértice v em V faça:
		dist = new Integer[G.V.size()];
		pred = new Integer[G.V.size()];
		for (Integer i = 0; i < G.V.size(); ++i) {
			dist[i] = infinityInt;
			pred[i] = -1;
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

}