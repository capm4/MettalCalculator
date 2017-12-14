package ua.com.alexkrug.mettalcalculator;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Map;

import ua.com.alexkrug.mettalcalculator.src.adapter.ListOfMenu;
import ua.com.alexkrug.mettalcalculator.src.languageHelper.LocaleHelper;
import ua.com.alexkrug.mettalcalculator.src.adapter.ExpListAdapter;
import ua.com.alexkrug.mettalcalculator.src.adapter.SimpListAdapter;
import ua.com.alexkrug.mettalcalculator.src.adapter.ViewHandler;

public class CatalogActivity extends AppCompatActivity {
    final Context context = this;
    ListView mainList;
    ListView catalogueListSimpAdapt;
    ExpandableListView catalogueListExpSimpAdapt;
    LinearLayout.LayoutParams lParamsCatalogueListSimpAdapt;
    LinearLayout.LayoutParams lParamscatalogueListExpSimpAdapt;
    ExpListAdapter expListAdapter = new ExpListAdapter();
    SimpListAdapter simpListAdapter = new SimpListAdapter();
    Map<String, TextView> mapOfTextView;
    ViewHandler viewHandler = new ViewHandler();
    ImageView imageOfSteel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        catalogueListSimpAdapt = (ListView) findViewById(R.id.listSimplAdapter);
        catalogueListExpSimpAdapt = (ExpandableListView) findViewById(R.id.listExpSimplAdapter);
        mainList = (ListView) findViewById(R.id.mailList);
        lParamsCatalogueListSimpAdapt = (LinearLayout.LayoutParams)catalogueListSimpAdapt.getLayoutParams();
        lParamscatalogueListExpSimpAdapt = (LinearLayout.LayoutParams)catalogueListExpSimpAdapt.getLayoutParams();
        imageOfSteel = (ImageView)findViewById(R.id.imageOfSteel);
        String language = LocaleHelper.getLanguage(context);
        int list;
        if(language.equals("en")){
            list = R.array.main_list_en;
        }else {
            list = R.array.main_list_ru;
        }
        mapOfTextView = viewHandler.getMapOfTextViewForCatalog((TextView)findViewById(R.id.elemFirst),
                (TextView)findViewById(R.id.elemSecond),
                (TextView)findViewById(R.id.elemThird),
                (TextView)findViewById(R.id.elemFourth),
                (TextView)findViewById(R.id.elemFifth),
                (TextView)findViewById(R.id.elemSixth),
                (TextView)findViewById(R.id.elemSeventh),
                (TextView)findViewById(R.id.elemEighth));
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, list, android.R.layout.simple_list_item_1);

        mainList.setAdapter(adapter);
        mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int[] to={R.id.nameOfPositionList};
                int[] toTitle={R.id.nameOfTitle};
                int resource = R.layout.layouforpositionlist;
                int respurceTitle = R.layout.layoutfortitlelist;

                if(position == 6 || position == 7 || position == 8 ||position == 9 ||position == 10 ||position == 13){
                    catalogueListExpSimpAdapt.setAdapter(expListAdapter.getExpandableAdapter(position,context,respurceTitle,
                            toTitle,resource,to,mapOfTextView, imageOfSteel, catalogueListExpSimpAdapt));
                    lParamscatalogueListExpSimpAdapt.weight = 1;
                    lParamsCatalogueListSimpAdapt.weight = 0;
                } else{
                    catalogueListSimpAdapt.setAdapter(simpListAdapter.getAdapter(position, context, resource, to,catalogueListSimpAdapt, mapOfTextView, imageOfSteel));
                    lParamsCatalogueListSimpAdapt.weight = 1;
                    lParamscatalogueListExpSimpAdapt.weight = 0;
                }
            }
        });
    }
}
