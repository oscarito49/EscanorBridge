package mx.com.geekflu.escanor.bridge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cat_estatus")
public class CatEstatus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, unique=true)
	private String estatus;
	public CatEstatus() {
	}
	public CatEstatus(Long id, String estatus) {
		super();
		this.id = id;
		this.estatus = estatus;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	@Override
	public String toString() {
		return "CatEstatus [id=" + id + ", estatus=" + estatus + "]";
	}
}
