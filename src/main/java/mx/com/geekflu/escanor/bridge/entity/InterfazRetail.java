package mx.com.geekflu.escanor.bridge.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Contiene la informacion general de una interfaz retail
 * 
 * @author darklatiz
 *
 */
@Entity
@Table(name="interfaz_retail")
public class InterfazRetail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre", nullable=false, unique=true)
	private String nombre;
	
	@UpdateTimestamp
	private LocalDateTime lastUpadateDate;

	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="interfazRetail")
	private List<Pipe> pipes;
	
	public InterfazRetail() { }
	public InterfazRetail(Long id, String nombre, LocalDateTime lastUpadateDate, LocalDateTime createdDate) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.lastUpadateDate = lastUpadateDate;
		this.createdDate = createdDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDateTime getLastUpadateDate() {
		return lastUpadateDate;
	}
	public void setLastUpadateDate(LocalDateTime lastUpadateDate) {
		this.lastUpadateDate = lastUpadateDate;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public List<Pipe> getPipes() {
		return pipes;
	}
	public void setPipes(List<Pipe> pipes) {
		this.pipes = pipes;
	}
}
