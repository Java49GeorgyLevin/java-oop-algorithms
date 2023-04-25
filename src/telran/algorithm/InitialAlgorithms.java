package telran.algorithm;

public class InitialAlgorithms {
      public static void sortShortPositive(short [] array) {
    	  int [] helper = new int[Short.MAX_VALUE];
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
    	  boolean f = false;
    	  int j = 0;
    	  while(j < array.length-1 && !f) {
    		  short second =  (short) (sum - array[j++]);
    		  for(int i = j;i < array.length;i++) {
    			  if(array[i] == second) {
    				  f = true;
    			  }
    	  		}
    	  }    	  

    	  
    	  return f;
      }
      public static short getMaxPositiveWithNegativeReflect(short[] array) {
    	  //returns maximal positive number, for which there is the negative image
    	  //If there are not such numbers at all the method returns -1
    	  return -1;
      }
}
