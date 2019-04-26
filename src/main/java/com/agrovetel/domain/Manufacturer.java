package com.agrovetel.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "manufacturers")
public class Manufacturer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	@NotBlank
	private String manufacturerName;

	@Column
	private boolean enabled;

	@OneToMany(mappedBy = "manufacturer")
	private List<Ad> ads;

	public Manufacturer() {

	}

	public Manufacturer(long id, String manufacturerName) {
		super();
		this.id = id;
		this.manufacturerName = manufacturerName;
	}

	public Manufacturer(String manufacturerName) {
		super();
		this.manufacturerName = manufacturerName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public List<Ad> getAds() {
		return ads;
	}

	public void setAds(List<Ad> ads) {
		this.ads = ads;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Manufacturer [id=" + id + ", manufacturerName=" + manufacturerName + ", enabled=" + enabled + "]";
	}

}
