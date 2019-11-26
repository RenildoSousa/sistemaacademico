package br.unitins.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Curso implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String nome;

    @ManyToOne
    private Instituicao instituicao;

    private static final long serialVersionUID = 1L;

    public Curso() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}