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
import ua.com.alexkrug.mettalcalculator.src.model.RoundTube;


public class RoundTubeDAO extends  AbstractDAO<RoundTube> implements InterfaceForExpListAdapterDAO<RoundTube> {
	private String filePath = "roundTube.txt";
	private Context mContext;

	public RoundTubeDAO(Context mContext) {
		this.mContext = mContext;
	}

	@Override
	public List<RoundTube> getAll() {
		List<RoundTube> roundTube = new ArrayList<>();
		AssetManager am = mContext.getAssets();
		String line;
		try(BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(am.open(filePath))) ) {
			line = bufferedReader.readLine();
			while (line != null) {
				roundTube.add(gson.fromJson(line, RoundTube.class));
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
		return roundTube;
	}

	public RoundTube select(int id) {
		List<RoundTube> roundTubeStream = getAll();
		RoundTube findRoundTube = roundTubeStream.get(id);
		return findRoundTube;
	}

	@Override
	public List<RoundTube> selectByThickness(Double thickness, List<RoundTube> list) {
		return null;
	}

	@Override
	public List<RoundTube> selectByDimensions(Double width, Double height, List<RoundTube> list) {
		List<RoundTube> listOfSelectDimensions = new ArrayList<RoundTube>();
		for(RoundTube roundTube : list){
			if(roundTube.getRadius().equals(width)){
				listOfSelectDimensions.add(roundTube);
			}else if(roundTube.getRadius() > width){
				break;
			}
		}
		return listOfSelectDimensions;
	}

	@Override
	public List<Double> listOfThickness() {
		List<RoundTube> list = getAll();
		List<Double> listOfDimensions = new ArrayList<Double>();
		for(RoundTube roundTube : list ) {
			int size = listOfDimensions.size();
			if(listOfDimensions.size()== 0){
				listOfDimensions.add(roundTube.getRadius());
			}
			else if (listOfDimensions.get(size-1) < roundTube.getRadius()) {
				listOfDimensions.add(roundTube.getRadius());
			}
		}
		return listOfDimensions;
	}
}
