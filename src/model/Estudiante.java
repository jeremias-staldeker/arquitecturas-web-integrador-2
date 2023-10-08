package model;

import java.io.Serializable;

public class Estudiante implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8196114124044204066L;
	private int dni;
	private String nombre;
	private String apellido;
	private int edad;
	private String genero;
	private String ciudad;
	private int nroLibretaUnica;

	/**
	 * 
	 */
	public Estudiante() {
		super();
	}

	/**
	 * 
	 * @param dni
	 * @param nombre
	 * @param apellido
	 * @param edad
	 * @param genero
	 * @param ciudad
	 * @param nroLibretaUnica
	 */
	public Estudiante(int dni, String nombre, String apellido, int edad, String genero, String ciudad,
			int nroLibretaUnica) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.ciudad = ciudad;
		this.nroLibretaUnica = nroLibretaUnica;
	}

	/**
	 * @return the dni
	 */
	public int getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(int dni) {
		this.dni = dni;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * @return the nroLibreta
	 */
	public int getNroLibretaUnica() {
		return nroLibretaUnica;
	}

	/**
	 * @param nroLibreta the nroLibreta to set
	 */
	public void setNroLibretaUnica(int nroLibreta) {
		this.nroLibretaUnica = nroLibreta;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Estudiante - DNI: " + dni + ", Apellido: " + apellido + ", Nombre: " + nombre + ", Edad: " + edad
				+ ", Género: " + genero + ", Ciudad: " + ciudad + ", Número de Libreta Única: " + nroLibretaUnica;
	}
}
