package controller;

import model.entity.Atendimento;
import model.entity.StatusAtendimento;
import model.service.AtendimentoService;

import java.util.List;

public class AtendimentoController {

    private AtendimentoService atendimentoService;

    public AtendimentoController(AtendimentoService atendimentoService){
        this.atendimentoService = atendimentoService;
    }

    public void salvar(int idPet, String servico, double valor){
        try{
            atendimentoService.salvar(idPet, servico, valor);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    public Atendimento buscarPorId(int id){
        try{
            return atendimentoService.buscarPorId(id);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Atendimento> listar(){
        try{
            return atendimentoService.listar();
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void atualizarStatus(int id, StatusAtendimento novoStatus){
        try{
            atendimentoService.atualizarStatus(id, novoStatus);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    public void remover(int id){
        try{
            atendimentoService.remover(id);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}