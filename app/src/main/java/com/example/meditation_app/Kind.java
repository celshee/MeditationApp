package com.example.meditation_app;

import android.Manifest;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Kind extends AppCompatActivity {
    EditText editTextPhone;
    EditText editTextMessage;
    Button sendMessageButton;

    private static final int REQUEST_SMS_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kind);

        editTextPhone = findViewById(R.id.editText_Phone);
        editTextMessage = findViewById(R.id.editText_msg);
        sendMessageButton = findViewById(R.id.sendMessageButton);

        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(Kind.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                    sendSms();
                } else {
                    ActivityCompat.requestPermissions(Kind.this, new String[]{Manifest.permission.SEND_SMS}, REQUEST_SMS_PERMISSION);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_SMS_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                sendSms();
            } else {
                Toast.makeText(Kind.this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void sendSms() {
        String phoneNumber = editTextPhone.getText().toString();
        String message = editTextMessage.getText().toString();
        try {
            if (!phoneNumber.isEmpty() && !message.isEmpty()) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                Toast.makeText(Kind.this, "Message sent successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Kind.this, "Please enter phone number and message", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(Kind.this, "Failed to send message", Toast.LENGTH_SHORT).show();
        }
    }
}
