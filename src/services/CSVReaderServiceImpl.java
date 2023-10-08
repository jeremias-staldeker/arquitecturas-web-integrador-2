package services;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import model.Carrera;
import model.Estudiante;
import model.EstudianteCarrera;

public class CSVReaderServiceImpl implements CSVReaderService {

	@Override
	@SuppressWarnings("deprecation")
	public List<Estudiante> readEstudiantesFromCSV(String filePath) throws IOException {
		List<Estudiante> estudiantes = new ArrayList<Estudiante>();
		FileReader fileReader = new FileReader(filePath);

		try (CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withHeader())) {
			for (CSVRecord record : csvParser) {
				int dni = Integer.parseInt(record.get("DNI"));
				String nombre = record.get("nombre");
				String apellido = record.get("apellido");
				int edad = Integer.parseInt(record.get("edad"));
				String genero = record.get("genero");
				String ciudad = record.get("ciudad");
				int nroLibreta = Integer.parseInt(record.get("LU"));

				Estudiante estudiante = new Estudiante();
				estudiante.setDni(dni);
				estudiante.setNombre(nombre);
				estudiante.setApellido(apellido);
				estudiante.setEdad(edad);
				estudiante.setGenero(genero);
				estudiante.setCiudad(ciudad);
				estudiante.setNroLibretaUnica(nroLibreta);

				estudiantes.add(estudiante);
			}
		}
		return estudiantes;
	}

	@Override
	@SuppressWarnings("deprecation")
	public List<Carrera> readCarrerasFromCSV(String filePath) throws IOException {
		List<Carrera> carreras = new ArrayList<Carrera>();
		FileReader fileReader = new FileReader(filePath);

		try (CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withHeader())) {
			for (CSVRecord record : csvParser) {
				int id = Integer.parseInt(record.get("id_carrera"));
				String nombre = record.get("carrera");
				int duracion = Integer.parseInt(record.get("duracion"));

				Carrera carrera = new Carrera(nombre, duracion);
				carrera.setId(id);

				carreras.add(carrera);
			}
		}
		return carreras;
	}

	@Override
	@SuppressWarnings("deprecation")
	public List<EstudianteCarrera> readEstudianteCarreraFromCSV(String filePath) throws IOException {
		List<EstudianteCarrera> estudianteCarreras = new ArrayList<EstudianteCarrera>();
		FileReader fileReader = new FileReader(filePath);

		try (CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withHeader())) {
			for (CSVRecord record : csvParser) {
				int id = Integer.parseInt(record.get("id"));
				int idEstudiante = Integer.parseInt(record.get("id_estudiante"));
				int idCarrera = Integer.parseInt(record.get("id_carrera"));
				int inscripcion = Integer.parseInt(record.get("inscripcion"));
				int graduacion = Integer.parseInt(record.get("graduacion"));
				int antiguedad = Integer.parseInt(record.get("antiguedad"));

				Estudiante estudiante = new Estudiante();
				estudiante.setDni(idEstudiante);

				Carrera carrera = new Carrera();
				carrera.setId(idCarrera);

				EstudianteCarrera estudianteCarrera = new EstudianteCarrera();
				estudianteCarrera.setId(id);
				estudianteCarrera.setAnioInscripcion(inscripcion);
				estudianteCarrera.setAnioGraduacion(graduacion);
				estudianteCarrera.setAntiguedad(antiguedad);
				estudianteCarrera.setEstudiante(estudiante);
				estudianteCarrera.setCarrera(carrera);

				estudianteCarreras.add(estudianteCarrera);
			}
		}
		return estudianteCarreras;
	}
}
