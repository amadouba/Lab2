
public class Frame {
    private int score = 0;
    private int scoreType = 0;
    private int currentFrame = 0;
    private int turn = 0;
    private int totalPins = 10;
    
    
    public Frame(int t){
    	turn = t;
    }
    
    public int getScore(){
    	return score;
    }
    public int getScoreType(){
    	return scoreType;
    }
    public int getCurrentFrame(){
    	return currentFrame;
    }
    public int getCurrentTurn(){
    	return turn;
    }
    public int throww(int remainingPins){
    	if(turn > 1) throw new IllegalStateException();
    	if(0<=remainingPins && remainingPins > totalPins)
    	if(remainingPins == 0){
    		if(turn == 0)
    			scoreType = 11;
    		else
    			scoreType = 10;
    		turn++;
    		
    	}
    	else{
    		totalPins = remainingPins;
    		turn++;
    		scoreType = 10-totalPins;
    	}
    	return scoreType;
    }
    
}
