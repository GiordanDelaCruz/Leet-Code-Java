package imageSmoother;

// STEPS: 
// Add value to total
// Calculate average 
// Save data in new Image

public class Solution {
	public int[][] imageSmoother(int[][] img) {

        // Get data about image
        int rowLen = img.length;
        int colLen = img[0].length;
        int[][] newImage = new int[rowLen][colLen];

        // Calculate average 
        double total, average = 0;
        
        // Loop through elements 
        for( int i = 0; i < rowLen; i++ ){
            for( int j = 0; j < colLen; j++ ){

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
                	
            	// Top & Bottom edge cells
        		if( j != 0 && j != colLen -1) {
        			
        			if( i == 0 ) {
        				total = img[i][j-1] + img[i][j] + img[i][j+1] + img[i+1][j-1] + img[i+1][j] + img[i+1][j+1] ;
                        average = Math.floor(total/6);
                        newImage[i][j] = (int) average;
                        
        			}else if( i == rowLen -1 ) {
        				total = img[i][j-1] + img[i][j] + img[i][j+1] + img[i-1][j-1] + img[i-1][j] + img[i-1][j+1] ;
	                    average = Math.floor(total/6);
	                    newImage[i][j] = (int) average;
        			}
        		// Left & Right edge cells
            	}else if(i != 0 && i != rowLen -1) {
            		System.out.println("Inside left and right");
            		if( j == 0 ) {
        				total = img[i-1][j] + img[i][j] + img[i+1][j] + img[i-1][j+1] + img[i][j+1] + img[i+1][j+1] ;
                        average = Math.floor(total/6);
                        newImage[i][j] = (int) average;
                        
        			}else if( j == colLen -1 ) {
        				total = img[i-1][j] + img[i][j] + img[i+1][j] + img[i-1][j-1] + img[i][j-1] + img[i+1][j-1] ;
	                    average = Math.floor(total/6);
	                    newImage[i][j] = (int) average;
        			}
            	}
                          	
            	// Corner Cases
                if( (i == 0 && j == 0) ){
                    total = img[i][j] + img[i][j+1] + img[i+1][j] + img[i+1][j+1];
                    average = Math.floor(total/4);
                    newImage[i][j] = (int) average;
                    
                }else if( (i == 0 && j == colLen-1) ) {
                	 total = img[i][j] + img[i+1][j] + img[i+1][j-1] + img[i][j-1];
                     average = Math.floor(total/4);
                     newImage[i][j] = (int) average;
                     
                }else if( (i == rowLen-1 && j == 0)) {
                	 total = img[i][j] + img[i-1][j] + img[i][j+1] + img[i-1][j+1];
                     average = Math.floor(total/4);
                     newImage[i][j] = (int) average;
                     
                }else if( (i == rowLen-1 && j == colLen -1) ) {
                	 total = img[i][j] + img[i][j-1] + img[i-1][j-1] + img[i-1][j];
                     average = Math.floor(total/4);
                     newImage[i][j] = (int) average;
                }
                
                
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
