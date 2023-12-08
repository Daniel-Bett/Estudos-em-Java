package jogo;

public class InteracoesJogo {
	public static void inserirValor(Matriz m, int valor ) {
		
		int lin=EntradaSaida.solicitaInteiro("Digite a linha que deseja posicionar");
		int col= EntradaSaida.solicitaInteiro("Digite a coluna que deseja posicionar");
		
		do {
			if(verificaPosicao(m, lin, col) == false) {
				System.out.println("Posicao invalida, tente novamente");
				m.mostraMatriz();
				lin=EntradaSaida.solicitaInteiro("Digite a linha que deseja posicionar");
				col= EntradaSaida.solicitaInteiro("Digite a coluna que deseja posicionar");	
			}
		}while(verificaPosicao(m, lin, col)==false);
		
		if(m.isGanhou()==false) {
			m.setValor(valor, lin,col);
		}
		verificaGanhador(m);
	}
	
	public static void verificaGanhador(Matriz m) {
		boolean x =false;
		if(verificaLinha(m)==true) {
			x=true;
		}else if(verificaColuna(m)) {
			x=true;
		}else if(verificaDiagonal(m)) {
			x=true;
		}
		
		m.setGanhou(x);

	}
	
	public static boolean verificaPosicao(Matriz m,int lin, int col) {
		boolean x=false;
		if(lin > 2 || lin <0 || col > 2 || col < 0)
			return x;
		if(m.getValor(lin, col)==0)
			x=true;
		return x;
	}
	
	private static boolean verificaLinha(Matriz m) {
		boolean x=false;
		for(int i=0; i<3;i++) {
			if(m.getValor(i, 0) == m.getValor(i, 1)&& m.getValor(i, 1) == m.getValor(i, 2)) {
				if(m.getValor(i, 0) !=0 && m.getValor(i, 1) !=0 && m.getValor(i, 2)!=0) {
					x=true;
				}
			}
		}
		return x;
	}
	private static boolean verificaColuna(Matriz m) {
		boolean x=false;
		for(int i=0; i<3;i++) {
			if(m.getValor(0, i) == m.getValor(1, i)&& m.getValor(1, i) == m.getValor(2, i)) {
				if(m.getValor(0, i) !=0 && m.getValor(1, i) !=0 && m.getValor(2, i)!=0) {
					x=true;
				}
			}
		}
		return x;
	}
	
	private static boolean verificaDiagonal(Matriz m) {
		boolean x=false;
		if(m.getValor(0, 0)== m.getValor(1, 1)&& m.getValor(2, 2)==m.getValor(0, 0))
			if(m.getValor(0, 0) !=0 && m.getValor(1, 1) !=0 && m.getValor(2, 2)!=0) 
				x=true;
		
		if(m.getValor(0, 2)== m.getValor(1, 1)&& m.getValor(2, 0)==m.getValor(1, 1))
			if(m.getValor(0, 2) !=0 && m.getValor(1, 1) !=0 && m.getValor(2, 0)!=0) 
				x=true;
				
		return x;
	}
}
