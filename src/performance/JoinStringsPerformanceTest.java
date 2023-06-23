package performance;

import telran.strings.JoinStrings;

public class JoinStringsPerformanceTest extends PerformanceTest {
	String[] string;
	JoinStrings joinStrings;
	String delimetr = "#";

	JoinStringsPerformanceTest(String testName, int nRuns, String[] string, JoinStrings joinStrings) {
		super(testName, nRuns);
		this.string = string;
		this.joinStrings = joinStrings;
	}


	@Override
	protected void runTest() {
		joinStrings.join(string, delimetr);
	}

}
