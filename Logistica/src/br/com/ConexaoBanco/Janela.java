package br.com.ConexaoBanco;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Janela {

	protected JFrame JFrameTelaInicial;	
	public static Point point = new Point();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela window = new Janela();
					window.JFrameTelaInicial.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Janela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrameTelaInicial = new JFrame();
		JFrameTelaInicial.setTitle("Tela Inicial");
		JFrameTelaInicial.setIconImage(Toolkit.getDefaultToolkit().getImage(Janela.class.getResource("/resources/images/iconeprincipal35x40.png")));
		JFrameTelaInicial.setUndecorated(true);
		JFrameTelaInicial.setResizable(false);
		JFrameTelaInicial.setBounds(100, 100, 520, 500);
		JFrameTelaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrameTelaInicial.getContentPane().setLayout(null);			
		
		//teste para GIT!!!
		
		JMenuBar menuPrincipalSuperior = new JMenuBar();
		menuPrincipalSuperior.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		menuPrincipalSuperior.setBounds(0, 40, 520, 35);
		JFrameTelaInicial.getContentPane().add(menuPrincipalSuperior);
		
		JMenu menuArquivo = new JMenu("Arquivo");
		menuPrincipalSuperior.add(menuArquivo);
		
		JMenuItem itemSalvar = new JMenuItem("Salvar");
		menuArquivo.add(itemSalvar);
		
		JMenuItem itemSair = new JMenuItem("Sair");
		menuArquivo.add(itemSair);
		
		JMenu menuEditar = new JMenu("Editar");
		menuPrincipalSuperior.add(menuEditar);
		
		JMenuItem itemCadastrar = new JMenuItem("Cadastrar");
		
		menuEditar.add(itemCadastrar);
		
		JMenuItem itemAtualizar = new JMenuItem("Atualizar");
		menuEditar.add(itemAtualizar);
		
		JMenuItem itemExcluir = new JMenuItem("Excluir");
		menuEditar.add(itemExcluir);
		
		JMenuItem itemListar = new JMenuItem("Listar");
		
		menuEditar.add(itemListar);
		
		JPanel painelDaBarraSuperior = new JPanel();
		painelDaBarraSuperior.setLayout(null);
		painelDaBarraSuperior.setBackground(Color.WHITE);
		painelDaBarraSuperior.setBounds(0, 0, 520, 40);
		JFrameTelaInicial.getContentPane().add(painelDaBarraSuperior);
		
		JButton botaoFechar = new JButton("");		
		botaoFechar.setIcon(new ImageIcon(Janela.class.getResource("/resources/images/botaoFecharok.png")));
		botaoFechar.setOpaque(false);
		botaoFechar.setBorder(null);
		botaoFechar.setBounds(485, 0, 35, 40);
		painelDaBarraSuperior.add(botaoFechar);
		
		JButton botaoMaximizar = new JButton("");
		botaoMaximizar.setIcon(new ImageIcon(Janela.class.getResource("/resources/images/botaoMaximizar_35x40.jpg")));
		botaoMaximizar.setOpaque(false);
		botaoMaximizar.setBorder(null);
		botaoMaximizar.setBounds(450, 0, 35, 40);
		painelDaBarraSuperior.add(botaoMaximizar);
		
		JButton botaoMinimizar = new JButton("");
		botaoMinimizar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		botaoMinimizar.setIcon(new ImageIcon(Janela.class.getResource("/resources/images/botaoMinimizarok.png")));
		botaoMinimizar.setOpaque(false);
		botaoMinimizar.setBorder(null);
		botaoMinimizar.setBounds(415, 0, 35, 40);
		painelDaBarraSuperior.add(botaoMinimizar);
		
		JLabel labelIconeDaBarraSuperior = new JLabel("");
		labelIconeDaBarraSuperior.setIcon(new ImageIcon(Janela.class.getResource("/resources/images/iconeprincipal35x40.png")));
		labelIconeDaBarraSuperior.setBounds(0, 0, 35, 40);
		painelDaBarraSuperior.add(labelIconeDaBarraSuperior);
		
		JLabel labelTituloBarraSuperior = new JLabel("Tela Inicial");
		labelTituloBarraSuperior.setFont(new Font("Calibri", Font.PLAIN, 15));
		labelTituloBarraSuperior.setBounds(45, 11, 201, 19);
		painelDaBarraSuperior.add(labelTituloBarraSuperior);
			
			painelDaBarraSuperior.addMouseListener(new MouseAdapter() {
				
			      public void mousePressed(MouseEvent e) {
			    	  
			        point.x = e.getX();
			        point.y = e.getY();
			      }
			    });
			
			painelDaBarraSuperior.addMouseMotionListener(new MouseMotionAdapter() {
			      public void mouseDragged(MouseEvent e) {
			        Point p = JFrameTelaInicial.getLocation();
			        JFrameTelaInicial.setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
			      }
			    });
			
			botaoFechar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					System.exit(0);
				}
			});
			
			itemCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {	
					
					PainelCadastro cadastro = new PainelCadastro();
					JFrameTelaInicial.getContentPane().add(cadastro.painelDeCadastro);
					cadastro.painelDeCadastro.setVisible(true);
					
					labelTituloBarraSuperior.setText("Cadastro de Pessoal");
					JFrameTelaInicial.setTitle("Cadastro de Pessoal");
					
					
				}
			});
			
			itemListar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					PainelListar painelListar = new PainelListar();
					JFrameTelaInicial.getContentPane().add(painelListar.painelDeListagem);
					painelListar.painelDeListagem.setVisible(true);
					
					labelTituloBarraSuperior.setText("Listagem de Dados na Planilha");
					JFrameTelaInicial.setTitle("Listagem de Dados na Planilha");
					
				}
			});			
			
	
	}
}
