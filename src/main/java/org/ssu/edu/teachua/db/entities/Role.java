package org.ssu.edu.teachua.db.entities;

import org.ssu.edu.teachua.db.annotation.Column;
import org.ssu.edu.teachua.db.annotation.TableDB;
import lombok.Data;

@TableDB(name = "roles")
@Data
public class Role extends Entity{

    @Column(name = "name")
    private String name;
    
    public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
