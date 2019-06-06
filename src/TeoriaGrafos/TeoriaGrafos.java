package TeoriaGrafos;

import java.io.IOException;
import java.util.Scanner;

import algoritmos.Busca;
import algoritmos.CaminhoMinimo;
import algoritmos.Info;
import util.Grafo;
import util.Leitor;

public class TeoriaGrafos {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String escolha_algoritmo;
//		String [] lista_arquivos = {"rg300_4730","rome99c","facebook_combined","USA-road-dt.DC"};
		try {
			do {
			System.out.println("Escolha um algoritmo");
			System.out.println("1 - Dijkstra"
							 + "\n2 - Bellman Ford"
							 + "\n3 - Floyd Warshall");
			escolha_algoritmo = in.nextLine();
			}while(!escolha_algoritmo.equals("1") && !escolha_algoritmo.equals("2") && !escolha_algoritmo.equals("3"));
			System.out.println("Digite o nome do arquivo");
			String nomeArquivo = in.nextLine();
			System.out.println("Digite o vértice de origem");
			String origem = in.nextLine();
			System.out.println("Digite o vértice de destino");
			String destino = in.nextLine();
			Leitor leitor = new Leitor();
			Grafo G;
			G = leitor.lerArquivo("Datasets/" + nomeArquivo + ".txt");	
//			Info info = new Info(G);
//			if(info.regular()) {
//				System.out.println("Regular");
//			}else {
//				System.out.println("Não regular");
//			}
//			if(info.completo()) {
//				System.out.println("Completo");
//			}else {
//				System.out.println("Não Completo");
//			}
			
			CaminhoMinimo caminho = new	CaminhoMinimo();
			
			switch(Integer.parseInt(escolha_algoritmo)) {
				case 1:
					try {
		
						caminho.Dijkstra(G,Integer.parseInt(origem), Integer.parseInt(destino));
					}catch(java.lang.OutOfMemoryError e) {
						System.out.println("Out of memory");
						
					}
					break;
					
				case 2: 
					try {
						caminho.Bellman_Ford(G, Integer.parseInt(origem), Integer.parseInt(destino));
					}catch(java.lang.OutOfMemoryError e) {
						System.out.println("Out of memory");
					}
					break;
					
				case 3:
					try {
						caminho.Floyd_Warshall(G,Integer.parseInt(origem), Integer.parseInt(destino)) ;
					}catch(java.lang.OutOfMemoryError e) {
						System.out.println("Out of memory");
					}
					break;
				default:
					System.out.println("Erro");
		}
	
//			System.out.println("Densidade = " + info.densidade());
//			in.close();
//			System.out.println("Vertice 1 = " + G.getV());
//			
//			Busca busca = new Busca(G);
//			busca.busca_largura(2);
			
			
		} catch (IOException e) {
			System.out.println("Erro");
//			Logger.getLogger(TeoriaGrafos.class.getName());
		}

	}

}
