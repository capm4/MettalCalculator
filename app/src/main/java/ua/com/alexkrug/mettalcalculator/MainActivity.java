package ua.com.alexkrug.mettalcalculator;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import ua.com.alexkrug.mettalcalculator.src.languageHelper.LocaleHelper;
import ua.com.alexkrug.mettalcalculator.src.adapter.MainActivityAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnCatalog;
    Button btnCalculator;
    Context context = this;
    MainActivityAdapter mActAdapter = new MainActivityAdapter(context);
    Resources resources;
    TextView spinnerTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);



        SimpleAdapter adapter = new SimpleAdapter(this, mActAdapter.getData(),R.layout.language_list,mActAdapter.getFrom(),mActAdapter.getTo());
        spinner.setAdapter(adapter);
        btnCalculator = (Button) findViewById(R.id.btnCalculator);
        btnCatalog = (Button) findViewById(R.id.btnCatalog);
        btnCalculator.setOnClickListener(this);
        btnCatalog.setOnClickListener(this);
        spinnerTitle = (TextView) findViewById(R.id.spinnerTitle);
        spinner.setPrompt(mActAdapter.getTitle());
        spinnerTitle.setText(mActAdapter.getTitle());
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        context = LocaleHelper.setLocale(MainActivity.this, "en");
                        resources = context.getResources();
                        btnCatalog.setText(R.string.btnCatalog);
                        btnCalculator.setText(R.string.btnCalculator);
                        spinner.setPrompt(resources.getString(R.string.languageTitle));
                        spinnerTitle.setText(resources.getString(R.string.languageTitle));
                        break;
                    case 1:
                        context = LocaleHelper.setLocale(MainActivity.this, "ru");
                        resources = context.getResources();
                        btnCatalog.setText(R.string.btnCatalog);
                        btnCalculator.setText(R.string.btnCalculator);
                        spinner.setPrompt(resources.getString(R.string.languageTitle));
                        spinnerTitle.setText(resources.getString(R.string.languageTitle));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        int v = view.getId();
        switch (v) {
            case R.id.btnCatalog:
                Intent intentCatalog = new Intent(this, CatalogActivity.class);
                startActivityForResult(intentCatalog, 1);
                break;
            case R.id.btnCalculator:
                Intent intentCalculator = new Intent(this, CalculatorActivity.class);
                startActivityForResult(intentCalculator, 1);
                break;
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase));
    }

}
