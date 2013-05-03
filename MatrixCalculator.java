import java.text.DecimalFormat;


public class MatrixCalculator {

	
	/**
	 * Adds two Matrices together and returns the sum as a new Matrix.
	 * @param A Matrix
	 * @param B Matrix
	 */
	public Matrix add(Matrix A, Matrix B){
		if( A.getNumRows() != B.getNumRows() || A.getNumCols() != B.getNumCols() ){
			throw new IllegalArgumentException("Matrices differ in size.");
		}
		int n = A.getNumRows();
		int m = A.getNumCols();
		
		double[][] sum  = new double [n][];
		for(int i=0; i < n; i++){
			sum[i] = new double [m];
		}
		
		for(int i=0; i < n; i++){
			for(int j=0; j < m; j++){
				sum[i][j] = A.getElement(i, j) + B.getElement(i, j);
			}
		}
		
		return new Matrix(sum);

	}
	
	/**
	 * Multiplies two Matrices together and returns the sum as a new Matrix.
	 * @param A Matrix
	 * @param B Matrix
	 */
	public Matrix multiply(Matrix A, Matrix B){
		if( A.getNumCols() != B.getNumRows()  ){
			throw new IllegalArgumentException("Number of rows in A is not equal to the number of columns in B.");
		}
		
		int n = A.getNumCols();
		int m = A.getNumRows();
		int p = B.getNumCols();
		double[][] product = new double[m][p];
		

		for(int i=0; i < m; i++){
			for(int j=0; j < p; j++){
				for(int k=0; k < n; k++){
					product[i][j] += A.getElement(i, k) * B.getElement(k, j);			
				}
			}
		}
		
		return new Matrix(product);

	}
	
	/**
	 * Reduces Matrix A to row echelon form.
	 */
	public Matrix gauss(Matrix A){
		int m = A.getNumRows();
		int n = A.getNumCols();
		
		for(int k = 0; k < m; k++){
			int pivot=0;
			
			for(int j=k; j < m; j++){
				if( pivot < Math.abs(A.getElement(j, k)) ){
					pivot = j;
				}
			}
			/*
			if(A.getElement(pivot, k) == 0){
				throw new IllegalArgumentException("Matrix is singular!");
			}*/
			System.out.println("Before row swap " + A);
			if(k != pivot)
				A.swapRows(k, pivot);

			System.out.println("After row swap " + A);
			for(int i=k+1; i < m; i++){
				A.addRowMultipliedByScalar( (-1)*(A.getElement(i, k)/A.getElement(k,k)), i, k);
			}

			System.out.println("After addition " + A);
			
		}
		
		//Make all diagonal elements = 1 
		for(int i = 0; i < m; i++){
			if(A.getElement(i, i) != 0){
				double scalar = (1/A.getElement(i, i));
				A.multiplyRowByScalar( scalar, i);
			}
		}
		

	
		//Round down elements of A
		A.roundElements();

		
		return A;
	}
	
	/**
	 * Finds the determinant, if it exists.
	 */
	public double findDeterminant(Matrix A){
		if(A.getNumCols() != A.getNumRows())
			throw new IllegalArgumentException("Non-square matrix");
		
		int n = A.getNumCols();
		

		boolean negative=false;
		
		for(int k = 0; k < n; k++){
			int pivot=0;
			
			for(int j=k; j < n; j++){
				if( pivot < Math.abs(A.getElement(j, k)) ){
					pivot = j;
				}
			}
			
			if(k != pivot){
				A.swapRows(k, pivot);

				if(!negative){
					negative = true;
				}else{
					negative = false;
				}
			}
			
			//For all rows below pivot
			for(int i=k+1; i < n; i++){
				A.addRowMultipliedByScalar( (-1)*(A.getElement(i, k)/A.getElement(k,k)), i, k);
			}
			
		}
		double det=A.getElement(0,0);
		for(int i = 1; i < n; i++){
			det *= A.getElement(i, i);
		}
		if(negative)
			det *= (-1);
		
		return det;
	}
	

	/**
	 * Inverts an nxn matrix A
	 * @param A
	 * @throws IllegalArgumentException if
	 * 			1) Matrix is not square
	 * 			3) Determinant == 0
	 */
	public Matrix invert(Matrix A){
		if(A.getNumCols() != A.getNumRows())
			throw new IllegalArgumentException("Non-square matrix");
		
		int n = A.getNumCols();
		double [][] identity = new double[n][n];
		for(int i = 0; i < n; i++)
			identity[i][i] = 1;
		
		Matrix I = new Matrix(identity);
		
		for(int k = 0; k < n; k++){
			int pivot=0;
		
			for(int j=k; j < n; j++){
				if( pivot < Math.abs(A.getElement(j, k)) ){
					pivot = j;
				}
			}
			
			if(k != pivot){
				A.swapRows(k, pivot);
				I.swapRows(k, pivot);
			}
			
			for(int i=k+1; i < n; i++){
				double scalar = (-1)*(A.getElement(i, k)/A.getElement(k,k));
				A.addRowMultipliedByScalar( scalar, i, k);
				I.addRowMultipliedByScalar( scalar, i, k);
			}
			
		}
		
		//Check that determinant is != 0 <=> matrix is invertible
		double det=A.getElement(0,0);
		for(int i = 1; i < n; i++){
			det *= A.getElement(i, i);
		}
		if(det == 0)
			throw new IllegalArgumentException("Matrix is not invertible!");

		//Make all diagonal elements = 1 
		for(int i = 0; i < n; i++){
			double scalar = (1/A.getElement(i, i));
			A.multiplyRowByScalar( scalar, i);
			I.multiplyRowByScalar( scalar, i);
		}

		/*
		 * Invariant: (Sort of)
		 * A[i, i] is the only element on row n.
		 * A[i, i] = 1.
		 * All diagonal elements are = 1.
		 * 
		 * Start at A[i, i], subtract A[i, i] (1) multiplied by
		 * the element in position A[i-1, i] from A[i-1, i]
		 * effectively making A[i-1, i] = 0.
		 * 
		 * Continue this for each element in the column i.
		 * 
		 * Go to A[i-1, i-1] and repeat the procedure.
		 */
		for(int i = n-1; i > 0; i--){
			for(int j = 0; j < i; j++){
				double scalar = (-1)*(A.getElement(i, i)*A.getElement(j,i));
				A.addRowMultipliedByScalar( scalar, j, i);
				I.addRowMultipliedByScalar( scalar, j, i);
			}
		}

		//Round down elements of I
		I.roundElements();
		return I;
	}
	

}
