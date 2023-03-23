package org.ssu.edu.teachua.db.entities;


import org.ssu.edu.teachua.db.annotation.Column;
import lombok.Data;

import java.io.Serializable;

/**
 * An abstract class is the parent of all entity
 * Contain column id as primary key
 * @author User
 *
 */
@Data
public abstract class Entity implements Serializable, Cloneable {
	/**
	 * The name of column in table, also is primary key
	 */
    @Column(name = "id")
    Integer id;
}
