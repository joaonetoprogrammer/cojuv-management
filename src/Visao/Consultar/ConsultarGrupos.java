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
import Controle.ControleFecharGrupos;
import Modelo.Grupos;

public class ConsultarGrupos extends JFrame {

	// Painel

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JPanel PainelTabela;

	// Tabela
	public static JTable Tabela;

	public static JButton ok;
	public static JButton ok2;
	public static JButton porCodigo;
	public static JButton porOrdem;

	public static JLabel imagem;
	public static JLabel label;
	public static JLabel label2;
	public static JTextField entidade;

	public static JLabel porNome;
	public static JLabel porLotacao;

	public static JTextField campo;
	// Scroll
	public static JScrollPane Scroll;

	// Criação dos JLabels

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

	public ConsultarGrupos() {

		Container d = getContentPane();
		setLayout(null);
		Tela = this;
		setSize(1200, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		ControleFecharGrupos fechar = new ControleFecharGrupos();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(fechar);
		imagem = new JLabel();

		minhafont = new Font("Eras Bold ITC", Font.BOLD, 26);
		f2 = new Font("Eras Bold ITC", Font.BOLD, 20);
		f3 = new Font("Arial", Font.PLAIN, 18);
		f4 = new Font("Eras Bold ITC", Font.BOLD, 12);

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

		PlanodeFundo.add(titulo = new JLabel("Consultar Servidor Público"));
		titulo.setFont(minhafont);
		Dimension sizetitulo = titulo.getPreferredSize();
		titulo.setBounds(360, 50, sizetitulo.width, sizetitulo.height);

		// Titulo2
		PlanodeFundo.add(titulo2 = new JLabel(
				"Sistema de Gestão - Coordenadoria de Juventude"));
		titulo2.setFont(minhafont);
		Dimension sizetitulo2 = titulo2.getPreferredSize();
		titulo2.setBounds(240, 90, sizetitulo2.width, sizetitulo2.height);

		PlanodeFundo.add(rodape = new JLabel("Prefeitura de Maranguape"));
		rodape.setFont(minhafont);
		Dimension sizerodape = rodape.getPreferredSize();
		rodape.setBounds(380, 600, sizerodape.width, sizerodape.height);

		PlanodeFundo.add(ok2 = new JButton());
		ok2.setBounds(670, 205, 52, 32);
		imagem = new JLabel(new ImageIcon("Imagens/ok.png"));
		ok2.setLayout(null);
		ok2.add(imagem);
		imagem.setBounds(1, 1, 50, 30);

		PlanodeFundo.add(voltar = new JButton("voltar"));
		botao3 = new JLabel(new ImageIcon("Imagens/btvoltar2.png"));
		voltar.add(botao3);
		botao3.setBounds(1, 1, 298, 48);
		voltar.setBounds(430, 530, 300, 50);
		voltar.setLayout(null);

		PlanodeFundo.add(ok = new JButton());
		ok.setBounds(670, 165, 52, 32);
		imagem = new JLabel(new ImageIcon("Imagens/ok.png"));
		ok.setLayout(null);
		ok.add(imagem);
		imagem.setBounds(1, 1, 50, 30);

		PlanodeFundo.add(porCodigo = new JButton());
		porCodigo.setBounds(1042, 205, 122, 32);
		imagem = new JLabel(new ImageIcon("Imagens/porCodigoE.png"));
		porCodigo.setLayout(null);
		porCodigo.add(imagem);
		imagem.setBounds(1, 1, 120, 30);
		imagem.add(label = new JLabel("Por Código"));
		imagem.setLayout(null);
		label.setBounds(19, 4, 100, 20);
		label.setFont(f4);

		PlanodeFundo.add(porOrdem = new JButton());
		porOrdem.setBounds(985, 165, 180, 32);
		imagem = new JLabel(new ImageIcon("Imagens/porOrdem.png"));
		porOrdem.setLayout(null);
		porOrdem.add(imagem);
		imagem.setBounds(1, 1, 178, 30);
		imagem.add(label2 = new JLabel("Por Ordem Alfabética"));
		imagem.setLayout(null);
		label2.setBounds(13, 4, 180, 20);
		label2.setFont(f4);
		// Texto e Campo
		PlanodeFundo.add(porNome = new JLabel("Pesquisar Grupo: "));
		porNome.setBounds(50, 165, 200, 32);
		porNome.setFont(f2);

		PlanodeFundo.add(campo = new JTextField());
		campo.setBounds(300, 165, 355, 32);
		campo.setFont(f3);

		PlanodeFundo.add(porLotacao = new JLabel("Pesquisar Identidade: "));
		porLotacao.setBounds(50, 205, 270, 32);
		porLotacao.setFont(f2);

		PlanodeFundo.add(entidade = new JTextField());
		entidade.setBounds(300, 205, 355, 32);
		entidade.setFont(f3);

		// Incializando
		PainelTabela = new JPanel(new BorderLayout());
		PainelTabela.setBorder(new TitledBorder("Consultar Servidor Público"));
		Scroll = new JScrollPane();

		DefaultTableModel Modelo = new DefaultTableModel(new String[] {
				"Código", "Grupo", "Fundação", "Identidade",
				"Dias de Encontro", "Horário de Encontro", "Local",
				"Bairro/Distrito", "Comunidade", "Entidade", "Responsável",
				"Telefone", "Coordenador", "E-mail", "Facebook",
				"Tel Coordenador", "Atividades" }, 0) {
			public boolean isCellEditable(int row, int col) {
				if (col == 0 || col == 1 || col == 2 || col == 3 || col == 4
						|| col == 5 || col == 6 || col == 7 || col == 8
						|| col == 9 || col == 10 || col == 11 || col == 12
						|| col == 13 || col == 14 || col == 15 || col == 16) {
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
		Tabela.getColumnModel().getColumn(2).setPreferredWidth(150);
		Tabela.getColumnModel().getColumn(2).setResizable(false);

		Tabela.getColumnModel().getColumn(2).setCellRenderer(linhadireita);

		// Coluna 3
		Tabela.getColumnModel().getColumn(3).setPreferredWidth(300);
		Tabela.getColumnModel().getColumn(3).setResizable(false);

		Tabela.getColumnModel().getColumn(3).setCellRenderer(linhadireita);

		// Coluna 4
		Tabela.getColumnModel().getColumn(4).setPreferredWidth(300);
		Tabela.getColumnModel().getColumn(4).setResizable(false);

		Tabela.getColumnModel().getColumn(4).setCellRenderer(linhadireita);

		// Coluna 5
		Tabela.getColumnModel().getColumn(5).setPreferredWidth(150);
		Tabela.getColumnModel().getColumn(5).setResizable(false);

		Tabela.getColumnModel().getColumn(5).setCellRenderer(linhadireita);

		// Coluna 6
		Tabela.getColumnModel().getColumn(6).setPreferredWidth(250);
		Tabela.getColumnModel().getColumn(6).setResizable(false);

		Tabela.getColumnModel().getColumn(6).setCellRenderer(linhadireita);

		// Coluna 7
		Tabela.getColumnModel().getColumn(7).setPreferredWidth(290);
		Tabela.getColumnModel().getColumn(7).setResizable(false);

		Tabela.getColumnModel().getColumn(7).setCellRenderer(linhadireita);

		// Coluna 8
		Tabela.getColumnModel().getColumn(8).setPreferredWidth(300);
		Tabela.getColumnModel().getColumn(8).setResizable(false);

		Tabela.getColumnModel().getColumn(8).setCellRenderer(linhadireita);

		// Coluna 9
		Tabela.getColumnModel().getColumn(9).setPreferredWidth(300);
		Tabela.getColumnModel().getColumn(9).setResizable(false);

		Tabela.getColumnModel().getColumn(9).setCellRenderer(linhadireita);

		// Coluna 10
		Tabela.getColumnModel().getColumn(10).setPreferredWidth(300);
		Tabela.getColumnModel().getColumn(10).setResizable(false);

		Tabela.getColumnModel().getColumn(10).setCellRenderer(linhadireita);

		// Coluna 11
		Tabela.getColumnModel().getColumn(11).setPreferredWidth(150);
		Tabela.getColumnModel().getColumn(11).setResizable(false);

		Tabela.getColumnModel().getColumn(11).setCellRenderer(linhadireita);

		// Coluna 12
		Tabela.getColumnModel().getColumn(12).setPreferredWidth(300);
		Tabela.getColumnModel().getColumn(12).setResizable(false);

		Tabela.getColumnModel().getColumn(12).setCellRenderer(linhadireita);

		// Coluna 13
		Tabela.getColumnModel().getColumn(13).setPreferredWidth(300);
		Tabela.getColumnModel().getColumn(13).setResizable(false);

		Tabela.getColumnModel().getColumn(13).setCellRenderer(linhadireita);

		// Coluna 14
		Tabela.getColumnModel().getColumn(14).setPreferredWidth(230);
		Tabela.getColumnModel().getColumn(14).setResizable(false);

		Tabela.getColumnModel().getColumn(14).setCellRenderer(linhadireita);

		// Coluna 15
		Tabela.getColumnModel().getColumn(15).setPreferredWidth(150);
		Tabela.getColumnModel().getColumn(15).setResizable(false);

		Tabela.getColumnModel().getColumn(15).setCellRenderer(linhadireita);

		// Coluna 16
		Tabela.getColumnModel().getColumn(16).setPreferredWidth(300);
		Tabela.getColumnModel().getColumn(16).setResizable(false);

		Tabela.getColumnModel().getColumn(16).setCellRenderer(linhadireita);
		PlanodeFundo.add(PainelTabela);

		Tabela.getTableHeader().setReorderingAllowed(false);
		Tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		Scroll.setViewportView(Tabela);
		PainelTabela.setBounds(30, 250, 1150, 270);
		Scroll.setBounds(15, 20, 1120, 240);
		PainelTabela.add(Scroll);
		Tabela.setBackground(Color.DARK_GRAY);
		Tabela.setForeground(Color.black);
		Tabela.setCellSelectionEnabled(true);
		Tabela.setBackground(Color.getHSBColor(0, 342, 180));

		Grupos g = new Grupos();
		g.AtualizaTable();

		ControleConsultar c = new ControleConsultar();
		voltar.addActionListener(c);
		ok.addActionListener(c);
		ok2.addActionListener(c);
		porCodigo.addActionListener(c);
		porOrdem.addActionListener(c);

	}

}