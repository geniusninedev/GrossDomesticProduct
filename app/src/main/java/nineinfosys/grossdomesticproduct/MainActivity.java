package nineinfosys.grossdomesticproduct;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView consumptionTextView,governmentconsumptionTextView,grossinvestmentTextView,exportTextView;
    TextView importTextview;
    EditText consumptionEditText,governmentconsumptionEditText,grossinvestmentEditText,exportEditText;
    EditText importEditText;
    TextView grossDomesticProductValue;
    gdpCalci grossDomesticProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        consumptionTextView=(TextView)findViewById(R.id.textViewPersonalConsumption);
        governmentconsumptionTextView=(TextView)findViewById(R.id.editTextGovernmentConsumption);
        grossinvestmentTextView=(TextView)findViewById(R.id.textViewGrossInvestment);
        exportTextView=(TextView)findViewById(R.id.textViewExport);
        importTextview=(TextView)findViewById(R.id.textViewImport);
        grossDomesticProductValue=(TextView)findViewById(R.id.textViewResult);

        consumptionEditText=(EditText)findViewById(R.id.editTextPersonalConsumption);
        governmentconsumptionEditText=(EditText)findViewById(R.id.editTextGovernmentConsumption);
        grossinvestmentEditText=(EditText)findViewById(R.id.editTextGrossInvestment);
        exportEditText=(EditText)findViewById(R.id.editTextExport);
        importEditText=(EditText)findViewById(R.id.editTextImport);

        Button buttonCalculte=(Button) findViewById(R.id.buttonCalculate);
        Button buttonClear=(Button) findViewById(R.id.buttonClear);

        buttonCalculte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(consumptionEditText.getText().toString().trim())) {
                    consumptionEditText.setError("enter the consumption");
                    return;
                }
                if (TextUtils.isEmpty(grossinvestmentEditText.getText().toString().trim())) {
                    grossinvestmentEditText.setError("enter the grossinvestment");
                    return;
                }
                if (TextUtils.isEmpty(governmentconsumptionEditText.getText().toString().trim())) {
                    governmentconsumptionEditText.setError("enter the governmentconsumption");
                    return;
                }

                 if (TextUtils.isEmpty(exportEditText.getText().toString().trim())) {
                    exportEditText.setError("enter the export");
                    return;
                }
                if (TextUtils.isEmpty(importEditText.getText().toString().trim())) {
                    importEditText.setError("enter the import");
                    return;
                }

                double consumptionValue=Double.parseDouble(consumptionEditText.getText().toString().trim());

                double governmentconsumption=Double.parseDouble(governmentconsumptionEditText.getText().toString().trim());
                double grossinvestment=Double.parseDouble(grossinvestmentEditText.getText().toString().trim());
                double netexportsValue=Double.parseDouble(exportEditText.getText().toString().trim());
                double netimportsValue=Double.parseDouble(importEditText.getText().toString().trim());

                String consumptionValue1 = Double.toString((double) consumptionValue);
                String governmentconsumption1 = Double.toString((double) governmentconsumption);
                String grossinvestment1 = Double.toString((double) grossinvestment);
                String netexportsValue1 = Double.toString((double) netexportsValue);
                String netimportsValue1 = Double.toString((double) netimportsValue);

                grossDomesticProduct=new gdpCalci(consumptionValue,grossinvestment,governmentconsumption,netexportsValue,netimportsValue);
                double resultgrossDomesticProductValue=grossDomesticProduct.gdpCalculator();
                //   String resultBodySurfaceArea1 = Double.toString((double) resultBodySurfaceArea);
                grossDomesticProductValue.setText( "Gross Domestic Product Value:".toString()+Double.toString((double) resultgrossDomesticProductValue));
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consumptionEditText.getText().clear();
                governmentconsumptionEditText.getText().clear();
                grossinvestmentEditText.getText().clear();
                exportEditText.getText
                        ().clear();
                importEditText.getText().clear();
                grossDomesticProductValue.setText("");


            }
        });

    }
}
