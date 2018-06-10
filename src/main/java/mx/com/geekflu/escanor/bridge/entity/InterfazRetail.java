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
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="interfazRetail")
	private List<Pipe> pipes;
	
	public InterfazRetail() { }
	public InterfazRetail(Long id, String nombre, LocalDateTime lastUpadateDate, LocalDateTime createdDate) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.lastUpadateDate = lastUpadateDate;
		this.createdDate = createdDate;
	}
}
