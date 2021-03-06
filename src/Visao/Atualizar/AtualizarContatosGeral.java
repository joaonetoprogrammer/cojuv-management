package Visao.Atualizar;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Controle.ControleAtualizar;
import Controle.ControleFechaContatosGeral;

public class AtualizarContatosGeral extends JFrame {

	// Cria??o dos JLabels

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JLabel titulo;
	public static JLabel titulo2;
	public static JLabel rodape;
	public static JLabel codigo;
	public static JLabel nome;
	public static JLabel email;
	public static JLabel telefone;
	public static JLabel lotacao;
	public static JLabel matricula;
	public static JLabel funcao;
	public static JLabel facebook;

	// Font
	Font minhafont;
	Font minhafont2;

	// Cria??o TextField

	public static JFormattedTextField codigo1;
	public static JTextField nome1;
	public static JTextField email1;
	public static JFormattedTextField telefone1;
	public static JTextField matricula1;
	public static JTextField funcao1;
	public static JTextField facebook1;

	// Combo Box

	public static JComboBox<String> combo;

	// Buttons

	public static JButton atualizar;
	public static JButton voltar;
	public static JButton ok;

	// Inser??o de Imagens

	public JLabel PlanodeFundo;
	public JLabel agenda;
	public JLabel barra;
	public JLabel barra2;
	public JLabel barra3;
	public JLabel barra4;
	public JLabel brasao;
	public JLabel botao1;
	public JLabel botao2;
	public JLabel botao3;

	public static JFrame Tela;

	@SuppressWarnings("deprecation")
	public AtualizarContatosGeral() {

		Container h = getContentPane();
		h.setLayout(null);
		Tela = this;
		setSize(1200, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		ControleFechaContatosGeral fechar = new ControleFechaContatosGeral();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(fechar);

		minhafont = new Font("Eras Bold ITC", Font.BOLD, 26);
		minhafont2 = new Font("arial", Font.PLAIN, 25);

		// Imagens

		// Plano de Fundo
		PlanodeFundo = new JLabel(new ImageIcon("Imagens/PlanodeFundo.jpg"));
		h.add(PlanodeFundo);
		PlanodeFundo.setBounds(0, 00, 1200, 700);
		PlanodeFundo.setLayout(null);

		// Agenda

		agenda = new JLabel(new ImageIcon("Imagens/AgendaCordenadoria.png"));
		PlanodeFundo.add(agenda);
		agenda.setBounds(1000, 2, 170, 160);

		// Barra1

		barra = new JLabel(new ImageIcon("Imagens/barra.png"));
		PlanodeFundo.add(barra);
		barra.setBounds(0, 20, 1200, 25);

		// Barra2

		barra2 = new JLabel(new ImageIcon("Imagens/barra.png"));
		PlanodeFundo.add(barra2);
		barra2.setBounds(0, 130, 1200, 25);

		// Brasao

		brasao = new JLabel(new ImageIcon("Imagens/brasaomaranguape.png"));
		PlanodeFundo.add(brasao);
		brasao.setBounds(1010, 530, 150, 140);

		// Barra3

		barra3 = new JLabel(new ImageIcon("Imagens/barra2.png"));
		PlanodeFundo.add(barra3);
		barra3.setBounds(0, 590, 1200, 15);

		// Barra4

		barra4 = new JLabel(new ImageIcon("Imagens/barra2.png"));
		PlanodeFundo.add(barra4);
		barra4.setBounds(0, 640, 1200, 15);

		// Insercao dos Jlabel

		// Ttitulo1

		PlanodeFundo.add(titulo = new JLabel("Atualiza??o Outros Contatos"));
		titulo.setFont(minhafont);
		Dimension sizetitulo = titulo.getPreferredSize();
		titulo.setBounds(380, 50, sizetitulo.width, sizetitulo.height);

		// Titulo2
		PlanodeFundo.add(titulo2 = new JLabel(
				"Sistema de Gest?o - Coordenadoria de Juventude"));
		titulo2.setFont(minhafont);
		Dimension sizetitulo2 = titulo2.getPreferredSize();
		titulo2.setBounds(240, 90, sizetitulo2.width, sizetitulo2.height);

		// Rodape
		PlanodeFundo.add(rodape = new JLabel("Prefeitura de Maranguape"));
		rodape.setFont(minhafont);
		Dimension sizerodape = rodape.getPreferredSize();
		rodape.setBounds(400, 600, sizerodape.width, sizerodape.height);

		PlanodeFundo.add(codigo = new JLabel("C?digo:"));
		codigo.setFont(minhafont);
		Dimension sizecodigo = codigo.getPreferredSize();
		codigo.setBounds(360, 180, sizecodigo.width, sizecodigo.height);

		PlanodeFundo.add(nome = new JLabel("*Nome:"));
		nome.setFont(minhafont);
		Dimension sizenome = nome.getPreferredSize();
		nome.setBounds(50, 240, sizenome.width, sizenome.height);

		PlanodeFundo.add(email = new JLabel("*E-mail:"));
		email.setFont(minhafont);
		Dimension sizeemail = email.getPreferredSize();
		email.setBounds(50, 280, sizeemail.width, sizeemail.height);

		PlanodeFundo.add(telefone = new JLabel("*Telefone:"));
		telefone.setFont(minhafont);
		Dimension sizetelefone = telefone.getPreferredSize();
		telefone.setBounds(50, 320, sizetelefone.width, sizetelefone.height);

		PlanodeFundo.add(lotacao = new JLabel("*Categoria:"));
		lotacao.setFont(minhafont);
		Dimension sizelotacao = lotacao.getPreferredSize();
		lotacao.setBounds(50, 360, sizelotacao.width, sizelotacao.height);

		PlanodeFundo.add(funcao = new JLabel("*Fun??o:"));
		funcao.setFont(minhafont);
		Dimension sizefuncao = funcao.getPreferredSize();
		funcao.setBounds(50, 400, sizefuncao.width, sizefuncao.height);

		PlanodeFundo.add(facebook = new JLabel("*Facebook:"));
		facebook.setFont(minhafont);
		Dimension sizefacebook = facebook.getPreferredSize();
		facebook.setBounds(50, 440, sizefacebook.width, sizefacebook.height);

		// TextFields

		PlanodeFundo.add(codigo1 = new JFormattedTextField());
		codigo1.setFont(minhafont2);
		codigo1.setBounds(520, 180, 150, 40);

		PlanodeFundo.add(nome1 = new JTextField());
		nome1.setFont(minhafont2);
		nome1.setBounds(260, 240, 842, 35);
		nome1.disable();

		PlanodeFundo.add(email1 = new JTextField());
		email1.setFont(minhafont2);
		email1.setBounds(260, 280, 350, 35);
		email1.disable();

		PlanodeFundo.add(telefone1 = new JFormattedTextField());
		telefone1.setFont(minhafont2);
		telefone1.setBounds(260, 320, 350, 35);
		telefone1.disable();

		PlanodeFundo.add(funcao1 = new JTextField());
		funcao1.setFont(minhafont2);
		funcao1.setBounds(260, 400, 350, 35);
		funcao1.disable();

		PlanodeFundo.add(facebook1 = new JTextField());
		facebook1.setFont(minhafont2);
		facebook1.setBounds(260, 440, 450, 35);
		facebook1.disable();
		// Combo

		PlanodeFundo.add(combo = new JComboBox<String>());
		combo.setFont(minhafont2);
		combo.setBounds(260, 360, 840, 35);
		combo.disable();
		combo.addItem("");
		combo.addItem("Gr?mio Estudantil Anchieta");
		combo.addItem("Gr?mio Estudantil Ant?nio Luiz Coelho");
		combo.addItem("Gr?mio Estudantil Ant?nio Marques");
		combo.addItem("Gr?mio Estudantil CAIC Senador Carlos Jereissati");
		combo.addItem("Gr?mio Estudantil Clovis Monteiro");
		combo.addItem("Gr?mio Estudantil Conego Heitor");
		combo.addItem("Gr?mio Estudantil E.M Francsica Rocha Magalh?es");
		combo.addItem("Gr?mio Estudantil E.E.M. Luiz Gir?o");
		combo.addItem("Gr?mio Estudantil EEEP Santa Rita");
		combo.addItem("Gr?mio Estudantil Eunice Weaver");
		combo.addItem("Gr?mio Estudantil Jo?o Cirino");
		combo.addItem("Gr?mio Estudantil Jos? Fernades Vieira");
		combo.addItem("Gr?mio Estudantil Manoel Rodrigues");
		combo.addItem("Gr?mio Estudantil Nilo Campelo");
		combo.addItem("Gr?mio Estudantil Rio Grande do Norte");
		combo.addItem("Gr?mio Estudantil Ant?nio Marques");
		combo.addItem("SoftWay");

		// Inser??o de Bot?es

		// Bot?o OK

		PlanodeFundo.add(ok = new JButton("OK"));
		botao1 = new JLabel(new ImageIcon("Imagens/btok.png"));
		ok.add(botao1);
		botao1.setBounds(1, 1, 78, 38);
		ok.setBounds(710, 180, 80, 40);
		ok.setLayout(null);

		// Bot?o Atualizar

		PlanodeFundo.add(atualizar = new JButton("Atualizar"));
		botao2 = new JLabel(new ImageIcon("Imagens/btatualizar.png"));
		atualizar.add(botao2);
		botao2.setBounds(1, 1, 298, 48);
		atualizar.setBounds(280, 500, 300, 50);
		atualizar.setLayout(null);
		// atualizar.disable();
		// Bot?o Voltar

		PlanodeFundo.add(voltar = new JButton("voltar"));
		botao3 = new JLabel(new ImageIcon("Imagens/btvoltar2.png"));
		voltar.add(botao3);
		botao3.setBounds(1, 1, 298, 48);
		voltar.setBounds(630, 500, 300, 50);
		voltar.setLayout(null);

		ControleAtualizar c = new ControleAtualizar();
		atualizar.addActionListener(c);
		ok.addActionListener(c);
		voltar.addActionListener(c);

	}

}
