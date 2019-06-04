package com.flysky.study.dp.state;

public class LiftContext {

    public void open() {
        currentState.open();
    }


    public void close() {
        currentState.close();
    }

    public void up() {
        currentState.up();
    }

    public void stop() {
        currentState.stop();
    }

    public void down() {
        currentState.down();
    }

    public State getCloseStopState() {
        return closeStopState;
    }

    public void setCloseStopState(State closeStopState) {
        this.closeStopState = closeStopState;
    }

    public State getCloseDownState() {
        return closeDownState;
    }

    public void setCloseDownState(State closeDownState) {
        this.closeDownState = closeDownState;
    }

    public State getCloseUpState() {
        return closeUpState;
    }

    public void setCloseUpState(State closeUpState) {
        this.closeUpState = closeUpState;
    }

    public State getOpenStopState() {
        return openStopState;
    }

    public void setOpenStopState(State openStopState) {
        this.openStopState = openStopState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    @Override
    public String toString() {
        StringBuffer sb =new StringBuffer();
        sb.append("------Lift Context------\n");
        sb.append("当前状态："+currentState.getClass().getCanonicalName());
        return sb.toString();
    }

    private State closeStopState = new StopCloseState(this);
    private State closeDownState = new DownState(this);
    private State closeUpState = new UpState(this);
    private State openStopState = new StopOpenState(this);

    private State currentState = closeStopState;
}
