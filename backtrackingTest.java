package backtracking;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;

public class backtrackingTest {

	@Test
	public void testSolve() {
		int[] i = {3,6,4,1,3,4,2,5,3,0};
		Stack<Character> expected = new Stack<Character>();
		Stack<Character> result = new Stack<Character>();
		result = Backtracking.solve(i);
		expected.push('R');
		expected.push('R');
		expected.push('R');
		expected.push('L');
		expected.push('R');
		expected.push('R');
		expected.push('L');
		expected.push('R');
		
		assertEquals (expected, result);
	}

	@Test
	public void testFindAllSolutions() {
		int[] i = {3,6,4,1,3,4,2,5,3,0};
		Set<Stack<Character>> result = new HashSet<Stack<Character>>();
		Set<Stack<Character>> expected = new HashSet<Stack<Character>>();
		Stack<Character> stack1 = new Stack<Character>();
		Stack<Character> stack2 = new Stack<Character>();
		Stack<Character> stack3 = new Stack<Character>();
		stack1.push('R');
		stack1.push('L');
		stack1.push('R');
		stack1.push('R');
		stack1.push('L');
		stack1.push('R');
		stack1.push('R');
		stack1.push('R');
		
		stack2.push('R');
		stack2.push('L');
		stack2.push('R');
		stack2.push('R');
		stack2.push('L');
		stack2.push('R');
		
		
		stack3.push('R');
		stack3.push('L');
		stack3.push('R');
		stack3.push('R');
		stack3.push('L');
		stack3.push('R');
		stack3.push('L');
		stack3.push('R');
		stack3.push('R');
		
		expected.add(stack1);
		expected.add(stack2);
		expected.add(stack3);
		
		result = Backtracking.findAllSolutions(i);
		
		assertEquals (expected, result);
		
	}
}
