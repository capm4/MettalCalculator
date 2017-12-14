package ua.com.alexkrug.mettalcalculator.src.controller;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.com.alexkrug.mettalcalculator.src.controller.abstractClassForControler.AbstractController;
import ua.com.alexkrug.mettalcalculator.src.dao.WireRodDAO;
import ua.com.alexkrug.mettalcalculator.src.model.WireRod;



public class WireRodController extends AbstractController {
    private final String TAG_OF_CONTROLLER = "WireRodController";
    @Override
    public ArrayList<Map<String, Object>> getCatalogListForAdapter(Context context, long position) {
        WireRodDAO getList = new WireRodDAO(context);
        List<WireRod> catalogList = getList.getAll();
        Log.d(TAG_OF_CONTROLLER, "getCatalogListForAdapter, Size of getAll = " + catalogList.size());
        ArrayList<Map<String, Object>> dataList = arrayListhandler(catalogList);
        return dataList;
    }

    @Override
    protected ArrayList<Map<String, Object>> arrayListhandler(List catalogList) {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        for (int i = 0; i < catalogList.size(); i++ ) {
            Map<String, Object> itemForData = new HashMap<>();
            WireRod itemFromList = (WireRod) catalogList.get(i);
            itemForData.put("weight", itemFromList.getWeight());
            itemForData.put("radius", itemFromList.getRadius());
            itemForData.put("metersInTone", itemFromList.getMetersInTone());
            itemForData.put("nameForCatalog", itemFromList.getRadius());
            Log.d(TAG_OF_CONTROLLER, "ArrayListhandler, Put to WireRod "+"weight: "+itemFromList.getWeight()
                    +"; radius: "+itemFromList.getRadius()+"; metersInTone: "+itemFromList.getMetersInTone()
                    +": metersInTone: "+itemFromList.getMetersInTone()
                    +": nameForCatalog: "+itemFromList.getRadius());
            arrayList.add(itemForData);
        }
        return arrayList;
    }

    @Override
    public WireRod getById(Context context, int id) {
        WireRodDAO dao = new WireRodDAO(context);
        WireRod wireRod = dao.select(id);
        return wireRod;
    }
}
