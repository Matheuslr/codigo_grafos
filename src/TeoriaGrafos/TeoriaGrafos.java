package TeoriaGrafos;

import java.io.IOException;
import java.util.Scanner;

import algoritmos.Busca;
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
			G = leitor.lerArquivo(nomeArquivo);
			System.out.println(G.listaAdj);
			Info info = new Info(G);
			if(info.regular()) {
				System.out.println("Regular");
			}else {
				System.out.println("Não regular");
			}
			if(info.completo()) {
				System.out.println("Completo");
			}else {
				System.out.println("Não Completo");
			}
			
			System.out.println("Densidade = " + info.densidade());
			in.close();
			
			Busca busca = new Busca(G);
			busca.busca_largura(2);
			
			
		} catch (IOException e) {
			System.out.println("Erro");
//			Logger.getLogger(TeoriaGrafos.class.getName());
		}

	}

}
