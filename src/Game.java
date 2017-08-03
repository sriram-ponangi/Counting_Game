import java.util.concurrent.ThreadLocalRandom;

public class Game {	
	
	int endPoint,maxIncrement,currentBreakPoint,nextBreakPoint,currentValue;
	String startVal=new String("No");
	boolean validInput,gameOver;
	//Scanner sc=new Scanner(System.in);	
	
	public int getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(int endPoint) {
		this.endPoint = endPoint;
	}
	
	
	public int getMaxIncrement() {
		return maxIncrement;
	}
	public void setMaxIncrement(int maxIncrement) {
		this.maxIncrement = maxIncrement;
	}
	
	
	public String getStartVal() {
		return startVal;
	}
	public void setStartVal(String startVal) {
		this.startVal = startVal;
	}
	
	
	public int getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}		
	
	boolean setInput() {		

		setCurrentBreakPoint((getEndPoint()-1)%(getMaxIncrement()+1));
		setNextBreakPoint(getCurrentBreakPoint());//getNextBreakPoint(currentBreakPoint);

		if(startVal.equals("Yes"))
			return false;//computer should not start
		else
			return true;////computer should start		
	}
	
	int getStart() {
		int start=(endPoint-1)%(maxIncrement+1);
		if(start==0) {
			int randomNum = ThreadLocalRandom.current().nextInt(1, maxIncrement + 1);
			return randomNum;
		}
		return start;		
	}
	
	int getNextBreakPoint(int bp){		
		bp=bp+maxIncrement+1;
		return bp;		
	}
	
	
	
	public int getCurrentBreakPoint() {
		return currentBreakPoint;
	}
	public void setCurrentBreakPoint(int currentBreakPoint) {
		this.currentBreakPoint = currentBreakPoint;
	}
	public int getNextBreakPoint() {
		return nextBreakPoint;
	}
	public void setNextBreakPoint(int nextBreakPoint) {
		this.nextBreakPoint = nextBreakPoint;
	}
	public boolean isValidInput() {
		return validInput;
	}
	public void setValidInput(boolean validInput) {
		this.validInput = validInput;
	}
	public boolean isGameOver() {
		return gameOver;
	}
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
	
	
	/*
	 * RE-FACTORING THE CODE
	
	boolean validatePlayerInput(int temp) {			
		//int temp=Integer.parseInt(textField.getText());
		if(!validateInput(this.getCurrentValue()+1,this.getCurrentValue()+this.getMaxIncrement(),temp)) {
			
			return false;//for false do this-----> textArea.append("\n\nINVALID INPUT\n");	
		}
		else {
			this.setCurrentValue(temp);//valid input assigned to currentValue
			//for true do this----->textArea.append("\nPlayer's Number: "+this.getCurrentValue());
			i
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
	
	
	int getComputerInput() {
//		nextBreakPoint=getNextBreakPoint(currentBreakPoint);
		
		while(this.getNextBreakPoint()<=this.getCurrentValue())
			this.setNextBreakPoint(this.getNextBreakPoint(this.getNextBreakPoint()));
		
		if(this.getNextBreakPoint()>this.getCurrentValue()+this.getMaxIncrement()) {			
			this.setCurrentValue(ThreadLocalRandom.current().nextInt(this.getCurrentValue()+1, this.getCurrentValue()+this.getMaxIncrement()));
		}
		else {
			
			this.setCurrentBreakPoint(this.getNextBreakPoint());
			this.setCurrentValue(this.getNextBreakPoint());				
		}
		
		textArea.append("\nSystem's Number: "+this.getCurrentValue());
		
		else {
			String msg="*NOTE: Number should be in["+(this.getCurrentValue()+1)+","+(this.getCurrentValue()+this.getMaxIncrement())+"]";
			label_2.setText(msg);	
		}		
	}
	
	void playGame() {
		boolean startGame=this.setInput();				
		if(startGame) {//if computer starts the game			
			this.setCurrentValue(this.getStart());			
			textArea.append("\nSystem's Number: "+this.getCurrentValue());			
		}	
	}*/
	
	
	
}