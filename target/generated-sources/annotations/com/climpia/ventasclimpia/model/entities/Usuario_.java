package com.climpia.ventasclimpia.model.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;

@StaticMetamodel(Usuario.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Usuario_ {

	public static final String CLIENTE = "cliente";
	public static final String CLAVE = "clave";
	public static final String ESTADO = "estado";
	public static final String USUARIO = "usuario";
	public static final String ID = "id";

	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Usuario#cliente
	 **/
	public static volatile SingularAttribute<Usuario, Cliente> cliente;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Usuario#clave
	 **/
	public static volatile SingularAttribute<Usuario, String> clave;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Usuario#estado
	 **/
	public static volatile SingularAttribute<Usuario, BigDecimal> estado;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Usuario#usuario
	 **/
	public static volatile SingularAttribute<Usuario, String> usuario;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Usuario#id
	 **/
	public static volatile SingularAttribute<Usuario, Integer> id;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Usuario
	 **/
	public static volatile EntityType<Usuario> class_;

}

