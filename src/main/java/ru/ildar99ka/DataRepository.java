package ru.ildar99ka;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.ildar99ka.exceptions.EmailNotExistException;
import ru.ildar99ka.models.Cart;
import ru.ildar99ka.models.Category;
import ru.ildar99ka.models.Product;
import ru.ildar99ka.models.User;

import java.awt.color.ProfileDataException;
import java.util.List;

public class DataRepository {
    public static boolean checkEmail(String email) {
        //language=HQL
        User user = HibernateUtil.getSessionFactory().openSession().find(User.class, email);
        return user==null;
    }
    public static User getUserByEmail(String email) throws EmailNotExistException {
        User user=HibernateUtil.getSessionFactory().openSession().find(User.class,email);
        if (user==null){
            throw new EmailNotExistException();
        }
        return user;
    }
    public static Cart getCartByEmail(String email){
        List<Cart> carts=HibernateUtil.getSessionFactory().openSession().createQuery("select cart from Cart cart inner join cart.user u where u.email='" + email + "'").list();
        return carts.isEmpty()?null:carts.get(0);
    }
    public static List<Category> getAllCategories(){
        //language=hql
        List<Category> categories=HibernateUtil.getSessionFactory().openSession().createQuery("from Category").list();
        return categories;
    }
    public static List<Product> getAllProducts(){
        List<Product> products=HibernateUtil.getSessionFactory().openSession().createQuery("from Product").list();
        return products;
    }
    public static void deleteProduct(Product product){
        HibernateUtil.getSessionFactory().openSession().delete(product);
    }
    public static Category getCategoryByName(String name){
        return HibernateUtil.getSessionFactory().openSession().find(Category.class,name);
    }
    public static <T> void saveObject(T object){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        session.save(object);
        transaction.commit();
    }
}
