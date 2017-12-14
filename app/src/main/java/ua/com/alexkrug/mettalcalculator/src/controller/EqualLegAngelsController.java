package ua.com.alexkrug.mettalcalculator.src.controller;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.com.alexkrug.mettalcalculator.src.controller.abstractClassForControler.AbstractController;
import ua.com.alexkrug.mettalcalculator.src.dao.EqualLegAngelsDAO;
import ua.com.alexkrug.mettalcalculator.src.model.EqualLegAngels;


public class EqualLegAngelsController extends AbstractController<EqualLegAngels> {
    private final String TAG_OF_CONTROLLER = "EqualLegAngelsController";

    @Override
    public ArrayList<Map<String, Object>> getCatalogListForAdapter(Context context, long position) {
        EqualLegAngelsDAO getList = new EqualLegAngelsDAO(context);
        List<EqualLegAngels> catalogList = getList.getAll();
        Log.d(TAG_OF_CONTROLLER, "getCatalogListForAdapter, Size of getAll = " + catalogList.size());
        ArrayList<Map<String, Object>> dataList = arrayListhandler(catalogList);
        return dataList;
    }

    @Override
    protected ArrayList<Map<String, Object>> arrayListhandler(List catalogList) {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        for (int i = 0; i < catalogList.size(); i++ ) {
            Map<String, Object> itemForData = new HashMap<>();
            EqualLegAngels itemFromList = (EqualLegAngels) catalogList.get(i);
            itemForData.put("weight", itemFromList.getWeight());
            itemForData.put("width", itemFromList.getWidth());
            itemForData.put("thickness", itemFromList.getThickness());
            itemForData.put("innerRadius", itemFromList.getInnerRadius());
            itemForData.put("shelfRoundingRadius", itemFromList.getShelfRoundingRadius());
            itemForData.put("metersInTone", itemFromList.getMetersInTone());
            itemForData.put("nameForCatalog", itemFromList.getWidth()+" x "
                    +itemFromList.getWidth()+" x "+itemFromList.getThickness());
            Log.d(TAG_OF_CONTROLLER, "ArrayListhandler, Put to EqualLegAngels "+"; weight: "
                    +itemFromList.getWeight()+"; width: "+itemFromList.getWidth()+"; thickness: "
                    +itemFromList.getThickness()+"; innerRadius: "+itemFromList.getInnerRadius()
                    +"; shelfRoundingRadius: "+itemFromList.getShelfRoundingRadius()
                    +"; metersInTone: "+itemFromList.getMetersInTone()+"; shelfRoundingRadius: "+itemFromList.getShelfRoundingRadius()
                    +": nameForCatalog: "+itemFromList.getWidth()+" x "+itemFromList.getWidth()+" x "+itemFromList.getThickness());
            arrayList.add(itemForData);
        }
        Log.d(TAG_OF_CONTROLLER, "Size of arrayListhandler = " + arrayList.size());
        return arrayList;
    }

    public EqualLegAngels getById(Context context, int id){
        EqualLegAngelsDAO dao = new EqualLegAngelsDAO(context);
        EqualLegAngels angel = dao.select(id);
        return angel;
    }
}
