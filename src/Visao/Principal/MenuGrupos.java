package Visao.Principal;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import Controle.ControleFechar;
import Controle.ControleMenus;

public class MenuGrupos extends JFrame {

	// Criação dos JLabels

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JLabel titulo;
	public static JLabel titulo2;
	public static JLabel rodape;

	// Inserção de Imagem

	public JLabel PlanodeFundo;
	public JLabel agenda;
	public JLabel barra;
	public JLabel barra2;
	public JLabel barra3;
	public JLabel barra4;
	public JLabel brasao;
	public JLabel botao;
	public JLabel bt1;
	public JLabel bt2;
	public JLabel bt3;
	public JLabel bt4;

	// Criação dos Buttons

	public static JButton sair;
	public static JButton consultar;
	public static JButton cadastrar;
	public static JButton alterar;
	public static JButton deletar;

	// Criacao da fontes

	Font minhafont;

	public static JFrame Tela;

	public MenuGrupos() {

		Container e = getContentPane();
		setLayout(null);
		Tela = this;
		setSize(1200, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		ControleFechar controleFechar = new ControleFechar();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(controleFechar);

		// Inserção das Imagens

		minhafont = new Font("Eras Bold ITC", Font.BOLD, 27);

		// Plano de Fundo
		PlanodeFundo = new JLabel(new ImageIcon("Imagens/PlanodeFundo.jpg"));
		e.add(PlanodeFundo);
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

		PlanodeFundo.add(titulo = new JLabel("Menu de Opções Grupos"));
		titulo.setFont(minhafont);
		Dimension sizetitulo = titulo.getPreferredSize();
		titulo.setBounds(390, 50, sizetitulo.width, sizetitulo.height);

		// Titulo2
		PlanodeFundo.add(titulo2 = new JLabel(
				"Sistema de Gestão - Coordenadoria da Juventude"));
		titulo2.setFont(minhafont);
		Dimension sizetitulo2 = titulo2.getPreferredSize();
		titulo2.setBounds(240, 90, sizetitulo2.width, sizetitulo2.height);

		PlanodeFundo.add(rodape = new JLabel("Prefeitura de Maranguape"));
		rodape.setFont(minhafont);
		Dimension sizerodape = rodape.getPreferredSize();
		rodape.setBounds(390, 604, sizerodape.width, sizerodape.height);

		// Inserçao dos botões

		// Consultar

		PlanodeFundo.add(consultar = new JButton("Consultar"));
		bt1 = new JLabel(new ImageIcon("Imagens/btconsultar.png"));
		consultar.add(bt1);
		bt1.setBounds(1, 1, 700, 58);
		consultar.setBounds(260, 200, 700, 60);
		consultar.setLayout(null);

		// Cadastrar

		PlanodeFundo.add(cadastrar = new JButton("Cadastrar"));
		bt2 = new JLabel(new ImageIcon("Imagens/btcadastrar1.png"));
		cadastrar.add(bt2);
		bt2.setBounds(1, 1, 700, 58);
		cadastrar.setBounds(260, 280, 700, 60);
		cadastrar.setLayout(null);

		// Alterar

		PlanodeFundo.add(alterar = new JButton("Alterar"));
		bt3 = new JLabel(new ImageIcon("Imagens/btalterar.png"));
		alterar.add(bt3);
		bt3.setBounds(1, 1, 700, 58);
		alterar.setBounds(260, 360, 700, 60);
		alterar.setLayout(null);

		// Deletar

		PlanodeFundo.add(deletar = new JButton("Deletar"));
		bt4 = new JLabel(new ImageIcon("Imagens/btdeletar.png"));
		deletar.add(bt4);
		bt4.setBounds(1, 1, 700, 58);
		deletar.setBounds(260, 435, 700, 60);
		deletar.setLayout(null);

		// Botão sair

		PlanodeFundo.add(sair = new JButton("Sair"));
		botao = new JLabel(new ImageIcon("Imagens/sair.png"));
		sair.add(botao);
		botao.setBounds(1, 1, 228, 48);
		sair.setBounds(490, 530, 230, 50);
		sair.setLayout(null);

		ControleMenus controle = new ControleMenus();
		sair.addActionListener(controle);
		consultar.addActionListener(controle);
		cadastrar.addActionListener(controle);
		alterar.addActionListener(controle);
		deletar.addActionListener(controle);

	}

}
