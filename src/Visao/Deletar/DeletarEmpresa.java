package Visao.Deletar;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import Controle.ControleDeletar;
import Controle.ControleFecharEmpresa;
import Modelo.Empresa;

public class DeletarEmpresa extends JFrame {

	// Criação dos JLabels

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JLabel titulo ;
	public static JLabel titulo2;
	public static JLabel rodape;
	public static JLabel nome;
	
	

	// Font
	Font minhafont;
	Font minhafont2;
	// Criação TextField



	// Combo Box

	public static JComboBox<String> nome1;


	// Buttons

	public static JButton deletar ;
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

	public DeletarEmpresa() {

		Container l = getContentPane();
		l.setLayout(null);
		Tela = this;
		setSize(1200, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		ControleFecharEmpresa fechar = new ControleFecharEmpresa();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(fechar);
	
		minhafont2 = new Font("Arial", Font.PLAIN, 25);
		minhafont = new Font("Eras Bold ITC", Font.BOLD, 26);
		// Imagens

		// Plano de Fundo
		PlanodeFundo = new JLabel(new ImageIcon("Imagens/PlanodeFundo.jpg"));
		l.add(PlanodeFundo);
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

		PlanodeFundo.add(titulo= new JLabel("Deletar Empresa"));
		titulo.setFont(minhafont);
		Dimension sizetitulo = titulo.getPreferredSize();
		titulo.setBounds(440, 50, sizetitulo.width, sizetitulo.height);

		// Titulo2
		PlanodeFundo.add(titulo2  = new JLabel("Sistema de Gestão - Coordenadoria de Juventude"));
		titulo2.setFont(minhafont);
		Dimension sizetitulo2 = titulo2.getPreferredSize();
		titulo2.setBounds(240, 90, sizetitulo2.width, sizetitulo2.height);

		// Rodape
		PlanodeFundo.add(rodape  = new JLabel("Prefeitura de Maranguape"));
		rodape.setFont(minhafont);
		Dimension sizerodape = rodape.getPreferredSize();
		rodape.setBounds(360, 600, sizerodape.width, sizerodape.height);

		// Nome

		PlanodeFundo.add(nome  = new JLabel("*Nome Fantasia: "));
		nome.setFont(minhafont);
		Dimension sizenome = nome.getPreferredSize();
		nome.setBounds(80, 220, sizenome.width, sizenome.height);
	

		// Text Field

		PlanodeFundo.add(nome1  = new JComboBox<String>());
		nome1.setFont(minhafont2);
		nome1.setBounds(340, 220, 750, 38);




		// Botão Deletar

		PlanodeFundo.add(deletar = new JButton("Deletar"));
		botao2 = new JLabel(new ImageIcon("Imagens/botaodeletar.png"));
		deletar.add(botao2);
		botao2.setBounds(1, 1, 298, 48);
		deletar.setBounds(280, 500, 300, 50);
		deletar.setLayout(null);

		// Botão Voltar

		PlanodeFundo.add(voltar  = new JButton("voltar"));
		botao3 = new JLabel(new ImageIcon("Imagens/btvoltar2.png"));
		voltar.add(botao3);
		botao3.setBounds(1, 1, 298, 48);
		voltar.setBounds(630, 500, 300, 50);
		voltar.setLayout(null);
		Empresa emp = new Empresa();
		emp.MetodoDaTela();
		ControleDeletar d = new ControleDeletar();
		deletar.addActionListener(d);
		voltar.addActionListener(d);
	}

}
