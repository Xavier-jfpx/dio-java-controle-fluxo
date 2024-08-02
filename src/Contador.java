
import java.util.Scanner;

public class Contador {
	public static void main(String[] args) throws Exception {
		System.out.println("Aplicação Controle de Fluxo - Desafio DIO");
		printSequencia(obterValores());

	}

	private static void printSequencia(int numero) {
		for (int i = 1; i <= numero; i++) {
			System.out.println("Imprimindo o número " + i);
		}
	}

	private static Integer obterValores() {
		Scanner terminal = new Scanner(System.in);
		int parametroUm = 0,
				parametroDois = 0;
		try {
			System.out.print("Digite o primeiro parâmetro: ");
			parametroUm = Integer.parseInt(terminal.nextLine());
			System.out.print("Digite o segundo parâmetro: ");
			parametroDois = Integer.parseInt(terminal.nextLine());
			contar(parametroUm, parametroDois);

		} catch (Exception e) {
			if (e.getClass() == ParametrosInvalidosException.class) {
				System.out.println("O segundo parâmetro deve ser maior que o primeiro.");
			} else if (e.getClass() == NumberFormatException.class) {
				System.out.println("Os parâmetros devem ser números inteiros.");
			} else {
				System.out.print(e.getClass());
			}
			return obterValores();
		} finally {
			terminal.close();
		}
		return parametroDois - parametroUm;
	}

	static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
		if (parametroUm > parametroDois)
			throw new ParametrosInvalidosException();
	}

}
