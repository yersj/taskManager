package com.example.demo.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private int priority;

    @Enumerated(EnumType.STRING)
    private StatusTask status;

    @ManyToOne(fetch = FetchType.EAGER)
    private Project project;}
