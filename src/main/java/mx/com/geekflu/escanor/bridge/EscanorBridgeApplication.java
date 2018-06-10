package mx.com.geekflu.escanor.bridge;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import mx.com.geekflu.escanor.bridge.entity.CatProperty;
import mx.com.geekflu.escanor.bridge.entity.CatTipoFuente;
import mx.com.geekflu.escanor.bridge.service.CatMantenimientoService;

@SpringBootApplication
public class EscanorBridgeApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CatMantenimientoService catMantenimientoService;
	
	public static void main(String[] args) {
		SpringApplication.run(EscanorBridgeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Catalogo de fuentes --> {}", catMantenimientoService.getCatalogo(CatTipoFuente.class));
		logger.info("Catalogo de propiedades --> {}", catMantenimientoService.getCatalogo(CatProperty.class));
		CatTipoFuente f = new CatTipoFuente("JMS-Broker de mensajeria");
		CatTipoFuente f1 = new CatTipoFuente("JMS-Broker de mensajeria 01");
		CatTipoFuente f2 = new CatTipoFuente("JMS-Broker de mensajeria 02");
		CatTipoFuente f3 = new CatTipoFuente("JMS-Broker de mensajeria 03");
		logger.info("Agregando nueva fuente --> {}", catMantenimientoService.createTipoFuente(f, f1, f2, f3));
		logger.info("Catalogo de fuentes --> {}", catMantenimientoService.getCatalogo(CatTipoFuente.class));
		
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
