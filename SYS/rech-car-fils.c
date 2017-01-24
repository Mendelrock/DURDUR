#include <stdlib.h>
#include <stdio.h>

#define	TBloc		1024

int main (int nbarg, char *tbarg[]) {
	
	char Bloc[TBloc];
	int nbo;
	int df, cptcar=0;

	sscanf(tbarg[1],"%d",&df);

	while ((nbo=read(df, Bloc, TBloc)) > 0)
	{ 
		int index, IMax;
		IMax = nbo;
		for (index=0; index < IMax  ; index++ )
			if ( Bloc[index] == *tbarg[2] ) 
				cptcar++ ;
		long cal; 
		for( cal=0; cal< 5000000 ;cal++);
	}
	exit ( cptcar );
}
