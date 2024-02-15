package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BusinessLogic.SimulationManager;

public class Controller {
	public GUI view;
	public SimulationManager sm ;

	public Controller(GUI view) {

		this.view = view;
		view.addStartButtonAL(new StartButton());

	}

	public class StartButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				
				int time = Integer.parseInt(view.getTimeLimitTxt().getText());
				int minArr = Integer.parseInt(view.getMinArrTxt().getText());
				int maxArr = Integer.parseInt(view.getMaxArrTxt().getText());
				int minSer = Integer.parseInt(view.getMinProcTxt().getText());
				int maxSer = Integer.parseInt(view.getMaxProcTxt().getText());
				int queues = Integer.parseInt(view.getQueuesText().getText());
				int clients = Integer.parseInt(view.getClientsText().getText());


				sm = new SimulationManager(time,maxSer,minSer,maxArr,minArr,queues,clients,view);
				Thread t = new Thread(sm);
				t.start();

			} catch (NumberFormatException ex) {
				view.showMessage("Invalid input!");
				ex.printStackTrace();
			}
		}

	}

}
