package com.flysky.study.interview;

import java.util.Arrays;

public class Arithmetic {

	// void merge(int[] arr,int p ,int q,int r) {
	public static void merge(int[] arr, int low, int mid, int high) {
		System.out.println("上次排序结果及此次排序之前：" + Arrays.toString(arr));
		int len = mid - low + 1;
		int[] left = new int[len + 1];// 比自己长度大1
		len = high - mid;
		int[] right = new int[len + 1];// 比自己长度大1
		int i = 0;
		for (i = 0; i < left.length - 1; i++) {
			left[i] = arr[low + i];// 分配元素:low...mid
		}
		left[left.length - 1] = Integer.MAX_VALUE;
		int j = 0;
		for (j = 0; j < right.length - 1; j++) {
			right[j] = arr[mid + 1 + j];// 分配元素:mid+1...high
		}
		right[right.length - 1] = Integer.MAX_VALUE;
		StringBuffer sb = new StringBuffer();
		sb.append(getIntArrStr(arr, low, high));
		System.out.print("此次待排序元素" + sb);
		sb = new StringBuffer();// 清空
		sb.append("被分成两组" + getIntArrStr(left, 0, left.length - 2) + "和"
				+ getIntArrStr(right, 0, right.length - 2));
		System.out.println(sb);
		System.out.println();
		sb = new StringBuffer();// 清空
		j = 0;
		i = 0;
		int k = low;
		for (; i < left.length && j < right.length; k++) {
			if (left[i] < right[j]) {
				if (left[i] != Integer.MAX_VALUE)
					arr[k] = left[i];
				i++;
			} else {
				if (right[j] != Integer.MAX_VALUE)
					arr[k] = right[j];
				j++;
			}
		}
	}// merge

	private static String getIntArrStr(int[] arr, int low, int high) {
		StringBuffer sb = new StringBuffer();
		int i;
		// char separator='';//简单字符类型没有空
		String separator = "";// 分隔点位符
		sb.append("[");
		for (i = low; i <= high; i++) {
			sb.append(separator + arr[i]);
			separator = ",";
		}
		sb.append("]");
		return sb.toString();
	}

	public static void mergeSort(int[] arr, int low, int high) {// 用分治法对arr[low..high]进行二路归并排序
		int mid;
		if (low < high) {// 区间长度大于1
			mid = (low + high) / 2; // 分解
			mergeSort(arr, low, mid); // 递归地对左排序
			mergeSort(arr, mid + 1, high); // 递归地对右排序
			merge(arr, low, mid, high); // 合并,将两个有序区归并为一个有序区
		}
	}// mergeSort

	public static void main(String[] args) {
		int[] arr = { 6, 3, 1, 9, 2, 11, 5, 8, 4, 7, 10 };
		int[] arr2 = { 6, 3, 1, 9, 2, 11, 5, 8, 4, 7, 10 };
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));// 使用快速排序法
		Arrays.sort(arr2);
		System.out.println("arr2=" + Arrays.toString(arr2));
	}
}
