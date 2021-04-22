package modelo;

import java.util.ArrayList;
import java.util.List;

public class Campo {
	
	private final int linha;
	private final int coluna;
	
	
	private boolean aberto=false;
	private boolean minado=false;
	private boolean marcado = false;
	
	private  List<Campo> vizinhos = new ArrayList<>();
	
	Campo(int linha, int coluna){
		this.linha=linha;
		this.coluna=coluna;
	}
	
	boolean adicionarVizinho(Campo vizinho) {
		
		boolean linhaDiferente = linha != vizinho.linha;
		boolean ColunaDiferente = coluna != vizinho.coluna;
		boolean diagonal = linhaDiferente && ColunaDiferente;
		
		//as distancias em modulo
		int deltaLinha= Math.abs(linha-vizinho.linha);
		int deltaColuna = Math.abs(coluna-vizinho.coluna);
		int deltaGeral =deltaLinha+deltaColuna;
		
		
		//se delta geral= 1 e não esta na disgonal então é um vizinho
		if(deltaGeral == 1 && !diagonal) {
			vizinhos.add(vizinho);
			return true;
		}else if(deltaGeral ==2 && diagonal) {
			vizinhos.add(vizinho);
			return true;
		}else {
			return false;
		}
		
		
	}
}
