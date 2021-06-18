package user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class UserInputList {
	public String doScan() {
		String inputString = "";
		Scanner inputopt = new Scanner(System.in);
		inputopt = new Scanner(inputopt.nextLine());
		while (inputopt.hasNextLine()) {
			inputString = inputopt.nextLine();

		}
		inputopt.close();
		return inputString;
	}



}
