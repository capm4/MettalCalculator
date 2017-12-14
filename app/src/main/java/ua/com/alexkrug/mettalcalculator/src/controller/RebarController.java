package ua.com.alexkrug.mettalcalculator.src.controller;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.com.alexkrug.mettalcalculator.src.controller.abstractClassForControler.AbstractController;
import ua.com.alexkrug.mettalcalculator.src.dao.RebarDAO;
import ua.com.alexkrug.mettalcalculator.src.model.Rebar;


public class RebarController extends AbstractController<Rebar> {
    private final String TAG_OF_CONTROLLER = "RebarController";

    @Override
    public ArrayList<Map<String, Object>> getCatalogListForAdapter(Context context, long position) {
        RebarDAO getList = new RebarDAO(context);
        List<Rebar> catalogList = getList.getAll();
        Log.d(TAG_OF_CONTROLLER, "getCatalogListForAdapter, Size of getAll = " + catalogList.size());
        ArrayList<Map<String, Object>> dataList = arrayListhandler(catalogList);
        return dataList;
    }

    @Override
    protected ArrayList<Map<String, Object>> arrayListhandler(List catalogList) {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        for (int i = 0; i < catalogList.size(); i++ ) {
            Map<String, Object> itemForData = new HashMap<>();
            Rebar itemFromList = (Rebar) catalogList.get(i);
            itemForData.put("weight", itemFromList.getWeight());
            itemForData.put("radius", itemFromList.getRadius());
            itemForData.put("metersInTone", itemFromList.getMetersInTone());
            itemForData.put("nameForCatalog", itemFromList.getRadius());
            Log.d(TAG_OF_CONTROLLER, "ArrayListhandler, Put to Rebar "+"weight: "+itemFromList.getWeight()
                    +"; radius: "+itemFromList.getRadius()+"; metersInTone: "+itemFromList.getMetersInTone()
                    +": metersInTone: "+itemFromList.getMetersInTone()
                    +": nameForCatalog: "+itemFromList.getRadius());
            arrayList.add(itemForData);
        }
        return arrayList;
    }

    public Rebar getById(Context context, int id){
        RebarDAO dao = new RebarDAO(context);
        Rebar rebar = dao.select(id);
        return rebar;
    }
}
