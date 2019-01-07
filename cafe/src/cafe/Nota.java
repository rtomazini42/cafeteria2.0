package cafe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
	private JTextArea notinha;
	private JTextField NotaFiscal;

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
			}
		});
		btnSalgado.setBounds(21, 161, 89, 23);
		contentPane.add(btnSalgado);
		
		JButton addDoce = new JButton("Doce");
		addDoce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto doce = new Produto("doce",1.99);
				ItensPedidos.produtos.add(doce);
			}
		});
		addDoce.setBounds(21, 195, 89, 23);
		contentPane.add(addDoce);
		
		JButton addCafe = new JButton("Caf\u00E9");
		addCafe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto cafe = new Produto("cafe",2.99);
				ItensPedidos.produtos.add(cafe);
			}
		});
		addCafe.setBounds(21, 229, 89, 23);
		contentPane.add(addCafe);
		
		Nome = new JTextField();
		Nome.setDropMode(DropMode.INSERT);
		Nome.setBounds(109, 45, 326, 20);
		contentPane.add(Nome);
		Nome.setColumns(10);
		
		JButton btnNovaNota = new JButton("Nova Nota");
		btnNovaNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Cliente cliente = new Cliente();
				//System.out.println(Nome.getText());
				cliente.setNome(Nome.getText());
				cliente.setTelefone(Integer.parseInt(Telefone.getText()));
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
		
		notinha = new JTextArea();
		notinha.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		notinha.setBackground(Color.WHITE);
		notinha.setEditable(false);
		notinha.setBounds(21, 297, 270, 159);
		contentPane.add(notinha);
		notinha.setColumns(10);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente.pedido.getValorTotal();
				notinha.setText(cliente.getNome()+"\n"+"Valor a pagar:\n" + Double.toString(cliente.pedido.getValorTotal()));
				
			}
		});
		btnFinalizar.setBounds(21, 263, 89, 23);
		contentPane.add(btnFinalizar);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItensPedidos.produtos.clear();
				cliente.pedido.setValorTotal(0.0);
				NotaFiscal.setText(cliente.getNome() + System.lineSeparator()+ cliente.getTelefone());
				
			}
		});
		btnPagar.setBounds(21, 462, 89, 23);
		contentPane.add(btnPagar);
		
		NotaFiscal = new JTextField();
		NotaFiscal.setEditable(false);
		NotaFiscal.setHorizontalAlignment(SwingConstants.CENTER);
		NotaFiscal.setBounds(301, 130, 292, 355);
		contentPane.add(NotaFiscal);
		NotaFiscal.setColumns(10);
	}
}
