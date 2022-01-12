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
import Controle.ControleFechaContatosGeral;

public class CadastrarContatosGeral extends JFrame {

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

	Font f;
	Font f2;
	Font f3;
	Font f4;

	/* BUT�ES */
	public static JButton confirmar;
	public static JButton voltar;

	/* Nomes dos But�es */

	public static JLabel imagemBotao;

	/* LABELS DE TEXTOS */

	public static JLabel nome;
	public static JLabel email;
	public static JLabel telefone;
	public static JLabel lotacao;
	public static JLabel matricula;
	public static JLabel funcao;
	public static JLabel facebook;

	/* JTEXTFIELDS CAMPOS DE TEXTOS */

	public static JTextField campoNome;
	public static JTextField campoEmail;
	public static JFormattedTextField campoTelefone;
	public static JFormattedTextField campoMatricula;
	public static JTextField campoFuncao;
	public static JTextField campoFacebook;

	/* JCOMBOBOX PARA SELECIONAR LOTA��O */
	public static JComboBox<String> comboLotacao;

	/* MASCARA DE FORMATOS */
	public static MaskFormatter maskCampoTelefone;
	public static MaskFormatter maskCampoMatricula;

	/***
	 * METODO CONSTRUTOR
	 * 
	 * @throws ParseException
	 ****/
	public CadastrarContatosGeral() {
		Container c = getContentPane();
		setLayout(null);
		tela = this;
		setSize(1200, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		ControleFechaContatosGeral fechar = new ControleFechaContatosGeral();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(fechar);

		f = new Font("Eras Bold ITC", Font.BOLD, 26);
		f2 = new Font("Eras Bold ITC", Font.BOLD, 28);
		f3 = new Font("arial", Font.PLAIN, 25);
		f4 = new Font("Eras Bold ITC", Font.BOLD, 24);

		maskCampoTelefone = new MaskFormatter();
		maskCampoMatricula = new MaskFormatter();

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

		/* T�TULOS ENTRE BARRAS */
		imagemFundo.add(titulo = new JLabel("Cadastrar Outros Contatos"));
		titulo.setBounds(440, 40, 500, 50);
		titulo.setFont(f);

		imagemFundo.add(tituloComplemento = new JLabel(
				"Sistema de Gest�o - Coordenadoria de Juventude"));
		tituloComplemento.setBounds(240, 80, 800, 50);
		tituloComplemento.setFont(f);

		imagemFundo.add(tituloBaixo = new JLabel("Prefeitura de Maranguape"));
		tituloBaixo.setBounds(370, 595, 500, 50);
		tituloBaixo.setFont(f);

		/* BUT�ES */
		imagemFundo.add(confirmar = new JButton());
		confirmar.setLayout(null);
		confirmar.setBounds(320, 500, 300, 50);
		imagemBotao = new JLabel(new ImageIcon("Imagens/btcadastrar.png"));
		imagemBotao.setBounds(1, 1, 300, 48);
		confirmar.add(imagemBotao);

		imagemFundo.add(voltar = new JButton());
		voltar.setLayout(null);
		voltar.setBounds(650, 500, 300, 50);
		imagemBotao = new JLabel(new ImageIcon("Imagens/btvoltar2.png"));
		imagemBotao.setBounds(0, 1, 300, 48);
		voltar.add(imagemBotao);

		/* JLABELS TEXTOS */

		imagemFundo.add(nome = new JLabel("*Nome: "));
		nome.setBounds(40, 205, 330, 30);
		nome.setFont(f2);

		imagemFundo.add(email = new JLabel("*E-mail: "));
		email.setBounds(40, 255, 330, 30);
		email.setFont(f2);

		imagemFundo.add(telefone = new JLabel("*Telefone: "));
		telefone.setBounds(40, 305, 330, 30);
		telefone.setFont(f2);

		imagemFundo.add(lotacao = new JLabel("*Categoria: "));
		lotacao.setBounds(40, 355, 330, 30);
		lotacao.setFont(f2);

		imagemFundo.add(funcao = new JLabel("*Fun��o: "));
		funcao.setBounds(40, 405, 330, 30);
		funcao.setFont(f2);

		imagemFundo.add(facebook = new JLabel("*Facebook: "));
		facebook.setBounds(40, 455, 330, 30);
		facebook.setFont(f2);

		/* CAMPOS DE DIGITA��O */

		imagemFundo.add(campoNome = new JTextField());
		campoNome.setBounds(250, 205, 820, 30);
		campoNome.setFont(f3);

		imagemFundo.add(campoEmail = new JTextField());
		campoEmail.setBounds(250, 255, 420, 30);
		campoEmail.setFont(f3);

		imagemFundo.add(campoTelefone = new JFormattedTextField());
		campoTelefone.setBounds(250, 305, 420, 30);
		campoTelefone.setFont(f3);

		try {
			maskCampoTelefone.setMask("(##)####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		maskCampoTelefone.install(campoTelefone);

		imagemFundo.add(campoFuncao = new JTextField());
		campoFuncao.setBounds(250, 405, 320, 30);
		campoFuncao.setFont(f3);

		imagemFundo.add(campoFacebook = new JFormattedTextField());
		campoFacebook.setBounds(250, 455, 420, 30);
		campoFacebook.setFont(f3);

		/* COMBO BOX DA LOTA��O */
		imagemFundo.add(comboLotacao = new JComboBox<String>());
		comboLotacao.setBounds(250, 355, 820, 30);
		comboLotacao.setFont(f3);
		comboLotacao.addItem("");
		comboLotacao.addItem("Gr�mio Estudantil Anchieta");
		comboLotacao.addItem("Gr�mio Estudantil Ant�nio Luiz Coelho");
		comboLotacao.addItem("Gr�mio Estudantil Ant�nio Marques");
		comboLotacao.addItem("Gr�mio Estudantil CAIC Senador Carlos Jereissati");
		comboLotacao.addItem("Gr�mio Estudantil Clovis Monteiro");
		comboLotacao.addItem("Gr�mio Estudantil Conego Heitor");
		comboLotacao.addItem("Gr�mio Estudantil E.M Francsica Rocha Magalh�es");
		comboLotacao.addItem("Gr�mio Estudantil E.E.M. Luiz Gir�o");
		comboLotacao.addItem("Gr�mio Estudantil EEEP Santa Rita");
		comboLotacao.addItem("Gr�mio Estudantil Eunice Weaver");
		comboLotacao.addItem("Gr�mio Estudantil Jo�o Cirino");
		comboLotacao.addItem("Gr�mio Estudantil Jos� Fernades Vieira");
		comboLotacao.addItem("Gr�mio Estudantil Manoel Rodrigues");
		comboLotacao.addItem("Gr�mio Estudantil Nilo Campelo");
		comboLotacao.addItem("Gr�mio Estudantil Rio Grande do Norte");
		comboLotacao.addItem("Gr�mio Estudantil Ant�nio Marques");
		comboLotacao.addItem("SoftWay");

	
		ControleCadastrar f = new ControleCadastrar();
		confirmar.addActionListener(f);
		voltar.addActionListener(f);
	}

}
