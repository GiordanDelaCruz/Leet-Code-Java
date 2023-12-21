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

        //  Information about average 
        int total, numOfCells, average;
        total = numOfCells = average = 0;
        
        // Information about image smoother
        int top, bottom, right, left;
        top = bottom = right = left = 0;
        
        // Loop through cells
        for( int i = 0; i < rowLen; i++ ){
            for( int j = 0; j < colLen; j++ ){
            	
            	// Calculate top, bottom, right, and left boundaries for image smoother
            	top = Math.max(i-1, 0);
            	right = Math.min(j+1, colLen-1);
            	bottom = Math.min(i+1, rowLen-1);
            	left = Math.max(j-1, 0);
            	
            	System.out.println("Original Image Cell = " + img[i][j] + " | i = " + i + " | j = " + j);
    			System.out.println("top = " + top + " bottom = " + bottom + " right = " + right + " left = " + left + "\n");
    			
            	// Calculate average
            	for( int row = top; row <= bottom; row++) {
            		for( int col = left; col <= right; col++) {
            			
            			System.out.println("Image Smoother");
            			System.out.println("row = " + row + " col = " + col);
            			System.out.println("Cell data = " + img[row][col] + "\n");
            			
            			numOfCells += 1;
            			total += img[row][col];		
            		}
            	}
            	
            	// Store average into new image
            	average = (int) Math.floor(total/numOfCells);
            	newImage[i][j] = average;
            	
            
                // Reset total and average
                total = 0;
                average = 0;
                numOfCells = 0;
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
