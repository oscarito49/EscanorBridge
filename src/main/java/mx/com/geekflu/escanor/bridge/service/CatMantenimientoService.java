package mx.com.geekflu.escanor.bridge.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.com.geekflu.escanor.bridge.entity.CatProperty;
import mx.com.geekflu.escanor.bridge.entity.CatTipoConector;

/**
 * Clase que dara servicio a los differentes catalogos que existen en la aplicacion
 * @author darklatiz
 *
 */
@Service
public interface CatMantenimientoService {
	public boolean createTipoFuente(CatTipoConector... fuentes);
	public void updateTipoFuente(Long id, String newDescripcion);
	public void deleteTipoFuente(Long id);
	
	public boolean createProperty(CatProperty... properties );
	public void updateProperty(Short id, String newDescription);
	public void deleteProperty(Short id);
	
	public <T> List<T> getCatalogo(Class<T> theClazz); 
}
