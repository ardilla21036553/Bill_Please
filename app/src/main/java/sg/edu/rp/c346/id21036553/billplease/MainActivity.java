package sg.edu.rp.c346.id21036553.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    //declare variables
    EditText amount;
    EditText numpax;
    EditText discount;
    ToggleButton svs;
    ToggleButton gst;
    TextView eachPays;
    TextView totalBill;
    Button split;
    Button reset;

    RadioGroup rgMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect variables to UI elements.
        amount = findViewById(R.id.editInputAmount);
        numpax = findViewById(R.id.editInputNumPax);
        totalBill = findViewById(R.id.totalbills);
        eachPays = findViewById(R.id.eachpay);
        svs = findViewById(R.id.tgBtnSvs);
        gst = findViewById(R.id.tgBtnGst);
        split = findViewById(R.id.split);
        reset = findViewById(R.id.reset);
        discount = findViewById(R.id.editInputDisc);


        split.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data1 = amount.getText().toString();
                String data2 = numpax.getText().toString();

                double amount = Double.parseDouble(data1);
                double newAmount = 0.0;
                int pax = Integer.parseInt(data2);

                if (gst.isChecked() == true && svs.isChecked() == true) {
                    newAmount = amount * 1.1 * 1.07;
                } else if (gst.isChecked() == false && svs.isChecked() == true) {
                    newAmount = amount * 1.10;
                } else if (gst.isChecked() == true && svs.isChecked() == false) {
                    newAmount = amount * 1.17;
                } else {
                    newAmount = amount;
                }

                double paying = newAmount / pax;
                totalBill.setText("Total amount: $" +  newAmount);
                eachPays.setText("Each pays: $" + paying + " in cash");
                    // "via PayNow to 912345678"
            }
        });


        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                amount.setText("");
                numpax.setText("");
                svs.setChecked(false);
                gst.setChecked(false);
                discount.setText("");
            }
        });
    }


}