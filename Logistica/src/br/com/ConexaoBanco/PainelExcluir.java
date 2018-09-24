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

public class PainelExcluir {//Jpanel	
	protected JTextField campoNome;
	protected JPanel painelDeExclusao;
	
	public PainelExcluir() {	
		
		TelaExcluir();
	}
	
	public void TelaExcluir(){		
		
		painelDeExclusao = new JPanel();	
		painelDeExclusao.setBounds(50, 128, 420, 290);
		
		JLabel lblAtualizar = new JLabel("Exclus\u00E3o de Informa\u00E7\u00F5es");
		lblAtualizar.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Calibri", Font.PLAIN, 15));
		
		campoNome = new JTextField();
		campoNome.setColumns(10);
		campoNome.setText("*");
		
		JButton btnAtualizar = new JButton("Atualizar");
				
		
			btnAtualizar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {					
					
					if(campoNome.getText() == ""){
						
						JOptionPane.showMessageDialog(painelDeExclusao, "Preencha todos os campos!", "Um ou mais campos vazios", JOptionPane.ERROR_MESSAGE, null);
						
					}else{
					
					Connection connection = ConexaoMySQL.getConexaoMySQL();
					//DELETE FROM NOME_DA_TABELA WHERE id = VALOR_DO_ID
					String sql= "delete from material where nome = ?";
					PreparedStatement smtp;
					
					try {
						smtp = connection.prepareStatement(sql);
						smtp.setString(1, campoNome.getText());						
						smtp.execute();	
						smtp.close();//
						connection.close();
						int opcao = JOptionPane.showConfirmDialog(painelDeExclusao, "Funcionario Cadastrado com Sucesso!\n\nDeseja Cadastrar Outro usuário e limpar os campos escritos?\n");
						System.out.println(opcao);
						if(opcao == 0){
							campoNome.setText("");
							
						}else if(opcao == 1){
							
							
						}
						
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					
				}
				}
			});
				
				//===[Método para Consertar Layout]===
				
				GroupLayout gl_painelDeExclusao = new GroupLayout(painelDeExclusao);
				gl_painelDeExclusao.setHorizontalGroup(
					gl_painelDeExclusao.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painelDeExclusao.createSequentialGroup()
							.addGroup(gl_painelDeExclusao.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_painelDeExclusao.createSequentialGroup()
									.addGap(171)
									.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_painelDeExclusao.createSequentialGroup()
									.addGap(94)
									.addGroup(gl_painelDeExclusao.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblAtualizar)
										.addGroup(gl_painelDeExclusao.createSequentialGroup()
											.addComponent(lblNome)
											.addGap(2)
											.addComponent(campoNome, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)))))
							.addGap(91))
				);
				gl_painelDeExclusao.setVerticalGroup(
					gl_painelDeExclusao.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painelDeExclusao.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAtualizar)
							.addGap(79)
							.addGroup(gl_painelDeExclusao.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_painelDeExclusao.createSequentialGroup()
									.addGap(1)
									.addComponent(lblNome))
								.addComponent(campoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(98)
							.addComponent(btnAtualizar)
							.addGap(33))
				);
				painelDeExclusao.setLayout(gl_painelDeExclusao);
		
	}
}
