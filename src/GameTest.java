import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;


public class GameTest {
	    
	
	@Test
	public void testOneThrow() {
		ScoreSheet s = new ScoreSheet(); 
		s.addThrow (4);
		assertEquals (4, s.getScoreCurFrame() ) ;
		assertEquals (4, s.getScoreGame()) ;
		
	}
	
	@Test
	public void testTwoThrows(){
		ScoreSheet s = new ScoreSheet(); 
		s.addThrow(4);
		s.addThrow(2);
		
		
		assertEquals (6 , s.getScoreFrame(1)) ;
		assertEquals (6, s.getScoreGame()) ;
		
	}
	
	@Test
	public void ThreeThrows(){
		ScoreSheet s2 = new ScoreSheet(); 
		s2.addThrow(3);
		s2.addThrow(1);
		s2.addThrow(6);
		assertEquals (4 , s2.getScoreFrame(1)) ;
		assertEquals (10, s2.getScoreGame()) ;
		
	}
	
	@Test
	public void testSpareCountsNextFrameScore (){
		ScoreSheet s = new ScoreSheet();
		s.addThrow(3);
		s.addThrow(7);
		
		s.addThrow(3);
		s.addThrow(6);
		assertEquals (19, s.getScoreFrame(1));
		assertEquals (28,s.getScoreGame());
	}
	
	@Test
	public void testStrikeCountsNextFrameScores(){
		ScoreSheet s = new ScoreSheet();
		s.addThrow(10);
		
		
		s.addThrow(3);
		s.addThrow(6);
		assertEquals (19, s.getScoreFrame(1));
		assertEquals (28,s.getScoreGame());
		s.addThrow(4);
		s.addThrow(1);
		assertEquals (24, s.getScoreFrame(1));
		assertEquals (38,s.getScoreGame());
		
	}
	
	@Test
	public void testSpareOnLastFrame(){
		Random r = new Random ();
		ScoreSheet s = new ScoreSheet();
		int k = 0, n = 0;
		for (int i = 0 ; i < 9 ; i++){
			 n = r.nextInt(9) ;
			 s.addThrow(n);
			 s.addThrow(1);
			 
			 assertEquals (n + 1 , s.getScorePrevFrame() );
			 assertEquals (k += s.getScorePrevFrame(), s.getScoreGame());

		}
		k = s.getScoreCurFrame() ;
		n = s.getScoreGame() ;
		s.addThrow(4);
		s.addThrow(6);
		 assertEquals (10 , s.getScoreCurFrame() );
		 assertEquals (n + 10, s.getScoreGame());
		
	}
	
	@Test
	public void testStrikeOnLastFrames(){
		Random r = new Random ();
		ScoreSheet s = new ScoreSheet();
		int k = 0, n = 0;
		for (int i = 0 ; i < 7 ; i++){
			 n = r.nextInt(9) ;
			 s.addThrow(n);
			 s.addThrow(1);
			 
			 assertEquals (n + 1 , s.getScorePrevFrame() );
			 assertEquals (k += s.getScorePrevFrame(), s.getScoreGame());

		}
		
		n = s.getScoreGame() ;                        // 8th frame
		s.addThrow(10);
		assertEquals(n += 10, s.getScoreGame());
		
		                                            // 9th frame
		s.addThrow(10);
		assertEquals(n += 20, s.getScoreGame());
		assertEquals(20, s.getScoreFrame(8) ) ;
		
		              
		s.addThrow(10);                             // 10th frame
		assertEquals(n += 20, s.getScoreGame());
		assertEquals(30, s.getScoreFrame(8) ) ;
		assertEquals(10, s.getScoreFrame(9) ) ;
		
	}
	
	@Test
	public void testThrowOn11thFrame(){
		try {
			Random r = new Random ();
			ScoreSheet s = new ScoreSheet();
			int k = 0, n = 0;
			for (int i = 0 ; i < 10 ; i++){
				 n = r.nextInt(9) ;
				 s.addThrow(n);
				 s.addThrow(1);
				 
				 assertEquals (n + 1 , s.getScorePrevFrame() );
				 assertEquals (k += s.getScorePrevFrame(), s.getScoreGame());
			}
			
			s.addThrow(3);
			
		}catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	

}
