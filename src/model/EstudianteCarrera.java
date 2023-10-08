package model;

import java.io.Serializable;

public class EstudianteCarrera implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6385279426150648897L;
	private int id;
	private Estudiante estudiante;
	private Carrera carrera;
	private int anioInscripcion;
	private int anioGraduacion;
	private int antiguedad;

	/**
	 * 
	 */
	public EstudianteCarrera() {
		super();
	}

	/**
	 * 
	 * @param estudiante
	 * @param carrera
	 * @param anioInscripcion
	 * @param anioGraduacion
	 * @param antiguedad
	 */
	public EstudianteCarrera(Estudiante estudiante, Carrera carrera, int anioInscripcion, int anioGraduacion,
			int antiguedad) {
		super();
		this.estudiante = estudiante;
		this.carrera = carrera;
		this.anioInscripcion = anioInscripcion;
		this.anioGraduacion = anioGraduacion;
		this.antiguedad = antiguedad;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the estudiante
	 */
	public Estudiante getEstudiante() {
		return estudiante;
	}

	/**
	 * @param estudiante the estudiante to set
	 */
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
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
	 * @return the anioInscripcion
	 */
	public int getAnioInscripcion() {
		return anioInscripcion;
	}

	/**
	 * @param anioInscripcion the anioInscripcion to set
	 */
	public void setAnioInscripcion(int anioInscripcion) {
		this.anioInscripcion = anioInscripcion;
	}

	/**
	 * @return the anioGraduacion
	 */
	public int getAnioGraduacion() {
		return anioGraduacion;
	}

	/**
	 * @param anioGraduacion the anioGraduacion to set
	 */
	public void setAnioGraduacion(int anioGraduacion) {
		this.anioGraduacion = anioGraduacion;
	}

	/**
	 * @return the antiguedad
	 */
	public int getAntiguedad() {
		return antiguedad;
	}

	/**
	 * @param antiguedad the antiguedad to set
	 */
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
