import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Excecao.ExcecaoBatalhaNaval;


public class JogoTest {
	
	Jogo jogo;
	public void colocarTodasAsPecas() {
		jogo.getTabuleiro().colocarNavioDeUmCano(0,0);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,1);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,2);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,3);
		jogo.getTabuleiro().colocarNavioDeDoisCanos(1, 0, "horizontal");
		jogo.getTabuleiro().colocarNavioDeDoisCanos(1, 2, "horizontal");
		jogo.getTabuleiro().colocarNavioDeDoisCanos(1, 4, "horizontal");
		jogo.getTabuleiro().colocarNavioDeTresCanos(2, 0, "horizontal");
		jogo.getTabuleiro().colocarNavioDeTresCanos(2, 3, "horizontal");
		jogo.getTabuleiro().colocarNavioDeQuatroCanos(3, 0, "horizontal");
		jogo.getTabuleiro().colocarPortaAvioes(4, 2, "baixo");		
	}
	@Before
	public void iniciar() {
		jogo = new Jogo();
	}	
	@Test
	public void criaJogo() {
		assertFalse("o jogo comecou no fim", jogo.acabou());
	}
	@Test
	public void definirPrimeiroJogador() {
		jogo.setJogador(true);
		assertTrue("esperava primeiro jogador true", jogo.isJogador());
	}
	@Test 
	public void definirPrimeiroJogadorDeNovo() {
		jogo.setJogador(true);
		jogo.setJogador(false);
		assertFalse("esperava 1o jogador false", jogo.isJogador());
	}
	@Test 
	public void colocarPrimeiraPeca() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarPeca(0, 1);
		assertTrue("esperava primeira peca na posicao 0,1", jogo.getTabuleiro().isPecaNaPosicao(0, 1));
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocaPecaEmCelulaOcupada() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarPeca(0, 1);
		jogo.getTabuleiro().colocarPeca(0, 1);
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void lerPecaEmCelulaDesocupada() {
		jogo.setJogador(true);
		jogo.getTabuleiro().isPecaNaPosicao(0,1);
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void lerPecaEmColunaErrada() {
		jogo.setJogador(true);
		jogo.getTabuleiro().isPecaNaPosicao(1, 20);
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void lerPecaEmLinhaErrada() {
		jogo.setJogador(true);
		jogo.getTabuleiro().isPecaNaPosicao(20, 1);
	}
	@Test 
	public void colocarNavioDeUmCano() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarNavioDeUmCano(0, 1);
		assertTrue("esperava Navio de um cano na posicao 0,1", jogo.getTabuleiro().isPecaNaPosicao(0, 1));
	}
	@Test
	public void colocarDoisNavioDeUmCano() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarNavioDeUmCano(0, 1);
		jogo.getTabuleiro().colocarNavioDeUmCano(0, 2);
		assertTrue("esperava Navio de um cano na posicao 0,1", jogo.getTabuleiro().isPecaNaPosicao(0, 1));
		assertTrue("esperava Navio de um cano na posicao 0,2", jogo.getTabuleiro().isPecaNaPosicao(0, 2));
	
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNaviosDeUmCanoAlemDoMaximoDeQuatro() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarNavioDeUmCano(0, 1);
		jogo.getTabuleiro().colocarNavioDeUmCano(0, 2);
		jogo.getTabuleiro().colocarNavioDeUmCano(0, 3);
		jogo.getTabuleiro().colocarNavioDeUmCano(0, 4);
		jogo.getTabuleiro().colocarNavioDeUmCano(0, 5);
	}
	@Test 
	public void colocarNavioDeDoisCanosNaHorizontal() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarNavioDeDoisCanos(0, 1, "horizontal");
		assertTrue("esperava peca na posicao (0, 1)", jogo.getTabuleiro().isPecaNaPosicao(0, 1));
		assertTrue("esperava peca na posicao (0, 2)", jogo.getTabuleiro().isPecaNaPosicao(0, 2));
	}
	@Test
	public void colocarNavioDeDoisCanosNaVertical() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarNavioDeDoisCanos(0,  1, "vertical");
		assertTrue("esperava peca na posicao (0, 1)", jogo.getTabuleiro().isPecaNaPosicao(0, 1));
		assertTrue("esperava peca na posicao (1,1)",jogo.getTabuleiro().isPecaNaPosicao(1, 1));
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNavioDeDoisCanosComParteAlemDoLimiteDoTabuleiroNaHorizontal() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarNavioDeDoisCanos(9, 9, "horizontal");
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNavioDeDoisCanosComParteAlemDoLimiteDoTabuleiroNaVertical() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarNavioDeDoisCanos(9, 9, "vertical");
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNaviosDeDoisCanosAlemDoMaximoDeTres() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarNavioDeDoisCanos(0, 0, "horizontal");
		jogo.getTabuleiro().colocarNavioDeDoisCanos(2, 2, "vertical");
		jogo.getTabuleiro().colocarNavioDeDoisCanos(4, 4, "horizontal");
		jogo.getTabuleiro().colocarNavioDeDoisCanos(6, 6, "vertical");
	}
	@Test
	public void colocarNavioDeTresCanosNaHorizontal() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarNavioDeTresCanos(0, 0, "horizontal");
		assertTrue("esperava peca na posicao (0, 0)", jogo.getTabuleiro().isPecaNaPosicao(0, 0));
		assertTrue("esperava peca na posicao (0, 1)", jogo.getTabuleiro().isPecaNaPosicao(0, 1));
		assertTrue("esperava peca na posicao (0, 2)", jogo.getTabuleiro().isPecaNaPosicao(0, 2));
	}
	@Test
	public void colocarNavioDeTresCanosNaVertical() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarNavioDeTresCanos(0, 0, "vertical");
		assertTrue("esperava peca na posicao (0, 0)", jogo.getTabuleiro().isPecaNaPosicao(0, 0)); 
		assertTrue("esperava peca na posicao (1, 0)", jogo.getTabuleiro().isPecaNaPosicao(1, 0));
		assertTrue("esperava peca na posicao (2, 0)", jogo.getTabuleiro().isPecaNaPosicao(2, 0)); 
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNavioDeTresCanosComParteAlemDoLimiteDoTabuleiroNaHorizontal() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarNavioDeTresCanos(8, 8, "horizontal");
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNavioDeTresCanosComParteAlemDoLimiteDoTabuleiroNaVertical() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarNavioDeTresCanos(8, 8, "vertical");
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNaviosDeTresCanosAlemDoMaximoDeDois() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarNavioDeTresCanos(0, 0, "horizontal");
		jogo.getTabuleiro().colocarNavioDeTresCanos(1, 0, "horizontal");
		jogo.getTabuleiro().colocarNavioDeTresCanos(2, 0, "horizontal");
	}
	@Test
	public void colocarNavioDeQuatroCanosNaHorizontal() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarNavioDeQuatroCanos(0, 0, "horizontal");
		assertTrue("esperava peca na posicao (0, 0)", jogo.getTabuleiro().isPecaNaPosicao(0, 0));
		assertTrue("esperava peca na posicao (0, 1)", jogo.getTabuleiro().isPecaNaPosicao(0, 1));
		assertTrue("esperava peca na posicao (0, 2)", jogo.getTabuleiro().isPecaNaPosicao(0, 2));
		assertTrue("esperava peca na posicao (0, 3).", jogo.getTabuleiro().isPecaNaPosicao(0, 3));
	}
	@Test 
	public void colocarNavioDeQuatroCanosNaVertical() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarNavioDeQuatroCanos(0, 0, "vertical");
		assertTrue("esperava peca na posicao (0, 0)", jogo.getTabuleiro().isPecaNaPosicao(0, 0));
		assertTrue("esperava peca na posicao (1, 0)", jogo.getTabuleiro().isPecaNaPosicao(1, 0));
		assertTrue("esperava peca na posicao (2, 0)", jogo.getTabuleiro().isPecaNaPosicao(2, 0));
		assertTrue("esperava peca na posicao (3, 0).", jogo.getTabuleiro().isPecaNaPosicao(3, 0));
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNavioDeQuatroCanosComParteAlemDoLimiteDoTabuleiroNaHorizontal() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarNavioDeQuatroCanos(7, 7, "horizontal");
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNavioDeQuatroCanosComParteAlemDoLimiteDoTabuleiroNaVertical() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarNavioDeQuatroCanos(7, 7, "vertical");
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNavioDeQuatroCanosAlemDoNumeroMaximoDeUm() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarNavioDeQuatroCanos(0, 0, "horizontal");
		jogo.getTabuleiro().colocarNavioDeQuatroCanos(1, 0, "horizontal");
	}
	@Test
	public void colocarPortaAvioesViradoParaCima() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarPortaAvioes(1, 1, "cima");
		assertTrue("esperava peca na posicao (1, 1).", jogo.getTabuleiro().isPecaNaPosicao(1, 1));
		assertTrue("esperava peca na posicao (1, 0).", jogo.getTabuleiro().isPecaNaPosicao(1, 0));
		assertTrue("esperava peca na posicao (1, 2).", jogo.getTabuleiro().isPecaNaPosicao(1, 2));
		assertTrue("esperava peca na posicao (0, 1).", jogo.getTabuleiro().isPecaNaPosicao(0, 1));		
	}
	@Test
	public void colocarPortaAvioesViradoParaBaixo() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarPortaAvioes(1, 1, "baixo");
		assertTrue("esperava peca na posicao (1, 1).", jogo.getTabuleiro().isPecaNaPosicao(1, 1));
		assertTrue("esperava peca na posicao (1, 0).", jogo.getTabuleiro().isPecaNaPosicao(1, 0));
		assertTrue("esperava peca na posicao (1, 2).", jogo.getTabuleiro().isPecaNaPosicao(1, 2));
		assertTrue("esperava peca na posicao (2, 1).", jogo.getTabuleiro().isPecaNaPosicao(2, 1));
	}
	@Test
	public void colocarPortaAvioesViradoParaEsquerda() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarPortaAvioes(1, 1, "esquerda");
		assertTrue("esperava peca na posicao (1, 1).", jogo.getTabuleiro().isPecaNaPosicao(1, 1));
		assertTrue("esperava peca na posicao (0, 1).", jogo.getTabuleiro().isPecaNaPosicao(0, 1));
		assertTrue("esperava peca na posicao (2, 1).", jogo.getTabuleiro().isPecaNaPosicao(2, 1));
		assertTrue("esperava peca na posicao (1, 0).", jogo.getTabuleiro().isPecaNaPosicao(1, 0));
	}
	@Test
	public void colocarPortaAvioesViradoParaDireita() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarPortaAvioes(1, 1, "direita");
		assertTrue("esperava peca na posicao (1, 1).", jogo.getTabuleiro().isPecaNaPosicao(1, 1));
		assertTrue("esperava peca na posicao (0, 1).", jogo.getTabuleiro().isPecaNaPosicao(0, 1));
		assertTrue("esperava peca na posicao (2, 1).", jogo.getTabuleiro().isPecaNaPosicao(2, 1));
		assertTrue("esperava peca na posicao (1, 2).", jogo.getTabuleiro().isPecaNaPosicao(1, 2));
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarPortaAvioesAlemDoLimiteDoTabuleiroParaCima() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarPortaAvioes(0, 0, "cima");
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarPortaAvioesAlemDoLimiteDoTabuleiroParaBaixo() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarPortaAvioes(0, 0, "baixo");
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarPortaAvioesAlemDoLimiteDoTabuleiroParaEsquerda() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarPortaAvioes(0, 0, "esquerda");
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarPortaAvioesAlemDoLimiteDoTabuleiroParaDireita() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarPortaAvioes(0, 0, "direita");
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarPortaAvioesAlemDoMaximoDeUm() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarPortaAvioes(2, 2, "direita");
		jogo.getTabuleiro().colocarPortaAvioes(5, 5, "direita");
	}
	@Test 
	public void colocarTodasAsPecasDoJogador() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,0);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,1);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,2);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,3);
		jogo.getTabuleiro().colocarNavioDeDoisCanos(1, 0, "horizontal");
		jogo.getTabuleiro().colocarNavioDeDoisCanos(1, 2, "horizontal");
		jogo.getTabuleiro().colocarNavioDeDoisCanos(1, 4, "horizontal");
		jogo.getTabuleiro().colocarNavioDeTresCanos(2, 0, "horizontal");
		jogo.getTabuleiro().colocarNavioDeTresCanos(2, 3, "horizontal");
		jogo.getTabuleiro().colocarNavioDeQuatroCanos(3, 0, "horizontal");
		jogo.getTabuleiro().colocarPortaAvioes(4, 2, "baixo");
		
		assertTrue("esperava Primeiro Navio de um cano na posicao 0,0", jogo.getTabuleiro().isPecaNaPosicao(0, 0));
		assertTrue("esperava Segundo Navio de um cano na posicao 0,1", jogo.getTabuleiro().isPecaNaPosicao(0, 1));
		assertTrue("esperava Terceiro Navio de um cano na posicao 0,2", jogo.getTabuleiro().isPecaNaPosicao(0, 2));
		assertTrue("esperava Quarto Navio de um cano na posicao 0,3", jogo.getTabuleiro().isPecaNaPosicao(0, 3));
		
		assertTrue("esperava Primeira peca de Navio De Dois Canos na posicao (1, 0)", jogo.getTabuleiro().isPecaNaPosicao(1, 0));
		assertTrue("esperava Primeira peca de Navio De Dois Canos na posicao (1, 1)", jogo.getTabuleiro().isPecaNaPosicao(1, 1));
		assertTrue("esperava Segunda peca de Navio De Dois Canos na posicao (1, 2)", jogo.getTabuleiro().isPecaNaPosicao(1, 2));
		assertTrue("esperava Segunda peca de Navio De Dois Canos na posicao (1, 3)", jogo.getTabuleiro().isPecaNaPosicao(1, 3));
		assertTrue("esperava Terceira peca de Navio De Dois Canos na posicao (1, 4)", jogo.getTabuleiro().isPecaNaPosicao(1, 4));
		assertTrue("esperava Terceira peca de Navio De Dois Canos na posicao (1, 5)", jogo.getTabuleiro().isPecaNaPosicao(1, 5));
		
		assertTrue("esperava Primeira peca de Navio de Tres Canos na posicao (2, 0)", jogo.getTabuleiro().isPecaNaPosicao(2, 0));
		assertTrue("esperava Primeira peca de Navio de Tres Canos na posicao (2, 1)", jogo.getTabuleiro().isPecaNaPosicao(2, 1));
		assertTrue("esperava Primeira peca de Navio de Tres Canos na posicao (2, 2)", jogo.getTabuleiro().isPecaNaPosicao(2, 2));
		assertTrue("esperava Segunda peca de Navio de Tres Canos na posicao (2, 3)", jogo.getTabuleiro().isPecaNaPosicao(2, 3));
		assertTrue("esperava Segunda peca de Navio de Tres Canos na posicao (2, 4)", jogo.getTabuleiro().isPecaNaPosicao(2, 4));
		assertTrue("esperava Segunda peca de Navio de Tres Canos na posicao (2, 5)", jogo.getTabuleiro().isPecaNaPosicao(2, 5));
		
		assertTrue("esperava peca de Navio de Quatro Canos na posicao (3, 0)", jogo.getTabuleiro().isPecaNaPosicao(3, 0));
		assertTrue("esperava peca de Navio de Quatro Canos na posicao (3, 1)", jogo.getTabuleiro().isPecaNaPosicao(3, 1));
		assertTrue("esperava peca de Navio de Quatro Canos na posicao (3, 2)", jogo.getTabuleiro().isPecaNaPosicao(3, 2));
		assertTrue("esperava peca de Navio de Quatro Canos na posicao (3, 3)", jogo.getTabuleiro().isPecaNaPosicao(3, 3));
		
		assertTrue("esperava peca de Porta Avioes na posicao (4, 2).", jogo.getTabuleiro().isPecaNaPosicao(4, 2));
		assertTrue("esperava peca de Porta Avioes na posicao (4, 1).", jogo.getTabuleiro().isPecaNaPosicao(4, 1));
		assertTrue("esperava peca de Porta Avioes na posicao (4, 3).", jogo.getTabuleiro().isPecaNaPosicao(4, 3));
		assertTrue("esperava peca de Porta Avioes na posicao (5, 2).", jogo.getTabuleiro().isPecaNaPosicao(5, 2));
	}
	@Test
	public void colocarTodasAsPecasComputador() {
		jogo.setJogador(false);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,0);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,1);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,2);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,3);
		jogo.getTabuleiro().colocarNavioDeDoisCanos(1, 0, "horizontal");
		jogo.getTabuleiro().colocarNavioDeDoisCanos(1, 2, "horizontal");
		jogo.getTabuleiro().colocarNavioDeDoisCanos(1, 4, "horizontal");
		jogo.getTabuleiro().colocarNavioDeTresCanos(2, 0, "horizontal");
		jogo.getTabuleiro().colocarNavioDeTresCanos(2, 3, "horizontal");
		jogo.getTabuleiro().colocarNavioDeQuatroCanos(3, 0, "horizontal");
		jogo.getTabuleiro().colocarPortaAvioes(4, 2, "baixo");
	}
	@Test
	public void colocarPecasDoJogadorEDoComputador() {
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,0);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,1);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,2);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,3);
		jogo.getTabuleiro().colocarNavioDeDoisCanos(1, 0, "horizontal");
		jogo.getTabuleiro().colocarNavioDeDoisCanos(1, 2, "horizontal");
		jogo.getTabuleiro().colocarNavioDeDoisCanos(1, 4, "horizontal");
		jogo.getTabuleiro().colocarNavioDeTresCanos(2, 0, "horizontal");
		jogo.getTabuleiro().colocarNavioDeTresCanos(2, 3, "horizontal");
		jogo.getTabuleiro().colocarNavioDeQuatroCanos(3, 0, "horizontal");
		jogo.getTabuleiro().colocarPortaAvioes(4, 2, "baixo");
		
		jogo.setJogador(false);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,0);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,1);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,2);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,3);
		jogo.getTabuleiro().colocarNavioDeDoisCanos(1, 0, "horizontal");
		jogo.getTabuleiro().colocarNavioDeDoisCanos(1, 2, "horizontal");
		jogo.getTabuleiro().colocarNavioDeDoisCanos(1, 4, "horizontal");
		jogo.getTabuleiro().colocarNavioDeTresCanos(2, 0, "horizontal");
		jogo.getTabuleiro().colocarNavioDeTresCanos(2, 3, "horizontal");
		jogo.getTabuleiro().colocarNavioDeQuatroCanos(3, 0, "horizontal");
		jogo.getTabuleiro().colocarPortaAvioes(4, 2, "baixo");
	}	
	@Test
	public void atacarJogador() {
		jogo.setJogador(true);
		colocarTodasAsPecas();
		jogo.setJogador(false);
		colocarTodasAsPecas();
		jogo.atacar(0, 0);
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void atacarAntesDeColocarTodasAsPecas(){
		jogo.setJogador(true);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,0);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,1);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,2);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,3);
		jogo.setJogador(false);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,0);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,1);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,2);
		jogo.getTabuleiro().colocarNavioDeUmCano(0,3);
		jogo.setJogador(true);
		jogo.atacar(0, 0);
	}
}
	
