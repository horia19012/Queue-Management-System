package Model;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
	private List<Server> servers;
	private int maxNoServers;
	private int maxTasksPerServer;
	private Strategy strategy;

	public Scheduler(int maxNoServers, int maxTasksPerServer) {
		this.servers = new ArrayList<>(maxNoServers);
		for (int i = 0; i < maxNoServers; i++) {
			Server server = new Server(maxTasksPerServer);
			servers.add(server);
			Thread thread = new Thread(server);
			thread.start(); // launch thread for each server
		}
		strategy = new ConcreteStrategyTime();
	}

	public void dispatchTask(Task t) {

		strategy.addTask(servers, t);
	}

	public List<Integer> getQueueSizes() {
		List<Integer> queueSizes = new ArrayList<>();
		for (Server server : servers) {
			queueSizes.add(server.getTasks().size());
		}
		return queueSizes;
	}

	public interface Strategy {
		public void addTask(List<Server> servers, Task t);
	}

	public class ConcreteStrategyTime implements Strategy {
		@Override
		public void addTask(List<Server> servers, Task t) {

			Server shortestTimeServer = servers.get(0);
			for (Server s : servers) {
				if (s.getWaitingPeriod().get() < shortestTimeServer.getWaitingPeriod().get()) {
					shortestTimeServer = s;
				}
			}
			shortestTimeServer.addTask(t);
//                System.out.println(shortestTimeServer.getTasks());

		}
	}

	public List<Server> getServers() {
		return this.servers;
	}
}