package cafe;

import java.util.List;

public class Pedido {
	private double valorTotal = 0;
	public String todosItems = "";
	//ItensPedidos pedidos = new ItensPedidos();
	
	public String getItems() {
		todosItems = "";
		List<Produto> produtos = ItensPedidos.produtos;
		for(int i = 0; i < produtos.size(); i++){
			Produto item = produtos.get(i);
			//System.out.println(item.getNome() +" : "+ Double.toString(item.getValor()));
			todosItems = (todosItems + (item.getNome() +" : "+ Double.toString(item.getValor()) + "\n"));

		}
		System.out.println("Rodando");	
		return todosItems;
	}
	
	public double getValorTotal() {
		valorTotal = 0;
		List<Produto> produtos = ItensPedidos.produtos;
		for(int i = 0; i < produtos.size(); i++){
			Produto item = produtos.get(i);
			setValorTotal(item.getValor() + valorTotal);
		    
		}
		System.out.println(valorTotal);
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public static void limpar() {
		ItensPedidos.produtos.clear();
	}
	
	
}
