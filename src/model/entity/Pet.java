package model.entity;

public class Pet {

    private final int id;
    private static int idContador = 1;

    private String nome;
    private String especie;
    private Cliente cliente;

    public Pet(String nome, String especie, Cliente cliente) {

        setNome(nome);
        setEspecie(especie);
        setCliente(cliente);

        this.id = idContador++;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(!nome.isBlank()){
            this.nome = nome;
        } else {
            throw new RuntimeException("ERRO: O nome não pode ser vazio.");
        }
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        if(!especie.isBlank()){
            this.especie = especie;
        } else {
            throw new RuntimeException("ERRO: A espécie não pode ser vazia.");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if(cliente != null){
            this.cliente = cliente;
        } else {
            throw new RuntimeException("ERRO: O pet precisa estar vinculado a um cliente.");
        }
    }
}