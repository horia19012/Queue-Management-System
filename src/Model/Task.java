package Model;

public class Task {
	private int id;
	private int arrivalTime;
	private int serviceTime;
	private int waitTime;

	public Task() {

	};

	public Task(int id, int arrivalTime, int serviceTime) {
		this.id = id;
		this.arrivalTime = arrivalTime;
		this.serviceTime = serviceTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}

	public String toString() {
		return "(ID: " + id + "   AT: " + arrivalTime + "   ST: " + serviceTime + ")";
	}

	public int getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}
}
