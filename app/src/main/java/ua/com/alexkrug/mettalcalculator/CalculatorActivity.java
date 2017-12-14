package ua.com.alexkrug.mettalcalculator;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Map;

import ua.com.alexkrug.mettalcalculator.src.languageHelper.LocaleHelper;
import ua.com.alexkrug.mettalcalculator.src.adapter.ClickListenerCalculator;
import ua.com.alexkrug.mettalcalculator.src.adapter.ViewHandler;

public class CalculatorActivity extends AppCompatActivity {
    final Context context = this;
    ListView calculatorList;
    Button calResult;
    Map<String, TextView> mapOfTextView;
    Map<String, EditText> mapOfEditText;
    ViewHandler viewHandler = new ViewHandler();
    LinearLayout.LayoutParams layoutParamsBtn;
    ClickListenerCalculator clickListenerCalculator = new ClickListenerCalculator();
    ImageView imageOfSteel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        String language = LocaleHelper.getLanguage(context);
        int list;
        if(language.equals("en")){
            list = R.array.calculator_list_en;
        }else {
            list = R.array.calculator_list_ru;
        }

        calResult = (Button) findViewById(R.id.btnResultCalc);
        calResult.setText(R.string.btnResultCalc);
        layoutParamsBtn = (LinearLayout.LayoutParams) calResult.getLayoutParams();
        calculatorList = (ListView) findViewById(R.id.calculatorList);
        imageOfSteel = (ImageView) findViewById(R.id.imageCalculator);
        mapOfTextView = viewHandler.getMapOfTextViewForCalculator((TextView)findViewById(R.id.viewCalcF),
                (TextView)findViewById(R.id.calcViewS),
                (TextView)findViewById(R.id.calcViewT),
                (TextView)findViewById(R.id.calcResTex),
                (TextView)findViewById(R.id.calcResEdit));

        mapOfEditText = viewHandler.getMapOfEditTextForCalculator((EditText) findViewById(R.id.calcEditF),
                (EditText) findViewById(R.id.calcEditS),
                (EditText) findViewById(R.id.calcEdirT));

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, list, android.R.layout.simple_list_item_1);

        calculatorList.setAdapter(adapter);
        calculatorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                clickListenerCalculator.onItemClickListener(mapOfTextView, mapOfEditText, imageOfSteel,position,
                        calResult,layoutParamsBtn, context);
            }
        });

    }

}
