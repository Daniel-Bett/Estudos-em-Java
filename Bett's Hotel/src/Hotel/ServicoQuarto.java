package Hotel;
import java.util.ArrayList;

public class ServicoQuarto extends Servico {
	ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	Produto produto;

	public ArrayList<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(ArrayList<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
	public void mostraProdutos() {
		for(Produto p : listaProdutos) {
			EntradaSaida.mostraTexto("Nome:"+p.getNome()+ " Preco:"+ p.getPreco());
		}
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto p) {
		this.produto = p;		
	}
	
}