package com.dmsdbj.team3.tools.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.Data;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Classname JacksonUtil
 * @Auther sunshinezhang
 * @Date 2019/10/5 08:47
 */
public class JacksonUtil {

	// 将Product转换成json
	@Test
	public void test1() {
		Product p = new Product();
		p.setId(1);
		p.setName("电视机");
		p.setPrice(2000);
		p.setReleaseDate(new Date());

		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		String json = null;
		try {
			json = mapper.writeValueAsString(p);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(json);
	}

    // 将List<Product>转换成json
	@Test
	public void test2(){
		Product p1 = new Product();
		p1.setId(1);
		p1.setName("电视机");
		p1.setPrice(2000);

		Product p2 = new Product();
		p2.setId(2);
		p2.setName("电冰箱");
		p2.setPrice(3000);

		List<Product> ps = new ArrayList<>();
		ps.add(p1);
		ps.add(p2);

		ObjectMapper mapper = new ObjectMapper();

		// 处理过滤属性
		//FilterProvider fp = new SimpleFilterProvider().addFilter("productFilter", SimpleBeanPropertyFilter.filterOutAllExcept("id", "name"));
		FilterProvider fp = new SimpleFilterProvider().addFilter("productFilter",
				SimpleBeanPropertyFilter.serializeAllExcept("id", "name"));
		mapper.setFilters(fp);
		String json = null;
		try {
			json = mapper.writeValueAsString(ps);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(json);
	}


	@Data
	public class Product {
		private int id;
		private String name;
		private double price;
		private Date releaseDate;
	}
}

