
public class ScoreSheet {

	private Frame[] scoresheet;
	private int currentFrame = 0;
	
	public ScoreSheet(){
		for(int i = 0; i<10; i++){
			scoresheet[i] = new Frame(i+1);
		}
	}
	
	public void addThrow(int remainingPins){
		if(currentFrame>10) throw new IllegalArgumentException();
		scoresheet[currentFrame].throww(remainingPins);
		if(scoresheet[currentFrame].getScoreType()==11){
			
		}
		else if(scoresheet[currentFrame].getScoreType() == 10){
			
		}
		else{
			scoresheet[currentFrame].setScore(10-remainingPins);
			
		}
		if(scoresheet[currentFrame].isFrameOver())
			currentFrame++;
	}
	
}
