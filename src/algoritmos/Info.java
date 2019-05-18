package algoritmos;

import util.Grafo;

public class Info {
	
	private Grafo G;
	
	public Info(Grafo G) {
		this.G = G;
	}
	
	public boolean completo() {
		
		for(int i = 0; i < G.V.size(); ++i) {
			
			for(int j = 0; j< G.V.size(); ++j) {
				
				if (i != j && G.matrizAdj[i][j] == 0) {
					
					return false;
					
				}
			}
		}
		
		return true;
	}
	
	public boolean regular() {
		int grauAnterior = -1;
		for (int i = 0; i < G.V.size(); ++i) {
			
			int grau = 0;
			for (int j = 0; j < G.V.size(); ++j) {
				if(G.matrizAdj[i][j] != 0) {
					++grau;
				}
			}
			if(grauAnterior != -1 && grau != grauAnterior) {
				return false;
			}
			grauAnterior = grau;
		}
		return true;
	}
	
	public boolean regularListaAdj() {
		
		int grauAnterior = -1;
		for(int i = 0; i < G.listaAdj.size(); ++i) {
			if(grauAnterior != -1 && G.listaAdj.get(i).size() != grauAnterior) {
				return false;
			}
			grauAnterior = G.listaAdj.get(i).size();
		}
		return true;
		
	}
	
	public boolean completoListaAdj() {
		
		
		for( int i = 0; i < G.V.size(); ++i) {
			
			if(G.listaAdj.get(i).size() != G.V.size() - 1) {
				return false;
			}
		}
		return true;
	}
	
	public double densidade() {
		
		final double numeroVertice = G.V.size();
		final double numeroAresta = G.I.size();
		final double dens = numeroAresta/(numeroVertice * (numeroVertice - 1));
		return (dens);
	}
	

}
