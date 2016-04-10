package hibernate.repository.containerjpa;

import hibernate.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

@Repository
@Transactional
public class ContainerJpaRepository {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;
    private EntityManager currentEntityManager(){
        return entityManagerFactory.createEntityManager();
    }

    public void save(User user){
        currentEntityManager().persist(user);
    }

    public User get(int id){
        return currentEntityManager().find(User.class,id);
    }

    public void query(){
        Query query = currentEntityManager().createQuery("from User");

        List list = query.getResultList();
        Iterator<User> it = list.iterator();
        while (it.hasNext()){
            User user = it.next();
            System.out.println(user.getFirstname());
        }
    }

}
