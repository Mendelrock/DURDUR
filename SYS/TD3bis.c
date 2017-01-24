#include <sys/types.h>
#include <sys/uio.h>
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#define Erreur(x) 	{perror(x); exit(errno);}
#define T1 		2
#define T2 		3
#define T3 		2
#define mod		255

// récupération d'une chaîne de car en paramètre
int main (int nbarg, char *tbarg[]){
	int	TubePF[2], TubeFP[2], nbfils, i, j ;
	int	mat1[T1][T2];
	int	mat2[T2][T3];
	int	result[T1][T3];
	char 	k,l;

	pipe(TubePF);
	pipe(TubeFP);
	printf("test1\n");
	for(i=0; i<T1; i++)
		for(j=0; j<T2; j++)
			mat1[i][j]=((i+1)*(j+1))%mod;

	for(i=0; i<T2; i++)
		for(j=0; j<T3; j++)
			mat2[i][j]=((i+1)*(j+1))%mod;
		
	
	if(nbarg < 2) {
		printf (" utilisation %s <NbFils> \n", tbarg[0]);
		exit(-1) ;
	}

	sscanf(tbarg[1],"%d",&nbfils);
	printf("test2\n");
	for (i =0; i < nbfils; ++i){
		pid_t fils;
		if ((fils = fork ()) < 0) Erreur("creation de processus");
		if ( fils == 0){ // le fils
			char coord[3];
			int nbcarlus;
			printf("fils créé\n");
			
			close(TubePF[1]);
			close(TubeFP[0]);
			nbcarlus = read(TubePF[0],coord,2);
			
			while(nbcarlus == 2){
				char res = 0;
				
				for(j = 0; j < T2; ++j) res += mat1[coord[0]][j]*mat2[j][coord[1]];
				
				coord[2] = res;
				write(TubeFP[1],coord,3);
				nbcarlus = read(TubePF[0],coord,2);
			}
			
			close(TubePF[0]);
			close(TubeFP[1]);
			exit(0);
		}
	}
	
	// le père
	close(TubeFP[1]);
	close(TubePF[0]);
	printf("test3\n");
	for(k = 0; k < T1; ++k){
		char buff[2];
		
	printf("test3bis\n");
		buff[0] = k;
		
		for(l = 0; l < T3; ++l){
			buff[1] = l;
	printf("test3bis\n");
				write(TubePF[1],buff,2);

		}
	}
	printf("test4\n");
	for(i = 0; i < T1*T3; ++i){
		printf("test5");
		char buff[3];
		
		read(TubeFP[0],buff,3);
		printf("res(%d,%d) = %d\n", (int)buff[0], (int)buff[1], (int)buff[2]);
		result[buff[0]][buff[1]] = buff[2];
	}
	
	close(TubePF[1]);
	close(TubeFP[0]);
	printf("\n");
	exit(0);
}
