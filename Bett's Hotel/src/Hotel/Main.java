package Hotel;

public class Main{

	public static void main(String[] args) {
		Hotel Tannenhof = new Hotel();
		ServicoQuarto servicoQuarto = new ServicoQuarto();
		servicoQuarto.setListaProdutos(Tannenhof.getListaProdutos());
		Tannenhof.criarQuartos(Tannenhof);
		Tannenhof.criarProduto(Tannenhof);
		Tannenhof.criarReserva(Tannenhof);
		EntradaSaida.mostraTexto("Seja Bem-vindo ao sistema Bett's hotel");
		int i =-1;
		EntradaSaida.mostraTexto("Escolha o número relativo ao servico que deseja: ");
		while(i!=0) {
			i=EntradaSaida.solicitarNumero("1-Reservar 2-Mostrar Quartos 3-Mostrar Hospedes 4-Mostrar Reserva"
					+ " 5-Quantidade de Hospedes 6-Contagem de Quartos 7- Consumir Servico 8-Deixar Quarto indisponivel"
					+ " 9-Finalizar Reserva 10-Adicionar Quarto 11- remover Quarto 0-Sair");
			switch(i) {
				case 0:
					EntradaSaida.mostraTexto("Obrigado por usar nosso sistema");
					break;
				case 1:
					Tannenhof.reservar(Tannenhof);
					break;
				case 2:
					Tannenhof.mostraQuartos();
					break;
				case 3:
					Tannenhof.mostraHospedes();
					break;
				case 4:
					Tannenhof.mostraReserva();
					break;
				case 5:
					int cont =Tannenhof.contagemHospedes();
					EntradaSaida.mostraTexto("A quantidade de hospede no hotel:"+cont);

					break;
				case 6:
					int conta =Tannenhof.contagemQuartoDisponiveis();
					EntradaSaida.mostraTexto("A quantidade de quartos disponiveis para uso:"+conta);
					break;
				case 7:
					Tannenhof.consumirServico();
					break;
				case 8:
					Tannenhof.quartoIndisponivel();
					break;
				case 9:
					Tannenhof.finalizarReserva();
					break;
				case 10:
					Tannenhof.adicionarQuarto();
					break;
				case 11:
					Tannenhof.removerQuarto();
					break;
				default:
					EntradaSaida.mostraTexto("OPS valor invalido");
			}
		}
		
	}
} 

