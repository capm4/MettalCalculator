package ua.com.alexkrug.mettalcalculator.src.controller;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.com.alexkrug.mettalcalculator.src.controller.abstractClassForControler.AbstractController;
import ua.com.alexkrug.mettalcalculator.src.dao.SteelCircleDAO;
import ua.com.alexkrug.mettalcalculator.src.model.SteelCircle;


public class SteelCircleController extends AbstractController<SteelCircle> {
    private final String TAG_OF_CONTROLLER = "SteelCircleController";

    @Override
    public ArrayList<Map<String, Object>> getCatalogListForAdapter(Context context, long position) {
        SteelCircleDAO getList = new SteelCircleDAO(context);
        List<SteelCircle> catalogList = getList.getAll();
        Log.d(TAG_OF_CONTROLLER, "getCatalogListForAdapter, Size of getAll = " + catalogList.size());
        ArrayList<Map<String, Object>> dataList = arrayListhandler(catalogList);
        return dataList;
    }

    @Override
    protected ArrayList<Map<String, Object>> arrayListhandler(List catalogList) {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < catalogList.size(); i++ ) {
            Map<String, Object> itemForData = new HashMap<String, Object>();
            SteelCircle itemFromList = (SteelCircle) catalogList.get(i);
            itemForData.put("weight", itemFromList.getWeight());
            itemForData.put("radius", itemFromList.getRadius());
            itemForData.put("metersInTone", itemFromList.getMetersInTone());
            itemForData.put("nameForCatalog",itemFromList.getRadius());
            Log.d(TAG_OF_CONTROLLER, "ArrayListhandler, Put to SteelCircle "+"weight: "+itemFromList.getWeight()
                    +"; radius: "+itemFromList.getRadius()
                    +": metersInTone: "+itemFromList.getMetersInTone()
                    +": nameForCatalog: "+itemFromList.getRadius());
            arrayList.add(itemForData);
        }
        return arrayList;
    }

    @Override
    public SteelCircle getById(Context context, int position) {
        SteelCircleDAO dao = new SteelCircleDAO(context);
        SteelCircle steelCircle = dao.select(position);
        return steelCircle;
    }
}
