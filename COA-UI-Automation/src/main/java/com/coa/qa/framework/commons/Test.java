package com.coa.qa.framework.commons;

public class Test {

    public static void main(String[] args) {

//        GMailAccess.getRefreshToken();

        String a = GMailAccess.getEmailContentsFor("dhossain@clearoneadvantage.com.com", "payload.body.data");

    }
}
