package pt.hw1.dialerpad;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private static final String LOG_TAG = MainActivity.class.getName();

    private static final String URI_PREFIX_TEL = "tel:";
    private static final String SYMBOL_STAR = "*";
    private static final String SYMBOL_POUND = "#";

    private static final int PERMISSIONS_REQUEST_CALL_PHONE = 100;

    private RelativeLayout mLayout;
    private TextView textViewDisplay;
    private Button buttonDel;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonStar;
    private Button buttonZero;
    private Button buttonPound;
    private Button buttonCall;
    private Button buttonSettings;

    private HashMap<Integer, Integer> speedDialMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        speedDialMap = SpeedDialSingleton.getInstance().getHashMap();

        mLayout = (RelativeLayout) findViewById(R.id.relative_layout_dialer);
        textViewDisplay = (TextView) findViewById(R.id.text_view_display);
        textViewDisplay.setOnClickListener(this);
        buttonDel = (Button) findViewById(R.id.button_del);
        buttonDel.setOnClickListener(this);
        buttonDel.setOnLongClickListener(this);
        button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(this);
        button1.setOnLongClickListener(this);
        button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(this);
        button2.setOnLongClickListener(this);
        button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(this);
        button3.setOnLongClickListener(this);
        button4 = (Button) findViewById(R.id.button_4);
        button4.setOnClickListener(this);
        button4.setOnLongClickListener(this);
        button5 = (Button) findViewById(R.id.button_5);
        button5.setOnClickListener(this);
        button5.setOnLongClickListener(this);
        button6 = (Button) findViewById(R.id.button_6);
        button6.setOnClickListener(this);
        button6.setOnLongClickListener(this);
        button7 = (Button) findViewById(R.id.button_7);
        button7.setOnClickListener(this);
        button7.setOnLongClickListener(this);
        button8 = (Button) findViewById(R.id.button_8);
        button8.setOnClickListener(this);
        button8.setOnLongClickListener(this);
        button9 = (Button) findViewById(R.id.button_9);
        button9.setOnClickListener(this);
        button9.setOnLongClickListener(this);
        buttonZero = (Button) findViewById(R.id.button_zero);
        buttonZero.setOnClickListener(this);
        buttonStar = (Button) findViewById(R.id.button_star);
        buttonStar.setOnClickListener(this);
        buttonPound = (Button) findViewById(R.id.button_pound);
        buttonPound.setOnClickListener(this);
        buttonCall = (Button) findViewById(R.id.button_call);
        buttonCall.setOnClickListener(this);
        buttonSettings = (Button) findViewById(R.id.button_settings);
        buttonSettings.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_del:
                deleteCharacter();
                break;
            case R.id.button_1:
                appendDigit(1);
                break;
            case R.id.button_2:
                appendDigit(2);
                break;
            case R.id.button_3:
                appendDigit(3);
                break;
            case R.id.button_4:
                appendDigit(4);
                break;
            case R.id.button_5:
                appendDigit(5);
                break;
            case R.id.button_6:
                appendDigit(6);
                break;
            case R.id.button_7:
                appendDigit(7);
                break;
            case R.id.button_8:
                appendDigit(8);
                break;
            case R.id.button_9:
                appendDigit(9);
                break;
            case R.id.button_zero:
                appendDigit(0);
                break;
            case R.id.button_star:
                appendSymbol(SYMBOL_STAR);
                break;
            case R.id.button_pound:
                appendSymbol(SYMBOL_POUND);
                break;
            case R.id.button_call:
                call();
                break;
            case R.id.button_settings:
                openSettingsActivity();
                break;
            default:
                break;
        }
    }

    private void openSettingsActivity() {
        Intent settingsintent = new Intent(this, SettingsActivity.class);
        startActivity(settingsintent);
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case R.id.button_del:
                cancel();
                return true;
            case R.id.button_1:
                if(speedDialMap.containsKey(1)){
                    cancel();
                    appendDigit(speedDialMap.get(1));
                    call();
                    return true;
                }
                return false;
            case R.id.button_2:
                if(speedDialMap.containsKey(2)){
                    cancel();
                    appendDigit(speedDialMap.get(2));
                    call();
                    return true;
                }
                return false;
            case R.id.button_3:
                if(speedDialMap.containsKey(3)){
                    cancel();
                    appendDigit(speedDialMap.get(3));
                    call();
                    return true;
                }
                return false;
            case R.id.button_4:
                if(speedDialMap.containsKey(4)){
                    cancel();
                    appendDigit(speedDialMap.get(4));
                    call();
                    return true;
                }
                return false;
            case R.id.button_5:
                if(speedDialMap.containsKey(5)){
                    cancel();
                    appendDigit(speedDialMap.get(5));
                    call();
                    return true;
                }
                return false;
            case R.id.button_6:
                if(speedDialMap.containsKey(6)){
                    cancel();
                    appendDigit(speedDialMap.get(6));
                    call();
                    return true;
                }
                return false;
            case R.id.button_7:
                if(speedDialMap.containsKey(7)){
                    cancel();
                    appendDigit(speedDialMap.get(7));
                    call();
                    return true;
                }
                return false;
            case R.id.button_8:
                if(speedDialMap.containsKey(8)){
                    cancel();
                    appendDigit(speedDialMap.get(8));
                    call();
                    return true;
                }
                return false;
            case R.id.button_9:
                if(speedDialMap.containsKey(9)){
                    cancel();
                    appendDigit(speedDialMap.get(9));
                    call();
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSIONS_REQUEST_CALL_PHONE) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Snackbar.make(mLayout, R.string.permission_available_call_phone, Snackbar.LENGTH_SHORT).show();
                callPhone();
            } else {
                Snackbar.make(mLayout, R.string.permissions_not_granted, Snackbar.LENGTH_SHORT).show();
            }
        }
    }

    private void requestCallPhonePermissions() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {

            Snackbar.make(mLayout, R.string.permission_contacts_rationale,
                    Snackbar.LENGTH_INDEFINITE)
                    .setAction(R.string.button_ok, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSIONS_REQUEST_CALL_PHONE);
                        }
                    })
                    .show();
        } else {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSIONS_REQUEST_CALL_PHONE);
        }
    }

    private void call(){
        if (textViewDisplay.getText() != null) {
            if (textViewDisplay.getText().toString().length() > 0) {
                try {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        requestCallPhonePermissions();
                    } else {
                        callPhone();
                    }
                } catch (Exception e) {
                    Log.e(LOG_TAG, "Could not start CALL intent. Will try to start DIAL intent.", e);
                    dialPhone();
                }
            } else {
                showPhoneValidationToast();
            }
        } else {
            showPhoneValidationToast();
        }
    }

    private void showPhoneValidationToast(){
        Toast.makeText(MainActivity.this, getString(R.string.validation_enter_phone_number), Toast.LENGTH_SHORT).show();
    }


    private void cancel(){
        textViewDisplay.setText("");
    }


    private void appendSymbol(String symbol) {
        textViewDisplay.append(symbol);
    }


    private void appendDigit(int digit) {
        textViewDisplay.append(String.valueOf(digit));
    }


    private void deleteCharacter() {
        if (textViewDisplay.getText() != null) {
            String phoneNumber = textViewDisplay.getText().toString();
            if (phoneNumber.length() > 0) {
                phoneNumber = phoneNumber.substring(0, phoneNumber.length() - 1);
                textViewDisplay.setText(phoneNumber);
            }
        }
    }

    private void dialPhone() {
        try {
            String phoneNumber = textViewDisplay.getText().toString();
            Intent dialIntent = new Intent(Intent.ACTION_DIAL);
            dialIntent.setData(Uri.parse(URI_PREFIX_TEL + Uri.encode(phoneNumber)));
            dialIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(dialIntent);
        } catch (Exception e) {
            Log.e(LOG_TAG, "An exception occurred trying to execute the DIAL intent.", e);
        }
    }

    private void callPhone() {
        try {
            String phoneNumber = textViewDisplay.getText().toString();
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse(URI_PREFIX_TEL + Uri.encode(phoneNumber)));
            startActivity(callIntent);
        } catch (SecurityException e) {
            Log.e(LOG_TAG, "An exception occurred trying to execute the CALL intent.", e);
        }
    }
}