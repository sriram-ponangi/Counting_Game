import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;

public class PlayGui {

	int userip;
	Game data;
	
	private JFrame frmPlayCountingGame;
	private JTextField textField;
	JLabel label = new JLabel("Game Status :");
	TextArea textArea = new TextArea();
	JLabel label_1 = new JLabel("Enter Your Number:");
	JButton button = new JButton("OK");
	JLabel label_2 = new JLabel("");
	private final JLabel lblyourEndPoint = new JLabel("");
	private final JLabel lblYourMax = new JLabel("");
	/**
	 * Launch the application.
	 */
		
	public static void startMyGame(Game tempdata) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayGui window = new PlayGui(tempdata);
					window.frmPlayCountingGame.setVisible(true);
					window.playGame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlayGui(Game data) {
		this.data=data;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		lblyourEndPoint.setText("**Your End Point: "+data.getEndPoint());
		lblYourMax.setText("***Your Max Increment: "+data.getMaxIncrement());
		frmPlayCountingGame = new JFrame();
		frmPlayCountingGame.setTitle("PLAY COUNTING GAME");
		frmPlayCountingGame.getContentPane().setBackground(new Color(153, 153, 255));
		frmPlayCountingGame.setBounds(100, 100, 450, 497);
		frmPlayCountingGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlayCountingGame.getContentPane().setLayout(null);
		
		
		label.setForeground(new Color(0, 51, 51));
		label.setFont(new Font("Stencil", Font.PLAIN, 24));
		label.setBackground(new Color(255, 255, 153));
		label.setBounds(12, 13, 183, 25);
		frmPlayCountingGame.getContentPane().add(label);
		
		
		textArea.setText("                       Best of Luck!!!");
		if(data.getStartVal().equals("Yes")) {
			textArea.append("\nYour Turn: ");
			String msg="*NOTE: Number should be in["+(data.getCurrentValue()+1)+","+(data.getCurrentValue()+data.getMaxIncrement())+"]";
			label_2.setText(msg);
		}
		
		textArea.setForeground(new Color(204, 204, 255));
		textArea.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 19));
		textArea.setFocusable(false);
		textArea.setEditable(false);
		textArea.setBackground(new Color(0, 0, 51));
		textArea.setBounds(12, 44, 410, 232);
		frmPlayCountingGame.getContentPane().add(textArea);
		
		
		label_1.setForeground(new Color(0, 51, 102));
		label_1.setFont(new Font("Stencil", Font.PLAIN, 20));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(12, 303, 214, 19);
		frmPlayCountingGame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 51));
		textField.setFont(new Font("Arial Black", Font.BOLD, 13));
		textField.setColumns(10);
		textField.setBackground(new Color(204, 204, 255));
		textField.setBounds(235, 300, 93, 25);
		frmPlayCountingGame.getContentPane().add(textField);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {		
					
					//int temp=Integer.parseInt(textField.getText());//temporary variable to store data in current value
					if(getPlayerInput()) {//if user input is valid						
						getComputerInput();						
					}
					
				}
				catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Your input is not a valid integer");			
				}
			}
		});
		
		
		button.setForeground(new Color(204, 204, 255));
		button.setBackground(new Color(0, 0, 51));
		button.setBounds(340, 300, 74, 25);
		frmPlayCountingGame.getContentPane().add(button);
		
		
		label_2.setForeground(new Color(0, 51, 102));
		label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		label_2.setBounds(32, 335, 316, 19);
		frmPlayCountingGame.getContentPane().add(label_2);
		lblyourEndPoint.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblyourEndPoint.setForeground(new Color(0, 51, 102));
		lblyourEndPoint.setBounds(29, 367, 277, 25);
		
		frmPlayCountingGame.getContentPane().add(lblyourEndPoint);
		lblYourMax.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblYourMax.setForeground(new Color(0, 51, 102));
		lblYourMax.setBounds(27, 396, 279, 25);
		
		frmPlayCountingGame.getContentPane().add(lblYourMax);
	}
	boolean getPlayerInput() {			
		int temp=Integer.parseInt(textField.getText());
		if(!validateInput(data.getCurrentValue()+1,data.getCurrentValue()+data.getMaxIncrement(),temp)) {
			textArea.append("\n\nINVALID INPUT\n");	
			return false;
		}
		else {
			data.setCurrentValue(temp);//valid input assigned to currentValue
			textArea.append("\nPlayer's Number: "+data.getCurrentValue());
			if(data.getCurrentValue()==(data.getEndPoint()-1)) {
				textArea.append("\n\n*****************CONGRATULATIONS****************\n");
				textArea.append("\nGAME OVER: YOU WON\n");
				textArea.append("\nNEXT NUMBER IS '"+data.getEndPoint()+"'");
				button.setEnabled(false);				
			}
			return true;
		}
			
	}
	
	boolean validateInput(int low,int high,int ip) {
		if(low<=ip && high>=ip)
			return true;
		else {			
			return false;	
		}				
	}
	
	
	void getComputerInput() {
//		nextBreakPoint=getNextBreakPoint(currentBreakPoint);
		
		while(data.getNextBreakPoint()<=data.getCurrentValue())
			data.setNextBreakPoint(data.getNextBreakPoint(data.getNextBreakPoint()));
		
		if(data.getNextBreakPoint()>data.getCurrentValue()+data.getMaxIncrement()) {			
			data.setCurrentValue(ThreadLocalRandom.current().nextInt(data.getCurrentValue()+1, data.getCurrentValue()+data.getMaxIncrement()));
		}
		else {
			
			data.setCurrentBreakPoint(data.getNextBreakPoint());
			data.setCurrentValue(data.getNextBreakPoint());				
		}
		
		textArea.append("\nSystem's Number: "+data.getCurrentValue());
		if(data.getCurrentValue()==(data.getEndPoint()-1)) {
			textArea.append("\n***************SORRY TRY AGAIN***************");
			textArea.append("\nGAME OVER: YOU LOST\n");
			textArea.append("NEXT NUMBER IS '"+data.getEndPoint()+"'");
			button.setEnabled(false);
		}
		else {
			String msg="*NOTE: Number should be in["+(data.getCurrentValue()+1)+","+(data.getCurrentValue()+data.getMaxIncrement())+"]";
			label_2.setText(msg);	
		}		
	}
	
	void playGame() {
		boolean startGame=data.setInput();				
		if(startGame) {//if computer starts the game			
			data.setCurrentValue(data.getStart());			
			textArea.append("\nSystem's Number: "+data.getCurrentValue());			
		}	
	}
	
	void whoWon(String s,int n){
		if(data.getCurrentValue()==(data.getEndPoint()-1)) {
			if(s.equals("Player")) {
				textArea.append("\n\n*****************CONGRATULATIONS****************\n");
				textArea.append("\nGAME OVER: YOU WON\n");
				textArea.append("\nNEXT NUMBER IS '"+data.getEndPoint()+"'");
				button.setEnabled(false);				
			}
			else if(s.equals("System")) {
				textArea.append("\n***************SORRY TRY AGAIN***************");
				textArea.append("\nGAME OVER: YOU LOST\n");
				textArea.append("NEXT NUMBER IS '"+data.getEndPoint()+"'");
				button.setEnabled(false);
			}
		}
	}
	
}
