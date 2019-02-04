package com.sirtprojects.testejuh.Activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.led_on_off.led.R;

import java.io.IOException;
import java.util.UUID;


public class ControlActivity extends Activity implements View.OnClickListener {

    Button btSendCode, btLedOn, btLedOff, btDisconnect, btAbout, btDelay1s, btDelay5s, btPreset, btBuzzOn, btBuzzOff;
    EditText editTextCode;
    String address = null;
    private ProgressDialog progress;
    BluetoothAdapter myBluetooth = null;
    BluetoothSocket btSocket = null;
    private boolean isBtConnected = false;
    //SPP UUID. Look for it
    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        Intent newint = getIntent();
        address = newint.getStringExtra(DeviceList.EXTRA_ADDRESS); //receive the address of the bluetooth device

        //view of the ControlActivity
        setContentView(R.layout.activity_led_control);

        //call the widgets
        btSendCode = findViewById(R.id.on_btn);
        btLedOn = findViewById(R.id.button_ledControl_ledon);
        btLedOff = findViewById(R.id.button_ledControl_ledoff);
        btDelay1s = findViewById(R.id.button_ledControl_delay1s);
        btDelay5s = findViewById(R.id.button_ledControl_delay5s);
        btPreset = findViewById(R.id.button_ledControl_preset);
        btDisconnect = findViewById(R.id.dis_btn);
        btAbout = findViewById(R.id.abt_btn);
        btBuzzOn = findViewById(R.id.button_ledControl_buzzOn);
        btBuzzOff = findViewById(R.id.button_ledControl_buzzOff);
        editTextCode = findViewById(R.id.edit_text_code);
        editTextCode.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    hideKeyboard(v);
                }
            }
        });

        new ConnectBT().execute(); //Call the class to connect

        //commands to be sent to bluetooth
        btSendCode.setOnClickListener(this);
        btLedOn.setOnClickListener(this);
        btLedOff.setOnClickListener(this);
        btDelay1s.setOnClickListener(this);
        btDelay5s.setOnClickListener(this);
        btDisconnect.setOnClickListener(this);
        btPreset.setOnClickListener(this);
        btAbout.setOnClickListener(this);
        btBuzzOn.setOnClickListener(this);
        btBuzzOff.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v != null){
            if(v.getId() == btLedOn.getId()){
                ledOnTest();
            }
            else if(v.getId() == btLedOff.getId()){
                ledOffTest();
            }
            else if(v.getId() == btDelay1s.getId()){
                delay1s();
            }
            else if(v.getId() == btDelay5s.getId()){
                delay5s();
            }
            else if(v.getId() == btSendCode.getId()){
                sendCode();
            }
            else if(v.getId() == btPreset.getId()){
                sendPreset();
            }
            else if(v.getId() == btBuzzOn.getId()){
                buzzOn();
            }
            else if(v.getId() == btBuzzOff.getId()){
                buzzOff();
            }
            else if(v.getId() == btDisconnect.getId()){
                disconnect();
            }
            else if(v.getId() == btAbout.getId()){
                Intent intent = new Intent(ControlActivity.this, EditionActivity.class);
                startActivity(intent);
            }
        }

    }


    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        assert inputMethodManager != null;
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void disconnect() {
        if (btSocket!=null) //If the btSocket is busy
        {
            try
            {
                btSocket.close(); //close connection
            }
            catch (IOException e)
            { msg("Error");}
        }
        finish(); //return to the first layout

    }

    private void ledOnTest() {
        String ligarLed = "LON$";
        if (btSocket != null)
        {
            try
            {
                btSocket.getOutputStream().write(ligarLed.getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }

    private void ledOffTest(){
        if (btSocket != null){
            try {
                String desligarLed = "LOFF$";
                btSocket.getOutputStream().write(desligarLed.getBytes());
            } catch (IOException e) {
                msg("Error");
            }
        }
    }

    private void delay1s(){
        if (btSocket != null){
            try {
                String delay = "D1S$";
                btSocket.getOutputStream().write(delay.getBytes());
            } catch (IOException e) {
                msg("Error");
            }
        }
    }

    private void delay5s(){
        if (btSocket != null){
            try {
                String delay = "D5S$";
                btSocket.getOutputStream().write(delay.getBytes());
            } catch (IOException e) {
                msg("Error");
            }
        }
    }
    private void buzzOn(){
        if (btSocket != null){
            try {
                String delay = "BON$";
                btSocket.getOutputStream().write(delay.getBytes());
            } catch (IOException e) {
                msg("Error");
            }
        }
    }
    private void buzzOff(){
        if (btSocket != null){
            try {
                String delay = "BOFF$";
                btSocket.getOutputStream().write(delay.getBytes());
            } catch (IOException e) {
                msg("Error");
            }
        }
    }

    private void sendPreset(){
        if (btSocket != null){
            try {
                String preset = "L1ON$D5S$L1OFF$L2ON$D5S$L2OFF$L3ON$D5S$L3OFF$L4ON$D5S$L4OFF$";
                btSocket.getOutputStream().write(preset.getBytes());
            } catch (IOException e) {
                msg("Error");
            }
        }
    }

    private void sendCode() {
        if (btSocket != null)
        {
            try
            {
                btSocket.getOutputStream().write(editTextCode.getText().toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }

    private void msg(String s) {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_led_control, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class ConnectBT extends AsyncTask<Void, Void, Void> {
        private boolean ConnectSuccess = true; //if it's here, it's almost connected

        @Override
        protected void onPreExecute()
        {
            progress = ProgressDialog.show(ControlActivity.this, "Conectando", "Por favor, espere.");
        }

        @Override
        protected Void doInBackground(Void... devices) //while the progress dialog is shown, the connection is done in background
        {
            try
            {
                if (btSocket == null || !isBtConnected)
                {
                 myBluetooth = BluetoothAdapter.getDefaultAdapter();//get the mobile bluetooth device
                 BluetoothDevice dispositivo = myBluetooth.getRemoteDevice(address);//connects to the device's address and checks if it's available
                 btSocket = dispositivo.createInsecureRfcommSocketToServiceRecord(myUUID);//create a RFCOMM (SPP) connection
                 BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                 btSocket.connect();//start connection
                }
            }
            catch (IOException e)
            {
                ConnectSuccess = false;//if the try failed, you can check the exception here
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result) //after the doInBackground, it checks if everything went fine
        {
            super.onPostExecute(result);

            if (!ConnectSuccess)
            {
                msg("Connection Failed. Is it a SPP Bluetooth? Try again.");
                finish();
            }
            else
            {
                msg("Connected.");
                isBtConnected = true;
            }
            progress.dismiss();
        }
    }
}
