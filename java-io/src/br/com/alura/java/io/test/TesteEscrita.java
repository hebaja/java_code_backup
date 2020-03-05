package br.com.alura.java.io.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class TesteEscrita {

	public static void main(String[] args) throws IOException {

		//Fluxo de entrada com arquivo
		OutputStream fos = new FileOutputStream("texto.txt");
		Writer osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);

		bw.write("I am but flesh, and flesh is week.");
		bw.newLine();
		bw.newLine();
		bw.write("Can't be king of the world if you're a slave to the grind.");;
		
		bw.close();
			
		}
			
}


