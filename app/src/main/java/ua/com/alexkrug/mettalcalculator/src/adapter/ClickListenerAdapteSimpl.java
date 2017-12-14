package ua.com.alexkrug.mettalcalculator.src.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import ua.com.alexkrug.mettalcalculator.R;
import ua.com.alexkrug.mettalcalculator.src.controller.BeadController;
import ua.com.alexkrug.mettalcalculator.src.controller.ChannelsController;
import ua.com.alexkrug.mettalcalculator.src.controller.EqualLegAngelsController;
import ua.com.alexkrug.mettalcalculator.src.controller.HexahedronController;
import ua.com.alexkrug.mettalcalculator.src.controller.RebarController;
import ua.com.alexkrug.mettalcalculator.src.controller.SquareBarsController;
import ua.com.alexkrug.mettalcalculator.src.controller.SteelCircleController;
import ua.com.alexkrug.mettalcalculator.src.controller.UnequalLegAngelsController;
import ua.com.alexkrug.mettalcalculator.src.controller.WireRodController;
import ua.com.alexkrug.mettalcalculator.src.model.Bead;
import ua.com.alexkrug.mettalcalculator.src.model.Channels;
import ua.com.alexkrug.mettalcalculator.src.model.EqualLegAngels;
import ua.com.alexkrug.mettalcalculator.src.model.Hexahedron;
import ua.com.alexkrug.mettalcalculator.src.model.Rebar;
import ua.com.alexkrug.mettalcalculator.src.model.SquareBars;
import ua.com.alexkrug.mettalcalculator.src.model.SteelCircle;
import ua.com.alexkrug.mettalcalculator.src.model.UnequalLegAngels;
import ua.com.alexkrug.mettalcalculator.src.model.WireRod;


public class ClickListenerAdapteSimpl {
    private final String LOG_TAG = "ClickListenerAdapteSimpl";
    private UnequalLegAngelsController unAngelcontroller = new UnequalLegAngelsController();
    private EqualLegAngelsController eqAngelsController = new EqualLegAngelsController();
    private RebarController rebarController = new RebarController();
    private WireRodController wireRodController = new WireRodController();
    private BeadController beadController = new BeadController();
    private ChannelsController chanelController = new ChannelsController();
    private SquareBarsController squareBarsConroller = new SquareBarsController();
    private HexahedronController hexahedronController = new HexahedronController();
    private SteelCircleController steelCircleController = new SteelCircleController();

    public void onItemClickListener(long position, ListView listView, Map<String, TextView> mapOfTextView,
                ImageView imageOfSteel, final Context context){
        TextView firth = mapOfTextView.get("First");
        TextView second = mapOfTextView.get("Second");
        TextView third = mapOfTextView.get("Third");
        TextView fourth = mapOfTextView.get("Fourth");
        TextView fifth = mapOfTextView.get("Fifth");
        TextView sixth = mapOfTextView.get("Sixth");
        TextView seventh = mapOfTextView.get("Seventh");
        TextView eighth = mapOfTextView.get("Eighth");
        switch ((int) position){
            case 0:{
                Log.d(LOG_TAG, "itemClick: id = " + position);
                cleanTextView(firth,second, third, fourth,fifth,sixth,seventh,eighth);
                setOnClickListenerUnAngels(listView, firth,second, third, fourth,fifth,sixth,seventh,imageOfSteel, context);
                break;
            }
            case 1:{
                Log.d(LOG_TAG, "itemClick: id = " + position);
                cleanTextView(firth,second, third, fourth,fifth,sixth,seventh,eighth);
                setOnClickListenerEqAngels(listView, firth,second, third, fourth,fifth,sixth,imageOfSteel, context);
                break;
            }
            case 2:{
                Log.d(LOG_TAG, "itemClick: id = " + position);
                cleanTextView(firth,second, third, fourth,fifth,sixth,seventh,eighth);
                setOnClickListenerRebar(listView, firth,second, third,context, imageOfSteel);
                break;
            }
            case 3:{
                Log.d(LOG_TAG, "itemClick: id = " + position);
                cleanTextView(firth,second, third, fourth,fifth,sixth,seventh,eighth);
                setOnClickListenerCircle(listView, firth,second, third,context, imageOfSteel,1);
                break;
            }
            case 4:{
                Log.d(LOG_TAG, "itemClick: id = " + position);
                cleanTextView(firth,second, third, fourth,fifth,sixth,seventh,eighth);
                setOnClickListenerBAC(listView, firth,second, third,fourth, fifth,sixth,seventh,eighth,
                        context, imageOfSteel,1);
                break;
            }
            case 5:{
                Log.d(LOG_TAG, "itemClick: id = " + position);
                cleanTextView(firth,second, third, fourth,fifth,sixth,seventh,eighth);
                setOnClickListenerBAC(listView, firth,second, third,fourth, fifth,sixth,seventh,eighth,
                        context, imageOfSteel,2);
                break;
            }
            case 11:{
                Log.d(LOG_TAG, "itemClick: id = " + position);
                cleanTextView(firth,second, third, fourth,fifth,sixth,seventh,eighth);
                setOnClickListenerSAH(listView, firth,second, third, context, imageOfSteel,1);
                break;
            }
            case 12:{
                Log.d(LOG_TAG, "itemClick: id = " + position);
                cleanTextView(firth,second, third, fourth,fifth,sixth,seventh,eighth);
                setOnClickListenerCircle(listView, firth,second, third,context, imageOfSteel,2);
                break;
            }
            case 14:{
                Log.d(LOG_TAG, "itemClick: id = " + position);
                cleanTextView(firth,second, third, fourth,fifth,sixth,seventh,eighth);
                setOnClickListenerSAH(listView, firth,second, third, context, imageOfSteel,2);
                break;
            }
         }
    }

    private void setOnClickListenerUnAngels(ListView listView, final TextView first, final TextView second,
                                           final TextView third,final TextView fourth, final TextView fifth,
                                           final TextView sixth, final TextView seventh,
                                           final ImageView imageOfSteel, final Context context){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Log.d(LOG_TAG, "UnequalLegAngels itemClick: position = " + position + ", id = "+ id);
                UnequalLegAngels element = unAngelcontroller.getById(context, position);
                Double weight = new BigDecimal(element.getWeight()).setScale(2, RoundingMode.UP).doubleValue();
                first.setText(context.getString(R.string.Width)+"(b): "+element.getWidth().toString());
                first.setPadding(5,20,0,5);
                second.setText(context.getString(R.string.Height)+"(h): "+element.getHeight().toString());
                second.setPadding(5,5,0,5);
                third.setText( context.getString(R.string.Thickness)+"(S): "+element.getThickness().toString());
                third.setPadding(5,5,0,5);
                fourth.setText(context.getString(R.string.Radius)+"(R): "+element.getInnerRadius().toString());
                fourth.setPadding(5,5,0,5);
                fifth.setText(context.getString(R.string.Radius)+"(r): "+element.getShelfRoundingRadius().toString());
                fifth.setPadding(5,5,0,5);
                sixth.setText(context.getString(R.string.WeightOfMeter)+": " +weight.toString()+" kg.");
                sixth.setPadding(5,5,0,5);
                seventh.setText(context.getString(R.string.MetersInTone)+": "+element.getMetersInTone().toString());
                seventh.setPadding(5,5,0,0);
                imageOfSteel.setImageResource(R.drawable.unangel);
            }
        });
    }

    private void setOnClickListenerEqAngels(ListView listView, final TextView first, final TextView second,
                                           final TextView third,final TextView fourth, final TextView fifth,
                                           final TextView sixth,final ImageView imageOfSteel, final Context context){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Log.d(LOG_TAG, "EqualLegAngels itemClick: position = " + position + ", id = "+ id);
                EqualLegAngels element = eqAngelsController.getById(context, position);
                Double weight = new BigDecimal(element.getWeight()).setScale(2, RoundingMode.UP).doubleValue();
                first.setText(context.getString(R.string.Width)+"(b): "+element.getWidth().toString());
                first.setPadding(5,20,0,5);
                second.setText(context.getString(R.string.Thickness)+"(S): "+element.getThickness().toString());
                second.setPadding(5,5,0,5);
                third.setText(context.getString(R.string.Radius)+"(R): "+element.getInnerRadius().toString());
                third.setPadding(5,5,0,5);
                fourth.setText(context.getString(R.string.Radius)+"(r): "+element.getShelfRoundingRadius().toString());
                fourth.setPadding(5,5,0,5);
                fifth.setText(context.getString(R.string.WeightOfMeter)+": " +weight.toString()+" kg.");
                fifth.setPadding(5,5,0,5);
                sixth.setText(context.getString(R.string.MetersInTone)+": "+element.getMetersInTone().toString());
                sixth.setPadding(5,5,0,0);
                imageOfSteel.setImageResource(R.drawable.eqangel);
            }
        });
    }
    private void setOnClickListenerRebar(ListView listView, final TextView first, final TextView second,
                                        final TextView third,final Context context,
                                        final ImageView imageOfSteel ){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Log.d(LOG_TAG, "Rebar itemClick: position = " + position + ", id = "+ id);
                Rebar element = rebarController.getById(context, position);
                first.setText(context.getString(R.string.Diameter)+": "+element.getRadius().toString());
                first.setPadding(5,70,0,5);
                Double weight = new BigDecimal(element.getWeight()).setScale(2, RoundingMode.UP).doubleValue();
                second.setText(context.getString(R.string.WeightOfMeter)+": " +weight.toString()+" kg.");
                second.setPadding(5,5,0,5);
                third.setText(context.getString(R.string.MetersInTone)+": "+element.getMetersInTone().toString());
                third.setPadding(5,5,0,5);
                imageOfSteel.setImageResource(R.drawable.rebar);
            }
        });
    }
    private void setOnClickListenerCircle(ListView listView, final TextView first, final TextView second,
                                          final TextView third, final Context context,
                                          final ImageView imageOfSteel,
                                          final int elementPosition ){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Log.d(LOG_TAG, "Circle itemClick: position = " + position + ", id = "+ id);
                @NotNull Double circleDiameter = null;
                @NotNull Double circleWeight = null;
                @NotNull Double circleMetersInTone = null;
                switch (elementPosition) {
                    case 1: {
                        Log.d(LOG_TAG, "WireRod: position = " + position + ", id = "+ id);
                        WireRod element = wireRodController.getById(context, position);
                        circleDiameter =element.getRadius();
                        circleWeight = element.getWeight();
                        circleMetersInTone = element.getMetersInTone();
                        imageOfSteel.setImageResource(R.drawable.circle);
                        break;
                    }
                    case 2:{
                        Log.d(LOG_TAG, "SteelCircle: position = " + position + ", id = "+ id);
                        SteelCircle element = steelCircleController.getById(context, position);
                        circleDiameter =element.getRadius();
                        circleWeight = element.getWeight();
                        circleMetersInTone = element.getMetersInTone();
                        imageOfSteel.setImageResource(R.drawable.circle);
                        break;
                    }
                }
                first.setText(context.getString(R.string.Diameter)+": "+circleDiameter.toString());
                first.setPadding(5,70,0,5);
                Double weight = new BigDecimal(circleWeight).setScale(2, RoundingMode.UP).doubleValue();
                second.setText(context.getString(R.string.WeightOfMeter)+": " +weight.toString()+" kg.");
                second.setPadding(5,5,0,5);
                third.setText(context.getString(R.string.MetersInTone)+": "+circleMetersInTone.toString());
                third.setPadding(5,5,0,5);
            }
        });
    }

    private void setOnClickListenerBAC(ListView listView, final TextView first, final TextView second,
                                       final TextView third, final TextView fourth, final TextView fifth,
                                       final TextView sixth, final TextView seventh, final TextView eighth,
                                       final Context context,
                                       final ImageView imageOfSteel, final int elementPosition) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Log.d(LOG_TAG, "BAC itemClick: position = " + position + ", id = "+ id);
                @NotNull String bacNumber = new String();
                @NotNull Double bacWidth = null;
                @NotNull Double bacHeight = null;
                @NotNull Double bacThickness = null;
                @NotNull Double bacInRadius = null;
                @NotNull Double bacSheRadius = null;
                @NotNull Double bacWeight = null;
                @NotNull Double bacMetersInTone = null;
                switch (elementPosition) {
                    case 1: {
                        Bead element = beadController.getById(context, position);
                        bacNumber = element.getNumber();
                        bacWidth = element.getWidth();
                        bacHeight = element.getHeight();
                        bacThickness = element.getThickness();
                        bacInRadius = element.getInnerRadius();
                        bacSheRadius = element.getShelfRoundingRadius();
                        bacWeight = element.getWeightOfMeter();
                        bacMetersInTone = element.getMetersInTone();
                        imageOfSteel.setImageResource(R.drawable.bean);
                        break;
                    }
                    case 2: {
                        Channels element = chanelController.getById(context, position);
                        bacNumber = element.getNumber();
                        bacWidth = element.getWidth();
                        bacHeight = element.getHeight();
                        bacThickness = element.getThickness();
                        bacInRadius = element.getInnerRadius();
                        bacSheRadius = element.getShelfRoundingRadius();
                        bacWeight = element.getWeightOfMeter();
                        bacMetersInTone = element.getMetersInTone();
                        imageOfSteel.setImageResource(R.drawable.cheanel);
                        break;
                    }
                }
                first.setText("№ "+ bacNumber.toString());
                first.setPadding(3,5,0,3);
                second.setText(context.getString(R.string.Width)+"(b): "+bacWidth.toString());
                second.setPadding(3,5,0,3);
                third.setText(context.getString(R.string.Height)+"(h): "+bacHeight.toString());
                third.setPadding(3,5,0,3);
                fourth.setText(context.getString(R.string.Thickness)+"(S): "+bacThickness.toString());
                fourth.setPadding(3,5,0,3);
                fifth.setText(context.getString(R.string.Radius)+"(R): "+bacInRadius.toString());
                fifth.setPadding(3,5,0,3);
                sixth.setText(context.getString(R.string.Radius)+"(r): "+bacSheRadius.toString());
                sixth.setPadding(3,5,0,3);
                Double weight = new BigDecimal(bacWeight).setScale(2, RoundingMode.UP).doubleValue();
                seventh.setText(context.getString(R.string.WeightOfMeter)+": "+weight.toString()+"kg.");
                seventh.setPadding(3,5,0,3);
                eighth.setText(context.getString(R.string.MetersInTone)+": "+bacMetersInTone.toString());
                eighth.setPadding(3,5,0,3);;
            }
        });
    }
    private void setOnClickListenerSAH(ListView listView, final TextView first, final TextView second,
                                       final TextView third,final Context context, final ImageView imageOfSteel,
                                       final int elementPosition) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Log.d(LOG_TAG, "SAH itemClick: position = " + position + ", id = "+ id);
                @NotNull Double sahWidth = null;
                @NotNull Double sahWeight = null;
                @NotNull Double sahMetersInTone = null;
                switch (elementPosition) {
                    case 1: {
                        SquareBars element = squareBarsConroller.getById(context, position);
                        sahWidth = element.getWidth();
                        sahWeight = element.getWeight();
                        sahMetersInTone = element.getMetersInTone();
                        imageOfSteel.setImageResource(R.drawable.sqeabar);
                        break;
                    }
                    case 2: {
                        Hexahedron element = hexahedronController.getById(context, position);
                        sahWidth = element.getWidth();
                        sahWeight = element.getWeight();
                        sahMetersInTone = element.getMetersInTone();
                        imageOfSteel.setImageResource(R.drawable.hexahedron);
                        break;
                    }
                }
                first.setText(context.getString(R.string.Width)+"(a): "+sahWidth.toString());
                first.setPadding(5,70,0,5);
                Double weight = new BigDecimal(sahWeight).setScale(2, RoundingMode.UP).doubleValue();
                second.setText(context.getString(R.string.WeightOfMeter)+": "+weight.toString()+"kg.");
                second.setPadding(5,5,0,5);
                third.setText(context.getString(R.string.MetersInTone)+": "+sahMetersInTone.toString());
                third.setPadding(5,5,0,5);
            }
        });
    }

    protected void cleanTextView(TextView fist, TextView second, TextView third, TextView fourth, TextView fifth, TextView sixth, TextView seventh, TextView eighth) {
        fist.setText(null);
        second.setText(null);
        third.setText(null);
        fourth.setText(null);
        fifth.setText(null);
        sixth.setText(null);
        seventh.setText(null);
        eighth.setText(null);
    }
}
