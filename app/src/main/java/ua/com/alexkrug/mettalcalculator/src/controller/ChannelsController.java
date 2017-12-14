package ua.com.alexkrug.mettalcalculator.src.controller;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.com.alexkrug.mettalcalculator.src.controller.abstractClassForControler.AbstractController;
import ua.com.alexkrug.mettalcalculator.src.dao.ChannelsDAO;
import ua.com.alexkrug.mettalcalculator.src.model.Channels;



public class ChannelsController extends AbstractController<Channels> {
    private final String TAG_OF_CONTROLLER = "ChannelsController";

    @Override
    public ArrayList<Map<String, Object>> getCatalogListForAdapter(Context context, long position) {
        ChannelsDAO getList = new ChannelsDAO(context);
        List<Channels> catalogList = getList.getAll();
        Log.d(TAG_OF_CONTROLLER, "getCatalogListForAdapter, Size of getAll = " + catalogList.size());
        ArrayList<Map<String, Object>> dataList = arrayListhandler(catalogList);
        return dataList;
    }

    @Override
    protected ArrayList<Map<String, Object>> arrayListhandler(List catalogList) {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        for (int i = 0; i < catalogList.size(); i++ ) {
            Map<String, Object> itemForData = new HashMap<>();
            Channels itemFromList = (Channels) catalogList.get(i);
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
            Log.d(TAG_OF_CONTROLLER, "ArrayListhandler, Put to Channels "+" number: "+itemFromList.getNumber()
                    +"; weigth: "+itemFromList.getWeightOfMeter()
                    +"; width: "+itemFromList.getWidth()+": height: "+itemFromList.getHeight()
                    +"; thickness: "+itemFromList.getThickness()
                    +"; innerRadius: "+itemFromList.getInnerRadius()+"; shelfRoundingRadius: "
                    +itemFromList.getShelfRoundingRadius()
                    +"; metersInTone: "+itemFromList.getMetersInTone()+"; shelfAverageThickness: "
                    +itemFromList.getShelfAverageThickness()
                    +": nameForCatalog: "+itemFromList.getNumber());
            arrayList.add(itemForData);
        }
        Log.d(TAG_OF_CONTROLLER, "Size of arrayListhandler = " + arrayList.size());
        return arrayList;
    }

    @Override
    public Channels getById(Context context, int position) {
        ChannelsDAO dao = new ChannelsDAO(context);
        Channels channels = dao.select(position);
        return channels;
    }
}
