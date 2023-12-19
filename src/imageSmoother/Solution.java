package imageSmoother;

public class Solution {
	public int[][] imageSmoother(int[][] img) {

        // Get data about image
        int rowLen = img.length;
        int colLen = img[0].length;
        int[][] newImage = new int[rowLen][colLen];
        boolean cornerCase = false;

        // Calculate average 
        double total, average = 0;
        
        // Loop through elements 
        for( int i = 0; i < rowLen; i++ ){
            for( int j = 0; j < colLen; j++ ){

                // Corner Case
//                if( (i == 0 && j == 0) || 
//                    (i == 0 && j == colLen-1) ||
//                    (i == rowLen-1 && j == 0) || 
//                    (i == rowLen-1 && j == colLen -1) ){
//                    cornerCase = true;
//                }

                // Thinking    
                // if( cornerCase){

                // }

                // Check if surrounding cells are present
                if( i >= 1 && i < rowLen - 1){
                    if( j >= 1 && j < colLen - 1 ){
                        total = (img[i-1][j-1]) + (img[i-1][j]) + (img[i-1][j+1]) 
                        		+ (img[i][j-1]) + (img[i][j]) + (img[i][j+1]) 
                        		+ (img[i+1][j-1]) + (img[i+1][j]) + (img[i+1][j+1]);  

                        average = Math.floor(total / 9);
                        newImage[i][j] = (int) average;
                    }
                }
                    // STEPS: 
                    // Add value to total
                    // Calculate average 
                    // Save data in new Image
                
                // Reset total and average
                total = 0;
                average = 0;
            }

        }
        
        return newImage;
    }
	
	public static void main(String[] args) {
		int[][] testImg = { {100, 200, 100}, {200, 50, 200}, {100, 200, 100}};
		Solution obj = new Solution();
		int[][] newImage = obj.imageSmoother(testImg);
		
		for(int[] row : newImage) {
			for( int element : row ) {
				System.out.print(element + " ");
			}
			System.out.println("\n");
		}
	}

}
