package performance;
import java.util.Arrays;
import telran.strings.*;

public class JoinStringsPerformanceAppl {
	private static int N_STRINGS = 1000;
	private static int N_RUNS = 1000;
	private static String[] bigArray = new String[N_STRINGS];
	

	public static void main(String[] args) {
		for(int i = 0; i < bigArray.length; i++) {
			bigArray[i] = "Hello, world";
		}
		
		JoinStringsPerformanceTest jsBuilderImpl = new JoinStringsPerformanceTest(
				"JoinStringsBuilderImpl", N_RUNS, Arrays.copyOf(bigArray, bigArray.length), new JoinStringsBuilderImpl());
		JoinStringsPerformanceTest jsStringsImpl = new JoinStringsPerformanceTest(
				"JoinStringsImpl", N_RUNS, Arrays.copyOf(bigArray, bigArray.length), new JoinStringsImpl());
		
		jsBuilderImpl.run();
		jsStringsImpl.run();

	}

}
