package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import to.AccountTO;
import to.StatementTO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonFacade {
	
	public static StringBuilder toJson(HttpServletRequest request)
			throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line).append('\n');
			}
		} finally {
			reader.close();
		}
		return sb;
	}

	public static AccountTO jsonToAccountTO(String json) throws IOException{
		AccountTO accTO = null;
		try{
			JSONObject registro = new JSONObject(json);
			accTO = new AccountTO();
			accTO.setAgency(registro.getString("agency"));
			accTO.setAccount(registro.getString("account"));
			accTO.setPassword(registro.getString("password"));
		} catch(JSONException jsone){
			jsone.printStackTrace();
			//throw new IOException(jsone);
		}
		return accTO;
	}
	
	public static double getOfJson(String json, String key) throws IOException{
		try{
			JSONObject registro = new JSONObject(json);
			return registro.getDouble(key);
		} catch(JSONException jsone){
			jsone.printStackTrace();
			throw new IOException(jsone);
		}
	}
	
	public static String listToJsonArray(ArrayList<StatementTO> statementTO){
		JSONArray array = new JSONArray();
		for(StatementTO sto : statementTO){
			try{
				JSONObject json = new JSONObject();
				json.put("data", sto.getData());
				json.put("operacao", sto.getOperacao());
				json.put("valor", sto.getValor());
				array.put(json);
			}catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return array.toString();
	}

	public static String errorToJSon(Exception e) {
		JSONObject object = new JSONObject();
		try {
			object.put("error", e.toString());
		} catch (JSONException e1) {
			e.printStackTrace();
		}
		return object.toString();
	}
}
