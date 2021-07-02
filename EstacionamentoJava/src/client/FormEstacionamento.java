package client;

//import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//import java.awt.Component;
//import javax.swing.Box;
//import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
//import javax.swing.JSeparator;
//import javax.swing.JSplitPane;
//import java.awt.ScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import controller.ProcessaEstacionamentos;
import domain.Estacionamento;
//import javax.swing.JTable;

public class FormEstacionamento extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;
	private JTextField caixaVaga;
	private JTextField caixaPlaca01;
	private JTextField caixaPlaca02;
	private JTextField caixaData03;
	private JTextField caixaData01;
	private JTextField caixaPreco;
	private JTextField caixaSaida;
	private JTextField caixaPlaca03;
	private JTextField caixaData02;
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public String listarTodos() {
		String acum = " ";
		for (Estacionamento i : ProcessaEstacionamentos.estacionamentos) {
			acum += i.toString();
		}
		return acum;
		/*
		 * for (int i = 0; i < ProcessaEstacionamentos.estacionamentos.size(); i++) {
		 * acum += ProcessaEstacionamentos.estacionamentos.get(i).toString(); } return
		 * acum;
		 */
	}
	/*
	public static String listarPorData(String data) {
		Estacionamento a = new Estacionamento();		//String dataFormatada = sdf.format(data);
    	String acum = "";
		for (Estacionamento e:ProcessaEstacionamentos.estacionamentos) {
			if () {
				
			}
        }
        return acum;
    }*/

	public String listarEstacionados() {
		Estacionamento b = new Estacionamento();
		String acum = "";
		for (Estacionamento e : ProcessaEstacionamentos.estacionamentos){
			if ((b.getHoraSaida()) == "Estacionado" ) {
				acum += e;
			}
		}
		return acum;
	}

	public void adicionar() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
			Date data = new Date();
			String dataFormatada = sdf.format(data);
			String vazio = "Estacionado";
			Estacionamento e = new Estacionamento(caixaVaga.getText(), caixaPlaca01.getText(), new Date(),
					dataFormatada, vazio, Double.parseDouble(caixaPreco.getText()));
			System.out.println("teste");
			if (ProcessaEstacionamentos.estacionamentos.contains(e)) {
				JOptionPane.showMessageDialog(this, "O carro da placa " + e.getPlaca() + " Já esta Estacionado");
			} else { // if (e.getVaga() == caixaVaga.getText()) {
				ProcessaEstacionamentos.estacionamentos.add(e);
				System.out.println("Entrou no else");
				textArea.setText(listarTodos());
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "ERRROR");
			System.out.println("Erro " + e);
		}
	}

	public Date formata(String date) {	// formantando pra data
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void alterar() {
		Estacionamento eAlterar = new Estacionamento(caixaPlaca02.getText(), formata(caixaData01.getText())); 
																											
		if (ProcessaEstacionamentos.estacionamentos.contains(eAlterar)) {
			ProcessaEstacionamentos.estacionamentos.get(ProcessaEstacionamentos.estacionamentos.indexOf(eAlterar))
					.setHoraSaida(caixaSaida.getText());
			textArea.setText(listarTodos());										
		} else {
			JOptionPane.showMessageDialog(this, "Carro não encontrado");
		}
	}

	public void excluir() {
		Estacionamento eRemove = new Estacionamento(caixaPlaca03.getText(), formata(caixaData02.getText()));
		if (ProcessaEstacionamentos.estacionamentos.contains(eRemove)) {
			ProcessaEstacionamentos.estacionamentos.remove(ProcessaEstacionamentos.estacionamentos.indexOf(eRemove));
			JOptionPane.showMessageDialog(this, "Carro removido com sucesso !");
			textArea.setText(listarTodos());
		} else {
			JOptionPane.showMessageDialog(this, "Carro removido com sucesso !");
		}

	}

	public static void main(String[] args) throws ParseException {
		ProcessaEstacionamentos.abrir();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormEstacionamento frame = new FormEstacionamento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormEstacionamento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 661);
		contentPane = new JPanel();
		ImageIcon icon = new ImageIcon("placa.png");
		setIconImage(icon.getImage());
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBounds(10, 63, 569, 221);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBorder(new LineBorder(Color.BLACK));
		panel.setBounds(54, 0, 467, 221);
		panel_1.add(panel);
		panel.setLayout(null);

		textArea = new JTextArea(listarTodos());
		textArea.setBounds(0, 0, 467, 221);
		panel.add(textArea);

		JLabel lblNewLabel = new JLabel("Placa :");
		lblNewLabel.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 314, 52, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Vaga :");
		lblNewLabel_1.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 340, 52, 15);
		contentPane.add(lblNewLabel_1);

		JButton Adicionar = new JButton("Adicinar");
		Adicionar.setFont(new Font("SansSerif", Font.BOLD, 11));
		Adicionar.setBackground(new Color(0, 206, 209));
		Adicionar.setForeground(new Color(0, 0, 0));
		Adicionar.setBounds(169, 365, 89, 23);
		contentPane.add(Adicionar);
		

		caixaVaga = new JTextField();
		caixaVaga.setBounds(69, 339, 189, 15);
		contentPane.add(caixaVaga);
		caixaVaga.setColumns(10);

		caixaPlaca01 = new JTextField();
		caixaPlaca01.setBounds(69, 313, 189, 15);
		contentPane.add(caixaPlaca01);
		caixaPlaca01.setColumns(10);

		caixaPlaca02 = new JTextField();
		caixaPlaca02.setBounds(69, 427, 189, 15);
		contentPane.add(caixaPlaca02);
		caixaPlaca02.setColumns(10);

		caixaData03 = new JTextField();
		caixaData03.setBounds(69, 26, 94, 14);
		contentPane.add(caixaData03);
		caixaData03.setColumns(10);

		caixaData01 = new JTextField();
		caixaData01.setBounds(69, 453, 189, 15);
		contentPane.add(caixaData01);
		caixaData01.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Placa :");
		lblNewLabel_2.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 428, 52, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Data :");
		lblNewLabel_3.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 26, 52, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Saida :");
		lblNewLabel_4.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 480, 52, 14);
		contentPane.add(lblNewLabel_4);

		JButton Alterar = new JButton("Alterar");
		Alterar.setFont(new Font("SansSerif", Font.BOLD, 11));
		Alterar.setBackground(new Color(0, 206, 209));
		Alterar.setForeground(new Color(0, 0, 0));
		Alterar.setBounds(117, 512, 89, 23);
		contentPane.add(Alterar);

		JLabel lblNewLabel_5 = new JLabel("Listagem");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(422, 298, 46, 14);
		contentPane.add(lblNewLabel_5);

		JButton botTodos = new JButton("Todos");
		botTodos.setFont(new Font("SansSerif", Font.BOLD, 11));
		botTodos.setBackground(new Color(0, 206, 209));
		botTodos.setForeground(new Color(0, 0, 0));
		botTodos.setBounds(392, 365, 107, 23);
		contentPane.add(botTodos);

		JButton botData = new JButton("Data");
		botData.setFont(new Font("SansSerif", Font.BOLD, 11));
		botData.setForeground(new Color(0, 0, 0));
		botData.setBackground(new Color(0, 206, 209));
		botData.setBounds(392, 340, 107, 23);
		contentPane.add(botData);

		JButton botEstacionados = new JButton("Estacionado");
		botEstacionados.setFont(new Font("SansSerif", Font.BOLD, 11));
		botEstacionados.setForeground(new Color(0, 0, 0));
		botEstacionados.setBackground(new Color(0, 206, 209));
		botEstacionados.setBounds(392, 314, 107, 23);
		contentPane.add(botEstacionados);

		caixaPreco = new JTextField();
		caixaPreco.setBounds(69, 366, 73, 20);
		contentPane.add(caixaPreco);
		caixaPreco.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Pre\u00E7o  :");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblNewLabel_6.setBounds(10, 369, 56, 14);
		contentPane.add(lblNewLabel_6);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(10, 51, 569, 244);
		contentPane.add(panel_2);

		JButton botSalvar = new JButton("");
		botSalvar.setIcon(new ImageIcon(
				"C:\\Users\\micha\\Desktop\\RepositorioGit\\Estacionamento\\EstacionamentoJava\\salve-.png"));
		botSalvar.setBounds(518, 472, 46, 41);
		contentPane.add(botSalvar);

		JButton botSair = new JButton("Sair");
		botSair.setFont(new Font("SansSerif", Font.BOLD, 11));
		botSair.setBackground(new Color(0, 206, 209));
		botSair.setForeground(new Color(0, 0, 0));
		botSair.setBounds(494, 524, 89, 23);
		contentPane.add(botSair);

		caixaSaida = new JTextField();
		caixaSaida.setColumns(10);
		caixaSaida.setBounds(69, 479, 189, 15);
		contentPane.add(caixaSaida);

		JLabel lblNewLabel_2_1 = new JLabel("Data :");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("DialogInput", Font.PLAIN, 11));
		lblNewLabel_2_1.setBounds(10, 454, 52, 14);
		contentPane.add(lblNewLabel_2_1);

		caixaPlaca03 = new JTextField();
		caixaPlaca03.setColumns(10);
		caixaPlaca03.setBounds(310, 425, 189, 15);
		contentPane.add(caixaPlaca03);

		caixaData02 = new JTextField();
		caixaData02.setColumns(10);
		caixaData02.setBounds(310, 451, 189, 15);
		contentPane.add(caixaData02);

		JButton Remover = new JButton("Remover");
		Remover.setForeground(new Color(0, 0, 0));
		Remover.setFont(new Font("SansSerif", Font.BOLD, 11));
		Remover.setBackground(new Color(0, 206, 209));
		Remover.setBounds(310, 476, 89, 23);
		contentPane.add(Remover);

		JLabel lblNewLabel_7 = new JLabel("Estacionamento\r\n");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_7.setBounds(385, -15, 218, 67);
		contentPane.add(lblNewLabel_7);

		botSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == botSalvar) {
					ProcessaEstacionamentos.salvar();
				}
				
			}
		});
		
		Adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == Adicionar) {
					adicionar();
				}
				
			}
		});
		
		Alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == Alterar) {
					alterar();
				}
				
			}
		});
		
		Remover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == Remover) {
					excluir();
				}
				
			}
		});
		
		botData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == botData) {
					//textArea.setText(listarPorData(caixaData03.getText()));
				}
				
			}
		});
		
		botSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == botSair) {
					dispose();
				}
				
			}
		});
		
		botTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == botTodos) {
					textArea.setText(listarTodos());
					
				}
				
			}
		});
		
		botEstacionados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == botEstacionados) {
					textArea.setText(listarEstacionados());
					
				}
				
			}
		});
	}
}
