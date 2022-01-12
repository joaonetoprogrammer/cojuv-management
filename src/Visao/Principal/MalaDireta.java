package Visao.Principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Controle.ControleConsultar;
import Controle.ControleFechar;
import Modelo.MalaDireta2;

public class MalaDireta extends JFrame {

	// Painel

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JPanel PainelTabela;
	public static JPanel PainelTabela2;
	public static JPanel PainelTabela3;
	public static JPanel PainelTabela4;

	public static JLabel l;
	public static JLabel l2;

	public static JButton b;
	public static JButton b2;
	public static JButton ok;
	public static JButton ok2;
	public static JTable Tabela;
	public static JTable Tabela2;
	public static JTable Tabela3;
	public static JTable Tabela4;
	public static JLabel label2;
	public static JLabel imagem;

	public static JComboBox<String> comboLotacao;
	public static JComboBox<String> comboOutrosContatos;

	// Scroll
	public static JScrollPane Scroll;
	public static JScrollPane Scroll2;
	public static JScrollPane Scroll3;
	public static JScrollPane Scroll4;


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
	public JLabel contatos;


	// Buttons
	public static JButton voltar;

	// Criacao da fontes

	Font minhafont;
	Font f2;
	Font f3;
	Font f4;

	public static JFrame Tela;

	public MalaDireta() {

		Container d = getContentPane();
		setLayout(null);
		Tela = this;
		setSize(1200, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		ControleFechar controleFechar = new ControleFechar();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(controleFechar);

		minhafont = new Font("Eras Bold ITC", Font.BOLD, 27);
		f2 = new Font("Eras Bold ITC", Font.BOLD, 20);
		f3 = new Font("Arial", Font.PLAIN, 18);
		f4 = new Font("Eras Bold ITC", Font.BOLD, 14);

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

		PlanodeFundo.add(titulo = new JLabel("Mala Direta"));
		titulo.setFont(minhafont);
		Dimension sizetitulo = titulo.getPreferredSize();
		titulo.setBounds(480, 50, sizetitulo.width, sizetitulo.height);

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

		PlanodeFundo.add(voltar = new JButton("voltar"));
		botao3 = new JLabel(new ImageIcon("Imagens/btvoltar2.png"));
		voltar.add(botao3);
		botao3.setBounds(1, 1, 298, 48);
		voltar.setBounds(430, 530, 300, 50);
		voltar.setLayout(null);

		PlanodeFundo.add(comboLotacao = new JComboBox<String>());
		comboLotacao.setBounds(330, 165, 655, 32);
		comboLotacao.setFont(f3);
		comboLotacao.addItem("");
		comboLotacao
				.addItem("Associação dos Agentes Comunitários de Saúde de Maranguape");
		comboLotacao
				.addItem("Comissão Interinstitucional SELO UNICEF - EDIÇÃO 2013 - 2014");
		comboLotacao.addItem("Chefia de Gabinete");
		comboLotacao
				.addItem("Conselho M. dos direitos da criança e do adolescente (COMDICA)");
		comboLotacao.addItem("Conselho Tutelar de Maranguape");
		comboLotacao.addItem("Coordenadoria Conselhos Comunitários");
		comboLotacao.addItem("Coordenadoria de Comunicação");
		comboLotacao.addItem("Coordenadoria de Juventude");
		comboLotacao.addItem("Coordenadoria Políticas sobre Drogas");
		comboLotacao
				.addItem("Fundação Viva Maranguape de Turismo, Esporte e Cultura - FITEC");
		comboLotacao
				.addItem("Hospital Municipal Dr. Argeu Gurgel Braga Herbster(HMABH)");
		comboLotacao
				.addItem("Instituto de Previdência do Município de Maranguape - IPMM");
		comboLotacao.addItem("Núcleo de Gestão Educacional - Coordenadores");
		comboLotacao
				.addItem("Núcleo de Gestão Educacional - Coordenadores Escolas Anexas");
		comboLotacao
				.addItem("Núcleo de Gestão Educacional - Coordenadores - Infantil e Creche");
		comboLotacao.addItem("Núcleo de Gestão Educacional - Diretores");
		comboLotacao.addItem("Núcleo de Gestão Educacional - Secretários");
		comboLotacao.addItem("Procuradoria Geral do Município(PGM)");
		comboLotacao.addItem("Secretaria de Administração e Finaças(SAFIN)");
		comboLotacao.addItem("Secretaria de Educação");
		comboLotacao.addItem("Secretaria de Infraestrutura (SEINFRA)");
		comboLotacao
				.addItem("Secretaria de Meio Ambiente, D. Agrário e M. Ambiente (SEMADE)");
		comboLotacao.addItem("Secretaria de Saúde");
		comboLotacao
				.addItem("Secretaria de Trabalho e Desenvolvimento Social (STDS)");
		PlanodeFundo.add(l = new JLabel("Selecione uma Instituição:"));
		l.setBounds(20, 165, 300, 30);
		l.setFont(f2);
		
		PlanodeFundo.add(l2 = new JLabel("Outros Contatos:"));
		l2.setBounds(20, 205, 300, 30);
		l2.setFont(f2);

		PlanodeFundo.add(comboOutrosContatos = new JComboBox<String>());
		comboOutrosContatos.setBounds(330, 205, 655, 32);
		comboOutrosContatos.setFont(f3);
		comboOutrosContatos.addItem("");
		comboOutrosContatos.addItem("Grêmio Estudantil Anchieta");
		comboOutrosContatos.addItem("Grêmio Estudantil Antônio Luiz Coelho");
		comboOutrosContatos.addItem("Grêmio Estudantil Antônio Marques");
		comboOutrosContatos.addItem("Grêmio Estudantil CAIC Senador Carlos Jereissati");
		comboOutrosContatos.addItem("Grêmio Estudantil Clovis Monteiro");
		comboOutrosContatos.addItem("Grêmio Estudantil Conego Heitor");
		comboOutrosContatos.addItem("Grêmio Estudantil E.M Francsica Rocha Magalhães");
		comboOutrosContatos.addItem("Grêmio Estudantil E.E.M. Luiz Girão");
		comboOutrosContatos.addItem("Grêmio Estudantil EEEP Santa Rita");
		comboOutrosContatos.addItem("Grêmio Estudantil Eunice Weaver");
		comboOutrosContatos.addItem("Grêmio Estudantil João Cirino");
		comboOutrosContatos.addItem("Grêmio Estudantil José Fernades Vieira");
		comboOutrosContatos.addItem("Grêmio Estudantil Manoel Rodrigues");
		comboOutrosContatos.addItem("Grêmio Estudantil Nilo Campelo");
		comboOutrosContatos.addItem("Grêmio Estudantil Rio Grande do Norte");
		comboOutrosContatos.addItem("Grêmio Estudantil Antônio Marques");
		
		PlanodeFundo.add(b = new JButton());
		b.setBounds(1062, 165, 122, 32);
		imagem = new JLabel(new ImageIcon("Imagens/porCodigoE.png"));
		b.setLayout(null);
		b.add(imagem);
		imagem.setBounds(1, 1, 120, 30);
		imagem.add(label2 = new JLabel("TODOS"));
		imagem.setLayout(null);
		label2.setBounds(35, 4, 100, 20);
		label2.setFont(f4);
		
		PlanodeFundo.add(b2 = new JButton());
		b2.setBounds(1062, 205, 122, 32);
		imagem = new JLabel(new ImageIcon("Imagens/porCodigoE.png"));
		b2.setLayout(null);
		b2.add(imagem);
		imagem.setBounds(1, 1, 120, 30);
		imagem.add(label2 = new JLabel("TODOS"));
		imagem.setLayout(null);
		label2.setBounds(35, 4, 100, 20);
		label2.setFont(f4);

		PlanodeFundo.add(ok = new JButton());
		ok.setBounds(1000, 165, 52, 32);
		imagem = new JLabel(new ImageIcon("Imagens/ok.png"));
		ok.setLayout(null);
		ok.add(imagem);
		imagem.setBounds(1, 1, 50, 30);
		
		PlanodeFundo.add(ok2 = new JButton());
		ok2.setBounds(1000, 205, 52, 32);
		imagem = new JLabel(new ImageIcon("Imagens/ok.png"));
		ok2.setLayout(null);
		ok2.add(imagem);
		imagem.setBounds(1, 1, 50, 30);

		// Incializando
		PainelTabela = new JPanel(new BorderLayout());
		PainelTabela
				.setBorder(new TitledBorder("Mala Direta Servidor Público"));
		Scroll = new JScrollPane();

		DefaultTableModel Modelo = new DefaultTableModel(
				new String[] { "Emails Servidor Público" }, 0) {
			public boolean isCellEditable(int row, int col) {
				if (col == 0) {
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
		Tabela.getColumnModel().getColumn(0).setPreferredWidth(250);
		Tabela.getColumnModel().getColumn(0).setResizable(false);
		Tabela.getColumnModel().getColumn(0).setCellRenderer(linhadireita);

		PlanodeFundo.add(PainelTabela);

		Tabela.getTableHeader().setReorderingAllowed(false);
		Tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		Scroll.setViewportView(Tabela);
		PainelTabela.setBounds(20, 250, 270, 270);
		Scroll.setBounds(10, 20, 250, 240);
		PainelTabela.add(Scroll);
		Tabela.setBackground(Color.DARK_GRAY);
		Tabela.setForeground(Color.black);
		Tabela.setCellSelectionEnabled(true);
		Tabela.setBackground(Color.getHSBColor(0, 342, 180));

		// TABELA DOIS
		// Incializando
		PainelTabela2 = new JPanel(new BorderLayout());
		PainelTabela2.setBorder(new TitledBorder(
				"Mala Direta Servidor Terceirizado"));
		Scroll2 = new JScrollPane();

		DefaultTableModel Model = new DefaultTableModel(
				new String[] { "Emails Servidor Terceirizado" }, 0) {

			public boolean isCellEditable(int row, int col) {
				if (col == 0) {
					return false;
				}
				return true;
			}

			private static final long serialVersionUID = 1L;

		};

		// Inciando Tabela
		Tabela2 = new JTable(Model);

		// Alinhar tabela a direita

		DefaultTableCellRenderer linhadireita2 = new DefaultTableCellRenderer();
		linhadireita2.setHorizontalAlignment(SwingConstants.CENTER);

		// Editando as colunas

		// Coluna 0
		Tabela2.getColumnModel().getColumn(0).setPreferredWidth(250);
		Tabela2.getColumnModel().getColumn(0).setResizable(false);
		Tabela2.getColumnModel().getColumn(0).setCellRenderer(linhadireita2);

		PlanodeFundo.add(PainelTabela2);

		Tabela2.getTableHeader().setReorderingAllowed(false);
		Tabela2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		Scroll2.setViewportView(Tabela2);
		PainelTabela2.setBounds(310, 250, 270, 270);
		Scroll2.setBounds(90, 20, 250, 240);
		PainelTabela2.add(Scroll2);
		Tabela2.setBackground(Color.DARK_GRAY);
		Tabela2.setForeground(Color.black);
		Tabela2.setCellSelectionEnabled(true);
		Tabela2.setBackground(Color.getHSBColor(0, 342, 180));

		// TABELA TRES
		// Incializando
		PainelTabela3 = new JPanel(new BorderLayout());
		PainelTabela3.setBorder(new TitledBorder("Mala Direta Grupos"));
		Scroll3 = new JScrollPane();

		DefaultTableModel Model2 = new DefaultTableModel(
				new String[] { "Emails Grupos" }, 0) {

			public boolean isCellEditable(int row, int col) {
				if (col == 0) {
					return false;
				}
				return true;
			}

			private static final long serialVersionUID = 1L;

		};

		// Inciando Tabela
		Tabela3 = new JTable(Model2);

		// Alinhar tabela a direita

		DefaultTableCellRenderer linhadireita3 = new DefaultTableCellRenderer();
		linhadireita3.setHorizontalAlignment(SwingConstants.CENTER);

		// Editando as colunas

		// Coluna 0
		Tabela3.getColumnModel().getColumn(0).setPreferredWidth(250);
		Tabela3.getColumnModel().getColumn(0).setResizable(false);
		Tabela3.getColumnModel().getColumn(0).setCellRenderer(linhadireita3);

		PlanodeFundo.add(PainelTabela3);

		Tabela3.getTableHeader().setReorderingAllowed(false);
		Tabela3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		Scroll3.setViewportView(Tabela3);
		PainelTabela3.setBounds(605, 250, 270, 270);
		Scroll3.setBounds(70, 20, 250, 240);
		PainelTabela3.add(Scroll3);
		Tabela3.setBackground(Color.DARK_GRAY);
		Tabela3.setForeground(Color.black);
		Tabela3.setCellSelectionEnabled(true);
		Tabela3.setBackground(Color.getHSBColor(0, 342, 180));
		
		
		// TABELA QUATRO
		// Incializando
		PainelTabela4 = new JPanel(new BorderLayout());
		PainelTabela4.setBorder(new TitledBorder("Mala Direta Outros Contatos"));
		Scroll4 = new JScrollPane();

		DefaultTableModel Model3 = new DefaultTableModel(
				new String[] { "Emails Outros Contatos" }, 0) {

			public boolean isCellEditable(int row, int col) {
				if (col == 0) {
					return false;
				}
				return true;
			}

			private static final long serialVersionUID = 1L;

		};

		// Inciando Tabela
		Tabela4 = new JTable(Model3);

		// Alinhar tabela a direita

		DefaultTableCellRenderer linhadireita4 = new DefaultTableCellRenderer();
		linhadireita4.setHorizontalAlignment(SwingConstants.CENTER);

		// Editando as colunas

		// Coluna 0
		Tabela4.getColumnModel().getColumn(0).setPreferredWidth(250);
		Tabela4.getColumnModel().getColumn(0).setResizable(false);
		Tabela4.getColumnModel().getColumn(0).setCellRenderer(linhadireita3);

		PlanodeFundo.add(PainelTabela4);

		Tabela4.getTableHeader().setReorderingAllowed(false);
		Tabela4.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		Scroll4.setViewportView(Tabela4);
		PainelTabela4.setBounds(905, 250, 270, 270);
		Scroll4.setBounds(70, 20, 250, 240);
		PainelTabela4.add(Scroll4);
		Tabela4.setBackground(Color.DARK_GRAY);
		Tabela4.setForeground(Color.black);
		Tabela4.setCellSelectionEnabled(true);
		Tabela4.setBackground(Color.getHSBColor(0, 342, 180));

		MalaDireta2 m = new MalaDireta2();
		m.AtualizaTable2();
		m.AtualizaTable();
		m.AtualizaTableGrupos();
		m.AtualizaTableContatosGeral();

		ControleConsultar c = new ControleConsultar();
		ok.addActionListener(c);
		b.addActionListener(c);
		ok2.addActionListener(c);
		b2.addActionListener(c);
		voltar.addActionListener(c);

	}

	public static void main(String[] args) {
		new MalaDireta();
	}
}
