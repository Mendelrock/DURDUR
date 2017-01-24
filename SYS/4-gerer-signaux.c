#define GNU SOURCE
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <string.h>

void gestionSignal(int numsig)
{
	fprintf(stderr,"\nProcessus n°%d : signal (%d) %s capturé.\n",getpid(),numsig,strsignal(numsig));
	exit(0);
}

int main()
{
	fprintf(stderr,"\nProcessus n°%d",getpid());
	int i;
	struct sigaction action;
	sigset_t ensemble;
	
	action.sa_handler = gestionSignal;
	sigfillset(& (action.sa_mask));
	action.sa_flags=0;
	
	for(i=1; i < NSIG; i++) sigaction(i, &action, NULL);
	
	while(1){}
	return(EXIT_SUCCESS);
}
