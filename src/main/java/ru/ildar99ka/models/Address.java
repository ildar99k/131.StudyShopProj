package ru.ildar99ka.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "Address")
@AllArgsConstructor
@Data
public class Address {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 int id;
 String city;
 String country;
 String street;
 String homeNum;
 String flatNum;
}
