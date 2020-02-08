package chargebee;

import java.util.Scanner;

public class CatMouseProblem {
	
	
	public static void main(String[] args) {
		CatMouseProblem catMouseProblem = new CatMouseProblem();
		char[][] matrix = catMouseProblem.input();
		int total = catMouseProblem.process(matrix);
		System.out.println("Total Mouse caught is : "+total);
	}
	
	public char[][] input() {
		Scanner scanner = null;
		char[][] matrix = null;
		try {
			scanner = new Scanner(System.in);
			
			System.out.println("Enter N:");
			int N = scanner.nextInt();
			matrix = new char[N][N];
			
			scanner.nextLine();
			
			System.out.println("Enter " + N + " x " + N + " values");
			for(int i=0;i<N;i++) {
				for(int j=0; j<N; j++) {
					matrix[i][j] = scanner.next().charAt(0);
				}
			}			
		}catch(Throwable t) {
			throw t;
		}finally {
			scanner.close();
		}
		return matrix;
	}
	
	public int process(char[][] matrix) {
		int n = matrix.length;
		int total = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				char value = Character.toUpperCase(matrix[i][j]);
				if(value == 'C') {
					int before = j-1;
					int after = j+1;
					if(before > 0 && Character.toUpperCase(matrix[i][before]) == 'M') {
						total++;
						matrix[i][before] = ' ';						
					}
					else if(after < n && Character.toUpperCase(matrix[i][after]) == 'M') {
						total++;
						matrix[i][after] = ' ';
					}
					matrix[i][j] = ' ';
				}
			}
		}
		
		return total;
	}
	
	public void display(char[][] matrix) {
		for(int i=0;i < matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");				
			}
			System.out.println();
		}
	}
}
