package ua.com.alexkrug.mettalcalculator.src.dao;

import android.content.Context;
import android.content.res.AssetManager;
import ua.com.alexkrug.mettalcalculator.src.model.Bead;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class BeadDAO extends AbstractDAO<Bead> {
	private String filePath = "bead.txt";
	private Context mContext;

	public BeadDAO(Context mContext) {
		this.mContext = mContext;
	}

	@Override
	public List<Bead> getAll() {
		List<Bead> beads = new ArrayList<>();
		AssetManager am = mContext.getAssets();
		String line;
		try(BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(am.open(filePath))) ) {
			line = bufferedReader.readLine();
			while (line != null) {
				beads.add(gson.fromJson(line, Bead.class));
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
		return beads;
	}

	public Bead select(int id) {
		List<Bead> beadStream = getAll();
		Bead findBead = beadStream.get(id);
		return findBead;
	}
}
