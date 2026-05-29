package model.service;

import model.entity.Cliente;
import model.entity.Pet;
import model.repository.ClienteRepository;
import model.repository.PetRepository;

import java.util.List;

public class PetService {

    private PetRepository petRepository;
    private ClienteRepository clienteRepository;

    public PetService(PetRepository petRepository, ClienteRepository clienteRepository) {
        this.petRepository = petRepository;
        this.clienteRepository = clienteRepository;
    }

    public void salvar(Pet pet) {

        Cliente cliente = clienteRepository.buscarPorId(pet.getCliente().getId());

        if (cliente == null) {
            throw new RuntimeException("ERRO: Não é possível cadastrar pet para cliente inexistente.");
        }

        petRepository.salvar(pet);
    }

    public Pet buscar(int id) {

        Pet pet = petRepository.buscarPorID(id);

        if (pet == null) {
            throw new RuntimeException("ERRO: Pet não encontrado.");
        } else {
            return pet;
        }
    }

    public List<Pet> listar() {

        List<Pet> lista = petRepository.listar();

        if (lista.isEmpty()) {
            throw new RuntimeException("ERRO: A lista esta vazia.");
        } else {
            return lista;
        }
    }
}