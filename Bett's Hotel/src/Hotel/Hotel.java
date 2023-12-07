package Hotel;

import java.util.ArrayList;

public class Hotel {
	private ArrayList<Hospede> listaHospedes;
	private ArrayList<Produto> listaProdutos;
	private ArrayList<Reserva> listaReservas;
	private ArrayList<ServicoQuarto> listaServicosQuartos;
	private ArrayList<Lavanderia> listaLavanderia;
	private ArrayList<Quarto> listaQuartos;
	
	public Hotel() {
		listaQuartos = new ArrayList<>();
		listaHospedes = new ArrayList<>();
		listaProdutos = new ArrayList<>();
		listaReservas = new ArrayList<>();
		listaServicosQuartos= new ArrayList<>();
		listaLavanderia = new ArrayList<>();
		
	}
	
	
	
	public int reservar(Hotel h) {
		int diaE, mesE,anoE,diaS,mesS,anoS;
		
		diaE=EntradaSaida.solicitarNumero("Digite o dia da entrada");
		mesE=EntradaSaida.solicitarNumero("Digite o mes da entrada");
		anoE=EntradaSaida.solicitarNumero("Digite o ano da entrada");
		diaS=EntradaSaida.solicitarNumero("Digite o dia da saida");
		mesS=EntradaSaida.solicitarNumero("Digite o mes da saida");
		anoS=EntradaSaida.solicitarNumero("Digite o ano da saida");
		
		if(diaE<=0 || diaE>30 || diaS <=0 || diaS>30 || mesE>12 || mesE <=0 ||mesS<=0 || mesS>30 || anoE <2023 || anoS<2023) {
			EntradaSaida.mostraTexto("Erro nas Datas");
			return 0;
		}
		if(anoS < anoE) {
			EntradaSaida.mostraTexto("Ano de Entrada não é compativel com a Saída");
			return 0;
		}else{
			if(mesS<mesE)
			{
				EntradaSaida.mostraTexto("Mes de Entrada não é compativel com a Saída");
				return 0;
			}else {
				if(anoS == anoE && mesS == mesE && diaS < diaE) {
					EntradaSaida.mostraTexto("Dia de Entrada não é compativel com a Saída");
					return 0;
				}	
			}
		}
		
		Quarto a = h.selecionaQuarto(h, diaE,mesE, anoE);
		if(a==null) {
			int i=EntradaSaida.solicitarNumero("Deseja tentar novamente? Digite: 1-Sim 0-Nao");
			if(i==1) {
				return reservar(h);
			}
			return 0;
	}

		int qtdPessoas=EntradaSaida.solicitarNumero("Quantas pessoas vão ocupar este quarto: ");
		if(qtdPessoas>a.getQtdPessoas()) {
			EntradaSaida.mostraTexto("ERRO, quarto não suporta essa quantidade de pessoas");
			return 0;
		}
		EntradaSaida.mostraTexto("Faremos agora o cadastro do Responsavel da reserva");
		Hospede d = new Hospede(EntradaSaida.solicitarTexto("Digite o Nome: "),EntradaSaida.solicitarTexto("Digite o CPF: "), EntradaSaida.solicitarTexto("Digite um numero para contato: "), EntradaSaida.solicitarTexto("Digite o CEP: "),a);
		h.adicionarHospedes(d);
		
		Reserva b = new Reserva(d,a,diaE,mesE,anoE,diaS,mesS,anoS,EntradaSaida.solicitarNumero("Quantas pessoas na reserva: "));
		b.setDisponivel(false);
		d.setReserva(b);
		h.adicionarReservas(b);
		
		if(b.getQtdPessoas()>1) {
			EntradaSaida.mostraTexto("Nessa etapa cadastraremos todos os Hospedes, desconsidere o responsavel da reserva");
			for(int i=0;i<b.getQtdPessoas()-1;i++) {
				Hospede c = new Hospede(EntradaSaida.solicitarTexto("Digite o Nome: "),EntradaSaida.solicitarTexto("Digite o CPF: "), EntradaSaida.solicitarTexto("Digite um numero para contato: "), EntradaSaida.solicitarTexto("Digite o CEP: "),a);//digitar as entradasSaidas
				h.adicionarHospedes(c);
				c.setReserva(b);
			}
		}
		return 1;
	}
	
	private boolean verificaDisponibilidadeQuarto(Quarto quarto, int diaE,int mesE, int anoE) {
	   
	        for(Reserva reserva : listaReservas) {
	        	if(quarto == reserva.getQuarto()) {
	        		int dia=reserva.getDataEntradaDia() , mes=reserva.getDataEntradaMes() ,ano=reserva.getDataEntradaAno();
	        		for(int i =0; i<reserva.getQuantidadeDias(); i++) {
	        			if(anoE == ano && mesE == mes && diaE==dia)
	        				return true;
	        			dia++;
	        			if(dia>30) {
	        				dia=1;
	        				mes++;
	        			}
	        			if(mes>12) {
	        				mes=1;
	        				ano++;
	        			}
	        			
	        		}
	        	}
	        		
	        }
	        
	        return false;
	    }
	private boolean verificaDisponibilidade(Quarto quarto, int diaE,int mesE, int anoE) {
		   
        for(Reserva reserva : listaReservas) {
        	if(quarto == reserva.getQuarto()) {
        		int dia=reserva.getDataEntradaDia() , mes=reserva.getDataEntradaMes() ,ano=reserva.getDataEntradaAno();
        		for(int i =0; i<reserva.getQuantidadeDias(); i++) {
        			if(anoE == ano && mesE == mes && diaE==dia)
        				return false;
        			dia++;
        			if(dia>30) {
        				dia=1;
        				mes++;
        			}
        			if(mes>12) {
        				mes=1;
        				ano++;
        			}
        			
        		}
        	}
        		
        }
        
        return true;
    }
	

	public void criarQuartos(Hotel h) {
		int i;
		for(i=1; i<=3;i++) {
			Quarto luxo = new Quarto("Luxo", i+20, 4, 200 );
			Quarto simples = new Quarto("Simples", i, 1,80);
			Quarto intermediario = new Quarto("Intermediario",i+10,2,150);
			h.adicionarQuarto(simples);
			h.adicionarQuarto(intermediario);
			h.adicionarQuarto(luxo);
		}
		
	}
	
	public void criarProduto(Hotel h) {
			Produto a = new Produto("Refrigerante",5.50);
			h.adicionarProduto(a);
			Produto b = new Produto("Salgadinho",7.50);
			h.adicionarProduto(b);
			Produto c = new Produto("Chocolate",3.50);
			h.adicionarProduto(c);
			Produto d = new Produto("Sabonete",1.50);
			h.adicionarProduto(d);
			Produto e = new Produto("Toalha",25);
			h.adicionarProduto(e);
		}
	
	public void criarReserva(Hotel h) {
	    Quarto quarto1 = buscarQuarto(1);
	    Hospede hospede1 = new Hospede("Zezinho", "456789123", "4002-8022", "89755", quarto1);
	    Reserva a = new Reserva(hospede1, hospede1.getQuarto(), 2, 3, 2024, 5, 3, 2024, 1);
	    h.adicionarReservas(a);
	    h.adicionarHospedes(hospede1);
	    hospede1.setReserva(a);
	    hospede1.setQuarto(quarto1);

	    Quarto quarto2 = buscarQuarto(11);
	    Hospede hospede2 = new Hospede("Cecilia", "123", "4002-8022", "89755", quarto2);
	    Reserva b = new Reserva(hospede2, hospede2.getQuarto(), 2, 4, 2024, 5, 4, 2024, 1);
	    h.adicionarReservas(b);
	    h.adicionarHospedes(hospede2);
	    hospede2.setReserva(b);
	    hospede2.setQuarto(quarto2);


	    Quarto quarto3 = buscarQuarto(21);
	    Hospede hospede3 = new Hospede("Bett", "456", "4002-8022", "89755", quarto3);
	    Reserva c = new Reserva(hospede3, hospede3.getQuarto(), 18, 3, 2024, 19, 3, 2024, 1);
	    h.adicionarReservas(c);
	    h.adicionarHospedes(hospede3);
	    hospede3.setReserva(c);
	    hospede3.setQuarto(quarto3);

	}
	

	public void mostraQuartos() {
	for(Quarto quarto: listaQuartos) {
		EntradaSaida.mostraTexto("Tipo: "+quarto.getTipo()+" Número: "+quarto.getNum()+" Capacidade Maxima: "+quarto.getQtdPessoas()+" Disponivel: "+quarto.isDisponibilidade()+" Valor da Diaria:"+ quarto.getPreco());
		
		}
	}
	public void mostraHospedes() {
		for(Hospede hospede : listaHospedes) {
			Quarto a = hospede.getQuarto();
			EntradaSaida.mostraTexto("Nome: "+hospede.getNome()+" Cpf: "+hospede.getCpf()+" CEP: "+hospede.getCep()+" Contato: "+hospede.getContato()+"Quarto: "+ a.getNum());
		}
	}
	private void mostraQuarto(Quarto quarto) {
		EntradaSaida.mostraTexto("Tipo: "+quarto.getTipo()+" Número: "+quarto.getNum()+" Capacidade Maxima: "+quarto.getQtdPessoas()+" Disponivel: "+quarto.isDisponibilidade()+" Valor da Diaria:"+ quarto.getPreco());
	}
	
	public void mostraProdutos() {
		for(Produto produto: listaProdutos) {
			EntradaSaida.mostraTexto("Nome: "+produto.getNome()+" Preco: R$"+produto.getPreco());
			
			}
		}
	
	private void mostraHospede(Hospede hospede) {
		Quarto a = hospede.getQuarto();
		EntradaSaida.mostraTexto("Nome: "+hospede.getNome()+" Cpf: "+hospede.getCpf()+" CEP: "+hospede.getCep()+" Contato: "+hospede.getContato()+"Quarto: "+ a.getNum());
	}
	
	public void mostraReserva() {
		for(Reserva reserva: listaReservas) {
			Hospede a = reserva.getHospedeResponsavel();
			Quarto b = reserva.getQuarto();
			EntradaSaida.mostraTexto("Hospede Responsavel: "+a.getNome()+" quantidade dias: " + reserva.getQuantidadeDias()+ " Quarto: "+ b.getNum());
		}
	}
	
	public int contagemHospedes() {
		return listaHospedes.size();
	}
	
	public int contagemQuartoDisponiveis() {
		int cont = 0;
		for(Quarto quarto : listaQuartos) {
			if(quarto.isDisponibilidade()) {
				cont ++;
			}
		}
		return cont;
	}
		
	private Quarto selecionaQuarto(Hotel h, int diaE, int mesE, int anoE) {
		h.mostraQuartosDisponiveis(diaE,mesE,anoE);
		int num=EntradaSaida.solicitarNumero("Digite o numero do Quarto que Deseja");
		Quarto q=null;
		 for (Quarto quarto : listaQuartos) {
		        if (quarto.getNum() == num && quarto.isDisponibilidade()) {
		        	q=quarto;
		            break;
		        }
		 }
		if(h.verificaDisponibilidadeQuarto(q, diaE, mesE, anoE)) {
			EntradaSaida.mostraTexto("Quarto escolhido está ocupado");
			return null;
		}
		return q;
	}
	
	public void finalizarReserva() {
		Hospede hospede = buscaHospede();
		mostraHospede(hospede);
		Quarto quarto = hospede.getQuarto();
		Reserva reserva = null;
		for(Reserva r : listaReservas) {
			if(r.getHospedeResponsavel() == hospede) {
				reserva=r;
			}
		}
		if(reserva.getListaLavanderiaReserva() != null) {
			EntradaSaida.mostraTexto("Lista do uso da lavanderia");
			for(Lavanderia lavanderia : reserva.getListaLavanderiaReserva())
				EntradaSaida.mostraTexto("Data:"+lavanderia.getData()+" Descricao:" +lavanderia.getDescricao()+ " Preco:"+ lavanderia.getPreco()+" Quantidade de roupas:" +lavanderia.getQtdeRoupas());
		}
		if(reserva.getListaServicosQuartosReserva() != null) {
			EntradaSaida.mostraTexto("Lista de servicos de quarto utilizado");
			for(ServicoQuarto servico : reserva.getListaServicosQuartosReserva()) {
				Produto p = servico.getProduto();
				EntradaSaida.mostraTexto("Data:"+servico.getData()+" Descricao:" +servico.getDescricao()+ " Preco:"+ servico.getPreco()+" Produto:" +p.getNome());
			}
				
		}
		
		
		double precoFinal= (reserva.getQuantidadeDias()*quarto.getPreco())+ reserva.getAdicionais();
		EntradaSaida.mostraTexto("O valor a ser pago por "+hospede.getNome()+" é de:R$"+precoFinal);
		ArrayList<Hospede> copiaHospedes = new ArrayList<>(listaHospedes);

		for (Hospede hp : copiaHospedes) {
		    if (hp.getReserva() == reserva) {
		        listaHospedes.remove(hp);
		    }
		}

		listaReservas.remove(reserva);
		
	}
	
	public void quartoIndisponivel() {
		Quarto quarto = buscarQuarto(EntradaSaida.solicitarNumero("Digite o numero do Quarto:"));
		quarto.setDisponibilidade(false);
	}
	
	private Hospede buscaHospede() {
		String cpf= EntradaSaida.solicitarTexto("Digite o Cpf que procura");
		Hospede hospede=null;
		 for (Hospede h1 : listaHospedes) {
		        if (h1.getCpf().equals(cpf) ) {
		        	hospede=h1;
		            break;
		        }
		 }
		return hospede;
	}
	
	public void consumirServico() {
		Hospede hospede = buscaHospede();
		int escolha = EntradaSaida.solicitarNumero("Digite 1 para Servico de Lavanderia ou 2 para Servico de Quarto");
			switch(escolha) {
				case 1:
					consumirLavanderia(hospede);
					break;
				case 2:
					consumirServicoQuarto(hospede);
					break;
				default:
					EntradaSaida.mostraTexto("Erro na escolha");
			}
	}
	private void mostraQuartosDisponiveis(int dia, int mes, int ano) {
	    for (Quarto quarto : listaQuartos) {
	    		if(verificaDisponibilidade
	    				(quarto, dia, mes, ano)) {
	    			mostraQuarto(quarto);
	        }
	    }
	}
	
	private void consumirLavanderia(Hospede hospede) {
		Reserva reserva = hospede.getReserva();
		
		Lavanderia lavaDez = new Lavanderia();
		lavaDez.setData(EntradaSaida.solicitarTexto("Digite a Data do Servico"));
		lavaDez.setDescricao(EntradaSaida.solicitarTexto("Digite a descricao do Servico: "));
		lavaDez.setQtdeRoupas(EntradaSaida.solicitarNumero("Digite a quantidade de roupa para lavar: "));
		lavaDez.setPreco(lavaDez.getQtdeRoupas() * 2);
		reserva.adicionarListaLavanderia(lavaDez);
		reserva.setAdicionais(lavaDez.getPreco());

		
	}
	
	private void consumirServicoQuarto(Hospede hospede) {
			Reserva reserva = hospede.getReserva();
			ServicoQuarto servicoQuarto = new ServicoQuarto();
			for(Produto p : listaProdutos) {
				EntradaSaida.mostraTexto("Nome:"+p.getNome()+ " Preco:"+ p.getPreco());
			}
			String escolha = EntradaSaida.solicitarTexto("Digite o nome do Produto");
			for(Produto p : listaProdutos) {
				if(escolha.equals(p.getNome())) {
					servicoQuarto.setProduto(p);
					servicoQuarto.setPreco(p.getPreco());
					reserva.setAdicionais(servicoQuarto.getPreco());
				}
			}
			
			servicoQuarto.setData(EntradaSaida.solicitarTexto("Digite a Data do Servico"));
			servicoQuarto.setDescricao("Consumo de um produto em estoque");
			reserva.adicionarListaServicosQuartosReserva(servicoQuarto);
			
	}
	
	private Quarto buscarQuarto(int num) {
		Quarto quarto=null;
		for(Quarto q : listaQuartos) {
			if(num == q.getNum())
				quarto =q;
		}
		return quarto;
	}

	public void adicionarQuarto() {
		Quarto quarto = new Quarto(EntradaSaida.solicitarTexto("Digite o tipo do Quarto"),EntradaSaida.solicitarNumero("Digite o numero do quarto"),EntradaSaida.solicitarNumero("Digite a capacidade do quarto"),EntradaSaida.solicitarNumeroDouble("Digite o preco do quarto"));
		listaQuartos.add(quarto);
	}
	
	public void removerQuarto() {
		Quarto quarto = buscarQuarto(EntradaSaida.solicitarNumero("Digite o numero do Quarto"));
		listaQuartos.remove(quarto);
	}
	
	public ArrayList<Produto> getListaProdutos() {
		return listaProdutos;
	}
	public void setListaProdutos(ArrayList<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	public ArrayList<Reserva> getListaReservas() {
		return listaReservas;
	}
	public void setListaReservas(ArrayList<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
	}

	
	public ArrayList<Quarto> getListaQuartos() {
		return listaQuartos;
	}
	public void setListaQuartos(ArrayList<Quarto> listaQuartos) {
		this.listaQuartos = listaQuartos;
	}
	
	public void adicionarQuarto(Quarto quarto) {
		listaQuartos.add(quarto);
	}
	
	public void adicionarProduto(Produto produto) {
		listaProdutos.add(produto);
	}
	
	public void adicionarHospedes(Hospede hospede) {
		listaHospedes.add(hospede);
	}
	
	public void adicionarServicoQuarto(ServicoQuarto servicoQuarto) {
		listaServicosQuartos.add(servicoQuarto);
	}
	
	public void adicionarLavanderia(Lavanderia lavanderia) {
		listaLavanderia.add(lavanderia);
	}
	
	public void adicionarReservas(Reserva reserva) {
		listaReservas.add(reserva);
	}
	
	public ArrayList<Hospede> getListaHospedes() {
		return listaHospedes;
	}
	public void setListaHospedes(ArrayList<Hospede> listaHospedes) {
		this.listaHospedes = listaHospedes;
	}



	public ArrayList<ServicoQuarto> getListaServicosQuartos() {
		return listaServicosQuartos;
	}



	public void setListaServicosQuartos(ArrayList<ServicoQuarto> listaServicosQuartos) {
		this.listaServicosQuartos = listaServicosQuartos;
	}



	public ArrayList<Lavanderia> getListaLavanderia() {
		return listaLavanderia;
	}



	public void setListaLavanderia(ArrayList<Lavanderia> listaLavanderia) {
		this.listaLavanderia = listaLavanderia;
	}
}


