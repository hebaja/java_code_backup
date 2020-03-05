package br.com.alura;

import java.util.Iterator;
import java.util.Set;

public class TestaCursoComAluno {

	public static void main(String[] args) {
		
		Curso javaColecoes = new Curso("Dominando as coleções Java", "Henrique Jarbas");
		
//		javaColecoes.getAulas().add(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com coleções", 22));
		
		Aluno a1 = new Aluno("Alberto Roberto", 34672);
		Aluno a2 = new Aluno("Fredegundo Fernandes", 34332);
		Aluno a3 = new Aluno("Bernardino Beranto", 34284);
		
		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		javaColecoes.matricula(a3);
		
		System.out.println("Todos os alunos matriculados:");
		
		Set<Aluno> alunos = javaColecoes.getAlunos();
		Iterator<Aluno> iterador = alunos.iterator();
		
		while(iterador.hasNext()) {
			Aluno proximo = iterador.next();
			System.out.println("While com iterador" + proximo);
		}
		
//		for(Aluno a : javaColecoes.getAlunos()) {
//			System.out.println(a);
//		}
		
//		javaColecoes.getAlunos().forEach(a -> {
//			System.out.println(a);
//		});
		
		System.out.println("O aluno " + a1 + " está matriculado?");
		System.out.println(javaColecoes.estaMatriculadoAluno(a1));
		
		Aluno beranto = new Aluno("Bernardino Beranto", 34284);
		System.out.println("Beranto está matriculado?");
		System.out.println(javaColecoes.estaMatriculadoAluno(beranto));

		System.out.println("------------------------------");
		System.out.println("a3 equals beranto?");
		System.out.println(a3.equals(beranto));
		//Obrigatoriamente o próximo é true
		
		System.out.println("------------------------------");
		System.out.println(a3.hashCode() == beranto.hashCode());
		
	}

}
