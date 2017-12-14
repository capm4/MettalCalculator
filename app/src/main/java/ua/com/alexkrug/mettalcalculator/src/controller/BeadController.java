package ua.com.alexkrug.mettalcalculator.src.controller;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.com.alexkrug.mettalcalculator.src.controller.abstractClassForControler.AbstractController;
import ua.com.alexkrug.mettalcalculator.src.dao.BeadDAO;
import ua.com.alexkrug.mettalcalculator.src.model.Bead;


public class BeadController extends AbstractController<Bead> {
    private final String TAG_OF_CONTROLLER = "BeadController";

    @Override
    public ArrayList<Map<String, Object>> getCatalogListForAdapter(Context context, long position) {
        BeadDAO getList = new BeadDAO(context);
        List<Bead> catalogList = getList.getAll();
        Log.d(TAG_OF_CONTROLLER, "getCatalogListForAdapter, Size of getAll = " + catalogList.size());
        ArrayList<Map<String, Object>> dataList = arrayListhandler(catalogList);
        return dataList;
    }

    @Override
    protected ArrayList<Map<String, Object>> arrayListhandler(List catalogList) {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        for (int i = 0; i < catalogList.size(); i++ ) {
            Map<String, Object> itemForData = new HashMap<>();
            Bead itemFromList = (Bead) catalogList.get(i);
            itemForData.put("weight", itemFromList.getWeightOfMeter());
            itemForData.put("width", itemFromList.getWidth());
            itemForData.put("thickness", itemFromList.getThickness());
            itemForData.put("innerRadius", itemFromList.getInnerRadius());
            itemForData.put("shelfRoundingRadius", itemFromList.getShelfRoundingRadius());
            itemForData.put("metersInTone", itemFromList.getMetersInTone());
            itemForData.put("height", itemFromList.getHeight());
            itemForData.put("shelfAverageThickness", itemFromList.getShelfAverageThickness());
            itemForData.put("number", itemFromList.getNumber());
            itemForData.put("nameForCatalog", itemFromList.getNumber());
            Log.d(TAG_OF_CONTROLLER, "ArrayListhandler, Put to Bead "+" number: "+itemFromList.getNumber()
                    +"; weight: "+itemFromList.getWeightOfMeter()
                    +"; width: "+itemFromList.getWidth()+": height: "
                    +itemFromList.getHeight()+"; thickness: "+itemFromList.getThickness()
                    +"; innerRadius: "+itemFromList.getInnerRadius()+"; shelfRoundingRadius: "
                    +itemFromList.getShelfRoundingRadius()
                    +"; metersInTone: "+itemFromList.getMetersInTone()+"; " +
                    "shelfAverageThickness: "+itemFromList.getShelfAverageThickness()
                    +": nameForCatalog: "+itemFromList.getNumber());
            arrayList.add(itemForData);
        }
        Log.d(TAG_OF_CONTROLLER, "Size of arrayListhandler = " + arrayList.size());
        return arrayList;
    }

    @Override
    public Bead getById(Context context, int position) {
        BeadDAO dao = new BeadDAO(context);
        Bead bead = dao.select(position);
        return bead;
    }
}
