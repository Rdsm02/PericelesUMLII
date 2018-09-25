package br.com.ConexaoBanco;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class PainelListar {
	protected JPanel painelDeListagem;
	private JTable table;
	private JScrollPane scrollPane;
	
	public PainelListar() {
		
		initialize();
	}

	private void initialize() {
		
		painelDeListagem = new JPanel();
		painelDeListagem.setBounds(50, 128, 420, 290);
		
		JLabel lblListagemDeDados = new JLabel("Listagem de Dados");
		lblListagemDeDados.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		
		scrollPane = new JScrollPane();
		
		
		JButton botaoListaDados = new JButton("Listar Dados");
		botaoListaDados.setFont(new Font("Calibri", Font.PLAIN, 15));
		
		JLabel labelQtdListagem = new JLabel("Quantidade de Listados:");
		labelQtdListagem.setFont(new Font("Calibri", Font.PLAIN, 15));
		
		JLabel labelNumeroQtd = new JLabel("");
		labelNumeroQtd.setFont(new Font("Calibri", Font.BOLD, 15));
		
		painelDeListagem.setVisible(false);
		
		
		botaoListaDados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int contador = 0;
				Connection connection = ConexaoMySQL.getConexaoMySQL();
				String sql = "select * from material;";
				PreparedStatement smtp;
				try {					
					smtp = connection.prepareStatement(sql);
					ResultSet rs = smtp.executeQuery(sql);
					int qtdColunas = rs.getMetaData().getColumnCount();
					DefaultTableModel tablemodel = new DefaultTableModel(new String [] {"<html><b>ID</b></html>","NOME","QUANTIDADE"}, 0);
					
					table = new JTable(tablemodel);
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					while(rs.next()){
						
						String [] dados = new String [qtdColunas];
						for(int i = 1; i <=qtdColunas; i++){
							dados[i-1] = rs.getString(i);
							contador ++;
							
						}
						dtm.addRow(dados);
					}					
					labelNumeroQtd.setText(Integer.toString(contador/3));
					scrollPane.setViewportView(table);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				
			}
		});
		
		GroupLayout gl_painelDeListagem = new GroupLayout(painelDeListagem);
		gl_painelDeListagem.setHorizontalGroup(
			gl_painelDeListagem.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelDeListagem.createSequentialGroup()
					.addGap(124)
					.addComponent(lblListagemDeDados))
				.addGroup(gl_painelDeListagem.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_painelDeListagem.createSequentialGroup()
					.addGap(10)
					.addComponent(labelQtdListagem)
					.addGap(3)
					.addComponent(labelNumeroQtd, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_painelDeListagem.createSequentialGroup()
					.addGap(156)
					.addComponent(botaoListaDados))
		);
		gl_painelDeListagem.setVerticalGroup(
			gl_painelDeListagem.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelDeListagem.createSequentialGroup()
					.addGap(11)
					.addComponent(lblListagemDeDados)
					.addGap(13)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addGroup(gl_painelDeListagem.createParallelGroup(Alignment.LEADING)
						.addComponent(labelQtdListagem)
						.addGroup(gl_painelDeListagem.createSequentialGroup()
							.addGap(2)
							.addComponent(labelNumeroQtd, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)))
					.addGap(14)
					.addComponent(botaoListaDados))
		);
		painelDeListagem.setLayout(gl_painelDeListagem);
	}

}
