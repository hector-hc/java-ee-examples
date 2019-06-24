/**
 * @Class UserTxEJB
 * @author Hector
 * @Created on Jun 23, 2019, 8:44:21 PM
 */
package javaee.examples.ejb.transactions;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.AfterBegin;
import javax.ejb.AfterCompletion;
import javax.ejb.BeforeCompletion;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserTxEJB {

    private ArrayList<Integer> actions;

    @PostConstruct
    public void init() {
        actions = new ArrayList<>();
        System.out.println("UserTxEJB initalized");
    }

    public void add(Integer action) {
        actions.add(action);
        System.out.println(action + " added");
    }

    public void remove(Integer action) {
        actions.remove(action);
        System.out.println(action + " removed");
    }

    public List getActions() {
        return actions;
    }

    @Remove
    public void logout() {
        System.out.println("User logout. Resources will be released.");
    }

    @AfterBegin
    public void transactionStarted() {
        System.out.println("Transaction started");
    }

    @BeforeCompletion
    public void willBeCommited() {
        System.out.println("Transaction will be commited");
    }

    @AfterCompletion
    public void afterCommit(boolean commited) {
        System.out.println("Transaction commited? " + commited);
    }
}
