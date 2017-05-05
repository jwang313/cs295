import java.util.ArrayList;
import java.util.Arrays;
import java.lang.*;
public class MatrixMultiplication
{
	private static final int M = 3;
	private static final int K = 2;
	private static final int N = 3;
	public static void main(String[] args)
	{
		//Initialize matrices
		// Everyone must use same matrix values for testing

		int[][] A = {{1,4}, {2,5}, {3,6}};
		int[][] B = {{8,7,6}, {5,4,3}};

		int[][] result = new int[M][N];
		int columnLength = B[0].length;
		// Create for loop to calculate each element of C
	//	for (int i = 0; i < M; i++)
	//	{
	//		for (int j = 0; j < columnLength; j++) // number of columns
	//		{
	//			for (int z = 0; z <  B.length; z++)
	//			{
	//				result[i][j] += A[i][z] * B[z][j];
	//			}
	//		}
	//	}
		int numberThreads = M * N;
		ArrayList<Thread> workers = new ArrayList<Thread>();
		
		for (int i = 0; i < M; i++)
		{
			for (int j = 0; j < N; j++)
			{
				Thread worker = new Thread(new WThread(i, j, A, B, result));
				worker.start();
				workers.add(worker);
			}
		}
		
		for (Thread worker : workers)
		{
			try {
				worker.join();
			} catch(Exception e) {
				return;
			}
		}




		// Print Matrix C	
		System.out.println("Matrix Multiplication Results");
		System.out.println(Arrays.deepToString(result));
		//Print results
		//Need a for loop to print all elements of C

	}

}

//Create the Thread class
class WThread implements Runnable
{
	private int row;
	private int column;
	private int[][] A;
	private int[][] B;
	private int[][] C;
	private int columnLength;
	
	public WThread(int row, int column, int[][] A, int[][] B, int[][] C)
	{
		this.row = row;
		this.column = column;
		this.A = A;
		this.B = B;
		this.C = C;
		
	}
	
	public void run(){
		int[] actualRow = A[row];

		for (int i = 0; i < actualRow.length; i++)
		{
			
			C[row][column] += actualRow[i] * B[i][column];
			
		}
	
	}
	

}