package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {


   private SessionFactory sessionFactory;

   @Autowired
   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().persist(user);

   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUserByCar(String model, String series) {
      String carHql = "FROM Car WHERE model = :model AND series = :series";
      Session session = sessionFactory.getCurrentSession();
      Query carQuery = session.createQuery(carHql);
      carQuery.setParameter("model", model);
      carQuery.setParameter("series", series);

      Car car = (Car) carQuery.uniqueResult();

      if (car != null) {
         return car.getOwnerCar();
      } else {
         return null;
      }
   }

}
