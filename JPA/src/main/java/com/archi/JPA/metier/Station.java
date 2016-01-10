/**
 * 
 */
package com.archi.JPA.metier;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author rudi
 *
 */
@Entity
@Table(appliesTo = "station")
public class Station {
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
	
 
	public Station(String libelle, String lat, String lg) 
	{
		// TODO Auto-generated constructor stub
		this.libelle = libelle;
		this.lat = lat;
		this.lg = lg;
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
}
