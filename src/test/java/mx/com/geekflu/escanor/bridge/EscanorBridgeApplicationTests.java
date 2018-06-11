package mx.com.geekflu.escanor.bridge;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.test.context.junit4.SpringRunner;

import mx.com.geekflu.escanor.bridge.entity.CatAccion;
import mx.com.geekflu.escanor.bridge.entity.CatEstatus;
import mx.com.geekflu.escanor.bridge.entity.CatProperty;
import mx.com.geekflu.escanor.bridge.entity.CatTipoConector;
import mx.com.geekflu.escanor.bridge.entity.DetalleProperty;
import mx.com.geekflu.escanor.bridge.entity.InterfazRetail;
import mx.com.geekflu.escanor.bridge.entity.Pipe;
import mx.com.geekflu.escanor.bridge.service.CatMantenimientoService;
import mx.com.geekflu.escanor.bridge.service.InterfazRetailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EscanorBridgeApplicationTests {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	InterfazRetailService interfazRetailService;
	
	@Autowired
	CatMantenimientoService catMantenimientoService;
	
	@Test
	public void test_create_interfaz_retail() {
		InterfazRetail ir = new  InterfazRetail();
		List<CatAccion> acciones = catMantenimientoService.getCatalogo(CatAccion.class);
		List<CatTipoConector> tipos = catMantenimientoService.getCatalogo(CatTipoConector.class);
		List<CatEstatus> estatus = catMantenimientoService.getCatalogo(CatEstatus.class);
		List<CatProperty> catProperty = catMantenimientoService.getCatalogo(CatProperty.class);

		DetalleProperty propiedad = new DetalleProperty();
		propiedad.setProperty(catProperty.get(0));
		propiedad.setValor("sftp.url.mx");
		
		DetalleProperty propiedad1 = new DetalleProperty();
		propiedad1.setProperty(catProperty.get(1));
		propiedad1.setValor("useer1234");
		
		DetalleProperty propiedad2 = new DetalleProperty();
		propiedad2.setProperty(catProperty.get(2));
		propiedad2.setValor("passsword123");
		
		Pipe pp1 = new Pipe();
		pp1.setAccion(acciones.get(1));
		pp1.setEstatus(estatus.get(1));
		pp1.setNombre("FTP Extractor");
		pp1.setNumero(0);
		pp1.setTipo(tipos.get(0));
		pp1.setPropiedades(Arrays.asList(propiedad, propiedad1, propiedad2));
		
		ir.setNombre("InterFaz dummy");
		ir.setPipes(Arrays.asList(pp1));
		ir = interfazRetailService.createInterfazRetail(ir);
		
		InterfazRetail interFromDB = interfazRetailService.findInterfazRetail(ir.getId());
		assertEquals("InterFaz dummy", interFromDB.getNombre());
		assertEquals(ir.getId(), interFromDB.getId());
		
	}
	
	@Test(expected=DataRetrievalFailureException.class)
	public void test_validate_interfaaz_retail_not_found_byId() {
		logger.info("Interfaz Retail NOT FOUND Exception");
		InterfazRetail interFromDB = interfazRetailService.findInterfazRetail(-9999L);
	}

}
