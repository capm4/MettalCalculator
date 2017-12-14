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
import ua.com.alexkrug.mettalcalculator.src.model.ColdRolledSteel;
import ua.com.alexkrug.mettalcalculator.src.model.RectangularProfileTube;


public class ColdRolledSteelDAO extends AbstractDAO<ColdRolledSteel> implements InterfaceForExpListAdapterDAO<ColdRolledSteel> {

	private String filePath = "coldRolledMetal.txt";
	private Context mContext;

	public ColdRolledSteelDAO(Context mContext) {
		this.mContext = mContext;
	}

	@Override
	public List<ColdRolledSteel> getAll() {
		List<ColdRolledSteel> coldRolledSteel = new ArrayList<>();
		AssetManager am = mContext.getAssets();
		String line;
		try(BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(am.open(filePath))) ) {
			line = bufferedReader.readLine();
			while (line != null) {
				coldRolledSteel.add(gson.fromJson(line, ColdRolledSteel.class));
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
		return coldRolledSteel;
	}

	public ColdRolledSteel select(int id) {
		List<ColdRolledSteel> coldRolledSteelStream = getAll();
		ColdRolledSteel findColdRolledSteel = coldRolledSteelStream.get(id);
		return findColdRolledSteel;
	}

	@Override
	public List<ColdRolledSteel> selectByThickness (Double thickness, List<ColdRolledSteel> list){
		List<ColdRolledSteel> listOfSelectThickness = new ArrayList<ColdRolledSteel>();
		for(ColdRolledSteel coldRolledSteel : list){
			if(coldRolledSteel.getThickness().equals(thickness)){
				listOfSelectThickness.add(coldRolledSteel);
			}else if(coldRolledSteel.getThickness() > thickness){
				break;
			}
		}
		return listOfSelectThickness;
	}

	@Override
	public List<ColdRolledSteel> selectByDimensions(Double width, Double height, List<ColdRolledSteel> list) {
		return null;
	}

	@Override
	public List<Double> listOfThickness(){
		List<ColdRolledSteel> list = getAll();
		List<Double> listOfThickness = new ArrayList<Double>();
		for(ColdRolledSteel coldRolledSteel : list ) {
			int size = listOfThickness.size();
			if(listOfThickness.size()== 0){
				listOfThickness.add(coldRolledSteel.getThickness());
			}
			else if (listOfThickness.get(size-1) < coldRolledSteel.getThickness()) {
				listOfThickness.add(coldRolledSteel.getThickness());
			}
		}
		return listOfThickness;
	}
}
