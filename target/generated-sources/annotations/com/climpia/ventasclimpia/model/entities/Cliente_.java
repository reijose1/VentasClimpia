package com.climpia.ventasclimpia.model.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Cliente.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Cliente_ {

	public static final String APELLIDO = "apellido";
	public static final String ID = "id";
	public static final String TELEFONO = "telefono";
	public static final String NOMBRE = "nombre";
	public static final String EMAIL = "email";

	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Cliente#apellido
	 **/
	public static volatile SingularAttribute<Cliente, String> apellido;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Cliente#id
	 **/
	public static volatile SingularAttribute<Cliente, Integer> id;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Cliente#telefono
	 **/
	public static volatile SingularAttribute<Cliente, String> telefono;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Cliente
	 **/
	public static volatile EntityType<Cliente> class_;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Cliente#nombre
	 **/
	public static volatile SingularAttribute<Cliente, String> nombre;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Cliente#email
	 **/
	public static volatile SingularAttribute<Cliente, String> email;

}

