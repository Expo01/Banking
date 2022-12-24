import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    //In Customer, think about what else you need to do in the constructor when you instantiate a Customer object.


    public Customer(String name, double initialAmount) {  // second parameter is not of type ArrayList since we are not
        //creating a new ArrayList for each customer instance, but adding initial amount and transactions for that
        // customer object into the transactions ArrayList
        this.name = name;
        this.transactions = new ArrayList<Double>(); //initializes the ArrayList field
        addTransaction(initialAmount);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double amount){
        this.transactions.add(amount); //autoboxing present as parameter type double provided and directly added into
        //the transactions ArrayList which stores type Double.

    }
}
