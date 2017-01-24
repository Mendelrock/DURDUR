#include <stdio.h>
#include <stdlib.h> /* pour exit */
#include <string.h> /* pour memset */
#include <netinet/in.h> /* pour struct sockaddr_in */
#include <arpa/inet.h> /* pour htons et inet_aton */
#include <sys/types.h> /* pour socket */
#include <sys/socket.h>
#include <errno.h>

int main() {
	int sock;
	struct sockaddr_in adresse;
	socklen_t longueurAdresse;
	
	// Crée un socket de communication
	sock = socket(AF_INET, SOCK_STREAM, 0);
	if(sock < 0) {
		perror("socket"); // Affiche le message d’erreur
		exit(-1); // On sort en indiquant un code erreur
	}
	printf("Socket creee avec succes ! (%d)\n", sock);

	// On obtient la longueur en octets de la structure sockaddr_in
	longueurAdresse = sizeof(adresse);
	
	// On initialise à 0 la structure sockaddr_in
	memset(&adresse, 0x00, longueurAdresse);

	// Maintenant on va renseigner la structure sockaddr_in avec les informations 		du serveur distant
	adresse.sin_family = AF_INET;

	// On choisit le numéro de port d’écoute du serveur
	adresse.sin_port = htons(IPPORT_USERRESERVED);
	printf("\nNumero de port choisi est : %d \n", IPPORT_USERRESERVED);

	// On choisit l’adresse IPv4 du serveur
	inet_aton("127.0.0.1", &adresse.sin_addr); // à modifier selon ses besoins
	
	// On débute la connexion vers le processus serveur distant
	if( (connect(sock, (struct sockaddr *)&adresse, longueurAdresse) ) == -1) {
		perror("connect");
		close(sock);
		exit(-2);
	}
	printf("Connexion au serveur reussie !\n");

	// On ferme la ressource avant de quitter
	close(sock);
	return EXIT_SUCCESS;
}
