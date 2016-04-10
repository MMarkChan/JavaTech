/**
 * Created by Mark on 2016/3/5.
 */
package jdbc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class JdbcRepository {
    @Autowired
    private JdbcOperations jdbcOperations;
    public List<Map<String,Object>> select(){
        List<Map<String,Object>> list = jdbcOperations.queryForList("select * from user");
        return list;
    }
}
