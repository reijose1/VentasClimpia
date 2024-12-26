package com.climpia.ventasclimpia.model.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;

@StaticMetamodel(Detalle.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Detalle_ {

	public static final String IDVENTA = "idventa";
	public static final String IDPROD = "idprod";
	public static final String PRECIO = "precio";
	public static final String SUBTOTAL = "subtotal";
	public static final String CANT = "cant";
	public static final String ID = "id";

	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Detalle#idventa
	 **/
	public static volatile SingularAttribute<Detalle, Venta> idventa;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Detalle#idprod
	 **/
	public static volatile SingularAttribute<Detalle, Producto> idprod;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Detalle#precio
	 **/
	public static volatile SingularAttribute<Detalle, BigDecimal> precio;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Detalle#subtotal
	 **/
	public static volatile SingularAttribute<Detalle, BigDecimal> subtotal;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Detalle#cant
	 **/
	public static volatile SingularAttribute<Detalle, BigDecimal> cant;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Detalle#id
	 **/
	public static volatile SingularAttribute<Detalle, Integer> id;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Detalle
	 **/
	public static volatile EntityType<Detalle> class_;

}

