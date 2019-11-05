import java.util.ArrayList;
import java.util.Scanner;

public class Excercises {
	
	public static int removeDuplicates(int[] nums) {
        if(nums.length > 0){
        ArrayList<Integer> list = new ArrayList<Integer>(nums.length);
        
        for(int i=0; i<nums.length; i++){
            list.add(nums[i]);
        }
        
        int prev = nums[0];
        
        for(int i=1; i<list.size(); i++){
            
            
            if(list.get(i) ==  prev){
                System.out.println(list.get(i));
                list.remove(i);
            }
            else{
                prev = list.get(i);
            }
        }
        return list.size();
        }
    return 0;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		/*
		boolean res = checkPermutation();
		System.out.println("Result: " +res);
		*/
		int[] arr = {1,1,2};
		removeDuplicates(arr);
	}
	
	private static String getStringInput(String inputMsg) {
		System.out.println(inputMsg);
		Scanner scan = new Scanner(System.in);

		String res = scan.nextLine();
		scan.close();
		return res;
	}
	
	/*
	 * 1.1 Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you 
		cannot use additional data structures?
	 */
	private static boolean isUnique() {
		String input = getStringInput("Please enter input string:");
		
		if(input.length() > 128) {
			return false;
		}
		else {
			boolean charPresence[] = new boolean[128];
			
			for(int i=0; i<input.length(); i++) {
				int charAscii = input.charAt(i);
				
				if(!charPresence[charAscii]) {
					charPresence[charAscii] = true;
				}
				else{
					return false;
				}
			}
			return true;
		}
	}
	
	/*
	 * 1.2 Check Permutation: Given two strings, write a method to decide if one is a permutation of the 
	   other.
	 */
	private static boolean checkPermutation() {
		String input1 = getStringInput("Please enter input string 1:"),
				input2 = getStringInput("Please enter input string 2:");
		
		if(input1.length() != input2.length()) {
			return false;
		}
				
		int asciiCnt = 0;
		for(int i=0; i<input1.length(); i++) {
			asciiCnt += (int)input1.charAt(i);
			asciiCnt -= (int)input2.charAt(i);
		}
		return (asciiCnt == 0)? true: false;
	}
	
	/*
	 * 1.3 URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string 
		has sufficient space at the end to hold the additional characters,and that you are given the "true" 
		length of the string. (Note: If implementing in Java, please use a character array so that you can 
		perform this operation in place.) 
	 */
	private static void urlify(){
		String str = "G o T o He ll          ";
		
		char[] charArray = str.toCharArray();
		char[] charArray1 = str.toCharArray();
		
		int trueLength = 13, spaces = 0;
		for(int i=0; i<trueLength; i++) {	// count number of spaces
			if( charArray[i] == ' ')
				spaces++;
		}
		
		int index = (trueLength + spaces*2)-1;	// calculate last index from required size of new char arrangement
		for(int j=trueLength-1; j>=0; j--) {			
			if(charArray[j] == ' ') {
				charArray[index--] = '0';
				charArray[index--] = '2';
				charArray[index--] = '%';
			}else {
				charArray[index--] = charArray[j];
			}
		}
		System.out.println(charArray);
		System.out.println(charArray1);
	}

	/*
	 * 1.4 Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palin­
		drome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation 
		is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words. 
	 */
	private static boolean palindromePermutation() {
		String input = getStringInput("Please enter string:");
		input = input.replaceAll("\\s","").toLowerCase();
		
		int[] charOccurenceArr = new int[26];		
		for(int i=0; i<input.length(); i++) {
			charOccurenceArr[(int)input.charAt(i) - 97]++;
		}
		
		boolean isSingleAllowed = (input.length() % 2 == 0) ? false : true;
		for(int i=0; i<charOccurenceArr.length; i++) {			
			if(isSingleAllowed && charOccurenceArr[i] % 2 == 1) {
				isSingleAllowed = false;
			}
			else if( charOccurenceArr[i] % 2 == 0 ) {
				continue;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * 1.5 One Away: There are three types of edits that can be performed on strings: insert a character, 
		remove a character, or replace a character. Given two strings, write a function to check if they are 
		one edit (or zero edits) away.  
	 */
	private static boolean oneAway() {
		String ip1 = "Pales",
				ip2 = "Pale";

		if(ip1.length() == ip2.length()) {
			return checkOneReplaceAway(ip1, ip2);
		}
		else if(ip1.length() > ip2.length()){
			return checkOneCharAway(ip2, ip1);
		}
		else {
			return checkOneCharAway(ip1, ip2);
		}
	}
	
	private static boolean checkOneReplaceAway(String ip1, String ip2) {
		boolean isFoundChange = false;
		
		for(int i=0; i<ip1.length(); i++) {
			System.out.println(ip1.charAt(i) +", "+ ip2.charAt(i));
			if(ip1.charAt(i) != ip2.charAt(i)) {
				if(isFoundChange) {
					return false;
				}
				isFoundChange = true;
			}
		}
		return true;
	}
	
	private static boolean checkOneCharAway(String ip1, String ip2) {
		if(ip1.length() == ip2.length()-1) {
			int j=0;
			boolean isDetected =  false;
			for(int i=0; i<ip2.length(); i++) {
				if( j < ip1.length() ) {
					if( ip1.charAt(j) == ip2.charAt(i)) {
						j++;
					}
					else {
						if(isDetected) {
							return false;
						}
						isDetected = true;
					}
				}
			}
			return true;
		}
		return false;
	}
	
	/*
	 * 1.6: String Compression: Implement a method to perform basic string compression using the counts 
		of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the 
		"compressed" string would not become smaller than the original string, your method should return 
		the original string. You can assume the string has only uppercase and lowercase letters (a - z). 
	 * 
	 */
	private static String StringCompression() {
		String input = getStringInput("Please enter string:");
		char prevChar = input.charAt(0);
		
		StringBuilder sb = new StringBuilder();
		int count = 1;
		for(int i=1; i<input.length(); i++ ) {
			if(prevChar == input.charAt(i)) {
				count++;
			}
			else {
				sb.append(prevChar).append(String.valueOf(count));
				count =1;
				prevChar = input.charAt(i);
			}
		}
		sb.append(prevChar).append(String.valueOf(count));
		
		if(sb.length() > input.length()) {
			return input;
		}
		return sb.toString();
	}
	
	/*
	 * 1.8 Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and 
		column are set to 0. 
	 */
	private static void zeroMatrix() {
		int[][] mx = {{1, 7, 0, 0}, {9, 6, 9, 7}, {10, 12, 19, 6}, {10, 12, 19, 6}};
		printMatrix(mx, "INPUT MATRIX:\n");
		
		// Arrays to denote which rows and columns are to be zeroed out
		boolean[] rows = new boolean[mx.length];
		boolean[] cols = new boolean[mx[0].length];
		
		for(int i=0; i<mx.length; i++) {
			for(int j=0; j<mx[0].length; j++) {
				if(mx[i][j] == 0) {
					rows[i] = true;
					cols[j] = true;
				}
			}
		}
		
		// iterate over rows to nullify rows that are zeroed 
		for(int i=0; i<mx.length; i++) {
			if(rows[i]) {
				
				for(int j=0; j<mx[i].length; j++) {
					mx[i][j] = 0;
				}
			}
		}
		
		// iterate over columns to nullify columns that are zeroed
		for(int i=0; i<mx[0].length; i++) {
			if(cols[i]) {
				
				for(int j=0; j<mx.length; j++) {
					mx[j][i] = 0;
				}
			}
		}
		printMatrix(mx, "\n\nOUTPUT MATRIX:\n");
	}
	
	private static void rotateMatrix() {
		int[][] mx = {{1, 7, 0, 0}, {9, 6, 9, 7}, {10, 12, 19, 6}, {10, 12, 19, 6}};
		printMatrix(mx, "INPUT MATRIX:\n");
		
		for(int i=0; i<mx.length; i++) {
			for(int j=i; j<mx[0].length; j++) {
				int temp = mx[i][j];
				mx[i][j] = mx[j][i];
				mx[j][i] = temp;
			}
		}
		printMatrix(mx, "\n\nOUTPUT MATRIX:\n");
	}
	
	private static void printMatrix(int mx[][], String msg) {
		System.out.println(msg);
		
		for(int i=0; i<mx.length; i++) {
			for(int j=0; j<mx[0].length; j++) {
				System.out.print(mx[i][j] + " ");
			}
			System.out.println();
		}
	}
}
