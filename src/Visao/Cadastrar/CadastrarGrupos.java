package Visao.Cadastrar;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.text.MaskFormatter;

import Controle.ControleCadastrar;
import Controle.ControleFecharGrupos;

public class CadastrarGrupos extends JFrame {

	// Criação dos JLabels

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JLabel titulo;
	public static JLabel titulo2;
	public static JLabel rodape;
	public static JLabel grupo;
	public static JLabel fundacao;
	public static JLabel identidade;
	public static JLabel diasDeEncontro;
	public static JLabel HorarioDeEncontro;
	public static JLabel local;
	public static JLabel bairro;
	public static JLabel comunidade;
	public static JLabel entidade;
	public static JLabel responsavel;
	public static JLabel tel_responsavel;
	public static JLabel coordenador;
	public static JLabel email;
	public static JLabel facebook;
	public static JLabel cel_coordenador;
	public static JLabel atividade;

	public static JScrollPane pane;
	// Font
	Font minhafont;
	Font minhafont2;

	// Criação TextField

	public static JTextField tgrupo;
	public static JFormattedTextField tfundacao;
	public static JTextField tidentidade;
	public static JTextField tdiasDeEncontro;
	public static JFormattedTextField tHorarioDeEncontro;
	public static JTextField tlocal;
	public static JTextField tbairro;
	public static JTextField tcomunidade;
	public static JTextField tentidade;
	public static JTextField tresponsavel;
	public static JFormattedTextField ttel_responsavel;
	public static JTextField tcoordenador;
	public static JTextField temail;
	public static JTextField tfacebook;
	public static JFormattedTextField tcel_coordenador;
	public static TextArea tatividade;

	public static MaskFormatter maskFundacao;
	public static MaskFormatter maskTelefone;
	public static MaskFormatter maskTelefone2;
	public static MaskFormatter maskHora;

	// Buttons

	public static JButton cadastrar;
	public static JButton voltar;

	// Inserção de Imagens

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

	public CadastrarGrupos() {

		Container h = getContentPane();
		h.setLayout(null);
		Tela = this;
		setSize(1300, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		ControleFecharGrupos fechar = new ControleFecharGrupos();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(fechar);

		minhafont = new Font("Eras Bold ITC", Font.BOLD, 26);
		minhafont2 = new Font("arial", Font.PLAIN, 25);

		maskFundacao = new MaskFormatter();
		maskTelefone = new MaskFormatter();
		maskTelefone2 = new MaskFormatter();
		maskHora = new MaskFormatter();
		// Imagens

		// Plano de Fundo
		PlanodeFundo = new JLabel(new ImageIcon("Imagens/PlanodeFundo.jpg"));
		h.add(PlanodeFundo);
		PlanodeFundo.setBounds(0, 00, 1300, 800);
		PlanodeFundo.setLayout(null);

		// Agenda

		agenda = new JLabel(new ImageIcon("Imagens/AgendaCordenadoria.png"));
		PlanodeFundo.add(agenda);
		agenda.setBounds(1100, 2, 170, 160);

		// Barra1

		barra = new JLabel(new ImageIcon("Imagens/barra.png"));
		PlanodeFundo.add(barra);
		barra.setBounds(0, 20, 1300, 25);

		// Barra2

		barra2 = new JLabel(new ImageIcon("Imagens/barra.png"));
		PlanodeFundo.add(barra2);
		barra2.setBounds(0, 130, 1300, 25);

		// Brasao

		brasao = new JLabel(new ImageIcon("Imagens/brasaomaranguape.png"));
		PlanodeFundo.add(brasao);
		brasao.setBounds(1110, 630, 150, 140);

		// Barra3

		barra3 = new JLabel(new ImageIcon("Imagens/barra2.png"));
		PlanodeFundo.add(barra3);
		barra3.setBounds(0, 690, 1300, 15);

		// Barra4

		barra4 = new JLabel(new ImageIcon("Imagens/barra2.png"));
		PlanodeFundo.add(barra4);
		barra4.setBounds(0, 740, 1300, 15);

		// Insercao dos Jlabel

		// Ttitulo1

		PlanodeFundo.add(titulo = new JLabel("Cadastrar Grupo"));
		titulo.setFont(minhafont);
		Dimension sizetitulo = titulo.getPreferredSize();
		titulo.setBounds(540, 50, sizetitulo.width, sizetitulo.height);

		// Titulo2
		PlanodeFundo.add(titulo2 = new JLabel(
				"Sistema de Gestão - Coordenadoria de Juventude"));
		titulo2.setFont(minhafont);
		Dimension sizetitulo2 = titulo2.getPreferredSize();
		titulo2.setBounds(340, 90, sizetitulo2.width, sizetitulo2.height);

		// Rodape
		PlanodeFundo.add(rodape = new JLabel("Prefeitura de Maranguape"));
		rodape.setFont(minhafont);
		Dimension sizerodape = rodape.getPreferredSize();
		rodape.setBounds(490, 700, sizerodape.width, sizerodape.height);

		PlanodeFundo.add(grupo = new JLabel("Grupo:"));
		grupo.setFont(minhafont);
		Dimension sizeGrupo = grupo.getPreferredSize();
		grupo.setBounds(40, 190, sizeGrupo.width, sizeGrupo.height);

		PlanodeFundo.add(fundacao = new JLabel("Fundação: "));
		fundacao.setFont(minhafont);
		Dimension sizeFundacao = fundacao.getPreferredSize();
		fundacao.setBounds(810, 190, sizeFundacao.width, sizeFundacao.height);

		PlanodeFundo.add(identidade = new JLabel(
				"Identidade (Cultural, religioso, esportivo, etc.): "));
		identidade.setFont(minhafont);
		Dimension sizerazaocnpj = identidade.getPreferredSize();
		identidade
				.setBounds(40, 230, sizerazaocnpj.width, sizerazaocnpj.height);

		PlanodeFundo.add(diasDeEncontro = new JLabel("Dias de Encontro:"));
		diasDeEncontro.setFont(minhafont);
		Dimension sizetelefoneempresa = diasDeEncontro.getPreferredSize();
		diasDeEncontro.setBounds(40, 270, sizetelefoneempresa.width,
				sizetelefoneempresa.height);

		PlanodeFundo.add(bairro = new JLabel("Bairro/Distrito:"));
		bairro.setFont(minhafont);
		Dimension sizeemailempresa = bairro.getPreferredSize();
		bairro.setBounds(40, 310, sizeemailempresa.width,
				sizeemailempresa.height);

		PlanodeFundo.add(HorarioDeEncontro = new JLabel("Horário:"));
		HorarioDeEncontro.setFont(minhafont);
		Dimension sizenome = HorarioDeEncontro.getPreferredSize();
		HorarioDeEncontro.setBounds(550, 270, sizenome.width, sizenome.height);

		PlanodeFundo.add(local = new JLabel("Local:"));
		local.setFont(minhafont);
		Dimension sizetelefone = local.getPreferredSize();
		local.setBounds(840, 270, sizetelefone.width, sizetelefone.height);

		PlanodeFundo.add(comunidade = new JLabel("Comunidade:"));
		comunidade.setFont(minhafont);
		Dimension sizeRamo = comunidade.getPreferredSize();
		comunidade.setBounds(700, 310, sizeRamo.width, sizeRamo.height);

		PlanodeFundo.add(entidade = new JLabel("Entidade:"));
		entidade.setFont(minhafont);
		Dimension sizeE = entidade.getPreferredSize();
		entidade.setBounds(40, 350, sizeE.width, sizeE.height);

		PlanodeFundo.add(responsavel = new JLabel("Responsável:"));
		responsavel.setFont(minhafont);
		Dimension sizeR = responsavel.getPreferredSize();
		responsavel.setBounds(470, 350, sizeR.width, sizeR.height);

		PlanodeFundo.add(tel_responsavel = new JLabel("Telefone:"));
		tel_responsavel.setFont(minhafont);
		Dimension sizeT = tel_responsavel.getPreferredSize();
		tel_responsavel.setBounds(960, 350, sizeT.width, sizeT.height);

		PlanodeFundo.add(coordenador = new JLabel("Coordenador do grupo:"));
		coordenador.setFont(minhafont);
		Dimension sizeC = coordenador.getPreferredSize();
		coordenador.setBounds(40, 390, sizeC.width, sizeC.height);

		PlanodeFundo.add(email = new JLabel("E-mail:"));
		email.setFont(minhafont);
		Dimension sizeemail = email.getPreferredSize();
		email.setBounds(750, 390, sizeemail.width, sizeemail.height);

		PlanodeFundo.add(facebook = new JLabel("Facebook:"));
		facebook.setFont(minhafont);
		Dimension sizef = facebook.getPreferredSize();
		facebook.setBounds(40, 430, sizef.width, sizef.height);

		PlanodeFundo.add(cel_coordenador = new JLabel("Telefone:"));
		cel_coordenador.setFont(minhafont);
		Dimension sizeCel = cel_coordenador.getPreferredSize();
		cel_coordenador.setBounds(600, 430, sizeCel.width, sizeCel.height);

		PlanodeFundo.add(atividade = new JLabel("Atividades Desenvolvidas:"));
		atividade.setFont(minhafont);
		Dimension sizeA = atividade.getPreferredSize();
		atividade.setBounds(40, 470, sizeA.width, sizeA.height);

		// TextField
		PlanodeFundo.add(tgrupo = new JTextField(""));
		tgrupo.setBounds(160, 195, 630, 30);
		tgrupo.setFont(minhafont2);

		PlanodeFundo.add(tfundacao = new  JFormattedTextField());
		tfundacao.setBounds(980, 195, 250, 30);
		tfundacao.setFont(minhafont2);
		try {
			maskFundacao.setMask("        ##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		maskFundacao.install(tfundacao);

		PlanodeFundo.add(tidentidade = new JTextField(""));
		tidentidade.setBounds(720, 235, 510, 30);
		tidentidade.setFont(minhafont2);

		PlanodeFundo.add(tdiasDeEncontro = new JTextField(""));
		tdiasDeEncontro.setBounds(320, 275, 220, 30);
		tdiasDeEncontro.setFont(minhafont2);

		PlanodeFundo.add(tHorarioDeEncontro = new JFormattedTextField());
		tHorarioDeEncontro.setBounds(680, 275, 150, 30);
		tHorarioDeEncontro.setFont(minhafont2);
		try {
			maskHora.setMask("       ##:##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		maskHora.install(tHorarioDeEncontro);

		PlanodeFundo.add(tlocal = new JTextField(""));
		tlocal.setBounds(950, 275, 280, 30);
		tlocal.setFont(minhafont2);

		PlanodeFundo.add(tbairro = new JTextField(""));
		tbairro.setBounds(270, 315, 400, 30);
		tbairro.setFont(minhafont2);

		PlanodeFundo.add(tcomunidade = new JTextField(""));
		tcomunidade.setBounds(910, 315, 320, 30);
		tcomunidade.setFont(minhafont2);

		PlanodeFundo.add(tentidade = new JTextField(""));
		tentidade.setBounds(200, 355, 260, 30);
		tentidade.setFont(minhafont2);

		PlanodeFundo.add(tresponsavel = new JTextField(""));
		tresponsavel.setBounds(690, 355, 250, 30);
		tresponsavel.setFont(minhafont2);

		PlanodeFundo.add(ttel_responsavel = new  JFormattedTextField());
		ttel_responsavel.setBounds(1110, 355, 120, 30);
		ttel_responsavel.setFont(minhafont2);
		try {
			maskTelefone.setMask("(##)####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		maskTelefone.install(ttel_responsavel);

		PlanodeFundo.add(tcoordenador = new JTextField(""));
		tcoordenador.setBounds(400, 395, 330, 30);
		tcoordenador.setFont(minhafont2);

		PlanodeFundo.add(temail = new JTextField(""));
		temail.setBounds(870, 395, 360, 30);
		temail.setFont(minhafont2);

		PlanodeFundo.add(tfacebook = new JTextField(""));
		tfacebook.setBounds(210, 435, 360, 30);
		tfacebook.setFont(minhafont2);

		PlanodeFundo.add(tcel_coordenador = new  JFormattedTextField());
		tcel_coordenador.setBounds(760, 435, 200, 30);
		tcel_coordenador.setFont(minhafont2);
		try {
			maskTelefone2.setMask("(##)####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		maskTelefone2.install(tcel_coordenador);

		PlanodeFundo.add(tatividade = new TextArea(""));
		tatividade.setBounds(440, 475, 790, 80);
		tatividade.setFont(minhafont2);

		// Inserção de Botões

		// Botão Atualizar

		PlanodeFundo.add(cadastrar = new JButton("Atualizar"));
		botao2 = new JLabel(new ImageIcon("Imagens/btcadastrar.png"));
		cadastrar.add(botao2);
		botao2.setBounds(1, 1, 298, 48);
		cadastrar.setBounds(330, 600, 300, 50);
		cadastrar.setLayout(null);

		// Botão Voltar

		PlanodeFundo.add(voltar = new JButton("voltar"));
		botao3 = new JLabel(new ImageIcon("Imagens/btvoltar2.png"));
		voltar.add(botao3);
		botao3.setBounds(1, 1, 298, 48);
		voltar.setBounds(680, 600, 300, 50);
		voltar.setLayout(null);

		ControleCadastrar c = new ControleCadastrar();
		cadastrar.addActionListener(c);
		voltar.addActionListener(c);
	}

}
