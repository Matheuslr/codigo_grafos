package util;

public class Aresta {
	
	public int origem;
	public int destino;
	public int peso;
	
	
	
	public Aresta(int origem, int destino, int peso) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.peso = peso;
	}
	public int getOrigem() {
		return origem;
	}
	public void setOrigem(int origem) {
		this.origem = origem;
	}
	public int getDestino() {
		return destino;
	}
	public void setDestino(int destino) {
		this.destino = destino;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "\nAresta [origem=" + getOrigem() + ", destino=" + getDestino() + ", peso=" + getPeso() + "]";
	}
	
	

}
