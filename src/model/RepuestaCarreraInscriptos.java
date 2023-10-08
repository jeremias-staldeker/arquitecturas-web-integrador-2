package model;

public class RepuestaCarreraInscriptos {
	private Carrera carrera;
	private int inscriptos;

	public RepuestaCarreraInscriptos() {
		super();
	}

	/**
	 * 
	 * @param carrera
	 * @param inscriptos
	 */
	public RepuestaCarreraInscriptos(Carrera carrera, int inscriptos) {
		super();
		this.carrera = carrera;
		this.inscriptos = inscriptos;
	}

	/**
	 * @return the carrera
	 */
	public Carrera getCarrera() {
		return carrera;
	}

	/**
	 * @param carrera the carrera to set
	 */
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	/**
	 * @return the inscriptos
	 */
	public int getInscriptos() {
		return inscriptos;
	}

	/**
	 * @param inscriptos the inscriptos to set
	 */
	public void setInscriptos(int inscriptos) {
		this.inscriptos = inscriptos;
	}

	@Override
	public String toString() {
		return "Carrera: " + carrera.getNombre() + ", Cantidad de Inscriptos: " + inscriptos;
	}
}
