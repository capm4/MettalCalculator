package ua.com.alexkrug.mettalcalculator.src.dao;



import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import ua.com.alexkrug.mettalcalculator.src.model.EqualLegAngels;


public class EqualLegAngelsDAO extends AbstractDAO<EqualLegAngels>{
	private String filePath = "equalLegAngels.txt";
	private Context mContext;

	public EqualLegAngelsDAO(Context mContext) {
		this.mContext = mContext;
	}

	@Override
	public List<EqualLegAngels> getAll() {
		List<EqualLegAngels> equalLegAngels = new ArrayList<>();
		AssetManager am = mContext.getAssets();
		String line;
		try(BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(am.open(filePath))) ) {
			line = bufferedReader.readLine();
			while (line != null) {
				equalLegAngels.add(gson.fromJson(line, EqualLegAngels.class));
				line = bufferedReader.readLine();
			}
			try {
				bufferedReader.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}catch (IOException e1) {
			e1.printStackTrace();
		}
		return equalLegAngels;
	}

	public EqualLegAngels select(int id) {
		List<EqualLegAngels> equalLegAngelsStream = getAll();
		EqualLegAngels findEqualLegAngels = equalLegAngelsStream.get(id);
		return findEqualLegAngels;
	}
}
