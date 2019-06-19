/*
* Classname:    CountryMethodLevelEJB.java
* Author:       Héctor Hernández Chávez
* Date:         19-jun-2019
*/
package javaee.examples.ejb.concurrency;

import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

/**
 * @author Héctor Hernández Chávez
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@AccessTimeout(value = 5000)
public class CountryMethodLevelEJB {

    private int countryCount;
    
    @Lock(LockType.READ)
    public int getCountryCount() {
        return countryCount;
    }
    
    @Lock(LockType.WRITE)
    public void addCountry() {
        countryCount++;
    }
}
