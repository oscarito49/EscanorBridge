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
@Table(name="cat_tipo_fuente")
public class CatTipoFuente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, unique=true)
	private String fuente;
	public CatTipoFuente() { }
	public CatTipoFuente(Long id, String fuente) {
		super();
		this.id = id;
		this.fuente = fuente;
	}
	public CatTipoFuente(String fuente) {
		super();
		this.fuente = fuente;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFuente() {
		return fuente;
	}
	public void setFuente(String fuente) {
		this.fuente = fuente;
	}
	@Override
	public String toString() {
		return "CatTipoFuente [id=" + id + ", fuente=" + fuente + "]";
	}
}
