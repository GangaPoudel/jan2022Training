package com.ganga.observablepattern;

public class Shop {
	public static void main(String[] args) {
	    // Initialization
	    Subject fashionChainStores = new Store();
	    Observer customer1 = new PassiveCustomer();
	    Observer customer2 = new ShopaholicCustomer();
	    Observer customer3 = new ShopaholicCustomer();

	    // Adding two customers to the newsletter
	    fashionChainStores.addSubscriber(customer1);
	    fashionChainStores.addSubscriber(customer2);

	    // Notifying customers (observers)
	    fashionChainStores.notifySubscribers();

	    // A customer has decided not to continue following the newsletter
	    fashionChainStores.removeSubscriber(customer1);

	    // customer2 told customer3 that a sale is going on
	    fashionChainStores.addSubscriber(customer3);

	    // Notifying the updated list of customers
	    fashionChainStores.notifySubscribers();
	}

}
