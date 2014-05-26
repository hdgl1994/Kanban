package Kanban;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class EmptyComponentException extends Exception{
	
	private JComponent component;
	
	public JComponent getComponent(){
		return component;
	}
	
	public EmptyComponentException(String message, JComponent component){
		super(message);
		JOptionPane.showMessageDialog(null, message);
	this.component = component;
	}
}
