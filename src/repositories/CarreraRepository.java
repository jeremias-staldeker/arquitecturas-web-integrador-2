package repositories;

import java.util.List;

import dao.entities.CarreraEntity;
import model.Carrera;
import model.RepuestaCarreraInscriptos;
import model.RespuestaReporteCarrera;

public interface CarreraRepository {

	/**
	 * 
	 * @param carrera
	 */
	public void agregarCarrera(Carrera carrera);

	/**
	 * 
	 * @param carrera
	 */
	public void eliminarCarrera(CarreraEntity carrera);

	/**
	 * 
	 * @return
	 */
	public List<Carrera> getCarreras();

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Carrera getCarrera(int id);

	/**
	 * 
	 */
	public void obtenerPorCantInscriptos();

	/**
	 * 
	 * @return
	 */
	public List<RespuestaReporteCarrera> getReporteCarreras();

	/**
	 * 
	 * @return
	 */
	public List<RepuestaCarreraInscriptos> getCarrerasConInscriptos();

}
