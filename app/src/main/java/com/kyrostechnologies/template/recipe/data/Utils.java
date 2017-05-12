package com.kyrostechnologies.template.recipe.data;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

public class Utils {

	private static String KEY_LIS_ID = "KEY_LIS_ID";

	public static void addFavoriteId(Context ctx, String id){
		if(!isIdExist(ctx, id)) {
			List<String> listId = getListId(ctx);
			listId.add(id);
			saveListId(listId, ctx);
		}
	}
	public static void delFavoriteId(Context ctx, String id){
		List<String> listId = getListId(ctx);
		for (int i = 0; i < listId.size(); i++) {
			if(listId.get(i).equals(id)){
				listId.remove(i);
			}
		}
		saveListId(listId, ctx);
	}

	public static boolean isIdExist(Context ctx, String id){
		List<String> listId = getListId(ctx);
		for (int i = 0; i < listId.size(); i++) {
			if(listId.get(i).equals(id)){
				return true;
			}
		}
		return false;
	}

	public static List<String> getFavorites(Context ctx){
		return getListId(ctx);
	}

	private static void saveListId(List<String> listId, Context context){
		String s="";
		for (int i = 0; i < listId.size(); i++) {
			s = s + listId.get(i)+"|";
		}
		setStringPref(KEY_LIS_ID, s, context);
	}

	private static List<String> getListId(Context context){
		String s = getStringPref(KEY_LIS_ID, "null" , context);
		return split(s);
	}

	private static List<String> split(String s){
		// split by "|"
		List<String> list = new ArrayList<>();
		if(!s.equals("null")){
			for (int i = 0; i < s.split("\\|").length; i++) {
				list.add(s.split("\\|")[i]);
			}
		}
		return list;
	}

	/**
	 * Universal shared preference
	 * for string
	 */
	private static String getStringPref(String key_val, String def_val, Context context) {
		SharedPreferences pref = context.getSharedPreferences("pref_" + key_val, context.MODE_PRIVATE);
		return pref.getString(key_val, def_val);
	}

	private static void setStringPref(String key_val, String val, Context context) {
		SharedPreferences pref = context.getSharedPreferences("pref_"+key_val,context.MODE_PRIVATE);
		SharedPreferences.Editor prefEditor = pref.edit();
		prefEditor.clear();
		prefEditor.putString(key_val, val);
		prefEditor.commit();
	}

}
