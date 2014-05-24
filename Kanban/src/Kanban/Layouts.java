package Kanban;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;


public class Layouts extends JFrame{
	private JButton btnAdd;
	private JButton btnCan;
	private JTextField txtitle;
	private JTextField txdesc;
	private JComboBox cbstate;
	private JTextField txcatego;
	private JComboBox priority;
	private JTextField txprop;

	public Layouts(String title){
		super(title);

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.gridx=0;
		gc.gridy=0;
		add(new JLabel("Título: "),gc);
		gc.gridx=1;
		gc.gridy=0;
		txtitle= new JTextField();
		txtitle.setPreferredSize(new Dimension(130,25));
		add(txtitle,gc);

		gc.gridx=0;
		gc.gridy=1;
		add(new JLabel("Descripción: "),gc);
		gc.gridx=1;
		gc.gridy=2;
		txdesc= new JTextField();
		txdesc.setPreferredSize(new Dimension(130,200));
		add(txdesc,gc);

		gc.gridx=0;
		gc.gridy=3;
		add(new JLabel("Estado: "),gc);
		gc.gridx=1;
		gc.gridy=3;
		String [] states = {"BACKLOG", "DO_TO", "IN_PROGRESS", "DONE"};
		cbstate= new JComboBox<String>(states);
		cbstate.setPreferredSize(new Dimension(130,25));
		add(cbstate,gc);

		gc.gridx=0;
		gc.gridy=4;
		add(new JLabel("Categoría: "),gc);
		gc.gridx=1;
		gc.gridy=4;
		txcatego= new JTextField();
		txcatego.setPreferredSize(new Dimension(130,25));
		add(txcatego,gc);

		gc.gridx=0;
		gc.gridy=5;
		add(new JLabel("Prioridad: "),gc);
		gc.gridx=1;
		gc.gridy=5;
		Integer [] priorities = {1,2,3,4,5,6,7,8,9,10};
		priority= new JComboBox<Integer>(priorities);
		priority.setPreferredSize(new Dimension(130,25));
		add(priority,gc);

		gc.gridx=0;
		gc.gridy=6;
		add(new JLabel("Propietario: "),gc);
		gc.gridx=1;
		gc.gridy=6;
		txprop= new JTextField();
		txprop.setPreferredSize(new Dimension(130,25));
		add(txprop,gc);

		gc.gridx=0;
		gc.gridy=7;
		btnAdd = new JButton ("Add");
		btnAdd.addActionListener(new ConfirmationAction());
		add(btnAdd,gc);
		gc.gridx=1;
		gc.gridy=7;
		btnCan = new JButton ("Cancel");
		btnCan.addActionListener(new CancelAction());
		add(btnCan,gc);


	}

	private void addListener() {
		btnAdd.addActionListener(new ConfirmationAction());
		btnCan.addActionListener(new CancelAction());
	}

	private void isEmpty (String message, JTextComponent text) throws EmptyComponentException
	{
			if("".equals(text.getText().trim()))
			{
				throw new EmptyComponentException(message, text);
			}
	}

	private void verify() throws Exception{
		isEmpty("Titulo vacio",txtitle);
		isEmpty("Descripción vacio",txdesc);
		isEmpty("Categoría vacio",txcatego);
		isEmpty("Propietario vacio",txprop);
	}

	private void clean()
	{
		txcatego.setText("");
		txdesc.setText("");
		txprop.setText("");
		txtitle.setText("");
	}

	private class ConfirmationAction implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String title = txtitle.getText();
			String descr = txdesc.getText();
			String categ = txcatego.getText();
			String owner = txprop.getText();
			JOptionPane.showConfirmDialog(null,"Agregaras los datos, continuar?");
			try
			{
				verify();
				Task tarea = new Task(title);
				tarea.setTitle(title);
				tarea.setDescription(descr);
				tarea.setCategory(categ);
				tarea.setOwner(owner);
				Program.dashboard.add(tarea);
				JOptionPane.showMessageDialog(null, "Tarea agregada");
				clean();
			}catch (Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex.getMessage(),"Error de Validación",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	private class CancelAction implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			dispose();
		}
	}

	public static void main(String[] args){

		JFrame labelFrame2=new Layouts("Agregar");
		labelFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		labelFrame2.setSize(320,500);
		labelFrame2.setVisible(true);
	}
}