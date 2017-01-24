/*
 Exercice de programmation parallele
 Recherche du nombre d'occurences d'un caractere dans un texte
 On passe en parametres le nom du fichier (fichier.txt), le caractere … rechercher, le nombre de processus … lancer
*/

#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <errno.h>

#define	TBloc		1024
#define	NMaxesclave	3

// appel : rech-car fichier_a_etudier caractere_a_chercher nb_proces_esclave

int main (int nbarg, char *tbarg[]) {

  int NBEsclave;
  int idpro, df , cpt ,cptcar = 0, np[NMaxesclave], etat, NbOccu = 0;
  char Bloc[TBloc];

 if (nbarg < 4) { printf("utilisation %s fichier caractere nb_d'esclaves\n",tbarg[0]);
	exit(-1);
 }

 sscanf(tbarg[3],"%d",&NBEsclave);
 if (NBEsclave > NMaxesclave ) { printf("nb esclave trop eleve %d\n",NBEsclave );
	exit(-1);
  }
 if ((df=open(tbarg[1], O_RDONLY))< 0 )
 	{ perror ("erreur d'ouverture du fichier en parametre");
	  exit(errno);
	}
 for (cpt=1; cpt <= NBEsclave ; cpt++)
 {
 	if (( idpro= fork ()) < 0)
	{	perror("creation de processus");
		exit(errno);
	}

 	if ( idpro == 0)
	{
		char descfich[3];
		
		if(execl("rech-car-fils","rech-car-fils",descfich,tbarg[2],NULL) == -1){
			perror("exécution de rech-car-fils");
			exit(errno);
		}
	} // fin des esclaves
     }
     // le pere attend la fin des fils
     for (cpt=0; cpt < NBEsclave ; cpt++) {
        np[cpt]= wait( &etat );
	      //NbOccu= NbOccu + WEXITSTATUS(etat);
        NbOccu= NbOccu + ( etat >> 8 );
       printf(" le processus %d trouve %d %c \n",np[cpt],etat >> 8,*tbarg[2]);
       }
     printf(" le fichier %s contient %d %c \n",tbarg[1],NbOccu,*tbarg[2]);
     exit(0);
}
