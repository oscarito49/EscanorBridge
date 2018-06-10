package mx.com.geekflu.escanor.bridge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Esta clase representa una propiedad, estas propiedades pueden
 * representar:
 * <ul>
 * 	<li>IP de base datos
 *  <li>Usuario
 *  <li>Password
 *  <li>topic o queue de conexion
 *  <li>nombre de base de datos
 * </ul>
 * 
 * @author darklatiz
 * @since 0.1
 * @version 0.1
 *
 */
@Entity
@Table(name="property")
public class Property {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_cat_property")
	private CatProperty property;
	
	@Column(nullable=false)
	private String valor;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Pipe pipe;
	public Property() { }
	public Property(Long id, CatProperty property, String valor, Pipe pipe) {
		super();
		this.id = id;
		this.property = property;
		this.valor = valor;
		this.pipe = pipe;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CatProperty getProperty() {
		return property;
	}
	public void setProperty(CatProperty property) {
		this.property = property;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public Pipe getPipe() {
		return pipe;
	}
	public void setPipe(Pipe pipe) {
		this.pipe = pipe;
	}
	@Override
	public String toString() {
		return "Property [id=" + id + ", property=" + property + ", valor=" + valor + ", pipe=" + pipe + "]";
	}
}
