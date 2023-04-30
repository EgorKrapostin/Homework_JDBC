import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class CityDAOImpl implements CityDAO{

    @Override
    public List<City> getAllCities() {
        EntityManager entityManager = createEntityManager();

        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT c FROM City c";
        TypedQuery<City> query = entityManager.createQuery(jpqlQuery, City.class);
        List<City> cities = query.getResultList();
        entityManager.getTransaction().commit();

        return cities;
    }

    @Override
    public City getCityById(int id) {
        EntityManager entityManager = createEntityManager();

        return entityManager.find(City.class, id);
    }

    @Override
    public void createCity(City city) {
        EntityManager entityManager = createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(city);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateCity(City city) {
        EntityManager entityManager = createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(city);
        entityManager.getTransaction().commit();

    }

    @Override
    public void deleteCity(City city) {
        EntityManager entityManager = createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.remove(city);
        entityManager.getTransaction().commit();
    }

    private static EntityManager createEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");

        return entityManagerFactory.createEntityManager();
    }
}
