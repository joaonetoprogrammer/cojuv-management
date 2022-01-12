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

public class TelaDeAlteracao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JLabel imagem;
	public static JLabel titulo;
	public static JLabel titulo2;
	public static JLabel rodape;
	public static JLabel label;

	// Font
	Font minhafont;
	Font minhafont2;
	Font minhafont3;

	// Inserção de Imagens

	public JLabel PlanodeFundo;
	public JLabel barra;
	public JLabel barra2;
	public JLabel barra3;
	public JLabel barra4;

	public static JLabel loginAtual;
	public static JLabel senhaAtual;
	public static JLabel novoLogin;
	public static JLabel novaSenha;
	public static JLabel cSenha;
	public static JLabel ti;
	public static JLabel botao2;

	public static JTextField tLoginAtual;
	public static JPasswordField tSenhaAtual;
	public static JTextField tNovoLogin;
	public static JPasswordField tNovaSenha;
	public static JPasswordField tcSenha;

	public static JButton ok;
	public static JButton alterar;

	public static JFrame Tela;
	Font f4;

	@SuppressWarnings("deprecation")
	public TelaDeAlteracao() {

		Container f = getContentPane();
		setLayout(null);
		Tela = this;
		setSize(650, 560);
		setResizable(false);
		setLocationRelativeTo(null);

		minhafont = new Font("Eras Bold ITC", Font.BOLD, 26);
		minhafont2 = new Font("arial", Font.PLAIN, 25);
		minhafont3 = new Font("Eras Bold ITC", Font.BOLD | Font.ITALIC, 25);
		f4 = new Font("Eras Bold ITC", Font.BOLD, 16);

		// Imagens

		// Plano de Fundo
		PlanodeFundo = new JLabel(new ImageIcon("Imagens/PlanodeFundo.jpg"));
		f.add(PlanodeFundo);
		PlanodeFundo.setBounds(0, 00, 1200, 700);
		PlanodeFundo.setLayout(null);

		// Barra1

		barra = new JLabel(new ImageIcon("Imagens/barra.png"));
		PlanodeFundo.add(barra);
		barra.setBounds(0, 10, 1200, 15);

		// Barra2

		barra2 = new JLabel(new ImageIcon("Imagens/barra.png"));
		PlanodeFundo.add(barra2);
		barra2.setBounds(0, 90, 1200, 15);

		// Barra3

		barra3 = new JLabel(new ImageIcon("Imagens/barra2.png"));
		PlanodeFundo.add(barra3);
		barra3.setBounds(0, 460, 1200, 15);

		// Barra4

		barra4 = new JLabel(new ImageIcon("Imagens/barra2.png"));
		PlanodeFundo.add(barra4);
		barra4.setBounds(0, 510, 1200, 15);

		// Insercao dos Jlabel

		// Ttitulo1

		PlanodeFundo
				.add(titulo = new JLabel("Atualização de Login e Senha!!!"));
		titulo.setFont(minhafont2);
		Dimension sizetitulo = titulo.getPreferredSize();
		titulo.setBounds(150, 30, sizetitulo.width, sizetitulo.height);

		// Titulo2
		PlanodeFundo.add(titulo2 = new JLabel("Coordenadoria de Juventude"));
		titulo2.setFont(minhafont2);
		Dimension sizetitulo2 = titulo2.getPreferredSize();
		titulo2.setBounds(160, 60, sizetitulo2.width, sizetitulo2.height);

		// Rodape
		PlanodeFundo.add(rodape = new JLabel("Prefeitura de Maranguape"));
		rodape.setFont(minhafont2);
		Dimension sizerodape = rodape.getPreferredSize();
		rodape.setBounds(180, 480, sizerodape.width, sizerodape.height);

		PlanodeFundo
				.add(ti = new JLabel("Faça suas Alterações de Segurança!!!"));
		ti.setBounds(120, 100, 460, 40);
		ti.setFont(minhafont2);

		PlanodeFundo.add(loginAtual = new JLabel("Digite seu login atual: "));
		loginAtual.setBounds(20, 160, 260, 40);
		loginAtual.setFont(minhafont2);

		PlanodeFundo.add(senhaAtual = new JLabel("Digite sua senha atual: "));
		senhaAtual.setBounds(20, 200, 300, 40);
		senhaAtual.setFont(minhafont2);

		PlanodeFundo.add(novoLogin = new JLabel("Digite seu novo Login: "));
		novoLogin.setBounds(20, 260, 260, 40);
		novoLogin.setFont(minhafont2);

		PlanodeFundo.add(novaSenha = new JLabel("Digite sua nova senha: "));
		novaSenha.setBounds(20, 300, 300, 40);
		novaSenha.setFont(minhafont2);

		PlanodeFundo.add(cSenha = new JLabel("Confirmar senha: "));
		cSenha.setBounds(20, 340, 300, 40);
		cSenha.setFont(minhafont2);

		PlanodeFundo.add(tSenhaAtual = new JPasswordField());
		tSenhaAtual.setBounds(300, 205, 250, 30);
		tSenhaAtual.setFont(minhafont2);

		PlanodeFundo.add(tLoginAtual = new JTextField());
		tLoginAtual.setBounds(300, 165, 250, 30);
		tLoginAtual.setFont(minhafont2);

		PlanodeFundo.add(tNovaSenha = new JPasswordField());
		tNovaSenha.setBounds(300, 305, 250, 30);
		tNovaSenha.setFont(minhafont2);
		tNovaSenha.disable();

		PlanodeFundo.add(tNovoLogin = new JTextField());
		tNovoLogin.setBounds(300, 265, 250, 30);
		tNovoLogin.setFont(minhafont2);
		tNovoLogin.disable();

		PlanodeFundo.add(tcSenha = new JPasswordField());
		tcSenha.setBounds(300, 345, 250, 30);
		tcSenha.setFont(minhafont2);
		tcSenha.disable();

		PlanodeFundo.add(alterar = new JButton());
		alterar.setBounds(260, 405, 122, 32);
		imagem = new JLabel(new ImageIcon("Imagens/porCodigoE.png"));
		alterar.setLayout(null);
		alterar.add(imagem);
		imagem.setBounds(1, 1, 120, 30);
		imagem.add(label = new JLabel("Confirmar"));
		imagem.setLayout(null);
		label.setBounds(15, 4, 100, 20);
		label.setFont(f4);

		PlanodeFundo.add(ok = new JButton("Ok"));
		ok.setBounds(570, 180, 52, 32);
		imagem = new JLabel(new ImageIcon("Imagens/ok.png"));
		ok.setLayout(null);
		ok.add(imagem);
		imagem.setBounds(1, 1, 50, 30);

		ControleLogin l = new ControleLogin();
		ok.addActionListener(l);
		alterar.addActionListener(l);
	}

}
