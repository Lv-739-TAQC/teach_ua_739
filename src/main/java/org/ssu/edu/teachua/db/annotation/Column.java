package org.ssu.edu.teachua.db.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Specifies the mapped column for a persistent property or field.
 * @author Kapustin Illia
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface Column {
	/**
	 * The name column in database`s table .
	 */
    String name();
}

