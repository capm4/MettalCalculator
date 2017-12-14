package ua.com.alexkrug.mettalcalculator.src.dao;



import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ua.com.alexkrug.mettalcalculator.src.dao.interfaceForExpListAdapterDAO.InterfaceForExpListAdapterDAO;
import ua.com.alexkrug.mettalcalculator.src.model.RectangularProfileTube;
import ua.com.alexkrug.mettalcalculator.src.model.SteelStrip;


public class SteelStripDAO extends AbstractDAO<SteelStrip> implements InterfaceForExpListAdapterDAO<SteelStrip> {
	private String filePath = "steelStrip.txt";
	private Context mContext;

	public SteelStripDAO(Context mContext) {
		this.mContext = mContext;
	}

	@Override
	public List<SteelStrip> getAll() {
		List<SteelStrip> steelStrip = new ArrayList<>();
		AssetManager am = mContext.getAssets();
		String line;
		try(BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(am.open(filePath))) ) {
			line = bufferedReader.readLine();
			while (line != null) {
				steelStrip.add(gson.fromJson(line, SteelStrip.class));
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
		return steelStrip;
	}

	public SteelStrip select(int id) {
		List<SteelStrip > steelStripStream = getAll();
		SteelStrip findSteelStrip  = steelStripStream.get(id);
		return findSteelStrip ;
	}

	@Override
	public List<SteelStrip> selectByThickness(Double thickness, List<SteelStrip> list) {
		List<SteelStrip> listOfSelectThickness = new ArrayList<SteelStrip>();
		for(SteelStrip steelStrip : list){
			if(steelStrip.getThickness().equals(thickness)){
				listOfSelectThickness.add(steelStrip);
			}
		}
		return listOfSelectThickness;
	}

	@Override
	public List<SteelStrip> selectByDimensions(Double width, Double height, List<SteelStrip> list) {
		return null;
	}

	@Override
	public List<Double> listOfThickness() {
		List<SteelStrip> list = getAll();
		List<Double> listOfThickness = new ArrayList<Double>();
		for(SteelStrip steelStrip : list ) {
			int size = listOfThickness.size();
			if(listOfThickness.size()== 0){
				listOfThickness.add(steelStrip.getThickness());
			}
			else if (listOfThickness.get(size-1) < steelStrip.getThickness()) {
				listOfThickness.add(steelStrip.getThickness());
			}
		}
		return listOfThickness;
	}
}
