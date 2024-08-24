package package1.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import package1.domain.entity.ClientEntity;

@Repository
public class ClientRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    String INSERT = "insert into client(name) values(?)";
    String SELECT_BY_ID = "select id, name from client where id = (?)";
    String SELECT_ALL = "select id, name from client";

    public ClientEntity save(@org.jetbrains.annotations.NotNull ClientEntity clientEntity) {
        jdbcTemplate.update(INSERT, clientEntity.getName());
        return clientEntity;
    }

    public List<ClientEntity> findAll() {
        return jdbcTemplate.query(SELECT_ALL, new ClientRowMapper());
    }

    public ClientEntity findById(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, new ClientRowMapper(), id);
    }


    private static class ClientRowMapper implements RowMapper<ClientEntity> {
        @Override
        public ClientEntity mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return new ClientEntity(resultSet.getInt("id"), resultSet.getString("name"));
        }
    }
}
