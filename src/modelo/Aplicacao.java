package modelo;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6,6,6);//6 linhas , 6 colunas 6 minas
		
		new TabuleiroConsole(tabuleiro);
		
		

	}

}
