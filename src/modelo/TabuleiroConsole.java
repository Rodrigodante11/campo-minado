package modelo;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import excesao.ExplosaoException;
import excesao.SairException;

public class TabuleiroConsole {

	private Tabuleiro tabuleiro;
	
	private Scanner sc= new Scanner(System.in);
	
	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro=tabuleiro;
		
		executarJogo();
	}

	private void executarJogo() {
		
		try {
			boolean continuar = true;
			
			while(continuar) 
			{
				cicloDoJogo();
				System.out.println("Outra partida? (S/n) ");
				String resposta = sc.nextLine();
				
				if("n".equalsIgnoreCase(resposta)){
					continuar=false;
				}else {
					tabuleiro.reiniciar();
				}
			}
		} catch (SairException e) {
			System.out.println(tabuleiro);
			System.out.println("Tchau!!!");
		}finally {
			sc.close();
		}
		
	}

	private void cicloDoJogo() {
		try {
			while(!tabuleiro.objetivoAlcancado()) {
				System.out.println(tabuleiro);
				
				String digitado= capturarValorDigitado("Digite (linha,coluna): ");
				Iterator<Integer> xy=Arrays.stream(digitado.split(",")).map(e -> Integer.parseInt(e.trim())).iterator();
				//tirando a virgula e os espaços armazendo em um Array de String depois convertendo para int
				digitado= capturarValorDigitado("1 - abrir ou 2 (Des)Marcar: ");
				
				if("1".equals(digitado)) {
					
					tabuleiro.abrir(xy.next(), xy.next());
					
				}else if("2".equals(digitado)) {
					tabuleiro.alterarMacacao(xy.next(), xy.next());
				}
				
				      
			}
			System.out.println("Você Ganhou!");
		} catch (ExplosaoException e) {
			System.out.println(tabuleiro);
			System.out.println("Você Perdeu!");
		}
		
	}
	private String capturarValorDigitado(String texto) {
		System.out.print(texto);
		String digitado = sc.nextLine();
		
		if("sair".equalsIgnoreCase(digitado)) {
			throw new SairException();
		}
		return digitado;
	}
}
