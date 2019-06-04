package com.flysky.study.dp.behavioral.state;

public class StopOpenState implements State {
    private final LiftContext context;

    public StopOpenState(LiftContext liftContext) {
        this.context = liftContext;
    }

    @Override
    public void open() {
        System.out.println("打开-失败：电梯已经打开了！");
    }

    @Override
    public void close() {
        System.out.println("关闭-成功：电梯关闭！");
        context.setCurrentState(context.getCloseStopState());
    }

    @Override
    public void up() {
        System.out.println("上升-失败：请先关闭电梯！");
    }

    @Override
    public void down() {
        System.out.println("上升-失败：请先关闭电梯！");
    }

    @Override
    public void stop() {
        System.out.println("停止-失败：电梯已经停止！");
    }
}
