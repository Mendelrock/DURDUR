import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class Huffman {

	public static ArrayList<Character> transformTextFileInListChars(File f) throws FileNotFoundException{
		Scanner s = null;
		ArrayList<Character> listChars= new ArrayList<Character>();

		try {
			s = new Scanner (new BufferedReader (new FileReader (f)));

			while (s.hasNext())
			{
				String str = s.next(); 
				char[] ligne = str.toCharArray();
				for(char c:ligne){
					listChars.add(c);
				}

			}
		} finally {
			if (s != null) {
				s.close();
			}
		}
		return listChars;
	}

	public static ArrayList<Character> keepOnlyAlphaNumCharacters(ArrayList<Character> list){
		ArrayList<Character> newList = new ArrayList<Character>();
		for(Character c:list){
			if(Character.isLetter(c)){
				newList.add(Character.toLowerCase(c));
			}
		}
		return newList;
	}


	/**
	 * Cette fonction retourne un histogramme de la fréquence d'apparition d'un caractère dans le texte
	 * L'histogramme est représenté par un TreeMap où la clé est le caractère et la valeur associée est le pourcentage d'apparition du caractère dans le texte 
	 * @param args
	 * @throws IOException 
	 */
	public static TreeMap<Character,Double> buildHistogramOfCharacterFrequency(ArrayList<Character> list){
		TreeMap<Character,Double> histo = new TreeMap<Character,Double> ();

		for(Character c:list){
			if(histo.containsKey(c)){
				histo.put(c, histo.get(c)+1.0);
			}else{
				histo.put(c, 1.0);
			}
		}

		for(Character c:histo.keySet()){
			histo.put(c, (histo.get(c)/list.size())*100.0);
		}

		return histo;
	}



	/**
	 * Dessin d'un histogramme
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void plotHistogram(TreeMap<Character,Double> histo) throws IOException{

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(Character c :histo.keySet()){
			dataset.setValue(histo.get(c), "Serie1", c);
		}

		JFreeChart chart = ChartFactory.createBarChart(
				"Fréquence d'apparition des caractères",
				"Caractères",
				"% d'apparition", 
				dataset,
				PlotOrientation.VERTICAL,
				false, // generate legend?
				false, // generate tooltips?
				false); // generate url?
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		ValueAxis yAxis = plot.getRangeAxis();
		yAxis.setRange(0.0, 100.0);

		// create and display a frame...
		ChartFrame frame = new ChartFrame("DUT 2 Informatique - Shannon", chart);
		frame.pack();
		frame.setVisible(true);
	}




	public static void main(String[] args) throws IOException {
		File f=new File("Z:/MATH MOD/Huffman/src/Hamlet-Act1.txt");
		ArrayList<Character> listAllChars=transformTextFileInListChars(f);
		ArrayList<Character> listChars=keepOnlyAlphaNumCharacters(listAllChars);

		//Cette fonction retourne un histogramme de la fréquence d'apparition d'un caractère dans le texte ...
		TreeMap<Character,Double> histo=buildHistogramOfCharacterFrequency(listChars);
		//Dessin de l'histogramme ...
		plotHistogram(histo);

		HashMap<Character, String> code = new HashMap<Character, String>();

		for(Character c:histo.keySet()){
			code.put(c, "0");
			Character p = histo.firstKey();
			while(p!=c){
				System.out.println(p+" : "+histo.get(p));
				System.out.println(c+" : "+histo.get(c));
				if(histo.get(p)<histo.get(c)){
					p=histo.higherKey(p);
					code.put(c, code.get(c)+"1");
				}
				else{
					p=histo.lowerKey(p);
					code.put(c, code.get(c)+"0");
				}
			}
		}
		System.out.println(code.size());
		for(Character c:code.keySet()){
			System.out.println(c+" : "+code.get(c));
		}
	}
}