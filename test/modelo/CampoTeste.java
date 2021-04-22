package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CampoTeste {
	private Campo campo= new Campo(3,3);
	
	
	
	@Test
	void testeVizinhoDistancia1Esquerda() {
		
		Campo vizinhoEsquerda= new Campo(3,2);
		boolean resultadoEsquerda=campo.adicionarVizinho(vizinhoEsquerda);
		assertTrue(resultadoEsquerda);
	}
	
	@Test
	void testeVizinhoDistancia1Direita() {
		
		Campo vizinhoDireita= new Campo(3,4);
		boolean resultadoDireita=campo.adicionarVizinho(vizinhoDireita);
		assertTrue(resultadoDireita);
	}
	
	@Test
	void testeVizinhoDistancia1EmCima() {
		
		Campo vizinho= new Campo(2,3);
		boolean resultado=campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	@Test
	void testeVizinhoDistancia1EmBaixo() {
		
		Campo vizinho= new Campo(4,3);
		boolean resultado=campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinho2() {
		
		Campo vizinho= new Campo(2,2);
		boolean resultado=campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	@Test
	void testeNaoVizinho() {
		
		Campo vizinho= new Campo(1,1);
		boolean resultado=campo.adicionarVizinho(vizinho);
		assertFalse(resultado);
	}
	
	
}
