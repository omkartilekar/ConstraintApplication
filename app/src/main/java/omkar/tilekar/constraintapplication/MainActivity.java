package omkar.tilekar.constraintapplication;
// Importing the packages
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Initializing components
    TextView textView;
    EditText editText;
    Spinner spinner;
    static String string;
    RadioGroup radioGroup;
    CheckBox checkBox;
    RadioButton radioButton,radioButton1;
    private String string1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // FindViewByID Components
        spinner=findViewById(R.id.spinner);
        textView=findViewById(R.id.textView);
        editText=findViewById(R.id.editTextTextPersonName);
        radioButton=findViewById(R.id.radioButton);
        radioButton1=findViewById(R.id.radioButton2);
        radioGroup=findViewById(R.id.radio_may);
        checkBox=findViewById(R.id.checkBox);
        // Perform Operations on Checkbox
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //Checkbox is checked then it will visible or invisible other components
                if(compoundButton.isChecked())
                {
                    //Setting Visibility
                    editText.setVisibility(View.INVISIBLE);
                    radioGroup.setVisibility(View.INVISIBLE);
                    spinner.setVisibility(View.INVISIBLE);
                    textView.setVisibility(View.INVISIBLE);
                }else
                {
                    editText.setVisibility(View.VISIBLE);
                    radioGroup.setVisibility(View.VISIBLE);
                    spinner.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.VISIBLE);
                }

            }
        });
        // Using setOnItemSelectedListener when we want to show items
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            //Using onItemSelected by Adapter to make bridge
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String s= editText.getText().toString().trim();
                string= String.valueOf(adapterView.getItemAtPosition(i));
                string=string + "\n Welcome " +s +string1;
                textView.setText(string);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void onRadioButtonClicked(View view) {
        boolean status_checked=((RadioButton)view).isChecked();
        switch (view.getId())
        {
            case R.id.radioButton:
                String string1;
                // Checking Status
                if(status_checked)
                {
                    string1= "\n"+"Gender "+radioButton.getText().toString().trim();
                }

                break;
            case R.id.radioButton2:
                if(status_checked) {
                    string1 = "\n"+"Gender " + radioButton1.getText().toString().trim() + "\n";
                }
                break;
        }

    }
}

