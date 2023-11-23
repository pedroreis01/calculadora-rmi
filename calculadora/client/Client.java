import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    private Client() {}

    public static void main(String[] args) {

        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9400);
            ICalculadora calculadora = (ICalculadora) registry.lookup("ICalculadora");
			
			Scanner scanner = new Scanner(System.in);
			int escolha = -1;
			while(escolha != 0){

				System.out.println("Escolha a operação:");
				System.out.println("1 - Adição");
				System.out.println("2 - Subtração");
				System.out.println("3 - Multiplicação");
				System.out.println("4 - Divisão");
				System.out.println("0 - Sair");

				escolha = scanner.nextInt();
				
				if(escolha == 0){
					System.out.println("Saindo...");
					System.exit(0);
				}

				System.out.println("Digite o primeiro operando:");
				double operando1 = scanner.nextDouble();

				System.out.println("Digite o segundo operando:");
				double operando2 = scanner.nextDouble();

				double resultado = 0;

				switch (escolha) {
					case 1:
						resultado = calculadora.adicao(operando1, operando2);
						break;
					case 2:
						resultado = calculadora.subtracao(operando1, operando2);
						break;
					case 3:
						resultado = calculadora.multiplicacao(operando1, operando2);
						break;
					case 4:
						resultado = calculadora.divisao(operando1, operando2);
						break;
					default:
						System.out.println("Opção inválida.");
						System.exit(0);
				}

				System.out.println("Resultado: " + resultado);
			}
			
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}