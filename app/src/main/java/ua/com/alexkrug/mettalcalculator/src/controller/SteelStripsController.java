package ua.com.alexkrug.mettalcalculator.src.controller;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.com.alexkrug.mettalcalculator.src.controller.abstractClassForControler.AbstractController;
import ua.com.alexkrug.mettalcalculator.src.controller.interfaceForController.InterfaceForExpListAdapterController;
import ua.com.alexkrug.mettalcalculator.src.dao.SteelStripDAO;
import ua.com.alexkrug.mettalcalculator.src.model.SteelStrip;


public class SteelStripsController extends AbstractController<SteelStrip> implements InterfaceForExpListAdapterController {
    private final String ATTR_GROUP_NAME= "dimensions";
    private final String ATTR_THICKNESS_NAME= "thicknessName";
    private final String TAG_OF_CONTROLLER = "SteelStripsController";

    @Override
    public ArrayList<Map<String, Object>> getCatalogListForAdapter(Context context, long position) {
        SteelStripDAO getList = new SteelStripDAO(context);
        List<SteelStrip> catalogList = getList.getAll();
        Log.d(TAG_OF_CONTROLLER, "getCatalogListForAdapter, Size of getAll = " + catalogList.size());
        ArrayList<Map<String, Object>>dataList = arrayListhandler(catalogList);
        return dataList;
    }

    @Override
    protected ArrayList<Map<String, Object>> arrayListhandler(List catalogList) {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < catalogList.size(); i++ ) {
            Map<String, Object> itemForData = new HashMap<String, Object>();
            SteelStrip itemFromList = (SteelStrip) catalogList.get(i);
            itemForData.put("weigth", itemFromList.getWeight());
            itemForData.put("width", itemFromList.getWidth());
            itemForData.put("metersInTone", itemFromList.getMetersInTone());
            itemForData.put("thickness", itemFromList.getThickness());
            itemForData.put("nameForCatalog",itemFromList.getThickness()+" x "+itemFromList.getWidth());
            Log.d(TAG_OF_CONTROLLER, "ArrayListhandler, Put to SteelStrip "+"weigth: "+itemFromList.getWeight()
                    +"; width: "+itemFromList.getWidth()+"; thickness: "+itemFromList.getThickness()
                    +"; metersInTone"+itemFromList.getMetersInTone()
                    +": nameForCatalog: "+itemFromList.getThickness()
                    +" x "+itemFromList.getWidth());
            arrayList.add(itemForData);
        }
        return arrayList;
    }

    @Override
    public SteelStrip getById(Context context, int id) {
        SteelStripDAO dao = new SteelStripDAO(context);
        SteelStrip steelStrip = dao.select(id);
        return steelStrip;
    }

    @Override
    public ArrayList<ArrayList<Map<String, String>>> getChildData(Context context) {
        SteelStripDAO steelStripDAO = new SteelStripDAO(context);
        ArrayList<ArrayList<Map<String, String>>> childData = new ArrayList<ArrayList<Map<String, String>>>();
        Map<String, String> mapToPutIntoChildData;
        List<Double> listOfThicknessName = steelStripDAO.listOfThickness();
        List<SteelStrip> steelStripStream = steelStripDAO.getAll();
        ArrayList<Map<String, String>> childDataItem;
        for(Double thickness : listOfThicknessName){
            childDataItem = new ArrayList<Map<String, String>>();
            List<SteelStrip> listOfSlelectedThickness = steelStripDAO.selectByThickness(thickness, steelStripStream);
            Log.d(TAG_OF_CONTROLLER, "thickness:" + thickness + " size of list: "+ listOfSlelectedThickness.size());
            for (SteelStrip steelStrip : listOfSlelectedThickness){
                String stringToPut = steelStrip.getWidth().toString();
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
        SteelStripDAO getList = new SteelStripDAO(context);
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

    public SteelStrip getDimensions(Context context, String groupText, String childText) {
        SteelStripDAO steelStripDAO = new SteelStripDAO(context);
        List<SteelStrip> stream = steelStripDAO.getAll();
        Double width = Double.parseDouble(childText);
        SteelStrip findSteelStrip = null;
        for(SteelStrip steel : stream){
            Double checkTubeDimension = steel.getThickness();
            if(checkTubeDimension.equals(Double.parseDouble(groupText))){
                if(steel.getWidth().equals(width)){
                    findSteelStrip = steel;
                    break;
                }
            }
        }
        return findSteelStrip;
    }
}
