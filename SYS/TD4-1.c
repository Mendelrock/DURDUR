#include <stdio.h>
#include <stdlib.h> /* pour exit */
#include <sys/types.h>
#include <sys/socket.h>
#include <errno.h>

int main() {
	int sock;
	
	// Creation de la socket de communication
	sock = socket(AF_INET, SOCK_STREAM, 0); /* 0 indique que l’on utilisera le protocole associe par defaut a SOCK_STREAM soit TCP */
	if(sock < 0) {
		perror("socket");
		exit(-1);
	}
	printf("Socket creee avec succes ! (%d)\n", sock);
	// On ferme la socket avant de quitter
	close(sock);
	return(EXIT_SUCCESS);
}
