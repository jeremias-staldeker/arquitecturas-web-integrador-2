package dao.entities.mapper;

import dao.entities.EstudianteEntity;
import model.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class EstudianteMapper {

	/**
	 * 
	 * @param estudianteEntity
	 * @return
	 */
    public static Estudiante entityToModel(EstudianteEntity estudianteEntity) {
        Estudiante estudiante = new Estudiante();
        estudiante.setDni(estudianteEntity.getDni());
        estudiante.setNombre(estudianteEntity.getNombre());
        estudiante.setApellido(estudianteEntity.getApellido());
        estudiante.setEdad(estudianteEntity.getEdad());
        estudiante.setGenero(estudianteEntity.getGenero());
        estudiante.setCiudad(estudianteEntity.getCiudad());
        estudiante.setNroLibretaUnica(estudianteEntity.getNroLibretaUnica());
        return estudiante;
    }

    /**
     * 
     * @param estudiante
     * @return
     */
    public static EstudianteEntity modelToEntity(Estudiante estudiante) {
        EstudianteEntity estudianteEntity = new EstudianteEntity();
        estudianteEntity.setDni(estudiante.getDni());
        estudianteEntity.setNombre(estudiante.getNombre());
        estudianteEntity.setApellido(estudiante.getApellido());
        estudianteEntity.setEdad(estudiante.getEdad());
        estudianteEntity.setGenero(estudiante.getGenero());
        estudianteEntity.setCiudad(estudiante.getCiudad());
        estudianteEntity.setNroLibretaUnica(estudiante.getNroLibretaUnica());
        return estudianteEntity;
    }

    /**
     * 
     * @param estudianteEntities
     * @return
     */
    public static List<Estudiante> entityListToModelList(List<EstudianteEntity> estudianteEntities) {
        List<Estudiante> estudiantes = new ArrayList<>();
        for (EstudianteEntity estudianteEntity : estudianteEntities) {
            estudiantes.add(entityToModel(estudianteEntity));
        }
        return estudiantes;
    }

    /**
     * 
     * @param estudiantes
     * @return
     */
    public static List<EstudianteEntity> modelListToEntityList(List<Estudiante> estudiantes) {
        List<EstudianteEntity> estudianteEntities = new ArrayList<>();
        for (Estudiante estudiante : estudiantes) {
            estudianteEntities.add(modelToEntity(estudiante));
        }
        return estudianteEntities;
    }
}
