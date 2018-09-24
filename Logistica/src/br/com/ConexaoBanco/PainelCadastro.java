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

public class PainelCadastro {//Jpanel	
	protected JTextField campoNome;
	protected JTextField campoQuantidade;
	protected JPanel painelDeCadastro;
	
	public PainelCadastro() {	
		
		TelaCadastro();
	}
	
	public void TelaCadastro(){		
		
		painelDeCadastro = new JPanel();	
		painelDeCadastro.setBounds(50, 128, 420, 290);
		
		JLabel lblCadastro = new JLabel("Cadastro");
		lblCadastro.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		
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
		
		JButton btnCadastrar = new JButton("Cadastrar");
		
		JButton btnLimpar = new JButton("Limpar");
				
		
			btnCadastrar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					System.out.println("Campo nome:" + campoNome.getText() + "Campo quantidade:" + campoQuantidade.getText());
					
					if(campoNome.getText() == "" || campoQuantidade.getText() == ""){
						
						JOptionPane.showMessageDialog(painelDeCadastro, "Preencha todos os campos!", "Um ou mais campos vazios", JOptionPane.ERROR_MESSAGE, null);
						
					}else{
					
					Connection connection = ConexaoMySQL.getConexaoMySQL();
					String sql= "insert into material values (default, ?, ?)";
					PreparedStatement smtp;
					
					try {
						smtp = connection.prepareStatement(sql);
						
						smtp.setString(1, campoNome.getText());
						smtp.setString(2, campoQuantidade.getText());
						smtp.execute();	
						smtp.close();//
						connection.close();
						int opcao = JOptionPane.showConfirmDialog(painelDeCadastro, "Funcionario Cadastrado com Sucesso!\n\nDeseja Cadastrar Outro usuário e limpar os campos escritos?\n");
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
				
				//===[Método para Consertar Layout]===
				
				GroupLayout gl_painelDeCadastro = new GroupLayout(painelDeCadastro);
				gl_painelDeCadastro.setHorizontalGroup(
					gl_painelDeCadastro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painelDeCadastro.createSequentialGroup()
							.addGap(168)
							.addComponent(lblCadastro))
						.addGroup(gl_painelDeCadastro.createSequentialGroup()
							.addGap(94)
							.addComponent(lblNome)
							.addGap(2)
							.addComponent(campoNome, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_painelDeCadastro.createSequentialGroup()
							.addGap(94)
							.addGroup(gl_painelDeCadastro.createParallelGroup(Alignment.LEADING)
								.addComponent(labelQuantidade, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_painelDeCadastro.createSequentialGroup()
									.addGap(77)
									.addComponent(campoQuantidade, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_painelDeCadastro.createSequentialGroup()
							.addGap(74)
							.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(104)
							.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
				);
				gl_painelDeCadastro.setVerticalGroup(
					gl_painelDeCadastro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painelDeCadastro.createSequentialGroup()
							.addGap(11)
							.addComponent(lblCadastro)
							.addGap(35)
							.addGroup(gl_painelDeCadastro.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_painelDeCadastro.createSequentialGroup()
									.addGap(1)
									.addComponent(lblNome))
								.addComponent(campoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(57)
							.addGroup(gl_painelDeCadastro.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_painelDeCadastro.createSequentialGroup()
									.addGap(1)
									.addComponent(labelQuantidade))
								.addComponent(campoQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(65)
							.addGroup(gl_painelDeCadastro.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCadastrar)
								.addComponent(btnLimpar)))
				);
				painelDeCadastro.setLayout(gl_painelDeCadastro);
		
	}
}
