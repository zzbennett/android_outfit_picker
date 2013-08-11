package com.bennett.androidoutfitpicker.models;

public class Garment {
	/*
	 * -attributes are:
	*clothing id (for primary key)
	*description/title
	*garment type
	*color 1
	*color 2
	*color 3
	*color 4
	*color 5
	*fabric 1
	*fabric 2
	*pattern
	*formalness
	*volume
	*weather appropriateness
	*times worn? for laundry feature
	 */

	private long _id;
	private String _description;

	private int _garmentType;
	private int _color1;
	private int _color2;
	private int _color3;
	private int _color4;
	private int _color5;
	private int _fabric1;
	private int _fabric2;
	private int _pattern;
	private int _formalness;
	private int _volume;
	private int _weather;
	private int _timesWorn;

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	//description is a few words describing the garment, not a paragraph
	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getGarmentType() {
		return _garmentType;
	}

	public void setGarmentType(int garmentType) {
		_garmentType = garmentType;
	}

	public int getColor1() {
		return _color1;
	}

	public void setColor1(int color1) {
		_color1 = color1;
	}

	public int getColor2() {
		return _color2;
	}

	public void setColor2(int color2) {
		_color2 = color2;
	}

	public int getColor3() {
		return _color3;
	}

	public void setColor3(int color3) {
		_color3 = color3;
	}

	public int getColor4() {
		return _color4;
	}

	public void setColor4(int color4) {
		_color4 = color4;
	}

	public int getColor5() {
		return _color5;
	}

	public void setColor5(int color5) {
		_color5 = color5;
	}

	public int getFabric1() {
		return _fabric1;
	}

	public void setFabric1(int fabric1) {
		_fabric1 = fabric1;
	}

	public int getFabric2() {
		return _fabric2;
	}

	public void setFabric2(int fabric2) {
		_fabric2 = fabric2;
	}

	public int getPattern() {
		return _pattern;
	}

	public void setPattern(int pattern) {
		_pattern = pattern;
	}

	public int getFormalness() {
		return _formalness;
	}

	public void setFormalness(int formalness) {
		_formalness = formalness;
	}

	public int getVolume() {
		return _volume;
	}

	public void setVolume(int volume) {
		_volume = volume;
	}

	public int getWeather() {
		return _weather;
	}

	public void setWeather(int weather) {
		_weather = weather;
	}

	public int getTimesWorn() {
		return _timesWorn;
	}

	public void setTimesWorn(int timesWorn) {
		_timesWorn = timesWorn;
	}


	// Will be used by the ArrayAdapter in the ListView
	@Override
	public String toString() {
	  return _description;
	}
}
