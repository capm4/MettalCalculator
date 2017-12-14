package ua.com.alexkrug.mettalcalculator.src.dao;


import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ua.com.alexkrug.mettalcalculator.src.model.WireRod;


public class WireRodDAO extends AbstractDAO<WireRod> {
	private String filePath = "wireRod.txt";
	private Context mContext;

	public WireRodDAO(Context mContext) {
		this.mContext = mContext;
	}

	@Override
	public List<WireRod> getAll() {
		List<WireRod> wireRods = new ArrayList<>();
		AssetManager am = mContext.getAssets();
		String line;
		try(BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(am.open(filePath))) ) {
			line = bufferedReader.readLine();
			while (line != null) {
				wireRods.add(gson.fromJson(line, WireRod.class));
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
		return wireRods;
	}

	public WireRod select(int id) {
		List<WireRod> wireRodStream = getAll();
		WireRod findWireRod = wireRodStream.get(id);
		return findWireRod;
	}
}
