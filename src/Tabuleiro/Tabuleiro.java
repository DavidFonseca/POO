package Tabuleiro;
import Excecao.ExcecaoBatalhaNaval;




public class Tabuleiro {
	
	private static final int MAX_NAVIO_DE_UM_CANO = 4;
	private int contNavioDeUmCano = 0;
	private static final int MAX_NAVIO_DE_DOIS_CANOS = 3;
	private int contNavioDeDoisCanos = 0;
	private static final int MAX_NAVIO_DE_TRES_CANOS = 2;
	private int contNavioDeTresCanos = 0;
	private static final int MAX_NAVIO_DE_QUATRO_CANOS = 1;
	private int contNavioDeQuatroCanos = 0;
	private static final int MAX_PORTA_AVIOES = 1;
	private int contPortaAvioes = 0;
	private static final int TOTAL_DE_PECAS = 11;
	private int contPecasColocadas = 0;
	
	private Boolean[][] tabuleiro;
	
	public Tabuleiro() {
		tabuleiro = new Boolean[10][10];
	}
	
	public Boolean[][] getTabuleiro() {
		return tabuleiro;
	}
	
	public void colocarPeca(int linha, int coluna) {

		if (tabuleiro[linha][coluna] != null) {
			throw new ExcecaoBatalhaNaval("Celula ocupada");
		}
		tabuleiro[linha][coluna] = true;
	} 
	
	public boolean verificaPecasColocadas() {
		if (contPecasColocadas == TOTAL_DE_PECAS) {
			return true;
		}
		throw new ExcecaoBatalhaNaval("Ainda ha pecas a serem colocadas.");
	}

	public boolean isPecaNaPosicao(int linha, int coluna) {
		verificarLimites(linha, coluna);
		if (tabuleiro[linha][coluna] == null) {
			throw new ExcecaoBatalhaNaval("Celula Vazia");
		}
		return tabuleiro[linha][coluna] == true;
	}

	private void verificarLimites(int linha, int coluna) {
		if (linha < 0 || linha > 9) {
			throw new ExcecaoBatalhaNaval("Linha fora da faixa permitida");
		}
		if (coluna < 0 || coluna > 9) {
			throw new ExcecaoBatalhaNaval("Coluna fora da faixa permitida");
		}
	}
	
	public void colocarNavioDeUmCano(int linha, int coluna) {
		
		if (contNavioDeUmCano == MAX_NAVIO_DE_UM_CANO) {
			throw new ExcecaoBatalhaNaval("Numero máximo de Navio de um cano é 4.");
		}
		verificarLimites(linha, coluna);
		colocarPeca(linha, coluna);
		contNavioDeUmCano++;
		contPecasColocadas++;
	}

	public void colocarNavioDeDoisCanos(int linha, int coluna, String direcao) {
		if (contNavioDeDoisCanos == MAX_NAVIO_DE_DOIS_CANOS) {
			throw new ExcecaoBatalhaNaval("Numero máximo de Navio de dois canos é 3.");
		}
		if(direcao.equals("horizontal")) {
			verificarLimites(linha, coluna);
			verificarLimites(linha, coluna +1);
			
			colocarPeca(linha, coluna);
			colocarPeca(linha, coluna + 1);
			
		} else if (direcao.equals("vertical")) {
			verificarLimites(linha, coluna);
			verificarLimites(linha + 1, coluna);
			
			colocarPeca(linha, coluna);			
			colocarPeca(linha + 1, coluna);
			
			
		}
		contNavioDeDoisCanos++;
		contPecasColocadas++;
	}

	public void colocarNavioDeTresCanos(int linha, int coluna, String direcao) {
		if (contNavioDeTresCanos == MAX_NAVIO_DE_TRES_CANOS) {
			throw new ExcecaoBatalhaNaval("Numero máximo de Navio de três canos é 2.");
		}
		if (direcao.equals("horizontal")) {
			verificarLimites(linha, coluna);
			verificarLimites(linha, coluna + 1);
			verificarLimites(linha, coluna + 2);
			
			colocarPeca(linha, coluna);
			colocarPeca(linha, coluna + 1);
			colocarPeca(linha, coluna + 2);
		} else if (direcao.equals("vertical")) {
			verificarLimites(linha, coluna);
			verificarLimites(linha + 1, coluna);
			verificarLimites(linha + 2, coluna);
			
			colocarPeca(linha, coluna);
			colocarPeca(linha + 1, coluna);
			colocarPeca(linha + 2, coluna);
		}
		contNavioDeTresCanos++;
		contPecasColocadas++;
	}

	public void colocarNavioDeQuatroCanos(int linha, int coluna, String direcao) {
		if (contNavioDeQuatroCanos == MAX_NAVIO_DE_QUATRO_CANOS) {
			throw new ExcecaoBatalhaNaval("Numero máximo de Navio de quatro canos é 1");
		}
		if (direcao.equals("horizontal")) {
			verificarLimites(linha, coluna);
			verificarLimites(linha, coluna + 1);
			verificarLimites(linha, coluna + 2);
			verificarLimites(linha, coluna + 3);
			
			colocarPeca(linha ,coluna);
			colocarPeca(linha, coluna + 1);
			colocarPeca(linha, coluna + 2);
			colocarPeca(linha, coluna + 3);	
		} else if (direcao.equals("vertical")) {
			verificarLimites(linha, coluna);
			verificarLimites(linha + 1, coluna);
			verificarLimites(linha + 2, coluna);
			verificarLimites(linha + 3, coluna);
			
			colocarPeca(linha, coluna);
			colocarPeca(linha + 1, coluna);
			colocarPeca(linha + 2, coluna);
			colocarPeca(linha + 3, coluna);
		}
		contNavioDeQuatroCanos++;
		contPecasColocadas++;
	} 
	
	public void colocarPortaAvioes(int linha, int coluna, String direcao) {
		if (contPortaAvioes == MAX_PORTA_AVIOES) {
			throw new ExcecaoBatalhaNaval("Numero máximo de Porta Avioes é 1");
		}
		if (direcao.equals("cima")) {
			verificarLimites(linha, coluna);
			verificarLimites(linha, coluna - 1);
			verificarLimites(linha, coluna + 1);
			verificarLimites(linha - 1, coluna);
			
			colocarPeca(linha, coluna);
			colocarPeca(linha, coluna - 1);
			colocarPeca(linha, coluna + 1);
			colocarPeca(linha - 1, coluna);
		} else if (direcao.equals("baixo")) {
			verificarLimites(linha, coluna);
			verificarLimites(linha, coluna - 1);
			verificarLimites(linha, coluna + 1);
			verificarLimites(linha + 1, coluna);
			
			colocarPeca(linha, coluna);
			colocarPeca(linha, coluna - 1);
			colocarPeca(linha, coluna + 1);
			colocarPeca(linha + 1, coluna);
		} else if (direcao.equals("esquerda")) {
			verificarLimites(linha, coluna);
			verificarLimites(linha - 1, coluna);
			verificarLimites(linha + 1, coluna);
			verificarLimites(linha, coluna - 1);
			
			colocarPeca(linha, coluna);
			colocarPeca(linha - 1, coluna);
			colocarPeca(linha + 1, coluna);
			colocarPeca(linha, coluna - 1);
		} else if (direcao.equals("direita")) {
			verificarLimites(linha, coluna);
			verificarLimites(linha - 1, coluna);
			verificarLimites(linha + 1, coluna);
			verificarLimites(linha, coluna + 1);
			
			colocarPeca(linha, coluna);
			colocarPeca(linha - 1, coluna);
			colocarPeca(linha + 1, coluna);
			colocarPeca(linha, coluna + 1);
		}
		contPortaAvioes++;
		contPecasColocadas++;
	}
}
