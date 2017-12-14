package ua.com.alexkrug.mettalcalculator.src.controller;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.com.alexkrug.mettalcalculator.src.controller.abstractClassForControler.AbstractController;
import ua.com.alexkrug.mettalcalculator.src.controller.interfaceForController.InterfaceForExpListAdapterController;
import ua.com.alexkrug.mettalcalculator.src.dao.ColdRolledSteelDAO;
import ua.com.alexkrug.mettalcalculator.src.model.ColdRolledSteel;


public class ColdRolledSteelController extends AbstractController<ColdRolledSteel> implements InterfaceForExpListAdapterController {
    private final String ATTR_GROUP_NAME= "dimensions";
    private final String ATTR_THICKNESS_NAME= "thicknessName";
    private final String TAG_OF_CONTROLLER = "ColdRolledSteelController";

    @Override
    public ArrayList<ArrayList<Map<String, String>>> getChildData(Context context){
        ColdRolledSteelDAO coldRolledSteelDAO = new ColdRolledSteelDAO(context);
        ArrayList<ArrayList<Map<String, String>>> childData = new ArrayList<>();
        Map<String, String> mapToPutIntoChildData;
        List<Double> listOfThicknessName = coldRolledSteelDAO.listOfThickness();
        List<ColdRolledSteel> coldRolledSteelStream = coldRolledSteelDAO.getAll();
        ArrayList<Map<String, String>> childDataItem;
        for(Double thickness : listOfThicknessName){
            childDataItem = new ArrayList<>();
            List<ColdRolledSteel> listOfSlelectedThickness = coldRolledSteelDAO.selectByThickness(thickness, coldRolledSteelStream);
            Log.d(TAG_OF_CONTROLLER, "thickness:" + thickness + " size of list: "+ listOfSlelectedThickness.size());
            for (ColdRolledSteel coldRolledSteel : listOfSlelectedThickness){
                String stringToPut = coldRolledSteel.getWidth()+" x "+ coldRolledSteel.getHeight();
                mapToPutIntoChildData = new HashMap<>();
                mapToPutIntoChildData.put(ATTR_THICKNESS_NAME, stringToPut);
                Log.d(TAG_OF_CONTROLLER, "put to Child Data: article" + ATTR_THICKNESS_NAME + " msg: "+ stringToPut);
                childDataItem.add(mapToPutIntoChildData);
            }
            childData.add(childDataItem);
        }
        return childData;
    }

    @Override
    public ArrayList<Map<String, String>> getGroupData(Context context){
        ArrayList<Map<String, String>> groupData = new ArrayList<>();
        Map<String, String> mapToPutIntoGroupData;
        ColdRolledSteelDAO getList = new ColdRolledSteelDAO(context);
        List<Double> catalogList = getList.listOfThickness();
        Log.d(TAG_OF_CONTROLLER, "getGroupData, Size of listOfThickness = " + catalogList.size());
        for(Double thickness: catalogList ){
                mapToPutIntoGroupData = new HashMap<>();
                mapToPutIntoGroupData.put(ATTR_GROUP_NAME,thickness.toString());
                Log.d(TAG_OF_CONTROLLER, "getGroupData, put to Group Data: article"
                        + ATTR_GROUP_NAME + " msg: "+ thickness.toString());
                groupData.add(mapToPutIntoGroupData);
            }
        return groupData;
    }

    @Override
    public ArrayList<Map<String, Object>> getCatalogListForAdapter(Context context, long position) {
        ColdRolledSteelDAO getList = new ColdRolledSteelDAO(context);
        List<ColdRolledSteel> catalogList = getList.getAll();
        Log.d(TAG_OF_CONTROLLER, "getCatalogListForAdapter, Size of getAll = " + catalogList.size());
        ArrayList<Map<String, Object>> dataList = arrayListhandler(catalogList);
        return dataList;
    }

    @Override
    protected ArrayList<Map<String, Object>> arrayListhandler(List catalogList) {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        for (int i = 0; i < catalogList.size(); i++ ) {
            Map<String, Object> itemForData = new HashMap<>();
            ColdRolledSteel itemFromList = (ColdRolledSteel) catalogList.get(i);
            itemForData.put("weigth", itemFromList.getWeight());
            itemForData.put("width", itemFromList.getWidth());
            itemForData.put("height", itemFromList.getHeight());
            itemForData.put("thickness", itemFromList.getThickness());
            itemForData.put("nameForCatalog",itemFromList.getThickness()+" x "+itemFromList.getWidth()+" x "
                    +itemFromList.getHeight());
            Log.d(TAG_OF_CONTROLLER, "ArrayListhandler, Put to ColdRolledSteel "+"weigth: "+itemFromList.getWeight()
            +"; width: "+itemFromList.getWidth()+": height: "+itemFromList.getHeight()+"; thickness: "+itemFromList.getThickness()
            +": nameForCatalog: "+itemFromList.getThickness()+" x "+itemFromList.getWidth()+" x "+itemFromList.getHeight());
            arrayList.add(itemForData);
        }

        Log.d(TAG_OF_CONTROLLER, "Size of arrayListhandler = " + arrayList.size());
        return arrayList;
    }

    @Override
    public ColdRolledSteel getById(Context context, int position) {
        ColdRolledSteelDAO dao = new ColdRolledSteelDAO(context);
        ColdRolledSteel coldRolledSteel = dao.select(position);
        return coldRolledSteel;
    }

    public ColdRolledSteel getDimensions(Context context, String groupText, String childText) {
        ColdRolledSteelDAO coldRolledSteelDAO = new ColdRolledSteelDAO(context);
        List<ColdRolledSteel> stream = coldRolledSteelDAO.getAll();
        Double thickness = Double.parseDouble(groupText);
        ColdRolledSteel findColdRolledSteel = null;
        for(ColdRolledSteel steel : stream){
            if(steel.getThickness().equals(thickness)){
                String dimension = steel.getWidth()+" x "+steel.getHeight();
                if(dimension.equals(childText)){
                    findColdRolledSteel = steel;
                    break;
                }
            }
        }
        return findColdRolledSteel;
    }
}
