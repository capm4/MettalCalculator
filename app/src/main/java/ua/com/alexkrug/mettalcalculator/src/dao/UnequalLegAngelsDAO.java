package ua.com.alexkrug.mettalcalculator.src.dao;



import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ua.com.alexkrug.mettalcalculator.src.model.UnequalLegAngels;


public class UnequalLegAngelsDAO extends AbstractDAO<UnequalLegAngels> {
	private String filePath = "unequalLegAngels.txt";
	private Context mContext;

	public UnequalLegAngelsDAO(Context mContext) {this.mContext = mContext;}

	@Override
	public List<UnequalLegAngels> getAll() {
		List<UnequalLegAngels> unequalLegAngels = new ArrayList<>();
		AssetManager am = mContext.getAssets();
		String line;
        try(BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(am.open(filePath))) ) {
            line = bufferedReader.readLine();
            while(line != null){
                unequalLegAngels.add(gson.fromJson(line, UnequalLegAngels.class));
                line = bufferedReader.readLine();
            }
            try{
                bufferedReader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return unequalLegAngels;
	}

	public UnequalLegAngels select(int id) {
		List<UnequalLegAngels> unequalLegAngelsStream = getAll();
        UnequalLegAngels findUnequalLegAngels = unequalLegAngelsStream.get(id);
		return findUnequalLegAngels;
	}
}
