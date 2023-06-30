package br.edu.ifsuldeminas.mch.webii.crudmanager.model;

import java.text.DecimalFormat;

import javax.persistence.*;

@Entity
@Table(name="quartos")
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String numero;
    private double precoDiaria;
    private String status;
    private String tipo;

    public Quarto(){};
    public Quarto(Integer id) {
        this.id = id;
        setNumero("");
        setPrecoDiaria(0.0);
        setStatus("");
        setTipo("");
    }
    public String formateMoeda(){
        DecimalFormat formatoReal = new DecimalFormat("R$ #,##0.00");
        return formatoReal.format(precoDiaria);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(Double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
