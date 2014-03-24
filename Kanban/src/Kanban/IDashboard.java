package Kanban;

public interface IDashboard {
	/**
	 * TODO : Implement those methods
	 * 
	 * +classify(state) +add(task) +remove(task) +get() +orderByPriority()
	 * +orderByDate() +search()
	 * 
	 * /
	 **/
	/**
	 * Appends the specified task to the end of this list.
	 * 
	 * @param task
	 * @return
	 */
	public abstract boolean add(Task task);

	/**
	 * Removes the first occurrence of the specified task from this list, if it
	 * is present. If the list does not contain the taks, it is unchanged. More
	 * formally, removes the task with the lowest index i such that (o==null ?
	 * get(i)==null : o.equals(get(i))) (if such a task exists). Returns true if
	 * this list contained the specified element (or equivalently, if this list
	 * changed as a result of the call).
	 * 
	 * @param task
	 *            to be removed from this list, if present
	 * @return true if this list contained the specified task
	 */
	boolean remove(Task task);

	void clear();
}
