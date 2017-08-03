import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameGui {

	private JFrame frmCountingGame;
	private JTextField textField;
	private JTextField textField_1;
	JLabel lblCountingGame = new JLabel("Counting Game:");
	JLabel lblEndPoint_1 = new JLabel("End Point :");
	JLabel lblMaxIncrement = new JLabel("Max Increment : ");
	JRadioButton rdbtnNewRadioButton = new JRadioButton("Yes");
	JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("No");
	ButtonGroup rbg=new ButtonGroup();
	JButton btnNewButton = new JButton("PLAY");
	
	
	static Game data=new Game();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameGui window = new GameGui();
					window.frmCountingGame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public GameGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		frmCountingGame = new JFrame();
		frmCountingGame.setTitle("COUNTING GAME ~SRIRAM");
		frmCountingGame.setBackground(new Color(0, 153, 255));
		frmCountingGame.getContentPane().setBackground(new Color(102, 153, 255));
		frmCountingGame.getContentPane().setForeground(Color.BLACK);
		frmCountingGame.setBounds(100, 100, 427, 234);
		frmCountingGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCountingGame.getContentPane().setLayout(null);
		
		
		lblCountingGame.setBackground(new Color(0, 51, 255));
		lblCountingGame.setForeground(new Color(0, 51, 51));
		lblCountingGame.setFont(new Font("Stencil", Font.PLAIN, 30));
		lblCountingGame.setBounds(97, 0, 251, 40);
		frmCountingGame.getContentPane().add(lblCountingGame);
		
		
		lblEndPoint_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 20));
		lblEndPoint_1.setForeground(new Color(0, 51, 102));
		lblEndPoint_1.setBounds(22, 38, 99, 22);
		frmCountingGame.getContentPane().add(lblEndPoint_1);
		
		textField = new JTextField();
		textField.setBackground(new Color(204, 204, 255));
		textField.setBounds(127, 38, 74, 26);
		frmCountingGame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		lblMaxIncrement.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 20));
		lblMaxIncrement.setForeground(new Color(0, 51, 102));
		lblMaxIncrement.setBounds(22, 76, 154, 27);
		frmCountingGame.getContentPane().add(lblMaxIncrement);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(204, 204, 255));
		textField_1.setBounds(178, 77, 62, 27);
		frmCountingGame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		rdbtnNewRadioButton.setForeground(new Color(0, 0, 51));
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnNewRadioButton.setBackground(new Color(204, 204, 255));
		rdbtnNewRadioButton.setBounds(138, 118, 53, 25);
		frmCountingGame.getContentPane().add(rdbtnNewRadioButton);
		
		
		rdbtnNewRadioButton_1.setForeground(new Color(0, 0, 51));
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnNewRadioButton_1.setSelected(true);
		rdbtnNewRadioButton_1.setBackground(new Color(204, 204, 255));
		rdbtnNewRadioButton_1.setBounds(195, 118, 45, 25);
		frmCountingGame.getContentPane().add(rdbtnNewRadioButton_1);
		
		
		rbg.add(rdbtnNewRadioButton);
		rbg.add(rdbtnNewRadioButton_1);
		JLabel lblNewLabel = new JLabel("Start Game : ");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setForeground(new Color(0, 51, 102));
		lblNewLabel.setBounds(22, 115, 127, 22);
		frmCountingGame.getContentPane().add(lblNewLabel);
		
		
		btnNewButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				if(getValidInput()) {
					System.out.println("*-*-*-*-*VALID INPUT*-*-*-*-*-");
					System.out.println("*************Start: "+data.getStart());
					System.out.println("*************End point: "+data.getEndPoint());
					System.out.println("*************Max Inc: "+data.getMaxIncrement());					
					PlayGui.startMyGame(data);
					frmCountingGame.setVisible(false);					
				}
				else
					System.out.println("INVALID INPUT*-*-*-*-*-*-*");				
			}
		});	

		btnNewButton.setBackground(new Color(0, 0, 51));
		btnNewButton.setForeground(new Color(204, 204, 255));
		btnNewButton.setFont(new Font("Stencil", Font.PLAIN, 20));
		btnNewButton.setBounds(252, 146, 134, 29);
		frmCountingGame.getContentPane().add(btnNewButton);
	}
	
	/*
	 * Checks if data entered is valid or not when play button is clicked
	 */
	private boolean getValidInput() {
		
		try {			
			int endPoint=Integer.parseInt(textField.getText());
			data.setEndPoint(endPoint);							
			if(endPoint<=3) {
				throw new Exception();
			}			
		}
		catch(NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "End Point is not a valid integer");			
			return false;
		} catch (Exception e1) {			
			JOptionPane.showMessageDialog(null, "End Point should be greater than 3");			
			return false;
		}
		try {			
			int maxIncrement=Integer.parseInt(textField_1.getText());
			data.setMaxIncrement(maxIncrement);						
			if(maxIncrement >= (data.getEndPoint()-1) || maxIncrement<=1)
				throw new Exception();			
		}
		catch(NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Max Increment is not a valid integer");			
			return false;
		} catch (Exception e1) {			
			JOptionPane.showMessageDialog(null, "Max Increment should be grater than 1  and less than " + (data.getEndPoint()-1));			
			return false;
		}
		
		if(rdbtnNewRadioButton.isSelected()) {
			data.setStartVal("Yes");				
		}
		if(rdbtnNewRadioButton_1.isSelected())
			data.setStartVal("No");	
		
		return true;
	}
}
