package telran.performance;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import telran.strings.*;

public class JoinStringsPerformanceAppl {

	private static final String PAKAGE_STRINGS = "telran.strings.";

	private static final int N_STRINGS = 1000;
	private static final int N_RUNS = 1000;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("must be not less one name of implementation");
		}

		try {
			for (int i = 0; i < args.length; i++) {
				String name = args[i];
				Class<JoinStrings> clazz = (Class<JoinStrings>) Class.forName(PAKAGE_STRINGS + name);
				Constructor<JoinStrings> constructor = clazz.getConstructor();
				JoinStrings joinStrings = constructor.newInstance();
				String testName = getTestName(name);
				String[] strings = getStrings();

				JoinStringsPerformanceTest testS = 
						new JoinStringsPerformanceTest(testName, N_RUNS, strings, joinStrings);
				testS.run();
			}
			
		} catch (ClassNotFoundException e) {
			System.out.printf("name must be 'JoinStringsImpl' or 'JoinStringsBuilderImpl'");

		} catch (NoSuchMethodException e) {
			System.out.println("NoSuchMethodException " + e.getCause());

		} catch (LinkageError e) {
			System.out.println("the linkage fails " + e.getMessage());
		}
		
		catch (InvocationTargetException e) {
			System.out.println("InvocationTargetException" + e.getCause());

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	private static String getTestName(String className) {

		return String.format("%s; Number of the strings is %d", className, N_STRINGS);
	}

	private static String[] getStrings() {
		String[] res = new String[N_STRINGS];
		Arrays.fill(res, "string");
		return res;
	}

}
