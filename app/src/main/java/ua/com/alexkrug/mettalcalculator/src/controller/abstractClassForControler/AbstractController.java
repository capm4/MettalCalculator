package ua.com.alexkrug.mettalcalculator.src.controller.abstractClassForControler;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public abstract class AbstractController<T> {

    public ArrayList<Map<String, Object>> getCatalogListForAdapter(Context context, long position) {
        return null;
    }

    protected ArrayList<Map<String, Object>> arrayListhandler(List catalogList) {
        return null;
    }

    public abstract T getById(Context context, int position);
}
