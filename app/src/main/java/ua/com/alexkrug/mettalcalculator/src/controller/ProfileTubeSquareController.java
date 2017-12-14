package ua.com.alexkrug.mettalcalculator.src.controller;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.com.alexkrug.mettalcalculator.src.controller.abstractClassForControler.AbstractController;
import ua.com.alexkrug.mettalcalculator.src.controller.interfaceForController.InterfaceForExpListAdapterController;
import ua.com.alexkrug.mettalcalculator.src.dao.ProfileTubeSquareDAO;
import ua.com.alexkrug.mettalcalculator.src.model.ProfileTubeSquare;


public class ProfileTubeSquareController extends AbstractController<ProfileTubeSquare> implements InterfaceForExpListAdapterController{
    private final String ATTR_GROUP_NAME= "dimensions";
    private final String ATTR_DIMENSION_NAME= "dimensionsName";
    private final String TAG_OF_CONTROLLER = "ProfileTubeSquareController";

    @Override
    public ArrayList<Map<String, Object>> getCatalogListForAdapter(Context context, long position) {
        ProfileTubeSquareDAO getList = new ProfileTubeSquareDAO(context);
        List<ProfileTubeSquare> catalogList = getList.getAll();
        Log.d(TAG_OF_CONTROLLER, "getCatalogListForAdapter, Size of getAll = " + catalogList.size());
        ArrayList<Map<String, Object>> dataList = arrayListhandler(catalogList);
        return dataList;
    }

    @Override
    protected ArrayList<Map<String, Object>> arrayListhandler(List catalogList) {
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        for (int i = 0; i < catalogList.size(); i++ ) {
            Map<String, Object> itemForData = new HashMap<>();
            ProfileTubeSquare itemFromList = (ProfileTubeSquare) catalogList.get(i);
            itemForData.put("weigh", itemFromList.getWeight());
            itemForData.put("width", itemFromList.getWidth());
            itemForData.put("metersInTone", itemFromList.getMetersInTone());
            itemForData.put("thickness", itemFromList.getThickness());
            itemForData.put("nameForCatalog",itemFromList.getWidth()+"x"
                    +itemFromList.getWidth()+"x"+itemFromList.getThickness());
            Log.d(TAG_OF_CONTROLLER, "ArrayListhandler, Put to ProfileTubeSquare "+"weigth: "+itemFromList.getWeight()
                    +"; width: "+itemFromList.getWidth()+"; thickness: "+itemFromList.getThickness()
                    +": metersInTone: "+itemFromList.getMetersInTone()
                    +": nameForCatalog: "+itemFromList.getThickness()
                    +" x "+itemFromList.getWidth()+" x "+itemFromList.getWidth());
            arrayList.add(itemForData);
        }
        return arrayList;
    }

    @Override
    public ProfileTubeSquare getById(Context context, int position) {
        ProfileTubeSquareDAO dao = new ProfileTubeSquareDAO(context);
        ProfileTubeSquare profileTubeSquare = dao.select(position);
        return profileTubeSquare;
    }

    @Override
    public ArrayList<ArrayList<Map<String, String>>> getChildData(Context context) {
        ProfileTubeSquareDAO profileTubeSquareDAO = new ProfileTubeSquareDAO(context);
        ArrayList<ArrayList<Map<String, String>>> childData = new ArrayList<ArrayList<Map<String, String>>>();
        Map<String, String> mapToPutIntoChildData;
        List<Double> listOfDimensions = profileTubeSquareDAO.listOfThickness();
        List<ProfileTubeSquare> profileTubeSquareStream = profileTubeSquareDAO.getAll();
        ArrayList<Map<String, String>> childDataItem;
        for(Double  dimensions: listOfDimensions){
            childDataItem = new ArrayList<Map<String, String>>();
            List<ProfileTubeSquare> listOfSlelectedDimension = profileTubeSquareDAO.selectByDimensions(dimensions,dimensions, profileTubeSquareStream);
            Log.d(TAG_OF_CONTROLLER, "dimension:"+dimensions+" x "+ dimensions+" size of list: "+listOfSlelectedDimension.size());
            for (ProfileTubeSquare profileTubeSquare : listOfSlelectedDimension){
                String  stringToPut = profileTubeSquare.getThickness().toString();
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
        ProfileTubeSquareDAO getList = new ProfileTubeSquareDAO(context);
        List<Double> catalogList = getList.listOfThickness();
        Log.d(TAG_OF_CONTROLLER, "getGroupData, Size of listOfThickness = " + catalogList.size());
        for(Double dimension: catalogList ){
            mapToPutIntoGroupData = new HashMap<String, String>();
            mapToPutIntoGroupData.put(ATTR_GROUP_NAME,dimension.toString()+" x "+dimension.toString());
            Log.d(TAG_OF_CONTROLLER, "getGroupData, put to Group Data: article" + ATTR_GROUP_NAME + " msg: "+dimension.toString()+" x "+dimension.toString());
            groupData.add(mapToPutIntoGroupData);
        }
        return groupData;
    }

    public ProfileTubeSquare getDimensions(Context context, String groupText, String childText) {
        ProfileTubeSquareDAO profileTubeSquareDAO = new ProfileTubeSquareDAO(context);
        List<ProfileTubeSquare> stream = profileTubeSquareDAO.getAll();
        Double thickness = Double.parseDouble(childText);
        ProfileTubeSquare findProfileTubeSquare = null;
        for(ProfileTubeSquare steel : stream){
            String checkTubeDimension = steel.getWidth()+" x "+steel.getWidth();
            if(checkTubeDimension.equals(groupText)){
                if(steel.getThickness().equals(thickness)){
                    findProfileTubeSquare = steel;
                    break;
                }
            }
        }
        return findProfileTubeSquare;
    }
}
