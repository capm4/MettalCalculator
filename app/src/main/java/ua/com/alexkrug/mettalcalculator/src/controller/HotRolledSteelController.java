package ua.com.alexkrug.mettalcalculator.src.controller;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.com.alexkrug.mettalcalculator.src.controller.abstractClassForControler.AbstractController;
import ua.com.alexkrug.mettalcalculator.src.controller.interfaceForController.InterfaceForExpListAdapterController;
import ua.com.alexkrug.mettalcalculator.src.dao.HotRolledSteelDAO;
import ua.com.alexkrug.mettalcalculator.src.model.HotRolledSteel;


public class HotRolledSteelController extends AbstractController<HotRolledSteel> implements InterfaceForExpListAdapterController {
    private final String ATTR_GROUP_NAME= "dimensions";
    private final String ATTR_THICKNESS_NAME= "thicknessName";
    private final String TAG_OF_CONTROLLER = "HotRolledSteelController";

    @Override
    public ArrayList<Map<String, Object>> getCatalogListForAdapter(Context context, long position) {
        HotRolledSteelDAO getList = new HotRolledSteelDAO(context);
        List<HotRolledSteel> catalogList = getList.getAll();
        Log.d(TAG_OF_CONTROLLER, "getCatalogListForAdapter, Size of getAll = " + catalogList.size());
        ArrayList<Map<String, Object>> dataList = arrayListhandler(catalogList);
        return dataList;
    }

    @Override
    protected ArrayList<Map<String, Object>> arrayListhandler(List catalogList) {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        for (int i = 0; i < catalogList.size(); i++ ) {
            Map<String, Object> itemForData = new HashMap<>();
            HotRolledSteel itemFromList = (HotRolledSteel) catalogList.get(i);
            itemForData.put("weight", itemFromList.getWeight());
            itemForData.put("width", itemFromList.getWidth());
            itemForData.put("height", itemFromList.getHeight());
            itemForData.put("thickness", itemFromList.getThickness());
            itemForData.put("nameForCatalog", itemFromList.getThickness()+" x "+itemFromList.getWidth()+" x "
                    + itemFromList.getHeight());
            Log.d(TAG_OF_CONTROLLER, "ArrayListhandler, Put to HotRolledSteel "+"weigh: "+itemFromList.getWeight()
                    +"; width: "+itemFromList.getWidth()+": height: "+itemFromList.getHeight()+"; thickness: "
                    +itemFromList.getThickness()+": nameForCatalog: "+itemFromList.getThickness()
                    +" x "+itemFromList.getWidth()+" x "+itemFromList.getHeight());
            arrayList.add(itemForData);
        }
        Log.d(TAG_OF_CONTROLLER, "ArrayListhandler, Size of arrayListhandler = " + arrayList.size());
        return arrayList;
    }

    @Override
    public HotRolledSteel getById(Context context, int position) {
        HotRolledSteelDAO dao = new HotRolledSteelDAO(context);
        HotRolledSteel hotRolledSteel = dao.select(position);
        return hotRolledSteel;
    }

    @Override
    public ArrayList<ArrayList<Map<String, String>>> getChildData(Context context) {
        HotRolledSteelDAO hotRolledSteelDAO = new HotRolledSteelDAO(context);
        ArrayList<ArrayList<Map<String, String>>> childData = new ArrayList<ArrayList<Map<String, String>>>();
        Map<String, String> mapToPutIntoChildData;
        List<Double> listOfThicknessName = hotRolledSteelDAO.listOfThickness();
        List<HotRolledSteel> hotRolledSteelStream = hotRolledSteelDAO.getAll();
        ArrayList<Map<String, String>> childDataItem;
        for(Double thickness : listOfThicknessName){
            childDataItem = new ArrayList<Map<String, String>>();
            List<HotRolledSteel> listOfSlelectedThickness = hotRolledSteelDAO.selectByThickness(thickness, hotRolledSteelStream);
            Log.d(TAG_OF_CONTROLLER, "thickness:" + thickness + " size of list: "+ listOfSlelectedThickness.size());
            for (HotRolledSteel hotRolledSteel : listOfSlelectedThickness){
                String stringToPut = hotRolledSteel.getWidth()+" x "+ hotRolledSteel.getHeight();
                mapToPutIntoChildData = new HashMap<String, String>();
                mapToPutIntoChildData.put(ATTR_THICKNESS_NAME, stringToPut);
                Log.d(TAG_OF_CONTROLLER, "put to Child Data: article" + ATTR_THICKNESS_NAME + " msg: "+ stringToPut);
                childDataItem.add(mapToPutIntoChildData);
            }
            childData.add(childDataItem);
        }
        return childData;
    }

    @Override
    public ArrayList<Map<String, String>> getGroupData(Context context) {
        ArrayList<Map<String, String>> groupData = new ArrayList<Map<String, String>>();
        Map<String, String> mapToPutIntoGroupData;
        HotRolledSteelDAO getList = new HotRolledSteelDAO(context);
        List<Double> catalogList = getList.listOfThickness();
        Log.d(TAG_OF_CONTROLLER, "getGroupData, Size of listOfThickness = " + catalogList.size());
        for(Double thickness: catalogList ){
            mapToPutIntoGroupData = new HashMap<String, String>();
            mapToPutIntoGroupData.put(ATTR_GROUP_NAME,thickness.toString());
            Log.d(TAG_OF_CONTROLLER, "getGroupData, put to Group Data: article" + ATTR_GROUP_NAME + " msg: "+ thickness.toString());
            groupData.add(mapToPutIntoGroupData);
        }
        return groupData;
    }

    public HotRolledSteel getDimensions(Context context, String groupText, String childText) {
       HotRolledSteelDAO hotRolledSteelDAO = new HotRolledSteelDAO(context);
        List<HotRolledSteel> stream = hotRolledSteelDAO.getAll();
        Double thickness = Double.parseDouble(groupText);
        HotRolledSteel findHotRolledSteel = null;
        for(HotRolledSteel steel : stream){
            if(steel.getThickness().equals(thickness)){
                String dimenssion = steel.getWidth()+" x "+steel.getHeight();
                if(dimenssion.equals(childText)){
                    findHotRolledSteel = steel;
                    break;
                }
            }
        }
        return findHotRolledSteel;
    }
}
