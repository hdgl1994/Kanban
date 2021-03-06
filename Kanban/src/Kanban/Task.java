package Kanban;

import java.util.Date;

public class Task {
	
	private final Object addSave = new Object();
	
	private String title;
	private String description;
	private State state;
	private Category category;
	private short priority;
	private String owner;
	private Date dueDate;
	private Date createDate;
	
	public Task() {
		this("");
		System.out.println("starting Task() ctor...");
	}
	
	public Task(String title) {
		this(title, State.BACKLOG,(short) 1);
		System.out.println("starting Task(String) ctor...");
	}
	public Task(String title, short priority) {
		this(title, State.BACKLOG, priority);
		System.out.println("starting Task(String, Priority) ctor...");
	}
	
	public Task(String title,State state) {
		super();
		System.out.println("starting Task(String, State) ctor...");
		
		this.title = title;
		createDate = new Date();
		priority = 1;
		this.state  = state;
	}
	
	public Task(String title,State state, short priority){
		super();
		System.out.println("starting Task(String, State,Priority) ctor...");
		
		this.title = title;
		createDate = new Date();
		this.priority = priority;
		this.state  = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if(title != null) {
		this.title = title;
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public short getPriority() {
		return priority;
	}

	public void setPriority(short priority) {
		this.priority = priority;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public String toHtml() {
		return "<table><tr><td>Título:</tr></td>"
				+ "<tr><td>Descripción:</td></tr>"
				+ "<tr><td>Estado:</td></tr>"
				+ "<tr><td>Categoría:</td></tr>"
				+ "<tr><td>Prioridad:</td></tr>"
				+ "<tr><td>Propietario:</td></tr>"
				+ "<tr><td>Fecha de Entrega:</td></tr>"
				+ "<tr><td>Fecha de Creación:</td></tr>"
				+ "</table>";
	}
	
	public boolean equals(Object obj) {
		if (obj != null) {
			if(obj instanceof Task) {
				return title.equals(((Task) obj).getTitle());
			}
		}
		return false;
	}
	
	public boolean remove() {
		synchronized(this){
			return true;
		}
	}
	
	public boolean save() {
		//
		
		synchronized (addSave){
		try{
			Thread.sleep(1*1000);
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		return true;
		}
	}
}