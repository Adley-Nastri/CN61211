package com.u1803005.D2.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response_SearchDestinyPlayer {


    @Expose
    @SerializedName("MessageData")
    private MessageData MessageData;


    public static class Response {


        @SerializedName("iconPath")
        private String iconPath;

        @SerializedName("crossSaveOverride")
        private Integer crossSaveOverride;

        @SerializedName("isPublic")
        private Boolean isPublic;

        @SerializedName("membershipType")
        private int membershipType;

        @SerializedName("membershipId")
        private String membershipId;

        @SerializedName("displayName")
        private String displayName;

        public String getIconPath() {
            return iconPath;
        }

        public Integer getCrossSaveOverride() {
            return crossSaveOverride;
        }

        public Boolean getPublic() {
            return isPublic;
        }

        public int getMembershipType() {
            return membershipType;
        }

        public String getMembershipId() {
            return membershipId;
        }

        public String getDisplayName() {
            return displayName;
        }
    }


    public static class MessageData{

    }


}
