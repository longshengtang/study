package com.flysky.study.dp.behavioral.command;

import com.google.gson.Gson;

import java.util.Stack;

public class RemoteController {

    public RemoteController() {
        int len = 6;
        onCommands = new Command[len];
        offCommands = new Command[len];
        for (int i = 0; i < len; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        historyCommand = new HistoryCommandStack(16);
    }

    public void setCommand(int index, Command onCommand, Command offCommand) {
        if (index < 0 || index >= onCommands.length) {
            throw new RuntimeException("超出命令索引");
        }
        onCommands[index] = onCommand;
        offCommands[index] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        historyCommand.push(deepCopy(onCommands[slot]));
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        historyCommand.push(deepCopy(offCommands[slot]));
    }

    public void undoButtonWasPushed() {
        historyCommand.pop().undo();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("------Remote Controller------\n");
        for (int i = 0; i < onCommands.length; i++) {
            sb.append("[slot " + i + "]" + onCommands[i].getClass().getCanonicalName() + " " + offCommands[i].getClass().getCanonicalName() + "\n");
        }
        for (int i = 0; i < historyCommand.size(); i++) {
            sb.append("[undo " + i + "]" + historyCommand.get(i).getClass().getCanonicalName() + "---" + getString(historyCommand.get(i)) + "\n");
        }
        return sb.toString();
    }

    public <T> T deepCopy(T t) {
        Gson gson = new Gson();
        return (T) gson.fromJson(gson.toJson(t), t.getClass());
    }

    public <T> String getString(T t) {
        return new Gson().toJson(t);
    }

    class HistoryCommandStack extends Stack<Command> {
        private int maxCount;

        public HistoryCommandStack(int maxCount) {
            this.maxCount = maxCount;
        }

        @Override
        public synchronized Command push(Command item) {
            if (size() >= maxCount) {
                remove(0);
            }
            return super.push(item);
        }

        @Override
        public synchronized Command pop() {
            if (size() == 0) {
                return noCommand;
            }
            return super.pop();
        }
    }

    private final NoCommand noCommand = new NoCommand();

    private Command[] onCommands;
    private Command[] offCommands;
    private HistoryCommandStack historyCommand;
}
