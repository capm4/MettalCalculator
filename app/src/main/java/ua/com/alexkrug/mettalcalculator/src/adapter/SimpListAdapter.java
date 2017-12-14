package ua.com.alexkrug.mettalcalculator.src.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

import ua.com.alexkrug.mettalcalculator.src.controller.BeadController;
import ua.com.alexkrug.mettalcalculator.src.controller.ChannelsController;
import ua.com.alexkrug.mettalcalculator.src.controller.EqualLegAngelsController;
import ua.com.alexkrug.mettalcalculator.src.controller.HexahedronController;
import ua.com.alexkrug.mettalcalculator.src.controller.RebarController;
import ua.com.alexkrug.mettalcalculator.src.controller.SquareBarsController;
import ua.com.alexkrug.mettalcalculator.src.controller.SteelCircleController;
import ua.com.alexkrug.mettalcalculator.src.controller.UnequalLegAngelsController;
import ua.com.alexkrug.mettalcalculator.src.controller.WireRodController;



public class SimpListAdapter
{
    private static final String[] from = {"nameForCatalog"};
    private static ChannelsController channelsController = new ChannelsController();
    private static BeadController beadController = new BeadController();
    private static UnequalLegAngelsController unequalLegAngelsController = new UnequalLegAngelsController();
    private static ClickListenerAdapteSimpl clickListener= new ClickListenerAdapteSimpl();
    private static EqualLegAngelsController equalLegAngelsController = new EqualLegAngelsController();
    private static RebarController rebarController = new RebarController();
    private static WireRodController wireRodController = new WireRodController();
    private static SquareBarsController squareBarsController = new SquareBarsController();
    private static SteelCircleController steelCircleController = new SteelCircleController();
    private static HexahedronController hexahedronController = new HexahedronController();

    public SimpleAdapter getAdapter(long position, Context context, int resource, int[] to, ListView listView,Map<String, TextView> mapOfTextView,ImageView imageOfSteel){
        ArrayList<Map<String, Object>> dataList = getCatalogListForAdapter(context,position, listView, mapOfTextView,imageOfSteel);
        SimpleAdapter adapter = new SimpleAdapter(context, dataList, resource, from, to);
        return  adapter;
    }

    private static ArrayList<Map<String, Object>> getCatalogListForAdapter(Context context, long position, ListView listView, Map<String, TextView> mapOfTextView,ImageView imageOfSteel){
        ArrayList<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
        switch ((int) position){
            case  0:
                dataList = unequalLegAngelsController.getCatalogListForAdapter(context, position);
                clickListener.onItemClickListener(position, listView, mapOfTextView,imageOfSteel, context);
                break;
            case  1:
                dataList = equalLegAngelsController.getCatalogListForAdapter(context, position);
                clickListener.onItemClickListener(position, listView, mapOfTextView,imageOfSteel, context);
                break;
            case 2:
                dataList = rebarController.getCatalogListForAdapter(context, position);
                clickListener.onItemClickListener(position, listView, mapOfTextView,imageOfSteel, context);
                break;
            case 3:
                dataList = wireRodController.getCatalogListForAdapter(context, position);
                clickListener.onItemClickListener(position, listView, mapOfTextView,imageOfSteel, context);
                break;
            case 4:
                dataList = beadController.getCatalogListForAdapter(context, position);
                clickListener.onItemClickListener(position, listView, mapOfTextView,imageOfSteel, context);
                break;
            case 5:
                dataList = channelsController.getCatalogListForAdapter(context, position);
                clickListener.onItemClickListener(position, listView, mapOfTextView,imageOfSteel, context);
                break;
            case 11:
                dataList = squareBarsController.getCatalogListForAdapter(context, position);
                clickListener.onItemClickListener(position, listView, mapOfTextView,imageOfSteel, context);
                break;
            case 12:
                dataList = steelCircleController.getCatalogListForAdapter(context, position);
                clickListener.onItemClickListener(position, listView, mapOfTextView,imageOfSteel, context);
                break;
            case 14:
                dataList = hexahedronController.getCatalogListForAdapter(context, position);
                clickListener.onItemClickListener(position, listView, mapOfTextView,imageOfSteel, context);
                break;
        }
        return dataList;
    }
}
