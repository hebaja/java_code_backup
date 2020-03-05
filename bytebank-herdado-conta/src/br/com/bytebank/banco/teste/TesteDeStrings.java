package br.com.bytebank.banco.teste;

public class TesteDeStrings {

	public static void main(String[] args) {

		int[]idades = new int[5];
//		
//		idades[0] = 29;
//		idades[1] = 39;
//		idades[2] = 19;
//		idades[3] = 59;
//		idades[4] = 69;
//		
//		int idade4 = idades[4];
////		
////		int idade1 = 29;
////		int idade2 = 39;
////		int idade3 = 19;
////		int idade4 = 59;
////		int idade5 = 69;
//		
//		System.out.println(idade4);
//		System.out.println(idades.length);

		for(int i = 0; i < idades.length; i++) {
			idades[i] = i * i;
		}
		
		for(int i = 0; i < idades.length; i++) {
			System.out.println(idades[i]);
		}
		
	}

}
