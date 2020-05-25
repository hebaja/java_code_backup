package br.com.hebaja.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class UseMap {

	public static void main(String[] args) throws IOException {

		InputStream fis = new FileInputStream("questions.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader brFile = new BufferedReader(isr);

        OutputStream fos = new FileOutputStream("questions_format.txt");
        Writer osw = new OutputStreamWriter(fos);
        BufferedWriter bwFile = new BufferedWriter(osw);

        String lineFile = brFile.readLine();

        int count = 0;

        while(lineFile != null){
            bwFile.write(lineFile + "/");
            lineFile = brFile.readLine();

            count++;

            if(count == 5) {
                count = 0;
                bwFile.newLine();
            }

        }

        bwFile.close();
        bwFile.close();

        BufferedReader br = new BufferedReader(new FileReader("questions_format.txt"));

        JSONArray jsonArray = new JSONArray();
        
        Map<String, String> questionsMap = new LinkedHashMap<>();


        String line;
        while((line = br.readLine()) != null) {
            String[] contents = line.split("/");

            String prompt = contents[0];
            String optionA = contents[1];
            String optionB = contents[2];
            String optionC = contents[3];
            String rightOption = contents[4];

//            jsonElements.add(prompt);
//            jsonElements.add(optionA);
//            jsonElements.add(optionB);
//            jsonElements.add(optionC);
//            jsonElements.add(rightOption);

            JSONObject jsonObject = new JSONObject();

            
            questionsMap.put("prompt", prompt);
            questionsMap.put("optionA", optionA);
            questionsMap.put("optionB", optionB);
            questionsMap.put("optionC", optionC);
            questionsMap.put("rightOption", rightOption);
            
            JSONObject questionJson = new JSONObject(questionsMap);
            
            jsonArray.put(questionJson);

        }

        JSONObject questions = new JSONObject();

        questions.put("questions", questionsMap);

        FileWriter fileWriter = new FileWriter("questions.json");
        fileWriter.write(questions.toString());
        fileWriter.flush();
        fileWriter.close();

    }
		
}
