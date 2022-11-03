package com.proyecto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name="Productos")
public class Productos {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private Double precio;
	private String descripcion;
	private String marca;
	private String estatus;
	private Integer destacado;
	private String descuento;
	private String imagen="no-image.png";
	
	@OneToOne
	@JoinColumn(name="idCategoria")
	private Categoria categoria;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Integer getDestacado() {
		return destacado;
	}

	public void setDestacado(Integer destacado) {
		this.destacado = destacado;
	}
	

	public String getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		return "Productos [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descripcion=" + descripcion
				+ ", marca=" + marca + ", estatus=" + estatus + ", destacado=" + destacado + ", descuento=" + descuento
				+ ", imagen=" + imagen + ", categoria=" + categoria + "]";
	}

	

	
	
	
	
}
