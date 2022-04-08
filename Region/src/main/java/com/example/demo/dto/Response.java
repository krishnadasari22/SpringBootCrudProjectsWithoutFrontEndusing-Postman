package com.example.demo.dto;

import org.springframework.stereotype.Component;

@Component
public class Response {
	public int id;
	public String regionName;
	@Override
	public String toString() {
		return "Resp [id=" + id + ", regionName=" + regionName + "]";
	}

}
