/**
 * 
 */
package com.archi.JPA;

import javax.validation.constraints.NotNull;

import io.dropwizard.Configuration;


/**
 * @author rudi
 *
 */
public class DataBaseConfiguration extends Configuration
{
	@NotNull
    public String driverClass;
	@NotNull
    public String user;
	@NotNull
    public String password;
    @NotNull
    public String url;
 
}
