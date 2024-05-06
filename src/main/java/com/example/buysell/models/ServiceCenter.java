package com.example.buysell.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service_center")
public class ServiceCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "serviceCenter")
    private List<Service> services;

    @OneToMany(mappedBy = "serviceCenter")
    private List<Client> clients;

    @OneToMany(mappedBy = "serviceCenter")
    private List<Repair> repairs;

    @OneToMany(mappedBy = "serviceCenter")
    private List<SparePart> spareParts;

    @OneToMany(mappedBy = "serviceCenter")
    private List<Master> masters;

}