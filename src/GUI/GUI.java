package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField queuesText;
	private JTextArea clientsText;
	private JTextArea showClientsTxt;
	private JTextArea[] queue = new JTextArea[10];
	private JTextField timeLimitTxt;
	private JTextField minProcTxt;
	private JTextField maxProcTxt;
	private JTextField minArrTxt;
	private JTextField maxArrTxt;
	private JButton startBtn;
	private JTextArea timeTxt;

	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 997, 552);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(99, 210, 220));
		contentPane.setForeground(new Color(255, 128, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel title = new JLabel("Queue Management System");
		title.setFont(new Font("Tahoma", Font.PLAIN, 20));
		title.setBounds(360, 10, 310, 58);
		contentPane.add(title);

		queuesText = new JTextField();
		queuesText.setBounds(484, 76, 96, 19);
		contentPane.add(queuesText);
		queuesText.setColumns(10);

		JLabel nbQueuesLabel = new JLabel("Enter number of queues:");
		nbQueuesLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nbQueuesLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
		nbQueuesLabel.setBounds(263, 74, 211, 19);
		contentPane.add(nbQueuesLabel);

		clientsText = new JTextArea();
		clientsText.setBounds(484, 105, 96, 19);
		contentPane.add(clientsText);
		clientsText.setColumns(10);

		JLabel clientsLabel = new JLabel("Enter number of clients:");
		clientsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		clientsLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
		clientsLabel.setBounds(263, 108, 211, 19);
		contentPane.add(clientsLabel);

		showClientsTxt = new JTextArea();
		showClientsTxt.setBounds(802, 34, 117, 448);
//		contentPane.add(showClientsTxt);
//		showClientsTxt.setColumns(10);

		JLabel label1 = new JLabel("CLIENTS");
		label1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		label1.setBounds(800, 10, 159, 13);
		contentPane.add(label1);

		queue[0] = new JTextArea();
		queue[0].setBounds(53, 219, 120, 286);
		contentPane.add(queue[0]);
		queue[0].setColumns(10);
//		queue[0].setText("CEVA\n" + "CEVA");

		queue[1] = new JTextArea();
		queue[1].setBounds(203, 219, 120, 286);
		contentPane.add(queue[1]);
		queue[1].setColumns(10);

		queue[2] = new JTextArea();
		queue[2].setBounds(359, 219, 120, 286);
		contentPane.add(queue[2]);
		queue[2].setColumns(10);

		queue[3] = new JTextArea();
		queue[3].setColumns(10);
		queue[3].setBounds(515, 219, 120, 286);
		contentPane.add(queue[3]);

		queue[4] = new JTextArea();
		queue[4].setBounds(668, 219, 120, 286);
		contentPane.add(queue[4]);
		queue[4].setColumns(10);

		timeLimitTxt = new JTextField();
		timeLimitTxt.setBounds(157, 34, 96, 19);
		contentPane.add(timeLimitTxt);
		timeLimitTxt.setColumns(10);

		minProcTxt = new JTextField();
		minProcTxt.setBounds(157, 63, 96, 19);
		contentPane.add(minProcTxt);
		minProcTxt.setColumns(10);

		maxProcTxt = new JTextField();
		maxProcTxt.setBounds(157, 92, 96, 19);
		contentPane.add(maxProcTxt);
		maxProcTxt.setColumns(10);

		minArrTxt = new JTextField();
		minArrTxt.setBounds(157, 118, 96, 19);
		contentPane.add(minArrTxt);
		minArrTxt.setColumns(10);

		maxArrTxt = new JTextField();
		maxArrTxt.setBounds(157, 149, 96, 19);
		contentPane.add(maxArrTxt);
		maxArrTxt.setColumns(10);

		JLabel lb1 = new JLabel("Time limit:");
		lb1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb1.setBounds(10, 37, 104, 13);
		contentPane.add(lb1);

		JLabel lb2 = new JLabel("Min processing time:");
		lb2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb2.setBounds(10, 63, 139, 13);
		contentPane.add(lb2);

		JLabel lb3 = new JLabel("Max processing time:");
		lb3.setHorizontalAlignment(SwingConstants.TRAILING);
		lb3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb3.setBounds(10, 93, 147, 13);
		contentPane.add(lb3);

		JLabel lb4 = new JLabel("Min arrival time:");
		lb4.setHorizontalAlignment(SwingConstants.LEFT);
		lb4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb4.setBounds(10, 121, 147, 13);
		contentPane.add(lb4);

		JLabel lb5 = new JLabel("Max arrival Time:");
		lb5.setHorizontalAlignment(SwingConstants.LEFT);
		lb5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lb5.setBounds(10, 150, 137, 13);
		contentPane.add(lb5);

		JLabel queueLabel = new JLabel("Queue 1");
		queueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		queueLabel.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		queueLabel.setBounds(61, 196, 96, 13);
		contentPane.add(queueLabel);

		JLabel lblQueue = new JLabel("Queue 2");
		lblQueue.setHorizontalAlignment(SwingConstants.CENTER);
		lblQueue.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		lblQueue.setBounds(203, 197, 96, 13);
		contentPane.add(lblQueue);

		JLabel lblQueue_1 = new JLabel("Queue 3");
		lblQueue_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblQueue_1.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		lblQueue_1.setBounds(360, 196, 96, 13);
		contentPane.add(lblQueue_1);

		JLabel lblQueue_2 = new JLabel("Queue 4");
		lblQueue_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblQueue_2.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		lblQueue_2.setBounds(523, 197, 96, 13);
		contentPane.add(lblQueue_2);

		JLabel lblQueue_3 = new JLabel("Queue 5");
		lblQueue_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblQueue_3.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		lblQueue_3.setBounds(668, 197, 96, 13);
		contentPane.add(lblQueue_3);

		startBtn = new JButton("START");
		startBtn.setBounds(617, 78, 85, 21);
		contentPane.add(startBtn);

		timeTxt = new JTextArea();
		timeTxt.setBounds(433, 164, 58, 22);
		contentPane.add(timeTxt);

		JLabel timeLabel = new JLabel("TIME:");
		timeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		timeLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		timeLabel.setBounds(338, 170, 85, 13);
		contentPane.add(timeLabel);

		JScrollPane scrollPane = new JScrollPane(showClientsTxt);
		scrollPane.setBounds(802, 34, 140, 448);
		contentPane.add(scrollPane);

//		JScrollPane scrollBar = new JScrollPane(showClientsTxt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
//				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//		scrollBar.setBounds(929, 34, 17, 448);
//		contentPane.add(scrollBar);

//		scrollBar.setVerti
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getQueuesText() {
		return queuesText;
	}

	public void setQueuesText(JTextField queuesText) {
		this.queuesText = queuesText;
	}

	public JTextArea getClientsText() {
		return clientsText;
	}

	public void setClientsText(JTextArea clientsText) {
		this.clientsText = clientsText;
	}

	public JTextArea getShowClientsTxt() {
		return showClientsTxt;
	}

	public void setShowClientsTxt(JTextArea showClientsTxt) {
		this.showClientsTxt = showClientsTxt;
	}

	public JTextArea[] getQueue() {
		return queue;
	}

	public void setQueue(JTextArea[] queue) {
		this.queue = queue;
	}

	public JTextField getTimeLimitTxt() {
		return timeLimitTxt;
	}

	public void setTimeLimitTxt(JTextField timeLimitTxt) {
		this.timeLimitTxt = timeLimitTxt;
	}

	public JTextField getMinProcTxt() {
		return minProcTxt;
	}

	public void setMinProcTxt(JTextField minProcTxt) {
		this.minProcTxt = minProcTxt;
	}

	public JTextField getMaxProcTxt() {
		return maxProcTxt;
	}

	public void setMaxProcTxt(JTextField maxProcTxt) {
		this.maxProcTxt = maxProcTxt;
	}

	public JTextField getMinArrTxt() {
		return minArrTxt;
	}

	public void setMinArrTxt(JTextField minArrTxt) {
		this.minArrTxt = minArrTxt;
	}

	public JTextField getMaxArrTxt() {
		return maxArrTxt;
	}

	public void setMaxArrTxt(JTextField maxArrTxt) {
		this.maxArrTxt = maxArrTxt;
	}

	public JButton getStartButton() {
		return startBtn;
	}

	public void setStartButton(JButton startButton) {
		this.startBtn = startButton;
	}

	public void addStartButtonAL(ActionListener l) {
		startBtn.addActionListener(l);
	}

	public JTextArea getTimeTxt() {
		return timeTxt;
	}

	public void setTimeTxt(String timeTxt) {
		this.timeTxt.setText(timeTxt);
	}

	public void showMessage(String errMessage) {
		JOptionPane.showMessageDialog(this, errMessage);
	}
}
