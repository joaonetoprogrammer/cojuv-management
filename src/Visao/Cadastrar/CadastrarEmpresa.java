
package Visao.Cadastrar;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.text.MaskFormatter;

import Controle.ControleCadastrar;
import Controle.ControleFecharEmpresa;

public class CadastrarEmpresa extends JFrame {

	// Criação dos JLabels

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JLabel titulo;
	public static JLabel titulo2;
	public static JLabel rodape;
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

	public static JTextField nomefantasia1;
	public static JTextField razaosocial1;
	public static JFormattedTextField cnpj1;
	public static JFormattedTextField telefoneempresa1;
	public static JTextField emailempresa1;
	public static JTextField ramo1;
	public static JTextField nome1;
	public static JTextField email1;
	public static JFormattedTextField telefone1;

	public static MaskFormatter maskCampoTelefoneEmpresa;
	public static MaskFormatter maskCampoTelefone;
	public static MaskFormatter maskCampoCNPJ;

	// Buttons

	public static JButton cadastrar;
	public static JButton voltar;

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

	public CadastrarEmpresa(){

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
		
		maskCampoTelefoneEmpresa = new MaskFormatter();
		maskCampoTelefone = new MaskFormatter();
		maskCampoCNPJ = new MaskFormatter();

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

		PlanodeFundo.add(titulo = new JLabel("Cadastrar Empresa"));
		titulo.setFont(minhafont);
		Dimension sizetitulo = titulo.getPreferredSize();
		titulo.setBounds(440, 50, sizetitulo.width, sizetitulo.height);

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

		PlanodeFundo.add(nomefantasia = new JLabel("Nome Fantasia:"));
		nomefantasia.setFont(minhafont);
		Dimension sizenomefantasia = nomefantasia.getPreferredSize();
		nomefantasia.setBounds(40, 190, sizenomefantasia.width,
				sizenomefantasia.height);

		PlanodeFundo.add(razaosocial = new JLabel("Razão Social:"));
		razaosocial.setFont(minhafont);
		Dimension sizerazaosocial = razaosocial.getPreferredSize();
		razaosocial.setBounds(40, 230, sizerazaosocial.width,
				sizerazaosocial.height);

		PlanodeFundo.add(cnpj = new JLabel("CNPJ:"));
		cnpj.setFont(minhafont);
		Dimension sizerazaocnpj = cnpj.getPreferredSize();
		cnpj.setBounds(40, 270, sizerazaocnpj.width, sizerazaocnpj.height);

		PlanodeFundo.add(telefoneempresa = new JLabel("Telefone:"));
		telefoneempresa.setFont(minhafont);
		Dimension sizetelefoneempresa = telefoneempresa.getPreferredSize();
		telefoneempresa.setBounds(40, 310, sizetelefoneempresa.width,
				sizetelefoneempresa.height);

		PlanodeFundo.add(emailempresa = new JLabel("E-mail da Empresa:"));
		emailempresa.setFont(minhafont);
		Dimension sizeemailempresa = emailempresa.getPreferredSize();
		emailempresa.setBounds(500, 310, sizeemailempresa.width,
				sizeemailempresa.height);

		PlanodeFundo.add(nome = new JLabel("Nome do Responsável:"));
		nome.setFont(minhafont);
		Dimension sizenome = nome.getPreferredSize();
		nome.setBounds(40, 350, sizenome.width, sizenome.height);

		PlanodeFundo.add(telefone = new JLabel("Telefone:"));
		telefone.setFont(minhafont);
		Dimension sizetelefone = telefone.getPreferredSize();
		telefone.setBounds(40, 395, sizetelefone.width, sizetelefone.height);

		PlanodeFundo.add(email = new JLabel("E-mail:"));
		email.setFont(minhafont);
		Dimension sizeemail = email.getPreferredSize();
		email.setBounds(500, 395, sizeemail.width, sizeemail.height);

		PlanodeFundo.add(ramo = new JLabel("Ramo Empresarial:"));
		ramo.setFont(minhafont);
		Dimension sizeRamo = ramo.getPreferredSize();
		ramo.setBounds(40, 445, sizeRamo.width, sizeRamo.height);

		// TextField

		PlanodeFundo.add(nomefantasia1 = new JTextField());
		nomefantasia1.setFont(minhafont2);
		nomefantasia1.setBounds(320, 195, 787, 30);

		PlanodeFundo.add(razaosocial1 = new JTextField());
		razaosocial1.setFont(minhafont2);
		razaosocial1.setBounds(320, 235, 787, 30);

		PlanodeFundo.add(cnpj1 = new JFormattedTextField());
		cnpj1.setFont(minhafont2);
		cnpj1.setBounds(320, 275, 787, 30);
		try {
			maskCampoCNPJ.setMask("##.###.###/####-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		maskCampoCNPJ.install(cnpj1);

		PlanodeFundo.add(telefoneempresa1 = new JFormattedTextField());
		telefoneempresa1.setFont(minhafont2);
		telefoneempresa1.setBounds(220, 315, 270, 30);
		try {
			maskCampoTelefoneEmpresa.setMask("(##)####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		maskCampoTelefoneEmpresa.install(telefoneempresa1);

		PlanodeFundo.add(emailempresa1 = new JTextField());
		emailempresa1.setFont(minhafont2);
		emailempresa1.setBounds(830, 315, 280, 30);

		PlanodeFundo.add(nome1 = new JTextField());
		nome1.setFont(minhafont2);
		nome1.setBounds(430, 355, 678, 30);

		
		PlanodeFundo.add(telefone1 = new JFormattedTextField());
		telefone1.setFont(minhafont2);
		telefone1.setBounds(220, 400, 270, 30);
		try{
			maskCampoTelefone.setMask("(##)####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		maskCampoTelefone.install(telefone1);

		PlanodeFundo.add(email1 = new JTextField());
		email1.setFont(minhafont2);
		email1.setBounds(650, 400, 456, 30);

		PlanodeFundo.add(ramo1 = new JTextField());
		ramo1.setFont(minhafont2);
		ramo1.setBounds(380, 449, 456, 30);

		// Inserção de Botões

		// Botão Atualizar

		PlanodeFundo.add(cadastrar = new JButton("Atualizar"));
		botao2 = new JLabel(new ImageIcon("Imagens/btcadastrar.png"));
		cadastrar.add(botao2);
		botao2.setBounds(1, 1, 298, 48);
		cadastrar.setBounds(280, 500, 300, 50);
		cadastrar.setLayout(null);

		// Botão Voltar

		PlanodeFundo.add(voltar = new JButton("voltar"));
		botao3 = new JLabel(new ImageIcon("Imagens/btvoltar2.png"));
		voltar.add(botao3);
		botao3.setBounds(1, 1, 298, 48);
		voltar.setBounds(630, 500, 300, 50);
		voltar.setLayout(null);

		ControleCadastrar c = new ControleCadastrar();
		cadastrar.addActionListener(c);
		voltar.addActionListener(c);
	}



}
