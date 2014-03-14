package com.json.project2;

import org.json.JSONException;
import org.json.JSONObject;

import com.myenum.project2.Users;

public class Json {
		//ArrayList<String>_userTags;
		
		public static JSONObject buildJSON(){
			
		// Create user object
		JSONObject usersObject = new JSONObject();
		try {
			// Create query
			JSONObject queryObject = new JSONObject();

			// Create user object in query
			for (Users user : Users.values()) {

				// Create user info
				JSONObject infoObject = new JSONObject();

				// add info object
				infoObject.put("name", user.setName());
				infoObject.put("status", user.setStatus());
				infoObject.put("reason", user.setReason());
				infoObject.put("score", user.setScore());
				queryObject.put(user.name().toString(), infoObject);

			}

			usersObject.put("query", queryObject);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usersObject;

	}
		
		public static String readJSON (String selected){
			
			String results, name, status, reason, score;
			
			JSONObject object = buildJSON();
			
			try {
				name = object.getJSONObject("query").getJSONObject(selected).getString("name");
				status = object.getJSONObject("query").getJSONObject(selected).getString("status");
				reason = object.getJSONObject("query").getJSONObject(selected).getString("reason");
				score = object.getJSONObject("query").getJSONObject(selected).getString("score");
				
				results = "Name:" + name + "\r\n"
						+"Status:" + status + "\r\n"
						+"Reason:" + reason + "\r\n"
						+"Score:" + score + "\r\n";
			
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				results = e.toString();
			}
		
			
				
			return results;
		}
}
