package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class Tabuleiro {
	private int linhas;
	private int colunas;
	private int minas;
	
	private final List<Campo> campos = new ArrayList<>();
	
	

	public Tabuleiro(int linhas, int colunas, int minas) {
		
		this.linhas = linhas;
		this.colunas = colunas;
		this.minas = minas;
		gerarCampos();
		associarOsVizinhos();
		sortearMinas();
	}
	
	public void abrir(int linha,int coluna) {
		try {
			campos.parallelStream()
			      .filter(c -> c.getLinha() ==linha && c.getColuna() == coluna)
			      .findFirst()
			      .ifPresent(c->c.abrir());
		} catch ( Exception e) {
			campos.forEach(c -> c.setAberto(true));
			throw e;
		}
	}
	public void alterarMacacao(int linha,int coluna) {
		campos.parallelStream()
		      .filter(c -> c.getLinha() ==linha && c.getColuna() == coluna)
		      .findFirst()
		      .ifPresent(c->c.alternarMarcacao());
	}

	private void gerarCampos() {
		
		for(int i=0;i<linhas;i++) {
			for(int j=0;j<colunas;j++)
			{
				campos.add(new Campo(i,j));
			}
		}
	}
	
	private void associarOsVizinhos() {
		for(Campo c1:campos) {
			for(Campo c2:  campos)
			{
				c1.adicionarVizinho(c2);
			}
		}
	}
	
	private void sortearMinas() {
		
		long minasArmadas = 0;
		Predicate<Campo> minado= c-> c.isMinado();
		
		do {
			
			int aleatorio =(int) (Math.random()*campos.size());
			campos.get(aleatorio).minar();//colocando a mina por indice na lista
			minasArmadas= campos.stream().filter(minado).count();
			
		}while(minasArmadas<minas);
		
	}
	public boolean objetivoAlcancado() {
//		boolean desvendado =!minado && aberto;
//		boolean protegido = minado && marcado;
//		return desvendado || protegido;
		return campos.stream().allMatch(c-> c.objetivoAlcancado()); //se todos os campos da lista derem math
	}
	public void reiniciar() {
		campos.stream().forEach(c-> c.reiniciar());
		sortearMinas();
	}
	
	
	
	
}
