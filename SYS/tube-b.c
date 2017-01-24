// programme de démonstration de l'appel pipe(2)
#include <sys/types.h>
#include <errno.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>

#define Erreur(x) 	{perror(x); exit(errno);}
#define	mod	5

// récupération d'une chaîne de car en paramètre
int main (int nbarg, char *tbarg[])

{ int  idpro, tube[2], nbcarlus , attente ;
  char chaine[19], lgmes, lgrec ;
 
 if(nbarg <= 1) { printf (" utilisation %s <suite de chaines de car> \n", tbarg[0]); exit(-1) ; }  
 srand(getpid());
 pipe(tube);
 if (( idpro= fork ()) < 0) Erreur("creation de processus");
		
 if ( idpro == 0)
	{ // le fils
	 
	 /*close(tube[1]);
	 nbcarlus= read( tube[0], &lgrec, 1) ;
	 while ( nbcarlus  > 0)
	 	{ nbcarlus= read( tube[0], chaine, lgrec);
		  chaine[lgrec] = 0 ;
		  printf( "\t\t\t\t\tchaine lue : %s\n",chaine);
		  nbcarlus= read( tube[0], &lgrec, 1) ;
		 }
		 close( tube[0]);
 	  printf (" \t\t\t\tje suis le recepteur, num  %d et je me termine \n", getpid());*/
          	
          	char descfich[3];
          	
          	close(tube[1]);
          	sprintf(descfich,"%d",tube[0]);
          	
        	if(execl("coms","coms",descfich,NULL) == -1){
			perror("exécution de coms");
			exit(errno);
		}
	}
  else { // le pere
		    int i, np, etat;
     		close (tube[0]);
		    for (i=1; i< nbarg ; i++)
		    { lgmes=strlen(tbarg[i]); write( tube[1], &lgmes, 1) ;
		      write( tube[1],tbarg[i],strlen(tbarg[i]));
		      printf( "chaine emise %d eme message : %s\n",i,tbarg[i]);
		      attente = rand() % mod ; sleep (attente);
		    }
		    close(tube[1]);
		
     		printf (" je suis l'emetteur, num  %d et je me termine \n", getpid());
		    np=wait(&etat);
		    printf (" Fin du programme\n");
 }
}
