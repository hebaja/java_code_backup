
public class TestaValores {
	
	public static void main(String[] args) {
		Conta conta = new Conta(1337, 24226);
		Conta conta2 = new Conta(1337, 26885);
		Conta conta3 = new Conta(1337, 98562);
		
		System.out.println(Conta.getTotal());
		
	}

}
