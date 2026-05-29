package model.service;

import model.entity.Atendimento;
import model.entity.Pet;
import model.entity.StatusAtendimento;
import model.repository.AtendimentoRepository;

import java.util.List;

public class AtendimentoService {

    private AtendimentoRepository atendimentoRepository;
    private PetService petService;

    public AtendimentoService(AtendimentoRepository atendimentoRepository, PetService petService){
        this.atendimentoRepository = atendimentoRepository;
        this.petService = petService;
    }

    public void salvar(int idPet, String servico, double valor){

        Pet pet = petService.buscar(idPet);

        Atendimento atendimento = new Atendimento(pet, servico, valor);

        atendimentoRepository.salvar(atendimento);

    }

    public Atendimento buscarPorId(int id){
        if(atendimentoRepository.buscarPorId(id) == null){
            throw new RuntimeException("ERRO: Atendimento não encontrado.");
        } else {
            return atendimentoRepository.buscarPorId(id);
        }
    }

    public List<Atendimento> listar(){

        List<Atendimento> lista = atendimentoRepository.listar();

        if(lista.isEmpty()){
            throw new RuntimeException("ERRO: Nenhum atendimento foi registrado.");
        }

        return lista;
    }

    public void atualizarStatus(int idAtendimento, StatusAtendimento novoStatus){

        Atendimento atendimento = buscarPorId(idAtendimento);

        StatusAtendimento statusAtual = atendimento.getStatus();

        if(statusAtual == StatusAtendimento.FINALIZADO && novoStatus == StatusAtendimento.CANCELADO){
            throw new RuntimeException("ERRO: Não é permitido cancelar um atendimento finalizado");
        }

        if(statusAtual == StatusAtendimento.CANCELADO && novoStatus == StatusAtendimento.FINALIZADO){
            throw new RuntimeException("ERRO: Não é permitido finalizar um atendimento cancelado");
        }

        atendimento.setStatus(novoStatus);

        atendimentoRepository.salvar(atendimento);
    }

    public void remover(int id){

        buscarPorId(id);

        atendimentoRepository.remover(id);
    }

}