package org.ssu.edu.teachua.db.entities;


import org.ssu.edu.teachua.db.annotation.Column;
import lombok.Data;

import java.io.Serializable;

@Data
public class Entity implements Serializable, Cloneable {

    @Column(name = "id")
    Integer id;

	public void setId(int id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
}
