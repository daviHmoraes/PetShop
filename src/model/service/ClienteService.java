package model.service;

import model.entity.Cliente;
import model.repository.ClienteRepository;

import java.util.List;

public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void cadastrar(Cliente cliente) {

        if (clienteRepository.listar().stream()
                .anyMatch(c ->
                        c.getTelefone()
                                .equalsIgnoreCase(cliente.getTelefone()))) {

            throw new RuntimeException(
                    "ERRO: Esse telefone já está cadastrado."
            );
        }

        clienteRepository.salvar(cliente);
    }

    public Cliente buscarPorId(int id) {

        Cliente cliente =
                clienteRepository.buscarPorId(id);

        if (cliente == null) {

            throw new RuntimeException(
                    "ERRO: Cliente não encontrado."
            );
        }

        return cliente;
    }

    public List<Cliente> listar() {

        List<Cliente> lista =
                clienteRepository.listar();

        if (lista.isEmpty()) {

            throw new RuntimeException(
                    "ERRO: Lista vazia."
            );
        }

        return lista;
    }
}