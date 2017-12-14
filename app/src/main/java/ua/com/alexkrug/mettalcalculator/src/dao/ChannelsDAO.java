package ua.com.alexkrug.mettalcalculator.src.dao;

import android.content.Context;
import android.content.res.AssetManager;
import ua.com.alexkrug.mettalcalculator.src.model.Channels;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ChannelsDAO extends AbstractDAO {
	private String filePath = "channels.txt";
	private Context mContext;


	public ChannelsDAO(Context Context) {
		this.mContext = Context;
	}

	@Override
	public List<Channels> getAll() {
		List<Channels> channel = new ArrayList<>();
		AssetManager am = mContext.getAssets();
		String line;
		try(BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(am.open(filePath))) ) {
			line = bufferedReader.readLine();
			while (line != null) {
				channel.add(gson.fromJson(line, Channels.class));
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
		return channel;
	}

	public Channels select(int id) {
		List<Channels> channelsStream = getAll();
		Channels findChannels = channelsStream.get(id);
		return findChannels;
	}

}

