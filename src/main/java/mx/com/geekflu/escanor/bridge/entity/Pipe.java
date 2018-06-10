package mx.com.geekflu.escanor.bridge.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *  Esta clase representa un paso o bloque del flujo completo a ejecutar.
 * <p>Pasos Generales de una Interfaz Retail son:
 * <ol>
 * 	<li>Fuente de datos
 * 	<li>Mappeo de datos
 * 	<li>Destino de los datos
 * </ol>
 * <p>La variable miembro llamada tipo contiene esta informacion
 * 
 * <p>Los datos o propiedades especificas estaran contenidas en archivos de propiedades
 * generados por la aplicacion.<br>
 * Por ejemplo:
 * Si el tipo == FTP 
 * @author escanor
 *
 */
@Entity
@Table(name="pipe")
public class Pipe {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable=false)
	private int numero;

	@Column(nullable=false)
	private int estatus;
	
	@Column(nullable=false)
	private String nombre;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipo_fuente_id")
	private CatTipoFuente tipo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private InterfazRetail interfazRetail;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="pipe")
	private List<Property> propiedades;
	

}
