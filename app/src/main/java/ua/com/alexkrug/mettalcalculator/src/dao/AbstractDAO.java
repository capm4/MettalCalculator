package ua.com.alexkrug.mettalcalculator.src.dao;


import android.os.Build;
import android.support.annotation.RequiresApi;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ua.com.alexkrug.mettalcalculator.src.model.*;

public abstract class AbstractDAO<T> {
	Gson gson = new Gson();
	private String filePath;

	@RequiresApi(api = Build.VERSION_CODES.KITKAT)
	public void insert (T itemToInsert){
		filePath = getFilePath(itemToInsert);
		List<T> itemList = new ArrayList<T>();

		if(!itemList.contains(itemToInsert)){
			String line = gson.toJson(itemToInsert);
			try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))){
				bufferedWriter.write(line);
				bufferedWriter.newLine();
			}catch (IOException e){
				e.printStackTrace();
			}
		}
	}

	private String getFilePath(T itemToInsert) {
		if(itemToInsert instanceof ProfileTubeSquare){
			return "profileTubeSquare.txt";
		}
		if(itemToInsert instanceof Bead){
			return "bead.txt";
		}
		if(itemToInsert instanceof Channels){
			return "channels.txt";
		}
		if(itemToInsert instanceof ColdRolledSteel){
			return "coldRolledMetal.txt";
		}
		if(itemToInsert instanceof EqualLegAngels){
			return "equalLegAngels.txt";
		}
		if(itemToInsert instanceof HotRolledSteel){
			return "hotRolledMetal.txt";
		}
		if(itemToInsert instanceof Rebar){
			return "rebar.txt";
		}
		if(itemToInsert instanceof RoundTube){
			return "roundTube.txt";
		}
		if(itemToInsert instanceof SquareBars){
			return "squareBars.txt";
		}
		if(itemToInsert instanceof SteelCircle){
			return "steelCircle.txt";
		}
		if(itemToInsert instanceof UnequalLegAngels){
			return "unequalLegAngels.txt";
		}
		if(itemToInsert instanceof WireRod){
			return "wireRod.txt";
		}
		return "";
	}


	public void delete (T itemToDelete){
		filePath = getFilePath(itemToDelete);
		List<T> itemList = new ArrayList<T>();
		File DBFile = new File(filePath);
		File tmpFile = new File(filePath + "_tmp");
		if (itemList.contains(itemToDelete)){
			itemList.remove(itemToDelete);
			for(T metal : itemList){
				String line = gson.toJson(metal);
				try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tmpFile, true))){
					bufferedWriter.write(line);
					bufferedWriter.newLine();
				}catch (IOException e){
					e.printStackTrace();
				}
			}
		}
		DBFile.delete();
		tmpFile.renameTo(DBFile);
	}

	public List<T> getAll(){
		return null;
	}
}
