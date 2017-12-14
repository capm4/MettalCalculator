package ua.com.alexkrug.mettalcalculator.src.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import ua.com.alexkrug.mettalcalculator.R;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import ua.com.alexkrug.mettalcalculator.src.controller.ColdRolledSteelController;
import ua.com.alexkrug.mettalcalculator.src.controller.HotRolledSteelController;
import ua.com.alexkrug.mettalcalculator.src.controller.ProfileTubeSquareController;
import ua.com.alexkrug.mettalcalculator.src.controller.RectangularProfileTubeController;
import ua.com.alexkrug.mettalcalculator.src.controller.RoundTubeController;
import ua.com.alexkrug.mettalcalculator.src.controller.SteelStripsController;
import ua.com.alexkrug.mettalcalculator.src.model.ColdRolledSteel;
import ua.com.alexkrug.mettalcalculator.src.model.HotRolledSteel;
import ua.com.alexkrug.mettalcalculator.src.model.ProfileTubeSquare;
import ua.com.alexkrug.mettalcalculator.src.model.RectangularProfileTube;
import ua.com.alexkrug.mettalcalculator.src.model.RoundTube;
import ua.com.alexkrug.mettalcalculator.src.model.SteelStrip;


public class ClickListenerAdapteExp {

    private final String LOG_TAG = "ClickListenerAdapteExp";
    private final String ATTR_GROUP_NAME= "dimensions";
    private final String ATTR_THICKNESS_NAME= "thicknessName";
    private final String ATTR_DIMENSION_NAME= "dimensionsName";

    private ColdRolledSteelController coldRolledSteelController = new ColdRolledSteelController();
    private HotRolledSteelController hotRolledSteelController = new HotRolledSteelController();
    private ClickListenerAdapteSimpl clickListenerAdapterSimpl = new ClickListenerAdapteSimpl();
    private RectangularProfileTubeController rProfileTubeController = new RectangularProfileTubeController();
    private ProfileTubeSquareController profileTubeSquareController = new ProfileTubeSquareController();
    private RoundTubeController roundTubeController = new RoundTubeController();
    private SteelStripsController steelStripsController = new SteelStripsController();

    public void onItemClickListenerExp(SimpleExpandableListAdapter adapter, long position, ExpandableListView catalogueListExpSimpAdapt, Map<String, TextView> mapOfTextView, ImageView imageOfSteel, Context context) {
        TextView first = mapOfTextView.get("First");
        TextView second = mapOfTextView.get("Second");
        TextView third = mapOfTextView.get("Third");
        TextView fourth = mapOfTextView.get("Fourth");
        TextView fifth = mapOfTextView.get("Fifth");
        TextView sixth = mapOfTextView.get("Sixth");
        TextView seventh = mapOfTextView.get("Seventh");
        TextView eighth = mapOfTextView.get("Eighth");
        switch ((int) position){
            case 6:{
                clickListenerAdapterSimpl.cleanTextView(first,second, third, fourth,fifth,sixth,seventh,eighth);
                setOnClickListenerCAHS(catalogueListExpSimpAdapt, adapter,first,second, third,fourth, context, imageOfSteel,1);
                break;
            }
            case 7:{
                clickListenerAdapterSimpl.cleanTextView(first,second, third, fourth,fifth,sixth,seventh,eighth);
                setOnClickListenerCAHS(catalogueListExpSimpAdapt, adapter,first,second, third,fourth, context, imageOfSteel,2);
                break;
            }
            case 8:{
                clickListenerAdapterSimpl.cleanTextView(first,second, third, fourth,fifth,sixth,seventh,eighth);
                setOnClickListenerCAHS(catalogueListExpSimpAdapt, adapter,first,second, third,fourth, context, imageOfSteel,3);
                break;
            }
            case 9:{
                clickListenerAdapterSimpl.cleanTextView(first,second, third, fourth,fifth,sixth,seventh,eighth);
                setOnClickListenerCAHS(catalogueListExpSimpAdapt, adapter,first,second, third,fourth, context, imageOfSteel,4);
                break;
            }
            case 10:{
                clickListenerAdapterSimpl.cleanTextView(first,second, third, fourth,fifth,sixth,seventh,eighth);
                setOnClickListenerRoundTube(catalogueListExpSimpAdapt, adapter,first,second, third, context, imageOfSteel);
                break;
            }
            case 13:{
                clickListenerAdapterSimpl.cleanTextView(first,second, third, fourth,fifth,sixth,seventh,eighth);
                setOnClickListenerSteelStrips(catalogueListExpSimpAdapt, adapter,first,second, third,fourth, context, imageOfSteel);
                break;
            }
        }
    }

    private void setOnClickListenerSteelStrips(ExpandableListView catalogueListExpSimpAdapt,
                                               final SimpleExpandableListAdapter adapter, final TextView first,
                                               final TextView second, final TextView third, final TextView fourth,
                                               final Context context, final ImageView imageOfSteel) {
        catalogueListExpSimpAdapt.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int id, long l) {
                Log.d(LOG_TAG, "Round Tube itemClick: position = " + groupPosition + ", id = " + id + " / " + l);
                SteelStrip element = steelStripsController.getDimensions(context, getGroupText(adapter, groupPosition),
                                                                      getChildTextThickness(adapter, groupPosition, id));
                first.setText(context.getString(R.string.Thickness)+"(a): "+element.getThickness().toString());
                first.setPadding(5,70,0,5);
                second.setText(context.getString(R.string.Width)+"(b): "+element.getWidth().toString());
                second.setPadding(5,5,0,5);
                Double weigth = new BigDecimal(element.getWeight()).setScale(2, RoundingMode.UP).doubleValue();
                third.setText(context.getString(R.string.Weight)+": " +weigth.toString()+" kg.");
                third.setPadding(5,5,0,5);
                fourth.setText(context.getString(R.string.MetersInTone)+": "+element.getMetersInTone());
                fourth.setPadding(5,5,0,5);
                imageOfSteel.setImageResource(R.drawable.steelstrip);
                return false;
            }
        });
    }


    private void setOnClickListenerRoundTube(ExpandableListView catalogueListExpSimpAdapt,
                                             final SimpleExpandableListAdapter adapter, final TextView first,
                                             final TextView second, final TextView third, final Context context,
                                             final ImageView imageOfSteel) {
        catalogueListExpSimpAdapt.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int id, long l) {
                Log.d(LOG_TAG, "Round Tube itemClick: position = " + groupPosition + ", id = " + id + " / " + l);
                RoundTube element = roundTubeController.getDimensions(context, getGroupText(adapter, groupPosition),
                                                                  getChildTextDimension(adapter, groupPosition, id));
                first.setText(context.getString(R.string.Thickness)+"(S): "+element.getThickness().toString());
                first.setPadding(5,70,0,5);
                second.setText(context.getString(R.string.Radius)+"(a): "+element.getRadius().toString());
                second.setPadding(5,5,0,5);
                Double weigth = new BigDecimal(element.getWeight()).setScale(2, RoundingMode.UP).doubleValue();
                third.setText(context.getString(R.string.Weight)+": " +weigth.toString()+" kg.");
                third.setPadding(5,5,0,5);
                imageOfSteel.setImageResource(R.drawable.roundtube);
                return false;
            }
            });
        }

    private void setOnClickListenerCAHS(ExpandableListView catalogueListExpSimpAdapt, final SimpleExpandableListAdapter adapter,
                                        final TextView first, final TextView second, final TextView third,
                                        final TextView fourth, final Context context, final ImageView imageOfSteel,
                                        final int position) {
        catalogueListExpSimpAdapt.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int id, long l) {
                Log.d(LOG_TAG, "Cold Rolled Steel itemClick: position = " + groupPosition + ", id = "+ id + " / "+l );
                @NotNull Double width = null;
                @NotNull Double height = null;
                @NotNull Double thickness = null;
                @NotNull Double weightOfList = null;
                @NotNull String nameWeight = new String();
                switch (position) {
                    case 1: {
                        ColdRolledSteel element = coldRolledSteelController.getDimensions(context, getGroupText(adapter,
                                                       groupPosition),getChildTextThickness(adapter, groupPosition,id) );
                        width =element.getWidth();
                        height = element.getHeight();
                        thickness = element.getThickness();
                        weightOfList = element.getWeight();
                        nameWeight = context.getString(R.string.Weight)+"of list: ";
                        imageOfSteel.setImageResource(R.drawable.list);
                        break;
                    }
                    case 2: {
                        HotRolledSteel element = hotRolledSteelController.getDimensions(context, getGroupText(adapter,groupPosition),
                                getChildTextThickness(adapter, groupPosition,id) );
                        width =element.getWidth();
                        height = element.getHeight();
                        thickness = element.getThickness();
                        weightOfList = element.getWeight();
                        nameWeight = context.getString(R.string.Weight)+"of list: ";
                        imageOfSteel.setImageResource(R.drawable.list);
                        break;
                    }
                    case 3: {
                        ProfileTubeSquare element = profileTubeSquareController.getDimensions(context, getGroupText(adapter,groupPosition),
                                                      getChildTextDimension(adapter, groupPosition,id) );
                        width =element.getWidth();
                        height=element.getWidth();
                        thickness = element.getThickness();
                        weightOfList = element.getWeight();
                        nameWeight = context.getString(R.string.Weight)+"of meter: ";
                        imageOfSteel.setImageResource(R.drawable.squaretube);
                        break;
                    }
                    case 4: {
                        RectangularProfileTube element = rProfileTubeController.getDimensions(context, getGroupText(adapter,groupPosition),
                                                         getChildTextDimension(adapter, groupPosition,id) );
                        width =element.getWidth();
                        height=element.getHeight();
                        thickness = element.getThickness();
                        weightOfList = element.getWeight();
                        nameWeight = context.getString(R.string.Weight)+"of meter: ";
                        imageOfSteel.setImageResource(R.drawable.retube);
                        break;
                    }
                }
                first.setText(context.getString(R.string.Thickness)+"(S): "+thickness.toString());
                first.setPadding(5,70,0,5);
                second.setText(context.getString(R.string.Width)+"(b): "+width.toString());
                second.setPadding(5,5,0,5);
                third.setText(context.getString(R.string.Height)+"(h): "+height.toString());
                third.setPadding(5,5,0,5);
                Double weigth = new BigDecimal(weightOfList).setScale(2, RoundingMode.UP).doubleValue();
                fourth.setText(nameWeight +weigth.toString()+" kg.");
                fourth.setPadding(5,5,0,5);
                return false;
            }
        });
    }

    String getGroupText(SimpleExpandableListAdapter adapter, int groupPos) {
        return ((Map<String,String>)(adapter.getGroup(groupPos))).get(ATTR_GROUP_NAME);
    }

    String getChildTextThickness(SimpleExpandableListAdapter adapter, int groupPos, int childPos) {
        return ((Map<String,String>)(adapter.getChild(groupPos, childPos))).get(ATTR_THICKNESS_NAME);
    }
    String getChildTextDimension(SimpleExpandableListAdapter adapter, int groupPos, int childPos) {
        return ((Map<String,String>)(adapter.getChild(groupPos, childPos))).get(ATTR_DIMENSION_NAME);
    }
}
