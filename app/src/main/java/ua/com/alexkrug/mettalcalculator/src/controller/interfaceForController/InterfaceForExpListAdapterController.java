package ua.com.alexkrug.mettalcalculator.src.controller.interfaceForController;

import android.content.Context;

import java.util.ArrayList;
import java.util.Map;



public interface InterfaceForExpListAdapterController {
    ArrayList<ArrayList<Map<String, String>>> getChildData(Context context);
    ArrayList<Map<String, String>> getGroupData(Context context);
}
