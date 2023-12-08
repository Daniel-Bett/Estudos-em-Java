package jogo;

public class Main {

	public static void main(String[] args) {
		Matriz m= new Matriz();
		Jogador p1= new Jogador();
		Jogador p2= new Jogador();
		p1.setSuaVez(true);
		
		do {
			m.mostraMatriz();
			if(p1.isSuaVez()==true) {
				EntradaSaida.mostraTexto("É a vez de "+p1.getNome());
				InteracoesJogo.inserirValor(m, p1.getNum());
				p1.setSuaVez(false);
				p2.setSuaVez(true);
			}else {
				EntradaSaida.mostraTexto("É a vez de "+p2.getNome());
				InteracoesJogo.inserirValor(m, p2.getNum());
				p1.setSuaVez(true);
				p2.setSuaVez(false);
			}
			
		}while(m.isGanhou()==false);
		m.mostraMatriz();
		
		if(p1.isSuaVez()==false) {
			EntradaSaida.mostraTexto("O Jogador "+p1.getNome()+" é o vencedor!!");
		}
		
		if(p2.isSuaVez()==false) {
			EntradaSaida.mostraTexto("O Jogador "+p2.getNome()+" é o vencedor!!");
		}
	
	}

}
