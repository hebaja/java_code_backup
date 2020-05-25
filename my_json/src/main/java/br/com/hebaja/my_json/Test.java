package br.com.hebaja.my_json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Consumer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Test {

	private static ArrayList<Question> questionsList = new ArrayList<Question>();

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		
		JSONParser jsonParser = new JSONParser();
		
		try {
			FileReader reader = new FileReader("phrasal_verbs_questions.json");
			Object obj = jsonParser.parse(reader);
			JSONArray questions = (JSONArray) obj;
			
//			questions.forEach(new Consumer() {
//				public void accept(Object quest) {
//					parseQuestionsObject( (JSONObject) quest );
//				}
//			});

			questions.forEach(new Consumer() {
				public void accept(Object o) {
					parseQuestionsObject((JSONObject) o);
				}
			});
			
			System.out.println(questionsList.get(1).getPrompt());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	private static void parseQuestionsObject(JSONObject questions) {
		
		JSONObject questionObject = (JSONObject) questions.get("question");
		
		String prompt = (String) questionObject.get("prompt");
//		System.out.println(prompt);
		
		String optionA = (String) questionObject.get("optionA");
//		System.out.println(optionA);
		
		String optionB = (String) questionObject.get("optionB");
//		System.out.println(optionB);
		
		String optionC = (String) questionObject.get("optionC");
//		System.out.println(optionC);
		
		String rightOption = (String) questionObject.get("rightOption");
//		System.out.println(rightOption);
		
		Question questionCreated = new Question();
		questionCreated.setPrompt(prompt);
		questionCreated.setOptionA(optionA);
		questionCreated.setOptionB(optionB);
		questionCreated.setOptionC(optionC);
		questionCreated.setRightOption(rightOption);
		
		questionsList.add(questionCreated);
		
		
		
	}
	
}