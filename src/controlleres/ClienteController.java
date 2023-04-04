package controlleres;

import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import repositories.ClienteRepository;

public class ClienteController {

	public void cadastrarCliente() {

		System.out.println("\n *****CADASTRAR CLIENTE *****\n");
		Scanner scanner = new Scanner(System.in);
		Cliente cliente = new Cliente();

		System.out.println("Nome do cliente.:");
		cliente.setNome(scanner.nextLine());

		System.out.println("Email..........:");
		cliente.setEmail(scanner.nextLine());

		System.out.println("Telefone..........:");
		cliente.setTelefone(scanner.nextLine());

		System.out.println(" CPF........:");
		cliente.setCpf(scanner.nextLine());

		ClienteRepository clienteRepository = new ClienteRepository();

		try {
			clienteRepository.create(cliente);
			System.out.println("\n Cliente cadastrado com sucesso!");
		} catch (Exception e) {
			System.out.println("\n Falha ao cadastrar cliente!");
			e.printStackTrace(); // Imprimir log de erro
		}
	}

	public void atualizarCliente() {

		System.out.println("\n *****ATUALIZAR CLIENTE *****\n");
		Scanner scanner = new Scanner(System.in);
		Cliente cliente = new Cliente();

		System.out.println("id cliente.:");
		cliente.setIdCliente(Integer.parseInt(scanner.nextLine()));

		System.out.println("Nome do cliente.:");
		cliente.setNome(scanner.nextLine());

		System.out.println("Email..........:");
		cliente.setEmail(scanner.nextLine());

		System.out.println("Telefone..........:");
		cliente.setTelefone(scanner.nextLine());

		System.out.println(" CPF........:");
		cliente.setCpf(scanner.nextLine());

		ClienteRepository clienteRepository = new ClienteRepository();
		try {
			clienteRepository.update(cliente);
			System.out.println("\n Cliente Atualizado com Sucesso");

		} catch (Exception e) {
			System.out.println("\n Falha ao atualizar cliente");
			e.printStackTrace();
		}
	}

	public void excluirCliente() {

		System.out.println("\n *****EXCLUIR CLIENTE *****\n");
		Scanner scanner = new Scanner(System.in);
		Cliente cliente = new Cliente();

		System.out.println("id cliente.:");
		cliente.setIdCliente(Integer.parseInt(scanner.nextLine()));

		ClienteRepository clienteRepository = new ClienteRepository();

		try {
			clienteRepository.delete(cliente);
			System.out.println("\nCliente Excluido com sucesso!");

		} catch (Exception e) {

			System.out.println("\n FALHA AO EXCLUIR CLIENTE");

			e.printStackTrace();// imprimir log

		}

	}

	public void consultarCliente() {
		ClienteRepository clienteRepository = new ClienteRepository();

		try {
			List<Cliente> lista = clienteRepository.findAll();

			for (Cliente cliente : lista) { // foreach

				System.out.println("ID CLIENTE.............: " + cliente.getIdCliente());
				System.out.println("NOME DO CLIENTE........: " + cliente.getNome());
				System.out.println("EMAIL..................: " + cliente.getEmail());
				System.out.println("Telefone...............:" + cliente.getTelefone());
				System.out.println("CPF....................:" + cliente.getCpf());
				System.out.println("...");
			}
		} catch (Exception e) {
			System.out.println("\n Falha ao Consultar Clientes!");
			e.printStackTrace();

		}

	}
}
