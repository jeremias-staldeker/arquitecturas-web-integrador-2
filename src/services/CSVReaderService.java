package services;

import java.io.IOException;
import java.util.List;
import model.*;

public interface CSVReaderService {
	/**
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public List<Estudiante> readEstudiantesFromCSV(String filePath) throws IOException;

	/**
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public List<Carrera> readCarrerasFromCSV(String filePath) throws IOException;

	/**
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public List<EstudianteCarrera> readEstudianteCarreraFromCSV(String filePath) throws IOException;
}
