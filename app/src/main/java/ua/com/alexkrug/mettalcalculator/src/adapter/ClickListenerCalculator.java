package ua.com.alexkrug.mettalcalculator.src.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import ua.com.alexkrug.mettalcalculator.R;



public class ClickListenerCalculator {

    public void onItemClickListener(Map<String,TextView> mapOfTextView, Map<String, EditText> mapOfEditText,
                                    ImageView imageView, int position, Button buttonResult,
                                    LinearLayout.LayoutParams btnParam, Context context){
        final TextView firthRow = mapOfTextView.get("First");
        final TextView secondRow = mapOfTextView.get("Second");
        ViewGroup.LayoutParams secondRowLP = secondRow.getLayoutParams();
        final TextView thirdRow = mapOfTextView.get("Third");
        ViewGroup.LayoutParams thirdRowLP = thirdRow.getLayoutParams();
        TextView texResultRow = mapOfTextView.get("Fifth");
        final TextView result = mapOfTextView.get("Sixth");
        final EditText firstEditText = mapOfEditText.get("FirstEditText");
        final EditText secondEditText = mapOfEditText.get("SecondEditText");
        ViewGroup.LayoutParams secondEditLP = secondEditText.getLayoutParams();
        final EditText thirdEditText = mapOfEditText.get("ThirdEditText");
        ViewGroup.LayoutParams thirdEditLP = thirdEditText.getLayoutParams();
        switch (position){
            case 0: {
                cleanTextView(firthRow, secondRow, thirdRow, texResultRow, result, firstEditText,
                        secondEditText, thirdEditText,secondRowLP,thirdRowLP, secondEditLP, thirdEditLP,btnParam);

                calculatorForSteelCircle(firthRow, texResultRow, imageView, firstEditText, context);

                buttonResult.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String weight = getWeightOfCircle(firstEditText.getText().toString());
                        result.setText(weight.toString());
                    }
                });
                break;
            }
            case 1:{
                cleanTextView(firthRow, secondRow,thirdRow,texResultRow ,result,firstEditText,
                        secondEditText ,thirdEditText,secondRowLP,thirdRowLP, secondEditLP, thirdEditLP,btnParam);

                calculatorForSteelRole(firthRow, secondRow,thirdRow ,texResultRow, imageView,firstEditText,
                        secondEditText,thirdEditText,secondRowLP,thirdRowLP, secondEditLP, thirdEditLP, context);
                buttonResult.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String weight = getWeightOfSteelRole(firstEditText.getText().toString(),
                                        secondEditText.getText().toString(), thirdEditText.getText().toString());
                        result.setText(weight.toString());
                    }
                });
                break;
            }
            case 2:{
                cleanTextView(firthRow, secondRow,thirdRow,texResultRow ,result,firstEditText,
                        secondEditText ,thirdEditText,secondRowLP,thirdRowLP, secondEditLP, thirdEditLP,btnParam);
                calculatorForProfileTube(firthRow, secondRow,thirdRow ,texResultRow, imageView,firstEditText,
                        secondEditText,thirdEditText,secondRowLP,thirdRowLP, secondEditLP, thirdEditLP, context,1);
                buttonResult.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String weight = getWeightOfSquareTube(firstEditText.getText().toString(),
                                        secondEditText.getText().toString());
                        result.setText(weight.toString());
                    }
                });
                break;
            }
            case 3:{
                cleanTextView(firthRow, secondRow,thirdRow,texResultRow ,result,firstEditText,
                        secondEditText ,thirdEditText,secondRowLP,thirdRowLP, secondEditLP, thirdEditLP,btnParam);

                calculatorForProfileTube(firthRow, secondRow,thirdRow ,texResultRow, imageView,firstEditText,
                        secondEditText,thirdEditText,secondRowLP,thirdRowLP, secondEditLP, thirdEditLP, context,2);

                buttonResult.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String weight = getWeightOfReTube(firstEditText.getText().toString(),
                                secondEditText.getText().toString(),
                                thirdEditText.getText().toString());
                        result.setText(weight.toString());
                    }
                });
                break;
            }
            case 4:{
                cleanTextView(firthRow, secondRow,thirdRow,texResultRow ,result,firstEditText,
                        secondEditText ,thirdEditText,secondRowLP,thirdRowLP, secondEditLP, thirdEditLP,btnParam);

                calculatorForRoundTube(firthRow, secondRow,texResultRow, imageView,firstEditText,
                        secondEditText,secondRowLP, secondEditLP, context);

                buttonResult.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String weight = getWeightOfRoundTube(firstEditText.getText().toString(),
                                                                secondEditText.getText().toString());
                        result.setText(weight.toString());
                    }
                });
                break;
            }
            case 5:{
                cleanTextView(firthRow, secondRow,thirdRow,texResultRow ,result,firstEditText,
                        secondEditText ,thirdEditText,secondRowLP,thirdRowLP, secondEditLP, thirdEditLP,btnParam);

                calculatorForSquareBars(firthRow, texResultRow, imageView, firstEditText, context,1);

                buttonResult.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String weight = getWeightOfSquareBars(firstEditText.getText().toString());
                        result.setText(weight.toString());
                    }
                });
                break;
            }
            case 6:{
                cleanTextView(firthRow, secondRow,thirdRow,texResultRow ,result,firstEditText,
                        secondEditText ,thirdEditText,secondRowLP,thirdRowLP, secondEditLP, thirdEditLP,btnParam);

                calculatorForSteelStrip(firthRow, secondRow,texResultRow, imageView,firstEditText,
                        secondEditText,secondRowLP, secondEditLP, context);

                buttonResult.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String weight = getWeightOfSteelStrip(firstEditText.getText().toString(),
                                secondEditText.getText().toString());
                        result.setText(weight.toString());
                    }
                });
                break;
            }
            case 7:{
                cleanTextView(firthRow, secondRow,thirdRow,texResultRow ,result,firstEditText,
                        secondEditText ,thirdEditText,secondRowLP,thirdRowLP, secondEditLP, thirdEditLP,btnParam);

                calculatorForSquareBars(firthRow, texResultRow, imageView, firstEditText, context,2);

                buttonResult.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String weight = getWeightOfHexahedron(firstEditText.getText().toString());
                        result.setText(weight.toString());
                    }
                });
                break;
            }
        }
    }



    private void calculatorForSteelStrip(TextView firthRow, TextView secondRow,  TextView texResultRow,
                                         ImageView imageView, EditText firstEditText, EditText secondEditText,
                                         ViewGroup.LayoutParams secondRowLP,
                                          ViewGroup.LayoutParams secondEditLP, Context context) {
        firstEditText.setVisibility(View.VISIBLE);
        secondEditText.setVisibility(View.VISIBLE);
        secondRowLP.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        secondEditLP.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        firthRow.setText(context.getString(R.string.Thickness)+"(S) mm: ");
        secondRow.setText(context.getString(R.string.Height)+"(a) mm: ");
        texResultRow.setText(context.getString(R.string.WeightOfSteelStripCalculator)+": ");
        imageView.setImageResource(R.drawable.steelstrip);
    }


    private void calculatorForSquareBars(TextView firthRow, TextView textResultRow, ImageView imageView, EditText firstEditText,
                                         Context context, int i) {
        firstEditText.setVisibility(View.VISIBLE);
        firthRow.setText(context.getString(R.string.Width)+"(a) mm: ");
        if(i == 1) {
            textResultRow.setText(context.getString(R.string.WeightOfSquareBarsCalculator)+": ");
            imageView.setImageResource(R.drawable.sqeabar);
        }else if(i == 2){
            textResultRow.setText(context.getString(R.string.WeightOfHexahedronCalculator)+": ");
            imageView.setImageResource(R.drawable.hexahedron);
        }
    }


    private void calculatorForRoundTube(TextView firthRow, TextView secondRow, TextView texResultRow, ImageView imageView,
                                        EditText firstEditText, EditText secondEditText, ViewGroup.LayoutParams secondRowLP,
                                        ViewGroup.LayoutParams secondEditLP, Context context) {
        firstEditText.setVisibility(View.VISIBLE);
        secondEditText.setVisibility(View.VISIBLE);
        secondRowLP.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        secondEditLP.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        firthRow.setText(context.getString(R.string.Thickness)+"(S) mm: ");
        secondRow.setText(context.getString(R.string.Diameter)+"(a) mm: ");
        texResultRow.setText(context.getString(R.string.WeightOfTubeCalculator)+": ");
        imageView.setImageResource(R.drawable.roundtube);
    }


    private void calculatorForProfileTube(TextView firthRow, TextView secondRow, TextView thirdRow, TextView texResultRow,
                                         ImageView imageView, EditText firstEditText, EditText secondEditText,
                                         EditText thirdEditText, ViewGroup.LayoutParams secondRowLP,
                                         ViewGroup.LayoutParams thirdRowLP, ViewGroup.LayoutParams secondEditLP,
                                         ViewGroup.LayoutParams thirdEditLP, Context context, int tupeType) {
        firstEditText.setVisibility(View.VISIBLE);
        secondEditText.setVisibility(View.VISIBLE);
        thirdEditText.setVisibility(View.VISIBLE);
        secondRowLP.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        secondEditLP.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        thirdEditLP.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        thirdRowLP.height= ViewGroup.LayoutParams.WRAP_CONTENT;
        firthRow.setText(context.getString(R.string.Thickness)+"(S) mm: ");
        secondRow.setText(context.getString(R.string.Width)+"(b) mm: ");
        thirdRow.setText(context.getString(R.string.Height)+"(h) mm: ");
        texResultRow.setText(context.getString(R.string.WeightOfTubeCalculator)+": ");
        if(tupeType == 1){
            imageView.setImageResource(R.drawable.squaretube);
        }else if(tupeType == 2){
            imageView.setImageResource(R.drawable.retube);
        }

    }

    private void calculatorForSteelCircle(TextView firthRow, TextView texResultRow, ImageView imageView,EditText firstEditText, Context context) {
        firstEditText.setVisibility(View.VISIBLE);
        firthRow.setText(context.getString(R.string.Diameter)+"(d) mm: ");
        texResultRow.setText(context.getString(R.string.WeightOfCircleCalculator)+": ");
        imageView.setImageResource(R.drawable.circle);
    }

    private void calculatorForSteelRole(TextView first, TextView second, TextView third,
                                        TextView texResultRow,ImageView imageView,
                                        EditText firstEditText,EditText secondEditText, EditText thirdEditText,
                                        ViewGroup.LayoutParams secondRowLP, ViewGroup.LayoutParams thirdRowLP,
                                        ViewGroup.LayoutParams secondEditLP, ViewGroup.LayoutParams thirdEditLP,
                                        Context context) {
        firstEditText.setVisibility(View.VISIBLE);
        secondEditText.setVisibility(View.VISIBLE);
        secondRowLP.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        thirdEditText.setVisibility(View.VISIBLE);
        thirdRowLP.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        secondEditLP.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        thirdEditLP.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        first.setText(context.getString(R.string.Thickness)+"(S) mm: ");
        second.setText(context.getString(R.string.Width)+"(b) mm: ");
        third.setText(context.getString(R.string.Height)+"(h) mm: ");
        texResultRow.setText(context.getString(R.string.WeightOfListCalculator)+": ");
        imageView.setImageResource(R.drawable.list);
    }

    private void cleanTextView(TextView fist, TextView second, TextView third, TextView fifth, TextView sixth,
                               EditText firstEditText, EditText secondEditText, EditText thirdEditText,
                               ViewGroup.LayoutParams secondRowLP, ViewGroup.LayoutParams thirdRowLP,
                               ViewGroup.LayoutParams secondEditLP, ViewGroup.LayoutParams thirdEditLP,
                               LinearLayout.LayoutParams btnParam) {
        btnParam.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        fist.setText(null);
        second.setText(null);
        secondRowLP.height = 0;
        third.setText(null);
        thirdRowLP.height = 0;
        fifth.setText(null);
        sixth.setText(null);
        firstEditText.setText(null);
        firstEditText.setVisibility(View.INVISIBLE);
        secondEditLP.height = 0;
        secondEditText.setText(null);
        secondEditText.setVisibility(View.INVISIBLE);
        thirdEditText.setText(null);
        thirdEditText.setVisibility(View.INVISIBLE);
        thirdEditLP.height = 0;
    }

    private String getWeightOfSteelRole(String thickness, String width, String heigth){
        String result;
        Double t =Double.parseDouble(thickness);
        Double w = Double.parseDouble(width);
        Double h = Double.parseDouble(heigth);
        Double r = t * w * h*0.007850;
        Double roundResult = new BigDecimal(r).setScale(4, RoundingMode.HALF_UP).doubleValue();
        result  = roundResult.toString();
        return result;
    }
    private String getWeightOfCircle(String diametr) {
        String result;
        Double d = Double.parseDouble(diametr);
        Double sqearDiametr = Math.pow(d,2.0);
        Double r = 0.0061654*sqearDiametr;
        Double roundResult = new BigDecimal(r).setScale(4, RoundingMode.HALF_UP).doubleValue();
        result  = roundResult.toString();
        return result;
    }
    private String getWeightOfSquareTube(String thickness, String width) {
        String result;
        Double t =Double.parseDouble(thickness);
        Double w = Double.parseDouble(width);
        Double r = t*(0.0314*w - 0.044877*t);
        Double roundResult = new BigDecimal(r).setScale(2, RoundingMode.HALF_UP).doubleValue();
        result  = roundResult.toString();
        return result;
    }
    private String getWeightOfReTube(String thickness, String width, String heigth) {
        String result;
        Double t =Double.parseDouble(thickness);
        Double w = Double.parseDouble(width);
        Double h = Double.parseDouble(heigth);
        Double r = t*(0.0157*(w+h)-0.04487*t);
        Double roundResult = new BigDecimal(r).setScale(2, RoundingMode.HALF_UP).doubleValue();
        result  = roundResult.toString();
        return result;
    }

    private String getWeightOfRoundTube(String thickness, String diametr) {
        String result;
        Double t = Double.parseDouble(thickness);
        Double d = Double.parseDouble(diametr);
        Double r = 0.0246615*t*(d-t);
        Double roundResult = new BigDecimal(r).setScale(2, RoundingMode.HALF_UP).doubleValue();
        result  = roundResult.toString();
        return result;
    }
    private String getWeightOfSquareBars(String width) {
        String result;
        Double w = Double.parseDouble(width);
        Double sqearWidth = Math.pow(w,2.0);
        Double r = 0.007850*sqearWidth;
        Double roundResult = new BigDecimal(r).setScale(2, RoundingMode.HALF_UP).doubleValue();
        result  = roundResult.toString();
        return result;
    }
    private String getWeightOfSteelStrip(String thickness, String width) {
        String result;
        Double t = Double.parseDouble(thickness);
        Double w = Double.parseDouble(width);
        Double r = 0.007850*t*w;
        Double roundResult = new BigDecimal(r).setScale(2, RoundingMode.HALF_UP).doubleValue();
        result  = roundResult.toString();
        return result;
    }
    private String getWeightOfHexahedron(String width) {
        String result;
        Double w = Double.parseDouble(width);
        Double sqearWidth = Math.pow(w,2.0);
        Double r = 0.0067983*sqearWidth;
        Double roundResult = new BigDecimal(r).setScale(2, RoundingMode.HALF_UP).doubleValue();
        result  = roundResult.toString();
        return result;
    }
}
