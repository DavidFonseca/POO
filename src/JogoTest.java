import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class JogoTest {
	
	Jogo jogo;
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
		jogo.colocarPeca(0, 1);
		assertTrue("esperava primeira peca na posicao 0,1", jogo.isPecaNaPosicao(0, 1));
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocaPecaEmCelulaOcupada() {
		jogo.setJogador(true);
		jogo.colocarPeca(0, 1);
		jogo.colocarPeca(0, 1);
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarPecaEmColunaErrada() {
		jogo.setJogador(true);
		jogo.colocarPeca(1, 20);
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarPecaEmLinhaErrada() {
		jogo.setJogador(true);
		jogo.colocarPeca(20, 1);
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void lerPecaEmCelulaDesocupada() {
		jogo.setJogador(true);
		jogo.isPecaNaPosicao(0,1);
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void lerPecaEmColunaErrada() {
		jogo.setJogador(true);
		jogo.isPecaNaPosicao(1, 20);
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void lerPecaEmLinhaErrada() {
		jogo.setJogador(true);
		jogo.isPecaNaPosicao(20, 1);
	}
	@Test 
	public void colocarNavioDeUmCano() {
		jogo.setJogador(true);
		jogo.colocarNavioDeUmCano(0, 1);
		assertTrue("esperava Navio de um cano na posicao 0,1", jogo.isPecaNaPosicao(0, 1));
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNaviosDeUmCanoAlemDoMaximoDeQuatro() {
		jogo.setJogador(true);
		jogo.colocarNavioDeUmCano(0, 1);
		jogo.colocarNavioDeUmCano(0, 2);
		jogo.colocarNavioDeUmCano(0, 3);
		jogo.colocarNavioDeUmCano(0, 4);
		jogo.colocarNavioDeUmCano(0, 5);
	}
	@Test 
	public void colocarNavioDeDoisCanosNaHorizontal() {
		jogo.setJogador(true);
		jogo.colocarNavioDeDoisCanos(0, 1, "horizontal");
		assertTrue("esperava peca na posicao (0, 1) e (0, 2)", jogo.isPecaNaPosicao(0, 1) && jogo.isPecaNaPosicao(0, 2));
	}
	@Test
	public void colocarNavioDeDoisCanosNaVertical() {
		jogo.setJogador(true);
		jogo.colocarNavioDeDoisCanos(0,  1, "vertical");
		assertTrue("esperava peca na posicao (0, 1) e (1,1)", jogo.isPecaNaPosicao(0, 1) && jogo.isPecaNaPosicao(1, 1));
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNavioDeDoisCanosComParteAlemDoLimiteDoTabuleiroNaHorizontal() {
		jogo.setJogador(true);
		jogo.colocarNavioDeDoisCanos(9, 9, "horizontal");
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNavioDeDoisCanosComParteAlemDoLimiteDoTabuleiroNaVertical() {
		jogo.setJogador(true);
		jogo.colocarNavioDeDoisCanos(9, 9, "vertical");
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNaviosDeDoisCanosAlemDoMaximoDeTres() {
		jogo.setJogador(true);
		jogo.colocarNavioDeDoisCanos(0, 0, "horizontal");
		jogo.colocarNavioDeDoisCanos(2, 2, "vertical");
		jogo.colocarNavioDeDoisCanos(4, 4, "horizontal");
		jogo.colocarNavioDeDoisCanos(6, 6, "vertical");
	}
	@Test
	public void colocarNavioDeTresCanosNaHorizontal() {
		jogo.setJogador(true);
		jogo.colocarNavioDeTresCanos(0, 0, "horizontal");
		assertTrue("esperava peca na posicao (0, 0), (0, 1) e (0, 2)", jogo.isPecaNaPosicao(0, 0) 
				&& jogo.isPecaNaPosicao(0, 1) && jogo.isPecaNaPosicao(0, 2));
	}
	@Test
	public void colocarNavioDeTresCanosNaVertical() {
		jogo.setJogador(true);
		jogo.colocarNavioDeTresCanos(0, 0, "vertical");
		assertTrue("esperava peca na posicao (0, 0), (1, 0) e (2, 0)", jogo.isPecaNaPosicao(0, 0) 
				&& jogo.isPecaNaPosicao(1, 0) && jogo.isPecaNaPosicao(2, 0));
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNavioDeTresCanosComParteAlemDoLimiteDoTabuleiroNaHorizontal() {
		jogo.setJogador(true);
		jogo.colocarNavioDeTresCanos(8, 8, "horizontal");
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNavioDeTresCanosComParteAlemDoLimiteDoTabuleiroNaVertical() {
		jogo.setJogador(true);
		jogo.colocarNavioDeTresCanos(8, 8, "vertical");
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNaviosDeTresCanosAlemDoMaximoDeDois() {
		jogo.setJogador(true);
		jogo.colocarNavioDeTresCanos(0, 0, "horizontal");
		jogo.colocarNavioDeTresCanos(1, 0, "horizontal");
		jogo.colocarNavioDeTresCanos(2, 0, "horizontal");
	}
	@Test
	public void colocarNavioDeQuatroCanosNaHorizontal() {
		jogo.setJogador(true);
		jogo.colocarNavioDeQuatroCanos(0, 0, "horizontal");
		assertTrue("esperava peca na posicao (0, 0), (0, 1), (0, 2) e (0, 3).", jogo.isPecaNaPosicao(0, 0)
				&& jogo.isPecaNaPosicao(0, 1) && jogo.isPecaNaPosicao(0, 2) && jogo.isPecaNaPosicao(0, 3));
	}
	@Test 
	public void colocarNavioDeQuatroCanosNaVertical() {
		jogo.setJogador(true);
		jogo.colocarNavioDeQuatroCanos(0, 0, "vertical");
		assertTrue("esperava peca na posicao (0, 0), (0, 1), (0, 2) e (0, 3).", jogo.isPecaNaPosicao(0, 0)
				&& jogo.isPecaNaPosicao(1, 0) && jogo.isPecaNaPosicao(2, 0) && jogo.isPecaNaPosicao(3, 0));
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNavioDeQuatroCanosComParteAlemDoLimiteDoTabuleiroNaHorizontal() {
		jogo.setJogador(true);
		jogo.colocarNavioDeQuatroCanos(7, 7, "horizontal");
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNavioDeQuatroCanosComParteAlemDoLimiteDoTabuleiroNaVertical() {
		jogo.setJogador(true);
		jogo.colocarNavioDeQuatroCanos(7, 7, "vertical");
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNavioDeQuatroCanosAlemDoNumeroMaximoDeUm() {
		jogo.setJogador(true);
		jogo.colocarNavioDeQuatroCanos(0, 0, "horizontal");
		jogo.colocarNavioDeQuatroCanos(1, 0, "horizontal");
	}

	
}
