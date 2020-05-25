package br.com.hebaja.project;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;

public class WriteFile {

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

            jsonObject.put("prompt", prompt);
            jsonObject.put("optionA", optionA);
            jsonObject.put("optionB", optionB);
            jsonObject.put("optionC", optionC);
            jsonObject.put("rightOption", rightOption);

            jsonArray.put(jsonObject);

        }

        JSONObject questions = new JSONObject();

        questions.put("questions", jsonArray);

        FileWriter fileWriter = new FileWriter("questions.json");
        fileWriter.write(questions.toString());
        fileWriter.flush();
        fileWriter.close();

    }

}
