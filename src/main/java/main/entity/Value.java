package main.entity;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "valueDB")
@Named
public class Value extends PanacheEntityBase{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int valueId;
	
	@Column(name="subjectId") //Kanske bra om title är med också?
	int subjectId;
	
	@Column(name="valuey")
	int valuey;
	
	@Column(name="valuex")
	int valuex;
	
//	@Column(name="subjectTitle")
//	String subjectTitle;
	
//	
//	@Column(name="userId")
//	int userId;
	
	public Value() {
		
	}
	
	public Value(int subjectId, int valuey, int valuex) {
		super();
		this.subjectId = subjectId;
		this.valuey = valuey;
		this.valuex = valuex;
	}
	
	

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getValueId() {
		return valueId;
	}

	public void setValueId(int vId) {
		this.valueId = vId;
	}

	public int getValuey() {
		return valuey;
	}

	public void setValuey(int valuey) {
		this.valuey = valuey;
	}

	public int getValuex() {
		return valuex;
	}

	public void setValuex(int valuex) {
		this.valuex = valuex;
	}
	
	
	
	
	

}