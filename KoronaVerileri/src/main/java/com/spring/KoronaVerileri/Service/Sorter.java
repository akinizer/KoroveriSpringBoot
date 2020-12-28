package com.spring.KoronaVerileri.Service;

import java.util.Arrays;
import java.util.List;

import com.spring.KoronaVerileri.Model.CaseModel;

public abstract class Sorter {
	
	//merge function
	private static void mergeByCity(List<CaseModel> cases, int l, int m, int r)	{
		//Prepare
		int n1 = m - l + 1;
		int n2 = r - m;
		
		String[] L = new String[n1];
		String[] R = new String[n2];

		for (int i = 0; i < n1; ++i) 	L[i] = cases.get(l + i).getIl();
		for (int j = 0; j < n2; ++j)	R[j] = cases.get(m + 1 + j).getIl();
		int i = 0, j = 0;

		// Merge Part
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i].compareTo(R[j])<=0) {
				cases.get(k).setIl(L[i]);
				i++;
			}
			else {
				cases.get(k).setIl(R[j]);
				j++;
			}
			k++;
		}
		
		while (i < n1) {
			cases.get(k).setIl(L[i]);
			i++;
			k++;
		}

		while (j < n2) {
			cases.get(k).setIl(R[j]);
			j++;
			k++;
		}
	}

	// sort function
	public static void sortByCity(List<CaseModel> cases, int l, int r)		{
		if (l < r) {
			int m = (l + r) / 2;
			sortByCity(cases, l, m);
			sortByCity(cases, m + 1, r);
			mergeByCity(cases, l, m, r);
		}
	}	
	
	/////////////////////////////////////////////////////////////////////////////////////
	//merge function
	private static void mergeByDate(List<CaseModel> cases, int l, int m, int r)	{
		//Prepare
		int n1 = m - l + 1;
		int n2 = r - m;
		
		String[] L = new String[n1];
		String[] R = new String[n2];

		for (int i = 0; i < n1; ++i) 	L[i] = cases.get(l + i).getTarih();
		for (int j = 0; j < n2; ++j)	R[j] = cases.get(m + 1 + j).getTarih();
		int i = 0, j = 0;

		// Merge Part
		int k = l;
		while (i < n1 && j < n2) {
			if (compareDates(L[i],R[j])<=0) {
				cases.get(k).setTarih(L[i]);
				i++;
			}
			else {
				cases.get(k).setTarih(R[j]);
				j++;
			}
			k++;
		}
		
		while (i < n1) {
			cases.get(k).setTarih(L[i]);
			i++;
			k++;
		}

		while (j < n2) {
			cases.get(k).setTarih(R[j]);
			j++;
			k++;
		}
	}

	// sort function
	public static void sortByDate(List<CaseModel> cases, int l, int r)		{
		if (l < r) {
			int m = (l + r) / 2;
			sortByDate(cases, l, m);
			sortByDate(cases, m + 1, r);
			mergeByDate(cases, l, m, r);
		}
	}
	
	private static int compareDates(String date1, String date2){
		List<Integer> dateFirst = getDateAssembler(date1);
		List<Integer> dateSecond = getDateAssembler(date2);
			
		//compare years
		if(dateFirst.get(2)<dateSecond.get(2)) {
			return -1;
		}
		else if(dateFirst.get(2)>dateSecond.get(2)) {
			return 1;
		}
		else {
			//compare months
			if(dateFirst.get(1)<dateSecond.get(1)) {
				return -1;
			}
			else if(dateFirst.get(1)>dateSecond.get(1)) {
				return 1;
			}
			else {
				if(dateFirst.get(0)<dateSecond.get(0)) {
					return -1;
				}
				else if(dateFirst.get(0)>dateSecond.get(0)) {
					return 1;
				}
				else return 0;
			}
		}		
	}
	
	private static List<Integer> getDateAssembler(String tarih) {
		String[] splitlist = tarih.split("-");
		int year = Integer.parseInt(splitlist[2]);
		int month = Integer.parseInt(splitlist[1]);
		int day = Integer.parseInt(splitlist[0]);
		return Arrays.asList(day,month,year);
	}

}
