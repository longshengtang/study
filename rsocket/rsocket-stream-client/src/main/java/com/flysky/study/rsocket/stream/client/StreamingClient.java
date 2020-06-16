///*
// * Copyright 2015-2018 the original author or authors.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package com.flysky.study.rsocket.stream.client;
//
//import io.rsocket.Payload;
//import io.rsocket.RSocket;
//import io.rsocket.RSocketFactory;
//import io.rsocket.transport.netty.client.TcpClientTransport;
//import io.rsocket.util.DefaultPayload;
//
//public final class StreamingClient {
//
//  public static void main(String[] args) throws InterruptedException {
//
//      RSocket socket =
//              RSocketFactory.connect()
//                      .transport(TcpClientTransport.create("localhost", 7000))
//                      .start().log("client----")
//                      .block();
//
//      socket
//              .requestStream(DefaultPayload.create("Hello")).log("client-socket---")
//              .map(Payload::getDataUtf8)
//              .doOnNext(System.out::println)
//              .take(10)
//              .then()
//              .doFinally(signalType -> socket.dispose())
//              .then()
//              .block();
//  }
//
//}
