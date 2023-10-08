package dao.entities.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.entities.CarreraEntity;
import model.Carrera;
import model.ReporteCarrera;
import model.RepuestaCarreraInscriptos;
import model.RespuestaReporteCarrera;

public class CarreraMapper {

	/**
	 * 
	 * @param carreraEntity
	 * @return
	 */
	public static Carrera entityToModel(CarreraEntity carreraEntity) {
		Carrera carrera = new Carrera();
		carrera.setId(carreraEntity.getId());
		carrera.setNombre(carreraEntity.getNombre());
		carrera.setDuracion(carreraEntity.getDuracion());
		return carrera;
	}

	/**
	 * 
	 * @param carrera
	 * @return
	 */
	public static CarreraEntity modelToEntity(Carrera carrera) {
		CarreraEntity carreraEntity = new CarreraEntity();
		carreraEntity.setId(carrera.getId());
		carreraEntity.setNombre(carrera.getNombre());
		carreraEntity.setDuracion(carrera.getDuracion());
		return carreraEntity;
	}

	/**
	 * 
	 * @param carreraEntities
	 * @return
	 */
	public static List<Carrera> entityListToModelList(List<CarreraEntity> carreraEntities) {
		List<Carrera> carreras = new ArrayList<Carrera>();
		for (CarreraEntity carreraEntity : carreraEntities) {
			carreras.add(entityToModel(carreraEntity));
		}
		return carreras;
	}

	/**
	 * 
	 * @param carreras
	 * @return
	 */
	public static List<CarreraEntity> modelListToEntityList(List<Carrera> carreras) {
		List<CarreraEntity> carreraEntities = new ArrayList<CarreraEntity>();
		for (Carrera carrera : carreras) {
			carreraEntities.add(modelToEntity(carrera));
		}
		return carreraEntities;
	}

	/**
	 * 
	 * @param carreraInscriptos
	 * @return
	 */
	public static List<RepuestaCarreraInscriptos> entityToModelRespuesta(List<Object[]> carreraInscriptos) {
		List<RepuestaCarreraInscriptos> respuestaInscriptos = new ArrayList<>();
		for (Object[] row : carreraInscriptos) {
			CarreraEntity carreraEntity = (CarreraEntity) row[0];
			Long inscriptos = (Long) row[1];
			RepuestaCarreraInscriptos respuesta = new RepuestaCarreraInscriptos();
			respuesta.setCarrera(entityToModel(carreraEntity));
			respuesta.setInscriptos(inscriptos.intValue());
			respuestaInscriptos.add(respuesta);
		}
		return respuestaInscriptos;
	}

	public static List<RespuestaReporteCarrera> entityToModelRespuestaReporte(List<Object[]> carreraReporte) {
		Map<String, RespuestaReporteCarrera> carreraMap = new HashMap<>();
		List<RespuestaReporteCarrera> resultadoFinal = new ArrayList<>();

		for (Object[] resultado : carreraReporte) {
			String nombreCarrera = (String) resultado[1];
			int id = (int) resultado[0];
			int anio = (int) resultado[2];
			BigDecimal inscriptos = (BigDecimal) resultado[3];
			BigDecimal egresados = (BigDecimal) resultado[4];

			if (!carreraMap.containsKey(nombreCarrera)) {
				RespuestaReporteCarrera respuestaCarrera = new RespuestaReporteCarrera();
				ReporteCarrera reporteCarrera = new ReporteCarrera();
				Carrera carrera = new Carrera();
				carrera.setId(id);
				carrera.setNombre(nombreCarrera);
				respuestaCarrera.setCarrera(carrera);
				reporteCarrera.setAnio(anio);
				reporteCarrera.setInscriptos(inscriptos.intValue());
				reporteCarrera.setEgresados(egresados.intValue());
				respuestaCarrera.getReporteCarrera().add(reporteCarrera);

				carreraMap.put(nombreCarrera, respuestaCarrera);
			} else {
				RespuestaReporteCarrera carrera = carreraMap.get(nombreCarrera);
				ReporteCarrera reporteCarrera = new ReporteCarrera();
				reporteCarrera.setAnio(anio);
				reporteCarrera.setInscriptos(inscriptos.intValue());
				reporteCarrera.setEgresados(egresados.intValue());

				carrera.getReporteCarrera().add(reporteCarrera);
			}
		}
		resultadoFinal.addAll(carreraMap.values());
		return resultadoFinal;
	}
}
