package com.becomedigital.sdk.identity.becomedigitalsdk.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class ResponseIV implements Parcelable, Serializable {

    public static final int ERROR = 2;
    public static final int PENDING = 1;
    public static final int SUCCES = 0;
    private String id;
    private String created_at;
    private String company;
    private String fullname;
    private String birth;
    private String document_type;
    private String document_number;
    private Boolean face_match;
    private Boolean template;
    private Boolean alteration;
    private Boolean watch_list;
    private String comply_advantage_result;
    private String comply_advantage_url;
    private String verification_status;
    private String message;
    private Integer responseStatus;


    public ResponseIV(Integer responseStatus, String message) {
        this.responseStatus = responseStatus;
        this.message = message;
    }

    public ResponseIV(String id, String created_at, String company, String fullname, String birth, String document_type, String document_number, Boolean face_match, Boolean template, Boolean alteration, Boolean watch_list, String comply_advantage_result, String comply_advantage_url, String verification_status, String message, Integer responseStatus) {
        this.id = id;
        this.created_at = created_at;
        this.company = company;
        this.fullname = fullname;
        this.birth = birth;
        this.document_type = document_type;
        this.document_number = document_number;
        this.face_match = face_match;
        this.template = template;
        this.alteration = alteration;
        this.watch_list = watch_list;
        this.comply_advantage_result = comply_advantage_result;
        this.comply_advantage_url = comply_advantage_url;
        this.verification_status = verification_status;
        this.message = message;
        this.responseStatus = responseStatus;
    }

    protected ResponseIV(Parcel in) {
        id = in.readString ( );
        created_at = in.readString ( );
        company = in.readString ( );
        fullname = in.readString ( );
        birth = in.readString ( );
        document_type = in.readString ( );
        document_number = in.readString ( );
        byte tmpFace_match = in.readByte ( );
        face_match = tmpFace_match == 0 ? null : tmpFace_match == 1;
        byte tmpTemplate = in.readByte ( );
        template = tmpTemplate == 0 ? null : tmpTemplate == 1;
        byte tmpAlteration = in.readByte ( );
        alteration = tmpAlteration == 0 ? null : tmpAlteration == 1;
        byte tmpWatch_list = in.readByte ( );
        watch_list = tmpWatch_list == 0 ? null : tmpWatch_list == 1;
        comply_advantage_result = in.readString ( );
        comply_advantage_url = in.readString ( );
        verification_status = in.readString ( );
        message = in.readString ( );
        if (in.readByte ( ) == 0) {
            responseStatus = null;
        } else {
            responseStatus = in.readInt ( );
        }
    }

    public static final Creator<ResponseIV> CREATOR = new Creator<ResponseIV> ( ) {
        @Override
        public ResponseIV createFromParcel(Parcel in) {
            return new ResponseIV (in);
        }

        @Override
        public ResponseIV[] newArray(int size) {
            return new ResponseIV[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getDocument_type() {
        return document_type;
    }

    public void setDocument_type(String document_type) {
        this.document_type = document_type;
    }

    public String getDocument_number() {
        return document_number;
    }

    public void setDocument_number(String document_number) {
        this.document_number = document_number;
    }

    public Boolean getFace_match() {
        return face_match;
    }

    public void setFace_match(Boolean face_match) {
        this.face_match = face_match;
    }

    public Boolean getTemplate() {
        return template;
    }

    public void setTemplate(Boolean template) {
        this.template = template;
    }

    public Boolean getAlteration() {
        return alteration;
    }

    public void setAlteration(Boolean alteration) {
        this.alteration = alteration;
    }

    public Boolean getWatch_list() {
        return watch_list;
    }

    public void setWatch_list(Boolean watch_list) {
        this.watch_list = watch_list;
    }

    public String getComply_advantage_result() {
        return comply_advantage_result;
    }

    public void setComply_advantage_result(String comply_advantage_result) {
        this.comply_advantage_result = comply_advantage_result;
    }

    public String getComply_advantage_url() {
        return comply_advantage_url;
    }

    public void setComply_advantage_url(String comply_advantage_url) {
        this.comply_advantage_url = comply_advantage_url;
    }

    public String getVerification_status() {
        return verification_status;
    }

    public void setVerification_status(String verification_status) {
        this.verification_status = verification_status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(Integer responseStatus) {
        this.responseStatus = responseStatus;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString (id);
        parcel.writeString (created_at);
        parcel.writeString (company);
        parcel.writeString (fullname);
        parcel.writeString (birth);
        parcel.writeString (document_type);
        parcel.writeString (document_number);
        parcel.writeByte ((byte) (face_match == null ? 0 : face_match ? 1 : 2));
        parcel.writeByte ((byte) (template == null ? 0 : template ? 1 : 2));
        parcel.writeByte ((byte) (alteration == null ? 0 : alteration ? 1 : 2));
        parcel.writeByte ((byte) (watch_list == null ? 0 : watch_list ? 1 : 2));
        parcel.writeString (comply_advantage_result);
        parcel.writeString (comply_advantage_url);
        parcel.writeString (verification_status);
        parcel.writeString (message);
        if (responseStatus == null) {
            parcel.writeByte ((byte) 0);
        } else {
            parcel.writeByte ((byte) 1);
            parcel.writeInt (responseStatus);
        }
    }
}
