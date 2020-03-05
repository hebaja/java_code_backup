package br.com.hebaja;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuizPhrasalVerbs {

	public static void main(String[] args) throws FileNotFoundException {

		takeQuiz();

	}

	private static void takeQuiz() throws FileNotFoundException {
		
		//Creating a list of questions
		ArrayList<Question> questions = new ArrayList<>();

		//Scanner for question and options
		Scanner scannerQuestionOptions = new Scanner(new File("resources/questions.cvs"));
		
		//Scanner for right answers
		Scanner scannerRightAnswers = new Scanner(new File("resources/questions_answers.txt"));
		
		//Iterator for the questions exhibition
		int iterator = 0;
		
		int score = 0;
		
		//Starting a loop to populate the list of questions 
		while(scannerQuestionOptions.hasNextLine()) {
		
			//Scanner to build each question with its respective options
			String lineQuestionOptions = scannerQuestionOptions.nextLine();
			Scanner format = new Scanner(lineQuestionOptions);
			format.useDelimiter(",");
			
			populateQuestions(questions, format);

			//Print the question
			System.out.println(questions.get(iterator));
			
			iterator++;
			
			//scanner for keyboard input
			Scanner keyboardInput = new Scanner(System.in);
			String answerInput = keyboardInput.nextLine();

			//Scanner for selecting the question right answer
			String lineScannerRightAnswer = scannerRightAnswers.nextLine();			
			
			score = verifyRightAnswer(score, answerInput, lineScannerRightAnswer);
			
		}
			
		scannerQuestionOptions.close();
		System.out.println("Your score is: " + score);
	}

	private static int verifyRightAnswer(int score, String answerInput, String lineScannerRightAnswer) {
		//verify right answer
		if(answerInput.equals(lineScannerRightAnswer)){
			System.out.println();
			System.out.println("Right answer");
			System.out.println();
			score++;
		} else {
			System.out.println();
			System.out.println("Wrong answer");
			System.out.println();
		}
		return score;
	}

	private static void populateQuestions(ArrayList<Question> questions, Scanner format) {
		//Populating the list of questions
		Question question = new Question();
		String linePrompt = format.next();
		question.setPrompt(linePrompt);
		String lineOptionA = format.next();
		question.setOptionA(lineOptionA);
		String lineOptionB = format.next();
		question.setOptionB(lineOptionB);
		String lineOptionC = format.next();
		question.setOptionC(lineOptionC);
		questions.add(question);
	}
}
