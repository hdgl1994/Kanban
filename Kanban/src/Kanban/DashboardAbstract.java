package Kanban;

import java.util.ArrayList;
import java.util.List;

public abstract class DashboardAbstract implements IDashboard {

	protected List container;

	public DashboardAbstract() {
		super();
		System.out.println("starting DashboardAbstract() ctor...");
		container = new ArrayList();
	}

	@Override
	public boolean add(Task task) {
		return container.add(task);
	}

}
