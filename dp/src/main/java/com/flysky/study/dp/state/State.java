package com.flysky.study.dp.state;

public interface State {
    void open();

    void close();

    void up();

    void down();

    void stop();
}
