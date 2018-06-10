package mx.com.geekflu.escanor.bridge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Esta clase representa el catalogo de acciones que en conjunto son
 * CatTipoConector forman el conector y su accion:<br/>
 * Ejemplo:
 * Tipo Conector = FTP
 * Accion = Extraer <br>
 * Esto indica que el conector es del tipo FTP y su accion es la de extraer
 * archivos utilizando este conector.
 * 
 * @author darklatiz
 *
 */
@Entity
@Table(name="cat_accion")
public class CatAccion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, unique=true)
	private String accion;
	public CatAccion() {}
	
	public CatAccion(Long id, String accion) {
		super();
		this.id = id;
		this.accion = accion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	@Override
	public String toString() {
		return "CatAccion [id=" + id + ", accion=" + accion + "]";
	}
	
}
