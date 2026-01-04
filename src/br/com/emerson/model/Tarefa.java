package br.com.emerson.model;

public class Tarefa {
    private String descricao;
    private boolean concluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    public String getDescricao() { return descricao; }
    public boolean isConcluida() { return concluida; }
    public void setConcluida(boolean concluida) { this.concluida = concluida; }

    @Override
    public String toString() {
        return (concluida ? "[CONCLUÍDA] " : "[PENDENTE] ") + descricao;
    }
    
 // Adicione apenas isto ao final da sua classe Tarefa
    public String paraArquivo() {
        return descricao + ";" + concluida;
    }
}