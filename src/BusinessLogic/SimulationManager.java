package BusinessLogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import javax.swing.JTextArea;

import GUI.GUI;
import Model.Scheduler;
import Model.Server;
import Model.Task;

public class SimulationManager implements Runnable {

	public int timeLimit;// maximum processing time-read from UI
	public int maxProcessingTime;
	public int minProcessingTime;
	public int maxArrivalTime;
	public int minArrivalTime;
	public int numberOfServers;
	public int numberOfClients;
	public boolean activeThread = true;
	private GUI view;

	public int peakHour = 0;
	public double avgServiceTime = 0;
	public double avgWaitTime = 0;

	public PrintStream consoleStream = System.out;
	public PrintStream fileStream;
	private Scheduler scheduler;
//	private SimulationFrame frame;
	private List<Task> generatedTasks;
//	private SelectionPolicy selectionPolicy;

	public SimulationManager(int timeLimit, int maxProcessingTime, int minProcessingTime, int maxArrivalTime,
			int minArrivalTime, int numberOfServers, int numberOfClients) {
		this.timeLimit = timeLimit;
		this.maxProcessingTime = maxProcessingTime;
		this.minProcessingTime = minProcessingTime;
		this.maxArrivalTime = maxArrivalTime;
		this.minArrivalTime = minArrivalTime;
		this.numberOfClients = numberOfClients;
		this.numberOfServers = numberOfServers;

		this.generatedTasks = new ArrayList<>();
		this.scheduler = new Scheduler(numberOfServers, numberOfClients);

		this.generateNRandomTasks();

	}

	public SimulationManager(int timeLimit, int maxProcessingTime, int minProcessingTime, int maxArrivalTime,
			int minArrivalTime, int numberOfServers, int numberOfClients, GUI view) {
		this.timeLimit = timeLimit;
		this.maxProcessingTime = maxProcessingTime;
		this.minProcessingTime = minProcessingTime;
		this.maxArrivalTime = maxArrivalTime;
		this.minArrivalTime = minArrivalTime;
		this.numberOfClients = numberOfClients;
		this.numberOfServers = numberOfServers;

		this.generatedTasks = new ArrayList<>();
		this.scheduler = new Scheduler(numberOfServers, numberOfClients);
		this.view = view;

		this.generateNRandomTasks();
		String s = "";
		for (Task t : generatedTasks) {
			s = s + t + "\n";
			view.getShowClientsTxt().setText(s);
		}

	}

	private void generateNRandomTasks() {
		// generate N random tasks
		// -random processing time
		// minProcessingTime<processingTime<maxProcessingTime
		// - random arrivalTime
		// sort list with respect to arrivalTime

		Random random = new Random();
		for (int i = 0; i < numberOfClients; i++) {
			Task t = new Task();
//			t.setArrivalTime(random.nextInt(timeLimit));
			t.setArrivalTime(minArrivalTime + random.nextInt(maxArrivalTime - minArrivalTime + 1));
			t.setServiceTime(minProcessingTime + random.nextInt(maxProcessingTime - minProcessingTime + 1));
			t.setId(i + 1);
			this.avgServiceTime += t.getServiceTime();
			generatedTasks.add(t);
		}
		Collections.sort(generatedTasks, Comparator.comparingInt(Task::getArrivalTime));
	}

	public void printGeneratedTasks() {

		for (Task i : generatedTasks) {
			System.out.println(i);
		}

	}

	public void stop() {
		this.activeThread = false;
	}

	public void run() {
		// iterate generatedTasks list and pick tasks that have the
		// arrivalTime equal with the currentTime
		// -send task to queue by calling the dispatch
		// from Scheduler
		// - delete client from list

		try {

			fileStream = new PrintStream(new File("output.txt"));
			PrintStream consoleStream = System.out;

			// Redirect console output to the output file

			int currentTime = 0;
			int currentTaskIndex = 0;
			int maxClients = 0;

			System.setOut(fileStream);
//			System.out.println(consoleStream);
			this.printGeneratedTasks();
			while (currentTime < timeLimit && activeThread) {
				// Dispatch new tasks to the scheduler

				while (currentTaskIndex < generatedTasks.size()
						&& generatedTasks.get(currentTaskIndex).getArrivalTime() == currentTime) {
					Task task = generatedTasks.get(currentTaskIndex);
					scheduler.dispatchTask(task);
					System.out.println("Task " + task.getId() + " has arrived at time " + currentTime);
					this.avgWaitTime += task.getWaitTime();
					currentTaskIndex++;

				}
				view.setTimeTxt(String.valueOf(currentTime));
				List<Integer> queueSizes = scheduler.getQueueSizes();

				System.out.println("Queues at time " + currentTime + ": ");
				int clients = 0;
				for (Server s : scheduler.getServers()) {
					clients += s.getTasks().size();

					s.printIDs(scheduler.getServers().indexOf(s));
					if (this.numberOfServers < 6) {
						view.getQueue()[scheduler.getServers().indexOf(s)].setText("");
						view.getQueue()[scheduler.getServers().indexOf(s)].setText(s.printClientsInColumn());
					}
				}
				if (clients > maxClients) {
					this.peakHour = currentTime;
					maxClients = clients;
				}

				System.out.println();
				currentTime++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			for (int i = 0; i < scheduler.getServers().size(); i++) {
				scheduler.getServers().get(i).stop();
			}
			System.out.println("Average service time= " + this.avgServiceTime / this.numberOfClients);
			System.out.println("Average wait time= " + this.avgWaitTime / this.numberOfClients);
			System.out.println("Peak hour= " + this.peakHour);
			// peakHour aici
			fileStream.close();
			this.stop();
			this.view.showMessage("Simulation ended!\nAverage service time, Average wait time and Peak Hour\n are found in the .txt file");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static void main(String[] args) {
		GUI view=new GUI();
		view.setVisible(true);
		
		SimulationManager gen = new SimulationManager(12, 6, 1, 8, 1, 3, 12,view);
		Thread t = new Thread(gen);
		t.start();

//		fStream.close();

	}
}