package ua.com.alexkrug.mettalcalculator.src.dao;



import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import ua.com.alexkrug.mettalcalculator.src.model.Hexahedron;


public class HexahedronDAO extends AbstractDAO<Hexahedron> {
	private String filePath = "hexahedron.txt";
	private Context mContext;

	public HexahedronDAO(Context mContext) {
		this.mContext = mContext;
	}

	@Override
	public List<Hexahedron> getAll() {
		List<Hexahedron> hexahedron = new ArrayList<>();
		AssetManager am = mContext.getAssets();
		String line;
		try(BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(am.open(filePath))) ) {
			line = bufferedReader.readLine();
			while (line != null) {
				hexahedron.add(gson.fromJson(line, Hexahedron.class));
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
		return hexahedron;
	}

	public Hexahedron select(int id) {
		List<Hexahedron> hexahedronStream = getAll();
		Hexahedron findHexahedron = hexahedronStream.get(id);
		return findHexahedron;
	}
}
