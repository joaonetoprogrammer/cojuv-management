package Visao.Cadastrar;

import java.awt.Container;
import java.awt.Font;
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
import Controle.ControleFecharServidorTerceirizado;

public class CadastrarServidorTerceirizado extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JLabel titulo;
	public static JLabel tituloComplemento;
	public static JLabel tituloBaixo;
	public static JFrame tela;

	/* LABELS DE IMAGENS */
	public static JLabel imagemFundo;
	public static JLabel primeiraBarra;
	public static JLabel primeiraBarra2;

	public static JLabel segundaBarra;
	public static JLabel segundaBarra2;

	public static JLabel agenda;
	public static JLabel logo;

	public static JLabel botao;

	Font f;
	Font f2;
	Font f3;
	Font f4;

	/* BUTÕES */
	public static JButton confirmar;
	public static JButton voltar;

	/* LABELS DE TEXTOS */
	public static JLabel empresaTercerizada;
	public static JLabel nome;
	public static JLabel email;
	public static JLabel telefone;
	public static JLabel lotacao;
	public static JLabel matricula;
	public static JLabel funcao;
	public static JLabel facebook;

	/* JTEXTFIELDS CAMPOS DE TEXTOS */
	public static JTextField campoEmpresaTercerizada;
	public static JTextField campoNome;
	public static JTextField campoEmail;
	public static JFormattedTextField campoTelefone;
	public static JFormattedTextField campoMatricula;
	public static JTextField campoFuncao;
	public static JTextField campoFacebook;

	/* JCOMBOBOX PARA SELECIONAR LOTAÇÃO */
	public static JComboBox<String> comboLotacao;

	/* MASCARA DE FORMATOS */
	public static MaskFormatter maskCampoTelefone;

	/***
	 * METODO CONSTRUTOR
	 * 
	 * @throws ParseException
	 ****/
	public CadastrarServidorTerceirizado() {
		Container c = getContentPane();
		setLayout(null);
		tela = this;
		setSize(1200, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		ControleFecharServidorTerceirizado fechar = new ControleFecharServidorTerceirizado();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(fechar);
		maskCampoTelefone = new MaskFormatter();

		f = new Font("Eras Bold ITC", Font.BOLD, 26);
		f2 = new Font("Eras Bold ITC", Font.BOLD, 28);
		f3 = new Font("arial", Font.PLAIN, 25);
		f4 = new Font("Eras Bold ITC", Font.BOLD, 24);

		/* PLANO DE FUNDO */
		imagemFundo = new JLabel(new ImageIcon("Imagens/PlanodeFundo.jpg"));
		c.add(imagemFundo);
		imagemFundo.setBounds(0, 0, 1200, 700);
		imagemFundo.setLayout(null);

		/* IMAGENS PERSONALIZADAS */
		agenda = new JLabel(new ImageIcon("Imagens/agendaCordenadoria.png"));
		imagemFundo.add(agenda);
		agenda.setBounds(1000, 2, 170, 160);

		logo = new JLabel(new ImageIcon("Imagens/brasaomaranguape.png"));
		imagemFundo.add(logo);
		logo.setBounds(1010, 530, 150, 140);

		/* BARRAS DE IMAGENS */
		primeiraBarra = new JLabel(new ImageIcon("Imagens/primeirabarra.jpg"));
		imagemFundo.add(primeiraBarra);
		primeiraBarra.setBounds(0, 20, 1200, 25);

		primeiraBarra2 = new JLabel(new ImageIcon("Imagens/primeirabarra.jpg"));
		imagemFundo.add(primeiraBarra2);
		primeiraBarra2.setBounds(0, 130, 1200, 25);

		segundaBarra = new JLabel(new ImageIcon("Imagens/barrabaixo.jpg"));
		imagemFundo.add(segundaBarra);
		segundaBarra.setBounds(0, 590, 1200, 15);

		segundaBarra2 = new JLabel(new ImageIcon("Imagens/barrabaixo.jpg"));
		imagemFundo.add(segundaBarra2);
		segundaBarra2.setBounds(0, 640, 1200, 15);

		/* TÍTULOS ENTRE BARRAS */
		imagemFundo.add(titulo = new JLabel("Cadastrar Servidor Terceirizado"));
		titulo.setBounds(330, 40, 580, 50);
		titulo.setFont(f);

		imagemFundo.add(tituloComplemento = new JLabel(
				"Sistema de Gestão - Coordenadoria de Juventude"));
		tituloComplemento.setBounds(240, 80, 800, 50);
		tituloComplemento.setFont(f);

		imagemFundo.add(tituloBaixo = new JLabel("Prefeitura de Maranguape"));
		tituloBaixo.setBounds(380, 597, 500, 50);
		tituloBaixo.setFont(f);

		/* BUTÕES */
		imagemFundo.add(confirmar = new JButton());
		confirmar.setLayout(null);
		confirmar.setBounds(300, 490, 300, 50);
		confirmar.setFont(f);
		confirmar.setLayout(null);
		botao = new JLabel(new ImageIcon("Imagens/btcadastrar.png"));
		confirmar.add(botao);
		botao.setBounds(1, 1, 300, 48);

		imagemFundo.add(voltar = new JButton());
		voltar.setLayout(null);
		voltar.setBounds(630, 490, 300, 50);
		voltar.setFont(f);
		voltar.setLayout(null);
		botao = new JLabel(new ImageIcon("Imagens/btvoltar2.png"));
		voltar.add(botao);
		botao.setBounds(0, 1, 300, 48);

		/* JLABELS TEXTOS */

		imagemFundo.add(empresaTercerizada = new JLabel(
				"*Empresa Tercerizada: "));
		empresaTercerizada.setBounds(20, 190, 380, 30);
		empresaTercerizada.setFont(f2);

		imagemFundo.add(nome = new JLabel("*Nome: "));
		nome.setBounds(20, 235, 330, 30);
		nome.setFont(f2);

		imagemFundo.add(email = new JLabel("*E-mail: "));
		email.setBounds(20, 275, 330, 30);
		email.setFont(f2);

		imagemFundo.add(telefone = new JLabel("*Telefone: "));
		telefone.setBounds(20, 315, 330, 30);
		telefone.setFont(f2);

		imagemFundo.add(lotacao = new JLabel("*Instituição: "));
		lotacao.setBounds(20, 355, 330, 30);
		lotacao.setFont(f2);

		imagemFundo.add(matricula = new JLabel("*Matrícula: "));
		matricula.setBounds(20, 395, 330, 30);
		matricula.setFont(f2);

		imagemFundo.add(funcao = new JLabel("*Função: "));
		funcao.setBounds(560, 395, 330, 30);
		funcao.setFont(f2);

		imagemFundo.add(facebook = new JLabel("*Facebook: "));
		facebook.setBounds(20, 435, 330, 30);
		facebook.setFont(f2);

		/* CAMPOS DE DIGITAÇÃO */

		imagemFundo.add(campoEmpresaTercerizada = new JTextField());
		campoEmpresaTercerizada.setBounds(390, 195, 660, 30);
		campoEmpresaTercerizada.setFont(f3);

		imagemFundo.add(campoNome = new JTextField());
		campoNome.setBounds(230, 235, 820, 30);
		campoNome.setFont(f3);

		imagemFundo.add(campoEmail = new JTextField());
		campoEmail.setBounds(230, 275, 420, 30);
		campoEmail.setFont(f3);

		imagemFundo.add(campoTelefone = new JFormattedTextField());
		campoTelefone.setBounds(230, 315, 420, 30);
		campoTelefone.setFont(f3);
		try {
			maskCampoTelefone.setMask("(##)####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		maskCampoTelefone.install(campoTelefone);

		imagemFundo.add(campoMatricula = new JFormattedTextField());
		campoMatricula.setBounds(230, 395, 320, 30);
		campoMatricula.setFont(f3);

		imagemFundo.add(campoFuncao = new JTextField());
		campoFuncao.setBounds(730, 395, 320, 30);
		campoFuncao.setFont(f3);

		imagemFundo.add(campoFacebook = new JFormattedTextField());
		campoFacebook.setBounds(230, 435, 420, 30);
		campoFacebook.setFont(f3);

		/* COMBO BOX DA LOTAÇÃO */
		imagemFundo.add(comboLotacao = new JComboBox<String>());
		comboLotacao.setBounds(230, 355, 820, 30);
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
		ControleCadastrar f = new ControleCadastrar();
		confirmar.addActionListener(f);
		voltar.addActionListener(f);
	}

}
