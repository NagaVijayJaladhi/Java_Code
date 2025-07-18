package com.jst;

public class Interview001 {
	 public static void main(String[] args) {
	        System.out.println(myMethod(3));
	        
	    }
	    
	    public static int myMethod(int x){
	        int returnVal = 5;
	        try{
	            returnVal -= 6+x; 
	        }catch(Exception e){
	            returnVal = 3 * x;
	        }finally{
	            returnVal += 10;
	        }
	        
	        return returnVal;
	    }
}
