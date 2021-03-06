package com.nick.algorithms.implementations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Sherlock Holmes is getting paranoid about Professor Moriarty, his arch-enemy.
 * All his efforts to subdue Moriarty have been in vain. These days Sherlock is
 * working on a problem with Dr. Watson. Watson mentioned that the CIA has been
 * facing weird problems with their supercomputer, 'The Beast', recently.
 * 
 * This afternoon, Sherlock received a note from Moriarty, saying that he has
 * infected 'The Beast' with a virus. Moreover, the note had the number N
 * printed on it. After doing some calculations, Sherlock figured out that the
 * key to remove the virus is the largest Decent Number having N digits.
 * 
 * A Decent Number has the following properties:
 * 
 * 3, 5, or both as its digits. No other digit is allowed. Number of times 3
 * appears is divisible by 5. Number of times 5 appears is divisible by 3.
 * Meanwhile, the counter to the destruction of 'The Beast' is running very
 * fast. Can you save 'The Beast', and find the key before Sherlock?
 * 
 * Input Format The 1st line will contain an integer T, the number of test
 * cases. This is followed by T lines, each containing an integer N. i.e. the
 * number of digits in the number.
 * 
 * Output Format Largest Decent Number having N digits. If no such number
 * exists, tell Sherlock that he is wrong and print −1.
 * 
 * Constraints 1≤T≤20 1≤N≤100000
 * 
 * 
 * Sample Input
 * 
 * 4 1 3 5 11
 * 
 * Sample Output
 * 
 * -1 555 33333 55555533333
 * 
 * Explanation For N=1, there is no such number. For N=3, 555 is the only
 * possible number. For N=5, 33333 is the only possible number. For N=11,
 * 55555533333 and all permutations of these digits are valid numbers; among
 * them, the given number is the largest one.
 * 
 * @author nick.hansen
 *
 */
public class SherlockSolution {

	static void solveSherlockProblem(int in) {

		List<Long> longList = new ArrayList<>();

		List<String> toPermute = new ArrayList<>();
		toPermute.add("5");
		toPermute.add("3");

		permute(longList, "", toPermute, in);

		Collections.sort(longList);
		Collections.reverse(longList);
		for (Long s : longList) {
			if (isDecent(s)) {
				System.out.println(s);
				return;
			}
		}
		System.out.println("-1");
	}

	public static boolean isDecent(Long s) {
		String inString = s.toString();
		Integer threes = inString.replace("5", "").length();
		if (threes % 5 != 0) {
			return false;
		}
		Integer fives = inString.replace("3", "").length();
		if (fives % 3 != 0) {
			return false;
		}

		return true;
	}

	public static void permute(List<Long> list, String string,
			List<String> toPermute, int len) {
		if (string.length() == len) {
			list.add(Long.parseLong(string));
			return;
		}
		for (String s : toPermute)
			permute(list, string + s, toPermute, len);
	}

	/* Tail starts here */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			br.readLine();
			String line;
			while ((line = br.readLine()) != null && line.length() > 0) {
				int toFind = Integer.parseInt(line);
				solveSherlockProblem(toFind);
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
