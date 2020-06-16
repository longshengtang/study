/*
 * Copyright 2015-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flysky.study.rsocket.stream.client;

import io.rsocket.*;
import io.rsocket.transport.netty.server.TcpServerTransport;
import io.rsocket.util.DefaultPayload;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public final class StreamingServer {

  public static void main(String[] args) throws InterruptedException {
    RSocketFactory.receive()
        .acceptor(new SocketAcceptorImpl())
        .transport(TcpServerTransport.create("localhost", 7000))
        .start().log("server---")
        .subscribe();
      TimeUnit.MINUTES.sleep(2250);
//    RSocket socket =
//        RSocketFactory.connect()
//            .transport(TcpClientTransport.create("localhost", 7000))
//            .start()
//            .block();
//
//    socket
//        .requestStream(DefaultPayload.create("Hello"))
//        .map(Payload::getDataUtf8)
//        .doOnNext(System.out::println)
//        .take(10)
//        .then()
//        .doFinally(signalType -> socket.dispose())
//        .then()
//        .block();
  }

  private static class SocketAcceptorImpl implements SocketAcceptor {
    @Override
    public Mono<RSocket> accept(ConnectionSetupPayload setupPayload, RSocket reactiveSocket) {
      return Mono.just(
          new AbstractRSocket() {
            @Override
            public Flux<Payload> requestStream(Payload payload) {
//              return Flux.interval(Duration.ofMillis(50))
              return Flux.interval(Duration.ofMillis(100))
                  .map(aLong -> DefaultPayload.create("Interval: " + aLong));
            }
          });
    }
  }
}
