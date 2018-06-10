package mx.com.geekflu.escanor.bridge.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.geekflu.escanor.bridge.entity.DetalleProperty;
import mx.com.geekflu.escanor.bridge.entity.InterfazRetail;
import mx.com.geekflu.escanor.bridge.entity.Pipe;
import mx.com.geekflu.escanor.bridge.repository.DetallePropertyRepository;
import mx.com.geekflu.escanor.bridge.repository.InterfazRetailRepository;
import mx.com.geekflu.escanor.bridge.repository.PipeRepository;

@Service
@Transactional
public class InterfazRetailServiceImpl implements InterfazRetailService {

	@Autowired
	private InterfazRetailRepository interfazDao;

	@Autowired
	private PipeRepository pipeDao;

	@Autowired
	private DetallePropertyRepository detallePropertyDao;

	@Override
	public InterfazRetail createInterfazRetail(InterfazRetail interfaz) {
		InterfazRetail iSaved = interfazDao.save(interfaz);
		if (interfaz.getPipes() != null && !interfaz.getPipes().isEmpty()) {
			for (Pipe pipe : iSaved.getPipes()) {
				pipe.setInterfazRetail(iSaved);
				pipeDao.save(pipe);
				//salvamos las propiedades de cada PIPE
				if(pipe.getPropiedades() != null && 
						!pipe.getPropiedades().isEmpty()) {
					
					pipe.getPropiedades().stream()
					.forEach(propiedad -> propiedad.setPipe(pipe));
					
					pipe.getPropiedades().stream()
					.forEach(propiedad -> detallePropertyDao.save(propiedad));
				}
			}
		}
		return iSaved;
	}

	@Override
	public void updateInterfazRetail(InterfazRetail interfaz) {
		Optional<InterfazRetail> ir = interfazDao.findById(interfaz.getId());
		if (ir.isPresent()) {
			InterfazRetail i = ir.get();
			i.setNombre(interfaz.getNombre());
			i.setPipes(interfaz.getPipes());
		} else {
			throw new DataRetrievalFailureException("La Interfaz Retail no fue encontrada: " + interfaz.getNombre());
		}
	}

	@Override
	public void createDetalleProperty(DetalleProperty property) {
	}

	@Override
	public void updateDetalleProperty(DetalleProperty property) {
	}

	@Override
	public InterfazRetail findInterfazRetail(Long id) {
		Optional<InterfazRetail> ir = interfazDao.findById(id);
		if (ir.isPresent()) {
			// cargamos los pipes y sus dependencias ya que son LAZY
			InterfazRetail irObj = ir.get();
			irObj.setPipes(pipeDao.findByInterfazRetailId(irObj.getId()));
			if (irObj.getPipes() != null && 
					!irObj.getPipes().isEmpty()) {
				
				irObj.getPipes().stream()
				.forEach(pipe -> pipe.setPropiedades(detallePropertyDao.findDetallePropertyByIdPipe(pipe.getId())));
				
			}
			return irObj;
		} else {
			throw new DataRetrievalFailureException("La Interfaz Retail no fue encontrada id: " + id);
		}
	}

}
