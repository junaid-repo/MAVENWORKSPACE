package excelProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;

/**
 * Hello world!
 *
 */
public class App3 {
	/*
	 * @Value("${upload-dir}") 
	 */
	private String username;
	public App3(@Value("${upload-dir}") String username) {
		
		this.username = username;
		System.out.println(username);
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
	///	App3 ob = new App3();
		

	}

	public static void createAFile(String tableName) {

		String location = "C:\\Users\\junai\\OneDrive\\Documents\\";
		String fileName = location + tableName + ".sql";
		System.out.println(fileName);

		try {
			File myObj = new File(fileName);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();

		}
	}

	public static void witeInAFile(String tableName, String tableScrpts) {

		String location = "C:\\Users\\junai\\OneDrive\\Documents\\";
		String fileName = location + tableName + ".sql";
		System.out.println(fileName);

		try {
			FileWriter myWriter = new FileWriter(fileName);
			myWriter.write(tableScrpts);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
