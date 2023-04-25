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
    	  short biggest = -1;    	  
    	  for(int j = 0; j < array.length-1; j++) {
    		  short bigOne = array[j];
    		  if(bigOne != 0 && Math.abs(bigOne) > biggest) {
    			  for(int i = j; i < array.length; i++) {
    				  if(array[i] == -bigOne) {
    					  biggest = (short) Math.abs(bigOne);
    				  }
    			}
    		  }
    	  }
    	  return biggest;
      }
      public static void bubbleSort(short[] array) {
    	  int j = 0;
    	  boolean f = false;
    	  while (j < array.length && !f) {
    		  for(int i = 0; i < array.length - 1 - j; i++) {
    			  f = true;
    			  if(array[i] > array[i+1]) {
    				  short bubble = array[i];
    				  array[i] = array[i+1];
    				  array[i+1] = bubble;
    				  f = false;
    			  }
    		  }
    	  j++;    		  
    	  }
      }
}
