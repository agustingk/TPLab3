package json;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONException;

public class JsonUtiles {
	public static void grabar(JSONArray array, String fileName) {
		try {
			FileWriter file = new FileWriter(fileName + ".json");
			file.write(array.toString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String leer(String file) {
		String contenido = "";
		try {
			contenido = new String(Files.readAllBytes(Paths.get(file + ".json")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contenido;
	}
}