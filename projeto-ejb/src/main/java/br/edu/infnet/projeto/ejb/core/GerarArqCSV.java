package br.edu.infnet.projeto.ejb.core;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;


public class GerarArqCSV {
	
	public GerarArqCSV() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Boolean criaCSVFile(String nomeArq, List<String> lstObj){

		String linha;
		
	    try{

	        BufferedWriter StrW = new BufferedWriter(new FileWriter(nomeArq));
	        System.out.println("Lista:" + lstObj.size());
	        Iterator<String> itera = lstObj.iterator();
			while (itera.hasNext()) { 
				linha = itera.next();
				if (!linha.isEmpty()) {
					if (linha != null) {
						StrW.write(linha);
						StrW.newLine();						
					}
				}				
			}	        
	        StrW.close();
	        return true;
	    } catch (FileNotFoundException ex) {
	        ex.printStackTrace();
	        return false;
	    }catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

}
