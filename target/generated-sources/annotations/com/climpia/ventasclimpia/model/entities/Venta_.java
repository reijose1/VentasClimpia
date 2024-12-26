package com.climpia.ventasclimpia.model.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;
import java.time.LocalDate;

@StaticMetamodel(Venta.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Venta_ {

	public static final String FECHA = "fecha";
	public static final String VENDEDOR = "vendedor";
	public static final String IDCLI = "idcli";
	public static final String ID = "id";
	public static final String IMPORTE = "importe";

	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Venta#fecha
	 **/
	public static volatile SingularAttribute<Venta, LocalDate> fecha;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Venta#vendedor
	 **/
	public static volatile SingularAttribute<Venta, String> vendedor;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Venta#idcli
	 **/
	public static volatile SingularAttribute<Venta, Usuario> idcli;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Venta#id
	 **/
	public static volatile SingularAttribute<Venta, Integer> id;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Venta
	 **/
	public static volatile EntityType<Venta> class_;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Venta#importe
	 **/
	public static volatile SingularAttribute<Venta, BigDecimal> importe;

}

