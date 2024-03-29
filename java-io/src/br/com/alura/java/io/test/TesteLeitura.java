package br.com.alura.java.io.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class TesteLeitura {

	public static void main(String[] args) throws IOException {

		//Fluxo de entrada com arquivo
		InputStream fis = new FileInputStream("RARBG.txt");
		Reader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		String linha = br.readLine();
		
		while(linha != null) {
		
			System.out.println(linha);
			linha = br.readLine();
			
		}
		
		
		
		br.close();
		
	}

}
