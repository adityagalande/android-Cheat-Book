package com.example.cheatbook;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Feedback extends AppCompatActivity {

    private final ArrayList<CountryItem> countryList = new ArrayList<>();
    ;

    EditText name, emailSubject, emailMessage;
    RelativeLayout sendButton;
    private String eName, clickedCountryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException ignored) {
        }


        initList();
        Spinner spinner = findViewById(R.id.spinnerCountry);
        CountryAdapter countryAdapter = new CountryAdapter(this, 0, countryList);
        spinner.setAdapter(countryAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                here we get country name when clicked to store in (Toast or any Variable)
                CountryItem clickedItem = (CountryItem) parent.getItemAtPosition(position);
                clickedCountryName = clickedItem.getCountryName();
                Toast.makeText(Feedback.this, clickedCountryName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        name = findViewById(R.id.name);
        emailSubject = findViewById(R.id.emailSubject);
        emailMessage = findViewById(R.id.emailMessage);
        sendButton = findViewById(R.id.sendFeedbackButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recipient = "adityagalande14@gmail.com".trim();
                String subject = emailSubject.getText().toString().trim();
                String message = emailMessage.getText().toString().trim();

                sendEmail(recipient, subject, message);
            }
        });

    }

    private void initList() {

        countryList.add(new CountryItem("United States", R.drawable.united_states_of_america));
        countryList.add(new CountryItem("Afghanistan", R.drawable.afghanistan));
        countryList.add(new CountryItem("Albania", R.drawable.albania));
        countryList.add(new CountryItem("Algeria", R.drawable.algeria));
        countryList.add(new CountryItem("Andorra", R.drawable.andorra));
        countryList.add(new CountryItem("Angola", R.drawable.angola));
        countryList.add(new CountryItem("Antigua Barbuda", R.drawable.antigua_barbuda));
        countryList.add(new CountryItem("Argentina", R.drawable.argentina));
        countryList.add(new CountryItem("Armenia", R.drawable.armenia));
        countryList.add(new CountryItem("Australia", R.drawable.australia));
        countryList.add(new CountryItem("Austria", R.drawable.austria));
        countryList.add(new CountryItem("Azerbaijan", R.drawable.azerbaijan));
        countryList.add(new CountryItem("Bahamas", R.drawable.bahamas));
        countryList.add(new CountryItem("Bahrain", R.drawable.bahrain));
        countryList.add(new CountryItem("Bangladesh", R.drawable.bangladesh));
        countryList.add(new CountryItem("Barbados", R.drawable.barbados));
        countryList.add(new CountryItem("Belarus", R.drawable.belarus));
        countryList.add(new CountryItem("Belgium", R.drawable.belgium));
        countryList.add(new CountryItem("Belize", R.drawable.belize));
        countryList.add(new CountryItem("Benin", R.drawable.benin));
        countryList.add(new CountryItem("Bhutan", R.drawable.bhutan));
        countryList.add(new CountryItem("Bolivia", R.drawable.bolivia));
        countryList.add(new CountryItem("Bosnia Herzegovina", R.drawable.bosnia_herzegovina));
        countryList.add(new CountryItem("Botswana", R.drawable.botswana));
        countryList.add(new CountryItem("Brazil", R.drawable.brazil));
        countryList.add(new CountryItem("Brunei", R.drawable.brunei));
        countryList.add(new CountryItem("Bulgaria", R.drawable.bulgaria));
        countryList.add(new CountryItem("Burkina Faso", R.drawable.burkina_faso));
        countryList.add(new CountryItem("Burundi", R.drawable.burundi));
        countryList.add(new CountryItem("Cambodia", R.drawable.cambodia));
        countryList.add(new CountryItem("Cameroon", R.drawable.cameroon));
        countryList.add(new CountryItem("Canada", R.drawable.canada));
        countryList.add(new CountryItem("Central African Republic", R.drawable.central_african_republic));
        countryList.add(new CountryItem("Chad", R.drawable.chad));
        countryList.add(new CountryItem("Chile", R.drawable.chile));
        countryList.add(new CountryItem("China", R.drawable.china));
        countryList.add(new CountryItem("Colombia", R.drawable.colombia));
        countryList.add(new CountryItem("comoros", R.drawable.comoros));
        countryList.add(new CountryItem("Costa Rica", R.drawable.costa_rica));
        countryList.add(new CountryItem("Croatia", R.drawable.croatia));
        countryList.add(new CountryItem("Cuba", R.drawable.cuba));
        countryList.add(new CountryItem("Cyprus", R.drawable.cyprus));
        countryList.add(new CountryItem("Czech Republic", R.drawable.czech_republic));
        countryList.add(new CountryItem("Democratic Republic Congo", R.drawable.democratic_republic_of_congo));
        countryList.add(new CountryItem("Denmark", R.drawable.denmark));
        countryList.add(new CountryItem("Djibouti", R.drawable.djibouti));
        countryList.add(new CountryItem("Dominica", R.drawable.dominica));
        countryList.add(new CountryItem("Dominican Republic", R.drawable.dominican_republic));
        countryList.add(new CountryItem("Ecuador", R.drawable.ecuador));
        countryList.add(new CountryItem("Egypt", R.drawable.egypt));
        countryList.add(new CountryItem("England", R.drawable.england));
        countryList.add(new CountryItem("Eritrea", R.drawable.eritrea));
        countryList.add(new CountryItem("Estonia", R.drawable.estonia));
        countryList.add(new CountryItem("Ethiopia", R.drawable.ethiopia));
        countryList.add(new CountryItem("Fiji", R.drawable.fiji));
        countryList.add(new CountryItem("Finland", R.drawable.finland));
        countryList.add(new CountryItem("France", R.drawable.france));
        countryList.add(new CountryItem("Gabon", R.drawable.gabon));
        countryList.add(new CountryItem("Gambia", R.drawable.gambia));
        countryList.add(new CountryItem("Georgia", R.drawable.georgia));
        countryList.add(new CountryItem("Germany", R.drawable.germany));
        countryList.add(new CountryItem("Ghana", R.drawable.ghana));
        countryList.add(new CountryItem("Greece", R.drawable.greece));
        countryList.add(new CountryItem("Greenland", R.drawable.greenland));
        countryList.add(new CountryItem("Grenada", R.drawable.grenada));
        countryList.add(new CountryItem("Guatemala", R.drawable.guatemala));
        countryList.add(new CountryItem("Guinea", R.drawable.guinea));
        countryList.add(new CountryItem("Guinea Bissau", R.drawable.guinea_bissau));
        countryList.add(new CountryItem("Guyana", R.drawable.guyana));
        countryList.add(new CountryItem("Haiti", R.drawable.haiti));
        countryList.add(new CountryItem("Honduras", R.drawable.honduras));
        countryList.add(new CountryItem("Hungary", R.drawable.hungary));
        countryList.add(new CountryItem("Iceland", R.drawable.iceland));
        countryList.add(new CountryItem("India", R.drawable.india));
        countryList.add(new CountryItem("Indonesia", R.drawable.indonesia));
        countryList.add(new CountryItem("Iran", R.drawable.iran));
        countryList.add(new CountryItem("Iraq", R.drawable.iraq));
        countryList.add(new CountryItem("Ireland", R.drawable.ireland));
        countryList.add(new CountryItem("Israel", R.drawable.israel));
        countryList.add(new CountryItem("Italy", R.drawable.italy));
        countryList.add(new CountryItem("Jamaica", R.drawable.jamaica));
        countryList.add(new CountryItem("Japan", R.drawable.japan));
        countryList.add(new CountryItem("Jordan", R.drawable.jordan));
        countryList.add(new CountryItem("Kazakhstan", R.drawable.kazakhstan));
        countryList.add(new CountryItem("Kenya", R.drawable.kenya));
        countryList.add(new CountryItem("Kiribati", R.drawable.kiribati));
        countryList.add(new CountryItem("Kuwait", R.drawable.kuwait));
        countryList.add(new CountryItem("Kyrgyzstan", R.drawable.kyrgyzstan));
        countryList.add(new CountryItem("Laos", R.drawable.laos));
        countryList.add(new CountryItem("Latvia", R.drawable.latvia));
        countryList.add(new CountryItem("Lebanon", R.drawable.lebanon));
        countryList.add(new CountryItem("Lesotho", R.drawable.lesotho));
        countryList.add(new CountryItem("Liberia", R.drawable.liberia));
        countryList.add(new CountryItem("Libya", R.drawable.libya));
        countryList.add(new CountryItem("Liechtenstein", R.drawable.liechtenstein));
        countryList.add(new CountryItem("Lithuania", R.drawable.lithuania));
        countryList.add(new CountryItem("Luxembourg", R.drawable.luxembourg));
        countryList.add(new CountryItem("Madagascar", R.drawable.madagascar));
        countryList.add(new CountryItem("Malawi", R.drawable.malawi));
        countryList.add(new CountryItem("Malaysia", R.drawable.malaysia));
        countryList.add(new CountryItem("Maldives", R.drawable.maldives));
        countryList.add(new CountryItem("Mali", R.drawable.mali));
        countryList.add(new CountryItem("Marshall Island", R.drawable.marshall_island));
        countryList.add(new CountryItem("Mauritania", R.drawable.mauritania));
        countryList.add(new CountryItem("Mauritius", R.drawable.mauritius));
        countryList.add(new CountryItem("Mexico", R.drawable.mexico));
        countryList.add(new CountryItem("Micronesia", R.drawable.micronesia));
        countryList.add(new CountryItem("Moldova", R.drawable.moldova));
        countryList.add(new CountryItem("Monaco", R.drawable.monaco));
        countryList.add(new CountryItem("Mongolia", R.drawable.mongolia));
        countryList.add(new CountryItem("Montenegro", R.drawable.montenegro));
        countryList.add(new CountryItem("Morocco", R.drawable.morocco));
        countryList.add(new CountryItem("Mozambique", R.drawable.mozambique));
        countryList.add(new CountryItem("Myanmar", R.drawable.myanmar));
        countryList.add(new CountryItem("Namibia", R.drawable.namibia));
        countryList.add(new CountryItem("Nauru", R.drawable.nauru));
        countryList.add(new CountryItem("nepal", R.drawable.nepal));
        countryList.add(new CountryItem("Netherlands", R.drawable.netherlands));
        countryList.add(new CountryItem("Nw Zealand", R.drawable.new_zealand));
        countryList.add(new CountryItem("Nicaragua", R.drawable.nicaragua));
        countryList.add(new CountryItem("Niger", R.drawable.niger));
        countryList.add(new CountryItem("Nigeria", R.drawable.nigeria));
        countryList.add(new CountryItem("North Korea", R.drawable.north_korea));
        countryList.add(new CountryItem("Norway", R.drawable.norway));
        countryList.add(new CountryItem("Oman", R.drawable.oman));
        countryList.add(new CountryItem("Pakistan", R.drawable.pakistan));
        countryList.add(new CountryItem("Palau", R.drawable.palau));
        countryList.add(new CountryItem("Palestine", R.drawable.palestine));
        countryList.add(new CountryItem("Panama", R.drawable.panama));
        countryList.add(new CountryItem("Papua New Guinea", R.drawable.papua_new_guinea));
        countryList.add(new CountryItem("Paraguay", R.drawable.paraguay));
        countryList.add(new CountryItem("Peru", R.drawable.peru));
        countryList.add(new CountryItem("Philippines", R.drawable.philippines));
        countryList.add(new CountryItem("Poland", R.drawable.poland));
        countryList.add(new CountryItem("Portugal", R.drawable.portugal));
        countryList.add(new CountryItem("Puerto Rico", R.drawable.puerto_rico));
        countryList.add(new CountryItem("Qatar", R.drawable.qatar));
        countryList.add(new CountryItem("Romania", R.drawable.romania));
        countryList.add(new CountryItem("Russia", R.drawable.russia));
        countryList.add(new CountryItem("Rwanda", R.drawable.rwanda));
        countryList.add(new CountryItem("Samoa", R.drawable.samoa));
        countryList.add(new CountryItem("San Marino", R.drawable.san_marino));
        countryList.add(new CountryItem("Sao Tome and Principe", R.drawable.sao_tome_and_principe));
        countryList.add(new CountryItem("Saudi Arabia", R.drawable.saudi_arabia));
        countryList.add(new CountryItem("Scotland", R.drawable.scotland));
        countryList.add(new CountryItem("Senegal", R.drawable.senegal));
        countryList.add(new CountryItem("Serbia", R.drawable.serbia));
        countryList.add(new CountryItem("Seychelles", R.drawable.seychelles));
        countryList.add(new CountryItem("Sierra Leone", R.drawable.sierra_leone));
        countryList.add(new CountryItem("Singapore", R.drawable.singapore));
        countryList.add(new CountryItem("Slovakia", R.drawable.slovakia));
        countryList.add(new CountryItem("Slovenia", R.drawable.slovenia));
        countryList.add(new CountryItem("Solomon Islands", R.drawable.solomon_islands));
        countryList.add(new CountryItem("Somalia", R.drawable.somalia));
        countryList.add(new CountryItem("South Africa", R.drawable.south_africa));
        countryList.add(new CountryItem("South Korea", R.drawable.south_korea));
        countryList.add(new CountryItem("South Sudan", R.drawable.south_sudan));
        countryList.add(new CountryItem("Spain", R.drawable.spain));
        countryList.add(new CountryItem("Sri Lanka", R.drawable.sri_lanka));
        countryList.add(new CountryItem("Sudan", R.drawable.sudan));
        countryList.add(new CountryItem("Suriname", R.drawable.suriname));
        countryList.add(new CountryItem("Swaziland", R.drawable.swaziland));
        countryList.add(new CountryItem("Sweden", R.drawable.sweden));
        countryList.add(new CountryItem("Switzerland", R.drawable.switzerland));
        countryList.add(new CountryItem("Syria", R.drawable.syria));
        countryList.add(new CountryItem("Taiwan", R.drawable.taiwan));
        countryList.add(new CountryItem("Tajikistan", R.drawable.tajikistan));
        countryList.add(new CountryItem("Tanzania", R.drawable.tanzania));
        countryList.add(new CountryItem("Thailand", R.drawable.thailand));
        countryList.add(new CountryItem("Tibet", R.drawable.tibet));
        countryList.add(new CountryItem("Tunisia", R.drawable.tunisia));
        countryList.add(new CountryItem("Turkey", R.drawable.turkey));
        countryList.add(new CountryItem("Turkmenistan", R.drawable.turkmenistan));
        countryList.add(new CountryItem("Uganda", R.drawable.uganda));
        countryList.add(new CountryItem("Ukraine", R.drawable.ukraine));
        countryList.add(new CountryItem("United Arab Emirates", R.drawable.united_arab_emirates));
        countryList.add(new CountryItem("United Kingdom", R.drawable.united_kingdom));
        countryList.add(new CountryItem("Uruguay", R.drawable.uruguay));
        countryList.add(new CountryItem("Uzbekistn", R.drawable.uzbekistn));
        countryList.add(new CountryItem("Vanuatu", R.drawable.vanuatu));
        countryList.add(new CountryItem("Venezuela", R.drawable.venezuela));
        countryList.add(new CountryItem("Vietnam", R.drawable.vietnam));
        countryList.add(new CountryItem("Yemen", R.drawable.yemen));
        countryList.add(new CountryItem("Zambia", R.drawable.zambia));
        countryList.add(new CountryItem("Zimbabwe", R.drawable.zimbabwe));

    }


    @SuppressLint("IntentReset")
    private void sendEmail(String recipient, String subject, String message) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{recipient});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Name : " + name.getText().toString().trim() + "\nCountry : " + clickedCountryName + "\nSubject : " + subject + "\nMessage : " + message);

        try {
            if (subject.isEmpty() || message.isEmpty()) {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                startActivity(Intent.createChooser(emailIntent, "Choose an Email Client"));
            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }
}