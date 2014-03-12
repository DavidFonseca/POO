
public class Jogo {
	
	private static int MAX_NAVIU_DE_UM_CANO = 4;
	private int contNaviuDeUmCano = 0;
	private static int MAX_NAVIU_DE_DOIS_CANOS = 3;
	private int contNaviuDeDoisCanos = 0;
	
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
	
	public void colocarNaviuDeUmCano(int linha, int coluna) {
		
		if (contNaviuDeUmCano == MAX_NAVIU_DE_UM_CANO) {
			throw new ExcecaoBatalhaNaval("Numero m�ximo de naviu de um cano � 4.");
		}
		colocarPeca(linha, coluna);
		contNaviuDeUmCano++;
	}

	public void colocarNaviuDeDoisCanos(int linha, int coluna, String direcao) {
		colocarPeca(linha, coluna);
		if (contNaviuDeDoisCanos == MAX_NAVIU_DE_DOIS_CANOS) {
			throw new ExcecaoBatalhaNaval("Numero m�ximo de naviu de dois canos � 3.");
		}
		if(direcao.equals("horizontal")) {
			colocarPeca(linha, coluna + 1);
			contNaviuDeDoisCanos++;
		} else if (direcao.equals("vertical")) {
			colocarPeca(linha + 1, coluna);
			contNaviuDeDoisCanos++;
		}
	}
	
}

	
	

