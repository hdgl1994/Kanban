package Kanban;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DashboardList extends DashboardAbstract implements List<Task> {
	
	public DashboardList() {
		super();
		System.out.println("starting DashboardList() ctor...");
	}
	
	public boolean add(Task e) {
		return container.add(e);
	}
	
	public void add(int index, Task element) {
		container.add(index, element);
	}
	
	public boolean addAll(Collection c) {
		return container.addAll(c);
	}
	
	public boolean addAll(int index,Collection c) {
		return container.addAll(index, c);
	}
	
	public void clear() {
		container.clear();
	}
	public boolean contains(Object o) {
		return container.contains(o);
	}
	
	public boolean containsAll(Collection c) {
		return container.contains(c);
	}
	
	public Task get(int index) {
		return container.get(index);
	}
	
	public int indexOf(Object o) {
		return container.indexOf(o);
	}
	
	public boolean isEmpty() {
		return container.isEmpty();
	}
	
	public Iterator iterator() {
		return container.iterator();
	}
	
	public int lastIndexOf(Object o) {
		return container.lastIndexOf(o);
	}
	
	public ListIterator listIterator() {
		return container.listIterator();
	}
	
	public ListIterator listIterator(int index) {
		return container.listIterator(index);
	}
	
	public boolean remove(Object o) {
		return container.remove(o);
	}
	
	public Task remove(int index) {
		return container.remove(index);
	}
	
	public boolean removeAll(Collection c) {
		return container.removeAll(c);
	}
	
	public boolean retainAll(Collection c) {
		return container.retainAll(c);
	}
	
	public Task set(int index,Task element) {
		return container.set(index, element);
	}
	
	public int size() {
		return container.size();
	}
	
	
	public List subList(int fromIndex, int toIndex) {
		return container.subList(fromIndex, toIndex);
	}
	
	public Object[] toArray() {
		return container.toArray();
	}
	
	public Object[] toArray(Object[] a) {
		return container.toArray(a);
	}
	
	public boolean remove(Task task) {
		return container.remove(task);
	}

}
