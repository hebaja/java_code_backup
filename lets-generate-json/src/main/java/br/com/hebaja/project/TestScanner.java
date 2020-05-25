package br.com.hebaja.project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class TestScanner {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		JSONObject questions = new JSONObject();

        JSONArray questionsList = new JSONArray();
        
        List<Question> questionsObjectList = new ArrayList<Question>();

        FileInputStream fis = new FileInputStream("questions.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        Scanner scanner = new Scanner(isr);
		
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner formattedLine = new Scanner(line);

            Question question = new Question();

            question.setPrompt(formattedLine.next());
            question.setOptionA(formattedLine.next());
            question.setOptionB(formattedLine.next());
            question.setOptionC(formattedLine.next());
            question.setRightOption(formattedLine.next());

            questionsObjectList.add(question);

        }

        scanner.close();
        
	}
	

}
