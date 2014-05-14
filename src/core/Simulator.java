package core;

import javax.swing.JFrame;

import communication.CommunicationChannel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Simulator extends JFrame {
	
	private CommunicationChannel channel;
	private Detector detector;
	private Processor processor;
	private Monitor averageMonitor;
	private Monitor freeSlotsMonitor;
	
	private JLabel freeSlotsLabel;
	private JLabel averageCarsLabel;

	public Simulator() {
		super("Car Parking");
		setResizable(false);
		setSize(450, 240);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnCarEnters = new JButton("Car Enters");
		btnCarEnters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detector.carEnters();
			}
		});
		btnCarEnters.setBounds(40, 36, 158, 25);
		getContentPane().add(btnCarEnters);
		
		JButton btnNewButton = new JButton("Car Exits");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				detector.carExits();
			}
		});
		btnNewButton.setBounds(40, 83, 158, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnHourPassed = new JButton("Hour Passed");
		btnHourPassed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				processor.hourPassed();
			}
		});
		btnHourPassed.setBounds(40, 130, 158, 25);
		getContentPane().add(btnHourPassed);
		
		JLabel lblFreeSlots = new JLabel("Free slots:");
		lblFreeSlots.setBounds(254, 41, 134, 15);
		getContentPane().add(lblFreeSlots);
		
		JLabel lblAverageCarshour = new JLabel("Average cars/hour:");
		lblAverageCarshour.setBounds(254, 114, 134, 20);
		getContentPane().add(lblAverageCarshour);
		
		freeSlotsLabel = new JLabel(Processor.totalSlots + "");
		freeSlotsLabel.setBounds(254, 68, 134, 15);
		getContentPane().add(freeSlotsLabel);
		
		averageCarsLabel = new JLabel("0");
		averageCarsLabel.setBounds(254, 146, 134, 20);
		getContentPane().add(averageCarsLabel);
		
		channel = new CommunicationChannel();
		detector = new Detector(1, channel);
		processor = new Processor(2, channel);
		averageMonitor = new Monitor(3, channel, averageCarsLabel);
		freeSlotsMonitor = new Monitor(4, channel, freeSlotsLabel);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Simulator();
	}
}
