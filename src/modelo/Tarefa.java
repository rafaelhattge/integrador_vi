/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Rafael
 */
public class Tarefa {
    private int idTarefa;
    private String nome;
    private Date data;
    private Time hora;
    private String descricao;
    private boolean status;
    private int idDisciplina;
    private String nomeDisciplina;

    public Tarefa() {
    }

    public Tarefa(int idTarefa, boolean status) {
        this.idTarefa = idTarefa;
        this.status = status;
    }
    
    

    public Tarefa(int idTarefa, String nome, Time hora) {
        this.idTarefa = idTarefa;
        this.nome = nome;
        this.hora = hora;
    }

    public Tarefa(int idTarefa, String nome, Date data, Time hora, String descricao, boolean status) {
        this.idTarefa = idTarefa;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.descricao = descricao;
        this.status = status;
    }
    
    

    public Tarefa(String nome, Date data, Time hora, String descricao, boolean status, int idDisciplina, String nomeDisciplina) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.descricao = descricao;
        this.status = status;
        this.idDisciplina = idDisciplina;
        this.nomeDisciplina = nomeDisciplina;
    }
    
    

    public Tarefa(int idTarefa, String nome, Date data, Time hora, String descricao, 
            boolean status, int idDisciplina, String nomeDisciplina) {
        this.idTarefa = idTarefa;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.descricao = descricao;
        this.status = status;
        this.idDisciplina = idDisciplina;
        this.nomeDisciplina = nomeDisciplina;
    }

    public int getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }
    
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }
    
    public void setNomeDisciplina(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
    }
}
