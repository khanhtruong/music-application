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
@SerializedName("ID_IMG")
@Expose
private String idimg;
@SerializedName("PATH_BAI_HAT")
@Expose
private String pathbaihat;

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

public String getIDIMG() {
return idimg;
}

public void setIDIMG(String iDIMG) {
this.idimg = iDIMG;
}

public String getPATHBAIHAT() {
return pathbaihat;
}

public void setPATHBAIHAT(String pATHBAIHAT) {
this.pathbaihat = pATHBAIHAT;
}

}