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
import ua.com.alexkrug.mettalcalculator.src.model.ProfileTubeSquare;
import ua.com.alexkrug.mettalcalculator.src.model.RectangularProfileTube;


public class ProfileTubeSquareDAO extends AbstractDAO<ProfileTubeSquare> implements InterfaceForExpListAdapterDAO<ProfileTubeSquare> {
	private String filePath = "profileTubeSquare.txt";
	private Context mContext;

	public ProfileTubeSquareDAO(Context mContext) {
		this.mContext = mContext;
	}

	@Override
	public List<ProfileTubeSquare> getAll() {
		List<ProfileTubeSquare> profileTubeSquare = new ArrayList<>();
		AssetManager am = mContext.getAssets();
		String line;
		try(BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(am.open(filePath))) ) {
			line = bufferedReader.readLine();
			while (line != null) {
				profileTubeSquare.add(gson.fromJson(line, ProfileTubeSquare.class));
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
		return profileTubeSquare;
	}

	public ProfileTubeSquare select(int id) {
		List<ProfileTubeSquare> profileTubeSquareStream = getAll();
		ProfileTubeSquare findProfileTubeSquare  = profileTubeSquareStream.get(id);
		return findProfileTubeSquare;
	}

	@Override
	public List<ProfileTubeSquare> selectByThickness(Double thickness, List<ProfileTubeSquare> list) {
		return null;
	}

	@Override
	public List<ProfileTubeSquare> selectByDimensions(Double width, Double height, List<ProfileTubeSquare> list) {
		List<ProfileTubeSquare> listOfSelectDimensions = new ArrayList<ProfileTubeSquare>();
		for(ProfileTubeSquare profileTubeSquare : list){
			if(profileTubeSquare.getWidth().equals(width)){
				listOfSelectDimensions.add(profileTubeSquare);
			}else if(profileTubeSquare.getWidth() > width){
				break;
			}
		}
		return listOfSelectDimensions;
	}

	@Override
	public List<Double> listOfThickness() {
		List<ProfileTubeSquare> list = getAll();
		List<Double> listOfDimensions = new ArrayList<Double>();
		for(ProfileTubeSquare profileTubeSquare : list ) {
			int size = listOfDimensions.size();
			if(listOfDimensions.size()== 0){
				listOfDimensions.add(profileTubeSquare.getWidth());
			}
			else if (listOfDimensions.get(size-1) < profileTubeSquare.getWidth()) {
				listOfDimensions.add(profileTubeSquare.getWidth());
			}
		}
		return listOfDimensions;
	}
}
