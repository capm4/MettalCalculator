package ua.com.alexkrug.mettalcalculator.src.controller;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.com.alexkrug.mettalcalculator.src.controller.abstractClassForControler.AbstractController;
import ua.com.alexkrug.mettalcalculator.src.controller.interfaceForController.InterfaceForExpListAdapterController;
import ua.com.alexkrug.mettalcalculator.src.dao.RectangularProfileTubeDAO;
import ua.com.alexkrug.mettalcalculator.src.model.RectangularProfileTube;

/**
 * Created by Alex on 28.11.2017.
 */

public class RectangularProfileTubeController extends AbstractController<RectangularProfileTube> implements InterfaceForExpListAdapterController {
    final String ATTR_GROUP_NAME= "dimensions";
    final String ATTR_DIMENSION_NAME= "dimensionsName";
    final String TAG_OF_CONTROLLER = "RectangularProfileTubeController";

    @Override
    public ArrayList<Map<String, Object>> getCatalogListForAdapter(Context context, long position) {
        RectangularProfileTubeDAO getList = new RectangularProfileTubeDAO(context);
        List<RectangularProfileTube> catalogList = getList.getAll();
        Log.d(TAG_OF_CONTROLLER, "getCatalogListForAdapter, Size of getAll = " + catalogList.size());
        ArrayList<Map<String, Object>> dataList = arrayListhandler(catalogList);
        return dataList;
    }

    @Override
    protected ArrayList<Map<String, Object>> arrayListhandler(List catalogList) {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < catalogList.size(); i++ ) {
            Map<String, Object> itemForData = new HashMap<String, Object>();
            RectangularProfileTube itemFromList = (RectangularProfileTube) catalogList.get(i);
            itemForData.put("weight", itemFromList.getWeight());
            itemForData.put("width", itemFromList.getWidth());
            itemForData.put("height", itemFromList.getHeight());
            itemForData.put("thickness", itemFromList.getThickness());
            itemForData.put("nameForCatalog",itemFromList.getWidth()+"x"
                    +itemFromList.getHeight()+" x "+itemFromList.getThickness());
            Log.d(TAG_OF_CONTROLLER, "ArrayListhandler, Put to RectangularProfileTube "+"weight: "+itemFromList.getWeight()
                    +"; width: "+itemFromList.getWidth()+"; height"+itemFromList.getHeight()
                    +"; thickness: "+itemFromList.getThickness()
                    +": metersInTone: "+itemFromList.getMetersInTone()
                    +": nameForCatalog: "+itemFromList.getThickness()
                    +" x "+itemFromList.getWidth()+" x "+itemFromList.getWidth());
            arrayList.add(itemForData);
        }
        return arrayList;
    }

    @Override
    public RectangularProfileTube getById(Context context, int position) {
        RectangularProfileTubeDAO dao = new RectangularProfileTubeDAO(context);
        RectangularProfileTube rectangularProfileTube = dao.select(position);
        return rectangularProfileTube;
    }

    @Override
    public ArrayList<ArrayList<Map<String, String>>> getChildData(Context context) {
        RectangularProfileTubeDAO rectangularProfileTubeDAO = new RectangularProfileTubeDAO(context);
        ArrayList<ArrayList<Map<String, String>>> childData = new ArrayList<>();
        Map<String, String> mapToPutIntoChildData;
        List<RectangularProfileTube> listOfDimensions = rectangularProfileTubeDAO.listOfDimensions();
        List<RectangularProfileTube> rectangularProfileTubeStream = rectangularProfileTubeDAO.getAll();
        ArrayList<Map<String, String>> childDataItem;
        for(RectangularProfileTube  dimensions: listOfDimensions){
            childDataItem = new ArrayList<>();
            List<RectangularProfileTube> listOfSlelectedDimension = rectangularProfileTubeDAO.selectByDimensions(dimensions.getWidth(),dimensions.getHeight(), rectangularProfileTubeStream);
            Log.d(TAG_OF_CONTROLLER, "dimension:"+dimensions.getWidth()+" x "+ dimensions.getHeight()+" size of list: "+listOfDimensions.size());
            for (RectangularProfileTube rectangularProfileTube : listOfSlelectedDimension){
                String  stringToPut = rectangularProfileTube.getThickness().toString();
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
        ArrayList<Map<String, String>> groupData = new ArrayList<>();
        Map<String, String> mapToPutIntoGroupData;
        RectangularProfileTubeDAO getList = new RectangularProfileTubeDAO(context);
        List<RectangularProfileTube> catalogList = getList.listOfDimensions();
        Log.d(TAG_OF_CONTROLLER, "getGroupData, Size of listOfDimension = " + catalogList.size());
        for(RectangularProfileTube dimension: catalogList ){
            mapToPutIntoGroupData = new HashMap<String, String>();
            mapToPutIntoGroupData.put(ATTR_GROUP_NAME,dimension.getWidth()+" x "+dimension.getHeight());
            Log.d(TAG_OF_CONTROLLER, "getGroupData, put to Group Data: article" + ATTR_GROUP_NAME + " msg: "+dimension.getWidth()+" x "+dimension.getHeight());
            groupData.add(mapToPutIntoGroupData);
        }
        return groupData;
    }

    public RectangularProfileTube getDimensions(Context context, String groupText, String childText) {
        RectangularProfileTubeDAO rectangularProfileTubeDAO = new RectangularProfileTubeDAO(context);
        List<RectangularProfileTube> stream =rectangularProfileTubeDAO.getAll();
        Double thickness = Double.parseDouble(childText);
        RectangularProfileTube findRectangularProfileTube = null;
        for(RectangularProfileTube steel : stream){
            String checkTubeDimension = steel.getWidth()+" x "+steel.getHeight();
            if(checkTubeDimension.equals(groupText)){
                if(steel.getThickness().equals(thickness)){
                    findRectangularProfileTube = steel;
                    break;
                }
            }
        }
        return findRectangularProfileTube;
    }
}
