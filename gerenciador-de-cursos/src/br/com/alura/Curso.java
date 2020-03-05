package br.com.alura;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class Curso {
	
	private String nome;
	private String instrutuor;
	private List<Aula> aulas = new ArrayList<Aula>();
	private Set<Aluno> alunos = new HashSet<>();
	private Map<Integer, Aluno> matriculaParaAluno = new HashMap<>();
	
	public Curso(String nome, String instrutuor) {
		super();
		this.nome = nome;
		this.instrutuor = instrutuor;
	}
	
	public List<Aula> getAulas() {
		return java.util.Collections.unmodifiableList(aulas);
	}

	public String getNome() {
		return nome;
	}
	
	public String getInstrutuor() {
		return instrutuor;
	}
	
	public void adiciona(Aula aula) {
		this.aulas.add(aula);
	}
	
	public int getTempoTotal() { //Com for ou stream
//		int tempoTotal = 0;
//		for (Aula aula : aulas) {
//			tempoTotal += aula.getTempo();
//		}
//		return tempoTotal;
		
		return this.aulas.stream().mapToInt(Aula::getTempo).sum();
	}
	
	@Override
	public String toString() {
		return "[Curso: " + this.nome + ", tempo total: " + this.getTempoTotal() + ", aulas: " + this.aulas +  "]";
	}

	public void matricula(Aluno aluno) {
		this.alunos.add(aluno);
		this.matriculaParaAluno.put(aluno.getNumeroMatricula(), aluno);
	}
	
	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(alunos);
	}

	public boolean estaMatriculadoAluno(Aluno aluno) {
		return this.alunos.contains(aluno);
	}

	public Aluno buscaMatriculado(int numero) {
		return matriculaParaAluno.get(numero);
		
	}
	
//	public Aluno buscaMatriculado(int numero) { ///Sem map
//		for (Aluno aluno : alunos) {
//			if(aluno.getNumeroMatricula() == numero) 
//				return aluno;
//		}
//
//		throw new NoSuchElementException("Matrícula não encontrada " + numero);
//	}
	
}
