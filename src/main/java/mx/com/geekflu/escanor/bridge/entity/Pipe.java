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
	private String nombre;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_accion")
	private CatAccion accion;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_estatus")
	private CatEstatus estatus;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_tipo_conector")
	private CatTipoConector tipo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_interfaz_retail")
	private InterfazRetail interfazRetail;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="pipe")
	private List<DetalleProperty> propiedades;
	public Pipe() { }
	public Pipe(Long id, int numero, CatEstatus estatus, String nombre, CatAccion accion, CatTipoConector tipo,
			InterfazRetail interfazRetail, List<DetalleProperty> propiedades) {
		super();
		this.id = id;
		this.numero = numero;
		this.estatus = estatus;
		this.nombre = nombre;
		this.accion = accion;
		this.tipo = tipo;
		this.interfazRetail = interfazRetail;
		this.propiedades = propiedades;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public CatEstatus getEstatus() {
		return estatus;
	}
	public void setEstatus(CatEstatus estatus) {
		this.estatus = estatus;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public CatAccion getAccion() {
		return accion;
	}
	public void setAccion(CatAccion accion) {
		this.accion = accion;
	}
	public CatTipoConector getTipo() {
		return tipo;
	}
	public void setTipo(CatTipoConector tipo) {
		this.tipo = tipo;
	}
	public InterfazRetail getInterfazRetail() {
		return interfazRetail;
	}
	public void setInterfazRetail(InterfazRetail interfazRetail) {
		this.interfazRetail = interfazRetail;
	}
	public List<DetalleProperty> getPropiedades() {
		return propiedades;
	}
	public void setPropiedades(List<DetalleProperty> propiedades) {
		this.propiedades = propiedades;
	}
}
