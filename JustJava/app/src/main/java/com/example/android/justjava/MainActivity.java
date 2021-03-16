/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;



import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    int price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText name = (EditText) findViewById(R.id.nameInput);
        CheckBox wc = (CheckBox) findViewById(R.id.whippedCream);
        CheckBox c = (CheckBox) findViewById(R.id.chocolate);

        if(quantity < 1){
            TextView errText = (TextView) findViewById(R.id.errorText);
            errText.setVisibility(1);
        } else if (quantity >= 1 && quantity < 100) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:michaelirimus@gmail.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java for Mike");
            intent.putExtra(Intent.EXTRA_TEXT, "Name: " + name.getText().toString()
                    + "\nWhipped Cream? " + wc.getText().toString()
                    + "\nChocolate? " + c.getText().toString()
                    + "\nQuantity: " + quantity
                    + "\nTotal: " + price + "€"
                    + "\nThank you!");

            if (quantity > 100) {
                intent.putExtra(Intent.EXTRA_TEXT, "PS: Take Care! You are about to order " + quantity + " coffees!");
            }

            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                //TODO: Handle case where no email app is available
            }
        }
    }

    public void addCoffee(View view){
        quantity++;
        price=quantity*5;
        display(quantity);
        displayPrice(price);
    }

    public void removeCoffee(View view){
        quantity--;
        price=quantity*5;
        display(quantity);
        displayPrice(price);
    }

    public void checkCream(View view){
        CheckBox simpleCheckBox = (CheckBox) findViewById(R.id.whippedCream);
        if(simpleCheckBox.isChecked() == true){
            price+=2;
            displayPrice(price);
        } else {
            price-=2;
            displayPrice(price);
        }
    }

    public void checkChocolate(View view){
        CheckBox simpleCheckBox = (CheckBox) findViewById(R.id.chocolate);
        if(simpleCheckBox.isChecked() == true){
            price+=2;
            displayPrice(price);
        } else {
            price-=2;
            displayPrice(price);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}