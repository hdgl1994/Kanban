package Kanban;

public class ListaDeTareas implements IDashboard{
	private Tarea[] listaDeTareas;
	
	public boolean agregar(Tarea tarea)
	{
		return true;
	}
	public boolean borrar(Tarea tarea)
	{
		return true;
	}
	@Override
	public boolean remover(Tarea tarea) {
		// TODO Auto-generated method stub
		return false;
	}
	public Tarea[] getListaDeTareas() {
		return listaDeTareas;
	}
	public void setListaDeTareas(Tarea[] listaDeTareas) {
		this.listaDeTareas = listaDeTareas;
	}

}
