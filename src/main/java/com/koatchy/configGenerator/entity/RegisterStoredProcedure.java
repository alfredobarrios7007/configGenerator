/**
 * 
 */

  package com.koatchy.configGenerator.entity;
  
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.NamedStoredProcedureQueries; 
import javax.persistence.NamedStoredProcedureQuery; 
import javax.persistence.StoredProcedureParameter; 
import javax.persistence.ParameterMode; 
import javax.persistence.Id; 
import javax.persistence.Table;
  
 /**
	 * @author alfredo.barrios
	 *
	 */

@Entity
@Table(name = "nothinghill")
@NamedStoredProcedureQueries(
		{
			@NamedStoredProcedureQuery( 
					name = "register", procedureName = "REGISTER",
					resultClasses = {  
							RegisterStoredProcedure.class
							},
					parameters = {
				  @StoredProcedureParameter(name = "p_platform", type = String.class, mode = ParameterMode.IN),
				  @StoredProcedureParameter(name = "p_name", type = String.class, mode = ParameterMode.IN),
				  @StoredProcedureParameter(name = "p_lastname", type = String.class, mode = ParameterMode.IN),
				  @StoredProcedureParameter(name = "p_organization", type = String.class, mode = ParameterMode.IN),
				  @StoredProcedureParameter(name = "p_area", type = String.class, mode = ParameterMode.IN),
				  @StoredProcedureParameter(name = "p_email", type = String.class, mode = ParameterMode.IN),
				  @StoredProcedureParameter(name = "p_password", type = String.class, mode = ParameterMode.IN),
				  @StoredProcedureParameter(name = "p_photo", type = String.class, mode = ParameterMode.IN)
				  }
  ) 
  }
) 
public class RegisterStoredProcedure implements Serializable {
  
	/**
	* 
	*/
	
	private static final long serialVersionUID = 1L;
	  
	public RegisterStoredProcedure() {
		  
	}

	/**
	* "in" arguments
	*/
	@Id
	@Column(name = "iduser")
	private Long id; 
	
  
}