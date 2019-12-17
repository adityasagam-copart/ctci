package favourites;

import java.util.*;

/*
 * Given a list of positive integers nums and an int target, return indices of the two numbers such that they add up to a target - 30.
 * Conditions:
 * 	You will pick exactly 2 numbers.
 * 	You cannot pick the same element twice.
 * 	If you have muliple pairs, select the pair with the largest number.
 * 
 * 
 */
public class PairWithSum {
	
	public static void main(String[] args) {
		test(Arrays.asList(1, 10, 25, 35, 60), 90);
        test(Arrays.asList(20, 50, 40, 25, 30, 10, -50, 110), 90);
        test(Arrays.asList(5, 55, 40, 20, 30, 30), 90);
        test(Arrays.asList(10, 20, 45, 65, -10, -50, -45, -15), -30);
        test(Arrays.asList(90, 85, 75, 60, 120, 150, 125), 280);
    }
    
    private static void test(List<Integer> nums, int target) {
        System.out.println(getPairWthSum(nums, target));
    }
    
	static List<Integer> getPairWthSum(List<Integer> nums, int target){
		target -= 30;
		List<Integer> result = Arrays.asList(-1,-1);
		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		int largest = Integer.MIN_VALUE;
		
		for(int i=0; i< nums.size(); i++) {
			int currNum = nums.get(i);
			int complement = target - currNum;
			if(numMap.containsKey(complement) && (complement > largest || currNum > largest)) {
				result.set(0, numMap.get(complement));
				result.set(1, i);
				largest = Math.max(complement, currNum);
			}
			numMap.put(currNum, i);
		}
		return result;
	}
}
