package kmitl.covid.lib.korn.kornutil;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;

public class KornJSON {
	public static JSONObject getJSONFromURL(String url) {
		InputStream is;
		try {
			is = new URL(url).openStream();
			try {
				BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
				String jsonText = KornJSON.readAll(rd);
				jsonText = jsonText.replace("[", "");
				jsonText = jsonText.replace("]", "");
				return new JSONObject(jsonText);
			} finally {
				is.close();
			}
		} catch (MalformedInputException | MalformedURLException e) {
			System.out.println("ERROR: Unable to connect from requested url (" + e.getMessage() + ")");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	private static String readAll(Reader rd) {
		StringBuilder stringBuilder = new StringBuilder();
		int cp;
		try {
			while ((cp = rd.read()) != -1)
				stringBuilder.append((char) cp);
		} catch (IOException e) {
			System.out.println("ERROR: Cannot read file from a reader (" + e.getMessage() + ")");
		}
		return stringBuilder.toString();
	}
}
