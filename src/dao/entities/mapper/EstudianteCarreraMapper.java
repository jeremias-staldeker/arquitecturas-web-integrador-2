package dao.entities.mapper;

import dao.entities.EstudianteCarreraEntity;
import model.EstudianteCarrera;

import java.util.ArrayList;
import java.util.List;

public class EstudianteCarreraMapper {

	/**
	 * 
	 * @param entity
	 * @return
	 */
    public static EstudianteCarrera entityToModel(EstudianteCarreraEntity entity) {
        EstudianteCarrera model = new EstudianteCarrera();
		model.setId(entity.getId());
		model.setEstudiante(EstudianteMapper.entityToModel(entity.getEstudiante()));
        model.setCarrera(CarreraMapper.entityToModel(entity.getCarrera()));
        model.setAnioInscripcion(entity.getAnioInscripcion());
        model.setAnioGraduacion(entity.getAnioGraduacion());
        model.setAntiguedad(entity.getAntiguedad());
        return model;
    }

    /**
     * 
     * @param model
     * @return
     */
    public static EstudianteCarreraEntity modelToEntity(EstudianteCarrera model) {
        EstudianteCarreraEntity entity = new EstudianteCarreraEntity();
        entity.setId(model.getId());
        entity.setEstudiante(EstudianteMapper.modelToEntity(model.getEstudiante()));
        entity.setCarrera(CarreraMapper.modelToEntity(model.getCarrera()));
        entity.setAnioInscripcion(model.getAnioInscripcion());
        entity.setAnioGraduacion(model.getAnioGraduacion());
        entity.setAntiguedad(model.getAntiguedad());
        return entity;
    }

    /**
     * 
     * @param entities
     * @return
     */
    public static List<EstudianteCarrera> entityListToModelList(List<EstudianteCarreraEntity> entities) {
        List<EstudianteCarrera> models = new ArrayList<>();
        for (EstudianteCarreraEntity entity : entities) {
            models.add(entityToModel(entity));
        }
        return models;
    }

    /**
     * 
     * @param models
     * @return
     */
    public static List<EstudianteCarreraEntity> modelListToEntityList(List<EstudianteCarrera> models) {
        List<EstudianteCarreraEntity> entities = new ArrayList<>();
        for (EstudianteCarrera model : models) {
            entities.add(modelToEntity(model));
        }
        return entities;
    }
}
