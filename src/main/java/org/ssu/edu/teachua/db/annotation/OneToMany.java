package org.ssu.edu.teachua.db.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Specifies a single-valued association to another entity class that has one-to-many multiplicity.
 * @author Kapustin Illia
 *
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface OneToMany {
	/**
     * The name of the table in which the foreign key is the private key of main table
     */
    String foreignTable();
    /**
     * The name table contain foreign key
     */
    String mainColumnDB();
}

