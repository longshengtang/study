package com.flysky.study.dp.principle.ocp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Spy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class OcpTest {
    private DrawShape draw;
    @Spy
    private Circle circle;
    @Spy
    private Square square;

    @Before
    public void setUp() {
        initMocks(this);
        draw = new DrawShape();
        draw.addShape(circle);
        draw.addShape(square);
        draw.addShape2(circle);
        draw.addShape2(square);
    }

    @Test
    public void test_add_two_shape() {
        assertThat(draw.shapes()).hasSize(2);
        assertThat(draw.shapes()).describedAs("没有同时包含圆和正方形图形").contains(circle,square);
    }

    @Test
    public void test_drawAllShapes() {
        draw.drawAllShapes();
        verify(circle, times(1)).draw();
        verify(square, times(1)).draw();
    }

    @Test
    public void test_drawShapes() {
        draw.drawShapes();
        verify(circle, times(1)).draw();
        verify(square, times(1)).draw();
    }
}
