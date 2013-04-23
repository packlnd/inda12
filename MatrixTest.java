
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
    /**
     * Default constructor for test class StringHashTest
     */
    public MatrixTest(){
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown(){
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
}
