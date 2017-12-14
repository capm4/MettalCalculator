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


public class RectangularProfileTubeDAO extends AbstractDAO<RectangularProfileTube> implements InterfaceForExpListAdapterDAO<RectangularProfileTube> {
	private String filePath = "rectangularProfileTube.txt";
	private Context mContext;

	public RectangularProfileTubeDAO(Context mContext) {
		this.mContext = mContext;
	}

	@Override
	public List<RectangularProfileTube> getAll() {
		List<RectangularProfileTube> rectangularProfileTube = new ArrayList<>();
		AssetManager am = mContext.getAssets();
		String line;
		try(BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(am.open(filePath))) ) {
			line = bufferedReader.readLine();
			while (line != null) {
				rectangularProfileTube.add(gson.fromJson(line, RectangularProfileTube.class));
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
		return rectangularProfileTube;
	}

	public RectangularProfileTube select(int id) {
		List<RectangularProfileTube> rectangularProfileTubeStream = getAll();
		RectangularProfileTube findRectangularProfileTube = rectangularProfileTubeStream.get(id);
		return findRectangularProfileTube;
	}

	@Override
	public List<RectangularProfileTube> selectByThickness(Double thickness, List<RectangularProfileTube> list) {
		return null;
	}

	@Override
	public List<RectangularProfileTube> selectByDimensions(Double width, Double height, List<RectangularProfileTube> list) {
		List<RectangularProfileTube> listOfSelectDimensions = new ArrayList<RectangularProfileTube>();
		for(RectangularProfileTube tube : list){
			if(tube.getWidth().equals(width) && tube.getHeight().equals(height)){
				listOfSelectDimensions.add(tube);
			}else if(tube.getWidth() > width){
				break;
			}
		}
		return listOfSelectDimensions;
	}

	@Override
	public List<Double> listOfThickness() {
		return null;
	}

	public List<RectangularProfileTube> listOfDimensions() {
		List<RectangularProfileTube> list = getAll();
		List<RectangularProfileTube> listOfDimensions = new ArrayList<RectangularProfileTube>();
		for(RectangularProfileTube tube : list ) {
			int size = listOfDimensions.size();
			if(listOfDimensions.size()== 0){
				RectangularProfileTube rectangularProfileTube = new RectangularProfileTube(tube.getWidth(),tube.getHeight());
				listOfDimensions.add(rectangularProfileTube);
			}
			else if (listOfDimensions.get(size-1).getWidth() < tube.getWidth() ||
					listOfDimensions.get(size-1).getHeight() < tube.getHeight())
					{
				RectangularProfileTube rectangularProfileTube = new RectangularProfileTube(tube.getWidth(),tube.getHeight());
				listOfDimensions.add(rectangularProfileTube);
			}
		}
		return listOfDimensions;
	}
}
