package ua.com.alexkrug.mettalcalculator.src.dao;



import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ua.com.alexkrug.mettalcalculator.src.model.SquareBars;


public class SquareBarsDAO extends AbstractDAO<SquareBars> {
	private String filePath = "squareBars.txt";
	private Context mContext;

	public SquareBarsDAO(Context mContext) {
		this.mContext = mContext;
	}

	@Override
	public List<SquareBars> getAll() {
		List<SquareBars> squareBars = new ArrayList<>();
		AssetManager am = mContext.getAssets();
		String line;
		try(BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(am.open(filePath))) ) {
			line = bufferedReader.readLine();
			while (line != null) {
				squareBars.add(gson.fromJson(line, SquareBars.class));
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
		return squareBars;
	}

	public SquareBars select(int id) {
		List<SquareBars> squareBarsStream = getAll();
		SquareBars findSquareBars  = squareBarsStream.get(id);
		return findSquareBars ;
	}
}
