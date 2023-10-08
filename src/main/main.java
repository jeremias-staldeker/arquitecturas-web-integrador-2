package main;

import java.sql.SQLException;
import java.util.List;

import model.Carrera;
import model.Estudiante;
import model.EstudianteCarrera;
import model.ReporteCarrera;
import model.RepuestaCarreraInscriptos;
import model.RespuestaReporteCarrera;
import repositories.CarreraRepository;
import repositories.CarreraRepositoryImpl;
import repositories.EstudianteCarreraRepository;
import repositories.EstudianteCarreraRepositoryImpl;
import repositories.EstudianteRepository;
import repositories.EstudianteRepositoryImpl;
import services.CSVReaderServiceImpl;

public class main {

	public static void main(String[] args) throws SQLException {
		CSVReaderServiceImpl csvReader = new CSVReaderServiceImpl();
		CarreraRepository carreraRep = new CarreraRepositoryImpl();
		EstudianteRepository estudianteRep = new EstudianteRepositoryImpl();
		EstudianteCarreraRepository estCarreraRep = new EstudianteCarreraRepositoryImpl();
		try {
			// Rutas a los archivos CSV
			String carrerasCSVPath = "resources\\carreras.csv";
			String estudiantesCSVPath = "resources\\estudiantes.csv";
			String estudianteCarreraCSVPath = "resources\\estudianteCarrera.csv";

			// Cargar los datos de los archivos CSV
			List<Carrera> carreras = csvReader.readCarrerasFromCSV(carrerasCSVPath);
			List<Estudiante> estudiantes = csvReader.readEstudiantesFromCSV(estudiantesCSVPath);
			List<EstudianteCarrera> estudianteCarrera = csvReader
					.readEstudianteCarreraFromCSV(estudianteCarreraCSVPath);

			// Guardar los datos en la base de datos
			System.out.println("Inicio de carga de datos.");
			for (Carrera carrera : carreras) {
				carreraRep.agregarCarrera(carrera);
			}
			
			for (Estudiante estudiante : estudiantes) {
				estudianteRep.agregarEstudiante(estudiante);
			}
			
			for (EstudianteCarrera estCarrera : estudianteCarrera) {
				estCarreraRep.matricularEstudiante(estCarrera);
			}
			
			System.out.println("Datos cargados en la base de datos correctamente.");

			// c) recuperar todos los estudiantes, y especificar algún criterio de
			// ordenamiento simple.
			List<Estudiante> estudiantesOrdenados = estudianteRep.getEstudiantesOrdenadosPorNombre();
			System.out.println("Estudiante Ordenados Por Nombre:");
			for (Estudiante estudiante : estudiantesOrdenados) {
				System.out.println(estudiante.toString());
			}

			System.out.println("");
			System.out.println("------------------------------");
			System.out.println("");
			
			// d) recuperar un estudiante, en base a su número de libreta universitaria.
			Estudiante estudiantePorLibreta = estudianteRep.getEstudianteByLibreta(51244);
			System.out.println("Estudiante Por Libreta:");
			System.out.println(estudiantePorLibreta.toString());

			System.out.println("");
			System.out.println("------------------------------");
			System.out.println("");

			// e) recuperar todos los estudiantes, en base a su género.
			List<Estudiante> estudiantesPorGenero = estudianteRep.getEstudiantesByGenero("Male");
			System.out.println("Estudiante Por Genero:");
			for (Estudiante estudiante : estudiantesPorGenero) {
				System.out.println(estudiante.toString());
			}

			System.out.println("");
			System.out.println("------------------------------");
			System.out.println("");

			// f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad
			// de inscriptos.
			List<RepuestaCarreraInscriptos> respuesta = carreraRep.getCarrerasConInscriptos();
			System.out.println("Carreras Con Inscriptos:");
			for (RepuestaCarreraInscriptos repuestaCarreraInscriptos : respuesta) {
				System.out.println(repuestaCarreraInscriptos.toString());
			}

			System.out.println("");
			System.out.println("------------------------------");
			System.out.println("");

			// g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad
			// de residencia.
			List<Estudiante> estudiantesPorCarreraCuidad = estudianteRep.getEstudianteByCarreraAndCiudad("TUDAI",
					"Rauch");
			System.out.println("Estudiantes Por Carrera/Ciudad");
			for (Estudiante estudiante : estudiantesPorCarreraCuidad) {
				System.out.println(estudiante.toString());
			}

			System.out.println("");
			System.out.println("------------------------------");
			System.out.println("");

			// 3) Generar un reporte de las carreras, que para cada carrera incluya
			// información de los
			// inscriptos y egresados por año. Se deben ordenar las carreras
			// alfabéticamente, y presentar los años de manera cronológica.
			List<RespuestaReporteCarrera> respuestaReporte = carreraRep.getReporteCarreras();
			System.out.println("Reporte Carreras:");
			for (RespuestaReporteCarrera respuesta1 : respuestaReporte) {
				System.out.println(respuesta1.getCarrera().toString());
				for (ReporteCarrera reporteCarrera : respuesta1.getReporteCarrera()) {
					System.out.println("	" + reporteCarrera.toString());
				}
				System.out.println("");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
	}

}
