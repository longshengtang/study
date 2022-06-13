package com.flysky.study.flink;

public class WordCount {
    private String word;
    private int count;

    public WordCount() {//pojo必须有无参构造函数
    }

    public WordCount(String word, int count) {
        this.word=word;
        this.count=count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "WordCount{" +
                "word='" + word + '\'' +
                ", count=" + count +
                '}';
    }
}
