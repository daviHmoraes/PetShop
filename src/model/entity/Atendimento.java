package model.entity;

public class Atendimento {

    private final int id;
    private static int idPlus = 1;

    private Pet pet;
    private String servico;
    private double valor;
    private StatusAtendimento status;

    public Atendimento(Pet pet, String servico, double valor){

        setPet(pet);
        setServico(servico);
        setValor(valor);

        this.status = StatusAtendimento.AGENDADO;
        this.id = idPlus++;
    }

    public int getId() {
        return id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        if(pet == null){
            throw new RuntimeException("ERRO: O pet não pode ser vazio.");
        } else {
            this.pet = pet;
        }
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        if(servico.isBlank()){
            throw new RuntimeException("ERRO: O serviço não pode ser vazio.");
        } else {
            this.servico = servico;
        }
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor <= 0){
            throw new RuntimeException("ERRO: O valor deve ser maior que zero.");
        } else {
            this.valor = valor;
        }
    }

    public StatusAtendimento getStatus() {
        return status;
    }

    public void setStatus(StatusAtendimento status) {
        this.status = status;
    }
}
