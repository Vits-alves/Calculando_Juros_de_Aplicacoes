import java.util.Random;
import javax.swing.JOptionPane;
	//ALGUMAS VARIÁVEIS SÃO USADAS EM MAIS DE UM MÉTODO, DECLARADAS GLOBAIS.
public class Calculadora {       
	static int NumeroConta[] = new int [15];
	static int Num = 0;
	static String Nome = null;
	static double Valor = 0;
	static String Erro = null;
	static String NomeCliente[] = new String [15];
	static double ValorAplicado[] = new double [15];
	static double percentJuros;

	public static void leitura() {
		for (int i=0; i<NomeCliente.length; i++) {
			NomeCliente[i] = JOptionPane.showInputDialog("Nome do Cliente: ");
			ValorAplicado[i] = Double.parseDouble(JOptionPane.showInputDialog("Valor a ser aplicado: "));
			Random random = new Random();
			int num = random.nextInt(1000-1)+1;
			NumeroConta[i] = num;
			JOptionPane.showMessageDialog(null,"Nome: "+NomeCliente[i]+"\nNúmero da conta: "+NumeroConta[i]+
					"\nValor aplicado: "+ValorAplicado[i]);
		}
		Classificacao(NumeroConta, NomeCliente, ValorAplicado);
	
		String resp = JOptionPane.showInputDialog("Deseja voltar ao menu: ");
		if(resp.equals("Sim") || resp.equals("sim"))
			Menu();
		else
			System.exit(0);
	
	}
	//Classificar os arrays pelo NumeroConta em ordem crescente. 
	public static void Classificacao(int NumeroConta[], String NomeCliente[], double ValorAplicado[]) {
		int Aux1 = 0;
		String Aux2;
		double Aux3;
			for (int cont1 = 0; cont1<NumeroConta.length; cont1++) {
				for (int cont2 = cont1 +1; cont2 < NumeroConta.length; cont2++) {
					if (NumeroConta[cont1] > NumeroConta[cont2]) {
						Aux1=NumeroConta[cont1];
						NumeroConta[cont1] = NumeroConta[cont2];
						NumeroConta[cont2] = Aux1;
						
						Aux2 = NomeCliente[cont1];
						NomeCliente[cont1] = NomeCliente[cont2];
						NomeCliente[cont2] = Aux2;
						
						Aux3 = ValorAplicado[cont1];
						ValorAplicado[cont1] = ValorAplicado[cont2];
						ValorAplicado[cont2] = Aux3;
					}	
}
			}
			//MOSTRAR A MINHA CLASSIFICAÇÃO.	
			for (int i=0; i < NomeCliente.length;i++) {
				JOptionPane.showMessageDialog(null, "Cliente: "+NomeCliente[i]+ "\nNúmeroda conta: "+NumeroConta[i]+"\nValor Aplicado: "+
ValorAplicado[i],"INFORMAÇÕES", JOptionPane.INFORMATION_MESSAGE);
			}
			String resp = JOptionPane.showInputDialog("Deseja voltar ao menu: ");
			if (resp.equals("Sim") || resp.equals("sim"))
				Menu();
			else
				System.exit(0);
		}
	public static void pesquisar(int Num) {
		for (int cont=0; cont < NumeroConta.length; cont++) {
			if (NumeroConta[cont] == Num) {
					Num = NumeroConta[cont];
					Nome = NomeCliente[cont];
					Valor = ValorAplicado[cont];
					Exibir(Num,Nome,Valor);
		} 	
			}
		//SE NÃO ENCONTRAR O NÚMERO DA CONTA
		if (Nome == null) {
			Erro = "O CLIENTE NÃO ESTÁ CADASTRADO";
			ExibirErro(Erro);
		}
		String resp = JOptionPane.showInputDialog("Deseja voltar ao menu: ");
		if (resp.equals("Sim") || resp.equals("sim"))
			Menu();
		else
			System.exit(0);
		}
	public static void AplicarJuros(int Num, double percentJuros) {
		for (int cont=0; cont < NumeroConta.length; cont++) {
			if (NumeroConta[cont] == Num) {
				ValorAplicado[cont] = ValorAplicado[cont]+((percentJuros * ValorAplicado[cont])/100);
				Num = NumeroConta[cont];
				Nome = NomeCliente[cont];
				Valor = ValorAplicado[cont];
				Exibir(Num, Nome, Valor);   //EXIBIR OS DADOS JÁ COM O PERCENTUAL DE JUROS.
			} 
		}
		if(Nome == null) {
			Erro = "O CLIENTE NÃO ESTÁ CADASTRADO";
			ExibirErro(Erro); }
		String resp = JOptionPane.showInputDialog("Deseja voltar ao menu: ");
		if (resp.equals("Sim") || resp.equals("sim"))
			Menu();
		else
			System.exit(0);
	}
	public static void Exibir(int Num, String Nome, double Valor) {
		JOptionPane.showConfirmDialog(null, "Nome do cliente: "+ Nome+"\nNúmero da conta: "+Num+
				"\nValor Aplicado: "+ Valor, "INFORMAÇOES", JOptionPane.INFORMATION_MESSAGE );
		}
	public static void ExibirErro(String Erro) {
		JOptionPane.showConfirmDialog(null, Erro , "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
		}

	public static void Menu() {
		int Op;

		do {
		Op = Integer.parseInt(JOptionPane.showInputDialog("ESCOLHA A OPÇÃO DESEJADA: "
				+ "\n1 - LEITURA"
				+ "\n2 - APLICAR JUROS"
				+ "\n3 - PESQUISAR"
				+ "\n9 - ENCERRAR"));
		
			switch (Op) {
		
			case 1:
				leitura();
			case 2:
				Num = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta: "));
				percentJuros = Double.parseDouble(JOptionPane.showInputDialog("Digite o percentual de juros: "));
				AplicarJuros(Num,percentJuros);
			case 3:
				Num = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta: "));
				pesquisar(Num);
			case 9:
				System.exit(0);	
			default:
				JOptionPane.showMessageDialog(null, "Opção invalida!","ATENÇÃO",JOptionPane.INFORMATION_MESSAGE);
				String resp = JOptionPane.showInputDialog("Deseja voltar ao menu: ");
				if (resp.equals("Sim") || resp.equals("sim"))
					Menu();
				else
					System.exit(0);
			
		} 
			} while(Op != 9);
					}
	//MÉTODO MAIN.
	public static void main(String[] args) {
		
		Menu();
	}
		}
