package com.example.truongkhanh.ofmusicapp.Model.ModelSQLite;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaiHat {

@SerializedName("ID_BAI_HAT")
@Expose
private String idbaihat;
@SerializedName("NAME_BAI_HAT")
@Expose
private String namebaihat;
@SerializedName("NAME_CA_SI")
@Expose
private String namecasi;
@SerializedName("LINK_IMG")
@Expose
private String linkimg;
@SerializedName("LINK_BAI_HAT")
@Expose
private String linkbaihat;

public String getIDBAIHAT() {
return idbaihat;
}

public void setIDBAIHAT(String iDBAIHAT) {
this.idbaihat = iDBAIHAT;
}

public String getNAMEBAIHAT() {
return namebaihat;
}

public void setNAMEBAIHAT(String nAMEBAIHAT) {
this.namebaihat = nAMEBAIHAT;
}

public String getNAMECASI() {
return namecasi;
}

public void setNAMECASI(String nAMECASI) {
this.namecasi = nAMECASI;
}

public String getLINKIMG() {
return linkimg;
}

public void setLINKIMG(String lINKIMG) {
this.linkimg = lINKIMG;
}

public String getLINKBAIHAT() {
return linkbaihat;
}

public void setLINKBAIHAT(String lINKBAIHAT) {
this.linkbaihat = lINKBAIHAT;
}

}