package ru.chay.spring;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositor extends CrudRepository<Users,Long> {
    @Query("SELECT COUNT(*) FROM users")
    public Integer countByUsername();

}
