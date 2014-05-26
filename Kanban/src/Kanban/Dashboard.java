package Kanban;

import java.util.Arrays;


public class Dashboard implements IDashboard {

	private int size;
	// transient is used along with instance variables to exclude them from serialization process
	private transient Task[]tasks;
	private transient int modCount = 0;
	
	public boolean add(Task task) {
		ensureCapacity(size + 1);
		tasks[size++] = task;
		return true;
	}
	public void ensureCapacity(int minCapacity) {
		setModCount(getModCount() + 1);
		int oldCapacity = tasks.length;
		if(minCapacity > oldCapacity) {
			int newCapacity = (oldCapacity * 3) / 2 + 1;
			if(newCapacity < minCapacity)
				newCapacity = minCapacity;
			tasks = Arrays.copyOf(tasks, newCapacity);
		}
	}
	
	public boolean remove(Task task){
		if(task == null) {
			for(int index = 0; index < size; index++)
				if(tasks[index] == null) {
					fastRemove(index);
					return true;
				}
		} else {
			for (int index = 0; index < size; index++)
				if(task.equals(tasks[index])) {
					fastRemove(index);
					return true;
				}
		}
		return false;
	}
	
	private void fastRemove(int index) {
		setModCount(getModCount() + 1);
		int numMoved = size - index - 1;
		if(numMoved >0)
			System.arraycopy(tasks, index + 1, tasks, index, numMoved);
		tasks[--size] = null;
	}
	
	public void clear() {
		setModCount(getModCount() + 1);
		
		for(int i = 0; i < size; i++)
			tasks[i] = null;
		
		size = 0;
	}
	
	public Dashboard(int initialCapacity) {
		super();
		if(initialCapacity < 0)
			throw new IllegalArgumentException("IllegalCapacity: "
					+ initialCapacity);
		this.tasks = new Task[initialCapacity];
	}
	
	public Dashboard() {
		this(10);
	}
	public int getModCount() {
		return modCount;
	}
	public void setModCount(int modCount) {
		this.modCount = modCount;
	}
}
