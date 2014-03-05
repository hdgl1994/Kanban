package Kanban;

public class Programa {

	public static void main(String[] args) {
		Tarea tarea = new Tarea();
		
		tarea.setDespcripcion("Completar el programa");
		tarea.setEstado(Estado.DO_TO);
		
		//ListaDeTareas lista=new ListaDeTareas();
		IDashboard lista = new ListaDeTareas();
		if(lista.agregar(tarea))
		{
			System.out.println("Agregada");
		}

	}

}
