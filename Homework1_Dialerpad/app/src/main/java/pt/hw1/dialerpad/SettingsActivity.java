package pt.hw1.dialerpad;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener{


    private Button buttonsave;
    private Spinner dialernumber;
    private EditText telephonenumber;

    private int keypadnumber;
    private int phonenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        dialernumber = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.items_class,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dialernumber.setAdapter(adapter);
        dialernumber.setOnItemSelectedListener(this);
        telephonenumber = (EditText) findViewById(R.id.telephonenumber_edit);
        buttonsave = (Button) findViewById(R.id.button_save);
        buttonsave.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        keypadnumber = Integer.parseInt(parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_save:
                getTelephoneNumber();
                if(keypadnumber>0){
                    SpeedDialSingleton.getInstance().addToHashMap(keypadnumber,phonenumber);
                    Toast.makeText(getApplicationContext(),"Saved Successfully",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    private void getTelephoneNumber() {
        if(!telephonenumber.getText().toString().equals("")) {
            phonenumber = Integer.parseInt(telephonenumber.getText().toString());
        }
    }
}
