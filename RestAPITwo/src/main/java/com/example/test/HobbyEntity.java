package com.example.test;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class HobbyEntity {
	 @Id
	   
	    private Integer id;
	    @Column
	    private Integer personId;
	    @Column
	    private String hobby;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getPersonId() {
			return personId;
		}
		public void setPersonId(Integer personId) {
			this.personId = personId;
		}
		public String getHobby() {
			return hobby;
		}
		public void setHobby(String hobby) {
			this.hobby = hobby;
		}
		public HobbyEntity(Integer personId, String hobby) {
			super();
			this.personId = personId;
			this.hobby = hobby;
		}
		public HobbyEntity() {
			super();
		}

}
