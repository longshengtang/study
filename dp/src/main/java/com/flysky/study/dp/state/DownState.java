package com.flysky.study.dp.state;

public class DownState implements State {
    private final LiftContext context;

    public DownState(LiftContext liftContext) {
        this.context = liftContext;
    }

    @Override
    public void open() {
        System.out.println("打开-失败：电梯在下降！");
    }

    @Override
    public void close() {
        System.out.println("关闭-失败：电梯在下降！");
    }

    @Override
    public void up() {
        System.out.println("上升-失败：电梯在下降！");
    }

    @Override
    public void down() {
        System.out.println("下降-失败：电梯在下降！");
    }

    @Override
    public void stop() {
        System.out.println("停止-成功：电梯停止！");
        context.setCurrentState(context.getCloseStopState());
    }
}
