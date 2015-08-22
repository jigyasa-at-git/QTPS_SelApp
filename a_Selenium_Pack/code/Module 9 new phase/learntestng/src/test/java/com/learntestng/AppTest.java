package com.learntestng;

import org.testng.annotations.Test;

// run java file from command prompt - maven
// run testng.xml from maven cmd line
// surefire reports with maven
// xslt reports with maven

/*
 * 
 * 
mvn archetype:generate
mvn eclipse:eclipse
generate M2_REPO var
mvn compile
mvn eclipse:eclipse

mvn test
mvn surefire-report:report 
 */
public class AppTest 
   
{
    @Test
    public void sendMail(){
    	System.out.println("*********App Test22***********");
    	
    }
}
