#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main (int nbarg, char *tbarg[])
{
	int  nbcarlus, tube;
	char chaine[19], lgrec ;
	
	sscanf(tbarg[1],"%d",&tube);
	
	nbcarlus= read( tube, &lgrec, 1) ;
	
	while ( nbcarlus  > 0)
	{
		nbcarlus= read( tube, chaine, lgrec);
		chaine[lgrec] = 0 ;
		printf( "\t\t\t\t\tchaine lue : %s\n",chaine);
		nbcarlus= read( tube, &lgrec, 1) ;
	}
	
	close(tube);
	printf (" \t\t\t\tje suis le recepteur, num  %d et je me termine \n", getpid());
	exit(0);
}
