package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer qtdDias;
    @ManyToOne
    private User usuario;
    @ManyToOne
    private Quarto quarto;
    private String diaEntrada;
    private Integer idUsuario;
    private Integer idQuarto;

    public Reserva() {};
    public Reserva(Integer id) {
        this.id = id;
        setQtdDias(0);
        setUsuario(new User());
        setQuarto(new Quarto());
        setDiaEntrada("");
    }

public Integer getIdUsuario() {
    return idUsuario;
}

public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
}

public Integer getIdQuarto() {
    return idQuarto;
}

public void setIdQuarto(Integer idQuarto) {
    this.idQuarto = idQuarto;
}
    public String diaEntradaFormatada(){
       String[] data = diaEntrada.split("-");
       return data[2]+"/"+data[1]+"/"+data[0];
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQtdDias() {
        return qtdDias;
    }

    public void setQtdDias(Integer qtdDias) {
        this.qtdDias = qtdDias;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public String getDiaEntrada() {
        return diaEntrada;
    }

    public void setDiaEntrada(String diaEntrada) {
        this.diaEntrada = diaEntrada;
    }
}
