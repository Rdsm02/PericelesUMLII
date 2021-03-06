package br.com.ConexaoBanco;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class PainelAtualizar {	
	protected JTextField campoNome;
	protected JTextField campoQuantidade;
	protected JPanel painelDeAtualizacao;
	//teste git ooo
	public PainelAtualizar() {	
		
		TelaAtualizar();
	}
	
	public void TelaAtualizar(){		
		
		painelDeAtualizacao = new JPanel();	
		painelDeAtualizacao.setBounds(50, 128, 420, 290);
		
		JLabel lblAtualizar = new JLabel("Atualiza\u00E7\u00E3o de Informa\u00E7\u00F5es");
		lblAtualizar.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Calibri", Font.PLAIN, 15));
		
		JLabel labelQuantidade = new JLabel("Quantidade:");
		labelQuantidade.setFont(new Font("Calibri", Font.PLAIN, 15));
		
		campoNome = new JTextField();
		campoNome.setColumns(10);
		campoNome.setText("*");
		
		campoQuantidade = new JTextField();
		campoQuantidade.setColumns(10);
		campoQuantidade.setText("*");
		
		JButton btnAtualizar = new JButton("Atualizar");
		
		JButton btnLimpar = new JButton("Limpar");
				
		
			btnAtualizar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					System.out.println("Campo nome:" + campoNome.getText() + "Campo quantidade:" + campoQuantidade.getText());
					
					if(campoNome.getText() == "" || campoQuantidade.getText() == ""){
						
						JOptionPane.showMessageDialog(painelDeAtualizacao, "Preencha todos os campos!", "Um ou mais campos vazios", JOptionPane.ERROR_MESSAGE, null);
						
					}else{
					
					Connection connection = ConexaoMySQL.getConexaoMySQL();
					String sql= "update material set quantidade = ? where nome = ?";
					PreparedStatement smtp;
					
					try {
						smtp = connection.prepareStatement(sql);
						smtp.setString(1, campoQuantidade.getText());
						smtp.setString(2, campoNome.getText());						
						smtp.execute();	
						smtp.close();//
						connection.close();
						int opcao = JOptionPane.showConfirmDialog(painelDeAtualizacao, "Quantidade de Material Atualizada com Sucesso!\n\nDeseja Atualizar outro Material e limpar os campos escritos?\n");
						System.out.println(opcao);
						if(opcao == 0){
							campoNome.setText("");
							campoQuantidade.setText("");
							
						}else if(opcao == 1){
							
							
						}
						
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					
				}
				}
			});
			
				btnLimpar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						campoNome.setText("");
						campoQuantidade.setText("");					
					}
				});		
				
				//===[M�todo para Consertar Layout]===
				
				GroupLayout gl_painelDeAtualizacao = new GroupLayout(painelDeAtualizacao);
				gl_painelDeAtualizacao.setHorizontalGroup(
					gl_painelDeAtualizacao.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painelDeAtualizacao.createSequentialGroup()
							.addGap(94)
							.addGroup(gl_painelDeAtualizacao.createParallelGroup(Alignment.LEADING)
								.addComponent(labelQuantidade, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_painelDeAtualizacao.createSequentialGroup()
									.addGap(77)
									.addComponent(campoQuantidade, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_painelDeAtualizacao.createSequentialGroup()
							.addGap(74)
							.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(104)
							.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_painelDeAtualizacao.createSequentialGroup()
							.addGap(94)
							.addGroup(gl_painelDeAtualizacao.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAtualizar)
								.addGroup(gl_painelDeAtualizacao.createSequentialGroup()
									.addComponent(lblNome)
									.addGap(2)
									.addComponent(campoNome, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)))
							.addGap(91))
				);
				gl_painelDeAtualizacao.setVerticalGroup(
					gl_painelDeAtualizacao.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painelDeAtualizacao.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAtualizar)
							.addGap(35)
							.addGroup(gl_painelDeAtualizacao.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_painelDeAtualizacao.createSequentialGroup()
									.addGap(1)
									.addComponent(lblNome))
								.addComponent(campoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(57)
							.addGroup(gl_painelDeAtualizacao.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_painelDeAtualizacao.createSequentialGroup()
									.addGap(1)
									.addComponent(labelQuantidade))
								.addComponent(campoQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(65)
							.addGroup(gl_painelDeAtualizacao.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAtualizar)
								.addComponent(btnLimpar)))
				);
				painelDeAtualizacao.setLayout(gl_painelDeAtualizacao);
		
	}
}
