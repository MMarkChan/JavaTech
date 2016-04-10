package hibernate.repository.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class SpringDataJpaRepositoryHelper implements MixingFunctionality {
    @PersistenceContext
    private EntityManager em;
    public int eliteSweep(){
        String update =
                "UPDATE User u " +
                        "SET u.firstname = 'Elite' " +
                        "WHERE u.lastname = 'dongming' " +
                        "AND u.id IN (12,13)";
        return em.createQuery(update).executeUpdate();
    }
}
