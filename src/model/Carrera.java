package model;

import java.io.Serializable;

public class Carrera implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -230807645005566078L;
	private int id;
	private String nombre;
	private int duracion;

	/**
	 * 
	 */
	public Carrera() {
		super();
	}

	/**
	 * 
	 * @param nombre
	 * @param duracion
	 */
	public Carrera(String nombre, int duracion) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
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
	 * @return the duracion
	 */
	public int getDuracion() {
		return duracion;
	}

	/**
	 * @param duracion the duracion to set
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Carrera - " + nombre;
	}

}
