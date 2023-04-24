package telran.algorithm;

public class InitialAlgorithms {
      public static void sortShortPositive(short [] array) {
    	  int [] helper = new int[Short.MAX_VALUE];
    	  //helper[index] => count of occurrences for number index in array
    	  //helper[1000] = 2 => number 1000 occurs twice in the source array
    	  //helper[2] = 0;
    	  for(int i = 0; i < array.length; i++) {
    		  helper[array[i]]++; 
    	  }
    	  int ind = 0;
    	  for(int i = 0; i < helper.length; i++) {
    		  for(int j = 0; j < helper[i]; j++) {
    			  array[ind++] = (short) i;
    		  }
    	  }

      }
      public static boolean isSum2(short[] array, short sum) {
    	  //returns true if there are two numbers in the given array,
    	  // sum of which equals the given sum value
    	  //otherwise false
    	  //TODO
    	  return false;
      }
      public static short getMaxPositiveWithNegativeReflect(short[] array) {
    	  //returns maximal positive number, for which there is the negative image
    	  //If there are not such numbers at all the method returns -1
    	  return -1;
      }
}
