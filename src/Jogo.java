
public class Jogo {
	
	private static final int MAX_NAVIO_DE_UM_CANO = 4;
	private int contNavioDeUmCano = 0;
	private static final int MAX_NAVIO_DE_DOIS_CANOS = 3;
	private int contNavioDeDoisCanos = 0;
	private static final int MAX_NAVIO_DE_TRES_CANOS = 2;
	private int contNavioDeTresCanos = 0;
	private static final int MAX_NAVIO_DE_QUATRO_CANOS = 1;
	private int contNavioDeQuatroCanos = 0;
	
	private boolean jogadorDaVez;
	private Boolean[][] tabuleiro = new Boolean[10][10];
	

	public boolean acabou() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setJogador(boolean jogadorDaVez) {
		this.jogadorDaVez = jogadorDaVez;
	}

	public boolean isJogador() {
		// TODO Auto-generated method stub
		return jogadorDaVez;
	}

	public void colocarPeca(int linha, int coluna) {
		verificarLimites(linha, coluna);
		if (tabuleiro[linha][coluna] != null) {
			throw new ExcecaoBatalhaNaval("Celula ocupada");
		}
		tabuleiro[linha][coluna] = jogadorDaVez;
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
		colocarPeca(linha, coluna);
		contNavioDeUmCano++;
	}

	public void colocarNavioDeDoisCanos(int linha, int coluna, String direcao) {
		colocarPeca(linha, coluna);
		if (contNavioDeDoisCanos == MAX_NAVIO_DE_DOIS_CANOS) {
			throw new ExcecaoBatalhaNaval("Numero máximo de Navio de dois canos é 3.");
		}
		if(direcao.equals("horizontal")) {
			colocarPeca(linha, coluna + 1);
			contNavioDeDoisCanos++;
		} else if (direcao.equals("vertical")) {
			colocarPeca(linha + 1, coluna);
			contNavioDeDoisCanos++;
		}
	}

	public void colocarNavioDeTresCanos(int linha, int coluna, String direcao) {
		colocarPeca(linha, coluna);
		if (contNavioDeTresCanos == MAX_NAVIO_DE_TRES_CANOS) {
			throw new ExcecaoBatalhaNaval("Numero máximo de Navio de três canos é 2.");
		}
		if (direcao.equals("horizontal")) {
			colocarPeca(linha, coluna + 1);
			colocarPeca(linha, coluna + 2);
			contNavioDeTresCanos++;
		} else if (direcao.equals("vertical")) {
			colocarPeca(linha + 1, coluna);
			colocarPeca(linha + 2, coluna);
			contNavioDeTresCanos++;
		} 
	}

	public void colocarNavioDeQuatroCanos(int linha, int coluna, String direcao) {
		colocarPeca(linha,coluna);
		if (contNavioDeQuatroCanos == MAX_NAVIO_DE_QUATRO_CANOS) {
			throw new ExcecaoBatalhaNaval("Numero máximo de Navio de quatro canos é 1");
		}
		if (direcao.equals("horizontal")) {
			colocarPeca(linha, coluna + 1);
			colocarPeca(linha, coluna + 2);
			colocarPeca(linha, coluna + 3);
			contNavioDeQuatroCanos++;
		} else if (direcao.equals("vertical")) {
			colocarPeca(linha + 1, coluna);
			colocarPeca(linha + 2, coluna);
			colocarPeca(linha + 3, coluna);
			contNavioDeQuatroCanos++;
		}
		
	}
	
	
}

	
	

