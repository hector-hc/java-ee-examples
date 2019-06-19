/*
* Classname:    CountryClassLeveEJB.java
* Author:       Héctor Hernández Chávez <hector.hernandez@conceptomovil.com>
* Date:         19-jun-2019
* © Concepto Móvil S.A. de C.V. 2014
*/
package javaee.examples.ejb.concurrency;

import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

/**
 * @author Héctor Hernández Chávez <hector.hernandez@conceptomovil.com>
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER) // redundat
@Lock(LockType.READ)
@AccessTimeout(value = 5000)
public class CountryClassLeveEJB {
    
    private int countryCount;
    
    public int getCountryCount() {
        return countryCount;
    }
    
    public void addCountry() {
        countryCount++;
    }
}
