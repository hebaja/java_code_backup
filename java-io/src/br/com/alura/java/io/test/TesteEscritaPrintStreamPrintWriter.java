package br.com.alura.java.io.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;

public class TesteEscritaPrintStreamPrintWriter {

	public static void main(String[] args) throws IOException {

		//Fluxo de entrada com arquivo
//		OutputStream fos = new FileOutputStream("texto.txt");
//		Writer osw = new OutputStreamWriter(fos);
//		BufferedWriter bw = new BufferedWriter(osw);
		
//		FileWriter fw = new FileWriter("texto3.txt");
//		BufferedWriter bw = new BufferedWriter(fw); //É melhor encapsular como buffer para ter acesso à metodos melhores
		
		PrintStream ps = new PrintStream("texto3.txt"); //também pode usar PrintWriter
		
		ps.println("I am but flesh, and flesh is week.");
		ps.println();
		ps.println("Can't be king of the world if you're a slave to the grind.");
		ps.println();
		ps.println("Trapped inside this octavarium.");
		
		ps.close();
			
		}
			
}


