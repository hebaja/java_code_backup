package br.com.alura;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class TestaAlunos {

	public static void main(String[] args) {
		
		Collection<String> alunos = new HashSet<>();
		alunos.add("João Peganamão");
		alunos.add("Robisberto Ferroso");
		alunos.add("Jupira Piracicaba");
		alunos.add("Valdisnei Silvoso");
		alunos.add("Romualdo Zica");
		alunos.add("Armênia Gelada");
		alunos.add("João Peganamão");
		
		boolean joaoEstaMatriculado = alunos.contains("João Peganamão");
		System.out.println(joaoEstaMatriculado);
		System.out.println("-------------------------------");
		System.out.println(alunos.size());
		System.out.println("-------------------------------");
		for (String aluno : alunos) {
			System.out.println(aluno);
		}
		
		System.out.println(alunos);
		
		System.out.println("-------------------------------");
		
		alunos.forEach(aluno -> {
			System.out.println(aluno);
		});
		
		List<String> alunosEmLista = new ArrayList<>(alunos);//Agora é possível ordenar.

	}

}
