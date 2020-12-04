package com.example.justpizza;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    TextView quantityNumberView;
    TextView priceTextView;
    int quantity = 1;
    int pizzaPrice = 4;
    private RadioGroup pizzaType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantityNumberView = findViewById(R.id.quantityNumber);
        priceTextView = findViewById(R.id.price_text_view);
        pizzaType = (RadioGroup)findViewById(R.id.pizza_type);
        pizzaType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View additionsGroup = findViewById(R.id.additions);

                RadioButton radioButton = (RadioButton) findViewById(checkedId);

                Toast.makeText(getBaseContext(), radioButton.getText(), Toast.LENGTH_SHORT).show();

                if (radioButton.getText().equals("Just Pizza")) {
                    additionsGroup.setVisibility(View.VISIBLE);
                } else {
                    additionsGroup.setVisibility(View.GONE);
                }
            }
        });
    }

    public void submitOrder(View view) {
        display(1);
    }

    public void display(int number) {
        quantityNumberView.setText("" + number);
    }

    public void increment(View view) {
        if (quantity == 100) {
            Toast.makeText(this, "Can order more than 100 pizzas", Toast.LENGTH_SHORT).show();

            return;
        }

        quantity += 1;
        display(quantity);
    }

    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this, "Can order less than 1 pizza", Toast.LENGTH_SHORT).show();

            return;
        }

        quantity -= 1;
        display(quantity);
    }

    public void order(View view) {
        int price = quantity * pizzaPrice;

        String priceString = String.valueOf(NumberFormat.getCurrencyInstance().format(price));
        String priceMessage = "Total value: " + priceString + " Thank you.";

        displayMessage(priceMessage);
    }

    private void displayMessage(String message) {
        priceTextView.setText(message);
    }
}
