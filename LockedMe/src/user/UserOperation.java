package user;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class UserOperation {
	UserInputList oUserInputList = new UserInputList();
	
	
	
	public void doAdd() {
		// User Add a File Name Start
		String userInputAdd = "";
		System.out.println("To Add a File Enter the file name : ");
		userInputAdd = oUserInputList.doScan();
		// File Write in Specific directory
		String absoluteFilePath = "user_dir/" + userInputAdd;
		File file = new File(absoluteFilePath);

		try {
			if (file.createNewFile()) {
				System.out.println("File Added Successfully");
				System.out.println("--------------------------------------");
			} else {
				System.out.println("File " + absoluteFilePath + " already exists");
				System.out.println("--------------------------------------");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		// User Add a File Name End

	}

	public void doDelete() {
		// Delete a File from the Directory
		String userInputDelete = "";
		System.out.println("To Delete a File Enter the file name : ");
		userInputDelete = oUserInputList.doScan();
		File fDelete = new File("user_dir/" + userInputDelete);
		if (fDelete.delete()) {
			System.out.println(userInputDelete + "  File Deleted Sucessfully");
			System.out.println("--------------------------------------");
		} else {
			System.out.println(userInputDelete + "  File Not Found !!!");
			System.out.println("--------------------------------------");
		}

		// Delete a File from the Directory
	}

	public void doSearch() {
		String userInputSearch = "";
		System.out.println("To Search a File Enter the file name : ");
		userInputSearch = oUserInputList.doScan();
		String[] filenames;
		File f = new File("user_dir/");
		filenames = f.list();// contains exist file
		Arrays.sort(filenames);
		int result = Arrays.binarySearch(filenames, userInputSearch);
		boolean test = result > 0 ? true : false;
		// Print the result
		if (result > 0) {
			System.out.println(userInputSearch + " File exist in the directory");
			System.out.println("--------------------------------------");
		} else {
			System.out.println(userInputSearch + " File Not Found in the directory");
			System.out.println("--------------------------------------");
		}
		// File Search

	}

}
