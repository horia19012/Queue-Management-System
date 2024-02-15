import GUI.Controller;
import GUI.GUI;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI view=new GUI();
		Controller c=new Controller(view);
		view.setVisible(true);
		
	}

}
