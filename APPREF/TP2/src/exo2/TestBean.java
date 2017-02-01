package exo2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestBean {
// teste si une classe est un bean : public, un constructeur vide,Serializable, 
//		pas final et get/set standard pour chaque attribut
	
	public static void main(String[] args) {
		Class <?> classe = PersonBean.class;
		
		try {
			validationBean(classe);
			System.out.println("La classe "+classe.getName()+" est bien un bean conforme aux conventions");
		} catch (Exception e) {
			System.err.println(e.getMessage());;
		}
	}


	private static void validationBean(Class<?> classe) throws Exception {
		String error="";
		boolean Rammus = false;
		
		if(!classe.toGenericString().contains("public")) error+="La classe n'est pas publique.\n";
		
		for(Class<?> c:classe.getInterfaces()) if(c.toGenericString().contains("Serializable")) Rammus=true;
		
		if(!Rammus) error+="La classe n'implémente pas java.io.Serializable\n";
		
		if((classe.getConstructor()==null)||(!classe.getConstructor().toGenericString().contains("public"))) error+="Il manque un constructeur public sans argument";
		
		for(Field f:classe.getDeclaredFields()){
			Rammus = false;
			
			for(Method c:classe.getDeclaredMethods()){
				if(c.getName().toLowerCase().contains(("set"+f.getName()).toLowerCase())) Rammus=true;
			}
			
			if(!Rammus) error+="Il manque un setter pour l'attribut "+f.getName()+"\n";
			
			Rammus = false;
			
			for(Method c:classe.getDeclaredMethods()){
				if(c.getName().toLowerCase().contains(("get"+f.getName()).toLowerCase())) Rammus=true;
			}
			
			if(!Rammus) error+="Il manque un setter pour l'attribut "+f.getName()+"\n";
		}
		
		if(error.length()!=0){
			error="La classe "+classe.getSimpleName()+" ne respecte pas la norme JavaBean\n"+error;
			throw new Exception(error);
		}
	}
}
