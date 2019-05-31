package com.myapp.eip;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String,LocalDate>{

	public LocalDateAdapter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public LocalDate unmarshal(String v) throws Exception {
		// TODO Auto-generated method stub
		return LocalDate.parse(v);
	}

	@Override
	public String marshal(LocalDate v) throws Exception {
		// TODO Auto-generated method stub
		return v.toString();
	}

}
