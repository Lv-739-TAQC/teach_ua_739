package org.ssu.edu.teachua.db.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Specifies a many-valued association with many-to-many multiplicity.
 * The join table is specified on the owning side.
 * @author Kapustin Illia
 *
 */
@Retention(value= RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface ManyToMany {
	/**
     * The name table contain foreign entity
     */
    String foreignTable();
    /**
     * The name join table for the relationship
     */
    String tableForManyToMany();
    /**
     * The name main column in join table for the relationship
     */
    String mainColumnDB();
    /**
     * The name foreign column in join table for the relationship
     */
    String foreignColumnDB();

}
