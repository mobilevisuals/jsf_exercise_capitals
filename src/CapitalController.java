/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Admin
 */
@Named(value = "capitalController")
@SessionScoped
public class CapitalController implements Serializable {

    private String answer = "";
    private String guess = "";
    int i = 0;
    final private String[][] stateCapitals = {{"Alabama", "Montgomery"},
            {"Alaska", "Juneau"}, {"Arizona", "Phoenix"},
            {"Arkansas", "Little Rock"}, {"California", "Sacramento"},
            {"Colorado", "Denver"}, {"Connecticut", "Hartford"},
            {"Delaware", "Dover"}, {"Florida", "Tallahassee"},
            {"Georgia", "Atlanta"}, {"Hawaii", "Honolulu"}, {"Idaho", "Boise"},
            {"Illinois", "Springfield"}, {"Maryland", "Annapolis"},
            {"Minnesota", "Saint Paul"},
            {"Iowa", "Des Moines"}, {"Maine", "Augusta"},
            {"Kentucky", "Frankfort"}, {"Indiana", "Indianapolis"},
            {"Kansas", "Topeka"}, {"Louisiana", "Baton Rouge"},
            {"Oregon", "Salem"}, {"Oklahoma", "Oklahoma City"},
            {"Ohio", "Columbus"}, {"North Dakota", "Bismark"},
            {"New York", "Albany"}, {"New Mexico", "Santa Fe"},
            {"New Jersey", "Trenton"}, {"New Hampshire", "Concord"},
            {"Nevada", "Carson City"}, {"Nebraska", "Lincoln"},
            {"Montana", "Helena"}, {"Missouri", "Jefferson City"},
            {"Mississippi", "Jackson"}, {"Massachusettes", "Boston"},
            {"Michigan", "Lansing"}, {"Pennslyvania", "Harrisburg"},
            {"Rhode Island", "Providence"}, {"South Carolina", "Columbia"},
            {"South Dakota", "Pierre"}, {"Tennessee", "Nashville"},
            {"Texas", "Austin"}, {"Utah", "Salt Lake City"},
            {"Vermont", "Montpelier"}, {"Virginia", "Richmond"},
            {"Washington", "Olympia"}, {"West Virginia", "Charleston"},
            {"Wisconsin", "Madison"}, {"Wyoming", "Cheyenne"}
    };
    List list = Arrays.asList(stateCapitals);
    /**
     * Creates a new instance of CapitalController
     */
    public CapitalController() {

        Collections.shuffle(list);
    }


    public String getAnswer() {
        evaluateGuess();
        return answer;
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public String getQuestion() {
        return "What is the capital of " + stateCapitals[i][0] + "?";
    }

    //Evaluates the guess, forms the correct answer, and resets
    //the guess
    private void evaluateGuess() {
        answer = "";
        if (guess.toLowerCase().equals(stateCapitals[i][1].toLowerCase())) {
            answer += "Yes. The capital of " + stateCapitals[i][0]
                    + " is " + stateCapitals[i][1] + ".";
            guess = "";
        } else {
            answer += "No. The capital of " + stateCapitals[i][0]
                    + " is " + stateCapitals[i][1] + ".";
            guess = "";
        }
    }


    public String next() {
        if (getGuess().trim().length() == 0) {
            return null;
        } else {
            return "page2";
        }
    }

    public String goToMainPage() {
        i = (i + 1) % stateCapitals.length;
        return "index";
    }

}