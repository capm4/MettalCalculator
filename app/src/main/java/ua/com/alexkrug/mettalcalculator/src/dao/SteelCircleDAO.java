package ua.com.alexkrug.mettalcalculator.src.dao;



import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ua.com.alexkrug.mettalcalculator.src.model.SteelCircle;


public class SteelCircleDAO extends AbstractDAO<SteelCircle> {
	private String filePath = "steelCircle.txt";
	private Context mContext;

	public SteelCircleDAO(Context mContext) {
		this.mContext = mContext;
	}

	@Override
	public List<SteelCircle> getAll() {
		List<SteelCircle> steelCircles = new ArrayList<>();
		AssetManager am = mContext.getAssets();
		String line;
		try(BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(am.open(filePath))) ) {
			line = bufferedReader.readLine();
			while (line != null) {
				steelCircles.add(gson.fromJson(line, SteelCircle.class));
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
		return steelCircles;
	}

	public SteelCircle select(int id) {
		List<SteelCircle> SteelCircle = getAll();
		SteelCircle findSteelCircle  = SteelCircle.get(id);
		return findSteelCircle ;
	}
}
