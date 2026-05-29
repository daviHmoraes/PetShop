package model.repository;

import model.entity.Cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClienteRepository {

    private HashMap<Integer, Cliente> listaClientes =
            new HashMap<>();

    public void salvar(Cliente cliente) {

        listaClientes.put(cliente.getId(), cliente);
    }

    public Cliente buscarPorId(int id) {

        return listaClientes.get(id);
    }

    public List<Cliente> listar() {

        return new ArrayList<>(listaClientes.values());
    }
}