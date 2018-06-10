package mx.com.geekflu.escanor.bridge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Esta clase representa el tipo de fuente/destino para el intercambio de informacion
 *
 * <p>
 * <ul>
 * 	<li>FTP
 * 	<li>JDBC
 *  <li>BROKER Mensajeria
 * </ul>
 * @author darklatiz
 *
 */

@Entity
@Table(name="cat_tipo_conector")
public class CatTipoConector {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, unique=true)
	private String conector;
	public CatTipoConector() { }
	public CatTipoConector(Long id, String conectorS) {
		super();
		this.id = id;
		this.conector = conector;
	}
	public CatTipoConector(String conector) {
		super();
		this.conector = conector;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getConector() {
		return conector;
	}
	public void setConector(String conector) {
		this.conector = conector;
	}
	@Override
	public String toString() {
		return "CatTipoFuente [id=" + id + ", fuente=" + conector + "]";
	}
}
