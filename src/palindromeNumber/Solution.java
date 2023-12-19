package palindromeNumber;

public class Solution {
	
	public boolean isPalindrome(int x) {
	      
        if( x < 0 ){      // Case 1: Negative number
            return false;
        }else if( x>= 0 & x <= 9 ){        // Case 2: Single digit
            return true;
        }
        
        String numStr = Integer.toString(x);
        int reverseIndex = numStr.length() -1;
        // Loop through characters
        for( int i = 0; i < numStr.length(); i++ ){
            if( numStr.charAt(i) !=  numStr.charAt(reverseIndex) ){
                return false;
            }
            reverseIndex -= 1;
        }
        return true;
    }
	
	public static void main(String[] args) {
		int[] testData = {121, -121, 10};
		boolean output = false;
		
		Solution obj = new Solution();
		
		// Test Elements
		for( int element : testData ) {
			output = obj.isPalindrome(element);
			if( output == true) {
				System.out.println(element + " is a palindrome.");
			}else {
				System.out.println(element + " is NOT a palindrome.");
			}
		}	
		
	}

}
