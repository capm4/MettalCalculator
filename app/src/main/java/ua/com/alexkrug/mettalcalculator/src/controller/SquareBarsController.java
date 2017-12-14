package ua.com.alexkrug.mettalcalculator.src.controller;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.com.alexkrug.mettalcalculator.src.controller.abstractClassForControler.AbstractController;
import ua.com.alexkrug.mettalcalculator.src.dao.SquareBarsDAO;
import ua.com.alexkrug.mettalcalculator.src.model.SquareBars;


public class SquareBarsController extends AbstractController<SquareBars> {
    private final String TAG_OF_CONTROLLER = "SquareBarsController";

    @Override
    public ArrayList<Map<String, Object>> getCatalogListForAdapter(Context context, long position) {
        SquareBarsDAO getList = new SquareBarsDAO(context);
        List<SquareBars> catalogList = getList.getAll();
        Log.d(TAG_OF_CONTROLLER, "getCatalogListForAdapter, Size of getAll = " + catalogList.size());
        ArrayList<Map<String, Object>> dataList = arrayListhandler(catalogList);
        return dataList;
    }

    @Override
    protected ArrayList<Map<String, Object>> arrayListhandler(List catalogList) {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < catalogList.size(); i++ ) {
            Map<String, Object> itemForData = new HashMap<String, Object>();
            SquareBars itemFromList = (SquareBars) catalogList.get(i);
            itemForData.put("weight", itemFromList.getWeight());
            itemForData.put("width", itemFromList.getWidth());
            itemForData.put("metersInTone", itemFromList.getMetersInTone());
            itemForData.put("nameForCatalog",itemFromList.getWidth()+"x"+itemFromList.getWidth());
            Log.d(TAG_OF_CONTROLLER, "ArrayListhandler, Put to SquareBars "+"weight: "+itemFromList.getWeight()
                    +"; width: "+itemFromList.getWidth()
                    +": metersInTone: "+itemFromList.getMetersInTone()
                    +": nameForCatalog: "+itemFromList.getWidth()
                    +" x "+itemFromList.getWidth());
            arrayList.add(itemForData);
        }
        return arrayList;
    }

    @Override
    public SquareBars getById(Context context, int position) {
        SquareBarsDAO dao = new SquareBarsDAO(context);
        SquareBars squareBars = dao.select(position);
        return squareBars;
    }
}
