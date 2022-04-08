package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="region")
public class Region {
	@Id
public int id;
	public String regionName;
	public String CreatedAt;
	public String updatedAt;
public int getId() {
	return id;
}
@Override
public String toString() {
	return "Region [id=" + id + ", regionName=" + regionName + ", CreatedAt=" + CreatedAt + ", updatedAt=" + updatedAt
			+ "]";
}
public void setId(int id) {
	this.id = id;
}
public String getRegionName() {
	return regionName;
}
public void setRegionName(String regionName) {
	this.regionName = regionName;
}
public String getCreatedAt() {
	return CreatedAt;
}
public void setCreatedAt(String createdAt) {
	CreatedAt = createdAt;
}
public String getUpdatedAt() {
	return updatedAt;
}
public void setUpdatedAt(String updatedAt) {
	this.updatedAt = updatedAt;
}
public static List<Region> findAll() {
	return null;
}
}
