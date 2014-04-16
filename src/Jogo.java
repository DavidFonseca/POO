import Excecao.ExcecaoBatalhaNaval;
import Tabuleiro.Tabuleiro;



public class Jogo {
	
	
	private boolean jogadorDaVez;
	private Tabuleiro tabuleiroAux;
	private Tabuleiro tabuleiroJogador = new Tabuleiro();
	private Tabuleiro tabuleiroComputador = new Tabuleiro();

	public boolean acabou() {
		// TODO Auto-generated method stub
		return false;
	}
	

	public void setJogador(boolean jogadorDaVez) {
		this.jogadorDaVez = jogadorDaVez;
		if (jogadorDaVez == true) {
			this.tabuleiroAux = tabuleiroJogador;
		} else {
			this.tabuleiroAux = tabuleiroComputador;
		}
	}

	
	public boolean isJogador() {
		// TODO Auto-generated method stub
		return jogadorDaVez;
	}

	public void colocarPeca(int linha, int coluna) {
		
		if (tabuleiroAux.getTabuleiro()[linha][coluna] != null) {
			throw new ExcecaoBatalhaNaval("Celula ocupada");
		}
		tabuleiroAux.getTabuleiro()[linha][coluna] = jogadorDaVez;
	}
	public Tabuleiro getTabuleiro() {
		return tabuleiroAux;
	}

	public void atacar(int linha, int coluna) {
		if (tabuleiroAux.verificaPecasColocadas() == true) {
			getTabuleiro().getTabuleiro()[linha][coluna] = false;
		}
	}
}

	
	

