

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

/**
 * The test class MatrixTest.
 *
 * @author  Lasse Berglund
 * @version 2013-04-23
 */
public class MatrixTest{
	

	Matrix m0;
	Matrix m4x4;
	
	MatrixCalculator calc = new MatrixCalculator();
	double[][] elements;
	
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
    	m0 = new Matrix(4,4);
    	elements = new double[4][4];
    	
    	for(int i=0; i < 4; i++){
    		for(int j=0; j < 4; j++){
    			elements[i][j] = i+j;
    		}
    	}
    	
    	m4x4 = new Matrix(elements);
 
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown(){
    	m0=null;
    	elements = null;
    }
    
    /**
     * Test that an empty matrix is created properly.
     */
    @Test
    public void TestMatrix(){
    	Matrix m = new Matrix(4,4);
    	
    	for(int i = 0; i < 4; i++){
    		for(int j = 0; j < 4; j++){
    			assertEquals(0, m.getElement(i, j), 0.001);
    		}
    	}
    	
    }
    
    /**
     * Test that the getElementMethod performs as expected.
     * 
     */
    @Test
    public void TestgetElement(){
    	
    	//Negative index
    	try {
    		m0.getElement(-1, -1);
			fail();
		} catch (IndexOutOfBoundsException e) {
		}
    	//Too large index
    	try {
			m0.getElement(700, 700);
			fail();
		} catch (IndexOutOfBoundsException e) {
		}
    	
    	//Tests 4x4 matrix
    	for(int i = 0; i < 4; i++){
    		for(int j = 0; j < 4; j++){
    			assertEquals(i+j, m4x4.getElement(i, j), 0.001);
    		}
    	}
    	
    }
    
    /**
     * Tests the add(Matrix, Matrix) function.
     * 
     */
    @Test
    public void TestAddMatrix(){
    	Matrix m = calc.add(m0, m4x4);
    	
    	//Tests 4x4 matrix
    	for(int i = 0; i < 4; i++){
    		for(int j = 0; j < 4; j++){
    			assertEquals(i+j, m.getElement(i, j), 0.001);
    		}
    	}
    	
    	m = calc.add(m,m);
    	
    	for(int i = 0; i < 4; i++){
    		for(int j = 0; j < 4; j++){
    			assertEquals(2*(i+j), m.getElement(i, j), 0.001);
    		}
    	}
    	
    	Matrix m2x2 = new Matrix(2,2);
    	
    	try{
    		calc.add(m2x2, m4x4);
    		fail();
    	}catch (IllegalArgumentException e){
    	}
    	
    }
    
    /*
     * Tests the multiply(Matrix, Matrix).
     */
    @Test
    public void TestMultiplyMatrix(){
    	Matrix m = calc.multiply(m0, m4x4);
    	
    	//Tests 4x4 matrix
    	for(int i = 0; i < 4; i++){
    		for(int j = 0; j < 4; j++){
    			assertEquals(0, m.getElement(i, j), 0.001);
    		}
    	}
    	
    	//m += m4x4
    	m = calc.add(m4x4, m);
    	//m *= m
    	m = calc.multiply(m,m);

    	assertEquals(m.getElement(0, 0), 14, 0.001);
    	assertEquals(m.getElement(0, 1), 20, 0.001);
    	assertEquals(m.getElement(0, 2), 26, 0.001);
    	assertEquals(m.getElement(0, 3), 32, 0.001);

    	assertEquals(m.getElement(1, 0), 20, 0.001);
    	assertEquals(m.getElement(1, 1), 30, 0.001);
    	assertEquals(m.getElement(1, 2), 40, 0.001);
    	assertEquals(m.getElement(1, 3), 50, 0.001);

    	assertEquals(m.getElement(2, 0), 26, 0.001);
    	assertEquals(m.getElement(2, 1), 40, 0.001);
    	assertEquals(m.getElement(2, 2), 54, 0.001);
    	assertEquals(m.getElement(2, 3), 68, 0.001);
    	
    	assertEquals(m.getElement(3, 0), 32, 0.001);
    	assertEquals(m.getElement(3, 1), 50, 0.001);
    	assertEquals(m.getElement(3, 2), 68, 0.001);
    	assertEquals(m.getElement(3, 3), 86, 0.001);
    	
    	//Create row matrix filled with 2's
    	Matrix m4x1 = new Matrix(4, 1);	
    	m4x1.addElement(0, 0, 2.0);
    	m4x1.addElement(1, 0, 2.0);
    	m4x1.addElement(2, 0, 2.0);
    	m4x1.addElement(3, 0, 2.0);
    	
    	//Create col matrix filled with 2's
    	Matrix m1x4 = new Matrix(1, 4);
    	m1x4.addElement(0, 0, 2.0);
    	m1x4.addElement(0, 1, 2.0);
    	m1x4.addElement(0, 2, 2.0);
    	m1x4.addElement(0, 3, 2.0);
    	
    	//Tests that A*B != BA
    	m = calc.multiply(m1x4, m4x1);
    	assertEquals(m.getElement(0,0), 16, 0.001);
    	
    	m = calc.multiply(m4x1, m1x4);
    	assertEquals(m.getElement(0,0), 4, 0.001);
    	assertEquals(m.getElement(1,1), 4, 0.001);
    	assertEquals(m.getElement(2,2), 4, 0.001);
    	assertEquals(m.getElement(3,3), 4, 0.001);
    	
    	
    	//Tests that matrix multiplication doesn't work when 
    	//number of cols in A != number of rows in B
    	try{
    		calc.multiply(m1x4, m1x4);
    		fail();
    	}catch (IllegalArgumentException e){
    	}
    	
    }
    
    
    /**
     * Tests the toString method works properly.
     */
    public void TestToString(){
    	//4x4 matrix with all entries = 0
    	assertEquals("[[0.0 0.0 0.0 0.0][0.0 0.0 0.0 0.0][0.0 0.0 0.0 0.0][0.0 0.0 0.0 0.0]]", m0.toString());
    	//4x4 matrix where element at [i,j] = i+j
    	assertEquals("[[0.0 1.0 2.0 3.0][1.0 2.0 3.0 4.0][2.0 3.0 4.0 5.0][3.0 4.0 5.0 6.0]]", m4x4.toString());
    	
    	Matrix m = new Matrix(1,1);
    	m.addElement(1, 1, 7);
    	assertEquals("[[7]]", m.toString());
    }
}
