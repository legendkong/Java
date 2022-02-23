// Overloading methods
import java.util.Random;
import java.util.ArrayList;

class Overloading
{
	private static Random rand;
	
	//this method compute and return the sum of all odd digit in the positive integer
	private static int getSum(int n)
	{
		int sum = 0;
		
		while (n > 0)
		{
			if (n % 10 % 2 == 1)
			{
				sum += n %10;
			}
			
			n = n / 10;
		}
		
		return sum;
	}
	
	//this method find the sum of all even number squared between 0 and n
	private static long getSum(long n)
	{
		long sum = 0;
		
		for (long i = 0; i <= n; i++)
		{
			if (i % 2 == 0)
			{
				sum += i * i;
			}
		}
		
		return sum;
	}
	
	//this method compute and return the sum of all elements in a one D array
	private static double getSum(double [] a)
	{
		double sum = 0;
		
		for (double value : a)
		{
			sum += value;
		}
		
		return sum;
	}
	
	//this method compute and return the sum of all even numbers in a 2 D array
	private static int getSum(int [][] a)
	{
		int sum = 0;
		
		for (int [] row : a)
		{
			for (int column : row)
			{
				if (column % 2 == 0)
				{
					sum += column;
				}
			}
		}
		
		return sum;
	}
	
	//this method initialize a one D array
	private static void constructArray(double [] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			a[i] = Math.random() * 1000;
		}
	}
	
	//this method initialize a 2 D array
	private static void constructArray(int [][] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a[i].length; j++)
			{
				a[i][j] = rand.nextInt(1000);
			}
		}
	}
	
	private static void displayInfo(int n)
	{
		System.out.printf("Given a positive integer %d, the sum of odd digit is %d%n", n, getSum(n));
	}
	
	private static void displayInfo(long n)
	{
		System.out.printf("The sum of all even numbers squared from 0 up to %d is %d%n", n, getSum(n));
	}
	
	private static void displayInfo(double [] a)
	{
		System.out.println("Given the following one D array,");
		for (double value : a)
		{
			System.out.printf("%.3f%n", value);
		}
		
		System.out.printf("The sum of all element in array is %.3f%n", getSum(a));
	}
	
	private static void displayInfo(int [][] a)
	{
		System.out.println("Given the following 2 D array,");
		for (int[] row : a)
		{
			for (int column : row)
			{
				System.out.printf("%6d", column);
			}
			System.out.println();
		}
		
		System.out.printf("The sum of all even element in 2D array is %d%n", getSum(a));
	}
	
	private static void task(int n)
	{
		displayInfo(n);
		System.out.println("--------------------------------------------------------------------");
	}
	
	private static void task(long n)
	{
		displayInfo(n);
		System.out.println("--------------------------------------------------------------------");
	}
	
	private static void task(double[] a)
	{
		constructArray(a);
		displayInfo(a);
		System.out.println("--------------------------------------------------------------------");
	}
	
	private static void task(int[][] a)
	{
		constructArray(a);
		displayInfo(a);
		System.out.println("--------------------------------------------------------------------");
	}
	
	public static void main (String [ ] args)
	{
		rand = new Random();
		
		int n = rand.nextInt(100000);
		task(n);
		
		long nn = (long) rand.nextInt(10000);
		task(nn);
		
		double [] a = new double [10];
		task(a);
		
		int [][] aa = new int [10][10];
		task(aa);
	}
}
