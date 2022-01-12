package Visao.Cadastrar;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
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
import Controle.ControleFecharProjeto;

public class CadastrarProjeto extends JFrame {

	// Criação dos JLabels

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JLabel titulo;
	public static JLabel titulo2;
	public static JLabel rodape;
	public static JLabel projeto;
	public static JLabel orientador;
	public static JLabel email;
	public static JLabel telefone;
	public static JLabel publicoalvo;
	public static JLabel localidade;
	public static JLabel descricao;

	// Font
	Font minhafont;
	Font minhafont2;

	// Criação TextField

	public static JTextField projeto1;
	public static JTextField orientador1;
	public static JTextField email1;
	public static JFormattedTextField telefone1;
	public static JTextField publicoalvo1;
	public static JTextField localidade1;

	public static MaskFormatter maskCampoTelefone;

	// TextArea

	public static TextArea area;

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

	public CadastrarProjeto() {

		Container j = getContentPane();
		j.setLayout(null);
		Tela = this;
		setSize(1200, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		ControleFecharProjeto fechar = new ControleFecharProjeto();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(fechar);

		minhafont = new Font("Eras Bold ITC", Font.BOLD, 26);
		minhafont2 = new Font("arial", Font.PLAIN, 25);

		maskCampoTelefone = new MaskFormatter();

		// Imagens

		// Plano de Fundo
		PlanodeFundo = new JLabel(new ImageIcon("Imagens/PlanodeFundo.jpg"));
		j.add(PlanodeFundo);
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

		PlanodeFundo.add(titulo = new JLabel("Cadastrar Projetos"));
		titulo.setFont(minhafont);
		Dimension sizetitulo = titulo.getPreferredSize();
		titulo.setBounds(465, 50, sizetitulo.width, sizetitulo.height);

		// Titulo2
		PlanodeFundo.add(titulo2 = new JLabel("Sistema de Gestão - Coordenadoria de Juventude"));
		titulo2.setFont(minhafont);
		Dimension sizetitulo2 = titulo2.getPreferredSize();
		titulo2.setBounds(390, 90, sizetitulo2.width, sizetitulo2.height);

		// Rodape
		PlanodeFundo.add(rodape = new JLabel("Prefeitura de Maranguape"));
		rodape.setFont(minhafont);
		Dimension sizerodape = rodape.getPreferredSize();
		rodape.setBounds(410, 602, sizerodape.width, sizerodape.height);

		PlanodeFundo.add(projeto = new JLabel("Projeto :"));
		projeto.setFont(minhafont);
		Dimension sizeprojeto = projeto.getPreferredSize();
		projeto.setBounds(40, 190, sizeprojeto.width, sizeprojeto.height);

		PlanodeFundo.add(orientador = new JLabel("Orientador :"));
		orientador.setFont(minhafont);
		Dimension sizeorientador = orientador.getPreferredSize();
		orientador.setBounds(40, 230, sizeorientador.width,
				sizeorientador.height);

		PlanodeFundo.add(email = new JLabel("E-mail :"));
		email.setFont(minhafont);
		Dimension sizeemail = email.getPreferredSize();
		email.setBounds(40, 270, sizeemail.width, sizeemail.height);

		PlanodeFundo.add(telefone = new JLabel("Telefone :"));
		telefone.setFont(minhafont);
		Dimension sizetelefone = telefone.getPreferredSize();
		telefone.setBounds(630, 270, sizetelefone.width, sizetelefone.height);

		PlanodeFundo.add(publicoalvo = new JLabel("Público Alvo :"));
		publicoalvo.setFont(minhafont);
		Dimension sizepublicoalvo = publicoalvo.getPreferredSize();
		publicoalvo.setBounds(40, 310, sizepublicoalvo.width,
				sizepublicoalvo.height);

		PlanodeFundo.add(localidade = new JLabel("Localidade :"));
		localidade.setFont(minhafont);
		Dimension sizelocalidade = localidade.getPreferredSize();
		localidade.setBounds(630, 310, sizelocalidade.width,
				sizelocalidade.height);

		PlanodeFundo.add(descricao = new JLabel("Descrição :"));
		descricao.setFont(minhafont);
		Dimension sizedescricao = descricao.getPreferredSize();
		descricao.setBounds(40, 350, sizedescricao.width, sizedescricao.height);

		// TextField

		PlanodeFundo.add(projeto1 = new JTextField());
		projeto1.setFont(minhafont2);
		projeto1.setBounds(280, 195, 780, 30);

		PlanodeFundo.add(orientador1 = new JTextField());
		orientador1.setFont(minhafont2);
		orientador1.setBounds(280, 235, 780, 30);

		PlanodeFundo.add(email1 = new JTextField());
		email1.setFont(minhafont2);
		email1.setBounds(280, 275, 345, 30);

		PlanodeFundo.add(telefone1 = new JFormattedTextField());
		telefone1.setFont(minhafont2);
		telefone1.setBounds(820, 275, 240, 30);
		try {
			maskCampoTelefone.setMask("(##)####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		maskCampoTelefone.install(telefone1);

		PlanodeFundo.add(publicoalvo1 = new JTextField());
		publicoalvo1.setFont(minhafont2);
		publicoalvo1.setBounds(280, 315, 335, 30);

		PlanodeFundo.add(localidade1 = new JTextField());
		localidade1.setFont(minhafont2);
		localidade1.setBounds(840, 315, 220, 30);

		// Text Area

		PlanodeFundo.add(area = new TextArea());
		area.setFont(minhafont2);
		area.setBounds(280, 355, 779, 90);

		// Inserção de Botões

		// Botão Confirmar

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
