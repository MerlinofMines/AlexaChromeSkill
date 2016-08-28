package com.merlin.alexa.chrome.websockets;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by Aaron on 8/27/2016.
 */

@ServerEndpoint("/example")
public class ChromeExtension {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Chrome Extension WebSocket opened: " + session.getId());
        SocketManager.getInstance().addConnection(session);
    }

    @OnMessage
    public void onMessage(String txt, Session session) throws IOException {
        System.out.println("AlexaReceiver Message received: " + txt);
        SocketManager.getInstance().broadcast("replying back: " + txt.toUpperCase());
    }

    @OnClose
    public void onClose(CloseReason reason, Session session) {
        System.out.println("AlexaReceiver Closing a WebSocket due to " + reason.getReasonPhrase());
        SocketManager.getInstance().removeConnection(session);
    }
}
