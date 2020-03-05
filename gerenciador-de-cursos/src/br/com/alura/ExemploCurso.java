package br.com.alura;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CursoEscola {
    private String nome;
    private int alunos;

    public CursoEscola(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }
}

public class ExemploCurso {
	
	public static void main(String[] args) {
		
		List<CursoEscola> cursos = new ArrayList<CursoEscola>();
		cursos.add(new CursoEscola("Python", 45));
		cursos.add(new CursoEscola("JavaScript", 150));
		cursos.add(new CursoEscola("Java 8", 113));
		cursos.add(new CursoEscola("C", 55));
		
		cursos.sort(Comparator.comparing(CursoEscola::getAlunos));
		
//		cursos.forEach(c -> System.out.println(c.getNome()));
		
		cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.forEach(c -> System.out.println(c.getNome()));
			
		Stream<String> nomes = cursos.stream().map(CursoEscola::getNome);
		System.out.println(nomes);
		
		System.out.println("--------------------------------------------");
		
		cursos.stream()
			.filter(c -> c.getAlunos() >= 50)
//			.map(c -> c.getAlunos()) //usando lambda
			.map(CursoEscola::getAlunos) // usando reference
//			.forEach(x -> System.out.println(x));
			.forEach(System.out::println);
			
		System.out.println("--------------------------------------------");
		
		Optional<CursoEscola> optionalCurso = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.findAny();
		
		CursoEscola curso = optionalCurso.orElse(null);
		System.out.println(curso.getNome());
		
		optionalCurso.ifPresent(c -> System.out.println(c.getNome()));
		
		List<CursoEscola> resultado = cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.collect(Collectors.toList());
		
		cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toMap(
					c -> c.getNome(),
					c -> c.getAlunos()))
			.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos."));   
		
//		cursos.forEach(c -> System.out.println(c.getNome()));
	}

}
