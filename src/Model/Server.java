package Model;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {
	private BlockingQueue<Task> tasks;
	private AtomicInteger waitingPeriod = new AtomicInteger(0);
	private boolean isRunning = true;

	public Server(int length) {
		this.tasks = new ArrayBlockingQueue<>(length);

	}



	

	public void addTask(Task task) {
		try {
			task.setWaitTime(this.getWaitingPeriod().get());
			tasks.put(task);
			waitingPeriod.getAndAdd(task.getServiceTime());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public BlockingQueue<Task> getTasks() {
		return tasks;
	}

	@Override
	public void run() {
		while (isRunning) {
//			try {
//				Task task = tasks.peek(); // check if there is a task available
//				if (task != null) {
//
//					// wait for 1 second
//
//					Thread.sleep(1000);
//					if (task.getServiceTime() == 0) { // if service time is 0, remove task from queue
////						Thread.sleep(1000);
//						tasks.poll();
////						 System.out.println("Task " + task.getId() + " finished "); // print queue
//						// size
//					}
////					Thread.sleep(1);
//					task.setServiceTime(task.getServiceTime() - 1); // subtract 1 second from service time
//					waitingPeriod.getAndAdd(-1); // subtract 1 second from waiting period
//
//				}
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//			try {
//				Task task = tasks.peek();
//				if (task != null) {
//					Thread.sleep(task.getServiceTime() * 1000);
//					this.waitingPeriod.getAndAdd(-task.getServiceTime());
//					tasks.poll();
//				}
//
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			try {
				// E GRESIT
				Task task = tasks.peek();
				if (task != null) {
					for (int i = 0; i < task.getServiceTime(); i++) {
						Thread.sleep(1000);
						tasks.peek().setServiceTime(task.getServiceTime() - 1);
						this.waitingPeriod.getAndAdd(-1);
						if (tasks.peek().getServiceTime() == 0) {
							tasks.poll();

						}

					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void stop() {
		isRunning = false;
	}

	public AtomicInteger getWaitingPeriod() {
		return waitingPeriod;
	}

	public void setWaitingPeriod(AtomicInteger waitingPeriod) {
		this.waitingPeriod = waitingPeriod;
	}

	public void printIDs(int server) {

		System.out.print((server + 1) + " :");
		boolean isFirstTask = true;
		int numTasks = tasks.size();
		for (Task t : tasks) {
			System.out.print(t);
		}
		System.out.println();
	}

	public String printClientsInColumn() {
		String s = "";
		for (Task t : tasks) {
			s = s + t + "\n";
		}

		return s;
	}
}
