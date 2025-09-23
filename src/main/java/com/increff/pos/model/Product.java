package com.increff.pos.model;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String barcode;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientMaster client;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double mrp;

    @Column(nullable = false)
    private String imgUrl;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public ClientMaster getClient() {
        return client;
    }

    public void setClient(ClientMaster client) {
        this.client = client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMrp() {
        return mrp;
    }

    public void setMrp(double mrp) {
        this.mrp = mrp;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
