package ru.ildar99ka.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ildar99ka.DataRepository;
import ru.ildar99ka.exceptions.EmailExistingException;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    String email;
    String name;
    String surname;
    String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address")
    Address address;
    String phone;
    public static User createUser(HttpServletRequest request) throws EmailExistingException {
        if (!DataRepository.checkEmail(request.getParameter("email"))){
            throw new EmailExistingException();
        }
        User user=new User();
        user.setName(request.getParameter("name"));
        user.setSurname(request.getParameter("surname"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        user.setPhone(request.getParameter("phone"));
        Address address=new Address();
        address.setCountry(request.getParameter("country"));
        address.setCity(request.getParameter("city"));
        address.setStreet(request.getParameter("street"));
        address.setHomeNum(request.getParameter("home"));
        address.setFlatNum(request.getParameter("flat"));
        //HibernateUtil.getSessionFactory().openSession().save(address);
        user.setAddress(address);
        return user;
    }
}
