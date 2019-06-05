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
		
		try {
			System.out.println("Arquivo do grafo");
			Scanner in = new Scanner(System.in);
			String nomeArquivo = in.nextLine();
			Leitor leitor = new Leitor();
			Grafo G;
			G = leitor.lerArquivo("Datasets/" + nomeArquivo + ".txt");
			System.out.println(G.listaAdj);
			for(int i = 0; i < G.V.size(); ++i) {
				for(int j = 0; j < G.V.size(); ++j) {
					System.out.print(G.matrizAdj[i][j]);
				}
				System.out.println("\n");
			}
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
			System.out.println("Djikstra : ");
			caminho.Dijkstra(G, 2);
			System.out.println("Bellman_Ford");
			System.out.println(caminho.Bellman_Ford(G, 2));
			System.out.println("Floyd_Warshall");
			caminho.Floyd_Warshall(G);
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
