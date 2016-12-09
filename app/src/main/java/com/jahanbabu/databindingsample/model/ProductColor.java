package com.jahanbabu.databindingsample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductColor {

@SerializedName("hex_value")
@Expose
private String hexValue;
@SerializedName("colour_name")
@Expose
private String colourName;

/**
*
* @return
* The hexValue
*/
public String getHexValue() {
return hexValue;
}

/**
*
* @param hexValue
* The hex_value
*/
public void setHexValue(String hexValue) {
this.hexValue = hexValue;
}

/**
*
* @return
* The colourName
*/
public String getColourName() {
return colourName;
}

/**
*
* @param colourName
* The colour_name
*/
public void setColourName(String colourName) {
this.colourName = colourName;
}

}