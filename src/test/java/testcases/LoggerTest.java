package testcases;



import org.testng.annotations.Test;
import utilities.LoggerLoad;

public class LoggerTest {
	
	
	@Test
	public void tst001_TstngLog() throws InterruptedException
	{
        //if want to display info message
		LoggerLoad.info("<-------Testing Info-------->");
		
		//if want to display warn message
		LoggerLoad.warn("<--------Testing Warn-------");
		
		//if want to display error message
		LoggerLoad.error("<--------Testing error-------->");
		

	}

}
