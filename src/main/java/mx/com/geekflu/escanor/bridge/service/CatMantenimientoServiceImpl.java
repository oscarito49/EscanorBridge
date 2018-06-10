package mx.com.geekflu.escanor.bridge.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.geekflu.escanor.bridge.entity.CatProperty;
import mx.com.geekflu.escanor.bridge.entity.CatTipoFuente;
import mx.com.geekflu.escanor.bridge.repository.CatPropertyRepository;
import mx.com.geekflu.escanor.bridge.repository.CatTipoFuenteRepository;

@Service
@Transactional
public class CatMantenimientoServiceImpl implements CatMantenimientoService {

	@Autowired
	private EntityManager em;
	
	@Autowired
	private CatPropertyRepository catPropertyDao;
	
	@Autowired
	private CatTipoFuenteRepository catTipoFuenteDao;
	
	@Override
	public boolean createTipoFuente(CatTipoFuente... fuentes) {
		boolean isOk = true;
		for(CatTipoFuente fuente : fuentes) {
			catTipoFuenteDao.save(fuente);
		}
		return isOk;
	}

	@Override
	public void updateTipoFuente(Long id, String newDescripcion) {
		CatTipoFuente f = catTipoFuenteDao.getOne(id);
		f.setFuente(newDescripcion);
	}

	@Override
	public boolean createProperty(CatProperty... properties) {
		boolean isOk = true;
		for(CatProperty prop : properties) {
			catPropertyDao.save(prop);
		}
		return isOk;
	}

	@Override
	public void updateProperty(Short id, String newDescription) {
		CatProperty p = catPropertyDao.getOne(id);
		p.setProperty(newDescription);
	}

	@Override
	public void deleteTipoFuente(Long id) {
		CatTipoFuente f = catTipoFuenteDao.getOne(id);
		catTipoFuenteDao.delete(f);
	}

	@Override
	public void deleteProperty(Short id) {
		CatProperty p = catPropertyDao.getOne(id);
		catPropertyDao.delete(p);
	}

	@Override
	public <T> List<T> getCatalogo(Class<T> theClazz) {
		List<T> lst = null;
		if(theClazz.getSimpleName() != null &&
				theClazz.getSimpleName().equals(CatTipoFuente.class.getSimpleName())) {
			lst = (List<T>) catTipoFuenteDao.findAll();
		}else if(theClazz.getSimpleName() != null &&
				theClazz.getSimpleName().equals(CatProperty.class.getSimpleName())) {
			lst = (List<T>) catPropertyDao.findAll();
		}
		return lst;
	}

}
