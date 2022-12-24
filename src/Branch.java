import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>(); // just as with Customer class, we are not creating a new ArrayList
        //of customers with each new customer, but we are initializing the ArrayList of customers for the branch
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName, double initialAmount){
        if(findCustomer(customerName) == null){ //null is the opposite value of return type of generated Class type
            this.customers.add(new Customer(customerName,initialAmount));
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String customerName, double amount){
        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer != null){
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    private Customer findCustomer(String customerName){
        for (int i=0; i<this.customers.size(); i++){
            Customer checkedCustomer = this.customers.get(i);
            if (this.customers.get(i).getName().equals(customerName)){
                return checkedCustomer;
            }
        }
        return null;
    }



}
