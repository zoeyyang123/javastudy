package com.spider.news.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.common.collect.Maps;
import com.spider.news.entity.NewsBasic;
import org.springframework.stereotype.Component;
import java.util.Map;
import static com.spider.news.autorun.Spider.allNews;


@Path("/news")
@Component
public class NewsController {



	@GET
	@Path("/list")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response list(){

		Map<String,Object> response = Maps.newHashMap();

		for (int i = 0; i < 5 ; i++) {
			System.out.println(allNews.get("news_bigdata"+i));
			response.put("news_bigdata"+i,((NewsBasic)allNews.get("news_bigdata"+i)).getTitle());
			response.put("news_ai"+i,((NewsBasic)allNews.get("news_ai"+i)).getTitle());
			response.put("news_other"+i,((NewsBasic)allNews.get("news_other"+i)).getTitle());
			response.put("news_blockchain"+i,((NewsBasic)allNews.get("news_blockchain"+i)).getTitle());
		}

		return Response.status(Response.Status.OK).entity(response).build();
	}

	@POST
	@Path("/search/{newsType}/{num}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@PathParam("newsType")  String newsType,@PathParam("num")  int num){
		System.out.println(newsType);
		Map<String,Object> response = Maps.newHashMap();

		NewsBasic news = (NewsBasic)allNews.get(newsType+num);
		response.put("url",news.getUrl());
		response.put("title",news.getTitle());
		response.put("source",news.getSource());
		response.put("content",news.getContent());

		return Response.status(Response.Status.OK).entity(response).build();
	}
}
