package br.unitins.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Nota implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Double nota1;
    @Column
    private Double nota2;
    @Column
    private Double exame;

    @OneToOne
    private Matricula matricula;

    public Nota() {
        super();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getNota1() {
        return nota1;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }

    public Double getExame() {
        return exame;
    }

    public void setExame(Double exame) {
        this.exame = exame;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
}