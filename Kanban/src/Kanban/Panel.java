package Kanban;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.text.JTextComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;

@SuppressWarnings("serial")
public class Panel extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JComboBox<State> comboBox;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_1;
	private void clean() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		comboBox_1.setSelectedIndex(0);
		textField_3.setText("");
		textField_4.setText("");
	}
	private void isEmpty(String message, JTextComponent text)
		throws EmptyComponentException{
		if("".equals(text.getText().trim())){
			throw new EmptyComponentException(message, text);
		}
	}
	private void verify() throws EmptyComponentException{
		isEmpty("Titulo vacio!!",textField);
		isEmpty("Descripcion vacia!!",textField_1);
		isEmpty("Categoria vacio!!",textField_2);
		isEmpty("Dueño vacio!!",textField_3);
	}
	/**
	 * Create the panel.
	 */
	public Panel() {
		getContentPane().setLayout(null);
		
		JLabel lblTarea = new JLabel("Tarea");
		lblTarea.setBounds(200, 12, 55, 16);
		getContentPane().add(lblTarea);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setBounds(29, 74, 55, 16);
		getContentPane().add(lblTtulo);
		
		textField = new JTextField();
		textField.setBounds(112, 72, 445, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Descripci\u00F3n:");
		lblNewLabel.setBounds(29, 115, 71, 16);
		getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(112, 113, 445, 136);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(29, 263, 55, 16);
		getContentPane().add(lblEstado);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa:");
		lblCategora.setBounds(29, 291, 71, 16);
		getContentPane().add(lblCategora);
		
		JLabel lblPrioridad = new JLabel("Prioridad:");
		lblPrioridad.setBounds(29, 319, 71, 16);
		getContentPane().add(lblPrioridad);
		
		JLabel lblPropietario = new JLabel("Propietario:");
		lblPropietario.setBounds(29, 347, 71, 16);
		getContentPane().add(lblPropietario);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(29, 375, 55, 16);
		getContentPane().add(lblFecha);
		
		textField_2 = new JTextField();
		textField_2.setBounds(112, 289, 445, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(112, 345, 445, 20);
		getContentPane().add(textField_3);
		
		
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					verify();
				} catch (EmptyComponentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					return;
				}
				JOptionPane.showConfirmDialog(null, "Desea agregar los datos?");
				
				String titulo = textField.getText();
				Task tarea = new Task(titulo);
				tarea.setDescription(textField_1.getText());
				Category c = new Category();
				c.setDescription(textField_2.getText());
				tarea.setCategory(c);
				tarea.setState(comboBox.getItemAt(comboBox.getSelectedIndex()));
				tarea.setPriority(Short.parseShort(comboBox_1.getSelectedItem().toString()));
				tarea.setOwner(textField_3.getText());
				Date date = new Date();
				tarea.setCreateDate(date);
				Calendar cal = Calendar.getInstance();  
				cal.setTime(date);  
				int foo = Integer.parseInt(textField_4.getText());
				cal.add(Calendar.DATE, foo); // add number of days
				date = cal.getTime();
				tarea.setDueDate(date);
				Program.dashboard.add(tarea);
				clean();
			}
		});
		btnNewButton.setBounds(112, 405, 143, 56);
		getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	
			}
		});
		btnCancelar.setBounds(414, 405, 143, 56);
		getContentPane().add(btnCancelar);
		
		comboBox = new JComboBox<State>(State.values());
		comboBox.setToolTipText("");
		comboBox.setBounds(112, 259, 445, 25);
		getContentPane().add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox_1.setBounds(112, 315, 445, 25);
		getContentPane().add(comboBox_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(112, 373, 445, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		textField_4.setText("Rango de dias");
			
		
		
		
	}
		public static void main(String[] args){
		JFrame labelFrame2=new Panel();
		labelFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		labelFrame2.setSize(600,600);
		labelFrame2.setVisible(true);
	}
}



