package com.example.truongkhanh.ofmusicapp.Model.ModelSQLite;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Banner {

@SerializedName("ID_BANNER")
@Expose
private String idbanner;
@SerializedName("NAME_BANNER")
@Expose
private String namebanner;
@SerializedName("LINK_IMG")
@Expose
private String linkimg;

public String getIDBANNER() {
return idbanner;
}

public void setIDBANNER(String iDBANNER) {
this.idbanner = iDBANNER;
}

public String getNAMEBANNER() {
return namebanner;
}

public void setNAMEBANNER(String nAMEBANNER) {
this.namebanner = nAMEBANNER;
}

public String getLINKIMG() {
return linkimg;
}

public void setLINKIMG(String linkIMG) {
this.linkimg = linkIMG;
}

}