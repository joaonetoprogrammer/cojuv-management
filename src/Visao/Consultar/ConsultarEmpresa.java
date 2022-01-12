package Visao.Consultar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Controle.ControleConsultar;
import Controle.ControleFecharEmpresa;
import Modelo.Empresa;

public class ConsultarEmpresa extends JFrame {

	// Painel

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JPanel PainelTabela;

	// Tabela
	public static JTable Tabela;

	// Scroll
	public static JScrollPane Scroll;

	// Criação dos JLabels

	public static JLabel titulo;
	public static JLabel titulo2;
	public static JLabel rodape;

	// Labels de Imagens de Butoes
	public static JLabel texto;
	public static JLabel texto2;
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
	public JLabel botao3;

	// Buttons
	public static JButton voltar;

	// Criacao da fontes

	Font minhafont;
	Font f2;
	Font f3;
	Font f4;

	public static JFrame Tela;
	public static JLabel imagem;

	// butoes
	public static JButton ordemAlfabetica;
	public static JButton porcodigo;
	public static JButton ok;

	// TextFields
	public static JTextField campo;

	// JLabels
	public static JLabel label;

	public ConsultarEmpresa() {

		Container d = getContentPane();
		setLayout(null);
		Tela = this;
		setSize(1200, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		ControleFecharEmpresa fechar = new ControleFecharEmpresa();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(fechar);
		imagem = new JLabel();

		minhafont = new Font("Eras Bold ITC", Font.BOLD, 26);
		f4 = new Font("Eras Bold ITC", Font.BOLD, 12);
		f3 = new Font("Arial", Font.PLAIN, 18);
		f2 = new Font("Eras Bold ITC", Font.BOLD, 20);

		// Inserção das Imagens

		// Plano de Fundo
		PlanodeFundo = new JLabel(new ImageIcon("Imagens/PlanodeFundo.jpg"));
		d.add(PlanodeFundo);
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

		PlanodeFundo.add(titulo = new JLabel("Consultar Empresas"));
		titulo.setFont(minhafont);
		Dimension sizetitulo = titulo.getPreferredSize();
		titulo.setBounds(430, 50, sizetitulo.width, sizetitulo.height);

		// Titulo2
		PlanodeFundo.add(titulo2 = new JLabel("Sistema de Gestão - Coordenadoria de Juventude"));
		titulo2.setFont(minhafont);
		Dimension sizetitulo2 = titulo2.getPreferredSize();
		titulo2.setBounds(240, 90, sizetitulo2.width, sizetitulo2.height);

		PlanodeFundo.add(rodape = new JLabel("Prefeitura de Maranguape"));
		rodape.setFont(minhafont);
		Dimension sizerodape = rodape.getPreferredSize();
		rodape.setBounds(390, 600, sizerodape.width, sizerodape.height);

		// Botão Voltar

		PlanodeFundo.add(voltar = new JButton("voltar"));
		botao3 = new JLabel(new ImageIcon("Imagens/btvoltar2.png"));
		voltar.add(botao3);
		botao3.setBounds(1, 1, 298, 48);
		voltar.setBounds(430, 530, 300, 50);
		voltar.setLayout(null);

		// Butoes de consulta
		PlanodeFundo.add(porcodigo = new JButton("Por Código"));
		porcodigo.setBounds(720, 175, 120, 32);
		imagem = new JLabel(new ImageIcon("Imagens/porCodigoE.png"));
		porcodigo.setLayout(null);
		porcodigo.add(imagem);
		imagem.setBounds(1, 1, 118, 30);
		imagem.add(texto = new JLabel("Por Código"));
		imagem.setLayout(null);
		texto.setBounds(19, 4, 100, 20);
		texto.setFont(f4);

		PlanodeFundo.add(ordemAlfabetica = new JButton("Por Ordem Alfabética"));
		ordemAlfabetica.setBounds(880, 175, 180, 32);
		imagem = new JLabel(new ImageIcon("Imagens/porOrdem.png"));
		ordemAlfabetica.setLayout(null);
		ordemAlfabetica.add(imagem);
		imagem.setBounds(1, 1, 178, 30);
		imagem.add(texto2 = new JLabel("Por Ordem Alfabética"));
		imagem.setLayout(null);
		texto2.setBounds(13, 4, 180, 20);
		texto2.setFont(f4);

		PlanodeFundo.add(ok = new JButton("Ok"));
		ok.setBounds(550, 175, 52, 32);
		imagem = new JLabel(new ImageIcon("Imagens/ok.png"));
		ok.setLayout(null);
		ok.add(imagem);
		imagem.setBounds(1, 1, 50, 30);

		// Texto e Campo
		PlanodeFundo.add(label = new JLabel("Pesquisar Nome: "));
		label.setBounds(100, 175, 200, 32);
		label.setFont(f2);

		PlanodeFundo.add(campo = new JTextField());
		campo.setBounds(290, 175, 250, 32);
		campo.setFont(f3);

		// Incializando
		PainelTabela = new JPanel(new BorderLayout());
		PainelTabela.setBorder(new TitledBorder("Consultar Empresas"));
		Scroll = new JScrollPane();

		DefaultTableModel Modelo = new DefaultTableModel(new String[] {
				"Código", "Nome Fantasia", "Razão Social", "CNPJ",
				"Telefone da Empresa", "E-mail da Empresa", "Ramo Empresarial",
				"Nome do Responsável", "Telefone do Responsável",
				"E-mail do Responsável" }, 0) {
			public boolean isCellEditable(int row, int col) {
				if (col == 0 || col == 1 || col == 2 || col == 3 || col == 4
						|| col == 5 || col == 6 || col == 7 || col == 8
						|| col == 9) {
					return false;
				}
				return true;
			}

			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;

		};

		// Inciando Tabela
		Tabela = new JTable(Modelo);

		// Alinhar tabela a direita

		DefaultTableCellRenderer linhadireita = new DefaultTableCellRenderer();
		linhadireita.setHorizontalAlignment(SwingConstants.CENTER);
		Tabela.getColumnModel().getColumn(0).setCellRenderer(linhadireita);

		// Editando as colunas

		// Coluna 0
		Tabela.getColumnModel().getColumn(0).setPreferredWidth(70);
		Tabela.getColumnModel().getColumn(0).setResizable(false);

		// Coluna 1
		Tabela.getColumnModel().getColumn(1).setPreferredWidth(300);
		Tabela.getColumnModel().getColumn(1).setResizable(false);

		Tabela.getColumnModel().getColumn(1).setCellRenderer(linhadireita);

		// Coluna 2
		Tabela.getColumnModel().getColumn(2).setPreferredWidth(300);
		Tabela.getColumnModel().getColumn(2).setResizable(false);

		Tabela.getColumnModel().getColumn(2).setCellRenderer(linhadireita);

		// Coluna 3
		Tabela.getColumnModel().getColumn(3).setPreferredWidth(200);
		Tabela.getColumnModel().getColumn(3).setResizable(false);

		Tabela.getColumnModel().getColumn(3).setCellRenderer(linhadireita);

		// Coluna 4
		Tabela.getColumnModel().getColumn(4).setPreferredWidth(130);
		Tabela.getColumnModel().getColumn(4).setResizable(false);

		Tabela.getColumnModel().getColumn(4).setCellRenderer(linhadireita);

		// Coluna 5
		Tabela.getColumnModel().getColumn(5).setPreferredWidth(250);
		Tabela.getColumnModel().getColumn(5).setResizable(false);

		Tabela.getColumnModel().getColumn(5).setCellRenderer(linhadireita);

		// Coluna 6
		Tabela.getColumnModel().getColumn(6).setPreferredWidth(240);
		Tabela.getColumnModel().getColumn(6).setResizable(false);

		Tabela.getColumnModel().getColumn(6).setCellRenderer(linhadireita);

		// Coluna 7
		Tabela.getColumnModel().getColumn(7).setPreferredWidth(290);
		Tabela.getColumnModel().getColumn(7).setResizable(false);

		Tabela.getColumnModel().getColumn(7).setCellRenderer(linhadireita);

		// Coluna 8
		Tabela.getColumnModel().getColumn(8).setPreferredWidth(160);
		Tabela.getColumnModel().getColumn(8).setResizable(false);

		Tabela.getColumnModel().getColumn(8).setCellRenderer(linhadireita);

		// Coluna 9
		Tabela.getColumnModel().getColumn(9).setPreferredWidth(230);
		Tabela.getColumnModel().getColumn(9).setResizable(false);

		Tabela.getColumnModel().getColumn(9).setCellRenderer(linhadireita);

		PlanodeFundo.add(PainelTabela);

		Tabela.getTableHeader().setReorderingAllowed(false);
		Tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		Scroll.setViewportView(Tabela);
		PainelTabela.setBounds(30, 220, 1150, 300);
		Scroll.setBounds(15, 20, 1120, 270);
		PainelTabela.add(Scroll);
		Tabela.setBackground(Color.DARK_GRAY);
		Tabela.setForeground(Color.black);
		Tabela.setCellSelectionEnabled(true);
		Tabela.setBackground(Color.getHSBColor(0, 342, 180));

		Empresa emp = new Empresa();
		emp.AtualizaTable();

		ControleConsultar c = new ControleConsultar();
		voltar.addActionListener(c);
		ok.addActionListener(c);
		porcodigo.addActionListener(c);
		ordemAlfabetica.addActionListener(c);
	}

}
