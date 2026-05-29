package model.entity;

public class Cliente {

    private static int idPlus = 1;
    private int id;
    private String nome;
    private String telefone;


    public Cliente(String nome, String telefone) {

        setNome(nome);
        setTelefone(telefone);
        this.id = idPlus++;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (!nome.isBlank()) {
            this.nome = nome;
        } else {
            throw new RuntimeException("ERRO: Nome não pode ser vazio.");
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (!telefone.isBlank()) {
            this.id = id;
        }else {
            throw new RuntimeException("ERRO: Telefone não pode ser vazio.");
        }
    }

    public int getId() {
        return id;
    }
}