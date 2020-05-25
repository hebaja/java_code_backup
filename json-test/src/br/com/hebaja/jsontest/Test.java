package br.com.hebaja.jsontest;

import org.json.JSONException;
import org.json.JSONObject;

public class Test {

	public static void main(String[] args) throws JSONException {
		
		JSONObject myObj = new JSONObject();
		
		myObj.put("titulo", "Json x Xml: a Batalha final");
		myObj.put("ano", 2012);
		myObj.put("genero", "Ação");
		
		String json_string = myObj.toString();
        System.out.println("objeto original -> " + json_string);
        System.out.println();
		
        myObj.put("titulo", "JSON x XML: o Confronto das Linguagens");
        json_string = myObj.toString();
        System.out.println("objeto com o título modificado -> " + json_string);
        System.out.println();
        
        String titulo = myObj.getString("titulo");
        Integer ano = myObj.getInt("ano");
        String genero = myObj.getString("genero");
        
        System.out.println("Título: " + titulo + " - " + "Ano: " + ano + " - " + "Gênero: " + genero);
        
        

	}

}
