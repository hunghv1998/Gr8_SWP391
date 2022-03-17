/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebSocket;

import Model.Message;
import com.google.gson.Gson;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.util.logging.Logger;

/**
 *
 * @author chinh
 */
public class MessageDecoder implements Decoder.Text<Message> {

    private final Logger log = Logger.getLogger(getClass().getName());

    @Override
    public Message decode(String s) throws DecodeException {
        log.info("incoming message: " + s);
        
        Gson gson = new Gson();
        Message message = gson.fromJson(s, Message.class);
        return message;
    }

    @Override
    public boolean willDecode(String s) {
        return (s != null);
    }

    @Override
    public void init(EndpointConfig ec) {
        
    }

    @Override
    public void destroy() {
        
    }

}
