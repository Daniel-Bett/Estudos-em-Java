package Hotel;

import java.util.ArrayList;

public class Reserva {

		private Hospede hospedeResponsavel;
		private Quarto quarto;
		private int dataEntradaDia;
		private int dataEntradaMes;
		private int dataEntradaAno;
		private int dataSaidaDia;
		private int dataSaidaMes;
		private int dataSaidaAno;
		private int quantidadeDias;
		private int qtdPessoas;
		private boolean disponivel;
		private double adicionais;
		private ArrayList<ServicoQuarto> listaServicosQuartosReserva;
		private ArrayList<Lavanderia> listaLavanderiaReserva;

	public Reserva(Hospede hospedeResponsavel, Quarto quarto, int dataEntradaDia, int dataEntradaMes,int dataEntradaAno, int dataSaidaDia, int dataSaidaMes, int dataSaidaAno,int qtdPessoas) {
		this.hospedeResponsavel = hospedeResponsavel;
		this.quarto = quarto;
		this.dataEntradaDia = dataEntradaDia;
		this.dataEntradaMes = dataEntradaMes;
		this.dataEntradaAno = dataEntradaAno;
		this.dataSaidaDia = dataSaidaDia;
		this.dataSaidaMes = dataSaidaMes;
		this.dataSaidaAno = dataSaidaAno;
		this.qtdPessoas = qtdPessoas;
		this.disponivel = true;
		this.adicionais = 0;
		listaServicosQuartosReserva = new ArrayList<>();;
		listaLavanderiaReserva = new ArrayList<>();;
		int cont=0;
		
		while(dataEntradaAno != dataSaidaAno) {
			dataEntradaDia++;
			if(dataEntradaDia>30) {
				dataEntradaMes++;
				dataEntradaDia=1;
			}
			if(dataEntradaMes>12) {
				dataEntradaAno++;
				dataEntradaMes=1;
			}
				
			cont++;
		}
		
		while(dataEntradaMes!=dataSaidaMes) {
			dataEntradaDia++;
			if(dataEntradaDia>30) {
				dataEntradaMes++;
				dataEntradaDia=1;
			}
			cont++;
		}
		
		while(dataEntradaDia != dataSaidaDia) {
			dataEntradaDia++;
			cont++;
		}
			
		this.quantidadeDias=cont;
	}
	
	public Hospede getHospedeResponsavel() {
		return hospedeResponsavel;
	}
	public void setHospedeResponsavel(Hospede hospedeResponsavel) {
		this.hospedeResponsavel = hospedeResponsavel;
	}
	public Quarto getQuarto() {
		return quarto;
	}
	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
	public int getDataEntradaDia() {
		return dataEntradaDia;
	}
	public void setDataEntradaDia(int dataEntradaDia) {
		this.dataEntradaDia = dataEntradaDia;
	}
	public int getDataEntradaMes() {
		return dataEntradaMes;
	}
	public void setDataEntradaMes(int dataEntradaMes) {
		this.dataEntradaMes = dataEntradaMes;
	}
	public int getDataEntradaAno() {
		return dataEntradaAno;
	}
	public void setDataEntradaAno(int dataEntradaAno) {
		this.dataEntradaAno = dataEntradaAno;
	}
	public int getDataSaidaDia() {
		return dataSaidaDia;
	}
	public void setDataSaidaDia(int dataSaidaDia) {
		this.dataSaidaDia = dataSaidaDia;
	}
	public int getDataSaidaMes() {
		return dataSaidaMes;
	}
	public void setDataSaidaMes(int dataSaidaMes) {
		this.dataSaidaMes = dataSaidaMes;
	}
	public int getDataSaidaAno() {
		return dataSaidaAno;
	}
	public void setDataSaidaAno(int dataSaidaAno) {
		this.dataSaidaAno = dataSaidaAno;
	}
	public int getQuantidadeDias() {
		return quantidadeDias;
	}
	public void setQuantidadeDias(int quantidadeDias) {
		this.quantidadeDias = quantidadeDias;
	}
	public void setQtdPessoas(int qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}
	public int getQtdPessoas() {
		return qtdPessoas;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public double getAdicionais() {
		return adicionais;
	}

	public void setAdicionais(double adicionais) {
		this.adicionais += adicionais;
	}

	public ArrayList<ServicoQuarto> getListaServicosQuartosReserva() {
		return listaServicosQuartosReserva;
	}

	public void setListaServicosQuartosReserva(ArrayList<ServicoQuarto> listaServicosQuartosReserva) {
		this.listaServicosQuartosReserva = listaServicosQuartosReserva;
	}

	public ArrayList<Lavanderia> getListaLavanderiaReserva() {
		return listaLavanderiaReserva;
	}
	
	public void setListaLavanderiaReserva(ArrayList<Lavanderia> listaLavanderiaReserva) {
		this.listaLavanderiaReserva = listaLavanderiaReserva;
	}
	
	public void adicionarListaServicosQuartosReserva(ServicoQuarto servicoQuarto) {
		listaServicosQuartosReserva.add(servicoQuarto);
	}
	
	public void adicionarListaLavanderia(Lavanderia lavanderia) {
		 listaLavanderiaReserva.add(lavanderia);
	}
	
}
