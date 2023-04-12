/*
 * Author:Shawn Klempin
 * Course:COP 3503
 * Project #:1
 * Title:Word Statistics
 * Due Date:2/24/23
 * 
 * Allow user to select different statistics to run on a word list
 */
import java.util.Arrays;
import java.util.Scanner;

/**
 * The Class Project to run word statistics on a list of words.
 */
public class Project1 
{

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args)
	{
		showMenu();
	}//end main
	
	/**
	 * Show menu. Where I call in other methods for the program.
	 */
	public static void showMenu()
	{
		Scanner scnr = new Scanner(System.in);
		boolean flag = true;
		String[] list;
		list = readWords(scnr);
		do {
			
			System.out.println("Please make a selection:");
			System.out.println("1) Display List Ordered");
			System.out.println("2) Display Word Length");
			System.out.println("3) Display List Statistics");
			System.out.println("4) Number of Odd/Even Words");
			System.out.println("5) Check for Prime Length");
			System.out.println("6) Enter New Word List");
			System.out.println("7) Quit Program");
			
			String selection = scnr.nextLine();
			
			switch(selection) {
			case "1":
				orderList(list);
				break;
			case "2":
			    wordLength(list);
				break;
			case "3":
				displayStats(list, calcChar(list), calcNoun(list));
				calcChar ( list);
				break;
			case "4":
			    countEvenOdd(list);
				break;
			case "5":
				   int numPrimeLength = countPrimeLength(list);
				    System.out.println("Number of Prime Length Words: " + numPrimeLength);
				break;
			case "6":
				list = readWords(scnr);
				break;
			case "7": 
				System.out.println("Thank You, Goodbye!");
				flag = false;
				break;
				
			default: System.out.println("Invalid Choice");
			}//end switch

		}while(flag);//end do
		scnr.close();
	}//end show menu
	
	/**
	 * Read words.
	 *Method to take in user input of words, creates an array list from them. 
	 * @param  scnr object to take in user list
	 * @return the the list of words as arylist as an array. 
	 */
	

	public static String [] readWords(Scanner scnr) 
	{
	System.out.println("Enter List of Words Separated by Spaces:");
	String wordList = scnr.nextLine();
	String[] aryList = wordList.split(" ");
	
	return aryList;
	
	}//end readWords
	
	/**
	 * Order list.
	 *Option 1 which orders word list 
	 * @param  the list of words
	 */
	public static void orderList(String[] list) 
	{
		Arrays.sort(list);
		System.out.println(Arrays.toString(list) + "\n");

	}//end order list
	
	/**
	 * Display stats.
	 *calls in reference other methods which run statistics 
	 *
	 * @param list the list of words 
	 * @param len the length of characters in list
	 * @param num the number of nouns in the list
	 */
	public static void displayStats (String [] list, int len, int num)
	{
	    int shortest = Integer.MAX_VALUE;
	    int longest = 0;

	    for (String word : list) {
	        int wordLen = word.length();
	        len += wordLen;

	        if (wordLen < shortest) {
	            shortest = wordLen;
	        }
	        if (wordLen > longest) {
	            longest = wordLen;
	        }

	    }

		
		System.out.println("Min Word Length: " + shortest);
		System.out.println("Max Word Length: "  + longest);
		System.out.println("Total Number of Characters: " + calcChar(list));
		System.out.println("Number of Nouns: " + num);
		System.out.println("Average Word Length: " + avgWord(list));
		findMode(list);

	}//end displayStats
	
	/**
	 * Calc char.
	 *
	 *able to calculate the number of characters in the list
	 * @param list the list of words
	 * @return totalLetters the length of characters in the list
	 */
	public static int calcChar(String[] list) 
	{
	    int totalLetters = 0;
	    for (String str : list) 
	    {
	        for (int i = 0; i < str.length(); i++) 
	        {
	            if (!Character.isWhitespace(str.charAt(i))) 
	            {
	            	totalLetters++;
	            }
	        }
	    }
	    return totalLetters;
	}
	
	/**
	 * Calc noun.
	 * 
	 *able to determine how many captial letters in list then set that equal to number of nouns
	 * @param list the list of words
	 * @return the number of words that have a capital letter 
	 */
	public static int calcNoun(String[] list) 
	{
	    int num = 0;
	    for (String str : list)
	    {
	        for (int i = 0; i < str.length(); i++)
	        {
	            char ch = str.charAt(i);
	            if (ch >= 'A' && ch <= 'Z') 
	            {
	                num++;
	            }
	        }
	    }
	    return num;
	}//end calcNoun
	
	/**
	 * Avg word.
	 *
	 *Determines the avg length of each word
	 * @param list the list of words
	 * @return the average length of words 
	 */
	public static double avgWord(String[] list)
	{
	    int totalLength = 0;
	    for (String str : list) 
	    {
	        totalLength += str.length();
	    }
	    double avgLength = (double) totalLength / list.length;
	    return Math.round(avgLength * 100.0) / 100.0; 
	}
	
	/**
	 * Count even odd.
	 *
	 *Able to determine even and odd numbers of character in a word
	 * @param list the list of word
	 */
	public static void countEvenOdd(String[] list) {
	    int numEven = 0;
	    int numOdd = 0;
	    for (String word : list) {
	        if (word.length() % 2 == 0) {
	            numEven++;
	        } else {
	            numOdd++;
	        }
	    }
	    System.out.println("Number Even: " + numEven);
	    System.out.println("Number Odd: " + numOdd);
	}
	
	/**
	 * Word length.
	 *
	 *determine the length of words
	 * @param list the list of words
	 */
	public static void wordLength(String[] list) 
	{
	    for (String word : list) 
	    {
	        System.out.println(word + " Length is " + word.length());
	    }
	}
	
	/**
	 * Checks if is prime.
	 *
	 *able to determine if a number is a prime 
	 * @param sum the sum of words that have a prime number of words
	 * @return true, if number of characters in a word are prime
	 */
	public static boolean isPrime(int sum) 
	{
	    if (sum == 2) 
	    {
	        return true;
	    } else if (sum % 2 == 0 || sum == 1)
	    {
	        return false;
	    }

	    for (int i = 3; i <= Math.sqrt(sum); i += 2)
	    {
	        if (sum % i == 0) 
	        {
	            return false;
	        }
	    }

	    return true;
	
	}//end isPrime
	
	/**
	 * Count prime length.
	 *
	 *check to see if a word is prime the add to count
	 * @param list the list of words
	 * @return  if is prime then will count to total
	 */
	public static int countPrimeLength(String[] list)
	{
	    int count = 0;
	    for (String word : list) 
	    {
	        if (isPrime(word.length())) {
	            count++;
	        }

	    }
	    return count;
	}//end countPrimeLength
	
	/**
	 * Find mode.
	 *
	 *go through list of words and see if they are repeated
	 *if repeated will count as mode
	 * @param list the list of words
	 * compares current count of same words to max count
	 * if current is greater will become new max
	 * that word is saved until another word replaces it
	 */
	public static void findMode(String[] list) 
	{
	   if (list == null || list.length == 0)
	   {
	        System.out.println("No Mode");
	        return;
	    }

	    int maxCount = 1;
	    String mode = list[0];
	    for (int i = 0; i < list.length; i++) 
	    {
	        String currentWord = list[i];
	        int currentCount = 1;
	        for (int j = i + 1; j < list.length; j++)
	        {
	            if (currentWord.equalsIgnoreCase(list[j])) 
	            {
	                currentCount++;
	            }
	        }
	        if (currentCount > maxCount) {
	            maxCount = currentCount;
	            mode = currentWord;
	        } else if (currentCount == maxCount && currentWord.compareToIgnoreCase(mode) < 0) 
	        {
	            mode = currentWord;
	        }
	    }

	    if (maxCount == 1) {
	        System.out.println("No Mode");
	    } else {
	        System.out.println("Most Frequent Word: " + mode);
	    }
	}//end findMode
}//end class
