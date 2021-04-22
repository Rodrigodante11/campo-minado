package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excesao.ExplosaoException;

public class CampoTeste {
	private Campo campo;
	
	@BeforeEach
	void iniciarCampo() {
		campo =new Campo(3,3);
	}
	
	
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
	
	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}
	@Test
	void alternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void alternarMarcacaoDuasChamadas() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeabrirNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeabrirNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeabrirMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	@Test
	void testeabrirMinadoMNaoarcado() {
		campo.minar();
		
		assertThrows(ExplosaoException.class,() ->{ //testar se lançou a exceção esperada
			campo.abrir();
		});
	}
	@Test
	void testeabrirComVizinhos1() {
		Campo campo11= new Campo(1,1);
		
		Campo campo22= new Campo(2,2);
		campo22.adicionarVizinho(campo11);
		
		campo.adicionarVizinho(campo22);
		
		campo.abrir(); //campo atual é o 3,3 declarado no começo do teste
		
		assertTrue(campo22.isAberto() && campo11.isAberto());
	}
	@Test
	void testeabrirComVizinhos2() {
		Campo campo11= new Campo(1,1);
		Campo campo12= new Campo(1,1);
		campo12.minar();//minando o campo12
		
		Campo campo22= new Campo(1,1);
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		
		campo.adicionarVizinho(campo22);
		
		campo.abrir(); //campo atual é o 3,3 declarado no começo do teste
		
		assertFalse(campo22.isAberto() && campo11.isFechado());
	}
	
	@Test
	void testeRetornotoString1() {
		assertEquals("?", campo.toString());
	}
	@Test
	void testeRetornotoString2() {
		campo.alternarMarcacao();
		assertEquals("x", campo.toString());
	}
	@Test
	void testeRetornotoString3() {
		campo.abrir();
		campo.minar();
		
		assertEquals("*", campo.toString());
	}
	@Test
	void testeRetornotoString4() {
		campo.abrir();
		
		assertEquals(" ", campo.toString());
	}

	
	
}
