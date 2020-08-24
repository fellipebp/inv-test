package com.example.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InvolvesTestApplication {

	public static void main(String[] args) {
		LinkedList<Integer> a = new LinkedList<Integer>();
		a.add(5);
		a.add(1);
		a.add(10);
		
		System.out.println(a);
	}


	
}


