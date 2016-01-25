package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    public static int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice() {
        int price = quantity * 10;
        return price;
    }

    /* Creates order summary*/
    public String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolate){
        String priceMessage = "Name: Derp Herp";
        priceMessage += "\nAdd whipped cream? " + hasWhippedCream;
        priceMessage += "\nAdd chocolate? " + hasChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

     /* This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        /*
        int numberOfCoffees = 1;
        display(numberOfCoffees);
        displayPrice(numberOfCoffees * 5);
        */
        /*
        display(quantity);
        displayPrice(quantity * 5);
        */
        /*
        int price = quantity * 5;
        */

        int price = calculatePrice();

        CheckBox whippedCreamCB = (CheckBox) findViewById(R.id.whippedcream_checkbox);
        boolean whippedCream = whippedCreamCB.isChecked();


        CheckBox chocolateCB = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean chocolate = chocolateCB.isChecked();

        String priceMessage = createOrderSummary(price, whippedCream, chocolate);

        displayMessage(priceMessage);
    }


    /**
     * This method is called when the the plus button is clicked
     */
    public void increment(View view) {
        quantity += 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the the plus button is clicked
     */
    public void decrement(View view) {
        quantity -= 1;
        if (quantity < 0) {
            quantity = 0;
        }
        displayQuantity(quantity);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberone) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + numberone);
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}

