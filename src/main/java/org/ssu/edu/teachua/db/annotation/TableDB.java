package org.ssu.edu.teachua.db.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Specifies that the class is an entity. This annotation is applied to the entity class.
 * @author Kapustin Illia
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface TableDB {
	/**
	 * The name table in database. 
	 * This name is used to refer to the entity in database.
	 */
    String name();
}
