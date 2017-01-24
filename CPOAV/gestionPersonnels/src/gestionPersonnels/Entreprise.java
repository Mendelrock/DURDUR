package gestionPersonnels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class Entreprise {
	private HashMap<String,ArrayList<IEmploy�>> techniciens;
	
	public Entreprise(){
		techniciens = new HashMap<String,ArrayList<IEmploy�>>();
	}
	
	public void embaucher(IEmploy� e) {
		if( techniciens.containsKey( e.getClass().getSimpleName() ) ) techniciens.get(e.getClass().getSimpleName()).add(e);
		else techniciens.put( e.getClass().getSimpleName(), new ArrayList<IEmploy�>( Arrays.asList(e) ) );
	}

	public IEmploy� chercher(String string) {
		for(Entry<String, ArrayList<IEmploy�>> l : techniciens.entrySet())
			for(IEmploy� t : l.getValue())
				if(t.getNom().equals(string)) return t;
		return null;
	}

	public Double getSalaire(String string) {
		try	{return chercher(string).getSalaire();}
		catch (NullPointerException e){return null;}
	}

	public Integer getAbsences(String string) {
		try	{return chercher(string).getAbsences();}
		catch (NullPointerException e){return null;}
	}

	public void setAbsences(String string, int i) {
		try{
			chercher(string).setAbsences(i);
		}
		catch (NullPointerException e){}
	}
	
	public String toString(){
		String s = "";
		for(Entry<String, ArrayList<IEmploy�>> l : techniciens.entrySet()){
			s+=l.getKey()+" :\n\n";
			for(IEmploy� t : l.getValue())
				s+=t.getNom()+" - Salaire: "+t.getSalaire()+"� | Absences: "+t.getAbsences()+"\n";
			s+="\n";
		}	
		return s;
	}
}
