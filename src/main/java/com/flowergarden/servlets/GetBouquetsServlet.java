package com.flowergarden.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flowergarden.bouquet.Bouquet;
import com.flowergarden.service.BouquetsService;

public class GetBouquetsServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) 
   			throws ServletException, IOException {
			BouquetsService bouquetsService = new BouquetsService();
			List<Bouquet> bouquets = null;
			try {
				bouquets = bouquetsService.getAllBouquets();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PrintWriter writer = response.getWriter();
			Iterator<Bouquet> i = bouquets.iterator();
			while (i.hasNext()) {
				writer.println("Bouquet price: "+i.next().getPrice());
				writer.println("Bouquet contains flowers: "+i.next().getFlowers().size());
			}     	
        	
        	writer.close();
    }
}
