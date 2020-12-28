package com.spring.KoronaVerileri.Model;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CaseModel")
public class CaseModel {
	@Id
	private ObjectId _id;
	
	private String tarih;
	private String il;
	private int vaka;
	private int vefat;
	private int taburcu;
	
	public CaseModel() {
		
	}

	public CaseModel(String tarih, String il, int vaka, int vefat, int taburcu) {
		this.tarih = tarih;
		this.il = il;
		this.vaka = vaka;
		this.vefat = vefat;
		this.taburcu = taburcu;
	}

	public ObjectId getId() {
		return _id;
	}

	public void setId(ObjectId _id) {
		this._id = _id;
	}

	public String getTarih() {
		return tarih;
	}
	
	public List<Integer> getDatelist() {
		String[] splitlist = tarih.split("-");
		int year = Integer.parseInt(splitlist[0]);
		int month = Integer.parseInt(splitlist[1]);
		int day = Integer.parseInt(splitlist[2]);
		return Arrays.asList(day,month,year);
	}
	

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}
	
	

	public String getIl() {
		return il;
	}

	public void setIl(String il) {
		this.il = il;
	}

	public int getVaka() {
		return vaka;
	}

	public void setVaka(int vaka) {
		this.vaka = vaka;
	}

	public int getVefat() {
		return vefat;
	}

	public void setVefat(int vefat) {
		this.vefat = vefat;
	}

	public int getTaburcu() {
		return taburcu;
	}

	public void setTaburcu(int taburcu) {
		this.taburcu = taburcu;
	}
	
	@Override
	public String toString() {
		return tarih + " : " + il + " : " + vaka + " : " + " : " + vefat + " : " + taburcu;
	}
}