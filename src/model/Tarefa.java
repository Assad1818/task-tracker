package model;

public class Tarefa {

    private String nomeTarefa;
    private Status status;

    public Tarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
        this.status = Status.PARA_FAZER;
    }
    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return nomeTarefa + " [" + status + "]";
    }
}
