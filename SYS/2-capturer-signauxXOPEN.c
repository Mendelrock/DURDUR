#define _XOPEN_SOURCE 700
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <string.h>

void gestionSignal(int numsig)
{
	fprintf(stderr,"\nProcessus n°%d : signal (%d) %s reçu. Extinction...\n",getpid(),numsig,strsignal(numsig));
	exit(1);
}

int main()
{
   signal(SIGINT, gestionSignal);

   getchar();
   return(0);
}
