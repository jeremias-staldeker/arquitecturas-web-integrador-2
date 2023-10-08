package repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import dao.entities.EstudianteEntity;
import dao.entities.mapper.EstudianteMapper;
import factory.EntityFactory;
import model.Estudiante;

public class EstudianteRepositoryImpl implements EstudianteRepository {

	/**
	 * 
	 * @param estudiante
	 */
	private void agregarEstudiante(EstudianteEntity estudiante) {
		EntityManager em = EntityFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(estudiante);
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
	public void agregarEstudiante(Estudiante estudiante) {
		agregarEstudiante(EstudianteMapper.modelToEntity(estudiante));
	}

	@Override
	public List<Estudiante> getEstudiantes() {
		EntityManager em = EntityFactory.createEntityManager();
		try {
			String jpql = "SELECT e FROM EstudianteEntity e";
			TypedQuery<EstudianteEntity> query = em.createQuery(jpql, EstudianteEntity.class);
			List<EstudianteEntity> estudiantes = query.getResultList();
			return EstudianteMapper.entityListToModelList(estudiantes);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public List<Estudiante> getEstudiantesOrdenadosPorNombre() {
		EntityManager em = EntityFactory.createEntityManager();
		try {
			String jpql = "SELECT e FROM EstudianteEntity e ORDER BY e.apellido, e.nombre";
			TypedQuery<EstudianteEntity> query = em.createQuery(jpql, EstudianteEntity.class);
			List<EstudianteEntity> estudiantes = query.getResultList();
			return EstudianteMapper.entityListToModelList(estudiantes);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public Estudiante getEstudiante(int id) {
		EntityManager em = EntityFactory.createEntityManager();
		try {
			String jpql = "SELECT e FROM EstudianteEntity e WHERE e.dni = :id";
			TypedQuery<EstudianteEntity> query = em.createQuery(jpql, EstudianteEntity.class);
			query.setParameter("id", id);
			EstudianteEntity estudiante = query.getSingleResult();
			return EstudianteMapper.entityToModel(estudiante);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public void eliminarEstudiante(int dni) {
		EntityManager em = EntityFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			String jpql = "";
			Query query = em.createQuery(jpql);
			query.setParameter("dni", dni);
			int result = query.executeUpdate();
			if (result > 0) {
				System.out.println("Eliminado exitoso del estudiante");
			} else {
				System.out.println("No se encontro el estudiante");
			}
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
	public Estudiante getEstudianteByLibreta(int nroLibreta) {
		EntityManager em = EntityFactory.createEntityManager();
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT e FROM EstudianteEntity e ");
			sb.append("WHERE e.nroLibretaUnica = :nroLibretaUnica");
			TypedQuery<EstudianteEntity> query = em.createQuery(sb.toString(), EstudianteEntity.class);
			query.setParameter("nroLibretaUnica", nroLibreta);
			EstudianteEntity estudiante = query.getSingleResult();
			return EstudianteMapper.entityToModel(estudiante);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public List<Estudiante> getEstudiantesByGenero(String genero) {
		EntityManager em = EntityFactory.createEntityManager();
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT e FROM EstudianteEntity e ");
			sb.append("WHERE e.genero = :genero");
			TypedQuery<EstudianteEntity> query = em.createQuery(sb.toString(), EstudianteEntity.class);
			query.setParameter("genero", genero);
			List<EstudianteEntity> estudiantes = query.getResultList();
			return EstudianteMapper.entityListToModelList(estudiantes);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public List<Estudiante> getEstudianteByCarreraAndCiudad(String nombreCarrera, String ciudad) {
		EntityManager em = EntityFactory.createEntityManager();
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT e FROM EstudianteCarreraEntity ce ");
			sb.append("JOIN ce.estudiante e ");
			sb.append("JOIN ce.carrera c ");
			sb.append("WHERE e.ciudad = :ciudad ");
			sb.append("AND c.nombre = :nombreCarrera");
			TypedQuery<EstudianteEntity> query = em.createQuery(sb.toString(), EstudianteEntity.class);
			query.setParameter("ciudad", ciudad);
			query.setParameter("nombreCarrera", nombreCarrera);
			List<EstudianteEntity> estudiantes = query.getResultList();
			return EstudianteMapper.entityListToModelList(estudiantes);
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>(0);
		} finally {
			em.close();
		}
	}

}
