package ua.com.alexkrug.mettalcalculator.src.dao;



import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ua.com.alexkrug.mettalcalculator.src.model.Rebar;


public class RebarDAO extends AbstractDAO<Rebar> {
	private String filePath = "rebar.txt";
	private Context mContext;

	public RebarDAO(Context mContext) {
		this.mContext = mContext;
	}

	@Override
	public List<Rebar> getAll() {
		List<Rebar> rebars = new ArrayList<>();;
		AssetManager am = mContext.getAssets();
		String line;
		try(BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(am.open(filePath))) ) {
			line = bufferedReader.readLine();
			while (line != null) {
				rebars.add(gson.fromJson(line, Rebar.class));
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
		return rebars;
	}

	public Rebar select(int id) {
		List<Rebar> rebarStream = getAll();
		Rebar findRebar = rebarStream.get(id);
		return findRebar;
	}
}
