package jogo;

public class Jogador {
	private String nome;
	private int num;
	private boolean suaVez;
	
	public Jogador() {
		this.nome= EntradaSaida.solicitarString("Digite seu Nome:");
		this.num=EntradaSaida.solicitaInteiro("Escolha um numero para ser representado");
		this.suaVez=false;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	public boolean isSuaVez() {
		return suaVez;
	}

	public void setSuaVez(boolean suaVez) {
		this.suaVez = suaVez;
	}
}
