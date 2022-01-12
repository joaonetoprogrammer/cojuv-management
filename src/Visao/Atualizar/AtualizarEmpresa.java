package Visao.Atualizar;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Controle.ControleAtualizar;
import Controle.ControleFecharEmpresa;

public class AtualizarEmpresa extends JFrame {

	// Criação dos JLabels

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JLabel titulo;
	public static JLabel titulo2;
	public static JLabel rodape;
	public static JLabel codigo;
	public static JLabel nomefantasia;
	public static JLabel razaosocial;
	public static JLabel cnpj;
	public static JLabel telefoneempresa;
	public static JLabel emailempresa;
	public static JLabel ramo;

	public static JLabel nome;
	public static JLabel telefone;
	public static JLabel email;

	// Font
	Font minhafont;
	Font minhafont2;

	// Criação TextField

	public static JFormattedTextField codigo1;
	public static JTextField nomefantasia1;
	public static JTextField razaosocial1;
	public static JFormattedTextField cnpj1;
	public static JFormattedTextField telefoneempresa1;
	public static JTextField emailempresa1;
	public static JTextField ramo1;
	public static JTextField nome1;
	public static JTextField email1;
	public static JFormattedTextField telefone1;

	// Buttons

	public static JButton atualizar;
	public static JButton voltar;
	public static JButton ok;

	// Inserção de Imagens

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
	public AtualizarEmpresa() {

		Container h = getContentPane();
		h.setLayout(null);
		Tela = this;
		setSize(1200, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		ControleFecharEmpresa fechar = new ControleFecharEmpresa();
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

		PlanodeFundo.add(titulo = new JLabel("Atualização Empresa"));
		titulo.setFont(minhafont);
		Dimension sizetitulo = titulo.getPreferredSize();
		titulo.setBounds(430, 50, sizetitulo.width, sizetitulo.height);

		// Titulo2
		PlanodeFundo.add(titulo2 = new JLabel("Sistema de Gestão - Coordenadoria de Juventude"));
		titulo2.setFont(minhafont);
		Dimension sizetitulo2 = titulo2.getPreferredSize();
		titulo2.setBounds(240, 90, sizetitulo2.width, sizetitulo2.height);

		// Rodape
		PlanodeFundo.add(rodape = new JLabel("Prefeitura de Maranguape"));
		rodape.setFont(minhafont);
		Dimension sizerodape = rodape.getPreferredSize();
		rodape.setBounds(390, 600, sizerodape.width, sizerodape.height);

		PlanodeFundo.add(codigo = new JLabel("Código:"));
		codigo.setFont(minhafont);
		Dimension sizecodigo = codigo.getPreferredSize();
		codigo.setBounds(350, 180, sizecodigo.width, sizecodigo.height);

		PlanodeFundo.add(nomefantasia = new JLabel("Nome Fantasia:"));
		nomefantasia.setFont(minhafont);
		Dimension sizenomefantasia = nomefantasia.getPreferredSize();
		nomefantasia.setBounds(40, 240, sizenomefantasia.width,
				sizenomefantasia.height);

		PlanodeFundo.add(razaosocial = new JLabel("Razão Social:"));
		razaosocial.setFont(minhafont);
		Dimension sizerazaosocial = razaosocial.getPreferredSize();
		razaosocial.setBounds(40, 280, sizerazaosocial.width,
				sizerazaosocial.height);

		PlanodeFundo.add(cnpj = new JLabel("CNPJ:"));
		cnpj.setFont(minhafont);
		Dimension sizerazaocnpj = cnpj.getPreferredSize();
		cnpj.setBounds(40, 320, sizerazaocnpj.width, sizerazaocnpj.height);

		PlanodeFundo.add(telefoneempresa = new JLabel("Telefone:"));
		telefoneempresa.setFont(minhafont);
		Dimension sizetelefoneempresa = telefoneempresa.getPreferredSize();
		telefoneempresa.setBounds(40, 360, sizetelefoneempresa.width,
				sizetelefoneempresa.height);

		PlanodeFundo.add(emailempresa = new JLabel("E-mail da Empresa:"));
		emailempresa.setFont(minhafont);
		Dimension sizeemailempresa = emailempresa.getPreferredSize();
		emailempresa.setBounds(500, 360, sizeemailempresa.width,
				sizeemailempresa.height);

		PlanodeFundo.add(nome = new JLabel("Nome do Responsável:"));
		nome.setFont(minhafont);
		Dimension sizenome = nome.getPreferredSize();
		nome.setBounds(40, 400, sizenome.width, sizenome.height);

		PlanodeFundo.add(telefone = new JLabel("Telefone:"));
		telefone.setFont(minhafont);
		Dimension sizetelefone = telefone.getPreferredSize();
		telefone.setBounds(40, 440, sizetelefone.width, sizetelefone.height);

		PlanodeFundo.add(email = new JLabel("E-mail:"));
		email.setFont(minhafont);
		Dimension sizeemail = email.getPreferredSize();
		email.setBounds(500, 440, sizeemail.width, sizeemail.height);

		PlanodeFundo.add(ramo = new JLabel("Ramo Empresarial:"));
		ramo.setFont(minhafont);
		Dimension sizeRamo = ramo.getPreferredSize();
		ramo.setBounds(40, 480, sizeRamo.width, sizeRamo.height);

		// TextField

		PlanodeFundo.add(codigo1 = new JFormattedTextField());
		codigo1.setFont(minhafont2);
		codigo1.setBounds(510, 180, 150, 40);

		PlanodeFundo.add(nomefantasia1 = new JTextField());
		nomefantasia1.setFont(minhafont2);
		nomefantasia1.setBounds(320, 245, 787, 30);
		nomefantasia1.disable();

		PlanodeFundo.add(razaosocial1 = new JTextField());
		razaosocial1.setFont(minhafont2);
		razaosocial1.setBounds(320, 280, 787, 30);
		razaosocial1.disable();

		PlanodeFundo.add(cnpj1 = new JFormattedTextField());
		cnpj1.setFont(minhafont2);
		cnpj1.setBounds(320, 320, 787, 30);

		cnpj1.disable();

		PlanodeFundo.add(telefoneempresa1 = new JFormattedTextField());
		telefoneempresa1.setFont(minhafont2);

		telefoneempresa1.disable();

		PlanodeFundo.add(emailempresa1 = new JTextField());
		emailempresa1.setFont(minhafont2);
		emailempresa1.setBounds(830, 361, 280, 30);
		emailempresa1.disable();

		PlanodeFundo.add(nome1 = new JTextField());
		nome1.setFont(minhafont2);
		nome1.setBounds(430, 400, 678, 30);
		nome1.disable();

		PlanodeFundo.add(telefone1 = new JFormattedTextField());
		telefone1.setFont(minhafont2);
		telefone1.setBounds(220, 441, 270, 30);
		telefone1.disable();

		PlanodeFundo.add(email1 = new JTextField());
		email1.setFont(minhafont2);
		email1.setBounds(650, 440, 456, 30);
		email1.disable();

		PlanodeFundo.add(ramo1 = new JTextField());
		ramo1.setFont(minhafont2);
		ramo1.setBounds(330, 481, 777, 30);
		ramo1.disable();
		// Inserção de Botões

		// Botão OK

		PlanodeFundo.add(ok = new JButton("OK"));
		botao1 = new JLabel(new ImageIcon("Imagens/btok.png"));
		ok.add(botao1);
		botao1.setBounds(1, 1, 78, 38);
		ok.setBounds(700, 180, 80, 40);
		ok.setLayout(null);

		// Botão Atualizar

		PlanodeFundo.add(atualizar = new JButton("Atualizar"));
		botao2 = new JLabel(new ImageIcon("Imagens/btatualizar.png"));
		atualizar.add(botao2);
		botao2.setBounds(1, 1, 298, 48);
		atualizar.setBounds(270, 530, 300, 50);
		atualizar.setLayout(null);
		atualizar.disable();
		// Botão Voltar

		PlanodeFundo.add(voltar = new JButton("voltar"));
		botao3 = new JLabel(new ImageIcon("Imagens/btvoltar2.png"));
		voltar.add(botao3);
		botao3.setBounds(1, 1, 298, 48);
		voltar.setBounds(620, 530, 300, 50);
		voltar.setLayout(null);
		ControleAtualizar c = new ControleAtualizar();
		ok.addActionListener(c);
		atualizar.addActionListener(c);
		voltar.addActionListener(c);
	}

}
