package ua.com.alexkrug.mettalcalculator.src.adapter;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ua.com.alexkrug.mettalcalculator.R;
import ua.com.alexkrug.mettalcalculator.src.languageHelper.LocaleHelper;



public class MainActivityAdapter {
    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_IMAGE = "image";
    Context mContext;
    String languageTitle = new String();
    public MainActivityAdapter(Context context) {
        mContext = context;
    }

    public ArrayList<Map<String, Object>> getData() {
        String language = LocaleHelper.getLanguage(mContext);
        String[] list = null;
        if(language.equals("en")){
            list = new String[]{"English", "Russion"};
        }else if (language.equals("ru")) {
            list = new String[]{"Английский", "Русcкый"};
        }
        ArrayList<Map<String, Object>> data = new ArrayList<>(
                list.length);
        Map<String, Object> m;
        for (int i = 0; i < list.length; i++) {
            m = new HashMap<>();
            if (i == 0) {
                m.put(ATTRIBUTE_NAME_TEXT, list[i]);
                m.put(ATTRIBUTE_NAME_IMAGE, R.drawable.eng);
            } else {
                m.put(ATTRIBUTE_NAME_TEXT, list[i]);
                m.put(ATTRIBUTE_NAME_IMAGE, R.drawable.ru);
            }
            data.add(m);
        }
        return data;
    }

    public String[] getFrom(){
        String[] from = { ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_IMAGE };
        return from;
    }
    public int[] getTo(){
        int[] to={R.id.textLengList, R.id.imageLengList,};
        return to;
    }
    public String getTitle(){
        String language = LocaleHelper.getLanguage(mContext);
        if(language.equals("en")){
            languageTitle = "Choose lenguage: ";
        }else if (language.equals("ru")) {
            languageTitle = "Выбрать Язык: ";
        }
        return languageTitle;
    }
}
