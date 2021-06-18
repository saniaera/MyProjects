package user;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LockedMeMainClass {
	UserOperation oUserOperation = new UserOperation();
	UserInputList oUserInputList = new UserInputList();
	String arrMainMenu[] = { "0", "1", "2" };
	String arrSubMenu[] = { "3", "4", "5", "6" };
	boolean testMenu = false;

	// Check User Input
	public boolean checkMenu(String[] arr, String toCheckValue) {
		boolean test = false;
		for (String element : arr) {
			if (element.equals(toCheckValue)) {
				test = true;
			}
		}
		return test;
	}

	// Show File Name inthe Directory
	public void doPrintFileName() {
		System.out.println(" The Root Directory Contain File :");
		String[] pathnames;
		File f = new File("user_dir/");
		pathnames = f.list();// contains exist file
		Arrays.sort(pathnames);
		List<String> filesName = Arrays.asList(pathnames);
		for (String filename : filesName) {
			System.out.println(filename);
		}
		System.out.println("--------------------------------------------------");
	}

	public void showUserOptionMenu() {
		System.out.println(" User Sub Menu ");
		System.out.println("============================");
		System.out.println("To Add File Type 3");
		System.out.println("To Delete File Type 4");
		System.out.println("To Search File Type 5");
		System.out.println("Back To Mainmenu Type 6");
		// showUserOption();
		String userOption2 = "";
		userOption2 = oUserInputList.doScan();
		if (checkMenu(arrSubMenu, userOption2)) {
			if (userOption2.equals("3")) {
				oUserOperation.doAdd();
				this.showUserOptionMenu();
			} else if (userOption2.equals("4")) {
				oUserOperation.doDelete();
				this.showUserOptionMenu();
			} else if (userOption2.equals("5")) {
				oUserOperation.doSearch();
				this.showUserOptionMenu();
			} else if (userOption2.equals("6")) {
				showMenu();
			}
		} else {
			System.out.println("Please type a valid input again ");
			this.showUserOptionMenu();
		}
	}

	public void showMenu() {
		System.out.println(" Main Menu ");
		System.out.println("============================");
		System.out.println("To Show the Files in the Folder Type 1 ");
		System.out.println("To Show the User Option Type 2 ");
		System.out.println("To Exit Type 0");
		String userOption = "";
		userOption = oUserInputList.doScan();
		if (checkMenu(arrMainMenu, userOption)) {
			if (userOption.equals("1")) {
				doPrintFileName();
				this.showMenu();
			} else if (userOption.equals("2")) {
				showUserOptionMenu();
			} else if (userOption.equals("0")) {
				System.exit(0);
				System.out.println("Application Terminated");
			}
		} else {
			System.out.println("Please type a valid input again ");
			this.showMenu();
		}
	}

	public static void main(String[] args) {
		LockedMeMainClass oLockedMeMainClass = new LockedMeMainClass();
		String userOption = "";
		System.out.println("..........................:: Welcome to LochedMe.com ::....................................");
		System.out.println("Developer Name : Sania Rahman");
		System.out.println("------------------------------------------------------------");
		System.out.println("                     User Option                    ");
		System.out.println("=======================================================");
		oLockedMeMainClass.showMenu();
	}
}
