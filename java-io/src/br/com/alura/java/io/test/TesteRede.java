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
import java.net.Socket;


public class TesteRede {

	public static void main(String[] args) throws IOException {

		Socket s = new Socket();
		
		InputStream fis = s.getInputStream();
		Reader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
				
		OutputStream fos = s.getOutputStream(); 
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


