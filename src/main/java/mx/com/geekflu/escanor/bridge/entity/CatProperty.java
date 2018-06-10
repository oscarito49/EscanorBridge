package mx.com.geekflu.escanor.bridge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cat_property")
public class CatProperty {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Short id;
	
	@Column(nullable=false, unique=true)
	private String property;
	public CatProperty() {
	}
	public CatProperty(Short id, String property) {
		super();
		this.id = id;
		this.property = property;
	}
	public CatProperty(String property) {
		super();
		this.property = property;
	}
	public Short getId() {
		return id;
	}
	public void setId(Short id) {
		this.id = id;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	@Override
	public String toString() {
		return "CatProperty [id=" + id + ", property=" + property + "]";
	}
}
