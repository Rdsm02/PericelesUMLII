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

	protected JFrame jFrameTelaInicial;	
	public static Point point = new Point();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela window = new Janela();
					window.jFrameTelaInicial.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Janela() {
		initialize();
	}
	
	private void initialize() {
		jFrameTelaInicial = new JFrame();
		jFrameTelaInicial.setTitle("Tela Inicial");
		jFrameTelaInicial.setIconImage(Toolkit.getDefaultToolkit().getImage(Janela.class.getResource("/resources/images/iconeprincipal35x40.png")));
		jFrameTelaInicial.setUndecorated(true);
		jFrameTelaInicial.setResizable(false);
		jFrameTelaInicial.setBounds(100, 100, 520, 500);
		jFrameTelaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrameTelaInicial.setLocationRelativeTo(null);
		jFrameTelaInicial.getContentPane().setLayout(null);
		
		JMenuBar menuPrincipalSuperior = new JMenuBar();
		menuPrincipalSuperior.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		menuPrincipalSuperior.setBounds(0, 40, 520, 35);
		jFrameTelaInicial.getContentPane().add(menuPrincipalSuperior);
		
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
		jFrameTelaInicial.getContentPane().add(painelDaBarraSuperior);
		
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
			        Point p = jFrameTelaInicial.getLocation();
			        jFrameTelaInicial.setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
			      }
			    });
			
			itemSair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					System.exit(0);
					
				}
			});
			
			botaoFechar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					System.exit(0);
				}
			});
			
			botaoMinimizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					jFrameTelaInicial.setExtendedState(JFrame.ICONIFIED);
					
				}
			});
			
			itemCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {						
					jFrameTelaInicial.dispose();					
					initialize();
					jFrameTelaInicial.setVisible(true);
					
					PainelCadastro cadastro = new PainelCadastro();
					jFrameTelaInicial.getContentPane().add(cadastro.painelDeCadastro);
					cadastro.painelDeCadastro.setVisible(true);
					
					labelTituloBarraSuperior.setText("Cadastro de Pessoal");
					jFrameTelaInicial.setTitle("Cadastro de Pessoal");					
				}
			});
			
			itemListar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {					
					jFrameTelaInicial.dispose();					
					initialize();
					jFrameTelaInicial.setVisible(true);
					
					PainelListar painelListar = new PainelListar();
					jFrameTelaInicial.getContentPane().add(painelListar.painelDeListagem);
					painelListar.painelDeListagem.setVisible(true);
					
					labelTituloBarraSuperior.setText("Listagem de Dados na Planilha");
					jFrameTelaInicial.setTitle("Listagem de Dados na Planilha");					
				}
			});	
			
			itemAtualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {					
					jFrameTelaInicial.dispose();					
					initialize();
					jFrameTelaInicial.setVisible(true);
					
					PainelAtualizar painelAtualizar = new PainelAtualizar();
					jFrameTelaInicial.getContentPane().add(painelAtualizar.painelDeAtualizacao);
					painelAtualizar.painelDeAtualizacao.setVisible(true);
					
					labelTituloBarraSuperior.setText("Atualização de Dados na Planilha");
					jFrameTelaInicial.setTitle("Atualização de Dados na Planilha");					
				}
			});
			
			itemExcluir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jFrameTelaInicial.dispose();					
					initialize();
					jFrameTelaInicial.setVisible(true);
					
					PainelExcluir painelExcluir = new PainelExcluir();
					jFrameTelaInicial.getContentPane().add(painelExcluir.painelDeExclusao);
					painelExcluir.painelDeExclusao.setVisible(true);
					
					labelTituloBarraSuperior.setText("Exclusão de Dados na Planilha");
					jFrameTelaInicial.setTitle("Exclusão de Dados na Planilha");					
				}
			});
			
	
	}
}
