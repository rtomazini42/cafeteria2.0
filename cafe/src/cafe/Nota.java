package cafe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;

public class Nota extends JFrame {

	private JPanel contentPane;
	private JTextField Nome;
	private JTextField Telefone;
	private JTextArea lista;
	private JTextArea NotaFiscal;
	int qtdSal = 0;
	int qtdDoc = 0;
	int qtdCaf = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nota frame = new Nota();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Nota() {
		Cliente cliente = new Cliente();
		//System.out.println(Nome.getText());
		//cliente.setNome("Default");
		//cliente.setTelefone(000000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalgado = new JButton("Salgado");
		btnSalgado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Produto salgado = new Produto("salgado",1.99);
				ItensPedidos.produtos.add(salgado);
				qtdSal++;
				lista.setText(Integer.toString(qtdSal) + "x Salgado");
			}
		});
		btnSalgado.setBounds(21, 195, 89, 23);
		contentPane.add(btnSalgado);
		
		JButton addDoce = new JButton("Doce");
		addDoce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto doce = new Produto("doce",1.99);
				ItensPedidos.produtos.add(doce);
				qtdDoc++;
				lista.setText(Integer.toString(qtdDoc) + "x Doce");
			}
		});
		addDoce.setBounds(21, 229, 89, 23);
		contentPane.add(addDoce);
		
		JButton addCafe = new JButton("Caf\u00E9");
		addCafe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto cafe = new Produto("cafe",2.99);
				ItensPedidos.produtos.add(cafe);
				qtdCaf++;
				lista.setText(Integer.toString(qtdCaf) + "x Cafe");
				
			}
		});
		addCafe.setBounds(21, 263, 89, 23);
		contentPane.add(addCafe);
		
		Nome = new JTextField();
		Nome.setDropMode(DropMode.INSERT);
		Nome.setBounds(109, 45, 326, 20);
		contentPane.add(Nome);
		Nome.setColumns(10);
		
		JButton btnNovaNota = new JButton("Nova Nota");
		btnNovaNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qtdSal = 0;
				qtdDoc = 0;
				qtdCaf = 0;
				Cliente cliente = new Cliente();
				//System.out.println(Nome.getText());
				cliente.setNome(Nome.getText());
				NotaFiscal.setText(cliente.getNome());
				cliente.setTelefone(Integer.parseInt(Telefone.getText()));
				Pedido.limpar();
				cliente.pedido.limpar();
				//cliente.pedido.todosItems = null;
				//cliente.pedido.setValorTotal(0.0);
				
				//ItensPedidos.
			}
		});
		btnNovaNota.setBounds(21, 11, 414, 23);
		contentPane.add(btnNovaNota);
		
		
		
		Telefone = new JTextField();
		Telefone.setBounds(109, 76, 326, 20);
		contentPane.add(Telefone);
		Telefone.setColumns(10);
		
		JTextPane txtpnNome = new JTextPane();
		txtpnNome.setEditable(false);
		txtpnNome.setEnabled(false);
		txtpnNome.setText("Nome");
		txtpnNome.setBounds(21, 45, 78, 20);
		contentPane.add(txtpnNome);
		
		JTextPane txtpnTelefone = new JTextPane();
		txtpnTelefone.setEditable(false);
		txtpnTelefone.setText("Telefone");
		txtpnTelefone.setEnabled(false);
		txtpnTelefone.setBounds(21, 76, 78, 20);
		contentPane.add(txtpnTelefone);
		
		JTextPane txtpnPedir = new JTextPane();
		txtpnPedir.setEditable(false);
		txtpnPedir.setEnabled(false);
		txtpnPedir.setText("Pedir:");
		txtpnPedir.setBounds(21, 130, 60, 20);
		contentPane.add(txtpnPedir);
		
		lista = new JTextArea();
		lista.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		lista.setBackground(Color.WHITE);
		lista.setEditable(false);
		lista.setBounds(21, 297, 270, 159);
		contentPane.add(lista);
		lista.setColumns(10);
		
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			private String conteudo;

			public void actionPerformed(ActionEvent e) {
				//cliente.pedido.getItems();
				//cliente.pedido.setValorTotal(0.0);
				conteudo = "----Nota Fiscal-----\n"+"Cliente:"+ cliente.getNome() + "\nTelefone:" +cliente.getTelefone() + "\n" +cliente.pedido.getItems() + "Valor pago" + cliente.pedido.getValorTotal();
				NotaFiscal.setText(conteudo);
			}
		});
		btnPagar.setBounds(21, 462, 89, 23);
		contentPane.add(btnPagar);
		
		NotaFiscal = new JTextArea();
		NotaFiscal.setEditable(false);
		NotaFiscal.setBounds(301, 130, 292, 355);
		contentPane.add(NotaFiscal);
		NotaFiscal.setColumns(10);
	}
}
