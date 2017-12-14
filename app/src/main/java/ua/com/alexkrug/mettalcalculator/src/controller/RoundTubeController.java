package ua.com.alexkrug.mettalcalculator.src.controller;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.com.alexkrug.mettalcalculator.src.controller.abstractClassForControler.AbstractController;
import ua.com.alexkrug.mettalcalculator.src.controller.interfaceForController.InterfaceForExpListAdapterController;
import ua.com.alexkrug.mettalcalculator.src.dao.RoundTubeDAO;
import ua.com.alexkrug.mettalcalculator.src.model.RoundTube;



public class RoundTubeController extends AbstractController<RoundTube> implements InterfaceForExpListAdapterController {
    private final String ATTR_GROUP_NAME= "dimensions";
    private final String ATTR_DIMENSION_NAME= "dimensionsName";
    private final String TAG_OF_CONTROLLER = "RoundTubeController";

    @Override
    public ArrayList<Map<String, Object>> getCatalogListForAdapter(Context context, long position) {
        RoundTubeDAO getList = new RoundTubeDAO(context);
        List<RoundTube>catalogList = getList.getAll();
        Log.d(TAG_OF_CONTROLLER, "getCatalogListForAdapter, Size of getAll = " + catalogList.size());
        ArrayList<Map<String, Object>> dataList = arrayListhandler(catalogList);
        return dataList;
    }

    @Override
    protected ArrayList<Map<String, Object>> arrayListhandler(List catalogList) {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < catalogList.size(); i++ ) {
            Map<String, Object> itemForData = new HashMap<String, Object>();
            RoundTube itemFromList = (RoundTube) catalogList.get(i);
            itemForData.put("weight", itemFromList.getWeight());
            itemForData.put("radius", itemFromList.getRadius());
            itemForData.put("metersInTone", itemFromList.getMetersInTone());
            itemForData.put("thickness", itemFromList.getThickness());
            itemForData.put("nameForCatalog",itemFromList.getRadius()+"x"+itemFromList.getThickness());
            Log.d(TAG_OF_CONTROLLER, "ArrayListhandler, Put to RoundTube "+"weigth: "+itemFromList.getWeight()
                    +"; radius: "+itemFromList.getRadius()
                    +"; thickness: "+itemFromList.getThickness()
                    +": metersInTone: "+itemFromList.getMetersInTone()
                    +": nameForCatalog: "+itemFromList.getRadius()
                    +" x "+itemFromList.getThickness());
            arrayList.add(itemForData);
        }
        return arrayList;
    }

    @Override
    public RoundTube getById(Context context, int position) {
        RoundTubeDAO dao = new RoundTubeDAO(context);
        RoundTube roundTube = dao.select(position);
        return roundTube;
    }

    @Override
    public ArrayList<ArrayList<Map<String, String>>> getChildData(Context context) {
        RoundTubeDAO roundTubeDAO = new RoundTubeDAO(context);
        ArrayList<ArrayList<Map<String, String>>> childData = new ArrayList<ArrayList<Map<String, String>>>();
        Map<String, String> mapToPutIntoChildData;
        List<Double> listOfDimensions = roundTubeDAO.listOfThickness();
        List<RoundTube> roundTubeStream = roundTubeDAO.getAll();
        ArrayList<Map<String, String>> childDataItem;
        for(Double dimensions: listOfDimensions){
            childDataItem = new ArrayList<Map<String, String>>();
            List<RoundTube> listOfSlelectedDimension = roundTubeDAO.selectByDimensions(dimensions,dimensions, roundTubeStream);
            Log.d(TAG_OF_CONTROLLER, "dimension: "+dimensions+" size of list: "+listOfDimensions.size());
            for (RoundTube roundTube : listOfSlelectedDimension){
                String  stringToPut = roundTube.getThickness().toString();
                mapToPutIntoChildData = new HashMap<String, String>();
                mapToPutIntoChildData.put(ATTR_DIMENSION_NAME, stringToPut);
                Log.d(TAG_OF_CONTROLLER, "put to Child Data: article" + ATTR_DIMENSION_NAME + " msg: "+ stringToPut);
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
        RoundTubeDAO getList = new RoundTubeDAO(context);
        List<Double> catalogList = getList.listOfThickness();
        Log.d(TAG_OF_CONTROLLER, "getGroupData, Size of listOfThickness = " + catalogList.size());
        for(Double dimension: catalogList ){
            mapToPutIntoGroupData = new HashMap<String, String>();
            mapToPutIntoGroupData.put(ATTR_GROUP_NAME,dimension.toString());
            Log.d(TAG_OF_CONTROLLER, "getGroupData, put to Group Data: article" + ATTR_GROUP_NAME + " msg: "+dimension.toString());
            groupData.add(mapToPutIntoGroupData);
        }
        return groupData;
    }

    public RoundTube getDimensions(Context context, String groupText, String childText) {
        RoundTubeDAO roundTubeDAO = new RoundTubeDAO(context);
        List<RoundTube> stream = roundTubeDAO.getAll();
        Double thickness = Double.parseDouble(childText);
        RoundTube findRoundTube = null;
        for(RoundTube steel : stream){
            Double checkTubeDimension = steel.getRadius();
            if(checkTubeDimension.equals(Double.parseDouble(groupText))){
                if(steel.getThickness().equals(thickness)){
                    findRoundTube = steel;
                    break;
                }
            }
        }
        return findRoundTube;
    }
}
