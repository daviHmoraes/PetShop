package model.repository;

import model.entity.Pet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PetRepository {

    HashMap<Integer, Pet> mapa = new HashMap<>();

    public void salvar(Pet pet) {
        mapa.put(pet.getId(), pet);
    }

    public Pet buscarPorID(int id) {
        return mapa.get(id);
    }

    public List<Pet> listar() {
        return new ArrayList<>(mapa.values());
    }

    public void remover(int id) {
        mapa.remove(id);
    }
}