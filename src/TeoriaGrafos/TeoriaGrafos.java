package TeoriaGrafos;

import java.io.IOException;
import java.util.Scanner;

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
			in.close();
			
		} catch (IOException e) {
			System.out.println("Erro");
//			Logger.getLogger(TeoriaGrafos.class.getName());
		}

	}

}
