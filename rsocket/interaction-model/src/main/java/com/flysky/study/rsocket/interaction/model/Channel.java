package com.flysky.study.rsocket.interaction.model;

import io.rsocket.RSocketFactory;
import io.rsocket.transport.netty.client.TcpClientTransport;
import io.rsocket.util.DefaultPayload;
import reactor.core.publisher.Flux;

import java.time.Duration;

import static com.flysky.study.rsocket.interaction.model.Server.HOST;
import static com.flysky.study.rsocket.interaction.model.Server.PORT;

public class Channel {

    public static void main(String[] args) {
        RSocketFactory.connect()
                .transport(TcpClientTransport.create(HOST, PORT))
                .start()
                .block()
                .requestChannel(Flux.interval(Duration.ofMillis(100))
                        .map(time -> DefaultPayload.create("Jenny")))
                .blockLast();
    }

}
