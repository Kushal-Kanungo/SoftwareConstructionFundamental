package StringOperations;

import java.util.ArrayList;

/**
 * 
 * @author Kushal
 * @since 17 Oct 2022 5:00
 */
public class StringClass {

	/**
	 * Desc = We check length first, then we check each char one by one. 
	 * This Function check Strings case insensitive.
	 * 
	 * @param word1 String first
	 * @param word2 String second
	 * @return boolean if same true else false
	 */
	public boolean areEqual(String word1, String word2) {
		if (word1.length() != word2.length()) {
			return false;
		}
		for (int i = 0; i < word1.length(); i++) {
			if (charUpperCase(word1.charAt(i)) != charUpperCase(word2.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Reverse the string by taking characters from the last and appending it in
	 * result
	 * 
	 * @param word
	 * @return 
	 */
	public String reverseString(String word) {
		String result = "";
		for (int index = word.length() - 1; index >= 0; index--) {
			result += word.charAt(index);
		}
		return result;
	}

	/**
	 * To invert string we change ascii values of each character in string
	 * accordingly. For lower to upper case add 32 For upper to lower case subtract
	 * 32
	 * 
	 * 
	 * @param word
	 * @return inverted case string
	 */
	public String invertStringCase(String word) {
		String result = "";
		for (int i = 0; i < word.length(); i++) {
			int ascii = word.charAt(i);
			if (ascii >= 65 && ascii <= 90) {
				result += (char) (ascii + 32);
			} else if (ascii >= 97 && ascii <= 122) {
				result += (char) (ascii - 32);
			} else {
				result += (char) ascii;
			}
		}
		return result;
	}

	
	/**
	 * Description = We iterate a String and split it and save it in an Arraylist
	 * 
	 * @param stringValue
	 * @return
	 */
	public ArrayList<String> wordSplit(String stringValue) {
		String word = "";
		ArrayList<String> wordList = new ArrayList<String>();
		int idx = 0;
		while (idx < stringValue.length()) {
			if (stringValue.charAt(idx) == ' ' || stringValue.charAt(idx) == ',' || stringValue.charAt(idx) == '.') {
				if (word.length() > 0) {
					wordList.add(word);
				}
				word = "";
				idx++;
			} else {
				word += stringValue.charAt(idx);
				idx++;
			}
		}
		if (word.length() > 0) {
			wordList.add(word);
		}
		return wordList;
	}

	/**
	 * Desc = We first split the String in words using our wordSplit() func and then find max length
	 * string
	 * 
	 * @param sentence
	 * @return max length of word
	 */
	public String longestWord(String sentence) {
		ArrayList<String> wordList = wordSplit(sentence);
		String maxWord = "";
		for (String word : wordList) {
			if (maxWord.length() <= word.length()) {
				maxWord = word;
			}
		}
		return maxWord;
	}

	/**
	 * 
	 * This small function will return the upper case of a character.
	 * 
	 * @param character
	 * @return uppercased character
	 */
	private char charUpperCase(char character) {
		if (character >= 65 && character <= 90) {
			return (char) (character + 32);
		}
		return character;
	}

	
}
