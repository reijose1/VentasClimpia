package com.climpia.ventasclimpia.model.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;

@StaticMetamodel(Pago.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Pago_ {

	public static final String IDVENTA = "idventa";
	public static final String IDMEDIO = "idmedio";
	public static final String OBSERVACIONES = "observaciones";
	public static final String ID = "id";
	public static final String IMPORTE = "importe";
	public static final String DETALLE = "detalle";

	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Pago#idventa
	 **/
	public static volatile SingularAttribute<Pago, Venta> idventa;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Pago#idmedio
	 **/
	public static volatile SingularAttribute<Pago, MedioPago> idmedio;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Pago#observaciones
	 **/
	public static volatile SingularAttribute<Pago, String> observaciones;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Pago#id
	 **/
	public static volatile SingularAttribute<Pago, Integer> id;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Pago
	 **/
	public static volatile EntityType<Pago> class_;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Pago#importe
	 **/
	public static volatile SingularAttribute<Pago, BigDecimal> importe;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Pago#detalle
	 **/
	public static volatile SingularAttribute<Pago, String> detalle;

}

