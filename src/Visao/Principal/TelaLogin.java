package Visao.Principal;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controle.ControleLogin;

public class TelaLogin extends JFrame {

	// Criação dos JLabels

	private static final long serialVersionUID = 1L;
	public static JLabel titulo;
	public static JLabel titulo2;
	public static JLabel login;
	public static JLabel senha;
	public static JLabel rodape;

	// Criação dos TextFields

	public static JTextField login1;
	public static JPasswordField senha1;

	// Criação dos Buttons

	public static JButton entrar;
	public static JButton sair;
	public static JButton alterar;

	// Inserção das Imagens

	public static JLabel PlanodeFundo;
	public static JLabel barra;
	public static JLabel barra2;
	public static JLabel barra3;
	public static JLabel barra4;
	public static JLabel logo;
	public static JLabel imagem;
	public static JLabel botao;
	public static JLabel agenda;
	public static JLabel brasao;
	public static JLabel botaoalterar;

	// Fonte titulo
	Font minhafont;

	// Fonte Corpo

	Font minhafont2;
	Font minhafont3;

	public static JFrame Tela;

	// Metodo Construtor

	public TelaLogin() {
		Container c = getContentPane();
		setLayout(null);
		Tela = this;
		setSize(1200, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
		minhafont = new Font("Eras Bold ITC", Font.BOLD, 30);
		minhafont2 = new Font("Eras Bold ITC", Font.BOLD, 40);
		minhafont3 = new Font("arial", Font.PLAIN, 25);

		// Adicioando Imagem

		// PlanodeFundo
		PlanodeFundo = new JLabel(new ImageIcon("Imagens/PlanodeFundo.jpg"));
		c.add(PlanodeFundo);
		PlanodeFundo.setBounds(0, 0, 1200, 700);
		PlanodeFundo.setLayout(null);

		// Agenda

		agenda = new JLabel(new ImageIcon("Imagens/AgendaCordenadoria.png"));
		PlanodeFundo.add(agenda);
		agenda.setBounds(1000, 2, 170, 160);

		// Brasao

		brasao = new JLabel(new ImageIcon("Imagens/brasaomaranguape.png"));
		PlanodeFundo.add(brasao);
		brasao.setBounds(1010, 530, 150, 140);

		// Barra1

		barra = new JLabel(new ImageIcon("Imagens/primeirabarra.jpg"));
		PlanodeFundo.add(barra);
		barra.setBounds(0, 20, 1200, 25);

		// Barra2

		barra2 = new JLabel(new ImageIcon("Imagens/primeirabarra.jpg"));
		PlanodeFundo.add(barra2);
		barra2.setBounds(0, 130, 1200, 25);

		// Barra3

		barra3 = new JLabel(new ImageIcon("Imagens/barrabaixo.jpg"));
		PlanodeFundo.add(barra3);
		barra3.setBounds(0, 590, 1200, 15);

		// Barra4

		barra4 = new JLabel(new ImageIcon("Imagens/barrabaixo.jpg"));
		PlanodeFundo.add(barra4);
		barra4.setBounds(0, 640, 1200, 15);

		// Imagem

		imagem = new JLabel(new ImageIcon("Imagens/login2.png"));
		PlanodeFundo.add(imagem);
		imagem.setBounds(760, 200, 500, 300);

		// Adicionando Labels

		PlanodeFundo.add(titulo = new JLabel("Sistema de Gestão"));
		titulo.setFont(minhafont);
		Dimension sizetitulo = titulo.getPreferredSize();
		titulo.setBounds(420, 50, sizetitulo.width, sizetitulo.height);

		PlanodeFundo.add(titulo2 = new JLabel("Coordenadoria de Juventude"));
		titulo2.setFont(minhafont);
		Dimension sizetitulo2 = titulo2.getPreferredSize();
		titulo2.setBounds(350, 90, sizetitulo2.width, sizetitulo2.height);

		PlanodeFundo.add(login = new JLabel("Login :"));
		login.setFont(minhafont2);
		Dimension sizelogin = login.getPreferredSize();
		login.setBounds(250, 250, sizelogin.width, sizelogin.height);

		PlanodeFundo.add(senha = new JLabel("Senha :"));
		senha.setFont(minhafont2);
		Dimension sizesenha = senha.getPreferredSize();
		senha.setBounds(249, 350, sizesenha.width, sizesenha.height);

		PlanodeFundo.add(rodape = new JLabel("Prefeitura de Maranguape "));
		rodape.setFont(minhafont);
		Dimension sizerodape = rodape.getPreferredSize();
		rodape.setBounds(370, 600, sizerodape.width, sizerodape.height);

		// Adiciaondando textfiled

		PlanodeFundo.add(login1 = new JTextField());
		login1.setBounds(457, 254, 350, 40);
		login1.setFont(minhafont3);

		PlanodeFundo.add(senha1 = new JPasswordField());
		senha1.setBounds(457, 358, 350, 40);
		senha1.setFont(minhafont3);

		// Adicionando Botão

		// Botão Entrar

		PlanodeFundo.add(entrar = new JButton("Entrar"));
		botao = new JLabel(new ImageIcon("Imagens/bt1.png"));
		entrar.add(botao);
		botao.setBounds(1, 1, 228, 48);
		entrar.setBounds(249, 450, 230, 50);
		entrar.setLayout(null);

		// Botão Sair
		PlanodeFundo.add(sair = new JButton("Sair"));
		botao = new JLabel(new ImageIcon("Imagens/sair.png"));
		sair.add(botao);
		botao.setBounds(1, 1, 228, 48);
		sair.setBounds(590, 450, 230, 50);
		sair.setLayout(null);

		// Botão alterar
		PlanodeFundo.add(alterar = new JButton("Alertrar"));
		botaoalterar = new JLabel(new ImageIcon("Imagens/botao.png"));
		alterar.add(botaoalterar);
		botaoalterar.setBounds(1, 1, 570, 50);
		alterar.setBounds(249, 520, 572, 52);
		alterar.setLayout(null);

		// Adicionando Acão dos Botões
		ControleLogin controle = new ControleLogin();
		entrar.addActionListener(controle);
		sair.addActionListener(controle);
		alterar.addActionListener(controle);

	}
	
	public static void main (String[]args)
	{
		new TelaLogin();
	}

}
