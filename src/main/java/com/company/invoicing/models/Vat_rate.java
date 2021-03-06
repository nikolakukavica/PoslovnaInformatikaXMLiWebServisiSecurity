package com.company.invoicing.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Vat_rate{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long vat_rate_id;

    @ManyToOne
    @NotNull
    private Vat_type vat_type;

    @NotNull
    private Date date;

    @Column(precision=2, scale=2)
    @NotNull
    private double percentage_of_vatr;

    public Vat_rate(Vat_type vat_type, Date date, double percentage_of_vatr){
        super();
        this.vat_type = vat_type;
        this.date = date;
        this.percentage_of_vatr = percentage_of_vatr;

    }

    public Vat_rate(long vat_rate_id, Vat_type vat_type, Date date, double percentage_of_vatr){
        super();
        this.vat_rate_id = vat_rate_id;
        this.vat_type = vat_type;
        this.date = date;
        this.percentage_of_vatr = percentage_of_vatr;
    }

    public Vat_rate(){}

    public long getVat_rate_id() {
        return vat_rate_id;
    }

    public void setVat_rate_id(long vat_rate_id) {
        this.vat_rate_id = vat_rate_id;
    }

    public Vat_type getVat_type(){
        return vat_type;
    }

    public void setVat_type(Vat_type vat_type){
        this.vat_type = vat_type;
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public double getPercentage_of_vatr(){
        return percentage_of_vatr;
    }

    public void setPercentage_of_vatr(double percentage_of_vatr){
        this.percentage_of_vatr = percentage_of_vatr;
    }

    @Override
    public String toString() {
        return "Vat_rate{" +
                "vat_rate_id=" + vat_rate_id +
                ", vat_type=" + vat_type +
                ", date=" + date +
                ", percentage_of_vatr=" + percentage_of_vatr +
                '}';
    }
}
