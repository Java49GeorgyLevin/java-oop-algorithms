package telran.util.test;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		boolean checkEven1 = ((int)o1 % 2 == 0);
		boolean checkEven2 = ((int)o2 % 2 == 0);
		return 	(checkEven1 == true && checkEven2 == true) ? Integer.compare(o1, o2) :
				(checkEven1 == false && checkEven2 == false) ? Integer.compare(o2, o1) :
				(checkEven1 == false && checkEven2 == true) ? 1 : 0;

	}
}