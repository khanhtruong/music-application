package com.example.truongkhanh.ofmusicapp.Model.ModelSQLite;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Album {

@SerializedName("ID_ALBUM")
@Expose
private String idalbum;
@SerializedName("NAME_ALBUM")
@Expose
private String namealbum;
@SerializedName("ID_IMG")
@Expose
private String idimg;

public String getIDALBUM() {
return idalbum;
}

public void setIDALBUM(String iDALBUM) {
this.idalbum = iDALBUM;
}

public String getNAMEALBUM() {
return namealbum;
}

public void setNAMEALBUM(String nAMEALBUM) {
this.namealbum = nAMEALBUM;
}

public String getIDIMG() {
return idimg;
}

public void setIDIMG(String iDIMG) {
this.idimg = iDIMG;
}

}