/*
 * Name: Curtis Lin
 * Student Number: 260770287
 */
import java.util.Arrays;
public class Phrases 
{
	public static void main(String[] args) {
		
	}
	public static String join(String[] combinedArr)
	{
		//initializing empty string
		String finalStr = "";
		
		for ( int i=0; i<combinedArr.length; i++)
		{
			if(i==combinedArr.length-1)
			{
				finalStr += combinedArr[i];
			}
			else
			{
				finalStr += combinedArr[i] + " ";
			}
		}
		return finalStr;
	}
	// method that finds a word in an array
	public static int findInStringArray(String str, String[] secArr)
	{
		int index = -1;
		
		for(int i=0; i<secArr.length; i++)
		{
			if(str.equalsIgnoreCase(secArr[i]))
			{
				index = i;
				return index;
			}
		}
		return index;
	}
	//method that converts the string into an array using the helper method which can find out how many words there are
	public static String[] tokenize(String str)
	{
		String[] arr = new String[helper(str) + 1];
		int index = 0;
		String s = "";
		for (char c : str.toCharArray()) {
			if (c == ' ') {
				arr[index++] = s;
				s = "";
			} else {
				s += c;
			}
		}
		arr[index] = s;
		return arr;
	}
	// counts the number of iterations, which also means the number of words
	public static int helper(String str)
	{
		int count = 0;
		for(int i = 0; i<str.length(); i++)
		{
			if( str.charAt(i) == ' ')
			{
				count++;
			}
		}
		return count;
	}
	//a method that combines the two array
	public static String[] combineArray(String[] arr1, String[] arr2, int a, int b)
	{
		String[] result = new String[a + arr2.length - b];
		int resultIndex = 0;
		for (int i = 0; i <= a; i++) {
			result[resultIndex++] = arr1[i];
		}
		for (int i = b + 1; i < arr2.length; i++) {
			result[resultIndex++] = arr2[i];
		}
		return result;
	}
	//a method that combines the two strings
	public static String combineStrings(String a, String b) 
	{
		String[] arr1 = tokenize(a);
		String[] arr2 = tokenize(b);
		for( int i = 0; i< arr1.length; i++) 
		{
			int j = findInStringArray(arr1[i], arr2);
			if (j != -1) 
			{
				String[] combinedArr = combineArray(arr1, arr2, i, j);
				return join(combinedArr);
			}
		}
		throw new IllegalArgumentException("Error: no common word found.");
	}	
}
