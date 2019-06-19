/*
* Classname:    CountrySelftManagedEJB.java
* Author:       Héctor Hernández Chávez
* Date:         19-jun-2019
*/
package javaee.examples.ejb.concurrency;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;

/**
 * @author Héctor Hernández Chávez
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class CountrySelftManagedEJB {

    private int countryCount;
    
    public int getCountryCount() {
        return countryCount;
    }
    
    public synchronized void addCountry() {
        countryCount++;
    }
}
