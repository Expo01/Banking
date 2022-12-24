import com.sun.jdi.request.BreakpointRequest;

import javax.security.auth.login.CredentialException;
import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>(); //initialize ArrayList again
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branch branch = findBranch(branchName); //Branch object returned if exists in branches ArrayList
        if (branch != null) {
            return branch.newCustomer(customerName, initialAmount); //newCustomer method from branch class returns boolean
            // for whether new customer was added to the customers ArrayList of the located branch object
            //such that if branch exists but customer does not exist --> true. else --> false;
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName, amount); //same concept as addCustomer method above
        }
        return false;
    }

    private Branch findBranch(String branchName) {
        for (int i = 0; i < this.branches.size(); i++) {
            Branch checkedBranch = this.branches.get(i);
            if (checkedBranch.getName().equals(branchName)) {
                return checkedBranch; //if branch exists, compare the name field to entered parameter. return the
                // found branch object, if not found returns null
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if (branch != null) { //if branch object is found
            System.out.println("Customer details for branch " + branch.getName()); //name of branch
            ArrayList<Customer> branchCustomers = branch.getCustomers(); //ArrayList of all customers of the branch created
            for (int i = 0; i < branchCustomers.size(); i++) { //loops through ArrayList and prints their name and index #
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i + 1) + "]");
                if (showTransactions) { //if we choose to show transactions, ArrayList of transactions created for customer
                    //at each index.
                    System.out.println("Transaction");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) { //then loop and print all transactions
                        System.out.println("[" + (j + 1) + "] Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }


}
