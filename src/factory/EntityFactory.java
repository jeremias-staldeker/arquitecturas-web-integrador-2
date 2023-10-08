package factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityFactory {
    private static final String PERSISTENCE_UNIT_NAME = "IntegradorParteDos";
    private static EntityManagerFactory em;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (em == null) {
        	em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return em;
    }

    /**
     * Para obtener y devolver un EntityManager que se puede utilizar para interactuar con la base de datos.
     * @return
     */
    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    /**
     * 
     */
    public static void closeEntityManagerFactory() {
        if (em != null && em.isOpen()) {
        	em.close();
        }
    }
    
    /**
     * Obtener instancia
     * @return
     */
    public static EntityManager createEntityManager() {
        return getEntityManager();
    }
}