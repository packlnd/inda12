

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
    	elements = new double[4][];
    	for(int i=0; i < 4; i++)
    		elements[i] = new double[4];
    	
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
    
}
