package ua.com.alexkrug.mettalcalculator.src.controller;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.com.alexkrug.mettalcalculator.src.controller.abstractClassForControler.AbstractController;
import ua.com.alexkrug.mettalcalculator.src.dao.HexahedronDAO;
import ua.com.alexkrug.mettalcalculator.src.model.Hexahedron;


public class HexahedronController extends AbstractController<Hexahedron>{
    private final String TAG_OF_CONTROLLER = "HexahedronController";

    @Override
    public ArrayList<Map<String, Object>> getCatalogListForAdapter(Context context, long position) {
        HexahedronDAO getList = new HexahedronDAO(context);
        List<Hexahedron> catalogList = getList.getAll();
        Log.d(TAG_OF_CONTROLLER, "getCatalogListForAdapter, Size of getAll = " + catalogList.size());
        ArrayList<Map<String, Object>> dataList = arrayListhandler(catalogList);
        return dataList;
    }

    @Override
    protected ArrayList<Map<String, Object>> arrayListhandler(List catalogList) {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        for (int i = 0; i < catalogList.size(); i++ ) {
            Map<String, Object> itemForData = new HashMap<>();
            Hexahedron itemFromList = (Hexahedron) catalogList.get(i);
            itemForData.put("weight", itemFromList.getWeight());
            itemForData.put("width", itemFromList.getWidth());
            itemForData.put("metersInTone", itemFromList.getMetersInTone());
            itemForData.put("nameForCatalog", itemFromList.getWidth());
            Log.d(TAG_OF_CONTROLLER, "ArrayListhandler, Put to Hexahedron "+"; weight: "+itemFromList.getWeight()
                    +"; width: "+itemFromList.getWidth()
                    +"; metersInTone: "+itemFromList.getMetersInTone()
                    +": nameForCatalog: "+itemFromList.getWidth());
            arrayList.add(itemForData);
        }
        Log.d(TAG_OF_CONTROLLER, "Size of arrayListhandler = " + arrayList.size());
        return arrayList;
    }

    @Override
    public Hexahedron getById(Context context, int position) {
        HexahedronDAO dao = new HexahedronDAO(context);
        Hexahedron hexahedron = dao.select(position);
        return hexahedron;
    }
}
