package com.flysky.study.dp.state;

public class StopCloseState implements State {
    private final LiftContext context;

    public StopCloseState(LiftContext liftContext) {
        this.context = liftContext;
    }

    @Override
    public void open() {
        System.out.println("打开-成功：电梯打开了！");
        context.setCurrentState(context.getOpenStopState());
    }

    @Override
    public void close() {
        System.out.println("关闭-失败：电梯已经关闭！");
    }

    @Override
    public void up() {
        System.out.println("上升-成功：电梯开始上升了！");
        context.setCurrentState(context.getCloseUpState());
    }

    @Override
    public void down() {
        System.out.println("下降-成功：电梯开始下降了！");
        context.setCurrentState(context.getCloseDownState());
    }

    @Override
    public void stop() {
        System.out.println("停止-失败：电梯已经停止！");
    }
}
