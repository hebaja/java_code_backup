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


public class TesteCapturarTeclado {

	public static void main(String[] args) throws IOException {

		//Fluxo de entrada com arquivo
		InputStream fis = System.in;
		Reader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
				
		OutputStream fos = System.out; //new FileOutputStream("texto_recebe.txt");
		Writer osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);

		String linha = br.readLine();
		
		while(linha != null && !linha.isEmpty()) {
			bw.write(linha);
			bw.newLine();
			//bw.flush(); // Descarrega o output no consoleTesteCopiarArquivo.java
			linha = br.readLine();
		}
		
		br.close();
		bw.close();
			
		}
			
}


