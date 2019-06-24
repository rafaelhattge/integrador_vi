/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Rafael
 */
public class Subtarefa {
    
    int idSubtarefa;
    String nome;
    boolean status;
    int idTarefa;
    String nomeTarefa;

    public Subtarefa() {
    }

    public Subtarefa(int idSubtarefa, boolean status) {
        this.idSubtarefa = idSubtarefa;
        this.status = status;
    }

    public Subtarefa(String nome, boolean status, int idTarefa) {
        this.nome = nome;
        this.status = status;
        this.idTarefa = idTarefa;
    }

    public Subtarefa(int idSubtarefa, String nome, boolean status, int idTarefa) {
        this.idSubtarefa = idSubtarefa;
        this.nome = nome;
        this.status = status;
        this.idTarefa = idTarefa;
    }

    public Subtarefa(int idSubtarefa, String nome, boolean status, int idTarefa, String nomeTarefa) {
        this.idSubtarefa = idSubtarefa;
        this.nome = nome;
        this.status = status;
        this.idTarefa = idTarefa;
        this.nomeTarefa = nomeTarefa;
    }

    public int getIdSubtarefa() {
        return idSubtarefa;
    }

    public void setIdSubtarefa(int idSubtarefa) {
        this.idSubtarefa = idSubtarefa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }
    
    
}
