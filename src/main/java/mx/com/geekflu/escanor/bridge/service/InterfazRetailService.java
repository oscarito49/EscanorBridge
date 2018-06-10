package mx.com.geekflu.escanor.bridge.service;

import mx.com.geekflu.escanor.bridge.entity.DetalleProperty;
import mx.com.geekflu.escanor.bridge.entity.InterfazRetail;

public interface InterfazRetailService {
	
	/**Metodos que tienen que ver con {@link InterfazRetail}*/
	public InterfazRetail createInterfazRetail(InterfazRetail interfaz);
	public void updateInterfazRetail(InterfazRetail interfaz);
	public InterfazRetail findInterfazRetail(Long id);
	
	public void createDetalleProperty(DetalleProperty property);
	public void updateDetalleProperty(DetalleProperty property);
	
}
