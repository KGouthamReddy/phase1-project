package phase1;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class VirtualKeyPhase1 {
	static LinkedList<String> list = new LinkedList<>();
	static Scanner sc = new Scanner(System.in);
	static File path = new File("C:\\practice_project\\Files");
	static String[] files = path.list();

	private static void addingFiles() {
		for (String s : files) {
			list.add(s);
		}

	}

	public static void main(String[] args) throws IOException {
		
		System.out.println("\t\t Virtual Key for Your Repositories - Kasireddy Goutham Reddy (Developer)");
		System.out.println("Enter your Name: ");
		String developer = sc.nextLine();
		System.out.println("\n**************************************\n");
		System.out.println("\t\tWelcome   " + developer);
		System.out.println("\n**************************************");
		addingFiles();   //method for adding the files to the linked list
		
		//method for printing the options
		fileRepo();
		

	}

	private static void fileRepo() throws IOException {
		while (true) {
			System.out.println("\nSelect an option to continue: ");
			System.out.println("1. Show my files");
			System.out.println("2. Choose a feature");
			System.out.println("3. Close the application");

			int option = sc.nextInt();

			if (option == 1) {
				showFiles();
			} else if (option == 2) {
				chooseFeatures();
				break;
			} else if (option == 3) {
				System.out.println("Closed.");
				break;
			} else {
				System.out.println("...Please select from the given options...");
			}
		}

	}

	private static void showFiles() {
		Collections.sort(list);
		System.out.println(list);

	}

	private static void chooseFeatures() throws IOException {

		while (true) {
			System.out.println("\nChoose an option: \n 1. Add \n 2. Delete \n 3. Search \n 4. Main Menu \n");

			int feature = sc.nextInt();
			if (feature == 1) {
				addFile();
				
			} else if (feature == 2) {
				deleteFile();
				
			} else if (feature == 3) {
				searchFile();
			} else if (feature == 4) {
				fileRepo();
			} else {
				showFiles();
			}
		}
	}

	private static void addFile() throws IOException {
		System.out.println("Enter file name to add to your directory: ");

		String file = sc.next();
		File f = new File("C:\\practice_project\\Files", file);
		f.createNewFile();
		list.add(file);
		System.out.println("Your file is added into the directory \n");
	}

	private static void deleteFile() {
		showFiles();
		System.out.println("Enter the file from the above list to delete: ");
		String del = sc.next();
		System.out.println("Are you sure want to delete your file? ");
		String permission = sc.next();

		if (permission.equalsIgnoreCase("yes")) {
			if (list.contains(del)) {
				File f = new File("C:\\practice_project\\Files", del);
				f.delete();
				list.remove(del);
				System.out.println("Your file has been deleted. \n");
			} else {
				System.out.println("File not found.");
			}
		} else {
			System.out.println("Printing your files from the directory... \n" + list);
		}

	}

	private static void searchFile() {
		try {
			System.out.println("Enter the file name to search: ");
			String file = sc.next();
			File f = new File("C:\\practice_project\\Files", file);
			if (f.exists()) {
				System.out.println("\n" + file + " exists in the directory");
			} else {
				System.out.println("File Not Found");
			}
		} catch (Exception e) {
			System.out.println(e + "Exception is caught");
		}

	}

}
