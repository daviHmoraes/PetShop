package controller;

import model.entity.Pet;
import model.service.PetService;

import java.util.List;

public class PetController {

    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    public void salvar(Pet pet){
        try{
            petService.salvar(pet);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    public Pet buscar(int id){
        try{
            return petService.buscar(id);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Pet> listar(){
        try{
            return petService.listar();
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}