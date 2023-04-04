package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Cliente;
import factorie.ConnectionFactory;

public class ClienteRepository {

	// método para receber e cadastrar um cliente no banco de dados
	public void create(Cliente cliente) throws Exception {

		// abrindo conexão com o banco de dados
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();

		// escrevendo um comando em linguagem SQL para inserir um cliente no banco de
		// dados
		PreparedStatement statement = connection
				.prepareStatement("insert into cliente(nome, email, telefone, cpf) values(?,?,?,?)");
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getTelefone());
		statement.setString(4, cliente.getCpf());
		statement.execute();

		// fechando a conexão
		connection.close();
	}

	// método de receber e atualizar cliente no banco de dados.
	public void update(Cliente cliente) throws Exception {

		// abrir conexão com o banco de dados
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();

		// escrevendo um comando em linguagem SQL para atualizar u cliente no bd
		PreparedStatement statement = connection
				.prepareStatement("update cliente set nome=? ,  email = ? , telefone=? , cpf=? where idcliente=?");
		// update comando do PostegreSQL que é para subir atualização
		// where = indica que é o "idcliente" especifico, caso não tenha, tud sera
		// excluido.

		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getTelefone());
		statement.setString(4, cliente.getCpf());
		statement.setInt(5, cliente.getIdCliente());
		//executar
		statement.execute();
		//fechar a aplicação 
		connection.close();
	}

	public void delete(Cliente cliente) throws Exception {
		// abrindo conexão com bd
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();

		// Escrever um comando no sql para excluir um cliente.
		PreparedStatement statement = connection.prepareStatement("delete form cliente where idcliente=?");
		statement.setInt(1, cliente.getIdCliente());
		statement.execute();

		connection.close();

	}

	public List<Cliente> findAll() throws Exception{
		//Abrir conexao com bd.
		ConnectionFactory connectionFatory = new ConnectionFactory();
		Connection connection = connectionFatory.getConnection();
		
		//escrevendo um comando em linguagem SQL para consultar todos os clientes
		PreparedStatement statement = connection.prepareStatement("select * from cliente");
		ResultSet resultSet = statement.executeQuery();
	    
	    //declarando uma listagem de clientes
	    List<Cliente> lista = new ArrayList<Cliente>();
	    
	    //percorrendo cada registro obtido do bd
	    while(resultSet.next()) {
	    	
	    	Cliente cliente = new Cliente();
	    	cliente.setIdCliente( resultSet.getInt("idcliente"));
	    	cliente.setNome(resultSet.getString("nome"));
	    	cliente.setEmail(resultSet.getString("email"));
	    	cliente.setTelefone(resultSet.getString("Telefone"));
	    	cliente.setCpf(resultSet.getString("cpf"));
	    	
	    	//adicionar cada objeto cliente dentro da lista 
	    	lista.add(cliente);
	    }
	    //fechando conexão
	    connection.close();
	    return lista;
	    	
	    		
	}
}
