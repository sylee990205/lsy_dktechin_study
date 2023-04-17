package day16.exercise.mvclab.test;

import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.Test;

class AssumptionsDemo {
	   @Test
	    public void testAssumeTrue() {
	        assumeTrue(true);
	        // remainder of test
	    }
	 
	    @Test
	    public void testAssumeTrue2() {
	        assumeTrue(false);
	        // remainder of test
	    }
	 
	    @Test
	    public void testAssumeFalse() {
	        assumeFalse(false);
	        // remainder of test
	    }
	 
	    @Test
	    public void testAssumingThatTrue() {
	        assumingThat(true, () -> {
	            //실행 O
	            System.out.println("success1");
	        });
	    }
	 
	    @Test
	    public void testAssumingThatFalse() {
	        assumingThat(false, () -> {
	            //실행 X
	            System.out.println("success2");
	        });
	    }
}
