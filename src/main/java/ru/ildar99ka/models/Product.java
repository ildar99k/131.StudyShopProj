package ru.ildar99ka.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
@Entity
@AllArgsConstructor
@Data
@Table(name = "Product")
public class Product {
    @Id
    long articul;
    double price;
    String name;
    @ManyToOne
    @JoinColumn(name = "id")
    Category category;
    String producer;
    String description;
    String amount;
}
