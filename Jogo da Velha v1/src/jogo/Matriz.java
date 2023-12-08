package jogo;

public class Matriz {
	private int [][] tabela;
	private boolean ganhou;
	
	public Matriz() {
		tabela = new int[3][3];
		ganhou= false;
		for(int i=0; i<3;i++) {
			for(int j=0; j<3;j++) {
				tabela[i][j]=0;
			}
		}
	}
	
	public void mostraMatriz() {
		for(int i=0; i<3;i++) {
			for(int j=0; j<3;j++) {
				System.out.print(tabela[i][j]+ "|");
			}
			System.out.println();
		}
		
	}
	
	public void setValor(int x, int lin, int col) {
		this.tabela[lin][col]=x;
	}
	
	public boolean isGanhou() {
		return ganhou;
	}

	public void setGanhou(boolean ganhou) {
		this.ganhou = ganhou;
	}

	public int[][] getTabela() {
		return tabela;
	}

	public void setTabela(int[][] tabela) {
		this.tabela = tabela;
	}
	
	public int getValor(int lin, int col) {
		return tabela[lin][col];
	}
}
