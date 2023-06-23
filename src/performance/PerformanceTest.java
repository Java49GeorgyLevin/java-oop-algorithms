package performance;

public abstract class PerformanceTest {
	String testName;
	int nRuns;
	PerformanceTest(String testName, int nRuns) {
		this.testName = testName;
		this.nRuns = nRuns;		
	}
	protected abstract void runTest();
	
	void run() {		
		long timeBeginMs = System.currentTimeMillis();
		for(int i = 0; i < nRuns; i++) {
			runTest();			
		}		
		long timeFinishMs = System.currentTimeMillis();
		float timeProcessS = (float) (timeFinishMs - timeBeginMs) / 1000;
		printOut(timeProcessS);
	}
	
	private void printOut(float timeProcessS) {
		System.out.println("=======================");
		System.out.println("Value of nRuns: " + nRuns);
		System.out.println("Test name: " + testName);
		System.out.println("Running time, sec: " + timeProcessS);		
	}
	
}