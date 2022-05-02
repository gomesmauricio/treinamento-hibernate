package com.hibernate.view;

import java.awt.BorderLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hibernate.Exercicio1.App;
import com.hibernate.Exercicio1.Usuarios;

public class ListaUsuariosPanel extends JPanel {
	
	private JTable table;
	private App io = new App();

	/**
	 * Create the panel.
	 */
	public ListaUsuariosPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scroll = new JScrollPane();
//		scroll.setBounds(10, 11, 430, 278);
//		add(scroll);
		
//		table = new JTable();
//		scroll.setViewportView(table);


		table = new JTable(getDataColumns(), getNameColumns());
//		  JScrollPane scroll = new JScrollPane(table);
		  add(scroll, BorderLayout.CENTER);

	}
	
	private Vector<String> getNameColumns(){
		  Vector<String> nameColumns = new Vector<String>();
		  nameColumns.add("Id");
		  nameColumns.add("Nome");
	
		  return nameColumns;
		}
	
	public void addNewRow(Object[] valores){
		  ((DefaultTableModel)table.getModel()).addRow(valores);
		}
	
	private Vector<Vector<Object>> getDataColumns(){
		  App io = new App();
		  Vector<Vector<Object>> dataColumns = null;

		  try {
//		   dataColumns = io.getUsuarios();
		  }catch(Exception ex){
		   JOptionPane.showMessageDialog(null, "ERRO", ex.getMessage(),
		   JOptionPane.ERROR_MESSAGE);
		  }

		  return dataColumns;
		}
}
