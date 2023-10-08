package repositories;

import model.EstudianteCarrera;

public interface EstudianteCarreraRepository {

	/**
	 * 	
	 * @param estudiante
	 * @param carrera
	 * @param anioInscripcion
	 * @param graduacion
	 * @param antiguedad
	 */
	public void matricularEstudiante(EstudianteCarrera estudianteCarrera);

}
