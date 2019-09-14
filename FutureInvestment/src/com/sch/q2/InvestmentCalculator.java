package com.sch.q2;

//import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//import javax.swing.border.EmptyBorder;
import javax.swing.border.EmptyBorder;

public class InvestmentCalculator extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static JFrame fDisplay;
	private static JPanel contentPane;
	private static JTextField txtNoOfYears;
	private static JTextField txtInvestmentAmount;
	private static JTextField txtRate;
	private static JTextArea txtInvestmentResult;
	private static JLabel lblNoOfYears;
	private static JLabel lblInvestmentAmount;
	private static JLabel lblInvestmentRate;
	//private static JLabel lblInvestmentResult;

	// Amount = principle * math.pow (1.0 + rate, year)
	String AmountResult;

	public InvestmentCalculator() {
		AmountResult = "";
		/*
		 * setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setBounds(100, 100, 492,
		 * 300); contentPane = new JPanel(); contentPane.setBorder(new EmptyBorder(5, 5,
		 * 5, 5)); setContentPane(contentPane); contentPane.setLayout(null);
		 * 
		 * txtInvestmentAmount = new JTextField(); txtInvestmentAmount.setColumns(10);
		 * txtInvestmentAmount.setBounds(10, 31, 148, 27);
		 * contentPane.add(txtInvestmentAmount);
		 * 
		 * txtRate = new JTextField(); txtRate.setColumns(10); txtRate.setBounds(10,
		 * 100, 148, 27); contentPane.add(txtRate);
		 * 
		 * txtNoOfYears = new JTextField(); txtNoOfYears.setBounds(10, 164, 148, 27);
		 * contentPane.add(txtNoOfYears); txtNoOfYears.setColumns(10);
		 * 
		 * txtInvestmentResult = new JTextField(); txtInvestmentResult.setBounds(226,
		 * 11, 240, 239); contentPane.add(txtInvestmentResult);
		 * txtInvestmentResult.setColumns(10);
		 * 
		 * 
		 * btnCalculate = new JButton("Calculate"); btnCalculate.setBounds(37, 223, 89,
		 * 27); contentPane.add(btnCalculate);
		 * 
		 * 
		 * JLabel lblInvestmentRate = new JLabel("Investment Rate:");
		 * lblInvestmentRate.setBounds(10, 77, 148, 23);
		 * contentPane.add(lblInvestmentRate);
		 * 
		 * JLabel lblInvestmentAmount = new JLabel("Investment Amount:");
		 * lblInvestmentAmount.setBounds(10, 11, 148, 23);
		 * contentPane.add(lblInvestmentAmount);
		 * 
		 * JLabel lbNoOfYears = new JLabel("Number of Years:");
		 * lbNoOfYears.setBounds(10, 144, 148, 23); contentPane.add(lbNoOfYears);
		 */

	}

	/**
	 * Launch the application.
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		fDisplay = new JFrame("Investment Predictor");

		try {
			// set look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		InvestmentCalculator mInvCal = new InvestmentCalculator();
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
				 
				 
		
		lblInvestmentAmount = new JLabel("Investment Amount:");
		lblInvestmentAmount.setBounds(10, 11, 148, 23);
		contentPane.add(lblInvestmentAmount);
		
		txtInvestmentAmount = new JTextField(33);
		txtInvestmentAmount.setEditable(true);
		txtInvestmentAmount.setColumns(10);
		txtInvestmentAmount.setBounds(10, 31, 148, 27);
		contentPane.add(txtInvestmentAmount);
		
		
		
		lblInvestmentRate = new JLabel("Investment Rate:");
		lblInvestmentRate.setBounds(10, 77, 148, 23);
		contentPane.add(lblInvestmentRate);
		
		txtRate = new JTextField(33);
		txtRate.setEditable(true);
		txtRate.setColumns(10); 
		txtRate.setBounds(10,100, 148, 27); 
		contentPane.add(txtRate);
		
		
		
		lblNoOfYears = new JLabel("Number of Years:");	
		lblNoOfYears.setBounds(10, 144, 148, 23); 
		contentPane.add(lblNoOfYears);
		
		txtNoOfYears = new JTextField(33);
		txtNoOfYears.setEditable(true);
		txtNoOfYears.setBounds(10, 164, 148, 27);
		txtNoOfYears.setColumns(10);
		contentPane.add(txtNoOfYears); 
		
		
		
		
		//lblInvestmentResult = new JLabel();		
		txtInvestmentResult = new JTextArea();
		txtInvestmentResult.setEditable(false);
		txtInvestmentResult.setBounds(226,11, 240, 239); 
		contentPane.add(txtInvestmentResult);
		txtInvestmentResult.setColumns(10);

		
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(37, 223, 89, 27);
		contentPane.add(btnCalculate);
		btnCalculate.addActionListener(mInvCal);

		
		
		fDisplay.add(contentPane);
		fDisplay.setSize(500, 300);
		fDisplay.show();
	}

	/**
	 * Create the frame.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		String newline = "\n";
		Integer pYears = Integer.parseInt(txtNoOfYears.getText());
		Double Amount = 0.0;
		Integer Principle = Integer.parseInt(txtInvestmentAmount.getText());
		Integer Rate = Integer.parseInt(txtRate.getText());

		if (s.contains("Calculate")) {
			for (int i = 0; i < pYears; i++) {
				// Amount = principle * math.pow (1.0 + rate, year)
				Amount = Principle * Math.pow(1 + Rate, i);
				Integer mYr = i + 1;
				AmountResult += "Year " + mYr + " Investment = " + Amount.toString() + '\n';
				
				txtInvestmentResult.setText(AmountResult + newline);
			}
		}
	}

}
