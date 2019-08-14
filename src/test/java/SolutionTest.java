import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {
    private int input;
    private int[][] expected;
    private Solution soln = new Solution1();

    public SolutionTest(int input, int[][] output) {
        this.input = input;
        this.expected = output;
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][]{
                {3,
                new int[][]{
                        {1,2,3},
                        {8,9,4},
                        {7,6,5}
                }},
                {4,
                new int[][]{
                        {1,2,3,4},
                        {12,13,14,5},
                        {11,16,15,6},
                        {10,9,8,7}
                }}
        });
    }

    @Test
    public void testGenerate() {
        assert(checkEqual(expected, soln.generateMatrix(input)));
    }

    private boolean checkEqual(int[][] expected, int[][] actual) {
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                if (expected[i][j] != actual[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}