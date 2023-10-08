package repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import dao.entities.EstudianteCarreraEntity;
import dao.entities.mapper.EstudianteCarreraMapper;
import factory.EntityFactory;
import model.EstudianteCarrera;

public class EstudianteCarreraRepositoryImpl implements EstudianteCarreraRepository {

	/**
	 * 
	 * @param estudianteCarreraEntity
	 */
	private void matricularEstudiante(EstudianteCarreraEntity estudianteCarreraEntity) {
		EntityManager em = EntityFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(estudianteCarreraEntity);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	@Override
	public void matricularEstudiante(EstudianteCarrera estudianteCarrera) {
		matricularEstudiante(EstudianteCarreraMapper.modelToEntity(estudianteCarrera));
	}
}
