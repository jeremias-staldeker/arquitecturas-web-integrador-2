package repositories;

import java.util.List;

import dao.entities.EstudianteEntity;
import model.Estudiante;

public interface EstudianteRepository {

	/**
	 * 
	 * @param estudiante
	 */
	public void agregarEstudiante(Estudiante estudiante);

	/**
	 * 
	 * @return
	 */
	public List<EstudianteEntity> getEstudiantes();

	/**
	 * 
	 * @return
	 */
	public List<Estudiante> getEstudiantesOrdenadosPorNombre();

	/**
	 * 
	 * @param id
	 * @return
	 */
	public EstudianteEntity getEstudiante(int id);

	/**
	 * 
	 * @param dni
	 */
	public void eliminarEstudiante(int dni);

	/**
	 * 
	 * @param nroLibreta
	 * @return
	 */
	public Estudiante getEstudianteByLibreta(int nroLibreta);

	/**
	 * 
	 * @param genero
	 * @return
	 */
	public List<Estudiante> getEstudiantesByGenero(String genero);

	/**
	 * 
	 * @param nombreCarrera
	 * @param ciudad
	 * @return
	 */
	public List<Estudiante> getEstudianteByCarreraAndCiudad(String nombreCarrera, String ciudad);

}
