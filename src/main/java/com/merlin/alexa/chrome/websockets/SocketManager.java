package com.merlin.alexa.chrome.websockets;

import javax.websocket.Session;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by Aaron on 8/27/2016.
 */
public class SocketManager {

    private static final SocketManager INSTANCE = new SocketManager();

    private List<Session> openConnections = Collections.synchronizedList(new ArrayList<Session>());

    public static SocketManager getInstance() {
        return INSTANCE;
    }

    public synchronized List<Session> getOpenConnections() {
        return this.openConnections;
    }

    public synchronized void addConnection(Session session) {
        openConnections.add(session);
    }
    public synchronized void removeConnection(Session session) {
        openConnections.remove(session);
    }

    public synchronized void broadcast(String text) {
        openConnections.stream().forEach(x -> {
            try {
                x.getBasicRemote().sendText(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public synchronized void sendMessage(String sessionId, String text) {
        Optional<Session> first = openConnections.stream().filter(x -> x.getId().equals(sessionId)).findFirst();

        if(first.isPresent()) {
            try {
                first.get().getBasicRemote().sendText(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Warn: Unable to find socket matching sessionId: " + sessionId);
        }
    }
}
