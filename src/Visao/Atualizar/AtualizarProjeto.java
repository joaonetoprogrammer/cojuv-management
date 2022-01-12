package Visao.Atualizar;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Controle.ControleAtualizar;
import Controle.ControleFecharProjeto;

public class AtualizarProjeto extends JFrame {

	// Criação dos JLabels

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JLabel titulo;
	public static JLabel titulo2;
	public static JLabel rodape;
	public static JLabel codigo;
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

	public static JTextField codigo1;

	public static JTextField projeto1;
	public static JTextField orientador1;
	public static JTextField email1;
	public static JFormattedTextField telefone1;
	public static JTextField publicoalvo1;
	public static JTextField localidade1;

	
	// TextArea

	public static TextArea area;

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
	public AtualizarProjeto() {

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

		PlanodeFundo.add(titulo = new JLabel("Atualização Projetos"));
		titulo.setFont(minhafont);
		Dimension sizetitulo = titulo.getPreferredSize();
		titulo.setBounds(450, 50, sizetitulo.width, sizetitulo.height);

		// Titulo2
		PlanodeFundo.add(titulo2 = new JLabel("Sistema de Gestão - Coordenadoria de Juventude"));
		titulo2.setFont(minhafont);
		Dimension sizetitulo2 = titulo2.getPreferredSize();
		titulo2.setBounds(240, 90, sizetitulo2.width, sizetitulo2.height);

		// Rodape
		PlanodeFundo.add(rodape = new JLabel("Prefeitura de Maranguape"));
		rodape.setFont(minhafont);
		Dimension sizerodape = rodape.getPreferredSize();
		rodape.setBounds(400, 600, sizerodape.width, sizerodape.height);

		PlanodeFundo.add(codigo = new JLabel("Código :"));
		codigo.setFont(minhafont);
		Dimension sizecodigo = codigo.getPreferredSize();
		codigo.setBounds(350, 180, sizecodigo.width, sizecodigo.height);

		PlanodeFundo.add(projeto = new JLabel("Projeto :"));
		projeto.setFont(minhafont);
		Dimension sizeprojeto = projeto.getPreferredSize();
		projeto.setBounds(40, 240, sizeprojeto.width, sizeprojeto.height);

		PlanodeFundo.add(orientador = new JLabel("Orientador :"));
		orientador.setFont(minhafont);
		Dimension sizeorientador = orientador.getPreferredSize();
		orientador.setBounds(40, 280, sizeorientador.width,
				sizeorientador.height);

		PlanodeFundo.add(email = new JLabel("E-mail :"));
		email.setFont(minhafont);
		Dimension sizeemail = email.getPreferredSize();
		email.setBounds(40, 320, sizeemail.width, sizeemail.height);

		PlanodeFundo.add(telefone = new JLabel("Telefone :"));
		telefone.setFont(minhafont);
		Dimension sizetelefone = telefone.getPreferredSize();
		telefone.setBounds(630, 320, sizetelefone.width, sizetelefone.height);

		PlanodeFundo.add(publicoalvo = new JLabel("Público Alvo :"));
		publicoalvo.setFont(minhafont);
		Dimension sizepublicoalvo = publicoalvo.getPreferredSize();
		publicoalvo.setBounds(40, 370, sizepublicoalvo.width,
				sizepublicoalvo.height);

		PlanodeFundo.add(localidade = new JLabel("Localidade :"));
		localidade.setFont(minhafont);
		Dimension sizelocalidade = localidade.getPreferredSize();
		localidade.setBounds(630, 370, sizelocalidade.width,
				sizelocalidade.height);

		PlanodeFundo.add(descricao = new JLabel("Descrição :"));
		descricao.setFont(minhafont);
		Dimension sizedescricao = descricao.getPreferredSize();
		descricao.setBounds(40, 410, sizedescricao.width, sizedescricao.height);

		// TextField

		PlanodeFundo.add(codigo1 = new JTextField());
		codigo1.setFont(minhafont2);
		codigo1.setBounds(510, 180, 150, 40);
	

		PlanodeFundo.add(projeto1 = new JTextField());
		projeto1.setFont(minhafont2);
		projeto1.setBounds(280, 240, 780, 30);
		projeto1.disable();

		PlanodeFundo.add(orientador1 = new JTextField());
		orientador1.setFont(minhafont2);
		orientador1.setBounds(280, 280, 780, 30);
		orientador1.disable();

		PlanodeFundo.add(email1 = new JTextField());
		email1.setFont(minhafont2);
		email1.setBounds(280, 320, 345, 30);
		email1.disable();

		PlanodeFundo.add(telefone1 = new JFormattedTextField());
		telefone1.setFont(minhafont2);
		telefone1.setBounds(820, 320, 240, 30);
		telefone1.disable();

		PlanodeFundo.add(publicoalvo1 = new JTextField());
		publicoalvo1.setFont(minhafont2);
		publicoalvo1.setBounds(280, 370, 335, 30);
		publicoalvo1.disable();

		PlanodeFundo.add(localidade1 = new JTextField());
		localidade1.setFont(minhafont2);
		localidade1.setBounds(840, 370, 220, 30);
		localidade1.disable();
		// Text Area

		PlanodeFundo.add(area = new TextArea());
		area.setFont(minhafont2);
		area.setBounds(280, 410, 779, 90);
		area.disable();
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
