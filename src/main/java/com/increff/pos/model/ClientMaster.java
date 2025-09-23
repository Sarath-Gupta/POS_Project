package com.increff.pos.model;

import javax.persistence.*;

@Entity
@Table(name = "ClientMaster")
public class ClientMaster {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   @Column(nullable = false, unique = true, name = "client")
    private String client;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
