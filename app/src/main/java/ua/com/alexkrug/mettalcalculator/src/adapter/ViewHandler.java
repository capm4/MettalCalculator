package ua.com.alexkrug.mettalcalculator.src.adapter;

import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;



public class ViewHandler {

    public Map<String, TextView> getMapOfTextViewForCatalog(TextView elemFirst, TextView elemSecond, TextView elemThird,
                                                            TextView elemFourth, TextView elemFifth,
                                                            TextView elemSixth, TextView elemSeventh, TextView elemEighth){
        Map<String, TextView> returnMap = new HashMap<>();
        returnMap.put("First", elemFirst);
        returnMap.put("Second", elemSecond);
        returnMap.put("Third", elemThird);
        returnMap.put("Fourth", elemFourth);
        returnMap.put("Fifth", elemFifth);
        returnMap.put("Sixth", elemSixth);
        returnMap.put("Seventh", elemSeventh);
        returnMap.put("Eighth", elemEighth);
        return returnMap;
    }

    public Map<String, TextView> getMapOfTextViewForCalculator(TextView elemFirst, TextView elemSecond, TextView elemThird,
                                                               TextView elemFifth,TextView elemSixth){
        Map<String, TextView> returnMap = new HashMap<>();
        returnMap.put("First", elemFirst);
        returnMap.put("Second", elemSecond);
        returnMap.put("Third", elemThird);
        returnMap.put("Fifth", elemFifth);
        returnMap.put("Sixth", elemSixth);
        return returnMap;
    }

    public Map<String, EditText> getMapOfEditTextForCalculator(EditText elemFirst, EditText elemSecond, EditText elemThird
                                                               ){
        Map<String, EditText> returnMap = new HashMap<>();
        returnMap.put("FirstEditText", elemFirst);
        returnMap.put("SecondEditText", elemSecond);
        returnMap.put("ThirdEditText", elemThird);
        return returnMap;
    }
}
