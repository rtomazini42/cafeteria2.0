package cafe;

public class Cliente {
	private String Nome;
	private int Telefone;
	Pedido pedido = new Pedido();

	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public int getTelefone() {
		return Telefone;
	}
	public void setTelefone(int telefone) {
		Telefone = telefone;
	}

}
