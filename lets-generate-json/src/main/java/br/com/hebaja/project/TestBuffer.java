package br.com.hebaja.project;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestBuffer {

	public static void main(String[] args) throws IOException  {
		FileInputStream fis = new FileInputStream("questions.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);

		String line = br.readLine();


		while(line != null) {
			System.out.println(line);
			line = br.readLine();
		}

		br.close();

	}
	
}
