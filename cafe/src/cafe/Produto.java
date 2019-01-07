package cafe;

public class Produto {
	private String Nome;
	private double Valor;
	private int quantidade;
	
	public Produto(String Nome,double Valor) {
		this.Nome = Nome;
		this.Valor = Valor;
		setQuantidade(100);
		System.out.println(Nome);
	}
	public  String getNome() {
		return Nome;
	}
	public double getValor() {
		return Valor;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
