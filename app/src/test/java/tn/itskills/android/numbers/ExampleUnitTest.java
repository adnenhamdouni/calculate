package tn.itskills.android.numbers;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void testCheckMultipleThree() {
        boolean result = checkMultiple(1824, 3);
        assertTrue(result);
    }

    @Test
    public void testCheckNotMultipleThree() {
        boolean rBresult = checkMultiple(1823, 3);
        assertFalse(rBresult);
    }

    @Test
    public void testCheckMultipleFive() {
        boolean rBresult = checkMultiple(1825, 5);
        assertTrue(rBresult);
    }

    @Test
    public void testCheckNotMultipleFive() {
        boolean rBresult = checkMultiple(1824, 5);
        assertFalse(rBresult);
    }

    @Test
    public void testCalculate() {
        String rBresult = calculate(2, 22);
        assert rBresult.equals("H") || rBresult.equals("S") || rBresult.equals("i");
    }

    private String calculate(int pIMin, int pIMax) {

        int i = pIMin;
        String result = "";

        while (i < pIMax) {
            if (checkMultiple(i, 3)){
                result = "H";
            }
            if (checkMultiple(i, 5)){
                result = "S";
            }
            if (!checkMultiple(i, 3) && !checkMultiple(i, 5)) {
                result = "i";
            }
            i++;
        }


        return result;

    }

    private boolean checkMultiple(int pInumber, int pImultip) {
        boolean rBIsMultip = false;
        if (pInumber % pImultip == 0) {
            rBIsMultip = true;
        }
        return rBIsMultip;
    }

}