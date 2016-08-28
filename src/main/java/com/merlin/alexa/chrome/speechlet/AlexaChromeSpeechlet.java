package com.merlin.alexa.chrome.speechlet;

import com.amazon.speech.speechlet.*;

/**
 * Created by Aaron on 8/28/2016.
 */
public class AlexaChromeSpeechlet implements Speechlet {
    @Override
    public void onSessionStarted(SessionStartedRequest sessionStartedRequest, Session session) throws SpeechletException {

    }

    @Override
    public SpeechletResponse onLaunch(LaunchRequest launchRequest, Session session) throws SpeechletException {
        return null;
    }

    @Override
    public SpeechletResponse onIntent(IntentRequest intentRequest, Session session) throws SpeechletException {
        return null;
    }

    @Override
    public void onSessionEnded(SessionEndedRequest sessionEndedRequest, Session session) throws SpeechletException {

    }
}
