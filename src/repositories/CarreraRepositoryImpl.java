package repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import dao.entities.CarreraEntity;
import dao.entities.mapper.CarreraMapper;
import factory.EntityFactory;
import model.Carrera;
import model.RepuestaCarreraInscriptos;
import model.RespuestaReporteCarrera;

public class CarreraRepositoryImpl implements CarreraRepository {

	private void agregarCarrera(CarreraEntity carrera) {
		EntityManager em = EntityFactory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(carrera);
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
	public void agregarCarrera(Carrera carrera) {
		agregarCarrera(CarreraMapper.modelToEntity(carrera));
	}

	@Override
	public void eliminarCarrera(CarreraEntity carrera) {
//		EntityManager em = EntityFactory.createEntityManager();
//		EntityTransaction transaction = em.getTransaction();
//		transaction.begin();
//		try {
//			String jpql = "";
//			TypedQuery<Carrera> query = em.createQuery(jpql);
//			query.setParameter("id", carrera.getId());
//			int result = query.executeUpdate();
//			if (result > 0) {
//				System.out.println("Carrera " + carrera.getNombre() + " eliminada con exito");
//			} else {
//				System.out.println("No se encontro la carrera " + carrera.getNombre());
//			}
//			transaction.commit();
//		} catch (Exception e) {
//			if (transaction != null && transaction.isActive()) {
//				transaction.rollback();
//			}
//			e.printStackTrace();
//		} finally {
//			em.close();
//		}

	}

	@Override
	public List<Carrera> getCarreras() {
		EntityManager em = EntityFactory.createEntityManager();
		try {
			String jpql = "";
			TypedQuery<CarreraEntity> query = em.createQuery(jpql, CarreraEntity.class);
			List<CarreraEntity> carreras = query.getResultList();

			return CarreraMapper.entityListToModelList(carreras);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public Carrera getCarrera(int id) {
		EntityManager em = EntityFactory.createEntityManager();
		try {
			String jpql = "";
			TypedQuery<Carrera> query = em.createQuery(jpql, Carrera.class);
			query.setParameter("id", id);
			Carrera carrera = (Carrera) query.getSingleResult();

			return carrera;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public List<RespuestaReporteCarrera> getReporteCarreras() {
		EntityManager em = EntityFactory.createEntityManager();
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ca.id, ca.nombre, ca.anio, ");
			sb.append("SUM(CASE WHEN ca.anio = ec.inscripcion THEN 1 ELSE 0 END) AS inscriptos, ");
			sb.append("SUM(CASE WHEN ca.anio = ec.graduacion THEN 1 ELSE 0 END) AS egresados ");
			sb.append("FROM (");
			sb.append("SELECT c.id, c.nombre, ec.inscripcion AS anio ");
			sb.append("FROM carreras c ");
			sb.append("JOIN estudiantes_carreras ec ON c.id = ec.id_carrera ");
			sb.append("UNION ");
			sb.append("SELECT c.id, c.nombre, ");
			sb.append("(CASE WHEN ec.graduacion = 0 THEN ec.inscripcion ELSE ec.graduacion END) AS anio ");
			sb.append("FROM carreras c ");
			sb.append("JOIN estudiantes_carreras ec ON c.id = ec.id_carrera) ca ");
			sb.append("LEFT JOIN estudiantes_carreras ec ON ca.id = ec.id_carrera ");
			sb.append("GROUP BY ca.id, ca.anio ");
			sb.append("ORDER BY ca.nombre, ca.anio");
			Query query = em.createNativeQuery(sb.toString());
			List<Object[]> carreraInscriptos = query.getResultList();
			return CarreraMapper.entityToModelRespuestaReporte(carreraInscriptos);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public void obtenerPorCantInscriptos() {
//		EntityManager em = EntityFactory.createEntityManager();
//		try {
//			String jpql = "";
//			Query query = em.createQuery(jpql,CarreraDto.class);
//			query.setParameter("id", id);
//			CarreraDto carrera = (CarreraDto) query.getSingleResult();
//			
//			return carrera;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		} finally {
//			em.close();
//		}
	}

	@Override
	public List<RepuestaCarreraInscriptos> getCarrerasConInscriptos() {
		EntityManager em = EntityFactory.createEntityManager();
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT c, COUNT(e) AS inscriptos FROM CarreraEntity c ");
			sb.append("JOIN c.estudiantes e ");
			sb.append("GROUP BY c ORDER BY inscriptos DESC");
			TypedQuery<Object[]> query = em.createQuery(sb.toString(), Object[].class);
			List<Object[]> carreraInscriptos = query.getResultList();
			return CarreraMapper.entityToModelRespuesta(carreraInscriptos);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

}
