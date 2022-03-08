import java.util.Random;

public class sidebysideTriangles {

	private static void drawTriangles(int height) {
		  
		   int i, j, k, l, m;

	        for(i=0; i<height; i++)
	        {

	            for(j = height-i; j > 0; j--)
	            {
	                System.out.print("-");
	            }

	            for(k = 1; k <= i+1; k++)
	            {
	                System.out.print(k);
	            }

	            for(l = height-i; l > 0; l--)
	            {
	                System.out.print("*");
	            }

	            for(m = height; m >= height-i; m--)
	            {
	                System.out.print(m);
	            }

	            System.out.println();
	        }
		}

	
	public static void main(String[] args) {
		
		Random r = new Random();
		int low = 6;
		int high = 10;
		int height = r.nextInt(high-low) + low;
		drawTriangles(height);
		
	}

}
