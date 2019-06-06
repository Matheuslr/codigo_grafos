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
	public void Dijkstra(Grafo G, Integer s, Integer t) {
		System.out.println("Dijkstra: ");
		System.out.println("Processando...");
		long tempoInicial = System.currentTimeMillis();
		Integer [] dist;
		Integer [] pred;
		Q = new ArrayList<>();
		//para cada vértice v em V faça:
		dist = new Integer[G.V.size()];
		pred = new Integer[G.V.size()];
		for (Integer i = 0; i < G.V.size(); i++) {
			dist[i] = infinityInt;
			pred[i] = null;
			//Q <- V
			Q.add(G.V.get(i));
		}
		//dist[s] <- 0
		dist[s] = 0;
			
		
		while(!Q.isEmpty()) {
			u = 0;
			min = infinityInt;
			//u ← i : min{dist[i], ∀ i ∈ Q}
			for(int i = 0; i < Q.size(); i++) {
				
				if(dist[Q.get(i)] < min) {
					u = Q.get(i);
					min = dist[Q.get(i)];

				}
			}
			//Q ← Q – {u}
			Q.remove(u);
			//para cada vértice v adjacente a u faça
			for(int i = 0; i < G.listaAdj.get(u).size(); i++) {
				//se dist[v] > dist[u] + w(u, v) então
				if(dist[G.listaAdj.get(u).get(i).destino] > dist[u] + G.listaAdj.get(u).get(i).peso) {
					//dist[v] ← dist[u] + w(u, v)
					dist[G.listaAdj.get(u).get(i).destino] = dist[u] + G.listaAdj.get(u).get(i).peso;
					//pred[v] ← u
					pred[G.listaAdj.get(u).get(i).destino] = u;
				}
			}
		}
		
		long tempoFinal = System.currentTimeMillis();
		float tempo = (tempoFinal - tempoInicial);
		System.out.println("Tempo gasto = " + tempo/1000F + "s");
		retorna_caminho(s, t, pred);
		System.out.println("Custo = " + dist[t]);
		
	}
	
	public boolean Bellman_Ford(Grafo G, Integer s, Integer t) {
		System.out.println("Bellman_Ford: ");
		System.out.println("Processando...");
		long tempoInicial = System.currentTimeMillis();
		Integer [] dist;
		Integer [] pred;
		Q = new ArrayList<>();
		
		//para cada vértice v em V faça:
		dist = new Integer[G.V.size()];
		pred = new Integer[G.V.size()];
		for (Integer i = 0; i < G.V.size(); i++) {
			dist[i] = infinityInt;
			pred[i] = null;
			//Q <- V
			Q.add(G.V.get(i));
		}
		//dist[s] <- 0
		dist[s] = 0;
		//Q.get(i)
		//para cada vértice i em V faça
		for(int i = 0; i < G.V.size(); i++) {
			for(int j = 0; j < G.I.size(); j++) {
				//se dist[v] > dist[u] + w(u, v) então 
				if(dist[G.I.get(j).destino] > dist[G.I.get(j).origem] + G.I.get(j).peso) {
					dist[G.I.get(j).destino] = (dist[G.I.get(j).origem] + G.I.get(j).peso);
					pred[G.I.get(j).destino] = G.I.get(j).origem;
				}
			}
		}
		
		long tempoFinal = System.currentTimeMillis();
		
		float tempo = (tempoFinal - tempoInicial);
		System.out.println("Tempo gasto = " + tempo/1000F + "s");
	    retorna_caminho(s, t, pred);
	    System.out.println("Custo = " + dist[t]);
	    
		for(int i = 0; i < G.V.size(); ++i) {
			for(int j = 0; j > G.listaAdj.get(i).size(); j++) {
				//se dist[v] > dist[u] + w(u, v) então
				if(dist[G.listaAdj.get(i).get(j).destino] > dist[G.listaAdj.get(i).get(j).origem] + G.listaAdj.get(i).get(j).peso) {
					return false;
				}
			}
		}
		return true;
	}
	public void Floyd_Warshall(Grafo G,Integer s, Integer t) {
		System.out.println("Floyd_Warshall: ");
		System.out.println("Processando...");
		long tempoInicial = System.currentTimeMillis();
		Integer [][] dist;
		Integer [][] pred;
		
		dist = new Integer[G.V.size()][G.V.size()];
		pred = new Integer[G.V.size()][G.V.size()];
		//para cada vértice i em V faça
		for(int i = 0; i < G.V.size(); i++) {
			//para cada vértice j em V faça
			for(int j = 0; j < G.V.size(); j++) {
				//sei=jentão
				if (i == j)
					//dist [ i ][ j ] ← 0
					dist[i][j] = 0;
				//senão se (i, j) ∊ E então
				else if(G.matrizAdj[i][j] != 0) {
					//dist [ i ][ j ] ← w[ i ][ j ]
					dist[i][j] = G.matrizAdj[i][j];
					//pred [ i ] [ j ] ← i
					pred[i][j] = i;
				}
				else {
					//dist [ i ][ j ] ← ∞
					dist[i][j] = infinityInt;
					//pred [ i ] [ j ] ← null
					pred[i][j] = -1;
				}
			}
		}
		//para cada vértice k em V faça
		for(int k = 0 ; k < G.V.size(); k++) {
			//para cada vértice i em V faça
			for(int i = 0 ; i < G.V.size(); i++) {
				//para cada vértice j em V faça
				for(int j = 0 ; j < G.V.size(); j++) {
					//se dist [ i ][ j ] > dist [ i ][ k ] + dist [ k ][ j ] então
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						//dist [ i ][ j ] ← dist [ i ][ k ] + dist [ k ][ j ]
						dist[i][j] = dist[i][k] + dist[k][j];
						//pred [ i ][ j ] ← pred [ k ][ j ]
						pred[i][j] = pred[k][j];
						
					}
					
				}
			}
		}
		long tempoFinal = System.currentTimeMillis();
		float tempo = (tempoFinal - tempoInicial);
		System.out.println("Tempo gasto = " + tempo/1000F + "s");
		retorna_caminho(s, t, pred[s]);
		System.out.println("Custo = " + dist[s][t]);	
		
	}
	
	public ArrayList<Integer> retorna_caminho(Integer s,Integer t, Integer[] pred) {
		
		ArrayList <Integer> C = new ArrayList<Integer>();
		Integer aux = t;
		
		while(aux != s) {
			aux = pred[aux];
			C.add(0, aux);
		}
		
		
		System.out.println("Caminho minimo entre " + s + " e " + t + ": " + C.toString());
		return C;
		
	}
}