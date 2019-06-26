/*
* Classname:    AsyncTask.java
* Author:       Héctor Hernández Chávez
* Date:         26-jun-2019
*/
package javaee.examples.jaxrs.async.tx;

import java.util.concurrent.Callable;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 * @author Héctor Hernández Chávez
 */
public class AsyncTask implements Callable<UserAsyncTx> {

    private UserTransaction userTransaction;
    
    private UserAsyncTxEJB userAsyncTxEJB;

    @Override
    public UserAsyncTx call() throws Exception {
        perfomLookups();
        try {
            userTransaction.begin();
            UserAsyncTx user = userAsyncTxEJB.getUser();
            userTransaction.commit();
            return user;
        } catch (IllegalStateException | SecurityException | HeuristicMixedException 
                | HeuristicRollbackException | NotSupportedException | RollbackException | SystemException e) {
            userTransaction.rollback();
            return null;
        }
    }

    private void perfomLookups() {
        userAsyncTxEJB = CDI.current().select(UserAsyncTxEJB.class).get();
        userTransaction = CDI.current().select(UserTransaction.class).get();
    }
}
