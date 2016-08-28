package com.merlin.alexa.chrome.speechlet;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aaron on 8/28/2016.
 */
public class AlexaChrome extends SpeechletRequestStreamHandler {

    private static final Set<String> supportedApplicationIds;

    static {
        /*
         * This Id can be found on https://developer.amazon.com/edw/home.html#/ "Edit" the relevant
         * Alexa Skill and put the relevant Application Ids in this Set.
         */
        supportedApplicationIds = new HashSet<String>();
        supportedApplicationIds.add("amzn1.ask.skill.2be2212f-bb8f-4ffa-bd84-a86210c35e16");
    }

    public AlexaChrome() {
        super(new AlexaChromeSpeechlet(), supportedApplicationIds);
    }

}
