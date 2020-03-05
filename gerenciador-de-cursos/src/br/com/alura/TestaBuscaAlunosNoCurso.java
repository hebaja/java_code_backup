package br.com.alura;

public class TestaBuscaAlunosNoCurso {

	public static void main(String[] args) {
		
		Curso javaColecoes = new Curso("Strings em Java", "Henrique");
		
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
		
		System.out.println("Quem é o aluno com matricula 34284");
		Aluno aluno = javaColecoes.buscaMatriculado(34284);
		System.out.println("O aluno é : " + aluno);

	}

}
