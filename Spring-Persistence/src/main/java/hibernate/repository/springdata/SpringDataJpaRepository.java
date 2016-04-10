package hibernate.repository.springdata;

import hibernate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mark on 2016/3/6.
 */
@Repository
@Transactional
public interface SpringDataJpaRepository extends JpaRepository<User,Integer>,MixingFunctionality {
    public List<User> findByFirstname(String name);

    public List<User> findByFirstnameOrLastname(String first, String last);

    public List<User> findByIdGreaterThan(int id);

    public List<User> findByFirstnameIgnoringCaseOrLastnameIgnoringCase(String first, String last);

    public List<User> findByFirstnameOrLastnameAllIgnoringCase(String first, String last);

    public List<User> findByFirstnameOrderByFirstnameAsc(String name);
    public List<User> findByFirstnameOrderByFirstnameAscLastnameDesc(String name);

    @Query("select u from User u where u.email like '%gmail.com'")
    List<User> findAllGmailUsers();
}
