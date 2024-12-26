package com.climpia.ventasclimpia.model.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;

@StaticMetamodel(Producto.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Producto_ {

	public static final String PRECIO = "precio";
	public static final String ID = "id";
	public static final String STOCK = "stock";
	public static final String IDCAT = "idcat";
	public static final String NOMBRE = "nombre";

	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Producto#precio
	 **/
	public static volatile SingularAttribute<Producto, BigDecimal> precio;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Producto#id
	 **/
	public static volatile SingularAttribute<Producto, Integer> id;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Producto#stock
	 **/
	public static volatile SingularAttribute<Producto, Integer> stock;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Producto
	 **/
	public static volatile EntityType<Producto> class_;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Producto#idcat
	 **/
	public static volatile SingularAttribute<Producto, Categoria> idcat;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Producto#nombre
	 **/
	public static volatile SingularAttribute<Producto, String> nombre;

}

