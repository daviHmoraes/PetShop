package model.repository;

import model.entity.Atendimento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AtendimentoRepository {

    HashMap<Integer, Atendimento> mapa = new HashMap<>();

    public void salvar(Atendimento atendimento){
        mapa.put(atendimento.getId(), atendimento);
    }

    public Atendimento buscarPorId(int id){
        return mapa.get(id);
    }

    public List<Atendimento> listar(){
        return new ArrayList<>(mapa.values());
    }

    public void remover(int id){
        mapa.remove(id);
    }

}