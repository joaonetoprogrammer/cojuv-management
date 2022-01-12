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
import Controle.ControleFecharProjeto;
import Modelo.Projeto;

public class ConsultarProjeto extends JFrame {

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
	Font f5;

	public static JFrame Tela;

	public static JButton ok;
	public static JButton ok2;
	public static JButton porCodigo;
	public static JButton porOrdem;

	public static JLabel label;
	public static JTextField campo;

	public static JLabel label2;
	public static JTextField campo2;

	// Labels de Imagens de Butoes
	public static JLabel imagem;
	public static JLabel texto;
	public static JLabel texto2;

	public ConsultarProjeto() {

		Container d = getContentPane();
		setLayout(null);
		Tela = this;
		setSize(1200, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		ControleFecharProjeto fechar = new ControleFecharProjeto();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(fechar);

		minhafont = new Font("Eras Bold ITC", Font.BOLD, 26);
		f2 = new Font("Eras Bold ITC", Font.BOLD, 20);
		f3 = new Font("Arial", Font.PLAIN, 18);
		f4 = new Font("Eras Bold ITC", Font.BOLD, 12);
		f5 = new Font("Arial", Font.BOLD, 12);
		imagem = new JLabel();

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

		PlanodeFundo.add(titulo = new JLabel("Consultar Projetos"));
		titulo.setFont(minhafont);
		Dimension sizetitulo = titulo.getPreferredSize();
		titulo.setBounds(430, 50, sizetitulo.width, sizetitulo.height);

		// Titulo2
		PlanodeFundo.add(titulo2 = new JLabel(
				"Sistema de Gestão - Coordenadoria de Juventude"));
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

		PlanodeFundo.add(porCodigo = new JButton("Por Código"));
		porCodigo.setBounds(720, 190, 122, 32);
		imagem = new JLabel(new ImageIcon("Imagens/porCodigoE.png"));
		porCodigo.setLayout(null);
		porCodigo.add(imagem);
		imagem.setBounds(1, 1, 120, 30);
		imagem.add(texto = new JLabel("Por Código"));
		imagem.setLayout(null);
		texto.setBounds(19, 4, 100, 20);
		texto.setFont(f4);

		PlanodeFundo.add(porOrdem = new JButton("Por Oredm Alfabética"));
		porOrdem.setBounds(880, 190, 180, 32);
		imagem = new JLabel(new ImageIcon("Imagens/porOrdem.png"));
		porOrdem.setLayout(null);
		porOrdem.add(imagem);
		imagem.setBounds(1, 1, 178, 30);
		imagem.add(texto2 = new JLabel("Por Ordem Alfabética"));
		imagem.setLayout(null);
		texto2.setBounds(13, 4, 180, 20);
		texto2.setFont(f4);

		PlanodeFundo.add(ok = new JButton("Ok"));
		ok.setBounds(590, 165, 52, 32);
		imagem = new JLabel(new ImageIcon("Imagens/ok.png"));
		ok.setLayout(null);
		ok.add(imagem);
		imagem.setBounds(1, 1, 50, 30);

		// Texto e Campo
		PlanodeFundo.add(label = new JLabel("Pesquisar Nome: "));
		label.setBounds(80, 165, 200, 32);
		label.setFont(f2);

		PlanodeFundo.add(campo = new JTextField());
		campo.setBounds(330, 165, 250, 32);
		campo.setFont(f3);

		PlanodeFundo.add(ok2 = new JButton("Ok"));
		ok2.setBounds(590, 205, 52, 32);
		imagem = new JLabel(new ImageIcon("Imagens/ok.png"));
		ok2.setLayout(null);
		ok2.add(imagem);
		imagem.setBounds(1, 1, 50, 30);

		// Texto e Campo
		PlanodeFundo.add(label2 = new JLabel("Pesquisar Orientador: "));
		label2.setBounds(80, 205, 270, 32);
		label2.setFont(f2);

		PlanodeFundo.add(campo2 = new JTextField());
		campo2.setBounds(330, 205, 250, 32);
		campo2.setFont(f3);
		// Incializando
		PainelTabela = new JPanel(new BorderLayout());
		PainelTabela.setBorder(new TitledBorder("Consultar Servidor Público"));
		Scroll = new JScrollPane();

		DefaultTableModel Modelo = new DefaultTableModel(new String[] {
				"Código", "Nome do projeto", "Orientador",
				"Telefone do Orientador", "E-mail do Orientador",
				"Público-Alvo", "Localidade", "Descrição" }, 0) {
			public boolean isCellEditable(int row, int col) {
				if (col == 0 || col == 1 || col == 2 || col == 3 || col == 4
						|| col == 5 || col == 6|| col == 7) {
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

		// Editando as colunas

		// Coluna 0
		Tabela.getColumnModel().getColumn(0).setPreferredWidth(70);
		Tabela.getColumnModel().getColumn(0).setResizable(false);
		Tabela.getColumnModel().getColumn(0).setCellRenderer(linhadireita);

		// Coluna 1
		Tabela.getColumnModel().getColumn(1).setPreferredWidth(300);
		Tabela.getColumnModel().getColumn(1).setResizable(false);

		Tabela.getColumnModel().getColumn(1).setCellRenderer(linhadireita);

		// Coluna 2
		Tabela.getColumnModel().getColumn(2).setPreferredWidth(280);
		Tabela.getColumnModel().getColumn(2).setResizable(false);

		Tabela.getColumnModel().getColumn(2).setCellRenderer(linhadireita);

		// Coluna 3
		Tabela.getColumnModel().getColumn(3).setPreferredWidth(130);
		Tabela.getColumnModel().getColumn(3).setResizable(false);

		Tabela.getColumnModel().getColumn(3).setCellRenderer(linhadireita);
		// Coluna 4
		Tabela.getColumnModel().getColumn(4).setPreferredWidth(230);
		Tabela.getColumnModel().getColumn(4).setResizable(false);

		Tabela.getColumnModel().getColumn(4).setCellRenderer(linhadireita);

		// Coluna 5
		Tabela.getColumnModel().getColumn(5).setPreferredWidth(230);
		Tabela.getColumnModel().getColumn(5).setResizable(false);

		Tabela.getColumnModel().getColumn(5).setCellRenderer(linhadireita);

		// Coluna 6
		Tabela.getColumnModel().getColumn(6).setPreferredWidth(230);
		Tabela.getColumnModel().getColumn(6).setResizable(false);

		Tabela.getColumnModel().getColumn(6).setCellRenderer(linhadireita);
		
		// Coluna 6
		Tabela.getColumnModel().getColumn(7).setPreferredWidth(300);
		Tabela.getColumnModel().getColumn(7).setResizable(false);

		Tabela.getColumnModel().getColumn(7).setCellRenderer(linhadireita);

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
		Projeto p = new Projeto();
		p.AtualizaTable();

		ControleConsultar c = new ControleConsultar();
		voltar.addActionListener(c);
		ok.addActionListener(c);
		ok2.addActionListener(c);
		porCodigo.addActionListener(c);
		porOrdem.addActionListener(c);

	}

}
