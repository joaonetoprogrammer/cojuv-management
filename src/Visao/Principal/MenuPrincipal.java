package Visao.Principal;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controle.ControlePrincipal;
import Modelo.Administrador;

public class MenuPrincipal extends JFrame {

	// Criação dos JLabels

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JLabel titulo;
	public static JLabel titulo2;
	public static JLabel rodape;
	public static JLabel c;
	public static JLabel c2;

	public static JLabel hora;;
	public static JLabel data;

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
	public JLabel bt5;
	public JLabel bt6;
	public JLabel bt7;
	public JLabel bt8;
	public JLabel bt9;
	public JLabel bt10;
	public JLabel bt11;



	// Criação dos Buttons

	public static JButton sair;
	public static JButton ServidorPublico;
	public static JButton ServidorTerceirizado;
	public static JButton Empresas;
	public static JButton Projetos;
	public static JButton MalaDireta;
	public static JButton Lembretes;
	public static JButton grupos;
	public static JButton contatosGeral;
	public static JButton ver;
	public static JButton calendar;
	// Criacao da fontes

	Font minhafont;
	Font minhafont2;
	Font minhafont3;

	public static JLabel rh;

	public static JFrame Tela;
	public static JTextField form;

	public MenuPrincipal() {

		Container d = getContentPane();
		setLayout(null);
		Tela = this;
		setVisible(true);
		setSize(1300, 720);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Inserção das Imagens

		minhafont = new Font("Eras Bold ITC", Font.BOLD, 26);
		minhafont2 = new Font("Eras Bold ITC", Font.BOLD, 36);
		minhafont3 = new Font("Eras Bold ITC", Font.BOLD, 22);

		// Plano de Fundo
		PlanodeFundo = new JLabel(new ImageIcon("Imagens/PlanodeFundo.jpg"));
		d.add(PlanodeFundo);
		PlanodeFundo.setBounds(0, 00, 1300, 800);
		PlanodeFundo.setLayout(null);

		// Agenda

		agenda = new JLabel(new ImageIcon("Imagens/AgendaCordenadoria.png"));
		PlanodeFundo.add(agenda);
		agenda.setBounds(1100, -5, 170, 150);

		/*
		 * PlanodeFundo.add(rh = new JLabel(new
		 * ImageIcon("Imagens/relogio.png"))); rh.setBounds(10, 15, 131, 140);
		 */

		// Barra1

		barra = new JLabel(new ImageIcon("Imagens/barra.png"));
		PlanodeFundo.add(barra);
		barra.setBounds(0, 5, 1300, 18);

		// Barra2

		barra2 = new JLabel(new ImageIcon("Imagens/barra.png"));
		PlanodeFundo.add(barra2);
		barra2.setBounds(0, 95, 1300, 18);

		// Brasao

		brasao = new JLabel(new ImageIcon("Imagens/brasaomaranguape.png"));
		PlanodeFundo.add(brasao);
		brasao.setBounds(1110, 550, 150, 140);

		// Barra3

		barra3 = new JLabel(new ImageIcon("Imagens/barra2.png"));
		PlanodeFundo.add(barra3);
		barra3.setBounds(0, 625, 1300, 15);

		// Barra4

		barra4 = new JLabel(new ImageIcon("Imagens/barra2.png"));
		PlanodeFundo.add(barra4);
		barra4.setBounds(0, 675, 1300, 15);

		// Insercao dos Jlabel

		// Ttitulo1

		PlanodeFundo.add(titulo = new JLabel("Sistema de Gestão - Menu Principal"));
		titulo.setFont(minhafont);
		Dimension sizetitulo = titulo.getPreferredSize();
		titulo.setBounds(400, 25, sizetitulo.width, sizetitulo.height);

		// Titulo2
		PlanodeFundo.add(titulo2 = new JLabel("Coordenadoria de Juventude"));
		titulo2.setFont(minhafont);
		Dimension sizetitulo2 = titulo2.getPreferredSize();
		titulo2.setBounds(440, 60, sizetitulo2.width, sizetitulo2.height);

		PlanodeFundo.add(rodape = new JLabel("Prefeitura de Maranguape"));
		rodape.setFont(minhafont);
		Dimension sizerodape = rodape.getPreferredSize();
		rodape.setBounds(440, 640, sizerodape.width, sizerodape.height);

		// Inserçao dos botões

		// Servidor publico

		bt1 = new JLabel(new ImageIcon("Imagens/btpublico.png"));
		PlanodeFundo.add(ServidorPublico = new JButton("Servidor Público"));
		ServidorPublico.add(bt1);
		bt1.setBounds(1, 1, 278, 58);
		ServidorPublico.setBounds(180, 130, 280, 60);
		ServidorPublico.setLayout(null);

		// Servidor Terceirizado

		PlanodeFundo.add(ServidorTerceirizado = new JButton(
				"Servidor Terceirizado"));
		bt2 = new JLabel(new ImageIcon("Imagens/btterceirizado.png"));
		ServidorTerceirizado.add(bt2);
		bt2.setBounds(1, 1, 278, 58);
		ServidorTerceirizado.setBounds(530, 130, 280, 60);
		ServidorTerceirizado.setLayout(null);

		// Empresas

		PlanodeFundo.add(Empresas = new JButton("Empresas"));
		bt3 = new JLabel(new ImageIcon("Imagens/btempresas.png"));
		Empresas.add(bt3);
		bt3.setBounds(1, 1, 630, 58);
		Empresas.setBounds(180, 200, 630, 60);
		Empresas.setLayout(null);

		// Projetos

		PlanodeFundo.add(Projetos = new JButton("Projetos"));
		bt4 = new JLabel(new ImageIcon("Imagens/btprojetos.png"));
		Projetos.add(bt4);
		bt4.setBounds(1, 1, 630, 58);
		Projetos.setBounds(180, 270, 630, 60);
		Projetos.setLayout(null);

		// Mala Direta

		PlanodeFundo.add(MalaDireta = new JButton("Mala Direta"));
		bt5 = new JLabel(new ImageIcon("Imagens/btmala.png"));
		MalaDireta.add(bt5);
		bt5.setBounds(1, 1, 630, 58);
		MalaDireta.setBounds(180, 340, 630, 60);
		MalaDireta.setLayout(null);

		// Lembretes

		PlanodeFundo.add(Lembretes = new JButton("Lembretes"));
		bt6 = new JLabel(new ImageIcon("Imagens/btlembretes.png"));
		Lembretes.add(bt6);
		bt6.setBounds(1, 1, 630, 58);
		Lembretes.setBounds(180, 410, 630, 60);
		Lembretes.setLayout(null);
		
		
		PlanodeFundo.add(grupos = new JButton("Lembretes"));
		bt8 = new JLabel(new ImageIcon("Imagens/grupos.png"));
		grupos.add(bt8);
		bt8.setBounds(1, 1, 630, 58);
		grupos.setBounds(180, 480, 630, 60);
		grupos.setLayout(null);
		
		PlanodeFundo.add(contatosGeral = new JButton("Lembretes"));
		bt10 = new JLabel(new ImageIcon("Imagens/btoutroscontatos.png"));
		bt11 = new JLabel(new ImageIcon("Imagens/iconeoutroscontatos.jpg"));
		contatosGeral.add(bt10);
		bt10.add(bt11);
		bt11.setBounds(20, 4, 55, 50);
		bt10.setLayout(null);
		bt10.setBounds(1, 1, 630, 58);
		contatosGeral.setBounds(180, 550, 630, 60);
		contatosGeral.setLayout(null);

		PlanodeFundo.add(sair = new JButton("Sair"));
		botao = new JLabel(new ImageIcon("Imagens/sair.png"));
		sair.add(botao);
		botao.setBounds(1, 1, 228, 48);
		sair.setBounds(930,490, 230, 50);
		sair.setLayout(null);
	
		PlanodeFundo.add(ver = new JButton("Servidor Público"));
	    bt9 = new JLabel(new ImageIcon("Imagens/visualizar lembretes.png"));
	    ver.add(bt9);
		bt9.setBounds(-5, 0, 230, 110);
		ver.setBounds(935, 355, 225, 110);
		ver.setLayout(null);
		ver.setBackground(Color.getHSBColor(0, 342, 180));



		PlanodeFundo.add(form = new JTextField(""));
		form.setBounds(1500, 100, 100, 50);

		// Calendário Anual
		PlanodeFundo.add(calendar = new JButton());
		calendar.setBounds(900, 155, 288, 178);
		calendar.setLayout(null);
		calendar.add(bt7 = new JLabel(new ImageIcon("Imagens/Calendário.png")));
		bt7.setBounds(-1, -1, 290, 180);
		bt7.setLayout(null);
		calendar.setToolTipText("Dê uma olhada no calendário anual");

		// Hora e Data
		bt7.add(hora = new JLabel());
		hora.setBounds(65, 110, 200, 35);
		hora.setBackground(Color.getHSBColor(0, 342, 180));
		hora.setFont(minhafont3);

		bt7.add(data = new JLabel());
		data.setBounds(65, 140, 200, 35);
		data.setBackground(Color.getHSBColor(0, 342, 180));
		data.setFont(minhafont3);

		// Adicionando Ação dos Botões
		ControlePrincipal controle = new ControlePrincipal();
		sair.addActionListener(controle);
		ServidorPublico.addActionListener(controle);
		ServidorTerceirizado.addActionListener(controle);
		Empresas.addActionListener(controle);
		Projetos.addActionListener(controle);
		MalaDireta.addActionListener(controle);
		Lembretes.addActionListener(controle);
		calendar.addActionListener(controle);
		grupos.addActionListener(controle);
		ver.addActionListener(controle);
		contatosGeral.addActionListener(controle);



		Administrador a = new Administrador();
		a.AtualizarData();
		a.AtualizarData3();

		
	}

	public static void main(String[] args) {
		new MenuPrincipal();
	}
}
