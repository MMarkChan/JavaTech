package hibernate.repository.jpa;

import hibernate.model.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.persistence.*;
import java.util.Iterator;
import java.util.List;

@Repository
@Transactional
public class JpaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(User user){
        entityManager.persist(user);
    }



    public User get(int id){
        return entityManager.find(User.class,id);
    }

    public void query(){
        Query query = entityManager.createQuery("from User");

        List list = query.getResultList();
        Iterator<User> it = list.iterator();
        while (it.hasNext()){
            User user = it.next();
            System.out.println(user.getFirstname());
        }
    }

//    public List<User> queryByCriteria(){
//        return currentEntityManager().getCriteriaBuilder().e
//                .add(Restrictions.eq("name","cdm")).list();
//    }

}
