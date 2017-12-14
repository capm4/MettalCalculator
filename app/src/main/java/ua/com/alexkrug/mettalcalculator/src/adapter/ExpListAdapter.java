package ua.com.alexkrug.mettalcalculator.src.adapter;

import android.content.Context;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

import ua.com.alexkrug.mettalcalculator.src.controller.ColdRolledSteelController;
import ua.com.alexkrug.mettalcalculator.src.controller.HotRolledSteelController;
import ua.com.alexkrug.mettalcalculator.src.controller.ProfileTubeSquareController;
import ua.com.alexkrug.mettalcalculator.src.controller.RectangularProfileTubeController;
import ua.com.alexkrug.mettalcalculator.src.controller.RoundTubeController;
import ua.com.alexkrug.mettalcalculator.src.controller.SteelStripsController;


public class ExpListAdapter {
    private static ColdRolledSteelController coldRolledSteelController = new ColdRolledSteelController();
    private static HotRolledSteelController hotRolledSteelController = new HotRolledSteelController();
    private static ProfileTubeSquareController profileTubeSquareController = new ProfileTubeSquareController();
    private static RectangularProfileTubeController rectangularProfileTubeController = new RectangularProfileTubeController();
    private static RoundTubeController roundTubeController = new RoundTubeController();
    private static SteelStripsController steelStripsController = new SteelStripsController();
    private static ClickListenerAdapteExp clickListener= new ClickListenerAdapteExp();
    final String ATTR_GROUP_NAME= "dimensions";
    final String ATTR_THICKNESS_NAME= "thicknessName";
    final String ATTR_DIMENSION_NAME= "dimensionsName";
    String groupFrom[] = new String[]{ATTR_GROUP_NAME};
    String childThicknessFrom[] = new String[]{ATTR_THICKNESS_NAME};
    String childDimensionFrom[] = new String[]{ATTR_DIMENSION_NAME};
    public SimpleExpandableListAdapter getExpandableAdapter(long position, Context context, int resourceTitle, int[] toTitle,
                                                            int resource, int[] toChild, Map<String, TextView> mapOfTextView,
                                                            ImageView imageOfSteel, ExpandableListView catalogueListExpSimpAdapt){
        SimpleExpandableListAdapter adapter = null;
        switch ((int)position){
            case 6:{
                ArrayList<Map<String, String>> groupData = coldRolledSteelController.getGroupData(context);
                ArrayList<ArrayList<Map<String, String>>> childData = coldRolledSteelController.getChildData(context);
                adapter = new SimpleExpandableListAdapter(context,groupData,resourceTitle, groupFrom, toTitle,childData,resource,childThicknessFrom,toChild);
                clickListener.onItemClickListenerExp(adapter, position, catalogueListExpSimpAdapt, mapOfTextView,imageOfSteel, context);
                break;
            }
            case 7:{
                ArrayList<Map<String, String>> groupData = hotRolledSteelController.getGroupData(context);
                ArrayList<ArrayList<Map<String, String>>> childData = hotRolledSteelController.getChildData(context);
                adapter = new SimpleExpandableListAdapter(context,groupData,resourceTitle, groupFrom, toTitle,childData,resource,childThicknessFrom,toChild);
                clickListener.onItemClickListenerExp(adapter, position, catalogueListExpSimpAdapt, mapOfTextView,imageOfSteel, context);
                break;
            }
            case 8:{
                ArrayList<Map<String, String>> groupData = profileTubeSquareController.getGroupData(context);
                ArrayList<ArrayList<Map<String, String>>> childData = profileTubeSquareController.getChildData(context);
                adapter = new SimpleExpandableListAdapter(context,groupData,resourceTitle, groupFrom, toTitle,childData,resource,childDimensionFrom,toChild);
                clickListener.onItemClickListenerExp(adapter, position, catalogueListExpSimpAdapt, mapOfTextView,imageOfSteel, context);
                break;
            }
            case 9:{
                ArrayList<Map<String, String>> groupData = rectangularProfileTubeController.getGroupData(context);
                ArrayList<ArrayList<Map<String, String>>> childData = rectangularProfileTubeController.getChildData(context);
                adapter = new SimpleExpandableListAdapter(context,groupData,resourceTitle, groupFrom, toTitle,childData,resource,childDimensionFrom,toChild);
                clickListener.onItemClickListenerExp(adapter, position, catalogueListExpSimpAdapt, mapOfTextView,imageOfSteel, context);
                break;
            }
            case 10:{
                ArrayList<Map<String, String>> groupData = roundTubeController.getGroupData(context);
                ArrayList<ArrayList<Map<String, String>>> childData = roundTubeController.getChildData(context);
                adapter = new SimpleExpandableListAdapter(context,groupData,resourceTitle, groupFrom, toTitle,childData,resource,childDimensionFrom,toChild);
                clickListener.onItemClickListenerExp(adapter, position, catalogueListExpSimpAdapt, mapOfTextView,imageOfSteel, context);
                break;
            }
            case 13:{
                ArrayList<Map<String, String>> groupData = steelStripsController.getGroupData(context);
                ArrayList<ArrayList<Map<String, String>>> childData = steelStripsController.getChildData(context);
                adapter = new SimpleExpandableListAdapter(context,groupData,resourceTitle, groupFrom, toTitle,childData,resource,childThicknessFrom,toChild);
                clickListener.onItemClickListenerExp(adapter, position, catalogueListExpSimpAdapt, mapOfTextView,imageOfSteel, context);
                break;
            }

        }

        return adapter;
    }
}
