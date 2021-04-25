package modelo;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6,6,6);//6 linhas , 6 colunas 6 minas
		
		tabuleiro.abrir(3,3);
		tabuleiro.alterarMacacao(4, 4);
		tabuleiro.alterarMacacao(4, 5);
		
		System.out.println(tabuleiro);

	}

}
