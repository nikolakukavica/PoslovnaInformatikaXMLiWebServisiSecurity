package com.company.invoicing.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Entity
public class Currency{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long currency_id;

    /*@ManyToOne
    private Price_list_item price_list_item;*/

    @XmlElement
    @Column(length = 50)
    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @XmlElement
    @Column(length = 3)
    @NotNull
    @Size(min = 3, max = 3)
    private String abbreviation;

    @JsonIgnore
    @OneToMany(mappedBy="currency")
    private List<Price_list_item> price_list_items;

    public Currency(long currency_id, String name, String abbreviation, List<Price_list_item> price_list_items) {
        this.currency_id = currency_id;
        this.name = name;
        this.abbreviation = abbreviation;
        this.price_list_items = price_list_items;
    }

    public Currency(String name, String abbreviation, List<Price_list_item> price_list_items) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.price_list_items = price_list_items;
    }

    public Currency() {
    }

    public long getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(long currency_id) {
        this.currency_id = currency_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public List<Price_list_item> getPrice_list_items() {
        return price_list_items;
    }

    public void setPrice_list_items(List<Price_list_item> price_list_items) {
        this.price_list_items = price_list_items;
    }

    /*public Currency(Price_list_item price_list_item, String name, String abbreviation){
        super();
        this.price_list_item = price_list_item;
        this.name = name;
        this.abbreviation = abbreviation;

    }

    public Currency(long currency_id, Price_list_item price_list_item, String name, String abbreviation){
        super();
        this.currency_id = currency_id;
        this.price_list_item = price_list_item;
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public Currency(){}

    public long getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(long currency_id) {
        this.currency_id = currency_id;
    }

    public Price_list_item getPrice_list_item(){
        return price_list_item;
    }

    public void setPrice_list_item(Price_list_item price_list_item){
        this.price_list_item = price_list_item;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAbbreviation(){
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation){
        this.abbreviation = abbreviation;
    }*/

}
