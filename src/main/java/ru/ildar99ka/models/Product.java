package ru.ildar99ka.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ildar99ka.DataRepository;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;

@NoArgsConstructor
@Entity
@AllArgsConstructor
@Data
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long articul;
    double price;
    String name;
    @ManyToOne
    @JoinColumn(name = "category")
    Category category;
    String producer;
    String description;
    String amount;
    public void fillProduct(HttpServletRequest request) {
        setName(request.getParameter("name"));
        setAmount(request.getParameter("amount"));
        setPrice(Double.parseDouble(request.getParameter("price")));
        setProducer(request.getParameter("producer"));
        setDescription(request.getParameter("description"));
        setCategory(DataRepository.getCategoryByName(request.getParameter("category")));
    }
}
