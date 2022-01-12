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
import Controle.ControleFecharServidorPublico;

public class DeletarServidorPublico extends JFrame {

	// Cria��o dos JLabels

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JLabel titulo;
	public static JLabel titulo2;
	public static JLabel rodape;
	public static JLabel lotacao;
	public static JLabel nome;

	// Font
	Font minhafont;
	Font minhafont2;
	Font minhafont3;

	// Cria��o TextField

	// Combo Box

	public static JComboBox<String> combo;
	public static JComboBox<String> combo1;

	// Buttons

	public static JButton deletar;
	public static JButton voltar;
	public static JButton ok;

	// Inser��o de Imagens

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

	public DeletarServidorPublico() {

		Container l = getContentPane();
		l.setLayout(null);
		Tela = this;
		setSize(1200, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		ControleFecharServidorPublico fechar = new ControleFecharServidorPublico();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(fechar);

		minhafont3 = new Font("Arial", Font.PLAIN, 20);
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

		PlanodeFundo.add(titulo = new JLabel("Deletar Servidor P�blico"));
		titulo.setFont(minhafont);
		Dimension sizetitulo = titulo.getPreferredSize();
		titulo.setBounds(410, 50, sizetitulo.width, sizetitulo.height);

		// Titulo2
		PlanodeFundo.add(titulo2 = new JLabel(
				"Sistema de Gest�o - Coordenadoria de Juventude"));
		titulo2.setFont(minhafont);
		Dimension sizetitulo2 = titulo2.getPreferredSize();
		titulo2.setBounds(240, 90, sizetitulo2.width, sizetitulo2.height);

		// Rodape
		PlanodeFundo.add(rodape = new JLabel("Prefeitura de Maranguape"));
		rodape.setFont(minhafont);
		Dimension sizerodape = rodape.getPreferredSize();
		rodape.setBounds(400, 600, sizerodape.width, sizerodape.height);

		// Lota��o

		PlanodeFundo.add(lotacao = new JLabel("*Institui��o :"));
		lotacao.setFont(minhafont);
		Dimension sizelotacao = lotacao.getPreferredSize();
		lotacao.setBounds(150, 200, sizelotacao.width, sizelotacao.height);

		// Nome

		PlanodeFundo.add(nome = new JLabel("*Nome :"));
		nome.setFont(minhafont);
		Dimension sizenome = nome.getPreferredSize();
		nome.setBounds(150, 290, sizenome.width, sizenome.height);

		// Combo Box

		PlanodeFundo.add(combo = new JComboBox<String>());
		combo.setFont(minhafont3);
		combo.setBounds(350, 200, 700, 38);
		combo.addItem("");
		combo.addItem("Associa��o dos Agentes Comunit�rios de Sa�de de Maranguape");
		combo.addItem("Comiss�o Interinstitucional SELO UNICEF - EDI��O 2013 - 2014");
		combo.addItem("Chefia de Gabinete");
		combo.addItem("Conselho M. dos direitos da crian�a e do adolescente (COMDICA)");
		combo.addItem("Conselho Tutelar de Maranguape");
		combo.addItem("Coordenadoria Conselhos Comunit�rios");
		combo.addItem("Coordenadoria de Comunica��o");
		combo.addItem("Coordenadoria de Juventude");
		combo.addItem("Coordenadoria Pol�ticas sobre Drogas");
		combo.addItem("Funda��o Viva Maranguape de Turismo, Esporte e Cultura - FITEC");
		combo.addItem("Hospital Municipal Dr. Argeu Gurgel Braga Herbster(HMABH)");
		combo.addItem("Instituto de Previd�ncia do Munic�pio de Maranguape - IPMM");
		combo.addItem("N�cleo de Gest�o Educacional - Coordenadores");
		combo.addItem("N�cleo de Gest�o Educacional - Coordenadores Escolas Anexas");
		combo.addItem("N�cleo de Gest�o Educacional - Coordenadores - Infantil e Creche");
		combo.addItem("N�cleo de Gest�o Educacional - Diretores");
		combo.addItem("N�cleo de Gest�o Educacional - Secret�rios");
		combo.addItem("Procuradoria Geral do Munic�pio(PGM)");
		combo.addItem("Secretaria de Administra��o e Fina�as(SAFIN)");
		combo.addItem("Secretaria de Educa��o");
		combo.addItem("Secretaria de Infraestrutura (SEINFRA)");
		combo.addItem("Secretaria de Meio Ambiente, D. Agr�rio e M. Ambiente (SEMADE)");
		combo.addItem("Secretaria de Sa�de");
		combo.addItem("Secretaria de Trabalho e Desenvolvimento Social (STDS)");
		PlanodeFundo.add(combo1 = new JComboBox<String>());
		combo1.setFont(minhafont3);
		combo1.setBounds(350, 290, 700, 38);

		// Inser��o de Bot�es

		// Bot�o OK

		PlanodeFundo.add(ok = new JButton("OK"));
		botao1 = new JLabel(new ImageIcon("Imagens/btok.png"));
		ok.add(botao1);
		botao1.setBounds(1, 1, 78, 38);
		ok.setBounds(1060, 200, 80, 40);
		ok.setLayout(null);

		// Bot�o Deletar

		PlanodeFundo.add(deletar = new JButton("Deletar"));
		botao2 = new JLabel(new ImageIcon("Imagens/botaodeletar.png"));
		deletar.add(botao2);
		botao2.setBounds(1, 1, 298, 48);
		deletar.setBounds(280, 500, 300, 50);
		deletar.setLayout(null);

		// Bot�o Voltar

		PlanodeFundo.add(voltar = new JButton("voltar"));
		botao3 = new JLabel(new ImageIcon("Imagens/btvoltar2.png"));
		voltar.add(botao3);
		botao3.setBounds(1, 1, 298, 48);
		voltar.setBounds(630, 500, 300, 50);
		voltar.setLayout(null);

		ControleDeletar d = new ControleDeletar();
		ok.addActionListener(d);
		deletar.addActionListener(d);
		voltar.addActionListener(d);

	}

}
