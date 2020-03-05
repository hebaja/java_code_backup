package br.com.hebaja;

public class Question {
	
	private String prompt;
	private String optionA;
	private String optionB;
	private String optionC;
	
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	
	public String getOptionA() {
		return optionA;
	}
	
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	
	public String getOptionB() {
		return optionB;
	}
	
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	
	public String getOptionC() {
		return optionC;
	}
	
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	
	@Override
	public String toString() {
		return this.prompt + "\n" + this.optionA + "\n" + this.optionB + "\n" + this.optionC +"\n";
	}
	
	
	
}