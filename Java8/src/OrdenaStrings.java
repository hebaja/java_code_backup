import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<String>();
		
		palavras.add("alura online");
		palavras.add("editor maluca");
		palavras.add("the riot act");

//		Comparator<String> comparador = new ComparadorPorTamanho();
		//Collections.sort(palavras, comparador);
//		palavras.sort(comparador);
		
//		palavras.sort((s1, s2) -> {        //LAMBDA
//			if(s1.length() < s2.length())
//				return -1;
//			if(s1.length() > s2.length())
//				return 1;
//			return 0;
//		});
		
//		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length())); //LAMBDA ENXUTO
		
		palavras.sort(Comparator.comparing(s -> s.length()));
		
		
		System.out.println(palavras);
		
//		for (String p : palavras) {
//			System.out.println(p);
//		}
		
//		Consumer<String> consumidor = new imprimeNaLinha(); //Não precisa ao por a linha abaixo (classe anônima

//		Consumer<String> consumidor = new Consumer<String>() {
//
//			@Override
//			public void accept(String s) {
//				 System.out.println(s);
//			}
//			
//		};

//		palavras.forEach(consumidor);
		
//		palavras.forEach(new Consumer<String>() { // não precisa se implementar lambda
//
//			@Override
//			public void accept(String s) {
//				 System.out.println(s);
//			}
//		
//	});
	
//		palavras.forEach((String s) -> { //lambda
//			System.out.println(s);
//		});
		
		palavras.forEach(s -> System.out.println(s)); //lambda enxuto

	}
	
}

//class imprimeNaLinha implements Consumer<String> { // Não precisa se implementar classe anônima
//
//	@Override
//	public void accept(String s) {
//		System.out.println(s);
//	}
//	
//}

//class ComparadorPorTamanho implements Comparator<String> { // Não precisa se implementar classe anônima
//
//	@Override
//	public int compare(String s1, String s2) {
//		if(s1.length() < s2.length())
//			return -1;
//		if(s1.length() > s2.length())
//			return 1;
//		return 0;
//	}
//	
//}