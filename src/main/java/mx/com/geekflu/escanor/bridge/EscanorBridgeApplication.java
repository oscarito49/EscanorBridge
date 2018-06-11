package mx.com.geekflu.escanor.bridge;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import mx.com.geekflu.escanor.bridge.entity.CatAccion;
import mx.com.geekflu.escanor.bridge.entity.CatEstatus;
import mx.com.geekflu.escanor.bridge.entity.CatProperty;
import mx.com.geekflu.escanor.bridge.entity.CatTipoConector;
import mx.com.geekflu.escanor.bridge.entity.DetalleProperty;
import mx.com.geekflu.escanor.bridge.entity.InterfazRetail;
import mx.com.geekflu.escanor.bridge.entity.Pipe;
import mx.com.geekflu.escanor.bridge.service.CatMantenimientoService;
import mx.com.geekflu.escanor.bridge.service.InterfazRetailService;

@SpringBootApplication
public class EscanorBridgeApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CatMantenimientoService catMantenimientoService;
	
	@Autowired
	InterfazRetailService interfazRetailService;
	
	public static void main(String[] args) {
		SpringApplication.run(EscanorBridgeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Catalogo de fuentes --> {}", catMantenimientoService.getCatalogo(CatTipoConector.class));
		logger.info("Catalogo de propiedades --> {}", catMantenimientoService.getCatalogo(CatProperty.class));
		CatTipoConector f = new CatTipoConector("JMS-Broker de mensajeria");
		CatTipoConector f1 = new CatTipoConector("JMS-Broker de mensajeria 01");
		CatTipoConector f2 = new CatTipoConector("JMS-Broker de mensajeria 02");
		CatTipoConector f3 = new CatTipoConector("JMS-Broker de mensajeria 03");
		logger.info("Agregando nueva fuente --> {}", catMantenimientoService.createTipoFuente(f, f1, f2, f3));
		logger.info("Catalogo de fuentes --> {}", catMantenimientoService.getCatalogo(CatTipoConector.class));
		
		CatProperty p = new CatProperty("JMS-Connection-URL");
		CatProperty p1 = new CatProperty("JMS-Connection-URL01");
		CatProperty p2 = new CatProperty("JMS-Connection-URL02");
		CatProperty p3 = new CatProperty("JMS-Connection-URL03");
		logger.info("Agregando fuentes --> {}", catMantenimientoService.createProperty(p,p1,p2,p3));
		logger.info("Propiedades --> {}", catMantenimientoService.getCatalogo(CatProperty.class));
		
		List<CatProperty> cat = (List<CatProperty>) catMantenimientoService.getCatalogo(CatProperty.class);
		
		catMantenimientoService.updateProperty(cat.get(0).getId(), "MyaSS Fuckers property");
		logger.info("Propiedades --> {}", catMantenimientoService.getCatalogo(CatProperty.class));

	}
}
