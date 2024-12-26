package com.climpia.ventasclimpia.model.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Categoria.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Categoria_ {

	public static final String ID = "id";
	public static final String NOMBRE = "nombre";

	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Categoria#id
	 **/
	public static volatile SingularAttribute<Categoria, Integer> id;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Categoria
	 **/
	public static volatile EntityType<Categoria> class_;
	
	/**
	 * @see com.climpia.ventasclimpia.model.entities.Categoria#nombre
	 **/
	public static volatile SingularAttribute<Categoria, String> nombre;

}

