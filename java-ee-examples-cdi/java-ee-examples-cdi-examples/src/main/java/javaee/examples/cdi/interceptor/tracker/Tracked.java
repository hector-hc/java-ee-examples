/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaee.examples.cdi.interceptor.tracker;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Inherited;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.enterprise.util.Nonbinding;
import javax.interceptor.InterceptorBinding;

/**
 *
 * @author Héctor Hernández Chávez
 */
@InterceptorBinding
@Inherited
@Documented
@Retention(RUNTIME)
@Target({METHOD, TYPE})
public @interface Tracked {
    @Nonbinding
    Category value();
}
