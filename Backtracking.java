package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Using Backtracking to solve a given puzzle
 * 
 * @author Rajveer Parikh
 * @version February 10, 2015
 */

public class Backtracking {
	
	/**
     * Solves the given puzzle for a single solution
     * 
     * @param puzzle to be solved
     * @return Stack containing the result solution path or null in case of no solution
     */
	public static void main(String args[]){
		int[] i = {3,6,0,0,0};
		System.out.print(findAllSolutions(i));
	}
	public static Stack<Character> solve(int[] puzzle){
		Stack<Integer> stackIndex = new Stack<Integer>();
		Stack<Character> resultPath = new Stack<Character>();
		HashSet<Integer> visitedRight = new HashSet<Integer>();
		HashSet<Integer> visitedLeft = new HashSet<Integer>();
		int i = 0;
		stackIndex.push(i);
		int moveRight = 0;
		int moveLeft = 0;
		
		while(!stackIndex.empty()){
			moveRight = moveRight + puzzle[i];
			moveLeft = moveLeft - puzzle[i];
			if (i == puzzle.length-1){
				return resultPath;
			}
			else if ((moveRight <= (puzzle.length-1)) && (!visitedRight.contains(i))){
				resultPath.push('R');
				stackIndex.push(moveRight);
				visitedRight.add(i);
				i = moveRight;
				moveLeft = moveRight;
				continue;
			}
			else if ((moveLeft >= 0) && (!visitedLeft.contains(i))){
					resultPath.push('L');
					stackIndex.push(moveLeft);
					visitedLeft.add(i);
					i = moveLeft;
					moveRight = moveLeft;
					continue;
				}
			else{
				stackIndex.pop();
			}
		}
		return null;
	}
	
	/**
     * Recursively finds all solutions to a puzzle
     * 
     * @param currIndex The current Index of the puzzle you are on
     * @param puzzle The puzzle to be solved
     * @param visitedIndex Set of visited indices
     * @param resultPath Current path of solution
     * @param allPaths Current set of all solution paths
     * @return Set of all solution paths
     */
	public static Set<Stack<Character>> findGoal (int currIndex, int[] puzzle, HashSet<Integer> visitedIndex, Stack<Character> resultPath, Set<Stack<Character>> allPaths){
		int moveRight = currIndex + puzzle[currIndex];
		int moveLeft = currIndex - puzzle[currIndex];
		if (currIndex != puzzle.length -1){
			visitedIndex.add(currIndex);
			if ((moveRight <= puzzle.length - 1) && (!visitedIndex.contains(moveRight))){
				resultPath.push('R');
				findGoal(moveRight, puzzle, visitedIndex, resultPath, allPaths);
			}
			if ((moveLeft >= 0) && (!visitedIndex.contains(moveLeft))){
				resultPath.push('L');
				findGoal(moveLeft, puzzle, visitedIndex, resultPath, allPaths);
			}
		}
		else {
			allPaths.add(deepCopy(resultPath));
		}
		if (resultPath.size() >= 1){
			resultPath.pop();
			visitedIndex.remove(currIndex);
		}
		return allPaths;
	}
	
	/**
     * Creates a deep copy of the resultPath
     * 
     * @param resultPath Stack variable to make deep copy
     * @return deep copy of the resultPath
     */
	private static Stack<Character> deepCopy(Stack<Character> resultPath){
		Stack<Character> newStack = new Stack<Character>();
		ArrayList<Character> holder = new ArrayList<Character>();

		while(!resultPath.isEmpty()){
		char current = resultPath.pop();
		holder.add(0, current);
		newStack.push(current);
		}

		for (Character c : holder){
		resultPath.push(c);
		}

		return newStack;
	}
	
	/**
     * Calls the helper method findGoals to get all solution paths
     * 
     * @param puzzle Puzzle to be solved
     * @return Set of stacks containing all possible solutions to given puzzle
     */
	public static Set<Stack<Character>> findAllSolutions(int[] puzzle){
		Set<Stack<Character>> allPaths = new HashSet<Stack<Character>>();
		HashSet<Integer> visitedIndex = new HashSet<Integer>();
		Stack<Character> resultPath = new Stack<Character>();
		allPaths = findGoal(0, puzzle, visitedIndex, resultPath, allPaths);
		return allPaths;
	}
}

