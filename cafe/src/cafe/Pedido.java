package cafe;

import java.util.List;

public class Pedido {
	private double valorTotal = 0;
	
	//ItensPedidos pedidos = new ItensPedidos();
	
	
	
	public double getValorTotal() {
		List<Produto> produtos = ItensPedidos.produtos;
		for(int i = 0; i < produtos.size(); i++){
			Produto item = produtos.get(i);
			setValorTotal(item.getValor() + valorTotal);
		    //System.out.println(item.getValor());
		    //System.out.println(i);
		    
		}
		System.out.println(valorTotal);
		ItensPedidos.produtos.clear();
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
