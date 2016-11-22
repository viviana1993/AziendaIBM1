package it.alfasoft.viviana.main;

import it.alfasoft.viviana.bean.BustaPaga;

import java.util.List;

import ServizioAzienda.ServizioAzienda;

public class TestBuste {

	public static void main(String[] args) {
		ServizioAzienda s=new ServizioAzienda();
		List<BustaPaga> buste=s.getAllBuste();
	
		
		for(BustaPaga b:buste){
			System.out.println(b.getCodiceBusta()+" "+b.getImporto());
		}


	}

}
