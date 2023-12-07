package Hotel;

public class Quarto {
	private String tipo;
	private int num;
	private int qtdPessoas;
	private boolean disponibilidade;
	private double preco;
	
	public Quarto(String tipo, int num, int qtdPessoas, double preco) {
		this.tipo=tipo;
		this.num=num;
		this.qtdPessoas=qtdPessoas;
		this.disponibilidade=true;
		this.preco=preco;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getQtdPessoas() {
		return qtdPessoas;
	}
	public void setQtdPessoas(int qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}
	public boolean isDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
}
