package com.coa.qa.framework.commons;

import java.util.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.apache.commons.codec.binary.Base64;

public class GMailAccess {

    static String token ;

    /**+
     * This method hits the gmail api and gets a new refresh token which is assigned to the class variable 'token'
     */
    public static void getRefreshToken(String clientId, String clientSecret, String refresh_token){

        try {
            Response response = RestAssured.given().header("Content-Type", "application/x-www-form-urlencoded")
                    .formParam("client_id", clientId)
                    .formParam("client_secret", clientSecret)
                    .formParam("refresh_token", refresh_token)
                    .formParam("grant_type", "refresh_token").request().post("https://www.googleapis.com/oauth2/v4/token");

            token = response.body().jsonPath().get("access_token");

            System.out.println("Current Refresh Token --> \n" + token);
            System.out.println("Response -> ");

        }catch(Exception e){

            System.out.println("Exception in getting refresh token \n");
            e.printStackTrace();

        }

    }

    /**+
     * This method deletes all the existing emails in the inbox of the test account
     */
    public static void deleteAllMails(){

//        getRefreshToken();

        Map<String,Object> requestParams = new HashMap<String,Object>();

        requestParams.put("ids", getMessageIDs());

        //		System.out.println("Map ->" +requestParams.toString());

        Response response1 = RestAssured.given().header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(requestParams)
                .request().post("https://www.googleapis.com/gmail/v1/users/bssqa2019@gmail.com/messages/batchDelete");


        System.out.println("Response Code for delete emails request -> " +response1.getStatusCode());

    }

    /**+
     * This method returns  the messageIDs for all the emails currently in the inbox
     */
    public static ArrayList<String> getMessageIDs() {

        ArrayList<String> idList = new ArrayList<String>();

        List<Object> oList  = new ArrayList<Object>();

        Response response = RestAssured.given().header("Authorization", "Bearer " + token)
                .request().get("https://www.googleapis.com/gmail/v1/users/bssqa2019@gmail.com/messages");

        oList =  response.body().jsonPath().get("messages");

        if(oList == null)
            System.out.println("Inbox is empty");

        else {

            for(int i = 0; i < oList.size(); i++) {

                Map<String, Object> jo = (Map<String, Object>)  oList.get(i);

                idList.add(String.valueOf(jo.get("id")));
            }
        }

        System.out.println("ID List -> \n"+idList);
        return idList;

    }

    /**+
     * This method returns the html text of the first multi part email addressed to the given emailID
     * @param emailID
     * @return
     */

    public static String getEmailContentsMultiPart(String emailID){

        Response response = RestAssured.given().header("Authorization", "Bearer " + token)
                .request().get("https://www.googleapis.com/gmail/v1/users/bssqa2019@gmail.com/messages/"+getFirstMessageID(emailID));

        // Getting the encoded email message from the request.

        String encodedBody1 = response.body().jsonPath().get("payload.parts[0].body.data");
        String encodedBody2 = response.body().jsonPath().get("payload.parts[1].body.data");

        byte[] deCodedText1 = Base64.decodeBase64(encodedBody1);
        byte[] deCodedText2 = Base64.decodeBase64(encodedBody2);

        return new String(deCodedText1) + new String(deCodedText2);

    }

    /**+
     * This method returns the html text of the first part of the email addressed to the given emailID
     * @param emailID
     * @return
     */

    public static String getEmailContentsFirstPart(String emailID){

        Response response = RestAssured.given().header("Authorization", "Bearer " + token)
                .request().get("https://www.googleapis.com/gmail/v1/users/bssqa2019@gmail.com/messages/"+getFirstMessageID(emailID));

        // Getting the encoded email message from the request.

        String encodedBody1 = response.body().jsonPath().get("payload.parts[0].body.data");

        byte[] deCodedText1 = Base64.decodeBase64(encodedBody1);

        return new String(deCodedText1);

    }

    /**+
     * This method returns the html text of the first email addressed to the given emailID based on jsonpath to the html content
     * @param emailID
     * @return
     */

    public static String getEmailContentsFor(String emailID, String jsonpath){

        Response response = RestAssured.given().header("Authorization", "Bearer " + token)
                .request().get("https://www.googleapis.com/gmail/v1/users/bssqa2019@gmail.com/messages/"+getFirstMessageID(emailID));

        // Getting the encoded email message from the request.

        String encodedBody = response.body().jsonPath().get(jsonpath);

        byte[] deCodedText = Base64.decodeBase64(encodedBody);

        return new String(deCodedText);

    }




    /**+
     * This method returns the html text of the first single part email addressed to the given emailID
     * @param emailID
     * @return
     */

    public static String getEmailContents(String emailID){

        Response response = RestAssured.given().header("Authorization", "Bearer " + token)
                .request().get("https://www.googleapis.com/gmail/v1/users/bssqa2019@gmail.com/messages/"+getFirstMessageID(emailID));

        // Getting the encoded email message from the request.

        String encodedBody = response.body().jsonPath().get("payload.parts.body.data");

        byte[] deCodedText = Base64.decodeBase64(encodedBody);

        return new String(deCodedText);

    }

    /**+
     * This method returns the message ID of the first email addressed to an emailID
     * @param emailID
     */
    public static String getFirstMessageID(String emailID) {

        Response response = RestAssured.given().header("Authorization", "Bearer " + token)
                .queryParam("q", emailID)
                .request().get("https://www.googleapis.com/gmail/v1/users/bssqa2019@gmail.com/messages");

        return response.body().jsonPath().get("messages[0].id");
    }

    /**+
     * This method returns the message IDs of all the emails addressed to an emailID
     * @param emailID
     */
    public static void getAllMessageIDs(String emailID) {

        Response response = RestAssured.given().header("Authorization", "Bearer " + token)
                .queryParam("q", emailID)
                .request().get("https://www.googleapis.com/gmail/v1/users/bssqa2019@gmail.com/messages");

        System.out.println("->" +response.body().jsonPath().get("messages.id"));
        ;
    }





}
