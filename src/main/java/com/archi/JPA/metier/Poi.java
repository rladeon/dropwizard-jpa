/**
 * 
 */
package com.archi.JPA.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author rudi
 *
 */
@Entity
@Table(name = "poi")
public class Poi {
	@JsonProperty
	@Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@JsonProperty
	@NotBlank
	@Column(name = "libelle")
	private String libelle;
	@JsonProperty
	@Column(name = "lat")
    private String lat;
	@JsonProperty
	@Column(name = "lg")
    private String lg;
	@JsonProperty
	@Column(name = "alt")
    private String alt;
	@JsonProperty
	@Column(name = "description")
    private String description;
	
	public Poi()
	{
		
	}
 
	public Poi(String libelle, String lat, String lg, String alt, String description) 
	{
		// TODO Auto-generated constructor stub
		this.libelle = libelle;
		this.lat = lat;
		this.lg = lg;
		this.alt = alt;
		this.description = description;
	} 
	
 
    public long getId()
    {
        return id;
    }
    public String getLibelle()
    {
        return libelle;
    }
    public void setLibelle(String libelle)
    {
		this.libelle = libelle;
	}
    public String getLat() 
    {
        return lat;
    }
    public void setLat(String lat)
    {
		this.lat = lat;
	}
    public String getLg()
    {
        return lg;
    }
    public void setLg(String lg)
    {
		this.lg = lg;
	}    
    public String getAlt()
    {
        return alt;
    }
    public void setAlt(String alt)
    {
		this.alt = alt;
	}
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String d)
    {
		this.description = d;
	}
}
