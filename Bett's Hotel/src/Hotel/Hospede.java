package Hotel;

public class Hospede {
	private String nome;
	private String cpf;
	private String contato;
	private String cep;
	private Quarto quarto;
	private Reserva reserva;
	
	public Hospede(String nome, String cpf, String contato, String cep, Quarto quarto) {
		this.nome=nome;
		this.cpf=cpf;
		this.contato=contato;
		this.cep=cep;
		this.quarto=quarto;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Quarto getQuarto() {
		return quarto;
	}
	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
	public void mostra(Hospede hospede) {
		System.out.println(hospede.quarto.getNum());
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
}
