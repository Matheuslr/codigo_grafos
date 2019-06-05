package algoritmos;

import java.util.ArrayList;


import util.Grafo;

public class Busca {
	
	private Grafo G;

	public Busca(Grafo g) {
		G = g;
	}
	
	public void busca_largura(int s) {
		
		int [] visitado = new int[G.V.size()];
		for(int i = 0;i < G.V.size(); ++i) {
			visitado[i] = 0;
		}
		
		visitado[s] = 1;
		System.out.println(s);
		
		ArrayList<Integer> F = new ArrayList<Integer>();
		
		F.add(s);
		
		while(!F.isEmpty()) {
			int u = F.remove(0);
			for(int i = 0;i < G.listaAdj.get(u).size(); ++i) {
				
				int v = G.listaAdj.get(u).get(i).getDestino();
				if(visitado[v] == 0) {
					visitado[v] = 1;
					System.out.println(v);
					F.add(v);
				}
				
			}
		}
		
		
	}
	
	
	
}
