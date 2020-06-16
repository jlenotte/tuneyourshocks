package com.cnam.tuneyourshocks;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProfileSavingActivity extends AppCompatActivity {

    private Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_saving);


    }


    public void saveProfileToSQL(View v, SQLiteDatabase db, int psiPressure) {
        Log.i("Info", "About to save profile.");

        try {

            EditText profileName = (EditText)findViewById(R.id.profileNameText);

            String profileNameVarchar = profileName.getText().toString();

            db.execSQL("INSERT INTO Profiles (profileName, airPressure) VALUES('"+profileNameVarchar+"', '"+psiPressure+"')");




        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
