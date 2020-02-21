package com.flysky.study.rsocket.interaction.model;

import io.rsocket.RSocket;
import io.rsocket.RSocketFactory;
import io.rsocket.transport.netty.client.TcpClientTransport;
import io.rsocket.util.DefaultPayload;
import lombok.extern.slf4j.Slf4j;

import static com.flysky.study.rsocket.interaction.model.Server.HOST;
import static com.flysky.study.rsocket.interaction.model.Server.PORT;

@Slf4j
public class RequestResponse {

    public static void main(String[] args) {
        RSocket socket = RSocketFactory.connect().transport(TcpClientTransport.create(HOST, PORT))
                .start()
                .block();

        socket.requestResponse(DefaultPayload.create("Jenny"))
                .doOnNext(payload -> log.info("Received response payload:[{}] metadata:[{}]",
                        payload.getDataUtf8(),
                        payload.getMetadataUtf8()))
                .block();

        socket.dispose();
    }

}
