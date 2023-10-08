package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RespuestaReporteCarrera implements Serializable {

	private Carrera carrera;
	private List<ReporteCarrera> reporteCarrera;

	public RespuestaReporteCarrera() {
		super();
		this.reporteCarrera = new ArrayList<>();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4670857072884139364L;

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
	 * @return the reporteCarrera
	 */
	public List<ReporteCarrera> getReporteCarrera() {
		return reporteCarrera;
	}

	/**
	 * @param reporteCarrera the reporteCarrera to set
	 */
	public void setReporteCarrera(List<ReporteCarrera> reporteCarrera) {
		this.reporteCarrera = reporteCarrera;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
