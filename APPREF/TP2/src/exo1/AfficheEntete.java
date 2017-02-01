package exo1;

public class AfficheEntete {
	// ce programme charge une charge � partir de son nom et affiche l'entete de cette classe
	// public abstract class etc...
	// le param�trage des types n'est pas affich�
	// � faire dans une future version : idem pour chaque m�thode

	
	public static void main(String[] args) {
		// � tester avec diff�rents types de java.util
		Class <?> classe = java.util.List.class;
		
		System.out.println(enTete(classe));
	}

	private static String enTete(Class<?> classe) {
		String s = classe.toGenericString();
		if(classe.getSuperclass()!=null) s+=" extends "+classe.getSuperclass().getSimpleName();
		if(classe.getInterfaces().length>0){
			if(classe.isInterface()) s+=" extends "; else s += " implements ";
			for(Class<?> c:classe.getInterfaces()) s+=c.getSimpleName()+",";
			s=s.substring(0, s.length()-1);
		}
		return s;
	}

}
