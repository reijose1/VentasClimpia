package com.climpia.ventasclimpia.model.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(MedioPago.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class MedioPago_ {

	public static final String ID = "id";
	public static final String NOMBRE = "nombre";

	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.MedioPago#id
	 **/
	public static volatile SingularAttribute<MedioPago, Integer> id;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.MedioPago
	 **/
	public static volatile EntityType<MedioPago> class_;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.MedioPago#nombre
	 **/
	public static volatile SingularAttribute<MedioPago, String> nombre;

}

