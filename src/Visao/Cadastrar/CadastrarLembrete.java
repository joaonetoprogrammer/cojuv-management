package Visao.Cadastrar;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.text.MaskFormatter;

import Controle.ControleCadastrar;
import Controle.ControleFechar;

public class CadastrarLembrete extends JFrame {

	// Criação dos JLabels

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JLabel titulo;
	public static JLabel titulo2;
	public static JLabel rodape;
	public static JLabel titulolembrete;
	public static JLabel descricao;
	public static JLabel data;
	public static JLabel hora;
	public static JLabel conf;

	// TextArea

	public static TextArea area;

	// Font
	Font minhafont;
	Font minhafont2;

	// Criação TextField

	public static JTextField titulolembrete1;
	public static JComboBox<String> dia;
	public static JComboBox<String> ano2;

	public static JFormattedTextField data1;
	public static JFormattedTextField hora1;

	public static MaskFormatter maskCampoData;
	public static MaskFormatter maskCampoHora;

	// Buttons

	public static JButton sair;
	public static JButton salvar;

	// Inserção de Imagens

	public JLabel PlanodeFundo;
	public JLabel agenda;
	public JLabel barra;
	public JLabel barra2;
	public JLabel barra3;
	public JLabel barra4;
	public JLabel brasao;
	public JLabel botao;
	public JLabel botao2;

	public static JLabel hora2;
	public static JLabel ano;
	public static JLabel mes;
	public static JComboBox<String> ano1;
	public static JComboBox<String> mes1;

	public static JFrame Tela;

	public CadastrarLembrete() {

		Container f = getContentPane();
		f.setLayout(null);
		Tela = this;
		setSize(1200, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		ControleFechar controleFechar = new ControleFechar();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(controleFechar);

		minhafont = new Font("Eras Bold ITC", Font.BOLD, 26);
		minhafont2 = new Font("arial", Font.PLAIN, 25);

		maskCampoData = new MaskFormatter();
		maskCampoHora = new MaskFormatter();

		// Imagens

		// Plano de Fundo
		PlanodeFundo = new JLabel(new ImageIcon("Imagens/PlanodeFundo.jpg"));
		f.add(PlanodeFundo);
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

		PlanodeFundo.add(titulo = new JLabel("Lembretes"));
		titulo.setFont(minhafont);
		Dimension sizetitulo = titulo.getPreferredSize();
		titulo.setBounds(510, 50, sizetitulo.width, sizetitulo.height);

		// Titulo2
		PlanodeFundo.add(titulo2 = new JLabel(
				"Sistema de Gestão - Coordenadoria de Juventude"));
		titulo2.setFont(minhafont);
		Dimension sizetitulo2 = titulo2.getPreferredSize();
		titulo2.setBounds(240, 90, sizetitulo2.width, sizetitulo2.height);

		PlanodeFundo.add(rodape = new JLabel("Prefeitura de Maranguape"));
		rodape.setFont(minhafont);
		Dimension sizerodape = rodape.getPreferredSize();
		rodape.setBounds(400, 600, sizerodape.width, sizerodape.height);

		PlanodeFundo.add(titulolembrete = new JLabel("Titulo:"));
		titulolembrete.setFont(minhafont);
		Dimension sizetitulolembrete = titulolembrete.getPreferredSize();
		titulolembrete.setBounds(50, 180, sizetitulolembrete.width,
				sizetitulolembrete.height);

		PlanodeFundo.add(ano = new JLabel("Ano:"));
		ano.setFont(minhafont);
		Dimension sizetituloano = ano.getPreferredSize();
		ano.setBounds(350, 290, sizetituloano.width, sizetituloano.height);

		PlanodeFundo.add(ano2 = new JComboBox<String>());
		ano2.setFont(minhafont2);
		ano2.setBounds(440, 290, 100, 35);
		ano2.addItem("");
		ano2.addItem("2014");
		ano2.addItem("2015");

		PlanodeFundo.add(descricao = new JLabel("Descrição:"));
		descricao.setFont(minhafont);
		Dimension sizedescricao = descricao.getPreferredSize();
		descricao.setBounds(50, 340, sizedescricao.width, sizedescricao.height);

		PlanodeFundo.add(mes = new JLabel("Mês:"));
		mes.setFont(minhafont);
		Dimension sizemes = mes.getPreferredSize();
		mes.setBounds(50, 235, sizemes.width, sizemes.height);

		PlanodeFundo.add(conf = new JLabel("Confirme a data do lembrete:"));
		conf.setFont(minhafont);
		Dimension sizec = conf.getPreferredSize();
		conf.setBounds(50, 480, sizec.width, sizec.height);

		PlanodeFundo.add(mes1 = new JComboBox<String>());
		mes1.setFont(minhafont2);
		mes1.setBounds(240, 235, 300, 35);
		mes1.addItem("");
		mes1.addItem("Janeiro");
		mes1.addItem("Fevereiro");
		mes1.addItem("Março");
		mes1.addItem("Abril");
		mes1.addItem("Maio");
		mes1.addItem("Junho");
		mes1.addItem("Julho");
		mes1.addItem("Agosto");
		mes1.addItem("Setembro");
		mes1.addItem("Outubro");
		mes1.addItem("Novembro");
		mes1.addItem("Dezembro");

		PlanodeFundo.add(data = new JLabel("Dia:"));
		data.setFont(minhafont);
		Dimension sizedata = data.getPreferredSize();
		data.setBounds(50, 290, sizedata.width, sizedata.height);

		PlanodeFundo.add(hora = new JLabel("Hora:"));
		hora.setFont(minhafont);
		Dimension sizehora = hora.getPreferredSize();
		hora.setBounds(580, 290, sizehora.width, sizehora.height);

		// Insercao TextFields

		PlanodeFundo.add(titulolembrete1 = new JTextField());
		titulolembrete1.setFont(minhafont2);
		titulolembrete1.setBounds(240, 180, 400, 35);

		PlanodeFundo.add(area = new TextArea());
		area.setFont(minhafont2);
		area.setBounds(240, 345, 700, 120);

		PlanodeFundo.add(dia = new JComboBox<String>());
		dia.setBounds(240, 290, 60, 35);
		dia.setFont(minhafont2);
		dia.addItem("");
		dia.addItem("1");
		dia.addItem("2");
		dia.addItem("3");
		dia.addItem("4");
		dia.addItem("5");
		dia.addItem("6");
		dia.addItem("7");
		dia.addItem("8");
		dia.addItem("9");
		dia.addItem("10");
		dia.addItem("11");
		dia.addItem("12");
		dia.addItem("12");
		dia.addItem("13");
		dia.addItem("14");
		dia.addItem("15");
		dia.addItem("16");
		dia.addItem("17");
		dia.addItem("18");
		dia.addItem("19");
		dia.addItem("20");
		dia.addItem("21");
		dia.addItem("22");
		dia.addItem("23");
		dia.addItem("24");
		dia.addItem("25");
		dia.addItem("26");
		dia.addItem("27");
		dia.addItem("28");
		dia.addItem("29");
		dia.addItem("30");
		dia.addItem("31");

		PlanodeFundo.add(hora1 = new JFormattedTextField());
		hora1.setFont(minhafont2);
		hora1.setBounds(690, 290, 250, 35);
		try {
			maskCampoHora.setMask("           ##:##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		maskCampoHora.install(hora1);

		PlanodeFundo.add(data1 = new JFormattedTextField());
		data1.setFont(minhafont2);
		data1.setBounds(480, 480, 250, 35);
		try {
			maskCampoData.setMask("           ##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		maskCampoData.install(data1);

		// Inserção Buttons

		// Botão Salvar

		PlanodeFundo.add(salvar = new JButton("Salvar"));
		salvar.setBounds(350, 530, 230, 50);
		salvar.setLayout(null);
		botao2 = new JLabel(new ImageIcon("Imagens/btsalvar.png"));
		salvar.add(botao2);
		botao2.setBounds(1, 1, 228, 48);

		// Botão sair

		PlanodeFundo.add(sair = new JButton("Sair"));
		botao = new JLabel(new ImageIcon("Imagens/sair.png"));
		sair.add(botao);
		botao.setBounds(1, 1, 228, 48);
		sair.setBounds(650, 530, 230, 50);
		sair.setLayout(null);

		ControleCadastrar c = new ControleCadastrar();
		salvar.addActionListener(c);
		sair.addActionListener(c);
	}

}
