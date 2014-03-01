/**
 * 
 */
package java.practice.level1;

import java.util.Arrays;

/**
 * @author aaronl
 *
 */
public class SingleNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int singleNumber(int[] A) {
	        if(A.length == 0){
	            return 0;   
	        }else if(A.length == 1){
	             return A[0] ;
	        }
	        
	        Arrays.sort(A);
	        for(int i = 1 ; i < A.length; i=i+2){ //i =1 not i==1
	            if(A[i-1] != A[i]){
	                return A[i-1];
	            }
	        }
	        return A[A.length-1]; //length -1
	    }
	 
	    public int singleNumber1(int[] A) {
	        if(A.length == 0){
	            return 0;   
	        }else if(A.length == 1){
	             return A[0] ;
	        }
	        
	        Arrays.sort(A);
	        for(int i = 1 ; i < A.length; i=i+2){
	            if((A[i-1] ^ A[i]) != 0){
	                return A[i-1];
	            }
	        }
	        return A[A.length-1];
	    }
}
