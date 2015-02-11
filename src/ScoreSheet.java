public class ScoreSheet {
	private int score;
	private int  currentFrame = 0 ;
	private int scUpdate = -1 ;
	private int marker = -1 ;
	Frame scoresheet[] = new Frame[10] ;
	
		public void _scoreWellFormed(){
			if (scUpdate == -1 ) return ;
			Frame f = scoresheet[scUpdate] ;
			Frame nextFrame = scoresheet[scUpdate + 1] ; 
			int n ;
			if (marker > 0) nextFrame =  scoresheet[scUpdate + 2] ; 
			
			while (scUpdate >= 0 && nextFrame.isFrameOver()){
				n = f.getScore() + nextFrame.getScore() ;      // new score at the frame with the spare
				f.setScore(n ) ;
				score += nextFrame.getScore() ;
				if (marker > 0 ) {
					scUpdate  = - 1 ;
					marker = -1 ;
					break;
				}

				if (f.getScoreType() == 10)                   // if it was a spare 
					scUpdate = -1 ;                           // frame has been updated so we can move on
				else{
					marker = 1 ;
					nextFrame =  scoresheet[scUpdate + 2] ;	
				}
				
			}
		}
	
	public ScoreSheet (){
		for (int i = 0 ; i < 10 ; i++)
			scoresheet [i] = new Frame (0);
		
		score = 0 ;
	}
	
	
	
	public void addThrow(int knockedPins){
		if(currentFrame > 9 ) throw new IllegalArgumentException("Illegal to throw for 11th frame"); 
		Frame cf = scoresheet[currentFrame] ;
		cf.throww(knockedPins);
		if(cf.getScoreType()==11 && currentFrame < 8){
			scUpdate = currentFrame ;
		}
		else if(cf.getScoreType() == 10 && currentFrame < 9){
			scUpdate = currentFrame ;
		}
		

		cf.setScore(cf.getScore() + knockedPins) ;
		score += knockedPins  ;
		
		if( cf.isFrameOver())	
			currentFrame++;
		
		
		_scoreWellFormed() ;	
	}
	
	public int getScoreCurFrame(){
		return currentFrame < 10  ? scoresheet[currentFrame].getScore() : scoresheet[currentFrame - 1].getScore();
	}
	public int getScorePrevFrame(){
		return currentFrame - 1  < 0 ? -Integer.MAX_VALUE : scoresheet[currentFrame - 1].getScore();
	}
	public int getScoreFrame(int n ){
		return n  <= 10 ? scoresheet[n- 1].getScore() : -Integer.MAX_VALUE ;
	}
	
	
	public int getScoreGame (){
		_scoreWellFormed();
		return score ;
	}
	
	public int curFrame(){  
		return currentFrame ;
	}

}
