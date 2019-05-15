package ru.ildar99ka.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name ="Category")
public class Category {
    @Id
    String name;
}
