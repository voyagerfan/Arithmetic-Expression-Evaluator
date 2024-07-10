package test.java;

import org.junit.jupiter.api.BeforeAll; 
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import main.java.InfixToPostfix;
import main.java.PostfixEvaluation;

public class TestExpressions {

    private static InfixToPostfix postfix_converter;
    private static PostfixEvaluation eval_converter;

    @BeforeAll
    public static void setUp() {
        postfix_converter = new InfixToPostfix();
        eval_converter = new PostfixEvaluation();
    }
    
    /**
     * Tests the addition of 2+2
     * @param 2+2
     */
    @Test
    public void test1_simpleAddition() {
        String postfix_val = postfix_converter.infix2postfix("2+2");
        int final_val = eval_converter.postfixEvaluation(postfix_val);
        assertEquals(4, final_val);
    }
    /**
     * Tests the subtraction of 10-5
     * @param "10-5"
     */
    @Test
    public void test2_simpleSubtraction() {
        String postfix_val = postfix_converter.infix2postfix("10-5");
        int final_val = eval_converter.postfixEvaluation(postfix_val);
        assertEquals(5, final_val);
    }
    
    /**
     * Tests the multiplication of 8 x 4
     * @param "8*4"
     */
    @Test
    public void test3_simpleMultiplication() {
        String postfix_val = postfix_converter.infix2postfix("8*4");
        int final_val = eval_converter.postfixEvaluation(postfix_val);
        assertEquals(32, final_val);
    }
    
    /**
     * Tests the multiplication of 8 x 4
     * @param "55/11"
     */
    @Test
    public void test4_simpleDivision() {
        String postfix_val = postfix_converter.infix2postfix("55/11");
        int final_val = eval_converter.postfixEvaluation(postfix_val);
        assertEquals(5, final_val);
    }
    
    /**
     * Tests the addition of 2+2 with brackets
     * @param "(2+2)"
     */
    @Test
    public void test5_addwithbrackets() {
        String postfix_val = postfix_converter.infix2postfix("(2+2)");
        int final_val = eval_converter.postfixEvaluation(postfix_val);
        assertEquals(4, final_val);
    }
    /**
     * Tests the addition of 2+2 with brackets and spaces
     * @param "(2+2)"
     */
    @Test
    public void test6_addwithbrackets_spaces() {
        String postfix_val = postfix_converter.infix2postfix("(2 + 2)");
        int final_val = eval_converter.postfixEvaluation(postfix_val);
        assertEquals(4, final_val);
    }
    
    /**
     * Tests the subtraction of 20-10 with brackets
     * @param "(20-10)"
     */
    @Test
    public void test7_subractwithbrackets() {
        String postfix_val = postfix_converter.infix2postfix("(20-10)");
        int final_val = eval_converter.postfixEvaluation(postfix_val);
        assertEquals(10, final_val);
    }
    /**
     * Tests the subtraction of 20-10 with brackets and spaces
     * @param "(20 - 10)"
     */
    @Test
    public void test8_subractwithbrackets_spaces() {
        String postfix_val = postfix_converter.infix2postfix("(20 - 10)");
        int final_val = eval_converter.postfixEvaluation(postfix_val);
        assertEquals(10, final_val);
    }
    
    /**
     * Tests the multiplication of 5*4 with brackets
     * @param "(5*4)"
     */
    @Test
    public void test9_multiplcationwithbrackets() {
        String postfix_val = postfix_converter.infix2postfix("(5*4)");
        int final_val = eval_converter.postfixEvaluation(postfix_val);
        assertEquals(20, final_val);
    }
    /**
     * Tests the multiplication of 5*4 with brackets and spaces
     * @param "(5 - 4)"
     */
    @Test
    public void test10_subractwithbrackets_spaces() {
        String postfix_val = postfix_converter.infix2postfix("(5 * 4)");
        int final_val = eval_converter.postfixEvaluation(postfix_val);
        assertEquals(20, final_val);
    }
    
    /**
     * Tests multiple operator expression w/ parenthesis
     * @param "(4+5)+(9+3)"
     */
    @Test
    public void test11() {
        String postfix_val = postfix_converter.infix2postfix("(4+5)+(9+3)");
        int final_val = eval_converter.postfixEvaluation(postfix_val);
        assertEquals(21, final_val);
    }
    
    /**
     * Tests multiple operator expression w/ parenthesis
     * @param "(9+3)-(4+5)"
     */
    @Test
    public void test12() {
        String postfix_val = postfix_converter.infix2postfix("(9+3)-(4+5)");
        int final_val = eval_converter.postfixEvaluation(postfix_val);
        assertEquals(3, final_val);
    }
    
    /**
     * Tests multiple operator expression w/ parenthesis
     * @param "(9+3)*(4+5)"
     */
    @Test
    public void test13() {
        String postfix_val = postfix_converter.infix2postfix("(9+3)*(4+5)");
        int final_val = eval_converter.postfixEvaluation(postfix_val);
        assertEquals(108, final_val);
    }
    
    /**
     * Tests multiple operator expression w/ parenthesis
     * @param "(9+3)/(3+0)"
     */
    @Test
    public void test14() {
        String postfix_val = postfix_converter.infix2postfix("(9+3)/(3+0)");
        int final_val = eval_converter.postfixEvaluation(postfix_val);
        assertEquals(4, final_val);
    }
    
    /**
     * Tests multiple operator expression w/ parenthesis
     * @param "(9/3)+(4*5)"
     */
    @Test
    public void test15() {
        String postfix_val = postfix_converter.infix2postfix("(9/3)+(4*5)");
        int final_val = eval_converter.postfixEvaluation(postfix_val);
        assertEquals(23, final_val);
    }
    
    /**
     * Tests multiple operator expression w/ parenthesis
     * @param "(9/3)+(5-1)"
     */
    @Test
    public void test16() {
        String postfix_val = postfix_converter.infix2postfix("(9/3)+(5-1)");
        int final_val = eval_converter.postfixEvaluation(postfix_val);
        assertEquals(7, final_val);
    }
    
    /**
     * Test precedence
     * @param "8*2+1-3*4/2"
     */
    @Test
    public void test17() {
        String postfix_val = postfix_converter.infix2postfix("8*2+1-3*4/2");
        int final_val = eval_converter.postfixEvaluation(postfix_val);
        assertEquals(11, final_val);
    }
    
    /**
     * Test precedence with spaces
     * @param "8*2+1-3*4/2"
     */
    @Test
    public void test18() {
        String postfix_val = postfix_converter.infix2postfix("8 * 2 + 1 - 3 * 4 / 2");
        int final_val = eval_converter.postfixEvaluation(postfix_val);
        assertEquals(11, final_val);
    }
    
}
