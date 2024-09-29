package package1.domain.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
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
    private EntityManager entityManager;


    @Transactional
    public ClientEntity save(ClientEntity clientEntity) {
        entityManager.persist(clientEntity);
        System.out.println(clientEntity.getId());
        return clientEntity;
    }
    @Transactional
    public List<ClientEntity> findAll() {
        TypedQuery<ClientEntity> query = entityManager.createQuery("SELECT c FROM ClientEntity c", ClientEntity.class);
        return query.getResultList();
    }

    @Transactional
    public ClientEntity findById(int id) {
        TypedQuery<ClientEntity> query = entityManager.createQuery("SELECT c FROM ClientEntity c WHERE c.id = :id", ClientEntity.class);
        query.setParameter("id", id);  // Substitui o parâmetro ":id" pelo valor da variável 'id'
        return query.getSingleResult();
    }

    @Transactional
    public List<ClientEntity> findByName(String name) {
        String jpql = "select c from client c where c.name like :name ";
        TypedQuery<ClientEntity> query = entityManager.createQuery(jpql, ClientEntity.class);
        query.setParameter("name",  "%" + name + "%");
        return query.getResultList();
    }

    @Transactional
    public void deleteById(int id) {
        delete(entityManager.find(ClientEntity.class, id));
    }
    @Transactional
    public void delete(ClientEntity clientEntity) {
        if (!entityManager.contains(clientEntity)) {
            entityManager.merge(clientEntity);
        }
        entityManager.remove(clientEntity);
    }

    @Transactional
    public ClientEntity update(ClientEntity clientEntity) {
        entityManager.merge(clientEntity);
        return clientEntity;
    }


}
