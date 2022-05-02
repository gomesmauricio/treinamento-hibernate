package com.hibernate.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hibernate.Exercicio1.App;
import com.hibernate.Exercicio1.Usuarios;
import com.hibernate.util.HibernateUtil;

public class AdicionaUsuariosPanel extends JPanel {
	private JTextField textBuscaId;
	private JTextField textField_1;
	private App app = new App();

	/**
	 * Create the panel.
	 */
	public AdicionaUsuariosPanel() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Usuarios");
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(10, 11, 46, 14);
		add(lblNewLabel);

		textBuscaId = new JTextField();
		textBuscaId.setBounds(10, 35, 57, 20);
		add(textBuscaId);
		textBuscaId.setColumns(10);
		
		final JLabel textId = new JLabel("ID - Usuario");
		textId.setBounds(290, 38, 62, 14);
		add(textId);

		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(textBuscaId.getText());
				
				try {
					Usuarios user = app.read(id);
					textId.setText(Integer.toString(user.getId()));			
					textField_1.setText(user.getNome());
				} catch (Exception e2) {
					JOptionPane.showInternalMessageDialog(null, "Usuario não encontrado!");					
				}				
			}
		});
		btnNewButton.setBounds(77, 34, 89, 23);
		add(btnNewButton);

		textField_1 = new JTextField();
		textField_1.setBounds(77, 79, 275, 20);
		add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(10, 82, 46, 14);
		add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("Salvar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				Usuarios us = new Usuarios();
				us.setNome(textField_1.getText());
				try {
					app.create(us);
					JOptionPane.showMessageDialog(null, "Usuario Salvo com sucesso!");
				} catch (Exception e2) {
					e2.getMessage();
				}
				
			}
		});
		btnNewButton_1.setBounds(272, 110, 80, 23);
		add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton_2.setBounds(176, 110, 80, 23);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Atualizar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_3.setBounds(77, 110, 80, 23);
		add(btnNewButton_3);

	}
}
