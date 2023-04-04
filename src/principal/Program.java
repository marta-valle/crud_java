package principal;

import java.util.Scanner;

import controlleres.ClienteController;

public class Program {

	public static void main(String[] args) {
		System.out.println("(1) CADASTRAR CLIENTE");
		System.out.println("(2) ATUALIZAR CLIENTE");
		System.out.println("(3) EXCLUIR CLIENTE");
		System.out.println("(4) CONSULTAR CLIENTE");

		Scanner scanner = new Scanner(System.in);

		System.out.println("\n Entre com a Opção desejada...:");
		Integer opcao = Integer.parseInt(scanner.nextLine());

		ClienteController clienteController = new ClienteController();
	
		switch (opcao) {
		case 1:
			clienteController.cadastrarCliente();
			break;
		case 2:
			clienteController.atualizarCliente();
			break;
		case 3:
			clienteController.excluirCliente();
			break;
		case 4:
			clienteController.consultarCliente();
			break;
		default:
			System.out.println("\n Opção Inválida");

		}
	}

}
