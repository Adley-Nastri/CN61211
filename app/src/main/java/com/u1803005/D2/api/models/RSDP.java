
package com.u1803005.D2.api.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RSDP {

    @SerializedName("Response")
    @Expose
    public List<Response> response = null;
    @SerializedName("ErrorCode")
    @Expose
    public Integer errorCode;
    @SerializedName("ThrottleSeconds")
    @Expose
    public Integer throttleSeconds;
    @SerializedName("ErrorStatus")
    @Expose
    public String errorStatus;
    @SerializedName("Message")
    @Expose
    public String message;
    @SerializedName("MessageData")
    @Expose
    public MessageData messageData;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RSDP() {
    }

    /**
     * 
     * @param response
     * @param errorCode
     * @param errorStatus
     * @param throttleSeconds
     * @param message
     * @param messageData
     */
    public RSDP(List<Response> response, Integer errorCode, Integer throttleSeconds, String errorStatus, String message, MessageData messageData) {
        super();
        this.response = response;
        this.errorCode = errorCode;
        this.throttleSeconds = throttleSeconds;
        this.errorStatus = errorStatus;
        this.message = message;
        this.messageData = messageData;
    }

    public class Response {

        @SerializedName("iconPath")
        @Expose
        public String iconPath;
        @SerializedName("crossSaveOverride")
        @Expose
        public Integer crossSaveOverride;
        @SerializedName("isPublic")
        @Expose
        public Boolean isPublic;
        @SerializedName("membershipType")
        @Expose
        public Integer membershipType;
        @SerializedName("membershipId")
        @Expose
        public String membershipId;
        @SerializedName("displayName")
        @Expose
        public String displayName;

        /**
         * No args constructor for use in serialization
         *
         */
        public Response() {
        }

        /**
         *
         * @param membershipType
         * @param displayName
         * @param isPublic
         * @param crossSaveOverride
         * @param membershipId
         * @param iconPath
         */
        public Response(String iconPath, Integer crossSaveOverride, Boolean isPublic, Integer membershipType, String membershipId, String displayName) {
            super();
            this.iconPath = iconPath;
            this.crossSaveOverride = crossSaveOverride;
            this.isPublic = isPublic;
            this.membershipType = membershipType;
            this.membershipId = membershipId;
            this.displayName = displayName;
        }

    }

    public class MessageData {


    }




}
