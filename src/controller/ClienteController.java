package controller;

import model.entity.Cliente;
import model.service.ClienteService;

import java.util.List;

public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void cadastrar(Cliente cliente) {

        try {

            clienteService.cadastrar(cliente);

        } catch (RuntimeException e) {

            System.out.println(e.getMessage());
        }
    }

    public Cliente buscarPorId(int id) {

        try {

            return clienteService.buscarPorId(id);

        } catch (RuntimeException e) {

            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Cliente> listar() {

        try {

            return clienteService.listar();

        } catch (RuntimeException e) {

            System.out.println(e.getMessage());
            return null;
        }
    }
}