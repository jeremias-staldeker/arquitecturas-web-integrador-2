package repositories;

import java.util.List;

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
	 * @return
	 */
	public List<RespuestaReporteCarrera> getReporteCarreras();

	/**
	 * 
	 * @return
	 */
	public List<RepuestaCarreraInscriptos> getCarrerasConInscriptos();

}
