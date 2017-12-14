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
import ua.com.alexkrug.mettalcalculator.src.model.HotRolledSteel;
import ua.com.alexkrug.mettalcalculator.src.model.RectangularProfileTube;


public class HotRolledSteelDAO extends AbstractDAO<HotRolledSteel> implements InterfaceForExpListAdapterDAO<HotRolledSteel> {
	private String filePath = "hotRolledMetal.txt";
	private Context mContext;

	public HotRolledSteelDAO(Context mContext) {
		this.mContext = mContext;
	}

	@Override
	public List<HotRolledSteel> getAll() {
		List<HotRolledSteel> hotRolledSteel = new ArrayList<>();
		AssetManager am = mContext.getAssets();
		String line;
		try(BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(am.open(filePath))) ) {
			line = bufferedReader.readLine();
			while (line != null) {
				hotRolledSteel.add(gson.fromJson(line, HotRolledSteel.class));
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
		return hotRolledSteel;
	}

	public HotRolledSteel select(int id) {
		List<HotRolledSteel> hotRolledSteelStream = getAll();
		HotRolledSteel findHotRolledSteel = hotRolledSteelStream.get(id);
		return findHotRolledSteel;
	}


	@Override
	public List<HotRolledSteel> selectByThickness(Double thickness, List<HotRolledSteel> list) {
		List<HotRolledSteel> listOfSelectThickness = new ArrayList<HotRolledSteel>();
		for(HotRolledSteel hotRolledSteel : list){
			if(hotRolledSteel.getThickness().equals(thickness)){
				listOfSelectThickness.add(hotRolledSteel);
			}else if(hotRolledSteel.getThickness() > thickness){
				break;
			}
		}
		return listOfSelectThickness;
	}

	@Override
	public List<HotRolledSteel> selectByDimensions(Double width, Double height, List<HotRolledSteel> list) {
		return null;
	}

	@Override
	public List<Double> listOfThickness() {
		List<HotRolledSteel> list = getAll();
		List<Double> listOfThickness = new ArrayList<Double>();
		for(HotRolledSteel hotRolledSteel : list ) {
			int size = listOfThickness.size();
			if(listOfThickness.size()== 0){
				listOfThickness.add(hotRolledSteel.getThickness());
			}
			else if (listOfThickness.get(size-1) < hotRolledSteel.getThickness()) {
				listOfThickness.add(hotRolledSteel.getThickness());
			}
		}
		return listOfThickness;
	}
}
