package cejv669.concordia.com.lab3_tip_calculator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText price_meal = findViewById(R.id.edTxt_Price);
        final Button b_confirm = findViewById(R.id.btn_Confirm);
        final TextView text_result = findViewById(R.id.txt_Result);

        b_confirm.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String priceOfDinner = price_meal.getText().toString();
                String gstAmount = new DecimalFormat("####.##")
                        .format(Double.parseDouble(priceOfDinner) * 0.05);
                String qstAmount = new DecimalFormat("####.##")
                        .format(Double.parseDouble(priceOfDinner) * 0.09975);
                String totalPrice = new DecimalFormat("####.##")
                        .format(Double.parseDouble(priceOfDinner)+
                                Double.parseDouble(gstAmount)+
                                Double.parseDouble(qstAmount));


                text_result.setText("The price of the meal is: " + price_meal.getText().toString()+"$" +
                        "\n" + "GST amount is " + "$"+ gstAmount +"\n" + "QST amount is " +"$" + qstAmount
                        +"\n" + "Total amount is " + "$" + totalPrice);

            }
        });
    }
}
